/* 
 * @Title: TTitleColumn.java
 * @Package com.yummy77.excel.template.model
 * @Description: excel title
 * @author RICK  
 * @date 2015年7月2日 下午3:29:31
 * Company yummy77.com
 */
package com.rick.excel.template.model;

import java.util.List;

import com.rick.excel.exception.IllegalParamsException;

/**
 * @ClassName: TTitleColumn
 * @Description: excel title
 * @author RICK
 * @date 2015年7月2日 下午3:29:31
 * 
 * Company yummy77.com
 */
public class TTitleColumn {
	/**
	 * title rows
	 */
	private TRow[] rows;
	
	private CellCoordsBuilder cellCoordsBuilder = new CellCoordsBuilder();
	
	
	public TTitleColumn(TRow[] rows){
		if(null == rows || rows.length < 1)
			throw new IllegalParamsException(" this field[rows] can't be null or empty");
		this.rows = rows;
	}
	
	public TTitleColumn(List<TRow> rowsList){
		if(null == rowsList || rowsList.isEmpty())
			throw new IllegalParamsException(" this field[rows] can't be null or empty");
		this.rows = rowsList.toArray(new TRow[rowsList.size()]);
	}
	
	/**
	 * @return the dataCells
	 */
	public TCell[] getDataCells() {
		return cellCoordsBuilder.getCellCoords()[getOccupySize() - 1];
	}

	/**
	 * 
	 * @Title: getOccupySize
	 * @Description: 获取title 占用的行数
	 * @return
	 */
	public int getOccupySize() {
		return rows == null ? 0 : rows.length ;
	}

	/**
	 * 
	 * @ClassName: _CellCoords
	 * @Description: 单元格坐标
	 * @author RICK
	 * @date 2015年7月11日 下午12:39:35
	 * 
	 * Company yummy77.com
	 */
	private class CellCoordsBuilder{
		
		
		/**
		 * excel 本身是由规则的 单元格组成，如果把所有的单元格看成一个坐标点(point)，横向(x)和纵向(y)下标就是单元格在坐标上的位置
		 * 每一个point都可以对应一个TCell
		 * 一个跨行跨列的单元格,可以看做是几个点对应TCell
		 * 将坐标用一个TCell的二维数组表示
		 * 这样设置的目的：
		 * 如果只是写Title,完全不用这样处理
		 * 但是如果要找到对应title下的数据的取值，会发现之前定义的TCell由于不断的跨行跨列,已经不知道具体是以哪个TCell取值
		 * 还必须适应各种情况的布局
		 * 这里通过坐标还原后，每一个Point都会有一个原始的TCell,按照覆盖原则，直接按照cellCoords[lastIndex]中的TCell取值即可
		 */
		private TCell[][] cellCoords;
		
		protected TCell[][] getCellCoords(){
			if(cellCoords == null){
				buildCellCoords();
			}
			return cellCoords;
		}
		
		protected void buildCellCoords() {
			initCellCoords();
			fillCellCoords();
		}
		
		/**
		 * 
		 * @Title: getCellCoords
		 * @Description: 获取坐标数组
		 * @return
		 */
		private TCell[][] initCellCoords(){
			int _y_size = getOccupySize();
			int _x_size = 0;
			TCell[] cells = rows[0].getCells();
			for(TCell cell : cells){
				_x_size += cell.getColspan();
			}
			return new TCell[_x_size][_y_size];
		}
		
		/**
		 * 
		 * @Title: fillCellCoords
		 * @Description: 还原单元格，填充 TCell
		 */
		private void fillCellCoords(){
			//TCell[][] __cellCoords = initCellCoords();
			int _x=0,_y=0;
			TCell _currentCell ;
			for (int r = 0; r < rows.length; r++) {
				_x = 0;//reset
				TCell[] _cells = rows[r].getCells();
				for (int c = 0; c < _cells.length; c++) {
					_currentCell = _cells[c];
					int __temp_y = _currentCell.getRowspan() + r;
					int __temp_x = _currentCell.getColspan() + _x;
					int __current_x = _x;// save current x index
					_y = r;
					for ( ; _y < __temp_y ; _y++) {
						_x = __current_x;//reset
						for (int _inner_x_ = _x; _inner_x_ < __temp_x; _inner_x_++) {
							while(true){
								if(cellCoords[_x][_y] == null){
									cellCoords[_x++][_y] = _currentCell;
									break;
								}
								_x ++;//current index
							}
						}
					}
				}
			}
		}
		
	}

	

}
