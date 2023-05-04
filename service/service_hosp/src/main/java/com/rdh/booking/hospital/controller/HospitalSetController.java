package com.rdh.booking.hospital.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rdh.booking.common.result.Result;
import com.rdh.booking.hospital.service.HospitalSetService;
import com.rdh.booking.model.hosp.HospitalSet;
import com.rdh.booking.vo.hosp.HospitalSetQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yangz
 */
@Api("hospital setting management")
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {
    @Resource
    private HospitalSetService hospitalSetService;

    @GetMapping("findAll")
    public Result findAllHospitalSet() {
        List<HospitalSet> list = hospitalSetService.list();
        return Result.ok(list);
    }

    @ApiOperation("delete hospital setting by id")
    @DeleteMapping("{id}")
    public Result removeHospSet(@PathVariable Long id) {
        boolean flag = hospitalSetService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @PostMapping("findPage/{current}/{limit}")
    public Result findPageHospSet(@PathVariable Long current, @PathVariable Long limit, @RequestBody(required = false) HospitalSetQueryVo hospitalSetQueryVo) {
        Page<HospitalSet> page = hospitalSetService.getHospSetByQueryInPage(current, limit, hospitalSetQueryVo);
        return Result.ok(page);
    }

    @PostMapping("saveHospitalSet")
    public Result saveHospitalSet(@RequestBody HospitalSet hospitalSet) {
        boolean b = hospitalSetService.saveHospitalSet(hospitalSet);
        if (b) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @GetMapping("getHospitalSet/{id}")
    public Result getHospitalSetById(@PathVariable Long id) {
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        return Result.ok(hospitalSet);
    }

    @PostMapping("updateHospitalSet")
    public Result updateHospitalSet(@RequestBody HospitalSet hospitalSet) {
        boolean flag = hospitalSetService.updateById(hospitalSet);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @DeleteMapping("batchRemove")
    public Result batchRemoveHospitalSet(@RequestBody List<Long> ids){
        hospitalSetService.removeByIds(ids);
        return Result.ok();
    }

    @PutMapping("lockHospitalSet/{id}/{status}")
    public Result lockHospitalSet(@PathVariable Long id, @PathVariable Integer status){
        hospitalSetService.lockHospitalSetById(id, status);
        return Result.ok();
    }

    @GetMapping("sendKey/{id}")
    public Result sendKey(@PathVariable Long id){
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        String signKey = hospitalSet.getSignKey();
        String hoscode = hospitalSet.getHoscode();
        //TODO SMS info
        return Result.ok();
    }
}
