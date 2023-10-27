package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterprisePage extends Basepage {

	public EnterprisePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//a[text()='Enterprise'])[1]")
	public WebElement enterprise;

	@FindBy(xpath = "//h1")
	public WebElement enterpriseHeader;

	@FindBy(xpath = "(//h5[contains(@class,'font-light')])[1]")
	public WebElement enterpriseHeaderInfo;

	@FindBy(xpath = "//div[@class='container'] //a[contains(@class, 'orange-purple-bg')]")
	public WebElement bookFreeConsultationButton;

	@FindBy(xpath = "//div[@data-component='name']")
	public WebElement sidePanelName;

	@FindBy(xpath = "//iframe[@title='Select a Date & Time - Calendly']")
	public WebElement popupModel;

	@FindBy(xpath = "//div[@data-component='name']/following-sibling::h1")
	public WebElement sidePanelHeader;

	@FindBy(xpath = "(//div[@data-container='details']/div)[1]")
	public WebElement sidePanelDuration;

	@FindBy(xpath = "//div[@data-component='event-type-location']")
	public WebElement sidePanelEventType;

	@FindBy(xpath = "(//div[@data-container=\"details\"]/div)[3]")
	public WebElement sidePanelTimeDetails;

	@FindBy(xpath = "(//div[@data-container=\"details\"]/div)[4]")
	public WebElement sidePanelTimeZone;

	@FindBy(xpath = "//div[@class=\"simplebar-content\"]//p")
	public WebElement sidePanelInfo;

	@FindBy(xpath = "//div[@data-component='spotpicker']/h2")
	public WebElement calendarHeader;

	@FindBy(xpath = "//div[@data-testid='title']")
	public WebElement selectedMonth;

	@FindBy(xpath = "//p[@id='timezone-label']")
	public WebElement timeZoneHeader;

	@FindBy(xpath = "//button[@id=\"timezone-field\"]")
	public WebElement selectedTimeZone;

	@FindBy(xpath = "//input[@placeholder=\"Search...\"]")
	public WebElement timeZoneSearch;

	@FindBy(xpath = "(//div[@aria-label=\"Time format\"]/label)[2]")
	public WebElement hoursTypeRadioButton;
	
	@FindBy(xpath = "(//div[@aria-label=\"Time format\"]/label)[1]")
	public WebElement hoursTypeRadioBtn;

	@FindBy(xpath = "//h3[@data-component=\"spotpicker-times-subtitle\"]")
	public WebElement selectedDateDetails;

	@FindBy(xpath = "//td[@aria-selected=\"true\"] //span")
	public WebElement selectedDate;

	@FindBy(xpath = "//button[@role=\"button\"]")
	public WebElement nextBtn;

	@FindBy(xpath = "//div[@data-container=\"booking-container\"]//h2")
	public WebElement formHeader;

	@FindBy(xpath = "//input[@id=\"full_name_input\"]")
	public WebElement fullNameInput;

	@FindBy(xpath = "//label[@for=\"full_name_input\"]")
	public WebElement fullNameLabel;

	@FindBy(xpath = "//label[@for=\"email_input\"]")
	public WebElement emailLabel;

	@FindBy(xpath = "//input[@id=\"email_input\"]")
	public WebElement emailInput;

	@FindBy(xpath = "//div[text()=\"Add Guests\"]/parent::button")
	public WebElement addGuestButton;

	@FindBy(xpath = "//label[@for=\"invitee_guest_input\"]")
	public WebElement addGuestLabel;

	@FindBy(xpath = "//input[@id=\"invitee_guest_input\"]")
	public WebElement addGuestInput;

	@FindBy(xpath = "//small")
	public WebElement addGuestInfo;

	@FindBy(xpath = "//fieldset[@data-component=\"choice\"] //label")
	public WebElement companySizeLabel;

	@FindBy(xpath = "//label[text()=\"Phone Number\"]")
	public WebElement phnNumLabel;

	@FindBy(xpath = "//div[@class=\"phone-field-wrapper\"]/input")
	public WebElement phnNumInput;

	@FindBy(xpath = "//label[text()=\"Company Name\"]")
	public WebElement companyNameLabel;

	@FindBy(xpath = "//label[text()=\"Company Name\"]/parent::div/following-sibling::div/input")
	public WebElement companyNameInput;

	@FindBy(xpath = "//textarea[@maxlength]")
	public WebElement moreInfoInput;

	@FindBy(xpath = "//textarea[@maxlength]/parent::div/preceding-sibling::div/label")
	public WebElement moreInfoLabel;

	@FindBy(xpath = "//div[@data-container=\"booking-container\"] //button[@type=\"submit\"]")
	public WebElement scheduleEventButton;

	@FindBy(xpath = "//input[@id=\"full_name_input\"]/parent::div/following-sibling::div[@aria-live=\"assertive\"]")
	public WebElement fullNameErrorMsg;

	@FindBy(xpath = "//input[@id=\"email_input\"]/parent::div/following-sibling::div[@aria-live=\"assertive\"]")
	public WebElement emailErrorMsg;

	@FindBy(xpath = "//label[text()=\"Phone Number\"]/parent::div/following-sibling::div[@aria-live=\"assertive\"]")
	public WebElement phnNumErrorMsg;

	@FindBy(xpath = "//label[text()=\"Company Name\"]/parent::div/following-sibling::div[@aria-live=\"assertive\"]")
	public WebElement companyNameErrorMsg;

	@FindBy(xpath = "//div[@id=\"question_2-error\"][@aria-live=\"assertive\"]")
	public WebElement companySizeErrorMsg;

	@FindBy(xpath = "//div[@id=\"invitee_guest_errors\"]")
	public WebElement guestEmailErrorMsg;

	@FindBy(xpath = "//button[@aria-label=\"Go to previous page\"]")
	public WebElement backButton;

	@FindBy(xpath = "//div[@data-container=\"booking-container\"] //h1")
	public WebElement successMsgHeader;

	@FindBy(xpath = "//div[@data-container=\"booking-container\"] //h1/following-sibling::div")
	public WebElement successMsgInfo;

	@FindBy(xpath = "//div[@data-container=\"details\"]//h2")
	public WebElement successDetailHeader;

	@FindBy(xpath = "(//div[@data-container=\"details\"]//span)[2]")
	public WebElement successDetailName;

	@FindBy(xpath = "(//div[@data-container=\"details\"]/div)[5]")
	public WebElement successDetailEventType;

	@FindBy(xpath = "(//div[@data-container=\"details\"]/div)[6]")
	public WebElement successDetailGuestEmails;

	@FindBy(xpath = "//button[@id='onetrust-reject-all-handler']")
	public WebElement cookiesCloseBtn;

	@FindBy(xpath = "//button[@aria-label='Go to next month']")
	public WebElement nextmonth;
	
	@FindBy(xpath = "//button[@aria-current]")
	public WebElement currentDate;

	@FindBy(xpath = "//ngb-modal-window")
	public WebElement outSidePopPup;

	public String availableDates = "//button[contains(@aria-label,'Times available')]";
	public String availableTimes = "//button[@data-container=\"time-button\"]";
	public String timeZoneList = "//div[@role=\"group\"] //button/div";
	public String companySizeOptions = "//div[@data-component=\"option\"] //label";
    public String fullNameErrorMesg = "//input[@id=\"full_name_input\"]/parent::div/following-sibling::div[@aria-live=\"assertive\"]";
    public String emailErrorMesg = "//input[@id=\"email_input\"]/parent::div/following-sibling::div[@aria-live=\"assertive\"]";
    public String companyErrorMesg = "//label[text()=\"Company Name\"]/parent::div/following-sibling::div[@aria-live=\"assertive\"]";
    public String phnNumMesg = "//label[text()=\"Phone Number\"]/parent::div/following-sibling::div[@aria-live=\"assertive\"]";
    public String companysizeMesg = "//div[@id=\"question_2-error\"][@aria-live=\"assertive\"]";
    public String cookiesCloseButton = "//button[@id='onetrust-reject-all-handler']";
	
	public WebElement getDate(int currentDay, String currentMonth) {
		String date = currentMonth + " " + currentDay;
		return driver.findElement(By.xpath("//button[contains(@aria-label,'" + date + "')]"));
	}

}
