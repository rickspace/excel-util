/**  
 * @Title: ExcelAbstractException.java
 * @Package com.yummy77.excel.exception
 * @Description: excel抽象异常类
 * @author RICK  
 * @date 2015年7月2日 下午3:37:50
 * Company yummy77.com
 */
package com.rick.excel.exception;

/**
 * @ClassName: ExcelAbstractException
 * @Description: excel抽象异常类
 * @author RICK
 * @date 2015年7月2日 下午3:37:50
 * 
 * Company yummy77.com
 */
public class ExcelAbstractException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -403571415689440365L;

	/**
	 * 
	 */
	public ExcelAbstractException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ExcelAbstractException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ExcelAbstractException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ExcelAbstractException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ExcelAbstractException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}
