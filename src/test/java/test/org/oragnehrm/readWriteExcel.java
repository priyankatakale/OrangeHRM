package test.org.oragnehrm;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import entities.EmployeeDetails;

public class readWriteExcel {

	public ArrayList<EmployeeDetails> getexcelData() throws IOException {

		FileInputStream f = new FileInputStream("C:\\Users\\Priyanka\\Desktop\\Testdata.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(f);
		XSSFSheet sheet = w.getSheet("test");

		int rowcount = sheet.getLastRowNum() - 1;
		System.out.println(rowcount);
		int columncount = sheet.getRow(1).getLastCellNum() - 1;
		System.out.println(columncount);
		ArrayList<EmployeeDetails> employeeList = new ArrayList<EmployeeDetails>();
		/*
		 * for (int i = 1; i < rowcount; i++) { EmployeeDetails e = new
		 * EmployeeDetails(); for (int j = 0; j <= columncount; j++) { XSSFCell cell =
		 * sheet.getRow(i).getCell(j); if (j == 0) { e.employeeName = cell.toString(); }
		 * if (j == 1) { e.employeeId = cell.toString(); } if (j == 2) {
		 * e.employmentStatus = cell.toString(); } if (j == 3) { e.include =
		 * cell.toString(); } if (j == 4) { e.supervisorName = cell.toString(); } if (j
		 * == 5) { e.jobTitle = cell.toString(); } if (j == 6) { e.subUnit =
		 * cell.toString(); }
		 * 
		 * } employeeList.add(e); }
		 */
		return employeeList;

	}

	public static String getcellData(int rownum, int colnum) throws IOException {
		FileInputStream f = new FileInputStream("C:\\Users\\Priyanka\\Desktop\\Testdata.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(f);
		XSSFSheet sheet = w.getSheet("test");
		try {
			XSSFCell cell = sheet.getRow(rownum).getCell(colnum);
			DataFormatter formatter = new DataFormatter();
			String celldata = formatter.formatCellValue(cell);

			return celldata;

		} catch (Exception e) {

		}
		return null;

	}

	public static void setcellData(String value, int rownum, int colnum) throws IOException {
		FileInputStream f = new FileInputStream("C:\\Users\\Priyanka\\Desktop\\Testdata.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(f);
		XSSFSheet sheet = w.getSheet("test");

		try {
			XSSFRow row = sheet.getRow(rownum);
			XSSFCell cell = row.getCell(colnum);
			if (cell == null) {
				cell = row.createCell(colnum);
				cell.setCellValue(value);
			} else {
				cell.setCellValue(value);
			}
		} catch (Exception e) {
			FileOutputStream fout = new FileOutputStream("C:\\Users\\Priyanka\\Desktop\\Testdata.xlsx");
			w.write(fout);
			fout.flush();
			fout.close();
		}
	}

}