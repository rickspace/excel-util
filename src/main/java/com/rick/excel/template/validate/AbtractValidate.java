/**  
 * @Title: AbtractValidate.java
 * @Package com.rick.excel.template.validate
 * @Description: 数据验证
 * @author RICK  
 * @date 2015年7月10日 下午5:20:59
 * Company yummy77.com
 */
package com.rick.excel.template.validate;

/**
 * @ClassName: AbtractValidate
 * @Description: 数据验证
 * @author RICK
 * @date 2015年7月10日 下午5:20:59
 * 
 * Company yummy77.com
 */
public abstract class AbtractValidate implements Validate {
	
	private Validate validate;
	
	public AbtractValidate(){}
	
	/**
	 * 使用装饰模式，实现多级验证
	 * @param validate
	 */
	public AbtractValidate(Validate validate){
		this.validate = validate;
	}

	/* 
	 * <p>Title: validate</p>
	 * <p>Description: 在没有装饰任何验证器的情况下，直接返回true</p>
	 * @param obj
	 * @return
	 * @see com.rick.excel.template.validate.Validate#validate(java.lang.Object)
	 */
	@Override
	public boolean validate(Object obj) {
		if(validate != null){
			return validate.validate(obj);
		}
		return true;
	}

	/* 
	 * <p>Title: addValidate</p>
	 * <p>Description: </p>
	 * @param validate
	 * @return
	 * @see com.rick.excel.template.validate.Validate#addValidate(com.rick.excel.template.validate.Validate)
	 */
	@Override
	public Validate addValidate(Validate validate) {
		if(this.validate != null){
			validate.addValidate(this.validate);
		}
		this.validate = validate;
		return this;
	}

	/**
	 * @return the validate
	 */
	protected Validate getValidate() {
		return validate;
	}
	

}
