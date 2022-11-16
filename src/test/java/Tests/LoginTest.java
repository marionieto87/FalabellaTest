package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest {
	WebDriver driver;
	String driverPath = "..\\Falabella\\Drivers\\chromedriver.exe";
	String url = "https://www.falabella.com.co/falabella-co";
	
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
	 * Descripción: El usuario espera un tiempo y despues va al boton de inicio de sesion, digita las credenciales y se 
	 * logue exitosamente en el sistema*/
	@Test
	public void login() {
		LoginPage login = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.SECONDS);
		login.fillCredentials("marionieto87@hotmail.com", "imposible");
		login.clickOnLogin();
	}

	
	/* Descripción: Cierra el navegador una ves se termina la prueba.*/
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
