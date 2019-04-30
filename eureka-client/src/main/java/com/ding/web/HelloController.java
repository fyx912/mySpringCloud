package com.ding.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {


    @RequestMapping("hello")
    public String hello(){
        return "hello world! ";
    }

    @RequestMapping("hello/{name}")
    public String hello(@PathVariable String name, HttpServletRequest request){
        String msg = " 获取的 name :"+name +" , request method : "+request.getMethod()+" \t, port:"+request.getServerPort();
        System.out.println(msg);
        return msg;
    }
}
