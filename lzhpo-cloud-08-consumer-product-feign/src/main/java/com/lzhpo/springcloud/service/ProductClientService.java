package com.lzhpo.springcloud.service;

import com.lzhpo.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：
 * 只要在已存在的 ProductClientService 接口上的 @FeignClient 注解中，加上 fallback 指定熔断处理类即可： ProductClientServiceFallBack.class。
 *
 * value = "lzhpo-product"：服务提供者的spring.application.name属性值。
 * fallback = ProductClientServiceFallBack.class：发生错误的回调。
 * </p>
 */
@FeignClient(value = "lzhpo-product",fallback = ProductClientServiceFallBack.class)
public interface ProductClientService {

    /**
     * 一开始粗心大意，写成这样子Product get(Long id);
     * 漏掉了@PathVariable("id")，
     * 报错：java.net.URISyntaxException: Illegal character in path at index 33: http://lzhpo-product/product/get/{id}
     *
     * 模拟服务垄断，测试Feign的服务垄断机制：
     * 访问不存在的（http://localhost/consumer/product/get/-1）或者将Provider_Product_8001停掉。
     * @param id
     * @return
     */
    @RequestMapping(value = "/product/get/{id}",method = RequestMethod.GET)
    Product get(@PathVariable("id") Long id);

    @RequestMapping(value = "/product/list",method = RequestMethod.GET)
    List<Product> list();

    @RequestMapping(value = "/product/add",method = RequestMethod.POST)
    boolean add(Product product);
}
