/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ConsumerApplication
 * Author:   THINK
 * Date:     2019/3/20 17:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Eureka服务 消费方〉
 *
 * @author THINK
 * @create 2019/3/20
 * @since 1.0.0
 */
// 注解用来将当前应用加入到服务治理体系中。
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args){
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
