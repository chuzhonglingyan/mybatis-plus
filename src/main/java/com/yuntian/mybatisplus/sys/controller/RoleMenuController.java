package com.yuntian.mybatisplus.sys.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.common.Result;
import com.yuntian.mybatisplus.common.ResultGenerator;
import com.yuntian.mybatisplus.sys.model.entity.RoleMenu;
import com.yuntian.mybatisplus.sys.service.RoleMenuService;
import com.yuntian.mybatisplus.sys.model.dto.RoleMenuDTO;

import org.springframework.web.bind.annotation.RestController;
import com.yuntian.mybatisplus.common.BaseController;

/**
 * <p>
 * 后台系统-角色菜单关系表 前端控制器
 * </p>
 *
 * @author yuntian
 * @since 2019-07-06
 */
@RestController
@RequestMapping("/sys/roleMenu")
public class RoleMenuController extends BaseController {


    @Resource
    private RoleMenuService  roleMenuService;


    @PostMapping("/save")
    public Result save(RoleMenu dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        roleMenuService.save(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(RoleMenu dto) {
        dto.setUpdateId(getUserId());
        roleMenuService.deleteByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(RoleMenu dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        roleMenuService.updateByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        RoleMenu entity = roleMenuService.getById(id);
        return ResultGenerator.genSuccessResult(entity);
    }


    @PostMapping("/list")
    public IPage<RoleMenu> list(RoleMenuDTO dto) {
        return roleMenuService.queryListByPage(dto);
    }

}
