package com.yuntian.mybatisplus.sys.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.common.Result;
import com.yuntian.mybatisplus.common.ResultGenerator;
import com.yuntian.mybatisplus.sys.model.entity.OperatorRole;
import com.yuntian.mybatisplus.sys.service.OperatorRoleService;
import com.yuntian.mybatisplus.sys.model.dto.OperatorRoleDTO;

import org.springframework.web.bind.annotation.RestController;
import com.yuntian.mybatisplus.common.BaseController;

/**
 * <p>
 * 后台系统-用户角色关系表 前端控制器
 * </p>
 *
 * @author yuntian
 * @since 2019-07-06
 */
@RestController
@RequestMapping("/sys/operatorRole")
public class OperatorRoleController extends BaseController {


    @Resource
    private OperatorRoleService  operatorRoleService;


    @PostMapping("/save")
    public Result save(OperatorRole dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        operatorRoleService.save(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(OperatorRole dto) {
        dto.setUpdateId(getUserId());
        operatorRoleService.deleteByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(OperatorRole dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        operatorRoleService.updateByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        OperatorRole entity = operatorRoleService.getById(id);
        return ResultGenerator.genSuccessResult(entity);
    }


    @PostMapping("/list")
    public IPage<OperatorRole> list(OperatorRoleDTO dto) {
        return operatorRoleService.queryListByPage(dto);
    }

}
