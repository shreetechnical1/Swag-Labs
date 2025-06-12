package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryItemPage;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryItemPage_Test extends BaseTest {
	
	InventoryPage ip1 = null;
	LoginPage l = null;
	
	@Test
	public void verifyBackButton() {
		LoginPage lp = new LoginPage(driver);
		InventoryPage ip = new InventoryPage(driver);
		InventoryItemPage itp = new InventoryItemPage(driver);
		lp.enterUserName();
		lp.enterPassword();
		lp.clickLoginButton();
		ip.clickOnProduct();
		ip1 = itp.clickOnBackButton();
		Assert.assertTrue(driver.getCurrentUrl().contains("www.saucedemo.com/v1/inventory.html"));
	}
	
	@Test(groups="smoke")
	public void verifyAddProductToCartFromInventoryItemPage() {
		LoginPage lp = new LoginPage(driver);
		InventoryPage ip = new InventoryPage(driver);
		InventoryItemPage itp = new InventoryItemPage(driver);
		lp.enterUserName();
		lp.enterPassword();
		lp.clickLoginButton();
		ip.clickOnProduct();
		itp.clickOnAddToCartButtonOnInventoryItemPage();
		Assert.assertTrue(itp.ButtonRemoveFromInventoryItemPage.isDisplayed());
			
	}
	
	@Test
	public void verifyRemoveProductFromCartFromInventoryItemPage() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		InventoryPage ip = new InventoryPage(driver);
		InventoryItemPage itp = new InventoryItemPage(driver);
		lp.enterUserName();
		lp.enterPassword();
		lp.clickLoginButton();
		ip.clickOnProduct();
		itp.clickOnAddToCartButtonOnInventoryItemPage();
		Thread.sleep(2000);
		itp.ButtonRemoveFromInventoryItemPage.click();
		Assert.assertTrue(itp.ButtonAddToCartInventoryItemPage.isDisplayed());
		
	}
	
	@Test(groups="smoke test")
	public void verifyLogoutFromInventoryItemPage() {
		LoginPage lp = new LoginPage(driver);
		InventoryPage ip = new InventoryPage(driver);
		InventoryItemPage itp = new InventoryItemPage(driver);
		lp.enterUserName();
		lp.enterPassword();
		lp.clickLoginButton();
		ip.clickOnProduct();
		itp.clickNoMenuInInventoryItemPage();
		l = itp.logoutFromInventoryItemPage();
		String loginButtonText = l.getLoginButtonText();
		Assert.assertEquals(loginButtonText, "LOGIN"); 
	}
	
	

}
