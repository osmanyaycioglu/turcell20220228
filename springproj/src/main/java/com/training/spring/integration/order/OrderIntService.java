package com.training.spring.integration.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.spring.employee.management.models.Employee;
import com.training.spring.integration.order.models.Order;

@Service
public class OrderIntService {

    @Autowired
    private RestTemplate restTemplate;

    public String placeOrder(final Employee employeeParam,
                             final String type,
                             final Integer amount) {
        Order orderLoc = new Order();
        orderLoc.setEmployeeId(employeeParam.getEmpId());
        orderLoc.setAmount(amount);
        orderLoc.setType(type);
        String resultLoc = this.restTemplate.postForObject("http://ORDER/api/v1/order/management/place",
                                                           orderLoc,
                                                           String.class);
        return resultLoc;
    }

}
