package com.ryan.capter3webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Capter3webfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(Capter3webfluxApplication.class, args);
    }
}

@RestController
class GreetingController {
    @GetMapping
    Mono<Greet> greet() {
        return Mono.just(new Greet("Hello world"));
    }
}

class Greet {
    private String message;

    public Greet() {
    }

    public Greet(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}