package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {
	
	private WebDriver driver;
	
	
	@FindBy(xpath="//div[@class='inventory_details']/button")
	public
	WebElement buttonBack;
	
	@FindBy(xpath="//button[contains(@class, 'btn_primary')]")
	public
	WebElement ButtonAddToCartInventoryItemPage;
	
	@FindBy(xpath="//button[contains(@class, 'btn_secondary')]")
	public
	WebElement ButtonRemoveFromInventoryItemPage;
	
	@FindBy(xpath="//div[contains(@class, 'bm-burger-button')]")
	WebElement menuInventoryItemPage;
	
	@FindBy(id="logout_sidebar_link")
	WebElement logoutLinkInventoryItemPage;
	
	public InventoryItemPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
		
	}
	
	public InventoryPage clickOnBackButton() {
		buttonBack.click();
		return new InventoryPage(driver);
	}
	
	public void clickOnAddToCartButtonOnInventoryItemPage() {
		ButtonAddToCartInventoryItemPage.click();
		
	}
	
	public void clickNoMenuInInventoryItemPage() {
		menuInventoryItemPage.click();
	}
	
	public LoginPage logoutFromInventoryItemPage() {
		logoutLinkInventoryItemPage.click();
		return new LoginPage(driver);
	}

}
