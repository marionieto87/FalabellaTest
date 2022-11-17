package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import Pages.HomePage;
import Pages.InfoPersonalPage;
import Pages.LoginPage;

public class ChangePersonalDataTest {
	WebDriver driver;
	String driverPath = "..\\Falabella\\Drivers\\chromedriver.exe";
	String url = "https://www.falabella.com.co/falabella-co";
	private static WebElement closeButton = null;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void changeCellphone() {
		HomePage item = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dy-lb-close")));
		/*driver.findElement(By.className("dy-lb-close")).click();*/

		closeButton = driver.findElement(By.className("dy-lb-close"));
		item.clickOnModal(closeButton);
		
		LoginPage login = new LoginPage(driver);
		login.fillCredentials("marionieto87@hotmail.com", "imposible");
		login.clickOnLogin();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='testId-UserAction-userinfo']//div[@id='']")));
		driver.findElement(By.xpath("//li[@id='testId-UserAction-userinfo']//div[@id='']")).click();
		login.myAccount();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("testId-Input-firstName")));
		driver.findElement(By.id("testId-Input-firstName")).click();
		//driver.findElement(By.id("testId-Input-firstName")).clear();
		
		
		InfoPersonalPage phone = new InfoPersonalPage(driver);
		phone.changeNameUser("Carlos");
	}
	
	/* Descripción: Cierra el navegador una ves se termina la prueba.*/
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}