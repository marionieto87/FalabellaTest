package Tests;


import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;

public class HomeTest {
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
	
	
	/* Descripción: Instancia la nueva busqueda, busca el item Iphone, lo busca en la pagina
	 * y una vez se despliegan, va al carrito de compras y valida que allí esta el producto que se adiciono.*/
	@Test
	public void search() {
		HomePage item = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dy-lb-close")));
		driver.findElement(By.className("dy-lb-close")).click();
		//closeButton = driver.findElement(By.className("dy-lb-close"));
		//item.clickOnModal(closeButton);
		item.searchItem("iPhone");
		item.clickOnSearch();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		item.addToBasket();
		item.clickOnBasket();
	}
	
	
	/* Descripción: Cierra el navegador una ves se termina la prueba.*/
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
