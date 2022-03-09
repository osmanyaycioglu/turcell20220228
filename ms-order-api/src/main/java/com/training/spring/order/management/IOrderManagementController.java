package com.training.spring.order.management;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface IOrderManagementController {

    @PostMapping("/api/v1/order/management/place")
    public String place(@RequestBody final Order order);

}
