package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(className="airship-btn airship-btn-deny")
	WebElement btnDenySubscribe;
	
	//Sirve le da click al banner y pasa a la siguiente pantalla
	/*@FindBy(className="dy-modal-wrapper")
	WebElement btnCloseBanner;*/
	
	@FindBy(className="dy-lb-close")
	WebElement btnCloseBanner2;
	
	@FindBy(id="testId-SearchBar-Input")
	WebElement navSearch;
	
	@FindBy(className="SearchBar-module_searchBtnIcon__6KVum")
	WebElement btnSearch;
	
	@FindBy(xpath="//button[@id='testId-Pod-action-prod10900027']")
	WebElement btnAddBasket;
	
	@FindBy(xpath="//a[@id='linkButton']")
	WebElement btnBasket;
	
	@FindBy(id="testId-HamburgerBtn-toggle")
	WebElement btnCategories;

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnModal(WebElement closeButton) {
		if(closeButton.isDisplayed()) 
			btnCloseBanner2.click();
	}
	
	public void clickOnModal2() {
		if(btnCloseBanner2.isDisplayed()) 
			btnCloseBanner2.click();
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
	
	public void clickOnCategories() {
		btnCategories.click();
	}
	
	public void nonSubscribe() {
		btnDenySubscribe.click();
	}
	
	
	


}
