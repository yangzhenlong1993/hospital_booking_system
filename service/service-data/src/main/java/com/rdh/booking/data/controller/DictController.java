package com.rdh.booking.data.controller;

import com.rdh.booking.common.result.Result;
import com.rdh.booking.data.service.DictService;
import com.rdh.booking.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api("data dictionary restful API")
@RestController
@RequestMapping("/admin/data/dict")
@CrossOrigin
public class DictController {

    @Resource
    private DictService dictService;

    @ApiOperation("get data list based on the id")
    @GetMapping("findChildData/{id}")
    public Result findChildData(@PathVariable Long id){
       List<Dict> list =  dictService.findChildData(id);
       return Result.ok(list);
    }

    @GetMapping("exportData")
    public void exportDict(HttpServletResponse response){
        dictService.exportDictData(response);
    }
}
