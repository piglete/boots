/**
 * @filename:DeviceStatusController 2019-05-13
 * @project boots  V1.0
 * Copyright(c) 2019 BAOYUE Co. Ltd.
 * All right reserved. 
 */
package com.bych.control;

import club.map.core.web.util.Result;
import com.bych.service.ImportData;
import com.bych.t_s_device_status.manager.VSDeviceStatusManager;
import com.bych.t_s_device_status.model.VSPressureStatusData;
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

//import com.bych.t_s_device_status.manager.TSDeviceStatusManager;

/**   
 * 
 * @Description:  设备状态接口层
 * @Author:       lxl   
 * @CreateDate:   2019-05-13
 * @Version:      V1.0
 *    
 */
@Api(description = "压力设备状态",value="压力设备状态" )
@CrossOrigin
@RestController
@RequestMapping("/devicestatus")
public class DeviceStatusController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	

    public ImportData importData;
	public DeviceStatusController(
								  ImportData importData) {
		this.importData=importData;
	}
	@Autowired
	public VSDeviceStatusManager vsDeviceStatusLastManager;

	/**
	 * @explain 查询设备状态对象  <swagger GET请求>
	 * @time    2019-05-13
	 */
	@ApiImplicitParams({
			@ApiImplicitParam(name = "url", value = "url", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "type", value = "type", dataType = "Integer", paramType = "query")
	})
	@GetMapping("/import")
	@ApiOperation(value = "导入", notes = "作者：lxl")
	public Result importss(	@RequestParam(value = "url") String url,
							@RequestParam(value = "type") Integer type){
		importData.importFromExcel(url,type);
		return Result.ok();
	}
	/**
	 * @explain 删除设备状态对象
	 * @param   ids
	 * @return  int
	 * @time    2019-05-13
	 */
	@ApiOperation("设备状态管理 - 删除设备状态信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "ids", value = "ids", dataType = "string", paramType = "query")
	})
	@PostMapping("/remove")
	public Result remove(
			@RequestParam(value = "ids") String ids
	) {
//		tsDeviceStatusManager.removeByIds(ids);
		return Result.ok();
	}



//	@ApiOperation("查询某设备历史信息")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "pageNo", value = "当前页", dataType = "int", paramType = "query"),
//			@ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int", paramType = "query"),
//			@ApiImplicitParam(name = "deviceName", value = "设备名称", dataType = "string", paramType = "query"),
//			@ApiImplicitParam(name = "regionCode", value = "区域编号", dataType = "string", paramType = "query"),
////			@ApiImplicitParam(name = "voltageSta", value = "电压状态", dataType = "int", paramType = "query"),
////			@ApiImplicitParam(name = "pressSta", value = "压力状态", dataType = "int", paramType = "query"),
////			@ApiImplicitParam(name = "heartSta", value = "心跳状态", dataType = "int", paramType = "query"),
////			@ApiImplicitParam(name = "batterySta", value = "电池状态", dataType = "int", paramType = "query"),
//			@ApiImplicitParam(name = "deviceSta", value = "设备状态", dataType = "int", paramType = "query"),
//			@ApiImplicitParam(name = "startTime", value = "开始时间（采集时间）", dataType = "string", paramType = "query"),
//			@ApiImplicitParam(name = "endTime", value = "结束时间（采集时间）", dataType = "string", paramType = "query")
//	})
//	@PostMapping("/flipList")
//	public Result flipList(
//			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
//			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
//			@RequestParam(value = "deviceName", required = false, defaultValue = "") Integer equId,
//			@RequestParam(value = "regionCode", required = false, defaultValue = "") String equStaBattery,
//			@RequestParam(value = "equStatus", required = false, defaultValue = "") String equStatus,
//			@RequestParam(value = "equId", required = false, defaultValue = "") Integer equId,
//			@RequestParam(value = "equStaBattery", required = false, defaultValue = "") String equStaBattery,
//			@RequestParam(value = "equStatus", required = false, defaultValue = "") String equStatus,
//			@RequestParam(value = "equId", required = false, defaultValue = "") Integer equId,
//			@RequestParam(value = "equStaBattery", required = false, defaultValue = "") String equStaBattery,
//			@RequestParam(value = "equStatus", required = false, defaultValue = "") String equStatus,
//			@RequestParam(value = "startTime", required = false, defaultValue = "") String startTime,
//			@RequestParam(value = "endTime", required = false, defaultValue = "") String endTime
//	) {
//		Page page = tsDeviceStatusManager.search(equId,equStaBattery,equStatus, pageNo, pageSize,startTime,endTime);
//		return Result.ok(page);
//	}
	@ApiOperation("查询设备最新数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", value = "当前页", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "deviceName", value = "设备名称", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "regionCode", value = "区域编号", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "voltageSta", value = "电压状态", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pressSta", value = "压力状态", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "heartSta", value = "心跳状态", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "batterySta", value = "电池状态", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "deviceSta", value = "设备状态", dataType = "int", paramType = "query")
	})
	@PostMapping("/getLastData")
	public Result getLastData(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false ) Integer pageSize,
			@RequestParam(value = "deviceName", required = false, defaultValue = "") String deviceName,
			@RequestParam(value = "regionCode", required = false, defaultValue = "") String regionCode,
			@RequestParam(value = "voltageSta", required = false, defaultValue = "") Integer voltageSta,
			@RequestParam(value = "pressSta", required = false, defaultValue = "") Integer pressSta,
			@RequestParam(value = "heartSta", required = false, defaultValue = "") Integer heartSta,
			@RequestParam(value = "batterySta", required = false, defaultValue = "") Integer batterySta,
			@RequestParam(value = "deviceSta", required = false, defaultValue = "") Integer deviceSta

	) {
		if (pageSize != null) {
			PageHelper.startPage(pageNo,pageSize);
		}
		List<VSPressureStatusData> docs = vsDeviceStatusLastManager.getLastData(deviceName,regionCode, voltageSta, pressSta, heartSta, batterySta, deviceSta);

		PageInfo page= new PageInfo<>(docs);
		return Result.ok(page);
	}
}