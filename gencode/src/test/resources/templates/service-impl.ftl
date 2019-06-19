package ${basePackage}.service.impl;

import ${basePackage}.core.AbstractService;
import ${basePackage}.exception.BusinessException;
import ${basePackage}.dao.${modelNameUpperCamel}Mapper;
import ${basePackage}.service.${modelNameUpperCamel}Service;
import ${basePackage}.model.dto.${modelNameUpperCamel}DTO;
import ${basePackage}.model.vo.${modelNameUpperCamel}VO;
import ${basePackage}.model.entity.${modelNameUpperCamel};
import ${basePackage}.model.vo.PageInfoVo;
import  ${basePackage}.util.AssertUtil;
import org.springframework.stereotype.Service;
import org.apache.commons.collections.CollectionUtils;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import javax.annotation.Resource;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/**
 * Created by ${author} on ${date}.
 */
@Service("${modelNameLowerCamel}Service")
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}DTO,${modelNameUpperCamel}VO> implements ${modelNameUpperCamel}Service {

    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;


    @Override
    public PageInfoVo<${modelNameUpperCamel}VO> queryListByPage(${modelNameUpperCamel}DTO dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        Condition condition = new Condition(${modelNameUpperCamel}.class);
        condition.orderBy("updateTime").desc();
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("isDelete", 0);
        List<${modelNameUpperCamel}VO> list = findByCondition(condition);
        return new PageInfoVo<>(new PageInfo<>(list));
    }

    @Override
    public void saveByDTO(${modelNameUpperCamel}VO dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        save(dto);
    }

    @Override
    public void updateByDTO(${modelNameUpperCamel}VO dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        AssertUtil.isNotNull(dto.getId(), "${modelNameDesc}id不能为空");
        int count=update(dto);
        if(count!=1){
           BusinessException.throwMessage("更新该${modelNameDesc}失败,请刷新页面");
        }
    }

    @Override
    public void deleteByDTO(${modelNameUpperCamel}VO dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        AssertUtil.isNotNull(dto.getId(),"${modelNameDesc}id不能为空");
        dto.setIsDelete((byte) 1);
        int count=update(dto);
        if(count!=1){
           BusinessException.throwMessage("删除该${modelNameDesc}失败,请刷新页面");
        }
    }


    @Override
    public ${modelNameUpperCamel}VO findById(Long id) {
        Condition condition = new Condition(${modelNameUpperCamel}.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("id", id);
        criteria.andEqualTo("isDelete", 0);
        List<${modelNameUpperCamel}VO> list = findByCondition(condition);
        if (CollectionUtils.isNotEmpty(list)) {
           return list.get(0);
        }
        return null;
    }



}
