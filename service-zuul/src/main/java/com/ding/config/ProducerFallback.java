package com.ding.config;

import net.minidev.json.JSONObject;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: mySpringCloud
 * @description: zuul   熔断
 * @author: tinTin
 * @create: 2019-04-30 13:50
 */
@Component
public class ProducerFallback implements FallbackProvider {

    /**
     * 返回服务id，如果需要所有调用都支持回退，则return "*"或return null
     */
    @Override
    public String getRoute() {
        return "eureka-client-two";
    }

    /**
     * 如果请求用户服务失败，返回什么信息给消费者客户端
     */
    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                // 和body中的内容编码一致，否则容易乱码
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }

            @Override
            public InputStream getBody() throws IOException {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("state", "9999");
                jsonObject.put("msg", "系统错误，请求失败,服务不可用，请稍后再试");
                return new ByteArrayInputStream(jsonObject.toJSONString().getBytes("UTF-8"));
            }

        /**
         * 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的， 不应该把api的404,500等问题抛给客户端
         * 网关和api服务集群对于客户端来说是黑盒子
         */
         @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }
        };
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return null;
    }
}
