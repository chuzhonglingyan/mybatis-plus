package com.yuntian.mybatisplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuntian.mybatisplus.util.SpringContextUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

/**
 * @Auther: yuntian
 * @Date: 2019/6/30 0030 21:04
 * @Description:
 */
public class FastBatch {

    public int updateBatch(List<Object> list){
        if(list ==null || list.size() <= 0){
            return -1;
        }
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) SpringContextUtil.getBean("sqlSessionFactory");
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
            BaseMapper mapper = sqlSession.getMapper(BaseMapper.class);
            int batchCount = 1000;
            //提交数量,到达这个数量就提交
            for (int index = 0; index < list.size(); index++) {
                Object obj = list.get(index);
                mapper.updateById(obj);
                if(index != 0 && index%batchCount == 0){
                    sqlSession.commit();
                }
            }
            sqlSession.commit();
            return 0;
        }catch (Exception e){
            sqlSession.rollback();
            return -2;
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }

    }


}
