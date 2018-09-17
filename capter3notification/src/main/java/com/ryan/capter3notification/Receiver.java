package com.ryan.capter3notification;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private static final String CUSTOMER_TOPIC = "CustomerQ";

    @Autowired
    Mailer mailer;

    @Bean
    Queue queue() {
        return new Queue(CUSTOMER_TOPIC, false);
    }

    @RabbitListener(queues = CUSTOMER_TOPIC)
    public void processMessage(String email) {
        System.out.println(email);
        mailer.sendMail(email);
    }
}
