package com.ding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableHystrixDashboard//开启dashboard，通过图形化的方式监控: 查看 http://127.0.0.1:7020/hystrix.stream
@EnableCircuitBreaker//开启断路器功能
@EnableFeignClients//采用Feign方式负载均衡
@EnableEurekaClient
@SpringBootApplication
public class ConsumerApplication {
    @Bean
    @LoadBalanced//Ribbon负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args){
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
