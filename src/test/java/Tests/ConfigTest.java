package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigTest {
	WebDriver driver;
	String driverPathChrome = "..\\Falabella\\Drivers\\chromedriver.exe";
	String driverPathFirefox = "..\\Falabella\\Drivers\\geckodriver.exe";
	String chromeDriver = "webdriver.chrome.driver";
	//String firefoxDriver = "webdriver.gecko.driver";
	String url = "https://www.falabella.com.co/falabella-co";
	
	

	public WebDriver setUp() {
		System.setProperty(chromeDriver, driverPathChrome);
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
	}
}
