package InventoryTests;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;
import genericutility.BaseClass;
import genericutility.FileUtility;
import genericutility.JavaUtility;
import genericutility.SeleniumUtility;
@Listeners(genericutility.ListenerImplementation.class)
public class AddLowestPriceProductToCartTest extends BaseClass{
   
	@Test(groups="Regresssionsuite")
	
	public void tc_02_AddLowestPriceProductToCartTest() throws IOException

	 {

		// Create Object of all Utilities
		//FileUtility fUtil = new FileUtility();
		//JavaUtility jUtil = new JavaUtility();
		//SeleniumUtility sUtil = new SeleniumUtility();

		// Read common Data
		//String URL = fUtil.ReadDataFromPropertyFile("url");
		//String USERNAME = fUtil.ReadDataFromPropertyFile("username");
		//String PASSWORD = fUtil.ReadDataFromPropertyFile("password");

		// Read Data from excel file
		String PRODUCTNAME = fUtil.ReadDataFromExelSheet("Products", 2, 0); // Run time data
		String SORTOPTION = fUtil.ReadDataFromExelSheet("Products", 2, 2);
		System.out.println(PRODUCTNAME);
		System.out.println(SORTOPTION);
		
		// Launch the browser
		//WebDriver driver = new EdgeDriver();
		//sUtil.maximizeWindow(driver);
		//sUtil.addimplicitWait(driver);

		// Load the URL
		//driver.get(URL);

		// Login to Application
	//	LoginPage lp = new LoginPage(driver);
		//lp.loginToApp(USERNAME, PASSWORD);

		// Click on a product
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnLowestPriceProduct(driver, SORTOPTION, PRODUCTNAME);

		// Click on add to cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCatBtn();

		// Navigate to Cart
		ip.clickOnCartContainer();

		// Validate the product in Cart
		CartPage cp = new CartPage(driver);
		String ProductIncart = cp.captureItemName();
		Assert.assertEquals(ProductIncart,PRODUCTNAME);
		Assert.assertTrue(ProductIncart.equals(PRODUCTNAME)); 
		//if (ProductIncart.equals(PRODUCTNAME)) {
			//System.out.println("PASS");
			//System.out.println(ProductIncart);
		//} else {
		//	System.out.println("FAIL");
		//}

		// Logout of Application
		//ip.logoutOfApp();
	}

}	