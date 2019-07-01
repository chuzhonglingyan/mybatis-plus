package ${package.Controller};


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import ${cfg.packageName}.common.Result;
import ${cfg.packageName}.common.ResultGenerator;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import ${cfg.dtoPackageName}.model.dto.${entity}DTO;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>


    @Resource
    private ${entity}Service  ${entity?uncap_first}Service;


    @PostMapping("/save")
    public Result save(${entity} dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        ${entity?uncap_first}Service.save(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(${entity} dto) {
        dto.setUpdateId(getUserId());
        ${entity?uncap_first}Service.deleteByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(${entity} dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        ${entity?uncap_first}Service.updateByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        ${entity} entity = ${entity?uncap_first}Service.getById(id);
        return ResultGenerator.genSuccessResult(entity);
    }


    @PostMapping("/list")
    public IPage<${entity}> list(${entity}DTO dto) {
        return ${entity?uncap_first}Service.queryListByPage(dto);
    }

}
</#if>
