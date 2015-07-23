/*  
 * @Title: TCell.java
 * @Package com.yummy77.excel.template.model
 * @Description: cell model  单元格模型
 * @author RICK  
 * @date 2015年7月2日 下午3:10:25
 * Company yummy77.com
 */
package com.rick.excel.template.model;

import com.rick.excel.template.DataType;
import com.rick.excel.template.validate.Validate;

/**
 * @ClassName: TCell
 * @Description: cell model  单元格模型
 * @author RICK
 * @date 2015年7月2日 下午3:10:25Aow
 * 
 * Company yummy77.com
 */
public class TCell {
	
	/**
	 * 读写cell数据的key
	 */
	private String cellKey;
	/**
	 * cell所在row的Text
	 */
	private String cellText;
	/**
	 * cell的位置索引
	 */
	private Integer cellIndex;
	/**
	 * cell数据类型
	 */
	private DataType dataType;
	/**
	 * 单元格跨行
	 */
	private int rowspan = 1;
	/**
	 * 单元格跨列
	 */
	private int colspan = 1;
	
	
	/**
	 * cell数据验证
	 */
	private Validate validate;
	
	public TCell(String cellKey,String cellText){
		this(cellKey,cellText,DataType.String);
	}
	
	public TCell(String cellKey,String cellText,DataType dataType){
		this(cellKey,cellText,0,dataType,null);
	}
	
	public TCell(String cellKey,Integer cellIndex){
		this(cellKey,cellIndex,DataType.String);
	}
	
	public TCell(String cellKey,int cellIndex,DataType dataType){
		this(cellKey,"",cellIndex,dataType,null);
	}
	
	public TCell(String cellKey,String cellText,int cellIndex){
		this(cellKey,cellText,cellIndex,DataType.String,null);
	}
	
	public TCell(String cellKey,String cellText,int cellIndex,DataType dataType){
		this(cellKey,cellText,cellIndex,dataType,null);
	}
	
	public TCell(String cellKey,String cellText,int cellIndex,Validate validate){
		this(cellKey,cellText,cellIndex,DataType.String,validate);
	}
	
	public TCell(String cellKey,String cellText,int cellIndex,DataType dataType,Validate validate){
		this.cellKey = cellKey;
		this.cellText = cellText;
		this.cellIndex = cellIndex;
		this.dataType = dataType;
		this.validate = validate;
	}

	
	/**
	 * @return the cellKey
	 */
	public String getCellKey() {
		return cellKey;
	}
	/**
	 * @param cellKey the cellKey to set
	 */
	public void setCellKey(String cellKey) {
		this.cellKey = cellKey;
	}
	/**
	 * @return the cellText
	 */
	public String getCellText() {
		return cellText;
	}
	/**
	 * @param cellText the cellText to set
	 */
	public void setCellText(String cellText) {
		this.cellText = cellText;
	}
	/**
	 * @return the dataType
	 */
	public DataType getDataType() {
		return dataType;
	}
	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return the cellIndex
	 */
	public Integer getCellIndex() {
		return cellIndex;
	}

	/**
	 * @param cellIndex the cellIndex to set
	 */
	public void setCellIndex(Integer cellIndex) {
		this.cellIndex = cellIndex;
	}

	/**
	 * @return the validate
	 */
	public Validate getValidate() {
		return validate;
	}

	/**
	 * @param validate the validate to set
	 */
	public void setValidate(Validate validate) {
		this.validate = validate;
	}

	/**
	 * @return the rowspan
	 */
	public int getRowspan() {
		return rowspan;
	}

	/**
	 * @param rowspan the rowspan to set
	 */
	public void setRowspan(int rowspan) {
		this.rowspan = rowspan;
	}

	/**
	 * @return the colspan
	 */
	public int getColspan() {
		return colspan;
	}

	/**
	 * @param colspan the colspan to set
	 */
	public void setColspan(int colspan) {
		this.colspan = colspan;
	}
	

}
