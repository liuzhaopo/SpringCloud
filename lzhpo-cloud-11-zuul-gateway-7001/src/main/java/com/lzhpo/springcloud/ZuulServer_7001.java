package com.lzhpo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：
 *
 * -不用路由直接访问：http://localhost:8001/product/get/1
 * -使用路由访问 (注意是 7001 端口), 当前要加上服务名：http://localhost:7001/lzhpo-product/product/get/1
 *
 * </p>
 */
@SpringBootApplication
@EnableZuulProxy    //开启zuul的功能
public class ZuulServer_7001 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServer_7001.class,args);
    }
}
