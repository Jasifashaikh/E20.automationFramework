package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

import ObjectRepository.LoginPage;
import genericutility.FileUtility;
import genericutility.JavaUtility;
import genericutility.SeleniumUtility;

public class AddLowestPricedProductToCartUsingDDT {


	

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

		//Create Object of All Utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		JavaUtility jUtil = new JavaUtility();
		
		// Read required Data
		// Property file - common Data
		String URL = fUtil.ReadDataFromPropertyFile("url");
		String USERNAME = fUtil.ReadDataFromPropertyFile("username");
		String PASSWORD = fUtil.ReadDataFromPropertyFile("password");

		// Read Test Data From Excel File
		String SORTOPTION = fUtil.ReadDataFromExelSheet("Products", 7, 2);
		String PRODUCTNAME = fUtil.ReadDataFromExelSheet("Products", 7, 3);
		System.out.println(PRODUCTNAME);
		System.out.println(SORTOPTION);

		// Launch the browser
		WebDriver driver = new ChromeDriver();
		
		LoginPage lp = new LoginPage(driver);
		//WebDriver driver = new ChromeDriver();
		sUtil.maximizeWindow(driver); 
		sUtil.addimplicitWait(driver);

		// Load the Application
		driver.get(URL);

		// Login to Application
		//driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		//driver.findElement(By.id("password")).sendKeys(PASSWORD);
		//driver.findElement(By.name("login-button")).click();
		
		lp.getUsernameText().sendKeys(USERNAME);
		lp.getPasswordText().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		

		// Sort the page for lowest Price
		WebElement prodSort = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		sUtil.handleDropDown(SORTOPTION, prodSort);

		Thread.sleep(1000);

		// Click on the Lowest price Product
		WebElement Product = driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']"));
		String productToBeAdded = Product.getText();
		//Product.click();

		// Add the product To Cart
		driver.findElement(By.id("add-to-cart")).click();

		// Navigate To Cart and Validate
		driver.findElement(By.id("shopping_cart_container")).click();

		// Validate
		String productInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if (productToBeAdded.equals(productInCart)) {
			System.out.println("PASS");
			System.out.println(productInCart);
		} else {
			System.out.println("FAILS");
		}

		// Logout of Application
		driver.findElement(By.xpath("//button[.='Open Menu']")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	}

				