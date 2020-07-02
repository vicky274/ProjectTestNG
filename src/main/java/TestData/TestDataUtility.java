package TestData;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestDataUtility {
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	
	public static void SetExcelFile(String path,String filename){
		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(filename);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	    public static String getCellData(int RowNum, int ColNum) throws Exception{

		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;

		} catch (Exception e) {

			return "";

		}
 }
	    
	    public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception {
	    	 
	        try{
	  
	            Row  = ExcelWSheet.getRow(RowNum);
	  
	            Cell = Row.getCell(ColNum);
	  
	  if (Cell == null) {
	  Cell = Row.createCell(ColNum);
	  Cell.setCellValue(Result);
	  } 
	  else{
	  Cell.setCellValue(Result);
	  }
	 
	   FileOutputStream fileOut = new FileOutputStream("");
	   ExcelWBook.write(fileOut);
	   fileOut.flush();
	   fileOut.close();
	  
	  }catch(Exception e){
	  
	  e.getMessage();
	  
	  }
	  
	  }
}
