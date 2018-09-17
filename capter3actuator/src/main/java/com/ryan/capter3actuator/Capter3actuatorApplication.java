package com.ryan.capter3actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@SpringBootApplication
public class Capter3actuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(Capter3actuatorApplication.class, args);
    }
}

@RestController
class GreetingController {

    @GetMapping("/greeting")
    public HttpEntity<Greet> greeting(@RequestParam(value = "name", required = false, defaultValue = "HATEOAS") String name) {
        Greet greet = new Greet("hello : " + name);
        greet.add(linkTo(
                methodOn(GreetingController.class)
                        .greeting(name))
                .withSelfRel()
        );

        return new ResponseEntity<>(greet, HttpStatus.OK);
    }
}

class Greet extends ResourceSupport {
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