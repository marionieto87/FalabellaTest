package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.RegisterPage;


public class RegisterTest {
	WebDriver driver;
	String driverPath = "..\\Falabella\\Drivers\\chromedriver.exe";
	String url = "https://www.falabella.com.co/falabella-co";
	
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
	
	/*Descripción: se va al login, click en registrarse y se diligencian todos los datos necesarios para
	 * poder registrarse en el pagina, da click en register y el usuario queda registrado en el sistema.
	 * */
	@Test
	public void register() {
		RegisterPage register = new RegisterPage(driver);
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.SECONDS);
		register.clickOnLogin();
		register.clickOnNewRegister();
		register.fillDataNewUser("Adriana", "Soto", "Cédula de Ciudadanía", "42058346", "3127842513", "adrimar_343@gmail.com", "Falabella123*");
		register.clickOnRegister();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
	
	
}
