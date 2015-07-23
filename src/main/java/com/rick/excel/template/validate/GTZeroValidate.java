/**  
 * @Title: GTZeroValidate.java
 * @Package com.yummy77.excel.template
 * @Description: 大于0
 * @author RICK  
 * @date 2015年7月9日 下午3:44:10
 * Company yummy77.com
 */
package com.rick.excel.template.validate;

import java.math.BigDecimal;

/**
 * @ClassName: GTZeroValidate
 * @Description: 大于0
 * @author RICK
 * @date 2015年7月9日 下午3:44:10
 * 
 * Company yummy77.com
 */
public class GTZeroValidate extends AbtractValidate implements Validate{
	
	public GTZeroValidate(){//默认传为空的异常检查
		super(new NotBlankValidate());
	}
	
	public GTZeroValidate(Validate validate){
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
		BigDecimal __obj = new BigDecimal(String.valueOf(obj));
		return __obj.compareTo(BigDecimal.ZERO) >= 0;
	}

}
