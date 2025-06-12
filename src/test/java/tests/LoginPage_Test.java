package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;



public class LoginPage_Test extends BaseTest {
	
	
	InventoryPage ip = null;
	
	
	@Test
	public void VerifyLoginPageTitle() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		String title = lp.validateLoginPageTitle();
		Thread.sleep(4000);
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@Test(groups = {"smoke"})
	public void verifyValidLogin() {
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName();
		lp.enterPassword();
		ip = lp.clickLoginButton();
		String buttonText = ip.getAddToCartButtonText();
		Assert.assertEquals(buttonText, "ADD TO CART");
	}

}
