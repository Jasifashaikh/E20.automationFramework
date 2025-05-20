package genericutility;


import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class consist of generic methods related to java
 * @author hap
 */

public class JavaUtility {
	/**
	 * This method will capture current system date and return caller 
	 * 
	 * Used to name  screenshot and report
	 * @return
	 */
	
	public String getSystemDateInFormat() {
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date = f.format(d);
		return date;
	}

}
