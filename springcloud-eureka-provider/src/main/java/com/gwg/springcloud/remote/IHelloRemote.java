package com.gwg.springcloud.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="service-provider")
public interface IHelloRemote {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    String printServiceHello(@PathVariable("name") String name);

    /*打印出微服务信息*/
    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public  String  info();

}
