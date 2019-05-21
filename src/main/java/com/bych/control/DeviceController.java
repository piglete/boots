/**
 * @filename:DeviceController 2019-05-13
 * @project boots  V1.0
 * Copyright(c) 2019 BAOYUE Co. Ltd.
 * All right reserved. 
 */
package com.bych.control;

import club.map.core.model.Page;
import club.map.core.web.util.Result;
import com.bych.t_b_device.manager.TBDeviceManager;
import com.bych.t_b_device.model.TBDevice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**   
 * 
 * @Description:  设
 * @Author:       lxl   
 * @C备接口层reateDate:   2019-05-13
 * @Version:      V1.0
 *    
 */
@Api(description = "设备管理/web与设备通信",value="设备管理" )
@CrossOrigin
@RestController
@RequestMapping("/device")
public class DeviceController {
	

	private TBDeviceManager tbDeviceManager;

	public DeviceController(TBDeviceManager tbDeviceManager) {
		this.tbDeviceManager = tbDeviceManager;

	}
	@ApiOperation("查询设备信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", value = "当前页", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "name", value = "设备名称", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "telecomNumber", value = "电信编号", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "cardNumber", value = "卡号", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "deviceType", value = "设备类型", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "regionCode", value = "区域编码", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "startTime", value = "开始时间（安装时间）", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "endTime", value = "结束时间（安装时间）", dataType = "string", paramType = "query")
	})
	@PostMapping("/flipList")
	public Result flipList(
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@RequestParam(value = "name", required = false,defaultValue = "") String name,
			@RequestParam(value = "telecomNumber", required = false,defaultValue = "") String telecomNumber,
			@RequestParam(value = "cardNumber",required = false, defaultValue = "") String cardNumber,
			@RequestParam(value = "deviceType",required = false, defaultValue = "") String deviceType,
			@RequestParam(value = "regionCode",required = false, defaultValue = "") String regionCode,
			@RequestParam(value = "startTime",required = false, defaultValue = "") String startTime,
			@RequestParam(value = "endTime",required = false, defaultValue = "") String endTime

	) {
		Page page = tbDeviceManager.search(name,telecomNumber,cardNumber,deviceType,regionCode, pageNo, pageSize,startTime,endTime);
		return Result.ok(page);
	}

	@ApiOperation("设备管理 - 添加/编辑设备状态信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "name", value = "设备名称", required = true, dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "sn", value = "设备S/N", required = true, dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "telecomNumber", value = "电信编号",  dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "cardNumber", value = "卡号", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "deviceType", value = "设备类型", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "regionCode", value = "区域编号",  dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "address", value = "地址",  dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "installTime", value = "安装时间", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "produceTime", value = "生产日期", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "longitude", value = "经度", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "latitude", value = "纬度", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "category", value = "设备类别", dataType = "string", paramType = "query"),

	})
	@PostMapping("/edit")
	public String edit(
			@RequestParam(value = "id", required = false, defaultValue = "") Integer id,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "sn", defaultValue = "") String sn,
			@RequestParam(value = "telecomNumber", defaultValue = "") String telecomNumber,
			@RequestParam(value = "cardNumber", defaultValue = "") String cardNumber,
			@RequestParam(value = "deviceType", defaultValue = "") Integer deviceType,
			@RequestParam(value = "regionCode", defaultValue = "") String regionCode,
			@RequestParam(value = "address", defaultValue = "") String address,
			@RequestParam(value = "installTime", defaultValue = "") String installTime,
			@RequestParam(value = "produceTime", defaultValue = "") String produceTime,
			@RequestParam(value = "longitude", defaultValue = "") Double longitude,
			@RequestParam(value = "latitude", defaultValue = "") Double latitude,
			@RequestParam(value = "category", defaultValue = "") String category
	) {
		TBDevice tbDevice = new TBDevice();
		if (id != null) {
			tbDevice.setId(id);
		}
		tbDevice.setName(name);
		tbDevice.setSn(sn);
		tbDevice.setTelecomNumber(telecomNumber);
		tbDevice.setCardNumber(cardNumber);
		tbDevice.setDeviceType(deviceType);
		tbDevice.setRegionCode(regionCode);
		tbDevice.setAddress(address);
		tbDevice.setInstallTime(installTime);
		tbDevice.setProduceTime(produceTime);
		tbDevice.setLangitude(longitude);
		tbDevice.setLatitude(latitude);
		tbDevice.setCategory(category);
		int a = tbDeviceManager.upperSave(tbDevice);
		if (a == 1) {
			return "设备名称已存在";
		}
		return "success";
	}

	@ApiOperation(value = "获取设备信息", notes = "获取设备信息，作者：lxl")
	@ApiImplicitParam(paramType="query", name = "id", value = "设备id", required = true, dataType = "Integer")
	@PostMapping("/detail")
	public Result detail(
			@RequestParam(value = "id", defaultValue = "") Integer id
	) {
		TBDevice tbDevice = tbDeviceManager.searchDetails(id);
		return Result.ok(tbDevice);
	}

	@ApiOperation("设备管理 - 删除设备信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "ids", value = "ids", dataType = "string", paramType = "query")
	})
	@PostMapping("/remove")
	public Result remove(
			@RequestParam(value = "ids") String ids
	) {
		tbDeviceManager.removeByIds(ids);
		return Result.ok();
	}
	@ApiOperation("设备通信 - 设备通信")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "data", value = "data", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "type", value = "type", dataType = "int", paramType = "query")
	})
	@PostMapping("/dataUpload")
	public Result dataUpload(
			@RequestParam(value = "data") String data,
			@RequestParam(value = "type") Integer type
	) {
		Map<String,Object> hashmap=new HashMap();
		hashmap.put("data",data);
		hashmap.put("type",type);
		return Result.ok(hashmap);
	}
}