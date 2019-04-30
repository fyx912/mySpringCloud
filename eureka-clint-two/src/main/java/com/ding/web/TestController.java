/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestController
 * Author:   THINK
 * Date:     2019/3/20 16:40
 * Description: test
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ding.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈test 〉
 *
 * @author THINK
 * @create 2019/3/20
 * @since 1.0.0
 */
@RefreshScope//开启更新功能
@RestController
public class TestController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Value("${from}")
    private String fromValue;
    @Value("${profile}")
    private String profile;


    @GetMapping("test")
    public String test(HttpServletRequest request){
        String services = "Services: "+ discoveryClient.getServices();
        services +=   ",\t port from :"+ request.getServerPort();
        System.out.println(services);
        return  services;
    }

    @GetMapping("ding")
    public String ding(){
        String services = "Services: "+ discoveryClient.description();
        System.out.println(services);
        return  services;
    }

    @GetMapping("from")
    public String from(){
        return fromValue;
    }

    @GetMapping("/profile")
    public String profile(){
        System.out.println("从配置中心获取文件属性"+profile);
        return this.profile;
    }

}
