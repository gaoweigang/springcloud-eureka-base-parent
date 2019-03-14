package com.gwg.springcloud.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Restful接口的一种写法
 * 在SpringCloud Eureka中，Restful接口 作为服务的提供者
 */
@RestController
public class HelloProvider {

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping(value = "/provider/{name}", method = RequestMethod.GET)
    public String printServiceProvider(@PathVariable("name") String name) {
        System.out.println("调用服务开始 start ..........");
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        return serviceInstance.getServiceId() + " (" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + ")" + "===>Say " + name;
    }
}