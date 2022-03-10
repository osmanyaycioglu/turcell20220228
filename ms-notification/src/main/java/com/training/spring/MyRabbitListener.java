package com.training.spring;

import java.time.LocalDateTime;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "sms-notify-queue",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-exchange",
                                                                  type = ExchangeTypes.DIRECT,
                                                                  durable = "true",
                                                                  autoDelete = "false"),
                                             key = "notify.sms"))
    public void handleSMSMessage(final NotifyMessage message) {
        System.out.println("Got SMS message : " + message);

    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "email-notify-queue",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-exchange",
                                                                  type = ExchangeTypes.DIRECT,
                                                                  durable = "true",
                                                                  autoDelete = "false"),
                                             key = "notify.email"))
    public void handleEmailMessage(final NotifyMessage message) {
        System.out.println("Got EMAIL message : " + message);
    }


    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "sms-topic-queue",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-topic-exchange",
                                                                  type = ExchangeTypes.TOPIC,
                                                                  durable = "true",
                                                                  autoDelete = "false"),
                                             key = "message.sms.europe.turkey.#"))
    public void handleETMSMessage(final NotifyMessage message) {
        System.out.println("Got europe.turkey message : " + message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "all-topic-queue",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-topic-exchange",
                                                                  type = ExchangeTypes.TOPIC,
                                                                  durable = "true",
                                                                  autoDelete = "false"),
                                             key = "message.#"))
    @SendTo("message-reply-exchange/reply.notify.sms")
    public String handleALLMessages(final NotifyMessage message) {
        System.out.println("Got ALL message : " + message);
        return "Message : "
               + message
               + " processed"
               + LocalDateTime.now()
                              .toString();
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "sms-allturkey-queue",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-topic-exchange",
                                                                  type = ExchangeTypes.TOPIC,
                                                                  durable = "true",
                                                                  autoDelete = "false"),
                                             key = "message.sms.*.turkey.#"))
    public void handleALLTurkeyMessages(final NotifyMessage message) {
        System.out.println("Got ALL Turkey message : " + message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "sms-asia-queue",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-topic-exchange",
                                                                  type = ExchangeTypes.TOPIC,
                                                                  durable = "true",
                                                                  autoDelete = "false"),
                                             key = "message.sms.asia.turkey.#"))
    public void handleETMessages(final NotifyMessage message) {
        System.out.println("Got Asia Turkey message : " + message);
    }

}
