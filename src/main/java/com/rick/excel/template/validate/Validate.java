/**  
 * @Title: Validate.java
 * @Package com.yummy77.excel.template
 * @Description: excel 验证接口
 * @author RICK  
 * @date 2015年7月9日 下午3:16:01
 * Company yummy77.com
 */
package com.rick.excel.template.validate;


/**
 * @ClassName: Validate {
 * @Description: excel 验证接口
 * @author RICK
 * @date 2015年7月9日 下午3:16:01
 * 
 * Company yummy77.com
 */
public interface Validate {
	
	/**
	 * 
	 * @Title: validate
	 * @Description: 值验证
	 * @param cell
	 * @return
	 */
	public boolean validate(Object obj);
	
	/**
	 * 
	 * @Title: addValidate
	 * @Description: 添加验证类
	 * @param validate
	 * @return
	 */
	public Validate addValidate(Validate validate);
	

}
