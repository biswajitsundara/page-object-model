package tests;

import org.testng.annotations.Test;

import base.TestSetup;
import pages.LoginPage;

/**
 * @author Biswajit Sundara
 * @date 31/03/2020
 */

public class FirstTest extends TestSetup{

	@Test
	public void executeTest()
	{
		new LoginPage(driver).get()
		.enterUserName("abc@gmail.com")
		.enterPassword("automation")
		.clickLogin()
		.enterSearchItem("dress")
		.clickSearchIcon()
		.addToCartProduct()
		.proceedCheckout()
		.checkoutCart()
		.addressCheckout()
		.acceptTermsCondition()
		.shippingCheckout()
		.selectPayment()
		.confirmOrder()
		.validateOrderConfirmation();
	}
}
