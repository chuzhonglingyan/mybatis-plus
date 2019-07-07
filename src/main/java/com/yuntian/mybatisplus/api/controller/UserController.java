package com.yuntian.mybatisplus.api.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.common.Result;
import com.yuntian.mybatisplus.common.ResultGenerator;
import com.yuntian.mybatisplus.api.model.entity.User;
import com.yuntian.mybatisplus.api.service.UserService;
import com.yuntian.mybatisplus.api.model.dto.UserDTO;

import org.springframework.web.bind.annotation.RestController;
import com.yuntian.mybatisplus.common.BaseController;

/**
 * <p>
 * 前台系统-用户表 前端控制器
 * </p>
 *
 * @author yuntian
 * @since 2019-07-07
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {


    @Resource
    private UserService  userService;


    @PostMapping("/save")
    public Result save(User dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        userService.save(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(User dto) {
        dto.setUpdateId(getUserId());
        userService.deleteByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(User dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        userService.updateByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        User entity = userService.getById(id);
        return ResultGenerator.genSuccessResult(entity);
    }


    @PostMapping("/list")
    public IPage<User> list(UserDTO dto) {
        return userService.queryListByPage(dto);
    }

}
