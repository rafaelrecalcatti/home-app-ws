package br.com.upbusiness.light_switch.controller;


import br.com.upbusiness.light_switch.dto.LightDto;
import br.com.upbusiness.light_switch.service.LightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@Validated
public class LightController {

    @Autowired
    private LightService lightService;

    @ResponseStatus(code = HttpStatus.FOUND)
    @RequestMapping(value = "/light/all", method = RequestMethod.GET)
    ResponseEntity<List<LightDto>> get() {

        ResponseEntity responseEntity = null;
        List<LightDto> lightDtoList = lightService.findAll();

        if (Objects.nonNull(lightDtoList)) {
            responseEntity = ResponseEntity.status(HttpStatus.FOUND).body(lightDtoList);
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao buscar status da lampada.");
        }
        return responseEntity;
    }


    @PostMapping(value = "/light")
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<LightDto> post(@RequestBody List<LightDto> lightDtoList) {

        ResponseEntity responseEntity = null;
        Boolean b = lightService.saveStatus(lightDtoList);

        if (Objects.nonNull(b)) {
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(b);
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao salavar sattus lampada");
        }
        return responseEntity;
    }

}
