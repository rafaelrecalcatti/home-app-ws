package br.com.upbusiness.light_switch.service;

import br.com.upbusiness.light_switch.dto.LightDto;

import java.util.List;

public interface LightService {

    public Boolean saveStatus(List<LightDto> lightDtoList);

    public abstract List<LightDto> findAll();

}
