package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class InventoryPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//button[contains(@class, 'btn_primary')]")
	WebElement buttonAddToCart;
	
	@FindBy(xpath="//button[contains(text(), 'REMOVE')]")
	public
	WebElement buttonRemove;
	
	@FindBy(xpath="//div[contains(text(), 'Sauce Labs Backpack')]")
	WebElement product;
	
	@FindBy(xpath="//div[contains(@class, 'bm-burger-button')]")
	WebElement menu;
	
	@FindBy(id="logout_sidebar_link")
	WebElement logoutLink;
	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String getAddToCartButtonText() {
		return buttonAddToCart.getText();
	}
	
	public void clickAddToCartButton() {
		buttonAddToCart.click();
	}
	
	public void clickRemoveButton() {
		buttonRemove.click();
	}
	
	public InventoryItemPage clickOnProduct() {
		product.click();
		return new InventoryItemPage(driver);
	}
	
	public void clickOnMenu() {
		menu.click();
	}
	
	public LoginPage clickOnLogout() {
		logoutLink.click();
		return new LoginPage(driver);
	}

}
