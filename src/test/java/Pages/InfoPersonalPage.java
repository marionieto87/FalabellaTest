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
	
	@FindBy(xpath="//button[@id='testId-Button-submit']")
	WebElement btnSaveChangesProfile;
	
	
	public InfoPersonalPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void changeNameUser(String name) {
		txtName.sendKeys(name);
	}
	
	public void changePhoneNumber(String phone) {
		txtPhoneNumber.sendKeys(phone);
	}
	
	public void saveChanges() {
		btnSaveChangesProfile.click();
	}
}
