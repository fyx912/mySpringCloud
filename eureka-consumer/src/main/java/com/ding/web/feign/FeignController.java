package com.ding.web.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feign")
public class FeignController {

    @Autowired
    FeignClientService feignClientService;

    @GetMapping("/hello")
    public String hello() {
        return feignClientService.hello();
    }

}
