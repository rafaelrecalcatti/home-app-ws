package br.com.upbusiness.light_switch.repository;

import br.com.upbusiness.light_switch.domain.Light;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LightRepository extends MongoRepository<Light, String> {

    Light findByNumber(Long number);
}