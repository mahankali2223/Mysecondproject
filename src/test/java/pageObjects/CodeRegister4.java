package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CodeRegister4 extends Basepage {

	public CodeRegister4(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//input[@placeholder='First Name'])[2]")
	public WebElement firstName;

	@FindBy(xpath = "(//input[@placeholder='Email'])[2]")
	public WebElement email;

	@FindBy(xpath = "(//input[@placeholder='Password'])[2]")
	public WebElement psswrd;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	public WebElement chkbox;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	public WebElement submit;

	@FindBy(xpath = "//span[@patternalidationerror]")
	public WebElement invalidPasswrd;

	@FindBy(xpath = "//input[@placeholder=\"Email\"]/following-sibling::small //span[@class=\"badge tertiary\"]")
	public WebElement invalidEmail;

	@FindBy(xpath = "(//label[text()=\" First Name\"])[2]")
	public WebElement firstNameLabel;

	public void checkInvalidPasswordMsg(String text) throws InterruptedException {
		try {
			this.sendKeys(this.psswrd, text);
			Thread.sleep(2000);
			this.click(this.firstName);
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
		try {
			this.sendKeys(this.email, text);
			Thread.sleep(1000);
			this.click(this.psswrd);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(invalidEmail));
		} catch (RuntimeException e) {
			System.out.println("Invalid Email Message is not visible");
		}
		String invalidEmailMsg = this.getText(this.invalidEmail);
		Assert.assertEquals(invalidEmailMsg, " Invalid Email Address ");
	}
	
	public void checkInvalidFirstNameMsg(WebElement element, String text) throws InterruptedException {
		this.sendKeys(element, text);
		Thread.sleep(3000);
		this.click(this.email);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(invalidFirstName));
		} catch (RuntimeException e) {
			System.out.println("Invalid First Name Message is not visible");
//			Assert.assertEquals("", " First Name Message is not visible");
		}
		String invalidFstNameMsg = this.getText(this.invalidFirstName);
		Assert.assertEquals(invalidFstNameMsg, "First name should have only letters");
	}

}
