package com.lzhpo.springcloud.controller;

import com.lzhpo.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
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
 * </p>
 */
@RestController
public class ProductController_Consumer {

    /**未开启Ribbon负载均衡**/
    //lzhpo-cloud-03-provider-product-8001 接口地址
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    /**开启Ribbon负载均衡之后**/
    //修改为Eureka注册中心的lzhpo-cloud-03-provider-product-8001服务名称（也就是spring.application.name属性值）
    private static final String REST_URL_PREFIX = "http://lzhpo-product";

    /**
     * spring Cloud 使用 RESTful API 实现服务之间通信
     * Dubbo 使用 RPC （远程过程调用） 实现服务之间通信
     */
    //通过RestTemplate模板远程调用
    @Autowired
    private RestTemplate restTemplate;

    /**
     * REST_URL_PREFIX + "/product/add", product, Boolean.class
     * product：传入值
     * Boolean.class：返回值类型
     *
     * postForObject（post方式）：@RequestMapping(value = "/product/add", method = RequestMethod.POST)
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "/consumer/product/add")
    public Boolean add(Product product) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/product/add", product, Boolean.class);
    }

    /**
     * REST_URL_PREFIX + "/product/get/" + id, Product.class
     * 特别注意这里是/product/get/，不是/product/get，一定要有斜杆。
     * 如果没有斜杆的话，加入id为1，拼接的就是/product/get1，而不是/product/get/1。
     *
     * getForObject（get方式）：看com.lzhpo.springcloud.controller.ProductController
     *                  -@RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/consumer/product/get/{id}")
    public Product get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/product/get/" + id, Product.class);
    }

    /**
     * getForObject（get方式）：@RequestMapping(value = "/product/list", method = RequestMethod.GET)
     * @return
     */
    @RequestMapping(value = "/consumer/product/list")
    public List<Product> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/product/list", List.class);
    }
}
