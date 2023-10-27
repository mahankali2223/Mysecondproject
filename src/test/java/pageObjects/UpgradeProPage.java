package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpgradeProPage  extends Basepage {

	public UpgradeProPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "(//a[text()='Upgrade To Pro'])[1]")
	public WebElement upGradePro;
	
	@FindBy(xpath = "(//a[contains(@class,'orange-purple-bg')])[1]")
	public WebElement getStartNow;
	
	@FindBy(xpath = "(//a[contains(@class,'h6')])[1]")
	public WebElement freeTrial;
	
	@FindBy(xpath = "//form[@id='paymentForm']//input[@id='fname']")
	public WebElement firstName;
	
	@FindBy(xpath = "//form[@id='paymentForm']//input[@id='lname']")
	public WebElement lastName;
	
	@FindBy(xpath = "//form[@id='paymentForm']//input[@id='email']")
	public WebElement emailID;
	
	@FindBy(xpath = "//form[@id='paymentForm']//input[@id='billing_address']")
	public WebElement address;
	
	@FindBy(xpath = "//form[@id='paymentForm']//input[@id='billing_city']")
	public WebElement cityName;
	
	@FindBy(xpath = "//form[@id='paymentForm']//select[@id='billing_country']")
	public WebElement CountryDropDown;
	
	@FindBy(xpath = "//form[@id='paymentForm']//input[@id='billing_region']")
	public WebElement region;
	
	@FindBy(xpath = "//form[@id='paymentForm']//input[@id='billing_postal_code']")
	public WebElement postalCode;
	
	@FindBy(xpath = "//form[@id='paymentForm']//input[@id='creditCardRadio']")
	public WebElement creditCard;
	
	@FindBy(xpath = "//input[@id='Field-numberInput']")
	public WebElement cardNumber;
	
	@FindBy(xpath = "//input[@id='Field-cvcInput']")
	public WebElement cvcInput;
	
	@FindBy(xpath = "//select[@id=\"Field-countryInput\"]")
	public WebElement countryInput;
	
	@FindBy(xpath = "//button[@id='placeOrder']")
	public WebElement placeOrder;
	
	@FindBy(xpath = "//input[@id=\"Field-expiryInput\"]")
	public WebElement expiryDate;
	
	@FindBy(xpath = "//label[@id='fname-error']")
	public WebElement firstNameError;
	
	@FindBy(xpath = "//label[@id='lname-error']")
	public WebElement lastNameError;
	
	@FindBy(xpath = "//label[@id='email-error']")
	public WebElement emailError;
	
	@FindBy(xpath = "//label[@id='billing_address-error']")
	public WebElement addressError;
	
	@FindBy(xpath = "//label[@id='billing_city-error']")
	public WebElement cityError;
	
	@FindBy(xpath = "//label[@id='billing_country-error']")
	public WebElement countryError;
	
	@FindBy(xpath = "//label[@id='billing_region-error']")
	public WebElement regionError;
	
	@FindBy(xpath = "//label[@id='billing_postal_code-error']")
	public WebElement postalCodeError;
	
	@FindBy(xpath = "//button[@name='placeOrder']")
	public WebElement placeOrderBtn;

	
}


