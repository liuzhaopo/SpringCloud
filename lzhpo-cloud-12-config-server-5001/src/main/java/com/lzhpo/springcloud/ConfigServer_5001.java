package com.lzhpo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：
 *
 * http://localhost:5001/lzhpo-config-application-dev.yml
 *
 * http://localhost:5001/lzhpo-config-application-prod.yml
 *
 * http://localhost:5001/lzhpo-config-application-test.yml
 * </p>
 */
@EnableConfigServer //开启配置中心功能
@SpringBootApplication
public class ConfigServer_5001 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_5001.class,args);
    }

}
