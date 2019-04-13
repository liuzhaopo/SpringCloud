package com.lzhpo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：</p>
 */
@SpringBootApplication
@EnableEurekaServer //标识一个Eureka Server服务注册中心
public class EurekaServer_6001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_6001.class,args);
    }
}
