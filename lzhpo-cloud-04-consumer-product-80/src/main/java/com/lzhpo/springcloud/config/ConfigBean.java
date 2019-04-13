package com.lzhpo.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：</p>
 */
@Configuration  //标识为一个配置类
public class ConfigBean {

    /**
     * 可使用 服务名称 替代真实IP地址。服务名称 就是服务提供者在application.yml中配置的spring.application.name属性的值。
     * @return
     */
    @Bean   // 向容器中添加 RestTemplate 组件,直接通过此组件可调用 REST 接口
    @LoadBalanced   //开启Ribbon负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
