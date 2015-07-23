/**  
 * @Title: Excel2007Reader.java
 * @Package com.yummy77.excel
 * @Description: excel 2007读取器
 * @author RICK  
 * @date 2015年7月3日 下午1:45:46
 * Company yummy77.com
 */
package com.rick.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rick.excel.template.model.TTitleColumn;

/**
 * @ClassName: Excel2007Reader
 * @Description: excel 2007读取器
 * @author RICK
 * @date 2015年7月3日 下午1:45:46
 * 
 * Company yummy77.com
 */
public class Excel2007Reader extends ExcelAbstractReader {

	/* 
	 * <p>Title: reader</p>
	 * <p>Description: excel 2007 读取</p>
	 * @param tTitleColumn
	 * @return
	 * @throws IOException
	 * @see com.yummy77.excel.ExcelAbstractReader#reader(com.yummy77.excel.template.model.TTitleColumn)
	 */
	@Override
	public List<Map<String, Object>> reader(TTitleColumn tTitleColumn)
			throws IOException {
		XSSFWorkbook book = (XSSFWorkbook)getWorkbook();
		XSSFSheet sheet = book.getSheetAt(0);
		List<Map<String, Object>> dataList = null;//reader(sheet, tTitleColumn.getCells(), tTitleColumn.getTitleRowCount());
		readerClose();
		return dataList;
	}

	/* 
	 * <p>Title: loadInputStream</p>
	 * <p>Description: </p>
	 * @param is
	 * @see com.yummy77.excel.ExcelAbstractReader#loadInputStream(java.io.InputStream)
	 */
	@Override
	protected void loadInputStream(InputStream is) throws IOException {
		setIs(is);
		setWorkbook(new XSSFWorkbook(getIs()));
		
	}
	

}
