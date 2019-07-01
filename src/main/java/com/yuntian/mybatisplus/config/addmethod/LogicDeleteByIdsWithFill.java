package com.yuntian.mybatisplus.config.addmethod;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlScriptUtils;
import com.yuntian.mybatisplus.util.SqlScriptStrongUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 *
 * @author miemie
 * @since 2018-11-29
 */
public class LogicDeleteByIdsWithFill extends AbstractMethod {

    /**
     * mapper 对应的方法名
     */
    private static final String MAPPER_METHOD = "deleteByIdsWithFill";


    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String isDeleteItem = String.format("when id=#{%s.id} then 1", Constants.ENTITY);
        String updateIdItem = String.format("when id=#{%s.id} then #{%s.updateId}", Constants.ENTITY, Constants.ENTITY);

        String valuesIsDeleteHead = SqlScriptStrongUtils.convertForeach(isDeleteItem, SqlScriptStrongUtils.List, null, Constants.ENTITY, COMMA);
        String valuesIsDeleteBody = SqlScriptUtils.convertTrim(valuesIsDeleteHead, "is_delete =case", "end,", "", "");

        String valueUpdateIdHead = SqlScriptStrongUtils.convertForeach(updateIdItem, SqlScriptStrongUtils.List, null, Constants.ENTITY, COMMA);
        String valuesUpdateIdBody = SqlScriptUtils.convertTrim(valueUpdateIdHead, "update_id =case", "end,", "", "");

        String sqlAll = SqlScriptUtils.convertTrim(valuesIsDeleteBody + "\n" + valuesUpdateIdBody, "set", "", "", ",");

        String idItem = String.format("(#{%s.id},0)", Constants.ENTITY);
        String valuesIDs = SqlScriptUtils.convertForeach(idItem, SqlScriptStrongUtils.List, null, Constants.ENTITY, COMMA);

        String sql = String.format(SqlMethod.LOGIC_DELETE_BATCH_BY_IDS.getSql(), tableInfo.getTableName(), sqlAll, "(id,is_delete)", valuesIDs, "");

        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return addUpdateMappedStatement(mapperClass, modelClass, MAPPER_METHOD, sqlSource);
    }

}

