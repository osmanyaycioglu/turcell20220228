package com.training.spring.integration.order;

import org.springframework.cloud.openfeign.FeignClient;

import com.training.spring.order.management.IOrderManagementController;


@FeignClient("ORDER")
public interface IOrderMSIntegration extends IOrderManagementController {

}
