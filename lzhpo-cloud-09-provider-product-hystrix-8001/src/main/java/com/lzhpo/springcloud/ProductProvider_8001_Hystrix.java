package com.lzhpo.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：</p>
 */
@SpringBootApplication
@MapperScan("com.lzhpo.springcloud.mapper")
@EnableEurekaClient    //本服务启动后会自动注册进Eureka中心
@EnableHystrix  //开启 Hystrix 熔断机制的支持
public class ProductProvider_8001_Hystrix {
    public static void main(String[] args) {
        SpringApplication.run(ProductProvider_8001_Hystrix.class,args);
    }
}
