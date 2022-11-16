package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(className="airship-btn airship-btn-deny")
	WebElement btnDenySubscribe;
	
	@FindBy(className="dy-modal-wrapper")
	WebElement btnCloseBanner;
	
	@FindBy(id="testId-SearchBar-Input")
	WebElement navSearch;
	
	@FindBy(className="SearchBar-module_searchBtnIcon__6KVum")
	WebElement btnSearch;
	
	@FindBy(xpath="//button[@id='testId-Pod-action-prod10900027']")
	WebElement btnAddBasket;
	
	@FindBy(xpath="//a[@id='linkButton']")
	WebElement btnBasket;
	
		
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnModal() {
		btnCloseBanner.click();
	}
	
	public void searchItem(String item) {
		navSearch.sendKeys("iPhone");
	}
	
	public void clickOnSearch() {
		btnSearch.click();		
	}
	
	public void addToBasket() {
		btnAddBasket.click();
	}
	
	public void clickOnBasket() {
		btnBasket.click();		
	}
	


}
