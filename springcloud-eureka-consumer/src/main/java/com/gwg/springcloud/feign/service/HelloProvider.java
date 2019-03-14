package com.gwg.springcloud.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 从服务注册中心获取服务( 不推荐)，
 * 最佳实践：将该接口抽离到单独的模块中，然后服务提供方实现该接口的同时也能够很方便的对外提供Resful接口，而使用方均依赖该模块后就是就能使用Eureka服务
 */
@FeignClient(name = "service-provider") //注解来绑定该接口对应的service-provider服务
public interface HelloProvider {

    @RequestMapping(value = "/provider/{name}", method = RequestMethod.GET)
    public String printServiceProvider(@PathVariable("name") String name);
}