package com.ding.web.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client")
public interface FeignClientService {

    @GetMapping("hello")
    String hello();
}
