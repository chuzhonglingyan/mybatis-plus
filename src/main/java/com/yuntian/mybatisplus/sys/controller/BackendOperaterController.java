package com.yuntian.mybatisplus.sys.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.common.Result;
import com.yuntian.mybatisplus.common.ResultGenerator;
import com.yuntian.mybatisplus.sys.model.entity.BackendOperater;
import com.yuntian.mybatisplus.sys.service.BackendOperaterService;
import com.yuntian.mybatisplus.sys.model.dto.BackendOperaterDTO;

import org.springframework.web.bind.annotation.RestController;
import com.yuntian.mybatisplus.common.BaseController;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author yuntian
 * @since 2019-07-02
 */
@RestController
@RequestMapping("/sys/backend-operater")
public class BackendOperaterController extends BaseController {


    @Resource
    private BackendOperaterService  backendOperaterService;


    @PostMapping("/save")
    public Result save(BackendOperater dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        backendOperaterService.save(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(BackendOperater dto) {
        dto.setUpdateId(getUserId());
        backendOperaterService.deleteByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(BackendOperater dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        backendOperaterService.updateByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        BackendOperater entity = backendOperaterService.getById(id);
        return ResultGenerator.genSuccessResult(entity);
    }


    @PostMapping("/list")
    public IPage<BackendOperater> list(BackendOperaterDTO dto) {
        return backendOperaterService.queryListByPage(dto);
    }

}
