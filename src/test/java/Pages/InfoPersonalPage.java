package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InfoPersonalPage {
	WebDriver driver;
	
	@FindBy(id="testId-Input-phoneNumber")
	WebElement txtPhoneNumber;
	
	@FindBy(id="testId-Input-firstName")
	WebElement txtName;
	
	
	public InfoPersonalPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void changeNameUser(String name) {
		 System.out.println("Pep");
		txtName.sendKeys(name);
	}
	
	public void changePhoneNumber(String phone) {
		txtPhoneNumber.sendKeys(phone);
	}
}
