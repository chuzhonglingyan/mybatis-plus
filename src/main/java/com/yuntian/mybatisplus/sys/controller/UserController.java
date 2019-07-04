package com.yuntian.mybatisplus.sys.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.common.Result;
import com.yuntian.mybatisplus.common.ResultGenerator;
import com.yuntian.mybatisplus.sys.model.entity.SysUser;
import com.yuntian.mybatisplus.sys.service.UserService;
import com.yuntian.mybatisplus.sys.model.dto.SysUserDTO;

import org.springframework.web.bind.annotation.RestController;
import com.yuntian.mybatisplus.common.BaseController;

/**
 * <p>
 * 后台系统-用户表 前端控制器
 * </p>
 *
 * @author yuntian
 * @since 2019-07-02
 */
@RestController
@RequestMapping("/sys/user")
public class UserController extends BaseController {


    @Resource
    private UserService  userService;


    @PostMapping("/save")
    public Result save(SysUser dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        userService.save(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(SysUser dto) {
        dto.setUpdateId(getUserId());
        userService.deleteByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SysUser dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        userService.updateByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        SysUser entity = userService.getById(id);
        return ResultGenerator.genSuccessResult(entity);
    }


    @PostMapping("/list")
    public IPage<SysUser> list(SysUserDTO dto) {
        return userService.queryListByPage(dto);
    }

}
