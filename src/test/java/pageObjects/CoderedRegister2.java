package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CoderedRegister2 extends Basepage {

	public CoderedRegister2(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//input[@placeholder='First Name'])[1]")
	public WebElement firstName;

	@FindBy(xpath = "(//input[@placeholder='Email'])[1]")
	public WebElement email;

	@FindBy(xpath = "(//input[@placeholder='Password'])[1]")
	public WebElement psswrd;

	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	public WebElement chkbox;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	public WebElement submit;

	@FindBy(xpath = "//input[@placeholder=\"Email\"]/following-sibling::small //span[@class=\"badge tertiary\"]")
	public WebElement invalidEmail;

	@FindBy(xpath = "//span[@patternalidationerror]")
	public WebElement invalidPasswrd;

	@FindBy(xpath = "(//label[text()=\" First Name\"])[1]")
	public WebElement firstNameLabel;

	@FindBy(xpath = "(//label[text()=\" Email\"])[1]")
	public WebElement emailLabel;

	@FindBy(xpath = "(//label[text()=\" Password\"])[1]")
	public WebElement password;

	@FindBy(xpath = "//h2")
	public WebElement header;

	@FindBy(xpath = "(//div//h4)[1]")
	public WebElement subheader;

	public void checkInvalidPasswordMsg(String text) throws InterruptedException {
		try {
			this.sendKeys(this.psswrd, text);
			Thread.sleep(2000);
			this.click(this.email);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(invalidPasswrd));
		} catch (RuntimeException e) {
			System.out.println("Invalid Password Message is not visible");
		}
		String invalidPasswordMsg = this.getText(this.invalidPasswrd);
		Assert.assertEquals(invalidPasswordMsg,
				"Password should have numbers, special characters, upper case and lower case letters and at minimum the length to be 8 characters");
	}

	public void checkInvalidEmailMsg(String text) throws InterruptedException {
		this.sendKeys(this.email, text);
		Thread.sleep(1000);
		this.click(this.psswrd);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(invalidEmail));
		} catch (RuntimeException e) {
			System.out.println("Invalid Email Message is not visible");
		}
		String invalidEmailMsg = this.getText(this.invalidEmail);
		Assert.assertEquals(invalidEmailMsg, " Invalid Email Address ");
	}
}
