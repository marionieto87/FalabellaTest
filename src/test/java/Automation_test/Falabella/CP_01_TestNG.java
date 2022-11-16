package Automation_test.Falabella;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CP_01_TestNG {
	WebDriver driver;
	String driverPath = "..\\Falabella\\Drivers\\chromedriver.exe";
	String url = "https://www.falabella.com.co/falabella-co";

	
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void verificarTitulo() {
		String tituloEsperado="Lo encontré en Falabella.com";
		String tituloObtenido=driver.getTitle();
		assertEquals(tituloEsperado, tituloObtenido);
	}
	
	@Test
	public void loginFailed() {
		//Search element
		
		//driver.findElement(By.id("testId-HamburgerBtn-toggle")).click();		
		/*driver.findElement(By.xpath("//input[@id='testId-cc-login-form-email-input']")).sendKeys("marionieto87@gmail.com");
		driver.findElement(By.xpath("//input[@id='testId-cc-login-form-password-input']")).sendKeys("imposibles");
		driver.findElement(By.xpath("//button[@id='testId-cc-login-form-submit']")).click();	*/
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.SECONDS);
		driver.findElement(By.className("dy-modal-backdrop lb_overlay js_lb_overlay")).click();
		//driver.manage().timeouts().implicitlyWait(60000, TimeUnit.SECONDS);
		driver.findElement(By.id("testId-SearchBar-Input")).sendKeys("Iphone");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("SearchBar-module_searchBtnIcon__6KVum")).click();

		driver.findElement(By.xpath("//div[@id='']")).click();
		
	}


	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}
