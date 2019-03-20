/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ConsulApplication
 * Author:   THINK
 * Date:     2019/3/20 16:58
 * Description: Consul 注册中心
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Consul 注册中心〉
 *
 * @author THINK
 * @create 2019/3/20
 * @since 1.0.0
 */

@SpringBootApplication
public class ConsulApplication {
    public static void main(String[] args){
        SpringApplication.run(ConsulApplication.class,args);
    }
}
