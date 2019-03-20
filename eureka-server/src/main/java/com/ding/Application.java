/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Application
 * Author:   THINK
 * Date:     2019/3/20 15:48
 * Description: Eureka 服务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Eureka 服务 注册中心〉
 *
 * @author THINK
 * @create 2019/3/20
 * @since 1.0.0
 */
@EnableEurekaServer
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
