package com.lzhpo.springcloud.controller;

import com.lzhpo.pojo.Product;
import com.lzhpo.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：
 * 启动Rabbitmq，再分别启动lzhpo-cloud-12-config-server-5001、lzhpo-cloud-14-eureka-config-6001、lzhpo-cloud-16-product-bus-8001
 *
 * 功能测试（修改之后post请求 http://localhost:8001/actuator/bus-refresh，刷新配置）：
 *      -先测试刷新spring.application.name：http://localhost:6001/
 *      -测试刷新emp.name：http://localhost:8001/hello
 *      -测试刷新Druid数据源配置：http://localhost:8001/product/list
 * </p>
 */
@RestController
@RefreshScope //刷新配置
public class ProductController {

    @Value("${emp.name}")
    private String name;

    @Autowired
    private ProductService productService;

    @RequestMapping("/hello")
    public String hello() {
        return name;
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product) {
        return productService.add(product);
    }

    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) {
        return productService.get(id);
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> list() {
        return productService.list();
    }

}
