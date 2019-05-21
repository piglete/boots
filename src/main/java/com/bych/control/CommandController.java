/**
 * @filename:ManagerController 2019-05-13
 * @project boots  V1.0
 * Copyright(c) 2019 BAOYUE Co. Ltd.
 * All right reserved. 
 */
package com.bych.control;

import club.map.core.web.util.Result;
import com.bych.t_c_command.manager.TCCommandManager;
import com.bych.t_c_command.model.VCCommand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**   
 * 
 * @Description:  下发指令信息接口层
 * @Author:       lxl   
 * @CreateDate:   2019-05-13
 * @Version:      V1.0
 *    
 */
@Api(description = "下发指令信息",value="下发指令信息" )
@CrossOrigin
@RestController
@RequestMapping("/command")
public class CommandController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public TCCommandManager tcCommandManager;
	@ApiOperation("查询下发指令信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", value = "当前页", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "sn", value = "设备S/N", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "deviceName", value = "设备名称", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "deviceSta", value = "设备状态", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "exeSta", value = "命令执行状态", dataType = "int", paramType = "query")
	})
	@PostMapping("/flipList")
	public Result flipList(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "sn", required = false, defaultValue = "") String sn,
			@RequestParam(value = "deviceName", required = false, defaultValue = "") String deviceName,
			@RequestParam(value = "deviceSta", required = false, defaultValue = "") Integer deviceSta,
			@RequestParam(value = "exeSta", required = false, defaultValue = "") Integer exeSta

	) {
		if (pageSize != null) {
			PageHelper.startPage(pageNo,pageSize);
		}
		List<VCCommand> docs=tcCommandManager.search(sn,deviceName,deviceSta,exeSta);
		PageInfo page= new PageInfo<>(docs);
		return Result.ok(page);
	}

	
}