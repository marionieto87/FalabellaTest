package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;

public class LoginTest {
	WebDriver driver;
	String driverPath = "..\\Falabella\\Drivers\\chromedriver.exe";
	String url = "https://www.falabella.com.co/falabella-co";
	private static WebElement closeButton = null;
	
	/*Titulo: Prueba de automatización.
	 * Autor: Carlos Mario Nieto.
	 * Descripción: Lanza el navegador Google Chrome, maximiza la ventana y
	borra todos las cookies.*/
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	/*Titulo: Prueba de automatización.
	 * Autor: Carlos Mario Nieto.
	 * Descripción: El usuario espera un tiempo y despues va al boton de inicio de sesión, digita las credenciales y se 
	 * loguee exitosamente en el sistema*/
	@Test
	public void login() {
		HomePage item = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dy-lb-close")));
		//driver.findElement(By.className("dy-lb-close")).click();
		closeButton = driver.findElement(By.className("dy-lb-close"));
		item.clickOnModal(closeButton);
		LoginPage login = new LoginPage(driver);
		login.fillCredentials("marionieto87@hotmail.com", "Imposible87*");
		login.clickOnLogin();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='testId-UserAction-userinfo']//div[@id='']")));
		driver.findElement(By.xpath("//li[@id='testId-UserAction-userinfo']//div[@id='']")).click();
		login.myAccount();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[3]/div[1]/div[4]/ul[1]/li[1]/div[1]/div[2]")));
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[4]/ul[1]/li[1]/div[1]/div[2]")).click();
		String currentUrl = driver.getCurrentUrl();
		String ExpectedUrl = "https://www.falabella.com.co/falabella-co/myaccount/userPersonalInformation";
		Assert.assertEquals(ExpectedUrl, currentUrl, "Credenciales correctas");
		System.out.println("El usuario inicio sesion con éxito.");
		
	}

	
	/* Descripción: Cierra el navegador una ves se termina la prueba.*/
	@AfterSuite
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
