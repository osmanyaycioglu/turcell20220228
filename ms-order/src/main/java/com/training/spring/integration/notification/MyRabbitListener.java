package com.training.spring.integration.notification;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "sms-reply-queue",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-reply-exchange",
                                                                  type = ExchangeTypes.DIRECT,
                                                                  durable = "true",
                                                                  autoDelete = "false"),
                                             key = "reply.notify.sms"))
    public void handleSMSMessage(final String message) {
        System.out.println("Got Response message : " + message);
    }


}
