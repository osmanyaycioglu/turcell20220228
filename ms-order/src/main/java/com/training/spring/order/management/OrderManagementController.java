package com.training.spring.order.management;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class OrderManagementController implements IOrderManagementController {

    @Value("${server.port}")
    private int port;

    @Override
    @Operation(description = "güzel bir op", summary = "test sum")
    @ApiResponse(description = "Şu bu dönecek")
    public String place(@RequestBody final Order order) {
        return "Order placed for : " + order.getEmployeeId() + " ex : " + this.port;
    }

}
