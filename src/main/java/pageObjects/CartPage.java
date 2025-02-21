package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
   @FindBy(css = ".cartSection h3")
   private List<WebElement> cartProducts;
   
   @FindBy(xpath = "//button[text()='Checkout']")
   private WebElement checkoutEle;
   
   public Boolean verifyProductDisplay(String productName) {
	   Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
	   return match;
   }
   
   public CheckOutPage goToCheckout() {
	   checkoutEle.click();
	   return new CheckOutPage(driver);
	   
   }
}
