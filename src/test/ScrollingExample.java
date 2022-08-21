package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);
		
		WebElement target = driver.findElement(By.xpath("//h2[text()='HTML Table Tags']"));
		
		JavascriptExecutor obj = (JavascriptExecutor)driver;
		obj.executeScript("arguments[0].scrollIntoView();", target);
	
		//Scroll Down
		
		obj.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		//Scroll UP
		
		obj.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform(); 
		
		//Scroll to Bottom
		
		act.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).build().perform();
		
	}

}
