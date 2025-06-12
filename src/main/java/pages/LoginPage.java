package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	private WebDriver driver;
	
	
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void enterUserName() {
		username.sendKeys("standard_user");
	}
	
	public void enterPassword() {
		password.sendKeys("secret_sauce");
	}
	
	public InventoryPage clickLoginButton() {
		loginButton.click();
		return new InventoryPage(driver);
	}
	
	
	
	public String getLoginButtonText() {
		return loginButton.getDomProperty("value");
	}



	

}
