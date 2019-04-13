package com.lzhpo.springcloud.mapper;

import com.lzhpo.pojo.Product;

import java.util.List;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：</p>
 */
//@Mapper //或在主启动类上使用@MapperScan注解
public interface ProductMapper {

    Product findById(Long pid);

    List<Product> findAll();

    boolean addProduct(Product product);

}
