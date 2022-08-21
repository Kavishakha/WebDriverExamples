package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsnTabsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);
		
		String ParentWin = driver.getWindowHandle();
		System.out.println("Before clicking the tab button Window is: " + ParentWin);
		
		WebElement tab = driver.findElement(By.id("tabButton"));
//		JavascriptExecutor obj = (JavascriptExecutor)driver;
//		obj.executeScript("arguments[0].scrollIntoView();", tab);
		tab.click();
		
		System.out.println("After clicking the tab button: ");
		
		Set<String> allWins = driver.getWindowHandles();
		
		for (String win: allWins) {
			
			System.out.println(win);
			
			if(!win.equals(ParentWin)) {
				
				driver.switchTo().window(win);
			}
		}
		
		WebElement ChildHandler = driver.findElement(By.id("sampleHeading"));
		System.out.println(ChildHandler.getText());
		
		driver.switchTo().window(ParentWin);
		
		WebElement WinBtn = driver.findElement(By.id("windowButton"));
		WinBtn.click();
		
		driver.quit();
		
	}

}
