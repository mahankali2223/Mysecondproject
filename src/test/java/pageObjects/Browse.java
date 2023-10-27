package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Browse extends Basepage {
	
	public Browse(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[text()='Course Categories']")
	public WebElement courseHeader;
	
	@FindBy(xpath = "//input[@type='search']")
	public WebElement search;
	
	@FindBy(xpath = "//div[contains(@class, \"search-form\")] //button")
	public WebElement searchButton;
	
	@FindBy(xpath = "(//h2)[2]")
	public WebElement searchHeader;
	
	@FindBy(xpath = "//a[text()=' Apply Filters ']")
	public WebElement applyFilter;
	
	@FindBy(xpath = "//div[@class='range-selection']//div[@id]")
	public WebElement rangeSelection;
	
	@FindBy(xpath = "//input[contains(@id,'jobRole')]")
	public WebElement jobRole;
	
	@FindBy(xpath = "//input[contains(@id,'specialtyArea')]")
	public WebElement specialtyArea;
	
	@FindBy(xpath = "//input[contains(@id,'level')]")
	public WebElement skillLevel;
	
	@FindBy(xpath = "//input[contains(@id,'category')]")
	public WebElement categories;
	
	@FindBy(xpath ="//h3[text()='Popular Courses']")
	public WebElement popularCoursesHeader;
	
	@FindBy(xpath ="//h3[text()='Trending Learning Paths']")
	public WebElement learningPathHeader;
	
	@FindBy(xpath = "//h3[text()='People Are Searching For']")
	public WebElement searchingHeader;
	
	@FindBy(xpath = "//app-sidebar-categories//input[@type='text']")
	public WebElement categorySearch;
	
	@FindBy(xpath = "//app-sidebar-skill//input[@type='text']")
	public WebElement skillSearch;
	
	@FindBy(xpath = "//app-sidebar-specialty-area//input[@type='text']")
	public WebElement specialityAreaSearch;
	
	@FindBy(xpath = "//app-sidebar-job-role//input[@type='text']")
	public WebElement jobRoleSearch;

	
	
	public String course = "//li[contains(@class,'d-flex justify-content')]";
	
	public String popularCourses = "(//div[contains(@class,'menu-section')])[1]//li";
	
	public String trendingCourses = "(//div[contains(@class,'menu-section')])[2]//li";
	
	public String coursesName = "//app-course-card //p[contains(@class,\"black\")]";
	
	public String coursesLabel = "//app-course-card //span[contains(@class, \"badge\")]";
	
	public String coursesLevel = "//div[@class=\"d-inline-block\"] //span[contains(@class, \"md-grey\")]";
	
	public String typeFilters = "//app-sidebar-types //label";
	
	public String categoryFilters = "//input[contains(@id,'category')]/following-sibling::label";
	
	public String skillsFilters = "//input[contains(@id,'level')]/following-sibling::label";
	
	public String specialtyAreaFilters = "//input[contains(@id,'specialtyArea')]/following-sibling::label";
	
	public String jobRoleFilters = "//input[contains(@id,'jobRole')]/following-sibling::label";
	

		public void Coursesoptions() throws InterruptedException {
	    	List<WebElement> list = driver.findElements(By.xpath("//li[contains(@class,'d-flex justify-content')]"));
	    	for(int i=0; i<list.size();i++) {
	    		JavascriptExecutor js = (JavascriptExecutor) driver;
	    		js.executeScript("arguments[0].scrollIntoView();",list.get(i) );
				Actions actions = new Actions(driver);
				actions.moveToElement(list.get(i)).perform();
				Thread.sleep(10000);
	    	}
	    	
	    }
	 
	 public WebElement getPopularCourse(int numberOfOption) {
		 List<WebElement> list = driver.findElements(By.xpath("(//div[contains(@class,'menu-section')])[1]//li"));
	    		JavascriptExecutor js = (JavascriptExecutor)driver;
	        	js.executeScript("arguments[0].scrollIntoView();",list.get(numberOfOption-1));
	    	return list.get(numberOfOption-1);
	 }
	 
	 public WebElement getTrendingCourse(int numberOfOption) {
		 List<WebElement> list = driver.findElements(By.xpath("(//div[contains(@class,'menu-section')])[2]//li"));
	    		JavascriptExecutor js = (JavascriptExecutor)driver;
	        	js.executeScript("arguments[0].scrollIntoView();",list.get(numberOfOption-1));
	    	return list.get(numberOfOption-1);
	 }
	 
//	 public void catergoryOption(String option) {
//	    	driver.findElement(By.xpath("//app-sidebar-categories//input[@type='text']")).sendKeys(option);
//	    	List<WebElement> list	= driver.findElements(By.xpath("categoryFilters"));
//	    		for(int i=0; i<list.size(); i++) {
//	    			if(list.get(i).getText().contains(option)){
//	    				WebDriverWait Mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    				Mywait.until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
//	    				break;
//	    			}
//	    		}
//		}
}
