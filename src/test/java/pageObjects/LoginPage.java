package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends Basepage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//a[text()='Login'])[2]")
	public WebElement loginButton;

	@FindBy(xpath = "(//a[text()='Login'])[1]")
	public WebElement loginBttn;

	@FindBy(xpath = "//input[@placeholder='Email']")
	public WebElement email;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement psswrd;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	public WebElement loginsubmit;

	@FindBy(xpath = "//app-right-side-header//h2")
	public WebElement welComemsg;

	@FindBy(xpath = "//h1")
	public WebElement welComemessg;

	@FindBy(xpath = "(//button[text()='Account Settings'])[1]")
	public WebElement accountSetting;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	public WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='Mobile']")
	public WebElement mobileNum;

	@FindBy(xpath = "//input[@type='password']")
	public WebElement updatePsswrd;

	@FindBy(xpath = "//span[text()='Update Password']")
	public WebElement update;

	@FindBy(xpath = "//input[@placeholder='Enter Your Old Password']")
	public WebElement oldPsswd;

	@FindBy(xpath = "//input[@placeholder='Enter Your New Password']")
	public WebElement newPsswd;

	@FindBy(xpath = "//input[@placeholder='Confirm  Password']")
	public WebElement confirmPsswd;

	@FindBy(xpath = "//h3")
	public WebElement changePasswdheader;

	@FindBy(xpath = "//a//span[text()='Go To ']")
	public WebElement gotoDashboard;

	@FindBy(xpath = "//div[text()=' Invalid username or password. ']")
	public WebElement invalidUserpaswrd;

	@FindBy(xpath = "//input[@placeholder=\"Email\"]/following-sibling::small //span[@class=\"badge tertiary\"]")
	public WebElement invalidEmail;

	@FindBy(xpath = "//span[text()='Browse']")
	public WebElement browser;

	@FindBy(xpath = "(//a[text()='Enterprise'])[1]")
	public WebElement enterprise;

	@FindBy(xpath = "(//span[text()='Home'])[1]")
	public WebElement home;

	@FindBy(xpath = "(//span[text()='Learn'])[1]")
	public WebElement learn;

	@FindBy(xpath = "(//a[text()='Upgrade To Pro'])[1]")
	public WebElement upGradePro;

	@FindBy(xpath = "//span[text()='Courses']")
	public WebElement courses;

	@FindBy(xpath = "//span[text()='Learning Paths']")
	public WebElement learningPath;

	@FindBy(xpath = "//span[text()='Micro Degrees']")
	public WebElement microDegrees;

	@FindBy(xpath = "//span[text()='Stats']")
	public WebElement Stats;

	@FindBy(xpath = "//span[text()='Completed Courses']")
	public WebElement completedCourses;

	@FindBy(xpath = "//span[text()='My Notes']")
	public WebElement myNotes;

	@FindBy(xpath = "//span[text()='Bundles']")
	public WebElement bundles;

	@FindBy(xpath = "//span[text()='Favorite Lessons']")
	public WebElement favoriteLessons;

	public String learnModules = "//div[@class='learn-list__expanded container-fluid']//a";

	@FindBy(xpath = "(//span[text()='Interactive Labs'])[1]")
	public WebElement interactiveLabs;

	@FindBy(xpath = "(//span[text()='Official eCourseware'])[1]")
	public WebElement officialEcourse;

	@FindBy(xpath = "(//span[text()='Exam Vouchers'])[1]")
	public WebElement examVouchers;

	@FindBy(xpath = "(//span[text()='Certificates'])[1]")
	public WebElement certificates;

	@FindBy(xpath = "//app-weekly-goals//h4")
	public WebElement weeklyGoals;

	@FindBy(xpath = "(//h6//span[@class='badge tertiary'])[1]")
	public WebElement updatePwdErrormesg;

	@FindBy(xpath = "(//h6//span[@class='badge tertiary'])[3]")
	public WebElement updateConfirmPswdErrorMeg;
	
	@FindBy(xpath = "//div[contains(@class,'alert-danger')]")
	public WebElement updatedErrorMeg;
	
	@FindBy(xpath = "//input[@placeholder='Enter Email']")
	public WebElement resetEmail;
	
	@FindBy(xpath = "//h2[@id='swal2-title']")
	public WebElement userNotFoundMessg;
	
	@FindBy(xpath = "//input[@name='otp1']")
	public WebElement otp1;
	
	@FindBy(xpath = "//input[@name='otp2']")
	public WebElement otp2;
	
	@FindBy(xpath = "//input[@name='otp3']")
	public WebElement otp3;
	
	@FindBy(xpath = "//input[@name='otp4']")
	public WebElement otp4;

	@FindBy(xpath = "//input[@name='otp5']")
	public WebElement otp5;
	
	@FindBy(xpath = "//input[@name='otp6']")
	public WebElement otp6;
	
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	public WebElement resetPasswordButton;
	
	public String updatedErrorMessage = "//div[contains(@class,'alert-danger')]";
	
	public String userfoundErrorMessage = "//h2[@id='swal2-title']";
	
	

	public void updateAccount() {
		this.click(profileIcon);
		this.moveAndClick(accountSetting);
	}

	public void checkInvalidEmailMsg(String text) {
		this.sendKeys(this.email, text);
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
	
	public void updateCheckInvalidEmailMsg(WebElement element, String text) throws InterruptedException {
		this.sendKeys(element, text);
		Thread.sleep(3000);
		this.moveAndClick(this.firstName);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(invalidEmail));
		} catch (RuntimeException e) {
			System.out.println("Invalid Email Message is not visible");
			Assert.assertEquals("", " Invalid Email Message is not visible ");
		}
		String invalidEmailMsg = this.getText(this.invalidEmail);
		Assert.assertEquals(invalidEmailMsg, " Invalid Email Address ");
	}


	public void checkInvalidUsernamemsg() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(invalidUserpaswrd));
		} catch (RuntimeException e) {
		}
		String invalidusernameMsg = this.getText(this.invalidUserpaswrd);
		Assert.assertEquals(invalidusernameMsg, "Invalid username or password.");
	}

	public void updatePswdInvalidMesg(WebElement element, String text) throws InterruptedException {
		this.sendKeys(element, text);
		Thread.sleep(2000);
		this.click(this.oldPsswd);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			wait.until(ExpectedConditions.visibilityOf(updatePwdErrormesg));
		} catch (RuntimeException e) {
			System.out.println("Invalid Password Message is not visible");
		}
	}

	public void updatePwdConfirmInvalidMsg(WebElement element, String text) throws InterruptedException {
		this.sendKeys(element, text);
		Thread.sleep(3000);
		this.click(this.oldPsswd);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			wait.until(ExpectedConditions.visibilityOf(updateConfirmPswdErrorMeg));
		} catch (RuntimeException e) {
			System.out.println("Invalid Password Message is not visible");
		}
	}
	
	public void updatePasswordErrorMsg(WebElement element, String text) throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			wait.until(ExpectedConditions.visibilityOf(invalidPasswrd));
		} catch (RuntimeException e) {
			System.out.println("Invalid Password Message is not visible");
		}
		String invalidPasswordMsg = this.getText(this.invalidPasswrd);
		Assert.assertEquals(invalidPasswordMsg,
				"Password should have numbers, special characters, capital and small letters");
	}


}
