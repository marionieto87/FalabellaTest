package Automation_test.Falabella;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CP_01 {
	String driverPath = "..\\Falabella\\Drivers\\chromedriver.exe";
	String url = "https://www.falabella.com.co/falabella-co";
	
	
	@Test
	public void searchItem() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Search element
		driver.findElement(By.id("testId-SearchBar-Input")).sendKeys("Iphone");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("SearchBar-module_searchBtnIcon__6KVum")).click();

		driver.findElement(By.xpath("//div[@id='']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.close(); //closes the browser
		
	}
	

}
