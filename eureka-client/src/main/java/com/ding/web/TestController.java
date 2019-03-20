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
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈test 〉
 *
 * @author THINK
 * @create 2019/3/20
 * @since 1.0.0
 */
@RestController
public class TestController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("test")
    public String test(){
        String services = "Services: "+ discoveryClient.getServices();
        System.out.println(services);
        return  services;
    }

    @GetMapping("ding")
    public String ding(){
        String services = "Services: "+ discoveryClient.description();
        System.out.println(services);
        return  services;
    }
}
