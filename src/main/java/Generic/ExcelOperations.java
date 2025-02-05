package Generic;

import java.io.File;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet ;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {
	
	 static String filePath;
	 static Sheet sheet;
	public ExcelOperations(String sheetName) {
		try {
			filePath = System.getProperty("user.dir")+PropertiesOperations.getPropertyByKey("testDataLocation");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		File testDataFile = new File(filePath);
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(testDataFile);
		} catch (Exception e) {

			e.printStackTrace();
		}
		sheet= wb.getSheet(sheetName);
	}
	
	// read and load data from excel sheet
	public HashMap<String, String> getTestDataInMap(int rowNumber) throws Exception {
		HashMap<String, String> mp = new HashMap<String, String>();
		
		for(int i=0; i<sheet.getRow(0).getLastCellNum(); i++) {
			sheet.getRow(rowNumber).getCell(i).setCellType(CellType.STRING);
			mp.put(sheet.getRow(0).getCell(i).toString(), sheet.getRow(rowNumber).getCell(i).toString());
		}
		return mp;
	}
	
	// rowcount
	public int getRowCount() {
		return sheet.getLastRowNum();
	}
	
	// column count
	public int getColumnCount() {
		return sheet.getRow(0).getLastCellNum();
	}
}
