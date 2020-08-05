package br.com.upbusiness.light_switch.service;

import br.com.upbusiness.light_switch.dto.LightDto;

public interface LightService {

    public abstract LightDto saveStatus(LightDto lightDto);
    public abstract Integer findStatus(Long number);

}
