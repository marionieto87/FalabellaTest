package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.HomePage;
import Pages.InfoPersonalPage;
import Pages.LoginPage;
import Pages.RegisterPage;

public class ExtentReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driverPath = "..\\Falabella\\Drivers\\chromedriver.exe";
		String url = "https://www.falabella.com.co/falabella-co";
		WebDriver driver;
		WebElement closeButton = null;
		
		//Se crea el objeto
	    ExtentReports extent = new ExtentReports();
	    ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
        extent.attachReporter(spark);
        
        	
        /*Se crea el test Numero 1
         * TC01 > Agregar un articulo al carro de compra con usuario no logueado.
         */
        ExtentTest test1 = extent.createTest("TC01");
        //Se inicia el navegador Chrome y se la la URL a la que se debe dirigir.
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		test1.log(Status.INFO, "Starting Test Case 01");
		HomePage item = new HomePage(driver);
		
		//Se inicia un explicit wait para esperar la ventana emergente y cerrarla.
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dy-lb-close")));
		closeButton = driver.findElement(By.className("dy-lb-close"));
		item.clickOnModal(closeButton);
		/*Se digita la palabra Iphone en la barra de navegacion y se busca
		 * y se arrojan todos los resultados y se selecciona el primero.*/
		test1.pass("Se cerro la ventana modal exitosamente.");
		item.searchItem("iPhone");
		test1.pass("se digito la palabra Iphone correctamente.");
		item.clickOnSearch();
		test1.pass("Busqueda de elemento Iphone exitosa.");
		item.addToBasket();
		//Se inicia un explicit wait para esperar el boton de agregar al carrito.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='linkButton']")));
		driver.findElement(By.xpath("//a[@id='linkButton']")).click();
		test1.pass("Item añadido correctamente al carrito de compras.");
		/*Se obtiene el titulo del elemento fb-product__title y se compara con el
		 * titulo esperado para validar que si se adiciono correctamente
		 * el artículo al carrito de compras*/
		String ActualTitle = driver.findElement(By.className("fb-product__title")).getText();
		String ExpectedTitle = "iPhone 11 128 GB";
		Assert.assertEquals(ExpectedTitle, ActualTitle, "El Producto se agrego al carrito");
		test1.pass("Se valida que el producto se añadio correctamente al carrito.");
		
		//Se cierra el navegador y la sesion en el servidor.
		driver.close();
		driver.quit();
		System.out.println("El producto se añadio correctamente al carrito de compra.");
		test1.info("TC01 completed.");
		
		
		
        /*Se crea el test Numero 2
         * TC02 > Usuario registrado se loguea exitosamente.
         */
		ExtentTest test2 = extent.createTest("TC02");
		//Se inicia el navegador Chrome y se la la URL a la que se debe dirigir.
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		test2.log(Status.INFO, "Starting Test Case 02");
		HomePage item2 = new HomePage(driver);
		
		//Se inicia un explicit wait para esperar la ventana emergente y cerrarla.
		WebDriverWait wait2 = new WebDriverWait(driver,20);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("dy-lb-close")));
		closeButton = driver.findElement(By.className("dy-lb-close"));
		item2.clickOnModal(closeButton);
		test2.pass("Se cerro la ventana modal exitosamente.");
		/*Se instancia la clase login para diligenciar las credenciales
		 * y poder iniciar sesion exitosamente en la pagina
		 */
		LoginPage login = new LoginPage(driver);
		login.fillCredentials("marionieto87@hotmail.com", "Imposible87*");
		test2.pass("Usuario digita las credenciales para loguearse.");
		login.clickOnLogin();
		//Se inicia un explicit wait esperando el login exitoso del usuario y se le da click.
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='testId-UserAction-userinfo']//div[@id='']")));
		driver.findElement(By.xpath("//li[@id='testId-UserAction-userinfo']//div[@id='']")).click();
		login.myAccount();
		test2.pass("El usuario se logue satisfactoriamente en el sistema");
		/*Se inicia un explicit wait para esperar que el usuario logueado
		 * pueda ir al perfil para validar que si ingreso correctamente.
		 */
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[3]/div[1]/div[4]/ul[1]/li[1]/div[1]/div[2]")));
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[4]/ul[1]/li[1]/div[1]/div[2]")).click();
		/*Se obtiene la URL actual de la pagina para validar con la esperada
		 * y verificar el ingreso satisfactorio del usuario.
		 */
		String currentUrl = driver.getCurrentUrl();
		String ExpectedUrl = "https://www.falabella.com.co/falabella-co/myaccount/userPersonalInformation";
		Assert.assertEquals(ExpectedUrl, currentUrl, "Credenciales correctas");
		System.out.println("El usuario inicio sesion con éxito.");
		
		//Se cierra el navegador y la sesion en el servidor.
		driver.close();
		driver.quit();
		System.out.println("El producto se añadio correctamente al carrito de compra");
		test2.info("TC02 completed.");
		
		
		
        /*Se crea el test Numero 3
         * TC03 > Usuario se loguea con credenciales incorrectas.
         */
		ExtentTest test3 = extent.createTest("TC03");
		//Se inicia el navegador Chrome y se la la URL a la que se debe dirigir.
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		test3.log(Status.INFO, "Starting Test Case 03");
		HomePage item3 = new HomePage(driver);
		
		//Se inicia un explicit wait para esperar la ventana emergente y cerrarla.
		WebDriverWait wait3 = new WebDriverWait(driver,20);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.className("dy-lb-close")));
		closeButton = driver.findElement(By.className("dy-lb-close"));
		item3.clickOnModal(closeButton);
		test3.pass("Se cerro la ventana modal exitosamente.");
		/*Se instancia la clase loginFailed para diligenciar las credenciales incorrectas
		 * y poder validar que no permita el ingreso del usuario.
		 */
		LoginPage loginFailed = new LoginPage(driver);
		test3.pass("Se digitan las credenciales incorrectas.");
		loginFailed.fillCredentials("adrimar_333@hotmail.com", "f6158d6fa");
		loginFailed.clickOnLogin();
		/*Se inicia un explicit wait para esperar el mensaje de que los 
		 * datos son incorrectos.
		 */
		test3.pass("Se espera el mensaje de contraseña incorrecta.");
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-form-module_form-alerts__1Bkgp")));
		driver.findElement(By.className("login-form-module_form-alerts__1Bkgp"));
		/*Se obtiene el mensaje de que los datos son incorrectos 
		 * y se valida con el mensaje esperado.
		 */
		String ActualTitle3 = driver.findElement(By.className("login-form-module_form-alerts__1Bkgp")).getText();
		String ExpectedTitle3 = "Correo electrónico o contraseña incorrecta. Por favor, vuelve a intentarlo nuevamente.";
		Assert.assertEquals(ExpectedTitle3, ActualTitle3, "Credenciales incorrectas");
		test3.pass("Se valida el mensaje correcto de: Correo electrónico o contraseña incorrecta.");
		System.out.println("El usuario no pudo iniciar sesion por que digito credenciales incorrectas.");
		
		//Se cierra el navegador y la sesion en el servidor.
		driver.close();
		driver.quit();
		System.out.println("El usuario no se logueo por que no digito las credenciales correctas.");
		test3.info("TC03 completed.");
		
		
		
        /*Se crea el test Numero 4
         * TC04 > Usuario nuevo se registra satisfactoriamente en el sistema.
         */
		ExtentTest test4 = extent.createTest("TC04");
		//Se inicia el navegador Chrome y se la la URL a la que se debe dirigir.
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		test4.log(Status.INFO, "Starting Test Case 04");
		HomePage item4 = new HomePage(driver);
		
		//Se inicia un explicit wait para esperar la ventana emergente y cerrarla.
		WebDriverWait wait4 = new WebDriverWait(driver,40);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.className("dy-lb-close")));
		closeButton = driver.findElement(By.className("dy-lb-close"));
		item4.clickOnModal(closeButton);
		test4.pass("Se cerro la ventana modal exitosamente.");
		/*Se instancia la clase register para diligenciar los datos solicitados
		 * para el registro de un usuario nuevo.
		 */		
		RegisterPage register = new RegisterPage(driver);
		register.clickOnLogin();
		register.clickOnNewRegister();
		register.fillDataNewUser("Adriana", "Soto", "Cédula de Ciudadanía", "42058346", "3127842513", "jewipiy234@jernang.com", "Falabella123*");
		test4.pass("Se llenaron todos los datos requeridos y se aceptan las condiciones.");
		register.clickOnRegister();
		test4.pass("Se espera el mensaje de que el usuario se creo correctamente.");

		System.out.println("El usuario fue creado exitosamente.");
		
		//Se cierra el navegador y la sesion en el servidor.
		driver.close();
		driver.quit();
		System.out.println("El usuario se logro registrar exitosamente en el sistema.");
		test4.info("TC04 completed.");
		
		
		
        /*Se crea el test Numero 5
         * TC05 > Usuario nuevo se registra satisfactoriamente en el sistema.
         */
		ExtentTest test5 = extent.createTest("TC05");
		//Se inicia el navegador Chrome y se la la URL a la que se debe dirigir.
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		test5.log(Status.INFO, "Starting Test Case 04");
		HomePage item5 = new HomePage(driver);
		//Se inicia un explicit wait para esperar la ventana emergente y cerrarla.
		WebDriverWait wait5 = new WebDriverWait(driver,20);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.className("dy-lb-close")));
		closeButton = driver.findElement(By.className("dy-lb-close"));
		item5.clickOnModal(closeButton);
		test5.pass("Se cerro la ventana modal exitosamente.");
		/*Se instancia la clase login5 para iniciar sesion en el sistema
		 */		
		LoginPage login5 = new LoginPage(driver);
		login5.fillCredentials("marionieto87@hotmail.com", "Imposible87*");
		login5.clickOnLogin();
		test5.pass("Se inicio sesion correctamente en el sistema.");
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='testId-UserAction-userinfo']//div[@id='']")));
		driver.findElement(By.xpath("//li[@id='testId-UserAction-userinfo']//div[@id='']")).click();
		login5.myAccount();
		
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("testId-Input-firstName")));
		driver.findElement(By.id("testId-Input-firstName")).click();
		
		InfoPersonalPage changes = new InfoPersonalPage(driver);
		changes.changeNameUser(" Mario");
		changes.saveChanges();
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Cambios guardados con éxito')]")));
		driver.findElement(By.xpath("//h1[contains(text(),'Cambios guardados con éxito')]"));
		/*Se obtiene el mensaje del elemento indicando que los cambios fueron guardados
		 * con exito y se compara con el esperado para validar que los cambios fueron satisfactorios.
		 */
		String ActualTitle5 = driver.findElement(By.xpath("//h1[contains(text(),'Cambios guardados con éxito')]")).getText();
		String ExpectedTitle5 = "Cambios guardados con éxito";
		Assert.assertEquals(ExpectedTitle5, ActualTitle5, "El cambio se realizo");
		System.out.println("El cambio de nombre se realizo exitosamente.");
		
		//Se cierra el navegador y la sesion en el servidor.
		driver.close();
		driver.quit();
		System.out.println("El usuario se logro registrar exitosamente en el sistema.");
		test5.info("TC05 completed.");
		
		
		
		extent.flush();
	}

}
