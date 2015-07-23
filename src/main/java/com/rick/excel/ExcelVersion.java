/**  
 * @Title: ExcelVersion.java
 * @Package com.yummy77.excel
 * @Description: excel版本
 * @author RICK  
 * @date 2015年7月2日 下午5:58:17
 * Company yummy77.com
 */
package com.rick.excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @ClassName: ExcelVersion
 * @Description: excel版本
 * @author RICK
 * @date 2015年7月2日 下午5:58:17
 * 
 * Company yummy77.com
 */
public enum ExcelVersion {
	
	/**
	 * 2003
	 */
	//EXCEL2003(ExcelWriter.class,".xls"),
	
	/**
	 * 2007 
	 */
	EXCEL2007(XSSFWorkbook.class,Excel2007Writer.class,Excel2007Reader.class,".xlsx"),
	/**
	 * 
	 */
	EXCELLAST(XSSFWorkbook.class,Excel2007Writer.class,Excel2007Reader.class,".xlsx")
	;
	
	/**
	 * 文件后缀
	 */
	private String suffix;
	/**
	 * 写入操作类
	 */
	private Class<? extends ExcelAbstractWriter> writerClass;
	/**
	 * 读取操作类
	 */
	private Class<? extends ExcelAbstractReader> readerClass;
	/**
	 * excel 文档对象
	 */
	private Class<? extends Workbook> workbook;
	ExcelVersion(
					Class<? extends Workbook> workbook,
					Class<? extends ExcelAbstractWriter> writerClass,
					Class<? extends ExcelAbstractReader> readerClass,
					String suffix){
		this.suffix = suffix;
		this.writerClass = writerClass;
		this.readerClass = readerClass;
		this.workbook = workbook;
	}
	
	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}
	/**
	 * @return the writerClass
	 */
	public Class<? extends ExcelAbstractWriter> getWriterClass() {
		return this.writerClass;
	}

	/**
	 * @return the workbook
	 */
	public Class<? extends Workbook> getWorkbook() {
		return workbook;
	}

	/**
	 * @return the readerClass
	 */
	public Class<? extends ExcelAbstractReader> getReaderClass() {
		return readerClass;
	}
	


}
