package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.AbstractComponent;

public class OrderPage extends AbstractComponent{
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	   
	   @FindBy(xpath = "//tr//td[2]")
	   private List<WebElement> productNames;
	   
	   public Boolean verifyOrderDisplay(String productName) {
			Boolean match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		   return match;
	   }
	   
	  
	}