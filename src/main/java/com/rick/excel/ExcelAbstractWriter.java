/**  
 * @Title: ExcelAbstractWriter.java
 * @Package com.yummy77.excel
 * @Description: 写入抽象类，封装基础方法
 * @author RICK  
 * @date 2015年7月3日 上午9:56:54
 * Company yummy77.com
 */
package com.rick.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.rick.excel.template.model.TCell;
import com.rick.excel.template.model.TTitleColumn;


/**
 * @ClassName: ExcelAbstractWriter
 * @Description: 写入抽象类
 * 				  使用多态机制，根据传入的参数操作
 * 				 只做方法的基础封装，可重写
 * @author RICK
 * @date 2015年7月3日 上午9:56:54
 * 
 * Company yummy77.com
 */
public abstract class ExcelAbstractWriter implements ExcelWriter {
	
	private final static Logger LOGGER= Logger.getLogger(ExcelAbstractWriter.class);
	
	private Workbook workbook;
	private OutputStream os;
	
	/* 
	 * <p>Title: write</p>
	 * <p>Description: 默认写入实现</p>
	 * @param dataList
	 * @param tTitleColumn
	 * @throws IOException
	 * @see com.yummy77.excel.ExcelWriter#write(java.util.List, com.yummy77.excel.template.model.TTitleColumn)
	 */
	@Override
	public void write(List<Map<String, Object>> dataList,
			TTitleColumn tTitleColumn) throws IOException {
		TCell[] cells = null;// tTitleColumn.getCells(); 
		Sheet sheet = workbook.createSheet();
		setSheetData(sheet, dataList, cells);
		writeClose();
	}

	/**
	 * 
	 * @Title: setSheetData
	 * @Description: 写入sheet数据
	 * @param sheet
	 * @param dataList
	 * @param cells
	 * @throws IOException
	 */
	protected void setSheetData(Sheet sheet,List<Map<String, Object>> dataList,TCell[] cells) throws IOException {
		writeTitle(sheet,cells);
		writeData(sheet,cells,dataList);
	}
	
	/**
	 * 
	 * @Title: write
	 * @Description: 将数据写入流，并且关闭
	 * @throws IOException
	 */
	protected void writeClose() throws IOException {
		getWorkbook().write(os);
		getOs().flush();
		getOs().close();
	}

	
	/**
	 * 
	 * @Title: writeTitle
	 * @Description: 写入标题
	 * @param sheet
	 * @param tCells
	 */
	protected void writeTitle(Sheet sheet,TCell[] tCells){
		Workbook ws = sheet.getWorkbook();
		Row titleRow = sheet.createRow(0);
		CellStyle cellType = ws.createCellStyle();
		{//set css
			Font font = ws.createFont();
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);//标题样式默认加粗
			cellType.setFont(font);
		}
		for (int i = 0; i < tCells.length; i++) {
			Cell cell = titleRow.createCell(i);
			cell.setCellStyle(cellType);
			cell.setCellValue(tCells[i].getCellText());
		}
	}
	
	/**
	 * 
	 * @Title: writeData
	 * @Description: 写入数据
	 * @param sheet
	 * @param tCells
	 * @param dataList
	 */
	protected void writeData(Sheet sheet,TCell[] tCells, List<Map<String,Object>> dataList) {
		String key;
		Object value;
		for (int i = 0;null != dataList && i < dataList.size(); i++) {
			Map<String,Object> dataRowMap = dataList.get(i);
			Row row = sheet.createRow(i+1);// add title row
			for (int j = 0; j < tCells.length; j++) {
				key = tCells[j].getCellKey();
				if(!"null".equalsIgnoreCase(key)){//忽略键值为null
					value = dataRowMap.get(key);
					if(null != value){//忽略value值为null
						row.createCell(j).setCellValue(String.valueOf(value));
					}
				}
			}
			if(i % 1000 == 0)
				LOGGER.info(" write data row count : " + (i+1));
		} 
		LOGGER.info(" write data over  ==> count : " + dataList.size());
	}

	/**
	 * @return the workbook
	 */
	public Workbook getWorkbook() {
		return workbook;
	}

	/**
	 * @param workbook the workbook to set
	 */
	protected void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}

	/**
	 * @return the os
	 */
	public OutputStream getOs() {
		return os;
	}

	/**
	 * @param os the os to set
	 */
	protected void setOs(OutputStream os) {
		this.os = os;
	}
	
	


}
