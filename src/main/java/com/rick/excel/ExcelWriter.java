/**  
 * @Title: ExcelWriter.java
 * @Package com.yummy77.excel
 * @Description: excel 写入接口
 * @author RICK  
 * @date 2015年7月2日 下午5:53:00
 * Company yummy77.com
 */
package com.rick.excel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.rick.excel.template.model.TTitleColumn;

/**
 * @ClassName: ExcelWriter
 * @Description: excel 写入接口
 * @author RICK
 * @date 2015年7月2日 下午5:53:00
 * 
 * Company yummy77.com
 */
public interface ExcelWriter {
	
	/**
	 * 
	 * @Title: write
	 * @Description: 将数据写入 excel
	 * @param dataList
	 * @param tTitleColumn
	 * @throws IOException
	 */
	public void write(List<Map<String, Object>> dataList,TTitleColumn tTitleColumn) throws IOException ;
	

}
