package genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


   public class SeleniumUtility<TakeScreeshot> {
	   /**
	    * This method maximize the window
	    * @param driver
	    */
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	/**
	 * This method minimize the window
	 * @param driver
	 */
   public void minimizWindow(WebDriver driver) {
	driver.manage().window().minimize();
		
	}
   /**
    * This method will add implicitwait for 10seconds
    * @param driver
    */
  public void addimplicitWait(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
}
  /**
   * This method wait 10 seconds element to be visible
   * @param driver
   * @param element
   */
  public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf(element));
	  
  }
  /**
   * This method wait 10 seconds element to be clikable
   * @param driver
   * @param element
   */
  public void waitForElementToBeClikable(WebDriver driver,WebElement element) {
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(element));
	  
  }
  /**
   * This method handle dropdown by value
   * @param element
   * @param index
   */
  public void handleDropDown(WebElement element,String value) {
	  Select sel = new Select(element);
	  sel.selectByValue(value);
  }
  /**
	 * This method will handle Dropdown by index
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
  /**
   * This method handle dropdown by visible text
   * @param element
   * @param index
   */
  public void handleDropDown(String visibleText,WebElement element) {
	  Select sel = new Select(element);
	  sel.selectByVisibleText(visibleText);
  }
  /**
   * This method used will perform mouse hovering action on webelement 
   * @param driver
   * @param element
   */
  public void mouseOverAction(WebDriver driver,WebElement element){
	  Actions act = new Actions(driver);
	  act.moveToElement(element).perform();
	  }
  
  /*
   * This method will perform drag and drop action on webelement
   * @param driver
   * @param element
   */
  public static void dragAndDrop(WebDriver driver, WebElement srcelement,WebElement tarElement ) {
      Actions act = new Actions(driver);
      act.dragAndDrop(srcelement,tarElement).perform();
      }
  /**
   * This method will perform right click action on Webelement
   * @param driver
   * @param element
   */
  public static void rightClickAction(WebDriver driver, WebElement element) {
      Actions act = new Actions(driver);
      act.contextClick(element).perform();
  }
  /*
   * This method perform double click action on Webelement
   * @param driver
   * @param element
   */
  public void doubleClickAction(WebDriver driver, WebElement element) {
	  Actions act = new Actions(driver);
	  act.doubleClick(element).perform();
	  
  }
  /*
   * This method perform scroll to particular Webelement
   * @param driver
   * @param element
   */
  public void scrollToElementActions(WebDriver driver, WebElement element) {
	  Actions act = new Actions(driver);
	  act.scrollToElement(element).perform();
	  
  }
  /*
   * This method switch to frame based on index
   * @param driver
   * @param index
   */
  public void handleframe(WebDriver driver, int index) {
	  driver.switchTo().frame(index);
  }
  /*
   * This method switch to frame based on name or ID
   * @param driver
   * @param index
   */
  public void handleframe(WebDriver driver, String nameorID) {
	  driver.switchTo().frame(nameorID);
  }
  /*
   * This method will switch to frame based on webelement
   * @param driver
   * @param index
   */
  public void handleframe(WebDriver driver, WebElement element) {
	  driver.switchTo().frame(element); 
  }
  /*
   * This method will switch the control to parent frame
   * @param driver
   * 
   */
  public void switchtoParentframe(WebDriver driver) { 
	  driver.switchTo().parentFrame(); 
	  } 
  
   /*
    *  This method will accept the alert popup 
    *  @param driver
    * 
    */
  public void acceptAlert(WebDriver driver) { 
	  driver.switchTo().alert().accept(); }
   
   /*
    *  This method will dismiss the alert popup 
    *   @param driver  
    * 
    */
   public void dismissAlert(WebDriver driver) { 
	   driver.switchTo().alert().dismiss(); }
   /*
    *  This method will get the alert text
    *  @param driver 
    *   @return
    * 
    */
   public String getAlertText(WebDriver driver) { 
	  return driver.switchTo().alert().getText(); } 
   /*
    *  This method will enter the data to alert popup
    *  @param driver
    * 
    */
   public void enterDataToAlert(WebDriver driver, String data) { 
	  driver.switchTo().alert().sendKeys(data); }
   /*
    * 
    * 
    * 
    */
   
   public String CaptureScreenShot(WebDriver driver,String screenshotName) throws IOException {
	   TakesScreenshot ts =(TakesScreenshot)driver;
	   File src = ts.getScreenshotAs(OutputType.FILE);
	   File dst = new File(".\\Screenshots"+screenshotName+".png");
	   FileHandler.copy(src,dst);
	   return dst.getAbsolutePath(); //For extent report
	   
	   
   }
  
 
   
   
   
   
   
   
   
   }
   
  
    
  


