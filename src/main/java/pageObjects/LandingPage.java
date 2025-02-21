package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(id = "userEmail")
	private WebElement userEmailTxtBx;
	
	@FindBy(id = "userPassword")
	private WebElement userPasswordTxtBx;
	
	@FindBy(id = "login")
	private WebElement loginBtn;
	
	@FindBy(css="[class*='flyInOut']")
	private WebElement errorMessage;

  
	public String getErrorMessage() {
		 waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public ProductCatalogue loginApplication(String email,String password) {
		userEmailTxtBx.sendKeys(email);
		userPasswordTxtBx.sendKeys(password);
		loginBtn.click();
		ProductCatalogue productCatalogue= new ProductCatalogue(driver);
		return productCatalogue;
		
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
}
