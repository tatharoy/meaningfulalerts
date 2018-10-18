package com.davita.hackathon2018.meaningfulalerts.controller;

import com.davita.hackathon2018.meaningfulalerts.mongo.entity.ClinicalAlert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

    @GetMapping
    public Mono<String> createCustomer() {
        System.out.println("inside Hello Customer: ");
        return Mono.just("Hello World");
    }
}
