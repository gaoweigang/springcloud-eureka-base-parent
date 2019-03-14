package com.gwg.springcloud.consumer;

import com.gwg.springcloud.feign.service.HelloProvider;
import com.gwg.springcloud.feign.service.IHelloRemote;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @Value("${name:高伟刚}")
    private String name;

    @Autowired
    private HelloProvider helloConsumer;

    @Autowired
    private IHelloRemote helloRemote;


    /**
     * 应用Consumer调用应用Provider的服务printServiceProvider
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        System.out.println("调用hello开始 start ****************");
        return "===>name:" + name + "<br/>" + helloConsumer.printServiceProvider(name);
    }

    @RequestMapping(value="/helloRemote", method = RequestMethod.GET)
    public String helloRemote(){
        System.out.println("调用helloRemote开始 start.......");
        return helloRemote.printServiceHello(name);
    }




}