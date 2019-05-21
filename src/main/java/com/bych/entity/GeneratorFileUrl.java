/**   
 * Copyright © 2019 dream horse Info. Tech Ltd. All rights reserved.
 * @Package: com.github.mybatis.fl.entity
 * @author: lxl
 * @date: 2019年5月10日 下午8:15:25
 */
package com.bych.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**   
 * Copyright: Copyright (c) 2019 
 * 
 * <p>说明： 自动生成文件路径</P>
 * @version: v2.1.0
 * @author: lxl
 * 
 * Modification History:
 * Date         	Author          Version          Description
 *---------------------------------------------------------------*
 * 2019年5月10日      lxl            v2.1.0           initialize
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneratorFileUrl implements Serializable{
	private static final long serialVersionUID = 123125L;

	private String entityUrl;
	 
	private String daoUrl;
	 
	private String mapperUrl;
	 
	private String serviceUrl;
	 
	private String serviceImplUrl;
	 
	private String controllerUrl;


}
