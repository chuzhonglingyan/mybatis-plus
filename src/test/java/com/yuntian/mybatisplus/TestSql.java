package com.yuntian.mybatisplus;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlScriptUtils;
import com.yuntian.mybatisplus.util.SqlScriptStrongUtils;


import org.junit.jupiter.api.Test;

import static com.baomidou.mybatisplus.core.toolkit.StringPool.COMMA;

/**
 * @Auther: yuntian
 * @Date: 2019/6/30 0030 19:40
 * @Description:
 */
public class TestSql {

    @Test
    public void  test(){

        String valuesIsDeleteHead= SqlScriptStrongUtils.convertForeach("when id=#{et.id} then 1", "list", null, Constants.ENTITY, COMMA);
        String valuesIsDeleteBody= SqlScriptUtils.convertTrim(valuesIsDeleteHead,"is_delete =case","end,","","");

        String valueUpdateIdHead= SqlScriptStrongUtils.convertForeach("when id=#{et.id} then #{et.updateId}", "list", null, Constants.ENTITY, COMMA);
        String valuesUpdateIdBody= SqlScriptUtils.convertTrim(valueUpdateIdHead,"update_id =case","end,","","");

        String sqlAll=SqlScriptUtils.convertTrim(valuesIsDeleteBody+"\n"+valuesUpdateIdBody,"set","","",",");

        String idItem=String.format("(#{%s.id})",Constants.ENTITY);
        String valuesIDs=SqlScriptUtils.convertForeach(idItem,"list", null, Constants.ENTITY, COMMA);

        String sql =String.format(SqlMethod.LOGIC_DELETE_BATCH_BY_IDS.getSql(),"user", sqlAll,"id",valuesIDs,"");

        System.out.println(sql);

    }
}
