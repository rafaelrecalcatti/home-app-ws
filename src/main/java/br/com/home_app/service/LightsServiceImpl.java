package br.com.home_app.service;


import br.com.home_app.domain.Lights;
import br.com.home_app.dto.LightDto;
import br.com.home_app.dto.LightsDto;
import br.com.home_app.repository.LightRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


@Service
@Slf4j
public class LightsServiceImpl implements LightsService {

    @Autowired
    private LightRepository lightRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Boolean saveLights(LightsDto lightsDto) {
        try {
            LightsDto lightsDtoDB = findLigths(lightsDto.getSerie());
            for (LightDto lightDto : lightsDto.getLights()) {
                if (lightDto.getStatus().equals(1)) {
                    LightDto l = lightsDtoDB.getLights().stream().filter(lightDto1 -> lightDto1.getNumber().equals(lightDto.getNumber())).findAny().get();
                    if (l.getDateTimeOn() == 0 && l.getStatus() == 0)
                        lightDto.setDateTimeOn(Timestamp.valueOf(LocalDateTime.now()).getTime());
                } else {
                    LightDto l = lightsDtoDB.getLights().stream().filter(lightDto1 -> lightDto1.getNumber().equals(lightDto.getNumber())).findAny().get();
                    if (l.getDateTimeOff() == 0 && l.getStatus() == 1)
                        lightDto.setDateTimeOff(Timestamp.valueOf(LocalDateTime.now()).getTime());
                    if (lightDto.getDateTimeOn() != 0 && lightDto.getDateTimeOff() != 0) {
                        Long actualUsageTime = lightDto.getDateTimeOff() - lightDto.getDateTimeOn();
                        Long usageTime = TimeUnit.MILLISECONDS.toMinutes(actualUsageTime);
                        lightDto.setUsageTime(lightDto.getUsageTime() + usageTime);
                        lightDto.setDateTimeOn(0L);
                        lightDto.setDateTimeOff(0L);
                    }
                }

            }

            lightRepository.save(modelMapper.map(lightsDto, Lights.class));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public LightsDto findLigths(String serie) {
        return modelMapper.map(lightRepository.findBySerie(serie), LightsDto.class);
    }
}
