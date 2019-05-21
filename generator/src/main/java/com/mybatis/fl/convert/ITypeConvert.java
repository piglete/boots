/**   
 * Copyright © 2019 dream horse Info. Tech Ltd. All rights reserved.
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * @Package: com.github.mybatis.fl.convert
 * @author: lxl
 * @date: 2019年5月10日 下午8:06:16
 */
package com.mybatis.fl.convert;

/**   
* Copyright: Copyright (c) 2019 
* 
* <p>说明: 该类的功能描述</p>
* @version: v1.0.0
* @author: lxl
*
* Modification History:
* Date         		Author          Version          Description
*---------------------------------------------------------------*
* 2019年5月10日      		lxl        v2.0.1           initialize
*/
public interface ITypeConvert {
	/**
     * <p>说明:执行类型转换</p>
     * @param dateType 	时间类型
     * @param fieldType 字段类型
     * @return ignore
     */
    IColumnType processTypeConvert(DateType dateType, String fieldType);
}
