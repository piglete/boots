/**   
 * Copyright © 2019 dream horse Info. Tech Ltd. All rights reserved.
 * @Package: com.github.mybatis.fl.entity
 * @author: lxl
 * @date: 2019年5月10日 下午8:15:25
 */
package com.mybatis.fl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**   
 * Copyright: Copyright (c) 2019 
 * 
 * <p>说明： 获取到数据库的信息</P>
 * @version: v2.1.0
 * @author: lxl
 * 
 * Modification History:
 * Date         	Author          Version          Description
 *---------------------------------------------------------------*
 * 2019年5月10日      		lxl   v2.1.0           initialize
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyInfo implements Serializable{
	
	private static final long serialVersionUID = 123124L;
	
	private String column;

	private String jdbcType;
	 
	private String comment;
	 
	private String property;
	 
	private String javaType;

}
