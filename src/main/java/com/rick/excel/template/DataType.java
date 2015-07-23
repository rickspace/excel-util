/**  
 * @Title: DataType.java
 * @Package com.yummy77.excel.template
 * @Description: excel表格数据类型
 * @author RICK  
 * @date 2015年7月2日 下午3:13:08
 * Company yummy77.com
 */
package com.rick.excel.template;

/**
 * @ClassName: DataType
 * @Description: excel表格数据类型
 * @author RICK
 * @date 2015年7月2日 下午3:13:08
 * 
 * Company yummy77.com
 */
@SuppressWarnings("rawtypes")
public enum DataType {
	
	String(java.lang.String.class),
	
	Integer(java.lang.Integer.class),
	
	Long(java.lang.Long.class),
	
	Float(java.lang.Float.class),
	
	Double(java.lang.Double.class),
	
	Date(java.util.Date.class),
	
	;
	
	private Class clasz;
	DataType(Class clasz){
		this.clasz = clasz;
	}
	/**
	 * @return the clasz
	 */
	public Class getClasz() {
		return clasz;
	}


}
