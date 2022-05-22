package com.atguigu.gulimall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
* 如何实现将服务注册到注册中心
* 1.配置依赖nacos服务发现
* 2.配置ymlnacos注册中心的地址以及当前服务的名字
* 3.开启客户端服务发现注解@EnableDiscoveryClient
*
*如何使用nacos作为配置中心统一管理配置
* 1）引入依赖
*       <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
* 2）创建一个bootstrap.properties ----配置的地址及该服务的名字
*   spring.application.name=gulimall-coupon    当前应用服务的名字
    spring.cloud.nacos.config.server-addr=127.0.0.1:8848
* 3）需要给配置中心默认添加一个叫数据集DataId  gulimall-coupon.properties默认规则  应用名.properties
* 4)给应用名.properties添加任何配置
* 5）动态获取配置
* @RefreshScope  动态获取并刷新配置
* @Value  获取到配置
* 如果配置中心和当前应用的配置文件中都配置了相同的项，优先使用配置中心的配置
*
* 2、细节
* 1）命名空间，配置隔离
* 默认public ，默认新增的所有配置都在public空间
* 1.开发。测试。生产利用命名空间来做隔离
* 2.每一个微服务之间互相隔离配置，每一个微服务都创建自己的命名空间，只加载自己命名空间下的所有配置
* 2)配置分组
* 默认所有的配置集都属于default_group
* 1111  618   1212
*
* 每个微服务创建自己的命名空间，使用配置分组区分环境，dev test prop
*
* 每个服务的配置都可以搬运到nacos中进行配置，只需要保留一bootstrap.yml文件即可，只需要在里面
* 引入命名空间、默认配置config（dev）、ext-config（dataId、group、refreshScope）
*
* */
@EnableDiscoveryClient
@MapperScan("com.atguigu.gulimall.coupon.dao")
@SpringBootApplication
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
