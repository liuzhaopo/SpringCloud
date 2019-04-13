DROP DATABASE IF EXISTS springcloud_db01;
CREATE DATABASE springcloud_db01 CHARACTER SET UTF8;
USE springcloud_db01;
CREATE TABLE product
(
pid BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
product_name VARCHAR(50),
db_source VARCHAR(50)
);
/**
  * DATABASE()：数据库名称。
  */
INSERT INTO product(product_name,db_source) VALUES('格力空调',DATABASE());
INSERT INTO product(product_name,db_source) VALUES('海尔冰箱',DATABASE());
INSERT INTO product(product_name,db_source) VALUES('小短裙',DATABASE());
INSERT INTO product(product_name,db_source) VALUES('羽绒服',DATABASE());
INSERT INTO product(product_name,db_source) VALUES('韩版休闲鞋',DATABASE());
INSERT INTO product(product_name,db_source) VALUES('高贵鞋',DATABASE());

SELECT * FROM product;