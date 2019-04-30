package com.ding.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonHelloService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 定义服务降级逻辑(serviceFallback)
     * 并且自动的实现了线程调用得依赖隔离-实现线程池的隔离，
     * 为每一个依赖服务创建一个独立的线程池，这样就算某一个依赖服务出现延迟过高
     * 的情况，也只是对该依赖服务的调用产生影响，而不会拖慢其他的服务。
     *
     * Hystrix会将请求结果放入缓存，默认缓存key既是请求参数
     */
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(String name){
        String url = "http://eureka-client/hello/"+name;
        url += "?name=Ribbon";
        return restTemplate.getForObject(url,String.class);
    }

    // 覆写fallbackMethod中指定的方法，注意，此方法的返回值，参数必须与原方法一致
    public String helloFallback(String name){
        String msg = "请求失败！you熔断返回信息。";
        System.out.println("进入熔断方法......"+name);
        return "error: "+ msg;
    }
}
