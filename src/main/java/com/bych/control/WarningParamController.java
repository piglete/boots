/**
 * @filename:WarningParamController 2019-05-13
 * @project boots  V1.0
 * Copyright(c) 2019 BAOYUE Co. Ltd.
 * All right reserved. 
 */
package com.bych.control;

import club.map.core.model.Page;
import club.map.core.web.util.Result;
import com.bych.t_s_warning_record.manager.TSWarningRecordManager;
import com.bych.t_s_warningparam.manager.TSWarningparamManager;
import com.bych.t_s_warningparam.model.TSWarningparam;
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
 * @Description:  报警参数接口层
 * @Author:       lxl   
 * @CreateDate:   2019-05-13
 * @Version:      V1.0
 *    
 */
@Api(description = "报警参数/报警记录",value="报警管理" )
@CrossOrigin
@RestController
@RequestMapping("/warn")
public class WarningParamController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TSWarningRecordManager tsWarningRecordManager;
    private TSWarningparamManager tsWarningparamManager;
	public WarningParamController(TSWarningparamManager tsWarningparamManager) {
		this.tsWarningparamManager = tsWarningparamManager;

	}
	/**
	 * @explain 查询报警参数对象  <swagger GET请求>
	 * @param   id
	 * @return  tSWarningparam
	 * @time    2019-05-13
	 */
	@ApiOperation(value = "获取报警参数信息", notes = "获取报警参数，作者：lxl")
	@ApiImplicitParam( name = "id", value = "报警参数id", required = true,dataType = "Integer" ,paramType="query")
	@PostMapping("/detail")
	public Result detail(
			@RequestParam(value = "id", defaultValue = "") Integer id
	) {
		TSWarningparam tsWarningparam = tsWarningparamManager.searchDetails(id);
		return Result.ok(tsWarningparam);
	}
	
	/**
	 * @explain 添加报警参数对象
	 * @param
	 * @return  int
	 * @time    2019-05-13
	 */
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "presUpper", value = "压力上限", dataType = "double", paramType = "query"),
			@ApiImplicitParam(name = "presLower", value = "压力下限", dataType = "double", paramType = "query"),
			@ApiImplicitParam(name = "voltageUpper", value = "电压上限", dataType = "double", paramType = "query"),
			@ApiImplicitParam(name = "voltageLower", value = "电压下限", dataType = "double", paramType = "query"),
			@ApiImplicitParam(name = "heartTime", value = "心跳包时间", dataType = "double", paramType = "query")
	})
	@PostMapping("/edit")

	@ApiOperation(value = "添加报警参数", notes = "添加报警参数[tSWarningparam],作者：lxl")
	public Result insertSelective(@RequestParam(value = "id", required = false, defaultValue = "") Integer id,
								  @RequestParam(value = "presUpper", required = false, defaultValue = "") Double presUpper,
								  @RequestParam(value = "presLower", required = false, defaultValue = "") Double presLower,
								  @RequestParam(value = "voltageUpper", required = false,defaultValue = "") Double voltageUpper,
								  @RequestParam(value = "voltageLower", required = false, defaultValue = "") Double voltageLower,
								  @RequestParam(value = "heartTime", required = false, defaultValue = "") Double heartTime
	){
		TSWarningparam tsWarningparam = new TSWarningparam();
		if (id != null) {
			tsWarningparam.setId(id);
		}
		tsWarningparam.setPresUpper(presUpper);
		tsWarningparam.setPresLower(presLower);
		tsWarningparam.setVoltageUpper(voltageUpper);
		tsWarningparam.setVoltageLower(voltageLower);
		tsWarningparam.setHeartTime(heartTime);
		tsWarningparamManager.upperSave(tsWarningparam);
		return Result.ok();
	}
	
	/**
	 * @explain 删除报警参数对象
	 * @param   ids
	 * @return  int
	 * @time    2019-05-13
	 */
	@ApiOperation("报警参数管理 - 删除报警参数")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "ids", value = "ids", dataType = "string", paramType = "query")
	})
	@PostMapping("/remove")
	public Result remove(
			@RequestParam(value = "ids") String ids
	) {
		tsWarningparamManager.removeByIds(ids);
		return Result.ok();
	}
	@ApiOperation("查询报警参数")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", value = "当前页", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "presUpper", value = "压力上限", dataType = "double", paramType = "query"),
			@ApiImplicitParam(name = "presLower", value = "压力下限", dataType = "double", paramType = "query"),
			@ApiImplicitParam(name = "voltageUpper", value = "电压上限", dataType = "double", paramType = "query"),
			@ApiImplicitParam(name = "voltageLower", value = "电压下限", dataType = "double", paramType = "query"),
			@ApiImplicitParam(name = "heartTime", value = "心跳包时间", dataType = "double", paramType = "query")
	})
	@PostMapping("/flipList")
	public Result flipList(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@RequestParam(value = "presUpper", required = false, defaultValue = "") Double presUpper,
			@RequestParam(value = "presLower", required = false, defaultValue = "") Double presLower,
			@RequestParam(value = "voltageUpper", required = false,defaultValue = "") Double voltageUpper,
			@RequestParam(value = "voltageLower", required = false, defaultValue = "") Double voltageLower,
			@RequestParam(value = "heartTime", required = false, defaultValue = "") Double heartTime
	) {
		TSWarningparam tsWarningparam = new TSWarningparam();
		tsWarningparam.setPresUpper(presUpper);
		tsWarningparam.setPresLower(presLower);
		tsWarningparam.setVoltageUpper(voltageUpper);
		tsWarningparam.setVoltageLower(voltageLower);
		tsWarningparam.setHeartTime(heartTime);
		Page page = tsWarningparamManager.search(tsWarningparam,pageNo, pageSize);
		return Result.ok(page);
	}
	@ApiOperation("查询报警记录")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", value = "当前页", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "sn", value = "设备序列号", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "regionCode", value = "区域", dataType = "string", paramType = "query")
	})
	@PostMapping("/getWarningRecords")
	public Result getWarningRecord(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "sn", required = false, defaultValue = "") String sn,
			@RequestParam(value = "regionCode", required = false, defaultValue = "") String regionCode
	) {

		Page page = tsWarningRecordManager.search(sn,regionCode,pageNo, pageSize);
		return Result.ok(page);
	}
	
}