package pageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccountRegisterationPage extends Basepage {
	
	public AccountRegisterationPage(WebDriver driver) {
		super(driver);
	}
	
	public String name = this.randomString();
	
	 
	@FindBy(xpath = "(//a[text()='Get Free Access'])[1]")
	public WebElement getFree ;
	
	@FindBy(xpath = "//a[text()='Create Your Free Account Now']")
	public WebElement createAccount;
	
	@FindBy(xpath ="(//input[@placeholder='First Name'])")
	public WebElement firstName;
	
	@FindBy(xpath ="(//input[@placeholder='Email'])")
	public WebElement email;
	
	@FindBy(xpath ="(//input[@placeholder='Password'])")
	public WebElement psswrd;
	
    @FindBy(xpath = "//app-select[@defaultvalue='Country']")
    public WebElement countryId;
    
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement chkbox;
    
    @FindBy(xpath = "//button[@title='Close']")
    public WebElement closeBtn;
    
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement submit;
    
    @FindBy(xpath = "//h2")
    public WebElement header;
    
    @FindBy(xpath = "//a[text()='Start']")
    public WebElement strtBtn;
    
    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement nxtBtn;
    
    @FindBy(xpath = "div.loader")
    public WebElement spinner;
    
    @FindBy(xpath = "//a[text()='Go To Dashboard']")
    public WebElement dashBoard;
    
    @FindBy(xpath = "//h1")
    public WebElement thankMsg;
    
    @FindBy(xpath = "//app-right-side-header//h2")
    public WebElement dashboardMsg;
    
    @FindBy(xpath = "//input[@placeholder=\"Email\"]/following-sibling::small //span[@class=\"badge tertiary\"]")
	public WebElement invalidEmail;
    
    @FindBy(xpath = "//span[@patternalidationerror]")
	public WebElement invalidPasswrd;
    
    @FindBy(xpath = "(//div//h4)[1]")
    public WebElement subheader;
    
    @FindBy(xpath = "(//h5)[1]")
    public WebElement thanksubheader;
    
    @FindBy(xpath = "//p//span")
	public WebElement popmsg;
    
    public void checkInvalidPasswordMsg(String text) throws InterruptedException {
		try {
			this.sendKeys(this.psswrd, text);
	    	Thread.sleep(2000);
			this.click(this.firstName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(invalidPasswrd));
		} catch(RuntimeException e) {
			System.out.println("Invalid Password Message is not visible");
		}
		String invalidPasswordMsg = this.getText(this.invalidPasswrd);
		Assert.assertEquals(invalidPasswordMsg, "Password should have numbers, special characters, upper case and lower case letters and at minimum the length to be 8 characters");
    }
    
    public void checkInvalidEmailMsg(String text) throws InterruptedException {
    	try {
    	this.sendKeys(this.email, text);
    	Thread.sleep(2000);
		this.click(this.psswrd);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(invalidEmail));
		} catch(RuntimeException e) {
			System.out.println("Invalid Email Message is not visible");
		}
		String invalidEmailMsg = this.getText(this.invalidEmail);
		Assert.assertEquals(invalidEmailMsg, " Invalid Email Address ");
    }

    public void clickOption(String option) {
    	driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys(option);
    	List<WebElement> list	= driver.findElements(By.xpath("//li[@role='option']"));
   
    		for(int i=0; i<list.size(); i++) {
    			
    			if(list.get(i).getText().equals(option)){
    				WebDriverWait Mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
    				Mywait.until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
    				break;
    			}
    		}
	}
    
    public void options(int numberofoptions) {
    	List<WebElement> list = driver.findElements(By.xpath("//div[@class='py-2 primary font-semi-bold']"));
    	for(int i=0; i<numberofoptions;i++) {
    		JavascriptExecutor js = (JavascriptExecutor) driver;
    		js.executeScript("arguments[0].scrollIntoView();",list.get(i) );
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
    	}
    	
    }
    
    public String[] optionsGettext() {
    	List<WebElement> list = driver.findElements(By.xpath("//div[@class='py-2 primary font-semi-bold']"));
    	String[] data = new String[list.size()];
    	for(int i=0; i < list.size();i++) {
    		JavascriptExecutor js = (JavascriptExecutor)driver;
        	js.executeScript("arguments[0].scrollIntoView();",list.get(i));
    		data[i] = list.get(i).getText();
    	}
    	return data;
    }
    
    public void selectCareerGoals(int numOfOptions) {
    	List<WebElement> list = driver.findElements(By.xpath("//label/p"));
    	for(int i=0; i<numOfOptions;i++) {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
    	}
    }
    
    public void proceedToNextStep() throws InterruptedException {
    	try {
    		String confirm = getText(header);
		    // Checking Message on screen
		    String msg = "Welcome To EC-Council Learning, "+name+"!";
		    Assert.assertEquals(confirm, msg);
		    // Checking title
		    Assert.assertEquals(driver.getTitle(), "Welcome | EC-Council Learning");
			this.click(strtBtn);
			this.spinnerloader();
			// Checking title
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.options(4);
			this.click(nxtBtn);
			this.spinnerloader();
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.options(1);
			this.click(nxtBtn);
			this.spinnerloader();
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.selectCareerGoals(1);
			this.click(nxtBtn);
			this.spinnerloader();
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.options(3);
			this.click(nxtBtn);
			this.spinnerloader();
			String thankYouMsg =this.getText(thankMsg);
		    // Checking Message on screen
		    String mesg = "Thank You, "+name+"!";
		    Assert.assertEquals(thankYouMsg, mesg);
			Assert.assertEquals(driver.getTitle(), "Thanks | EC-Council Learning");
			this.click(dashBoard);
			this.spinnerloader();
			String dashboardMssg =this.getText(dashboardMsg);
		    // Checking Message on screen
		    String messg = "Welcome, "+name+"!";
		    Assert.assertEquals(dashboardMssg, messg);
			Assert.assertEquals(driver.getTitle(), "Course | Dashboard | EC-Council Learning");
    	}catch(Exception e){
			System.out.println(e);
			Assert.fail();
		 }
    }
    
    public void assertionHeaders() throws InterruptedException {
    	try {
    		String confirm = getText(header);
		    // Checking Message on screen
		    String msg = "Welcome To EC-Council Learning, "+name+"!";
		    Assert.assertEquals(confirm, msg);
		    // Checking title
		    Assert.assertEquals(driver.getTitle(), "Welcome | EC-Council Learning");
			this.click(strtBtn);
			this.spinnerloader();
			//Checking header message on screen
			Assert.assertEquals(this.getText(header).trim(), "Personalizing Your EC-Council Learning Experience".trim());
			Assert.assertEquals(this.getText(subheader), "Choose up to 4 categories that interest you the most.");
			// Checking title
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			String[] categoryOption = {"Data Science","Cloud Security","Industrial Security Controls","Vulnerability Assessment and Pentesting","Security Architecture and Operations","Cybersecurity","Governance, Risk, and Compliance","DevSecOps","Software Development"};
			String[] categoryOptionUi = this.optionsGettext();
			Assert.assertEquals(categoryOptionUi, categoryOption);
			this.options(4);
			this.click(nxtBtn);
			this.spinnerloader();
			Assert.assertEquals(this.getText(header).trim(), "Personalizing Your EC-Council Learning Experience".trim());
			Assert.assertEquals(this.getText(subheader), "What is your level of experience at the previously selected categories?");
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			String[] leveloption = {"Beginner","Intermediate","Advanced"};
			String[] levelOptionUi = this.optionsGettext();
			Assert.assertEquals(levelOptionUi, leveloption);
			this.options(1);
			this.click(nxtBtn);
			this.spinnerloader();
			Assert.assertEquals(this.getText(header).trim(), "Personalizing Your EC-Council Learning Experience".trim());
			Assert.assertEquals(this.getText(subheader), "What is your next career goal?");
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.selectCareerGoals(1);
			this.click(nxtBtn);
			this.spinnerloader();
			Assert.assertEquals(this.getText(header).trim(), "Personalizing Your EC-Council Learning Experience".trim());
			Assert.assertEquals(this.getText(subheader), "Select all the topics you're interested in");
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
//			String[] topicsOption = {"Cybersecurity","Ethical Hacking","Linux","Network Security","PenTesting","ICS","Kali Linux","Microsoft Azure","OSINT","OWASP","Penetration Testing","Python","GDPR","Bug Bounty","Hacking","Cybersecurity","Nmap","Data Management","Phishing","Risk Management"};
//			String[] topicsOptionUi = this.optionsGettext();
//			Assert.assertEquals(topicsOptionUi, topicsOption);
			this.options(3);
			this.click(nxtBtn);
			this.spinnerloader();
			String thankYouMsg =this.getText(thankMsg);
		    // Checking Message on screen
		    String mesg = "Thank You, "+name+"!";
		    Assert.assertEquals(thankYouMsg, mesg);
		    String thankheader = "We're now ready to recommend courses for you based on your career goals and interests! You will always find your recommended courses in your dashboard";
		    Assert.assertEquals(this.getText(thanksubheader).trim(), thankheader.trim());
			Assert.assertEquals(driver.getTitle(), "Thanks | EC-Council Learning");
			this.click(dashBoard);
			this.spinnerloader();
			String dashboardMssg =this.getText(dashboardMsg);
		    // Checking Message on screen
		    String messg = "Welcome, "+name+"!";
		    Assert.assertEquals(dashboardMssg, messg);
			Assert.assertEquals(driver.getTitle(), "Course | Dashboard | EC-Council Learning");
    	}catch(Exception e){
			System.out.println(e);
			Assert.fail();
		 }
    }
}
	
	