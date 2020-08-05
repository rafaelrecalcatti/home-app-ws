package br.com.upbusiness.light_switch.controller;


import br.com.upbusiness.light_switch.dto.LightDto;
import br.com.upbusiness.light_switch.service.LightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@Validated
public class LightController {

    @Autowired
    private LightService lightService;

    @ResponseStatus(code = HttpStatus.FOUND)
    @RequestMapping(value = "/light/{number}", method = RequestMethod.GET)
    ResponseEntity<LightDto> get(@PathVariable String number) {

        ResponseEntity responseEntity = null;
        LightDto lightDto = lightService.findStatus(number);

        if (Objects.nonNull(lightDto)) {
            responseEntity = ResponseEntity.status(HttpStatus.FOUND).body(lightDto);
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao buscar status da lampada.");
        }
        return responseEntity;
    }


    @PostMapping(value = "/light/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<LightDto> save(@RequestBody LightDto lightDto) {

        ResponseEntity responseEntity = null;
        LightDto lightDtoResponse = lightService.saveStatus(lightDto);

        if (Objects.nonNull(lightDtoResponse)) {
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(lightDtoResponse);
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao salavar sattus lampada");
        }
        return responseEntity;
    }

}
