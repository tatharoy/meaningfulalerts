package com.davita.hackathon2018.meaningfulalerts.controller;

import com.davita.hackathon2018.meaningfulalerts.mongo.entity.ClinicalAlert;
import com.davita.hackathon2018.meaningfulalerts.repository.ReactiveClinicalAlertRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.Duration;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api")
public class ClinicalAlertController implements InitializingBean {

    @Autowired
    ReactiveClinicalAlertRepository clinicalAlertRepository;

    @Autowired
    ReactiveMongoOperations operations;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/alerts", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ClinicalAlert> getAllAlerts(@RequestParam(value = "physicianId") final Long physicianId) {
        System.out.println("Get all Alerts...");

        return clinicalAlertRepository.findByPhysicianId(physicianId).log().delayElements(Duration.ofMillis(500));

    }

    @PostMapping("/alerts/create")
    public Mono<ClinicalAlert> createCustomer(@Valid @RequestBody ClinicalAlert clinicalAlert) {
        System.out.println("Create Customer: " + clinicalAlert.getAlertName() + "...");
        clinicalAlert.setId(UUID.randomUUID().toString());


        return clinicalAlertRepository.save(clinicalAlert);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after properties set called");
        System.out.println(" collection exists : "+operations.collectionExists(ClinicalAlert.class).block());
		/*operations.createCollection("newcustomer", CollectionOptions.empty() //
				.size(2048) //
				.maxDocuments(200) //
				.capped());
		System.out.println(" collection exists : "+operations.collectionExists("newcustomer").block());*/
		/*operations.collectionExists(Customer.class) //
				//.flatMap(exists -> exists ? operations.dropCollection(Customer.class) : Mono.just(exists)) //
				.then(operations.createCollection(Customer.class, CollectionOptions.empty() //
						.size(2048) //
						.maxDocuments(200) //
						.capped()));*/

    }


}
