package br.com.upbusiness.light_switch.service;


import br.com.upbusiness.light_switch.domain.Light;
import br.com.upbusiness.light_switch.dto.LightDto;
import br.com.upbusiness.light_switch.repository.LightRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@Slf4j
public class LightServiceImpl implements LightService {

    @Autowired
    private LightRepository lightRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public LightDto saveStatus(LightDto lightDto) {
        Light light = lightRepository.save(modelMapper.map(lightDto, Light.class));
        return modelMapper.map(light, LightDto.class);
    }

    @Override
    public LightDto findStatus(String number) {
        return modelMapper.map(lightRepository.findByNumber(number), LightDto.class);
    }
}
