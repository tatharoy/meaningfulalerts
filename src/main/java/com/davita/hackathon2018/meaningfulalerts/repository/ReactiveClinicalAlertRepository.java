package com.davita.hackathon2018.meaningfulalerts.repository;

import com.davita.hackathon2018.meaningfulalerts.mongo.entity.ClinicalAlert;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ReactiveClinicalAlertRepository extends ReactiveCrudRepository<ClinicalAlert, String> {

    @Tailable
    Flux<ClinicalAlert> findByPhysicianId(Long physicianId);

}
