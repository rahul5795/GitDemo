package testCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import genericutilities.BaseClass;
import genericutilities.DataProviders;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.ConfirmationPage;
import pageObjects.OrderPage;
import pageObjects.ProductCatalogue;

public class SubmitOrderTest extends BaseClass{
	
	String productName = "QWERTY";
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviders.class,groups = {"Purchase"})
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		
		
		ProductCatalogue productCatalogue=	landingPage.loginApplication(input.get("email"), input.get("password"));
		
		
		List<WebElement> products = productCatalogue.getProductsList();

		productCatalogue.addProductToCart(input.get("product"));

		CartPage cartPage=productCatalogue.goToCartPage();
		
		Boolean match = cartPage.verifyProductDisplay(input.get("product"));

		Assert.assertTrue(match);
		CheckOutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.placeOrder();

		String confirmMessage = confirmationPage.getConfirmationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		

	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistroyTest() {
		ProductCatalogue productCataloge = landingPage.loginApplication("abc57@gmail.com", "Rahul@123");
		OrderPage orderPage = productCataloge.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));

		
		
	}

}
