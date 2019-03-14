package com.gwg.springcloud.provider;

import com.gwg.springcloud.remote.IHelloRemote;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Restful接口的第二种写法,在使用Eureka时候推荐，因为这样可以将服务提供方(IHelloRemote)单独抽象到一个模块中,服务提供方和使用方仅需要依赖
 */
@RestController
public class HelloController implements IHelloRemote {

    public String printServiceHello(@PathVariable("name") String name) {
        System.out.println("姓名: " + name);
        return name;
    }

    public String info() {
        return "HelloRemote";
    }
}
