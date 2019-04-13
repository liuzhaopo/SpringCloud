package com.lzhpo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：</p>
 */
@SpringBootApplication
@EnableHystrixDashboard //开启服务监控
public class HystrixDashboard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard_9001.class,args);
    }
}
