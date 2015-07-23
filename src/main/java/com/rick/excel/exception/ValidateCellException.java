/**  
 * @Title: ValidateCellException.java
 * @Package com.yummy77.excel.exception
 * @Description: TODO(用一句话描述该文件做什么)
 * @author RICK  
 * @date 2015年7月9日 下午3:27:32
 * Company yummy77.com
 */
package com.rick.excel.exception;

/**
 * @ClassName: ValidateCellException
 * @Description: excel数据验证异常
 * @author RICK
 * @date 2015年7月9日 下午3:27:32
 * 
 * Company yummy77.com
 */
public class ValidateCellException extends ExcelAbstractException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5700664847664390604L;
	
	public ValidateCellException(String msg){
		super(msg);
	}
	
	public ValidateCellException(){
		super("excel 数据验证失败 ");
	}
	
}
