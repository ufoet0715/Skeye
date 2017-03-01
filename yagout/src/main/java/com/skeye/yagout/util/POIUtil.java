package com.skeye.yagout.util;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class POIUtil {

	private static Logger logger = Logger.getLogger(POIUtil.class);
	
	@SuppressWarnings({ "resource", "deprecation", "unused", "rawtypes", "unchecked" })
	public static byte[] doPOI(String sheetName, String[] propertiesName, Class targetClass, List<?> dataList) {

		ByteArrayOutputStream out = null;
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFCellStyle cellStyle = workBook.createCellStyle();
		HSSFSheet sheet = workBook.createSheet(sheetName);
		HSSFRow row = null;
		HSSFCell cell = null;

		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		try {
			String[] fieldsValue=null;
            String[] returnValue=null;
            
			int recordLength = propertiesName.length;
			int rowLength = dataList.size();

			row = sheet.createRow(0);

			// 写属性名
			for (int i = 0; i < recordLength; i++) {
				cell = row.createCell(i);
				cell.setCellValue(propertiesName[i]);
				cell.setCellStyle(cellStyle);
			}

			String fieldName=null;
			Method method = null;
			Object value =null;
			// 写值
			for (int i = 0; i < rowLength; i++) {
				Object data = dataList.get(i);
				if(targetClass.equals(data.getClass()))
				{
					Field[] fields = targetClass.getDeclaredFields();
					fieldsValue=new String[recordLength];
					returnValue=new String[recordLength];
					row = sheet.createRow(i + 1);
					for(int j=0;j<recordLength;j++)
					{
						cell = row.createCell(j);
						fieldName=fields[j].getName();
						method = targetClass.getDeclaredMethod("get"+ObjectUtil.getBig(fieldName));
						returnValue[j] = String.valueOf(method.invoke(data));
						if (returnValue[j] != null) 
						{
							if(fieldName.equals("lastcaptime")||fieldName.equals("captime"))
							{
								returnValue[j]=DateFormatUtil.toDateStringM(Long.parseLong(returnValue[j]));	
							}
							if(fieldName.equals("dailtime"))
							{
								returnValue[j]=DateFormatUtil.toDateStringS(Long.parseLong(returnValue[j]));	
							}
							cell.setCellValue(returnValue[j]);
						}
						else
						{
							cell.setCellValue("");
						}
						cell.setCellStyle(cellStyle);
					}
				}
			}
			out = new ByteArrayOutputStream();
			workBook.write(out);
		} catch (Exception e) {
			logger.error("导入excel错误",e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					logger.error("导入excelout关闭错误",e);
				}
			}
		}
		return out.toByteArray();
	}
}
