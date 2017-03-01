package com.yagout.defense.util;

import org.apache.log4j.Logger;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class FileUtils {

	private static Logger logger = Logger.getLogger(FileUtils.class);
	public static boolean upload(InputStream is,
			String path, String realname) {
		boolean result = false;
		File file = new File(path, realname);
		FileOutputStream os = null;
		try {
			file.createNewFile();
			os = new FileOutputStream(file);
			byte[] datas = new byte[1024];
			int length = 0;

			while ((length = is.read(datas)) > 0) {
				os.write(datas, 0, length);
			}

			result = true;
		} catch (IOException e) {
			logger.error(e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
		return result;
	}

	public static String readTxtFile(InputStream is){
		StringBuffer  stringBuffer=new StringBuffer();
		try {
			String encoding="GBK";
				InputStreamReader read = new InputStreamReader(
						is,encoding);//考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while((lineTxt = bufferedReader.readLine()) != null){
					stringBuffer.append(lineTxt);
				}
				read.close();

		} catch (Exception e) {
			logger.error(e);
		}
       return  stringBuffer.toString();
	}


	public static String readZipFile(String file) throws Exception {
		StringBuffer  stringBuffer=new StringBuffer();
		try {
			ZipFile zf = new ZipFile(file);
			
			
			InputStream in = new BufferedInputStream(new FileInputStream(file));
			ZipInputStream zin = new ZipInputStream(in);
			ZipEntry ze;
			while ((ze = zin.getNextEntry()) != null) {
				if (ze.isDirectory()) {
				} else {
					if (ze.getName().equals("readme.ini")){
						long size = ze.getSize();
						if (size > 0) {
							BufferedReader br = new BufferedReader(
									new InputStreamReader(zf.getInputStream(ze)));
							String line;
							while ((line = br.readLine()) != null) {
								stringBuffer.append(line);
							}
							br.close();
						}
					}

				}
			}
			zin.closeEntry();
		}catch (Exception e){
			logger.error(e);
			return  stringBuffer.toString();
		}
		return  stringBuffer.toString();

	}


	public static void main(String[] args) {
   String aa="#{stationSize}";
		System.out.println(aa.substring(aa.indexOf("{")+1,aa.indexOf("}")));
//		int rows = 5;
//		int cols = 5;
//
//		XWPFDocument document = new XWPFDocument();
//		XWPFTable table = document.createTable(rows, cols);
//
//		fillTable(table);
//
//		mergeCellsVertically(table, 3, 1, 3);
//
//		try {
//			FileOutputStream out = new FileOutputStream("d:\\verticalmerge.docx");
//			document.write(out);
//			out.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

	private static void fillTable(XWPFTable table) {
		for (int rowIndex = 0; rowIndex < table.getNumberOfRows(); rowIndex++) {
			XWPFTableRow row = table.getRow(rowIndex);

			for (int colIndex = 0; colIndex < row.getTableCells().size(); colIndex++) {
				XWPFTableCell cell = row.getCell(colIndex);
				cell.addParagraph().createRun().setText(" cell " + rowIndex + colIndex + " ");
			}
		}
	}






}
