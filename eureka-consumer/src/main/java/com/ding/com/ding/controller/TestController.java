/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestController
 * Author:   THINK
 * Date:     2019/3/20 17:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ding.com.ding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 〈一句话功能简述〉<br> 
 * 〈消费者 Controller〉
 *
 * @author THINK
 * @create 2019/3/20
 * @since 1.0.0
 */
@RestController
public class TestController {

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("consumer")
    public String consumer(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort();
        System.out.println(url);
        return  restTemplate.getForObject(url,String.class);
    }

    @GetMapping("test")
    public String test(){
        String url = "Services:"+discoveryClient.getServices();
        System.out.println(url);
        return  url;
    }
}
