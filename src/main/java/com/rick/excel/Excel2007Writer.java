/**  
 * @Title: Excel2007Writer.java
 * @Package com.yummy77.excel
 * @Description: 2007版excel写入器
 * @author RICK  
 * @date 2015年7月2日 下午6:09:08
 * Company yummy77.com
 */
package com.rick.excel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rick.excel.template.model.TCell;
import com.rick.excel.template.model.TTitleColumn;

/**
 * @ClassName: Excel2007Writer
 * @Description: 2007版excel写入器
 * @author RICK
 * @date 2015年7月2日 下午6:09:08
 * 
 * Company yummy77.com
 */
public class Excel2007Writer extends ExcelAbstractWriter {
	
	/**
	 * 不使用默认构造器
	 * 实例化方法 @see {@link com.yummy77.excel.ExcelFactory#getExcelWriter(ExcelVersion)}
	 */
	protected Excel2007Writer(){
		setWorkbook(new XSSFWorkbook());
	}

	/* 
	 * <p>Title: write</p>
	 * <p>Description: excel2007 写入实现</p>
	 * @param dataList
	 * @param tTitleColumn
	 * @param os
	 * @throws IOException
	 * @see com.yummy77.excel.ExcelWriter#write(java.util.List, com.yummy77.excel.template.model.TTitleColumn, java.io.OutputStream)
	 */
	@Override
	public void write(List<Map<String, Object>> dataList,TTitleColumn tTitleColumn) throws IOException {
		XSSFWorkbook xssfWorkbook = (XSSFWorkbook)getWorkbook();
		TCell[] cells = null;//tTitleColumn.getCells(); 
		XSSFSheet sheet = xssfWorkbook.createSheet();
		setSheetData(sheet, dataList, cells);
		writeClose();
	}

}
