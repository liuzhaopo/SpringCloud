package com.lzhpo.springcloud.service;

import com.lzhpo.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：
 *
 * 加入容器中：@Component
 * 未加找不到报错：Caused by: java.lang.IllegalStateException: No fallback instance of type class com.lzhpo.springcloud.service.ProductClientServiceFallBack found for feign client lzhpo-product
 * </p>
 */
@Component  //加入容器中
public class ProductClientServiceFallBack implements ProductClientService{

    @Override
    public Product get(Long id) {
        return new Product(id, "id="+ id + "无数据--feign&hystrix", "无有效数据库");
    }

    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public boolean add(Product product) {
        return false;
    }
}
