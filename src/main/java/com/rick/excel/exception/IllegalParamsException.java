/**  
 * @Title: IllegalParamsException.java
 * @Package com.yummy77.excel.exception
 * @Description: 不符合要求的参数
 * @author RICK  
 * @date 2015年7月2日 下午3:36:24
 * Company yummy77.com
 */
package com.rick.excel.exception;

/**
 * @ClassName: IllegalParamsException
 * @Description: 不符合要求的参数
 * @author RICK
 * @date 2015年7月2日 下午3:36:24
 * 
 * Company yummy77.com
 */
public class IllegalParamsException extends ExcelAbstractException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 746242568205019583L;

	/**
	 * 
	 */
	public IllegalParamsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public IllegalParamsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public IllegalParamsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}
