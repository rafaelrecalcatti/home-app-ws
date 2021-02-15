package br.com.home_app.service;

import br.com.home_app.dto.LightDto;
import br.com.home_app.dto.LightsDto;

import java.util.List;

public interface LightsService {

    public abstract Boolean saveLights(LightsDto lights);

    public abstract LightsDto findLigths(String serie);

}
