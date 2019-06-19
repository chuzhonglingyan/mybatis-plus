package ${basePackage}.controller;
import ${basePackage}.core.Result;
import ${basePackage}.core.ResultGenerator;
import ${basePackage}.model.entity.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.yuntian.poeticlife.model.vo.PageInfoVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import ${basePackage}.model.dto.${modelNameUpperCamel}DTO;
import ${basePackage}.model.vo.${modelNameUpperCamel}VO;
import javax.annotation.Resource;
import org.apache.shiro.authz.annotation.RequiresPermissions;

/**
* Created by ${author} on ${date}.
*/
@Controller
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller extends BaseController{

    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @RequestMapping("/pageList")
    public String pageList() {
        return "backend/${modelNameLowerCamel}List";
    }

    @RequiresPermissions(value = {"${modelNameLowerCamel}:add"})
    @PostMapping("/add")
    @ResponseBody
    public Result add(${modelNameUpperCamel}VO dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        ${modelNameLowerCamel}Service.saveByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @RequiresPermissions(value = {"${modelNameLowerCamel}:delete"})
    @PostMapping("/delete")
    @ResponseBody
    public Result delete(${modelNameUpperCamel}VO dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        ${modelNameLowerCamel}Service.deleteByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @RequiresPermissions(value = {"${modelNameLowerCamel}:update"})
    @PostMapping("/update")
    @ResponseBody
    public Result update(${modelNameUpperCamel}VO dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        ${modelNameLowerCamel}Service.updateByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @RequiresPermissions(value = {"${modelNameLowerCamel}:view"})
    @PostMapping("/detail")
    @ResponseBody
    public Result detail(@RequestParam Long id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }


    @PostMapping("/list")
    @ResponseBody
    public PageInfoVo<${modelNameUpperCamel}VO> list(${modelNameUpperCamel}DTO dTO) {
        return ${modelNameLowerCamel}Service.queryListByPage(dTO);
    }


}
