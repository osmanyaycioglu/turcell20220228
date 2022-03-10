package com.training.spring.integration.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.spring.employee.management.models.Employee;
import com.training.spring.order.management.Order;

@Service
public class OrderIntService {

    @Autowired
    private RestTemplate        restTemplate;

    @Autowired
    private EurekaClient        eurekaClient;

    @Autowired
    private IOrderMSIntegration oms;

    @Scheduled(initialDelay = 1_000, fixedDelay = 30_000)
    public void name() {
        Application applicationLoc = this.eurekaClient.getApplication("ORDER");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println("IP : " + instanceInfoLoc.getIPAddr() + " port : " + instanceInfoLoc.getPort());
        }
    }

    public String placeOrder(final Employee employeeParam,
                             final String type,
                             final Integer amount) {
        Order orderLoc = new Order();
        orderLoc.setEmployeeId(employeeParam.getEmpId());
        orderLoc.setAmount(amount);
        orderLoc.setType(type);
        return this.oms.place(orderLoc);
    }

    public String placeOrder2(final Employee employeeParam,
                              final String type,
                              final Integer amount) {
        Order orderLoc = new Order();
        orderLoc.setEmployeeId(employeeParam.getEmpId());
        orderLoc.setAmount(amount);
        orderLoc.setType(type);
        String resultLoc = this.restTemplate.postForObject("http://APIGATEWAY-BACKOFFICE/api/v1/order/management/place",
                                                           orderLoc,
                                                           String.class);
        return resultLoc;
    }

    public String placeOrder3(final Employee employeeParam,
                              final String type,
                              final Integer amount) {
        Application applicationLoc = this.eurekaClient.getApplication("ORDER");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        InstanceInfo instanceInfoLoc = instancesLoc.get(0);
        Order orderLoc = new Order();
        orderLoc.setEmployeeId(employeeParam.getEmpId());
        orderLoc.setAmount(amount);
        orderLoc.setType(type);
        RestTemplate restTemplateLoc = new RestTemplate();
        String resultLoc = restTemplateLoc.postForObject("http://"
                                                         + instanceInfoLoc.getIPAddr()
                                                         + ":"
                                                         + instanceInfoLoc.getPort()
                                                         + "/api/v1/order/management/place",
                                                         orderLoc,
                                                         String.class);
        return resultLoc;
    }

}
