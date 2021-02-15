package br.com.home_app.repository;

import br.com.home_app.domain.Lights;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LightRepository extends MongoRepository<Lights, String> {

    Lights findBySerie(String s);

}