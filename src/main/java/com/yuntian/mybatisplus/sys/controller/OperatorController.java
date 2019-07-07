package com.yuntian.mybatisplus.sys.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.common.Result;
import com.yuntian.mybatisplus.common.ResultGenerator;
import com.yuntian.mybatisplus.sys.model.entity.Operator;
import com.yuntian.mybatisplus.sys.service.OperatorService;
import com.yuntian.mybatisplus.sys.model.dto.OperatorDTO;

import org.springframework.web.bind.annotation.RestController;
import com.yuntian.mybatisplus.common.BaseController;

/**
 * <p>
 * 后台系统-用户表 前端控制器
 * </p>
 *
 * @author yuntian
 * @since 2019-07-06
 */
@RestController
@RequestMapping("/sys/operator")
public class OperatorController extends BaseController {


    @Resource
    private OperatorService  operatorService;


    @PostMapping("/save")
    public Result save(Operator dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        operatorService.save(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(Operator dto) {
        dto.setUpdateId(getUserId());
        operatorService.deleteByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Operator dto) {
        dto.setCreateId(getUserId());
        dto.setUpdateId(getUserId());
        operatorService.updateByDTO(dto);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        Operator entity = operatorService.getById(id);
        return ResultGenerator.genSuccessResult(entity);
    }


    @PostMapping("/list")
    public IPage<Operator> list(OperatorDTO dto) {
        return operatorService.queryListByPage(dto);
    }

}
