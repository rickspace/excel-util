/**  
 * @Title: NotBlankValidate.java
 * @Package com.yummy77.excel.template
 * @Description: 为空或者空串
 * @author RICK  
 * @date 2015年7月9日 下午3:34:18
 * Company yummy77.com
 */
package com.rick.excel.template.validate;

/**
 * @ClassName: NotBlankValidate
 * @Description: 为空或者空串
 * @author RICK
 * @date 2015年7月9日 下午3:34:18
 * 
 * Company yummy77.com
 */
public class NotBlankValidate extends AbtractValidate implements Validate{
	
	public NotBlankValidate(){
		super(new NotNullValiate());
	}
	
	public NotBlankValidate(Validate validate){
		super(validate);
	}

	/* 
	 * <p>Title: validate</p>
	 * <p>Description: </p>
	 * @param obj
	 * @return
	 * @see com.yummy77.excel.template.Validate#validate(java.lang.Object)
	 */
	@Override
	public boolean validate(Object obj) {
		if(!super.validate(obj))
			return false;
		String __obj = obj.toString();
		return __obj.trim().length() > 0;
	}

}
