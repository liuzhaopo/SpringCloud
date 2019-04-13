package com.lzhpo.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：</p>
 */
@SpringBootApplication
@MapperScan("com.lzhpo.springcloud.mapper")
@EnableEurekaClient    //本服务启动后会自动注册进Eureka中心
public class ProductProvider_Config_8001 {
    public static void main(String[] args) {
        SpringApplication.run(ProductProvider_Config_8001.class,args);
    }
}
