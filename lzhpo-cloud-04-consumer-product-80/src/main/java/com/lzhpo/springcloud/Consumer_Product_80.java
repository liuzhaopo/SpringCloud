package com.lzhpo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：</p>
 */
@SpringBootApplication
@EnableEurekaClient //向服务注册中心进行注册
public class Consumer_Product_80 {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_Product_80.class,args);
    }
}
