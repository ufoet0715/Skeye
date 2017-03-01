package com.skyeye.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.skeye.yagout.util.ObjectUtil;

public class POIUtilTest {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doPOI(String sheetName, String[] propertiesName, Class targetClass, List<?> dataList, String path) {
		File xlsFile=new File(path);
		if(!xlsFile.exists())
		{
			try {
				xlsFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
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

			// 写值
			for (int i = 0; i < rowLength; i++) {
				Object data = dataList.get(i);
				if(targetClass.equals(data.getClass()))
				{
					Field[] fields = targetClass.getDeclaredFields();
					fieldsValue=new String[recordLength];
					returnValue=new String[recordLength];
					for(int j=0;j<recordLength;j++)
					{
						String fieldName= fields[j].getName();
						Method method = null;
						Object value =null;
						method = targetClass.getDeclaredMethod("get"+ObjectUtil.getBig(fieldName));
						returnValue[j] = String.valueOf(method.invoke(data));
					}

					row = sheet.createRow(i + 1);
					for (int j = 0; j < recordLength; j++) {
						cell = row.createCell(j);
						if (returnValue[j] != null) 
						{
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
			
			// 输出
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			workBook.write(fileOutputStream);
			fileOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
