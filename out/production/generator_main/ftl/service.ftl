/**
 * @filename:${entityName}Service ${createTime}
 * @project ${project}  ${version}
 * Copyright(c) 2019 ${company} Co. Ltd.
 * All right reserved. 
 */
package ${serviceUrl};

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.bych.util.JsonResult;
import ${entityUrl}.${entityName};
/**   
 *  
 * @Description:  ${entityComment}——SERVICE
 * @Author:       ${author}   
 * @CreateDate:   ${createTime}
 * @Version:      ${version}
 *    
 */
public interface ${entityName}Service {
	
	/**
	 * @explain 查询${entityComment}对象
	 * @param   id
	 * @return  ${entityName}
	 */
	${entityName} selectByPrimaryKey(${idType} id);
	
	/**
	 * @explain 删除${entityComment}对象
	 * @param   id
	 * @return  int
	 */
	int deleteByPrimaryKey(${idType} id);
	
	/**
	 * @explain 添加${entityComment}对象
	 * @param   ${objectName}
	 * @return  int
	 */
	int insertSelective(${entityName} ${objectName});
	
	/**
	 * @explain 修改${entityComment}对象
	 * @param   ${objectName}
	 * @return  int
	 * @author  ${author}
	 */
	int updateByPrimaryKeySelective(${entityName} ${objectName});
	
	/**
	 * @explain 查询${entityComment}集合
	 * @param   ${objectName}
	 * @return  List<${entityName}>
	 */
	List<${entityName}> query${entityName}List(${entityName} ${objectName});

}