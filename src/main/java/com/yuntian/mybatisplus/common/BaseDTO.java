package com.yuntian.mybatisplus.common;

import java.util.Date;

import lombok.Data;

/**
 * @Auther: yuntian
 * @Date: 2019/6/25 0025 22:42
 * @Description:
 */
@Data
public class BaseDTO {

    /**
     * 每页显示条数，默认 10
     */
    private long size = 10;
    /**
     * 当前页
     */
    private long current = 1;


    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private Long updateId;

    /**
     * 更新时间
     */
    private Date updateTime;


}
