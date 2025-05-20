package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import ObjectRepository.LoginPage;
import genericutility.FileUtility;
import genericutility.JavaUtility;
import genericutility.SeleniumUtility;

public class AddProductToCartWithGU {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Create Object of all Utilities
				FileUtility fUtil = new FileUtility();
				JavaUtility jUtil = new JavaUtility();
				SeleniumUtility sUtil = new SeleniumUtility();
				// Read common Data
				String URL = fUtil.ReadDataFromPropertyFile("url");
				String USERNAME = fUtil.ReadDataFromPropertyFile("username");
				String PASSWORD = fUtil.ReadDataFromPropertyFile("password");
				// Read Data from excel file
				String PRODUCTNAME = fUtil.ReadDataFromExelSheet("Products", 1, 2); // Run time data

				// Launch the browser
				WebDriver driver  = new EdgeDriver();
				LoginPage lp = new LoginPage(driver);
				sUtil.maximizeWindow(driver);
				sUtil.addimplicitWait(driver);

				// Load the URL
				driver.get(URL);

				// Login to Application
				//driver.findElement(By.id("user-name")).sendKeys(USERNAME);
				//driver.findElement(By.id("password")).sendKeys(PASSWORD);
				//driver.findElement(By.id("login-button")).click();
				
				lp.getUsernameText().sendKeys(USERNAME);
				lp.getPasswordText().sendKeys(PASSWORD);
				lp.getLoginBtn().click();
				

				// Click on a product - Tshirt - Dynamic xpath
				WebElement ele = driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']"));
				String productname = ele.getText();
			     ele.click();

				// Click on add to cart
				driver.findElement(By.id("add-to-cart")).click();
				
				//Capture screenshot
				String screenshotName = "addProductToCart-"+jUtil.getSystemDateInFormat();
				String path = sUtil.CaptureScreenShot(driver, screenshotName);
				System.out.println(path);

				// Navigate to Cart
				driver.findElement(By.id("shopping_cart_container")).click();

				// Validate the product in Cart
				String productIncart = driver.findElement(By.className("inventory_item_name")).getText();
				if (productIncart.equals(productname)) {
					System.out.println("PASS");
					System.out.println(productIncart);
				} else {
					System.out.println("FAIL");
				}

				// Logout of Application
				driver.findElement(By.id("react-burger-menu-btn")).click();
				driver.findElement(By.linkText("Logout")).click();

	}

}
