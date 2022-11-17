package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	@FindBy(xpath="//p[contains(text(),'Inicia Sesión')]")
	WebElement btnProfile;
	
	@FindBy(xpath="//input[@id='testId-cc-login-form-email-input']")
	WebElement txtUsername;
	
	@FindBy(xpath="//input[@id='testId-cc-login-form-password-input']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@id='testId-cc-login-form-submit']")
	WebElement btnLogin;
	
	@FindBy(xpath="//div[@id='']")
	WebElement txtLoginFailed;
	
	@FindBy(xpath="//li[@id='testId-UserAction-userinfo']//div[@id='']")
	WebElement btnUserLogued;
	
	@FindBy(xpath="//a[contains(text(),'Mi Cuenta')]")
	WebElement selMyAccount;
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fillCredentials(String username, String password){
		btnProfile.click();
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
	}
	
	public void clickOnLogin() {
		btnLogin.click();
	}
	
	public void goProfile() {
		btnUserLogued.click();
	}
	
	public void myAccount() {
		selMyAccount.click();
	}
	
	
	
}
