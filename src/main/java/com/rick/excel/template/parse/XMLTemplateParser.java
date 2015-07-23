/**  
 * @Title: XMLTemplateParser.java
 * @Package com.rick.excel.template.parse
 * @Description: xml 模板解析类
 * @author RICK  
 * @date 2015年7月10日 下午4:49:48
 * Company yummy77.com
 */
package com.rick.excel.template.parse;

import java.io.InputStream;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.rick.excel.template.model.TCell;
import com.rick.excel.template.model.TRow;
import com.rick.excel.template.model.TTitleColumn;
import com.rick.excel.template.validate.NotNullValiate;
import com.rick.excel.template.validate.Validate;

/**
 * @ClassName: XMLTemplateParser
 * @Description: xml 模板解析类
 * @author RICK
 * @date 2015年7月10日 下午4:49:48
 * 
 * Company yummy77.com
 */
public class XMLTemplateParser {
	
	//@SuppressWarnings("unchecked")
	public static TTitleColumn parse(InputStream is) throws DocumentException{
		//TTitleColumn titleColumn = 
		SAXReader reader = new SAXReader();
		Document doc = reader.read(is);
		Element root = doc.getRootElement();
		List<Element> rows_list = root.element("Title").element("Rows").elements();
		TRow[] rows = new TRow[rows_list.size()];
		List<Element> __cell_list;
		TCell[] tcells;
		for(Element _row : rows_list){
			__cell_list = _row.elements();
			tcells = new TCell[__cell_list.size()];
			for (int c = 0; c < __cell_list.size(); c++) {
				tcells[0] = createTCell(__cell_list.get(c));
			}
			
		}
		//return new TTitleColumn(tcells);
		return null;
	}
	
	public static TCell createTCell(Element cell){
		/*cell.attribute(name)
		List<Attribute> __arrList_ = cell.attributes();
		for(Attribute attr : __arrList_){
			System.out.println(attr.getName()+"_"+attr.getText());
		}*/
		return null;
	}
	
	/**
	 * 
	 * @Title: createTCell
	 * @Description: 创建TCell
	 * @param attrs
	 * @return
	 */
	public static TCell createTCell(List<Attribute> attrs){
		
		
		
		return null;
	}
	
	
	/**
	 * 
	 * @Title: getValidate
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param cellElement
	 * @return
	 */
	public Validate getValidate(Element cellElement){
		Validate validate = null;
		if("true".equalsIgnoreCase(cellElement.attributeValue("notNull"))){//为空验证
			validate = validate == null ? new NotNullValiate() : validate.addValidate(validate);
		}
		
		
		
		
		return null;
	}
	
	

}
