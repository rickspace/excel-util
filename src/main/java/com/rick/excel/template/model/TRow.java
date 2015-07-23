/*  
 * @Title: TRow.java
 * @Package com.yummy77.excel.template.model
 * @Description: Row model 单元行模型
 * @author RICK  
 * @date 2015年7月2日 下午3:09:10
 * Company yummy77.com
 */
package com.rick.excel.template.model;

import java.util.List;

import com.rick.excel.exception.IllegalParamsException;

/**
 * @ClassName: TRow
 * @Description: Row model  单元行模型
 *               单元行初始化时，需要指定已有的单元格，先有格，根据格排成行
 *          	   这样行初始化后，能保证行中单元格的数量不会改变
 * @author RICK  
 * @date 2015年7月2日 下午3:09:10
 * 
 * Company yummy77.com
 */
public class TRow {
	
	/**
	 * title cell
	 */
	private TCell[] cells;
	
	/**
	 * 
	 * @param cells
	 */
	public TRow(TCell[] cells){
		if(null == cells || cells.length < 1)
			throw new IllegalParamsException(" this field[cells] can't be null or empty");
		this.cells = cells;
	}
	
	/**
	 * 
	 * @param cellsList
	 */
	public TRow(List<TCell> cellsList){
		if(null == cellsList || cellsList.isEmpty())
			throw new IllegalParamsException(" this field[cells] can't be null or empty");
		this.cells = cellsList.toArray(new TCell[cellsList.size()]);
	}
	/**
	 * @return the cells
	 */
	public TCell[] getCells() {
		return cells;
	}


}
