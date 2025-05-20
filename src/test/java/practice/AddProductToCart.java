package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		 driver.findElement(By.name("password")).sendKeys("secret_sauce");
	   driver.findElement(By.name("login-button")).click();
	  String ProductToBeAdded = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
      driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
      driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
	  driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	 WebElement ProductInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
	 if(ProductInCart.equals(ProductToBeAdded)) {
		 System.out.println("PASS");
		 System.out.println("ProductInCart");
	 }
	 else {
		 System.out.println("FAIL");
	 }
	  
	  
	

	}

}
