/**  
 * @Title: ExcelWriterFactory.java
 * @Package com.yummy77.excel
 * @Description: excel 写入 工厂类
 * @author RICK  
 * @date 2015年7月2日 下午6:10:58
 * Company yummy77.com
 */
package com.rick.excel;

import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;

import com.rick.excel.template.DataType;
import com.rick.excel.template.model.TCell;
import com.rick.excel.template.model.TTitleColumn;
import com.rick.excel.template.parse.XMLTemplateParser;
import com.rick.excel.template.validate.GTZeroValidate;
import com.rick.excel.template.validate.NotBlankValidate;


/**
 * @ClassName: ExcelWriterFactory
 * @Description: excel 写入 工厂类
 * @author RICK
 * @date 2015年7月2日 下午6:10:58
 * 
 * Company yummy77.com
 */
public class ExcelFactory {
	
	private final static Logger LOGGER= Logger.getLogger(ExcelFactory.class);
	
	private ExcelFactory(){}
	
	/**
	 * 
	 * @Title: getExcelWriter
	 * @Description: 获取excelWriter
	 * @param version
	 * @return
	 */
	public static ExcelWriter getExcelWriter(ExcelVersion version,OutputStream os){
		try {
			ExcelAbstractWriter writer = version.getWriterClass().newInstance();
			Workbook workbook = version.getWorkbook().newInstance();
			writer.setWorkbook(workbook);
			writer.setOs(os);
			return writer;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new RuntimeException(e);
		} 
	}
	
	/**
	 * 
	 * @Title: getExcelReader
	 * @Description: 获取excelReader
	 * @param version
	 * @param is
	 * @return
	 */
	public static ExcelReader getExcelReader(ExcelVersion version,InputStream is){
		try {
			ExcelAbstractReader reader = version.getReaderClass().newInstance();
			reader.loadInputStream(is);
			return reader;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new RuntimeException(e);
		} 
	}
	
	
	public static void main(String[] args) throws Exception {

		XMLTemplateParser.parse(ExcelFactory.class.getResourceAsStream("/test.xml"));
		//System.out.println(new GTZeroValidate().validate("0"));
		
	}
	private static TTitleColumn tTitleColumn;
	static{
		TCell[] cells = new TCell[30];
		cells[0] = new TCell("stores_id","门店编号",0,new NotBlankValidate());
		cells[1] = new TCell("stores_name","门店名称",1,new NotBlankValidate());
		cells[2] = new TCell("depot_goods_id","商品库存编号",2,new NotBlankValidate());
		cells[3] = new TCell("goods_name","商品名称",3,new NotBlankValidate());
		cells[4] = new TCell("category1","大分类",4);
		cells[5] = new TCell("category2","中分类",5);
		cells[6] = new TCell("category3","小分类",6);
		cells[7] = new TCell("units","单位编号",7,new NotBlankValidate());
		cells[8] = new TCell("units_name","售卖单位",8,new NotBlankValidate());
		cells[9] = new TCell("pre_days","商品到货周期(T+N)",9,DataType.Integer,new GTZeroValidate());
		cells[10] = new TCell("supplier_id","采购商编号",10,new NotBlankValidate());
		cells[11] = new TCell("supplier_all_name","采购商名称",11,new NotBlankValidate());
		cells[12] = new TCell("empty_stock","零库存",12,DataType.Integer,new GTZeroValidate());
		cells[13] = new TCell("tax_rate","税率%",13,DataType.Double,new GTZeroValidate());
		cells[14] = new TCell("tax_purchase_price","到店成本(含税)",14,DataType.Double,new GTZeroValidate());
		cells[15] = new TCell("cu_price","系统零售价(含税)",15,DataType.Double);
		cells[16] = new TCell("gross_margin","毛利率%",16,DataType.Double);
		cells[17] = new TCell("d4","前第四天销量",17,DataType.Integer);
		cells[18] = new TCell("d3","前第三天销量",18,DataType.Integer);
		cells[19] = new TCell("d2","前第二天销量",19,DataType.Integer);
		cells[20] = new TCell("d1","昨日销量",20,DataType.Integer);
		cells[21] = new TCell("avg_p","前四天平均销量",21,DataType.Integer);
		cells[22] = new TCell("avg_damaged_num","前四天平均报损货量",22,DataType.Integer);
		cells[23] = new TCell("stock_valid_num","动态库存数量",23,DataType.Integer);
		cells[24] = new TCell("stock_price","动态库存金额",24,DataType.Double);
		cells[25] = new TCell("avg_d","系统建议补货量",25,DataType.Integer);
		cells[26] = new TCell("min_num","最小起订量",26,DataType.Integer);
		cells[27] = new TCell("audit_num","采购审核订货量",27,DataType.Integer);
		cells[28] = new TCell("final_num","最终订单订货量",28,DataType.Integer,new GTZeroValidate());
		cells[29] = new TCell("final_price","最终订单订货金额",29,DataType.Double);
		//tTitleColumn = new TTitleColumn(cells);
	}

}
