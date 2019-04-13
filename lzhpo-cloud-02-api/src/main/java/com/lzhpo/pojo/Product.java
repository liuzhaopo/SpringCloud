package com.lzhpo.pojo;

import java.io.Serializable;

/**
 * <p> Author：lzhpo </p>
 * <p> Title：</p>
 * <p> Description：</p>
 */
public class Product implements Serializable {  //必须实现序列化接口，因为后面要实现远程调用
    private Long pid; //主键
    private String productName; //产品名称
    // 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
    private String dbSource;

    public Product(String productName) {
        this.productName = productName;
    }
    public Product(Long pid, String productName, String dbSource) {
        this.pid = pid;
        this.productName = productName;
        this.dbSource = dbSource;
    }
    public Product() {
    }
    public Long getPid() {
        return pid;
    }
    public void setPid(Long pid) {
        this.pid = pid;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getDbSource() {
        return dbSource;
    }
    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }
}
