package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);
		
		WebElement button1 = driver.findElement(By.id("alertButton"));
		button1.click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		WebElement button2 = driver.findElement(By.id("confirmButton"));
		JavascriptExecutor obj = (JavascriptExecutor)driver;
		obj.executeScript("arguments[0].scrollIntoView();", button2);
		button2.click();
		
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		
		WebElement button3 = driver.findElement(By.id("promtButton"));
		obj.executeScript("arguments[0].scrollIntoView();", button2);
		button3.click();
		
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Hello world");
		alert.accept();
	}

}
