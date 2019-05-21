/**
 * @filename:${entityName}Controller ${createTime}
 * @project ${project}  ${version}
 * Copyright(c) 2019 ${company} Co. Ltd.
 * All right reserved. 
 */
package ${controllerUrl};

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ${entityUrl}.${entityName};
import ${daoUrl}.${entityName}Mapper;
import com.bych.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**   
 * 
 * @Description:  ${entityComment}接口层
 * @Author:       ${author}   
 * @CreateDate:   ${createTime}
 * @Version:      ${version}
 *    
 */
@Api(description = "${entityComment}",value="${entityComment}" )
@RestController
@RequestMapping("/${objectName}")
public class ${entityName}Controller {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public ${entityName}Mapper ${objectName}Dao;
	
	/**
	 * @explain 查询${entityComment}对象  <swagger GET请求>
	 * @param   id
	 * @return  ${objectName}
	 * @time    ${createTime}
	 */
	@GetMapping("/get/{id}")
	@ApiOperation(value = "获取${entityComment}信息", notes = "获取${entityComment}信息[${objectName}]，作者：${author}")
	@ApiImplicitParam(paramType="path", name = "id", value = "${entityComment}id", required = true, dataType = "${idType}")
	public JsonResult get${entityName}ById(@PathVariable("id")${idType} id){
		JsonResult result=new JsonResult();
		try {
			${entityName} ${objectName}=${objectName}Dao.selectByPrimaryKey(id);
			if (${objectName}!=null) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(${objectName});
			} else {
				logger.error("获取${entityComment}失败ID："+id);
				result.setCode(-1);
				result.setMessage("你获取的${entityComment}不存在");
			}
		} catch (Exception e) {
			logger.error("获取${entityComment}执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 添加${entityComment}对象
	 * @param   ${objectName}
	 * @return  int
	 * @time    ${createTime}
	 */
	@PostMapping("/insertSelective")
	@ApiOperation(value = "添加${entityComment}", notes = "添加${entityComment}[${objectName}],作者：${author}")
	public JsonResult insertSelective(${entityName} ${objectName}){
		JsonResult result=new JsonResult();
		try {
			int rg=${objectName}Dao.insertSelective(${objectName});
			if (rg>0) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(${objectName});
			} else {
				logger.error("添加${entityComment}执行失败："+${objectName}.toString());
				result.setCode(-1);
				result.setMessage("执行失败，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("添加${entityComment}执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 删除${entityComment}对象
	 * @param   id
	 * @return  int
	 * @time    ${createTime}
	 */
	@PostMapping("/deleteByPrimaryKey")
	@ApiOperation(value = "删除${entityComment}", notes = "删除${entityComment},作者：${author}")
	@ApiImplicitParam(paramType="query", name = "id", value = "${entityComment}id", required = true, dataType = "${idType}")
	public JsonResult deleteByPrimaryKey(${idType} id){
		JsonResult result=new JsonResult();
		try {
			int reg=${objectName}Dao.deleteByPrimaryKey(id);
			if (reg>0) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(id);
			} else {
				logger.error("删除${entityComment}失败ID："+id);
				result.setCode(-1);
				result.setMessage("执行错误，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("删除${entityComment}执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 修改${entityComment}对象
	 * @param   ${objectName}
	 * @return  ${objectName}
	 * @time    ${createTime}
	 */
	@ApiOperation(value = "修改${entityComment}", notes = "修改${entityComment}[${objectName}],作者：${author}")
	@PostMapping("/updateByPrimaryKeySelective")
	public JsonResult updateByPrimaryKeySelective(${entityName} ${objectName}){
		JsonResult result=new JsonResult();
		try {
			int reg = ${objectName}Dao.updateByPrimaryKeySelective(${objectName});
			if (reg>0) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(${objectName});
			} else {
				logger.error("修改${entityComment}失败ID："+${objectName}.toString());
				result.setCode(-1);
				result.setMessage("执行错误，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("修改${entityComment}执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	<#--/**-->
	 <#--* @explain 获取匹配${entityComment}-->
	 <#--* @param   ${objectName}-->
	 <#--* @return  List<${entityName}>-->
	 <#--* @time    ${createTime}-->
	 <#--*/-->
	<#--@ApiOperation(value = "条件查询${entityComment}", notes = "条件查询[${objectName}],作者：${author}")-->
	<#--@PostMapping("/query${entityName}List")-->
	<#--public JsonResult query${entityName}List(${entityName} ${objectName}){-->
		<#--JsonResult result=new JsonResult();-->
		<#--try {-->
			<#--List<${entityName}> list = ${objectName}Dao.query${entityName}List(${objectName});-->
			<#--result.setCode(1);-->
			<#--result.setMessage("成功");-->
			<#--result.setData(list);-->
		<#--} catch (Exception e) {-->
			<#--logger.error("获取${entityComment}执行异常："+e.getMessage());-->
			<#--result.setCode(-1);-->
			<#--result.setMessage("执行异常，请稍后重试");-->
		<#--}-->
		<#--return result;-->
	<#--}-->
}