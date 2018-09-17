package com.ryan.capter3customernotification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {

    @Autowired
    CustomerRegistrar customerRegistrar;

    @PostMapping(path = "/register")
    public Mono<Customer> register (@RequestBody Customer customer) {
        return customerRegistrar.register(customer);
    }
}
