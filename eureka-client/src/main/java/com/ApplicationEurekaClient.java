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
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 〈一句话功能简述〉<br> 
 * 〈eureka client 服务提供方〉
 *
 * @author THINK
 * @create 2019/3/20
 * @since 1.0.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationEurekaClient {

    public static void main(String[] args){
        SpringApplication.run(ApplicationEurekaClient.class,args);
    }
}
