package tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryItemPage;
import pages.InventoryPage;
import pages.LoginPage;


public class InventoryPage_Test extends BaseTest {
	
	InventoryItemPage itp = null;
	LoginPage l = null;
	
	@Test(priority=1, groups="smoke")
	public void VerifyAddProductToCart() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		InventoryPage ip = new InventoryPage(driver);
		lp.enterUserName();
		lp.enterPassword();
		lp.clickLoginButton();
		ip.clickAddToCartButton();
		Thread.sleep(2000);
		Assert.assertTrue(ip.buttonRemove.isDisplayed());
		
	}
	
	@Test(priority=3, groups="smoke")
	public void verifyClickingOnProduct() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		InventoryPage ip = new InventoryPage(driver);
		lp.enterUserName();
		lp.enterPassword();
		lp.clickLoginButton();
		itp = ip.clickOnProduct();
		Thread.sleep(2000);
		Assert.assertTrue(itp.buttonBack.isDisplayed());
		
		
	}
		
	
	@Test(priority=2)
	public void VerifyLogoutFromInventoryPage() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		InventoryPage ip = new InventoryPage(driver);
		lp.enterUserName();
		lp.enterPassword();
		lp.clickLoginButton();
		ip.clickOnMenu();
		Thread.sleep(2000);
		l = ip.clickOnLogout();
		String loginButtonText = l.getLoginButtonText();
		Assert.assertEquals(loginButtonText, "LOGIN");
		
	}
	
	

}
