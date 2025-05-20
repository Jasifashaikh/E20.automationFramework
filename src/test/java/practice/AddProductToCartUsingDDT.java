package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProductToCartUsingDDT {

	public static void main(String[] args) throws IOException, InterruptedException {
		 
		 FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		 Properties p = new Properties();
		 p.load(fis);
		 String URL = p.getProperty("url");
		 String USERNAME = p.getProperty("username");
		 String PASSWORD = p.getProperty("password");
		 WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		 driver.get(URL);
		 driver.findElement(By.id("user-name")).sendKeys(USERNAME);
			//Thread.sleep(2000);
		 driver.findElement(By.name("password")).sendKeys(PASSWORD);
			//Thread.sleep(2000);
		 driver.findElement(By.name("login-button")).click();
		 // fetch exel data 
		 FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\AdvanceTestCase.xlsx");
		 Workbook wb = WorkbookFactory.create(fise);
		 Sheet s =wb.getSheet("Products");
		 Row rw = s.getRow(1);
		 Cell c1 = rw.getCell(2);
		 String PRODUCTNAME = c1.getStringCellValue();
		//Launch the browser
			
					
			
			
			//Click on a product - Tshirt - Dynamic xpath
			WebElement ele = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
			String productname = ele.getText();
			ele.click();
			
			//Click on add to cart
			driver.findElement(By.id("add-to-cart")).click();
			
			//Navigate to Cart
			driver.findElement(By.id("shopping_cart_container")).click();
			
			//Validate the product in Cart
			String productIncart = driver.findElement(By.className("inventory_item_name")).getText();
			if(productIncart.equals(productname))
			{
				System.out.println("PASS");
				System.out.println(productIncart);
			}
			else
			{
				System.out.println("FAIL");
			}
			
			//Logout of Application
			driver.findElement(By.id("react-burger-menu-btn")).click();
			driver.findElement(By.linkText("Logout")).click();
	}
	}


		 
    
		
	


