package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	@FindBy(xpath="//button[@id='testId-cc-login-form-submit']")
	WebElement btnLogin;
	
	@FindBy(xpath="//p[contains(text(),'Inicia Sesión')]")
	WebElement btnProfile;
	
	@FindBy(xpath="//a[contains(text(),'Regístrate')]")
	WebElement btnRegister;
	
	@FindBy(xpath="//input[@id='testId-Input-firstName']")
	WebElement txtName;
	
	@FindBy(xpath="//input[@id='testId-Input-lastName']")
	WebElement txtLastName;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]/i[1]")
	WebElement btnTypeId;
	
	@FindBy(id="testId-Dropdown-Cédula de Ciudadanía")
	WebElement selTypeId;	
	
	@FindBy(xpath="//input[@id='testId-Input-document']")
	WebElement nroId;
	
	@FindBy(xpath="//input[@id='testId-Input-phoneNumber']")
	WebElement nroCellphone;
	
	@FindBy(id="testId-Input-email")
	WebElement txtEmail;
	
	@FindBy(id="testId-Input-password")
	WebElement txtPassword;	
	
	@FindBy(id="testId-consent-TyC-BU_consentTemplateRegistroTyC_FAL_CO-input")
	WebElement chkTermsCond;
	
	@FindBy(id="testId-consent-TyC-ECO_consentTemplateRegistroCMRPuntosTyC_FAL_CO-input")
	WebElement chkCmrPoints;
	
	@FindBy(id="testId-Button-submit")
	WebElement btnRegisterMe;
	
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogin() {
		btnProfile.click();
	}
	
	public void clickOnNewRegister() {
		btnRegister.click();
	}
		
	public void fillDataNewUser(String name, String lastname, String typeid, String numid, String cellphone, String email, String password) {
		txtName.sendKeys(name);
		txtLastName.sendKeys(lastname);
		btnTypeId.click();
		selTypeId.sendKeys(typeid);
		nroId.sendKeys(numid);
		nroCellphone.sendKeys(cellphone);
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		chkTermsCond.click();
		chkCmrPoints.click();
	}
	
	public void clickOnRegister() {
		btnRegisterMe.click();
	}
}
