package com.ryan.capter3customernotification;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Sender {

    private static final String CUSTOMER_TOPIC = "CustomerQ";

    @Autowired
    RabbitMessagingTemplate template;

    @Bean
    Queue queue() {
        return new Queue(CUSTOMER_TOPIC, false);
    }

    public void send(String message) {
        template.convertAndSend(CUSTOMER_TOPIC, message);
    }
}
