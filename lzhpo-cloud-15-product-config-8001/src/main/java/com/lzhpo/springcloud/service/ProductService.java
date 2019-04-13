package com.lzhpo.springcloud.service;

import com.lzhpo.pojo.Product;

import java.util.List;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：</p>
 */
public interface ProductService {

    boolean add(Product product);

    Product get(Long id);

    List<Product> list();

}

