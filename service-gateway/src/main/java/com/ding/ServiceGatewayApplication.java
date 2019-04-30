package com.ding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: mySpringCloud
 * @description: gateway 网关服务
 * @author: tinTin
 * @create: 2019-04-30 10:02
 */
@EnableEurekaClient
@SpringBootApplication
public class ServiceGatewayApplication {

    public static void main(String[] args){
        SpringApplication.run(ServiceGatewayApplication.class,args);
    }
}
