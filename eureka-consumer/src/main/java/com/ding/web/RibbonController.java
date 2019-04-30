package com.ding.web;

import com.ding.service.RibbonHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    /**
     * RestTemplate是Spring提供的用于访问Rest服务的客户端，
     *
     * RestTemplate提供了多种便捷访问远程Http服务的方法,能够大大提高客户端的编写效率。
     *
     * 调用RestTemplate的默认构造函数，RestTemplate对象在底层通过使用java.net包下的实现创建HTTP 请求，
     *
     * 可以通过使用ClientHttpRequestFactory指定不同的HTTP请求方式。
     *
     * ClientHttpRequestFactory接口主要提供了两种实现方式
     *
     * 1、一种是SimpleClientHttpRequestFactory，使用J2SE提供的方式（既java.net包提供的方式）创建底层的Http请求连接。
     *
     * 2、一种方式是使用HttpComponentsClientHttpRequestFactory方式，底层使用HttpClient访问远程的Http服务，使用HttpClient可以配置连接池和证书等信息。
     *
     * RestTemplate对象是在RunApp中声明并创建的，用它才可以实现负载均衡，同时注意url中的地址为VIP虚拟IP，为application.yml中配置的application-name。
     * */
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private  RibbonHelloService ribbonHelloService;

    @RequestMapping("hello/{name}")
    public String hello(@PathVariable(value = "name") String name){
        String msg = ribbonHelloService.helloService(name);
        System.out.println(msg);
       return  msg;
    }



    @RequestMapping("test")
    public String test(){
        String url = "http://eureka-client/test" ;
        String msg = restTemplate.getForObject(url,String.class);
        System.out.println("获取client 信息 :"+msg);
        return msg;
    }

    @RequestMapping("zuul/{name}")
    public String zuul(@PathVariable String name){
        String url = "http://SERVICE-ZUUL/api-a/hello/"+name+"?token=22" ;
        String msg = restTemplate.getForObject(url,String.class);
        System.out.println("获取client 信息 :"+msg);
        return msg;
    }

}
