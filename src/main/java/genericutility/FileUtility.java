package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists generic utility methods
 * @author hap
 *
 */
public class FileUtility {
	/**
	 * This Method Read Data From Property File and Return The Value
	 * caller
	 * @param key
	 * @return
	 * @throws IOException 
	 * @throws 
	 * @throws IOexception
	 */
	public String  ReadDataFromPropertyFile(String key) throws IOException{
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
		}
	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws IOException
	 */
	public String ReadDataFromExelSheet(String sheetName,int rowNo,int cellNo) throws IOException{
		FileInputStream f = new FileInputStream(".\\src\\test\\resources\\AdvanceTestCase.xlsx");
		Workbook wb = WorkbookFactory.create(f);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	
	}
	
   
}
