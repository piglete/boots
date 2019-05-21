/**
 * @filename:ManagerController 2019-05-13
 * @project boots  V1.0
 * Copyright(c) 2019 BAOYUE Co. Ltd.
 * All right reserved. 
 */
package com.bych.control;

import club.map.core.web.util.Result;
import com.bych.t_s_device_status.manager.VSGasManager;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**   
 * 
 * @Description:  燃气状态信息接口层
 * @Author:       lxl   
 * @CreateDate:   2019-05-13
 * @Version:      V1.0
 *    
 */
@Api(description = "燃气设备状态",value="燃气设备状态" )
@CrossOrigin
@RestController
@RequestMapping("/gas")
public class GasStatusController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public VSGasManager vsGasManager;
	@ApiOperation("查询燃气最新数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", value = "当前页", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "sn", value = "设备S/N", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "deviceName", value = "设备名称", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "regionCode", value = "区域编码", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "deviceSta", value = "设备状态", dataType = "int", paramType = "query")

	})
	@PostMapping("/getLastData")
	public Result getLastData(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "sn", required = false, defaultValue = "") String sn,
			@RequestParam(value = "deviceName", required = false, defaultValue = "") String deviceName,
			@RequestParam(value = "regionCode", required = false, defaultValue = "") String regionCode,
			@RequestParam(value = "deviceSta", required = false, defaultValue = "") Integer deviceSta
	) {
		PageInfo docs=vsGasManager.getLastData(sn,deviceName,regionCode,deviceSta,pageNo,pageSize);
		return Result.ok(docs);
	}

	
}