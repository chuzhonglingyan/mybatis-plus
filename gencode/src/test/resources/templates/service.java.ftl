package ${package.Service};
import com.baomidou.mybatisplus.core.metadata.IPage;
import ${cfg.dtoPackageName}.model.dto.${entity}DTO;
import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

   IPage<${entity}> queryListByPage(${entity}DTO dto);
}
</#if>
