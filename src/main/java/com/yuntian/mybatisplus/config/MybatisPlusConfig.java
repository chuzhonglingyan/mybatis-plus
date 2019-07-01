package com.yuntian.mybatisplus.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.yuntian.mybatisplus.config.addmethod.LogicDeleteByIdWithFill;
import com.yuntian.mybatisplus.config.addmethod.LogicDeleteByIdsWithFill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import java.util.List;

/**
 * @Auther: yuntian
 * @Date: 2019/6/25 0025 21:04
 * @Description: 数据库操作
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.yuntian.mybatisplus.*.mapper*")
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public ISqlInjector logicSqlInjector() {
        return new DefaultSqlInjector() {
            /**
             * 注入自定义全局方法
             */
            @Override
            public List<AbstractMethod> getMethodList() {
                List<AbstractMethod> methodList = super.getMethodList();
                methodList.add(new LogicDeleteByIdWithFill());
                methodList.add(new LogicDeleteByIdsWithFill());
                return methodList;
            }
        };
    }


}

