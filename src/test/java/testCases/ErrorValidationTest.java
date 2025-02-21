package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericutilities.BaseClass;
import genericutilities.Retry;
import pageObjects.CartPage;
import pageObjects.ProductCatalogue;

public class ErrorValidationTest extends BaseClass{
	
	@Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
	public void loginErrorValidation() {
		//String productName = "IPHONE 13 PRO";
		
		landingPage.loginApplication("abc57@gmail.com", "Rahul@125");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		//Assert.assertEquals("Incorrect email  password.", landingPage.getErrorMessage());
	}
	
	 @Test
	  public void productErrorValidation() throws InterruptedException {
		 String productName = "BANARSI SAREE";
		  ProductCatalogue productCataloge=landingPage.loginApplication("abc57@gmail.com", "Rahul@123");
		  List<WebElement> products = productCataloge.getProductsList();
		  productCataloge.addProductToCart(productName);
		 CartPage cartPage= productCataloge.goToCartPage();
		  boolean match = cartPage.verifyProductDisplay("BANARSI SAREE1");

		Assert.assertFalse(match);
	  }


}
