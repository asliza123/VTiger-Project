package com.crm.GenricUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Meghana
 *
 */
public class ExcelUtility {
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param CellNum
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
    public String getDataFromExcel(String sheetName, int rowNum, int CellNum) throws EncryptedDocumentException, IOException {
    	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData\\Testdata template.xlsx");
    	Workbook wb = WorkbookFactory.create(fis);
    	String exceldata = wb.getSheet(sheetName).getRow(rowNum).getCell(CellNum).getStringCellValue();
    	wb.close();
    	return exceldata;
    }
    /**
     * used to fetch data from excel
     * @throws IOException 
     * @throws EncryptedDocumentException 
     */
    
    /**
     * 
     * @param sheetName
     * @return
     * @throws EncryptedDocumentException
     * @throws IOException
     */
    public int getRowCountFromExcel(String sheetName) throws EncryptedDocumentException, IOException {
    	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData\\Testdata template.xlsx");
    	Workbook wb = WorkbookFactory.create(fis);
    	Sheet sheet = wb.getSheet(sheetName);
    	wb.close();
    	return sheet.getLastRowNum();
    }
    /**
     * used to get last row count in excel
     */
    
    
    /**
     * 
     * @param sheetName
     * @param rowNum
     * @param cellNum
     * @param data
     * @throws EncryptedDocumentException
     * @throws IOException
     */
    
    public void setDatatoExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException {
    	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData\\Testdata template.xlsx");
    	Workbook wb = WorkbookFactory.create(fis);
    	wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
    	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData\\Testdata template.xlsx");
    	wb.write(fos);
    	wb.close();
    }
    
    /**
     * used to set cell value in excel
     */ 
    
}




