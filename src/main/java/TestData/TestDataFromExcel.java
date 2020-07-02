package TestData;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataFromExcel {

	private static XSSFSheet ExcelWSheet,sheet;
	private static XSSFWorkbook ExcelWBook,workbook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static final String path="./src/test/resources/TestData/TestData.xlsx";
	
	
	public static void SetExcelFile(String path,String filename){
		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(filename);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	 public static Object[][] getCellData(String filename) throws Exception{
		 Object[][] obj = null;
		 try {
			 
				FileInputStream ExcelFile = new FileInputStream(path);
				workbook = new XSSFWorkbook(ExcelFile);
				sheet = workbook.getSheet(filename);
				
				int rowcount =sheet.getPhysicalNumberOfRows();
				
				System.out.println("Physical rows :"+rowcount);
				
				int rowcount1 =sheet.getLastRowNum();
				
				System.out.println("last rows :"+rowcount1);
				
				Row  = sheet.getRow(0);
				
				int cellcount = Row.getPhysicalNumberOfCells();
				System.out.println("Column Count:"+cellcount);
				
				int lastcellcount = Row.getLastCellNum();
				System.out.println("Last Column Count:"+lastcellcount);
				
				obj=new Object[rowcount1][lastcellcount];
				
				for(int i=1;i<rowcount;i++){
					
					Row = sheet.getRow(i);
					
					for(int j=0;j<cellcount;j++){
						Cell =Row.getCell(j);
						
						switch(Cell.getCellType())   
						{
	                    case STRING:
	                    	 obj[i-1][j]=Cell.getStringCellValue();
	                    	 System.out.println(obj[i-1][j]);
	                        break;
	                    case NUMERIC:
	                    	if (DateUtil.isCellDateFormatted(Cell)) {
	                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
	                            System.out.println(dateFormat.format(Cell.getDateCellValue()) + " -Date Cell");
	                        }
	                    	else{
	                    	 //System.out.println(Cell.getNumericCellValue());
	                    	 obj[i-1][j]=Cell.getNumericCellValue();
	                    	 System.out.println(obj[i-1][j]);
	                    	}
	                        break;
	                    case BOOLEAN:
	                        //System.out.println(Cell.getBooleanCellValue());
	                        obj[i-1][j]=Cell.getBooleanCellValue();
	                        System.out.println(obj[i-1][j]);
	                        break;
						default:
							//Cell.setCellType(CellType.STRING);
							System.out.println(Cell.getStringCellValue());
							break;
	                    }
					
				}}
				
				
		 }
				
			 catch (Exception e) {
				e.getMessage();
			}
		 
		return obj;

	 }
	 
	 public String dateformatter(int j){
		 DataFormatter dataFormatter = new DataFormatter();
		 String cellStringValue = dataFormatter.formatCellValue(Row.getCell(j));
		 System.out.println ("Is shows data as show in Excel file" + cellStringValue);
		return cellStringValue;  
	 }
	   
	 public static void setCellData(String filename) throws Exception{
		 Object[][] obj = null;
		 try {
			 
				//FileInputStream ExcelFile = new FileInputStream(path);
				workbook = new XSSFWorkbook();
				sheet = workbook.createSheet(filename);
				
				
				 Object[][] bookData = {
			                {"Head First Java", "Vignesh", 79},
			                {"Effective Java", "Jack", 36},
			                {"Clean Code", "William", 42},
			                {"Thinking in Java", "John", 35},
			        };
			 
			        int rowCount = 0;
			         
			        for (Object[] aBook : bookData) {
			            Row row = sheet.createRow(rowCount++);
			             
			            int columnCount = 0;
			             
			            for (Object field : aBook) {
			                Cell  cell= row.createCell(columnCount++);
			                if (field instanceof String) {
			                    cell.setCellValue((String) field);
			                } else if (field instanceof Integer) {
			                    cell.setCellValue((Integer) field);
			                }
			            }
			             
			        }
			         
			         
			        try (FileOutputStream outputStream = new FileOutputStream(path)) {
			            workbook.write(outputStream);
			            outputStream.flush();
			            outputStream.close();
			            System.out.println("Written Excel Data Successfully");
			        }
				
		 }
				
			 catch (Exception e) {
				e.getMessage();
			}
		 
		

	 }
	 
	 public static void setCellDatafrommapvalue(String filename) throws Exception{
		 Object[][] obj = null;
		 try {
			 
				//FileInputStream ExcelFile = new FileInputStream(path);
				workbook = new XSSFWorkbook();
				sheet = workbook.getSheet(filename);
				
				Map<String, Object[]> data = new LinkedHashMap<String, Object[]>();
		        data.put("1", new Object[]{"Year", "WinnerCountryName", "LosserCountryName","By"});
		        data.put("2", new Object[]{"1975", "WestInddies", "Australia","17 Run"});
		        data.put("3", new Object[]{"1979", "WestInddies", "England","92 Run"});
		        
		        Set<String> keyset = data.keySet();
		        int rowCount = 0;
		        for(String key:keyset){
		        	Object[] rowdata = data.get(key);
		        	 Row row = sheet.createRow(rowCount++);
		        	 
		        	 int columnCount = 0;
		        	 for(Object celldata: rowdata){
		        		 Cell  cell= row.createCell(columnCount++);
			                if (celldata instanceof String) {
			                    cell.setCellValue((String) celldata);
			                } else if (celldata instanceof Integer) {
			                    cell.setCellValue((Integer) celldata);
			                }
		        	 }
		        }
			             
			        try (FileOutputStream outputStream = new FileOutputStream(path)) {
			            workbook.write(outputStream);
			            outputStream.flush();
			            outputStream.close();
			            System.out.println("Written Excel Data Successfully");
			        }
				
		 }
				
			 catch (Exception e) {
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
