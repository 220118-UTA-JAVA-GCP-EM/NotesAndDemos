package com.example.subscriber;

import com.example.config.MessagingConfig;
import com.example.models.Person;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PersonSubscriber {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void cosumeMessageFromQueue(Person p){
        System.out.println("New person from queue: " + p.toString());
    }

}
