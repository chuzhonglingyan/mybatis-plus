package com.yuntian.mybatisplus.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.yuntian.mybatisplus.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
*
* <p>
*  测试表
* </p>
* @author yuntian
* @since 2019-06-18
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
    * 用户名字
    */
    private String userName;


    /**
    * 是否删除，0-未删除，1-删除，默认为0
    */
    @TableLogic
    private Integer isDelete;


}
