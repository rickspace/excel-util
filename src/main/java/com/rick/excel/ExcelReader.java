/**  
 * @Title: ExcelReader.java
 * @Package com.yummy77.excel
 * @Description: excel 读取器
 * @author RICK  
 * @date 2015年7月3日 下午1:36:35
 * Company yummy77.com
 */
package com.rick.excel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.rick.excel.template.model.TTitleColumn;

/**
 * @ClassName: ExcelReader
 * @Description: excel 读取器
 * @author RICK
 * @date 2015年7月3日 下午1:36:35
 * 
 * Company yummy77.com
 */
public interface ExcelReader {
	
	/**
	 * 
	 * @Title: reader
	 * @Description: excel 读取
	 * @param tTitleColumn
	 * @return
	 * @throws IOException
	 */
	public List<Map<String, Object>> reader(TTitleColumn tTitleColumn) throws IOException ;
	
	

}
