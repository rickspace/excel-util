/**  
 * @Title: NotNullValiate.java
 * @Package com.yummy77.excel.template
 * @Description: null 验证
 * @author RICK  
 * @date 2015年7月9日 下午3:42:51
 * Company yummy77.com
 */
package com.rick.excel.template.validate;

/**
 * @ClassName: NotNullValiate
 * @Description: null 验证
 * @author RICK
 * @date 2015年7月9日 下午3:42:51
 * 
 * Company yummy77.com
 */
public class NotNullValiate extends AbtractValidate implements Validate {

	public NotNullValiate(){}
	
	public NotNullValiate(Validate validate){
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
		return obj != null;
	}

}
