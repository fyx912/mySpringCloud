package com; /**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ApplicationClient
 * Author:   THINK
 * Date:     2019/3/20 16:32
 * Description: eureka client 服务提供方
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 〈一句话功能简述〉<br> 
 * 〈eureka client 服务提供方er〉
 *  本程序和eureka client 一样，用于实现负载均衡，已经熔断
 *
 * @author THINK
 * @create 2019/3/20
 * @since 1.0.0
 */
@EnableEurekaClient
@SpringBootApplication
public class ApplicationEurekaClientTwo {
    public static void main(String[] args){
        SpringApplication.run(ApplicationEurekaClientTwo.class,args);
    }
}
