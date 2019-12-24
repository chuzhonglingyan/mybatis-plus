package com.yuntian.mybatisplus;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@NacosPropertySource(dataId = "redis", groupId= "yun_shop",  autoRefreshed = true)
@SpringBootApplication
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }

}
