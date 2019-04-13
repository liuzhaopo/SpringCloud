package com.lzhpo.springcloud.controller;

import com.lzhpo.pojo.Product;
import com.lzhpo.springcloud.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：
 * 功能测试：
 * http://localhost:8001/product/get/3
 * http://localhost:8001/product/list
 * </p>
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product) {
        return productService.add(product);
    }

    /**
     * 当get方法出现异常时，则会调用getFallback方法处理。
     *
     * 测试：http://localhost/consumer/product/get/-9
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "getFallback")
    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) {
        Product product = productService.get(id);
        //模拟异常
        if (product == null){
            throw new RuntimeException("ID=" + id + "无效");
        }
        return product;
    }

    /**当get方法出现异常时，则会调用此方法. 注意此方法的返回值，参数列表与原方法一致。所以在Product要有相应的构造器**/
    public Product getFallback(@PathVariable("id") Long id){
        return new Product(id,"ID=" + id + "无效--@HystrixCommand","无有效的数据库");
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> list() {
        return productService.list();
    }



}
