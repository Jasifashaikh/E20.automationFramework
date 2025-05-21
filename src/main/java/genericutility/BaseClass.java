package genericutility;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;

/**
 * This class consists of Basic configuration annotations of Testng
 * @author Chaitra M
 *
 */
public class BaseClass {
	
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public FileUtility fUtil = new FileUtility();
	//for listeners
	public static WebDriver sdriver;
	
	public WebDriver driver;
	
	@BeforeSuite(alwaysRun=true)
	public void bsConfig()
	{
		System.out.println("------- Database Connection successful -------");
	}
	//@Parameters("browser")
 // @BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String Pvalue*/) throws IOException
	{
		String URL = fUtil.ReadDataFromPropertyFile("url");
		
		driver = new FirefoxDriver();
		//for cross browser execution - run time polymorphism
		//if(Pvalue.equals("edge")){
			//driver = new EdgeDriver();
			//}
		//else if(Pvalue.equals("chrome")) {
		//	driver = new ChromeDriver();
		//}
		//else {
		//	driver = new EdgeDriver();
		//}
		sUtil.maximizeWindow(driver);
		sUtil.addimplicitWait(driver);
		
		driver.get(URL);
		//for listeners
		sdriver = driver;
		
		System.out.println("------- Browser Launch successful -------");
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		String USERNAME = fUtil.ReadDataFromPropertyFile("username");
		String PASSWORD = fUtil.ReadDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("------- Login to App successful -------");
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApp();
		
		System.out.println("------- Logout of App successful -------");
	}
	//@AfterTest
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("------- Browser closure successful -------");
	}
	
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("------- Database closure successful -------");
	}
}