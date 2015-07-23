/**  
 * @Title: ExcelAbstractReader.java
 * @Package com.yummy77.excel
 * @Description: excel 读取抽象封装
 * @author RICK  
 * @date 2015年7月3日 下午1:39:29
 * Company yummy77.com
 */
package com.rick.excel;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.rick.excel.exception.ValidateCellException;
import com.rick.excel.template.model.TCell;
import com.rick.excel.template.model.TTitleColumn;

/**
 * @ClassName: ExcelAbstractReader
 * @Description: excel 读取抽象封装
 * @author RICK
 * @date 2015年7月3日 下午1:39:29
 * 
 * Company yummy77.com
 */
public abstract class ExcelAbstractReader implements ExcelReader {

	private Workbook workbook;
	private InputStream is;
	
	private final static Logger LOGGER= Logger.getLogger(ExcelAbstractReader.class);
	
	/**
	 * 
	 * @Title: loadInputStream
	 * @Description: 加载文件流
	 * @param is
	 * @throws IOException
	 */
	protected abstract void loadInputStream(InputStream is) throws IOException;
	
	/* 
	 * <p>Title: reader</p>
	 * <p>Description: 读取excel内容</p>
	 * @param tTitleColumn
	 * @return
	 * @throws IOException
	 * @see com.yummy77.excel.ExcelReader#reader(com.yummy77.excel.template.model.TTitleColumn)
	 */
	@Override
	public List<Map<String, Object>> reader(TTitleColumn tTitleColumn)
			throws IOException {
		Sheet sheet = getWorkbook().getSheetAt(0);
		List<Map<String, Object>> dataList = null;//reader(sheet,tTitleColumn.getCells(),-1);
		readerClose();
		return dataList;
	}
	
	/**
	 * 
	 * @Title: reader
	 * @Description: 读取sheet中的内容
	 * @param sheet
	 * @param tcells
	 * @param skipRows
	 * @return
	 */
	public List<Map<String, Object>> reader(Sheet sheet,TCell[] tcells,int skipRows){
		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
		FormulaEvaluator evaluator = sheet.getWorkbook().getCreationHelper().createFormulaEvaluator(); 
		Map<String, Object> map;
		skipRows = skipRows > 0 ? skipRows : 0 ;
		int lastNum = sheet.getLastRowNum();
		for (int i = skipRows; i <= lastNum; i++) {
			map = new HashMap<String, Object>();
			Row row = sheet.getRow(i);
			if(row == null || row.getPhysicalNumberOfCells() < 1){
				lastNum = i +1 ;
				break;
			}
			for(TCell tcell : tcells){
				if("null".equalsIgnoreCase(tcell.getCellKey()))//忽略null
					continue;
				Cell cell = row.getCell(tcell.getCellIndex());
				Object obj_value ;
				if(cell != null){
					switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							BigDecimal db = new BigDecimal(cell.getNumericCellValue());
							switch (tcell.getDataType()) {
							case String:
									obj_value = db.toPlainString();
									break;
							default:
								obj_value = db;
							}
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							obj_value = cell.getBooleanCellValue();
							break;
						case Cell.CELL_TYPE_FORMULA:
							evaluator.evaluateFormulaCell(cell);
							switch (tcell.getDataType()) {
								case String:
									obj_value = cell.getStringCellValue();
									break;
								default:
									obj_value = cell.getNumericCellValue();
								}
							break;
						default:
							obj_value = cell.getStringCellValue();
							break;
					}
				}else{
					obj_value = null;
				}
				if(tcell.getValidate() != null){
					if(!tcell.getValidate().validate(obj_value)){
						throw new ValidateCellException("excel 数据验证失败 [第"+(i+1)+"行,"+tcell.getCellText()+"]");
					}
				}
				map.put(tcell.getCellKey(), obj_value);
			}
			dataList.add(map);
			if( i%1000 == 0)
				LOGGER.info("reader row count : " + i);//一千条输出一条日志
		}
		LOGGER.info("reader row over, total count : " + (lastNum + 1 ));//总数
		return dataList;
	}
	
	/**
	 * 
	 * @Title: readerClose
	 * @Description: 关闭流
	 * @throws IOException
	 */
	protected void readerClose() throws IOException{
		getIs().close();
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
	 * @return the is
	 */
	public InputStream getIs() {
		return is;
	}


	/**
	 * @param is the is to set
	 */
	protected void setIs(InputStream is) {
		this.is = is;
	}

}
