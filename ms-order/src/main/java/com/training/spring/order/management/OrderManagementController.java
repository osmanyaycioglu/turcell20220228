package com.training.spring.order.management;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.NotifyMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class OrderManagementController implements IOrderManagementController {

    @Value("${server.port}")
    private int            port;

    @Autowired
    private RabbitTemplate rt;

    //    "message.sms.asia.turkey.izmir.si",
    @Override
    @Operation(description = "güzel bir op", summary = "test sum")
    @ApiResponse(description = "Şu bu dönecek")
    public String place(@RequestBody final Order order) {
        String message = "Order placed for : " + order.getEmployeeId() + " ex : " + this.port;
        NotifyMessage messageLoc = new NotifyMessage();
        messageLoc.setMessage(message);
        messageLoc.setDestination("346535343");
        this.rt.convertAndSend("message-topic-exchange",
                               "message.sms.asia.turkey.izmir.si",
                               messageLoc);

        return message;
    }

}
