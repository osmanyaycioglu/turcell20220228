package com.training.spring.order.management;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderManagementController {

    @Value("${server.port}")
    private int port;

    @PostMapping("/place")
    public String place(@RequestBody final Order order) {
        return "Order placed for : " + order.getEmployeeId() + " ex : " + this.port;
    }

}
