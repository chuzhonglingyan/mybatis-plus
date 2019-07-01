package ${package.Service};
import com.baomidou.mybatisplus.core.metadata.IPage;
import ${cfg.dtoPackageName}.model.dto.${entity}DTO;
import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import java.util.Collection;

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


   void updateByDTO(${entity} dto);


   void deleteByDTO(${entity} dto);


   void deleteBatchByDTO(Collection<${entity}> entityList);

}
</#if>
