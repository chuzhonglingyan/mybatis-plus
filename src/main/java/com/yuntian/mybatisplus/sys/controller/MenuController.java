package com.yuntian.mybatisplus.sys.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.common.Result;
import com.yuntian.mybatisplus.common.ResultGenerator;
import com.yuntian.mybatisplus.sys.model.entity.Menu;
import com.yuntian.mybatisplus.sys.service.MenuService;
import com.yuntian.mybatisplus.sys.model.dto.MenuDTO;

import org.springframework.web.bind.annotation.RestController;
import com.yuntian.mybatisplus.common.BaseController;

/**
 * <p>
 * 后台系统-菜单表 前端控制器
 * </p>
 *
 * @author yuntian
 * @since 2019-07-02
 */
@RestController
@RequestMapping("/sys/menu")
public class MenuController extends BaseController {


    @Resource
    private MenuService  menuService;


    @PostMapping("/save")
    public Result save(Menu dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        menuService.save(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(Menu dto) {
        dto.setUpdateId(getUserId());
        menuService.deleteByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Menu dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        menuService.updateByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        Menu entity = menuService.getById(id);
        return ResultGenerator.genSuccessResult(entity);
    }


    @PostMapping("/list")
    public IPage<Menu> list(MenuDTO dto) {
        return menuService.queryListByPage(dto);
    }

}
