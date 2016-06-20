package DDFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadExcel {

	public static void main(String[] args) throws FileNotFoundException {
		String filePath = "D:\\Testing (Selenium)\\Excel File\\TestData.xls";
		FileInputStream fs = new FileInputStream(filePath);
		//Workbook wb = Workbook.getWorkbook(fs);
		
	}

}
