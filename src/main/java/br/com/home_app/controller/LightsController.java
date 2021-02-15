package br.com.home_app.controller;


import br.com.home_app.util.*;
import br.com.home_app.dto.LightsDto;
import br.com.home_app.service.LightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
public class LightsController {

    @Autowired
    private LightsService lightsService;

    @ResponseStatus(code = HttpStatus.FOUND)
    @RequestMapping(value = "/lights/{serie}", method = RequestMethod.GET)
    ResponseEntity<LightsDto> get(@PathVariable String serie) {

        ResponseEntity responseEntity = null;
        LightsDto lights = lightsService.findLigths(serie);

        if (Objects.nonNull(lights)) {
            responseEntity = ResponseEntity.status(HttpStatus.FOUND).body(lights);
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao buscar info das lampadas.");
        }
        return responseEntity;
    }

    @PostMapping(value = "/lights")
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<LightsDto> post(@RequestBody LightsDto lightsDto) {

        ResponseEntity responseEntity = null;

        if (Objects.isNull(lightsDto.getToken()))
            lightsDto.setToken(Utils.tokenGenerator());

        Boolean b = lightsService.saveLights(lightsDto);

        if (Objects.nonNull(b)) {
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(b);
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao salvar info lampadas");
        }
        return responseEntity;
    }

}
