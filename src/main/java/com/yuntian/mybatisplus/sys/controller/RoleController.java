package com.yuntian.mybatisplus.sys.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.common.Result;
import com.yuntian.mybatisplus.common.ResultGenerator;
import com.yuntian.mybatisplus.sys.model.entity.Role;
import com.yuntian.mybatisplus.sys.service.RoleService;
import com.yuntian.mybatisplus.sys.model.dto.RoleDTO;

import org.springframework.web.bind.annotation.RestController;
import com.yuntian.mybatisplus.common.BaseController;

/**
 * <p>
 * 后台系统-角色表 前端控制器
 * </p>
 *
 * @author yuntian
 * @since 2019-07-02
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController extends BaseController {


    @Resource
    private RoleService  roleService;


    @PostMapping("/save")
    public Result save(Role dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        roleService.save(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(Role dto) {
        dto.setUpdateId(getUserId());
        roleService.deleteByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Role dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        roleService.updateByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        Role entity = roleService.getById(id);
        return ResultGenerator.genSuccessResult(entity);
    }


    @PostMapping("/list")
    public IPage<Role> list(RoleDTO dto) {
        return roleService.queryListByPage(dto);
    }

}
