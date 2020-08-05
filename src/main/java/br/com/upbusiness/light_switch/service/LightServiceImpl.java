package br.com.upbusiness.light_switch.service;


import br.com.upbusiness.light_switch.domain.Light;
import br.com.upbusiness.light_switch.dto.LightDto;
import br.com.upbusiness.light_switch.repository.LightRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class LightServiceImpl implements LightService {

    @Autowired
    private LightRepository lightRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public Boolean saveStatus(List<LightDto> lightDtoList) {
        try {
            lightDtoList.stream().forEach(l -> lightRepository.save(modelMapper.map(l, Light.class)));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<LightDto> findAll() {
        return lightRepository.findAll().stream().map(l -> modelMapper.map(l, LightDto.class)).collect(Collectors.toList());
    }
}
