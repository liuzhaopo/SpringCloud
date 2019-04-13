package com.lzhpo.springcloud.controller;

import com.lzhpo.pojo.Product;
import com.lzhpo.springcloud.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：Feign实战操作</p>
 * <p> Description：
 * 测试功能：
 * http://localhost/consumer/product/get/3
 * http://localhost/consumer/product/list
 * http://localhost/consumer/product/add?productName=python
 *
 *
 * 开启Ribbon负载均衡：
 *      -先测试各自是否有用：
 *              http://localhost:8001/product/list
 *              http://localhost:8002/product/list
 *      -查看Ribbon负载均衡效果
 *              http://localhost/consumer/product/list
 *              注意观察看到返回的数据库名字，各不相同，负载均衡实现。
 *
 * 使用Feign：
 *      我们要停止lzhpo-cloud-04-consumer-product-80，使用我们的新模块lzhpo-cloud-08-consumer-product-feign(Feign)来操作。
 *      注意事项：
 *          SpringCloud对Feign进行了增强兼容了SpringMVC的注解 ，我们在使用SpringMVC的注解时需要注意：
 *              1、@FeignClient接口方法有基本类型参数在参数必须加@PathVariable("XXX") 或 @RequestParam("XXX")
 *              2、@FeignClient接口方法返回值为复杂对象时，此类型必须有无参构造方法。
 * </p>
 */
@RestController
public class ProductController_Consumer {

    @Autowired
    private ProductClientService productClientService;

    @RequestMapping(value = "/consumer/product/add")
    public boolean add(Product product) {
        return productClientService.add(product);
    }

    @RequestMapping(value = "/consumer/product/get/{id}")
    public Product get(@PathVariable("id") Long id) {
        return productClientService.get(id);
    }

    @RequestMapping(value = "/consumer/product/list")
    public List<Product> list() {
        return productClientService.list();
    }

}
