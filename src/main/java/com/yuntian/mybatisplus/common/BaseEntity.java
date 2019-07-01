package com.yuntian.mybatisplus.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

import lombok.Data;

/**
 * @Auther: yuntian
 * @Date: 2019/6/18 0018 20:57
 * @Description:
 */
@Data
public class BaseEntity {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
    @TableField(value = "update_id", fill = FieldFill.UPDATE)
    private Long updateId;


    /**
     * 更新时间
     */
    private Date updateTime;


}
