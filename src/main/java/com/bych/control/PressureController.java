package com.bych.control;

import club.map.core.model.Page;
import club.map.core.web.util.Result;
import com.bych.v_s_pressure.manager.TSPressureManager;
import com.bych.v_s_pressure.manager.VSPressureManager;
import com.bych.v_s_pressure.model.VSPressure;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Description: 压力接口层
 * @Author: lxl
 * @CreateDate: 2019/05/16
 * @Version: v1.0
 */
@Api(description = "压力信息",value="压力信息" )
@CrossOrigin
@RestController
@RequestMapping("/pressure")
public class PressureController {
    @Autowired
    private VSPressureManager vsPressureManager;
    @Autowired
    private TSPressureManager tsPressureManager;
    @ApiOperation("查询设备历史数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sn", value = "设备S/N", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "deviceName", value = "设备名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "regionCode", value = "区域编码", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "开始时间（采集时间）", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间（采集时间）", dataType = "string", paramType = "query"),
    })
    @PostMapping("/flipList")
    public Result flipList(
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "sn", required = false, defaultValue = "") String sn,
            @RequestParam(value = "deviceName", required = false, defaultValue = "") String deviceName,
            @RequestParam(value = "regionCode", required = false, defaultValue = "") String regionCode,
            @RequestParam(value = "startTime", required = false, defaultValue = "") String startTime,
            @RequestParam(value = "endTime", required = false, defaultValue = "") String endTime
    ) {
        Page page = vsPressureManager.search(sn,deviceName,regionCode, pageNo, pageSize,startTime,endTime);
        return Result.ok(page);
    }
    @ApiOperation("查询设备最新数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "sn", value = "设备S/N", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "deviceName", value = "设备名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "regionCode", value = "区域编码", dataType = "string", paramType = "query")

    })
    @PostMapping("/getLastData")
    public Result getLastData(
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "sn", required = false, defaultValue = "") String sn,
            @RequestParam(value = "deviceName", required = false, defaultValue = "") String deviceName,
            @RequestParam(value = "regionCode", required = false, defaultValue = "") String regionCode
    ) {
        if (pageSize != null) {
            PageHelper.startPage(pageNo,pageSize);
        }

        List<VSPressure> docs=vsPressureManager.getLastData(sn,deviceName,regionCode);

        PageInfo page= new PageInfo<>(docs);
        return Result.ok(page);
}
    @ApiOperation("删除 - 删除压力信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "ids", dataType = "string", paramType = "query")
    })
    @PostMapping("/remove")
    public Result remove(
            @RequestParam(value = "ids") String ids
    ) {
        tsPressureManager.removeByIds(ids);
        return Result.ok();
    }
}
