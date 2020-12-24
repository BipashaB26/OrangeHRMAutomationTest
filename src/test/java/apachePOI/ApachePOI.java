package apachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ApachePOI {

	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\LENOVO\\Desktop\\orangeLogin.xlsx"));
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		DataFormatter formatter = new DataFormatter();
		Cell cell1 = sheet.getRow(0).getCell(0);
		Cell cell2 = sheet.getRow(0).getCell(1);
		String username = formatter.formatCellValue(cell1);
		String password = formatter.formatCellValue(cell2);
		System.out.println(username);
		System.out.println(password);
	}

}
