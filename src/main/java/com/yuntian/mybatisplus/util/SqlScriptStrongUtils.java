package com.yuntian.mybatisplus.util;

import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
 * @Auther: yuntian
 * @Date: 2019/6/30 0030 19:38
 * @Description: sql拼接工具
 */
public class SqlScriptStrongUtils implements Constants {

    public static  final String LIST ="list";

    public static String convertForeach(final String sqlScript, final String collection, final String index, final String item, final String separator) {
        StringBuilder sb = new StringBuilder("<foreach");
        if (StringUtils.isNotEmpty(collection)) {
            sb.append(" collection=\"").append(collection).append("\"");
        }

        if (StringUtils.isNotEmpty(index)) {
            sb.append(" index=\"").append(index).append("\"");
        }

        if (StringUtils.isNotEmpty(item)) {
            sb.append(" item=\"").append(item).append("\"");
        }
        return sb.append(">").append("\n").append(sqlScript).append("\n").append("</foreach>").toString();
    }

}
