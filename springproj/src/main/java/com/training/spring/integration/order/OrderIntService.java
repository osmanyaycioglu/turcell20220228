package com.training.spring.integration.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.ms.error.ErrorObj;
import com.training.ms.error.RestException;
import com.training.spring.employee.management.models.Employee;
import com.training.spring.order.management.Order;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

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

    @CircuitBreaker(name = "mycb")
    public String placeOrder(final Employee employeeParam,
                             final String type,
                             final Integer amount) {
        Order orderLoc = new Order();
        orderLoc.setEmployeeId(employeeParam.getEmpId());
        orderLoc.setAmount(amount);
        orderLoc.setType(type);
        return this.oms.place(orderLoc);
    }

    public String placexOrder(final Employee employeeParam,
                              final String type,
                              final Integer amount) {
        Order orderLoc = new Order();
        orderLoc.setEmployeeId(employeeParam.getEmpId());
        orderLoc.setAmount(amount);
        orderLoc.setType(type);
        return this.oms.placex(orderLoc);
    }


    private ErrorObj convertErrorObj(final byte[] bytes) {
        ObjectMapper mapperLoc = new ObjectMapper();
        try {
            return mapperLoc.readValue(bytes,
                                       ErrorObj.class);
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }
        return null;

    }

    public String placeOrder2(final Employee employeeParam,
                              final String type,
                              final Integer amount) {
        Order orderLoc = new Order();
        orderLoc.setEmployeeId(employeeParam.getEmpId());
        orderLoc.setAmount(amount);
        orderLoc.setType(type);
        try {
            String resultLoc = this.restTemplate.postForObject("http://APIGATEWAY-BACKOFFICE/api/v1/order/management/place",
                                                               orderLoc,
                                                               String.class);
            return resultLoc;
        } catch (HttpStatusCodeException eLoc) {
            ErrorObj convertErrorObjLoc = this.convertErrorObj(eLoc.getResponseBodyAsByteArray());
            throw new RestException(convertErrorObjLoc);
        }
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
