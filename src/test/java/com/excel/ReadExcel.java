package com.excel;

import java.io.FileInputStream;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcel {
	public static String dir=System.getProperty("user.dir");
	public static void main(String[] args)throws Exception {
		FileInputStream fis=new FileInputStream(dir +"//Excelfile//Addressdata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet st=wb.getSheet("Sheet1");

	        int rows = st.getLastRowNum();
	        int cols = st.getRow(0).getLastCellNum();
	        for (int r = 0; r <= rows; r++) {
	            XSSFRow row = st.getRow(r);
	            for (int c = 0; c < cols; c++) {
	                XSSFCell cell = row.getCell(c);
				  switch (cell.getCellType()) {
                  case STRING:
                      System.out.print(cell.getStringCellValue());
                      break;
                  case NUMERIC:
                      System.out.print(cell.getNumericCellValue());
                      break;
                  case BOOLEAN:
                      System.out.print(cell.getBooleanCellValue());
                      break;
              }
              System.out.print("|");
          }
      }
      System.out.println();
	}

}
