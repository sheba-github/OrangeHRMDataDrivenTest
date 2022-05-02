package util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	
		XSSFWorkbook wb;
		XSSFSheet sheet;

		public String [][] passData(String excelpath, String sheetName) throws IOException{
			FileInputStream fis = new FileInputStream(excelpath);
			wb = new XSSFWorkbook(fis);
			sheet=wb.getSheet(sheetName);

			int rowCount=sheet.getLastRowNum();
			System.out.println(rowCount);
			int cellCount=sheet.getRow(0).getLastCellNum();
			System.out.println(cellCount);

			String data[][] = new String [rowCount][cellCount];

			for(int i=1; i<rowCount+1; i++) {
				Row r=sheet.getRow(i);

				for(int j=0; j<cellCount; j++) {
					System.out.println(data[i-1][j]=r.getCell(j).getStringCellValue());
				}
			}
				return data;
	}

	}


