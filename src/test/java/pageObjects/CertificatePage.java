package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CertificatePage extends Basepage {

	public CertificatePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement certificateSearchInput;

	@FindBy(xpath = "//button[contains(@class,'custom-search-btn')]")
	public WebElement certificateSearchBtn;
	
	@FindBy(xpath = "//h2")
	public WebElement certificateHeader;
	
	@FindBy(xpath = "//h4[@class='text-center my-4']")
	public WebElement certificationCourse;

	@FindBy(xpath = "//div[@type='button']")
	public WebElement certificateFilter;

	public String certificateName = "//app-certificate-card //h5[contains(@class,'certificate-card__title')]";
	public String certificateType = "//div[@class='certificate-card__type']";
	public String certificateCompletionDate = "//app-certificate-card //div/following::h5[1][contains(@class,'certificate-card__sub-title')]";
	public String certificationScore = "//app-certificate-card //div/h5[contains(@class,'certificate-card__sub-title')]/following-sibling::h5";
	public String certificationViewBtn = "//app-certificate-card //a[contains(@class,'dark-btn-shadow')]";
	public String certificationFilterLabels = "//div[contains(@class,'dropdown-menu-custom ')]//label";

}
