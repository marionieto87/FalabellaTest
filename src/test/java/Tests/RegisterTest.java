package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.RegisterPage;
import org.openqa.selenium.WebElement;

public class RegisterTest {
	WebDriver driver;
	String driverPath = "..\\Falabella\\Drivers\\chromedriver.exe";
	String url = "https://www.falabella.com.co/falabella-co";
	private static WebElement closeButton = null;
	
	/*Titulo: Prueba de automatización.
	 * Autor: Carlos Mario Nieto.
	 * Descripción: Lanza el navegador Google Chrome o Firefox, maximiza la ventana y
	borra todos las cookies.*/
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	/*Descripción: Usuario nuevo se registra, va al login, click en registrarse y se diligencian todos los datos necesarios para
	 * poder registrarse en el pagina, da click en register y el usuario queda con un usuario registrado
	 * en el sistema.
	 * */
	@Test
	public void register() {
		RegisterPage register = new RegisterPage(driver);
		HomePage item = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dy-lb-close")));
		//driver.findElement(By.className("dy-lb-close")).click();
		
		closeButton = driver.findElement(By.className("dy-lb-close"));
		item.clickOnModal(closeButton);
		
		register.clickOnLogin();
		register.clickOnNewRegister();
		register.fillDataNewUser("Adriana", "Soto", "Cédula de Ciudadanía", "42058346", "3127842513", "adrimar7543@gmail.com", "Falabella123*");
		register.clickOnRegister();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
	
	
}
