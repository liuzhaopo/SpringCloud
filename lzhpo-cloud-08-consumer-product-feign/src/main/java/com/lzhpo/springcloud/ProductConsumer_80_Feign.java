package com.lzhpo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：</p>
 */
@SpringBootApplication
@EnableEurekaClient //向服务注册中心进行注册
@EnableFeignClients(basePackages = "com.lzhpo.springcloud.service") //会扫描标记了指定包下@FeignClient注解的接口，并生成此接口的代理对象
public class ProductConsumer_80_Feign {
    public static void main(String[] args) {
        SpringApplication.run(ProductConsumer_80_Feign.class,args);
    }
}
