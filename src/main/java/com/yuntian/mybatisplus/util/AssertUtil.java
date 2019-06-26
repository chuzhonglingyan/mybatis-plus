package com.yuntian.mybatisplus.util;

import com.yuntian.mybatisplus.exception.BusinessException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import java.util.Collection;

/**
 * @Auther: yuntian
 * @Date: 2018/8/19 17:57
 * @Description: 断言工具类
 */
public class AssertUtil {



    public static void  isNotEmpty(Collection collection,String msg){
        if (CollectionUtils.isEmpty(collection)){
            BusinessException.throwMessage(msg);
        }
    }

    public static void  isEmpty(Collection collection,String msg){
        if (CollectionUtils.isNotEmpty(collection)){
          BusinessException.throwMessage(msg);
        }
    }



    public static void  isNotBlank(String text,String msg){
        if (StringUtils.isBlank(text)){
            BusinessException.throwMessage(msg);
        }
    }


    public static void  isNotNull(Object object,String msg){
        if (object==null){
            BusinessException.throwMessage(msg);
        }
    }

    public static void  isNotTrue(boolean flag,String msg){
        if (!flag){
            BusinessException.throwMessage(msg);
        }
    }


}
