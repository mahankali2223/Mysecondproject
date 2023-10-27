package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LMSPage extends Basepage {
	public LMSPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//a[text()=' Short Courses '])[1]")
	public WebElement shortCourses;

	@FindBy(xpath = "(//a[text()=' Learning Paths '])[1]")
	public WebElement learningPath;

	@FindBy(xpath = "(//a[text()=' Bundles '])[1]")
	public WebElement bundles;

	@FindBy(xpath = "(//a[text()=' Microdegrees '])[1]")
	public WebElement microDegree;

	@FindBy(xpath = "//h2")
	public WebElement shortCoursesheader;

	@FindBy(xpath = "//h5[text()='In progress']")
	public WebElement inProgress;

	@FindBy(xpath = "//h5[text()='Purchased']")
	public WebElement purchased;

	@FindBy(xpath = "//h5[text()='Completed']")
	public WebElement completed;

	@FindBy(xpath = "(//div//span[text()='Interactive Labs'])[1]")
	public WebElement interactiveLabs;

	@FindBy(xpath = "//input[@placeholder='Search for any lab']")
	public WebElement labSearch;

	@FindBy(xpath = "//h5[text()='Free Courses']")
	public WebElement freeCourses;

	@FindBy(xpath = "//div[@id=\"headingOne\"]")
	public List<WebElement> CourseList;

	@FindBy(xpath = "//h5[@class=\"font-bold tertiary\"]")
	public List<WebElement> bundlecourseListLable;

	@FindBy(xpath = "//h5[@class=\"primary font-bold\"]")
	public List<WebElement> bundleCourseListName;

	@FindBy(xpath = "//div[@id=\"headingOne\"] //a")
	public List<WebElement> CourseListButton;

	@FindBy(xpath = "//div[@id=\"headingOne\"] //span[contains(@class,'font-weight-bold')] ")
	public List<WebElement> bundleCourseListExplore;

	@FindBy(xpath = "//input[@placeholder='Search for courses']")
	public WebElement search;

	@FindBy(xpath = "//h3")
	public WebElement searchResult;

	@FindBy(xpath = "//h1[contains(@class,'font-bold')]")
	public WebElement courseHeader;

	@FindBy(xpath = "//a[contains(@class,'orange-purple-bg')]")
	public WebElement resumeCourse;

	@FindBy(xpath = "//a[contains(@class,'btn-radius')]")
	public WebElement startcourses;

	@FindBy(xpath = "//a[contains(@class,'primary-bg dark-btn-shadow')]")
	public WebElement learnMore;

	@FindBy(xpath = "//button[contains(@class,'btn btn-labeled')]")
	public WebElement lunchLab;

	@FindBy(xpath = "//input[@formcontrolname='display_name']")
	public WebElement displayName;

	@FindBy(xpath = "//button[contains(@class,'btn text-white')]")
	public WebElement submit;

	@FindBy(xpath = "//a[contains(@class,'radius-8')]")
	public WebElement close;

	@FindBy(xpath = "//button[contains(@class,'black-bg btn')]")
	public WebElement confirmProceed;

	@FindBy(xpath = "//a[contains(@class,'bg-white primary')]")
	public WebElement GoToDashBoard;

	@FindBy(xpath = "//app-internal-course-nav-bar //span[text()=\"Mark as complete\"]")
	public WebElement markComplete;

	@FindBy(xpath = "//app-internal-course-nav-bar //span[text()=\"Leave a review\"]")
	public WebElement leaveReview;

	@FindBy(xpath = "//div[@aria-live=\"assertive\"] //button[contains(@class, 'swal2-cancel')]")
	public WebElement popupCancel;

	@FindBy(xpath = "//div[@aria-live=\"assertive\"] //button[contains(@class, 'swal2-confirm')]")
	public WebElement popupConfirm;

	@FindBy(xpath = "(//app-internal-course-chapters)[1] //li[contains(@class,\"li-active\")] //span")
	public WebElement selectedLesson;

	@FindBy(xpath = "(//app-internal-course-chapters)[1]//i[contains(@class,'fa-play-circle')]")
	public WebElement lessonPlayIcon;

	@FindBy(xpath = "(//app-internal-course-chapters)[1]//p[contains(@class,'chapter-font')]")
	public List<WebElement> chapterslist;

	@FindBy(xpath = "(//app-internal-course-chapters)[1]//i[contains(@class,'pointer')]")
	public List<WebElement> chapterIconlist;

	@FindBy(xpath = "//app-courses-section//ngb-accordion//a")
	public List<WebElement> startCourseList;

	@FindBy(xpath = "//app-internal-course-quize//p[@class=\"mb-2\"]")
	public WebElement quizQuestionLabel;

	@FindBy(xpath = "//app-internal-course-quize//a")
	public WebElement quizNextbtn;

	@FindBy(xpath = "//app-internal-course-quize//label/p")
	public List<WebElement> quizOptions;

	@FindBy(xpath = "//h2")
	public WebElement interActiveLabHeader;

	@FindBy(xpath = "(//div[contains(@class,'form-control radius-5')])[1]")
	public WebElement catergoryDrpDwn;

	@FindBy(xpath = "(//div[@class='btn-group dropdown'])[1]")
	public WebElement typeDrpDwn;

	@FindBy(xpath = "//a[contains(@class,'continue-learning-btn')]")
	public WebElement microGoToDashBoard;

	@FindBy(xpath = "//a[contains(@class,'bg-white btn')]")
	public WebElement startLearning;

	@FindBy(xpath = "(//span[text()='Certificates'])[1]")
	public WebElement certificates;

	@FindBy(xpath = "//h6/span")
	public WebElement certificatesNames;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement playButton;

	@FindBy(xpath = "//button[contains(@class,'launchbutton')]")
	public WebElement LaunchButton;

	@FindBy(xpath = "(//button[@placement=\"bottom\"])[1]")
	public WebElement terminateButton;

	@FindBy(xpath = "(//button[@class='btn btn-danger'])[2]")
	public WebElement finishButton;

	@FindBy(xpath = "//h5")
	public WebElement playHeader;

	@FindBy(xpath = "(//div[@class='col-12 p-2'])[2]")
	public WebElement launchLabTime;

	@FindBy(xpath = "//div[@class=\"card inner-card launchFirst\"]/div")
	public WebElement moduleName;

	@FindBy(xpath = "//div[text()= ' Lab Queue Position: ']")
	public WebElement labQueue;

	@FindBy(xpath = "//div[text()=' Lab Copy State: ']")
	public WebElement labCpyState;

	@FindBy(xpath = "//div[text()=' Lab Creation Progress: ']")
	public WebElement labCreationProgress;

	@FindBy(xpath = "//div[text()=' Lab Redirection State: ']")
	public WebElement labRedirection;

	@FindBy(xpath = "//h5")
	public WebElement finishLabHeader;

	@FindBy(xpath = "//p/b")
	public WebElement finishLabQuestion;

	@FindBy(xpath = "//div[text()=' Lab Launch State: ']")
	public WebElement labLaunchState;

	@FindBy(xpath = "//div[@class='p-4']")
	public WebElement closedWindowSuccessMeg;

	@FindBy(xpath = "//div[@role='alertdialog']")
	public WebElement terminatedSuccessMeg;

	public WebElement getLessonIcon(String lessonName) {
		WebElement lessonIcon = driver.findElement(By.xpath("(//app-internal-course-chapters)[1] //span[text()="
				+ lessonName + "]/parent::div/preceding-sibling::div //i"));
		return lessonIcon;
	}

	public String levels = "//div[@class='d-flex mt-3']//h5";
	public String Coursesnames = "//app-course-card //p[contains(@class,\"black\")]";
	public String bundleNames = "//h5[contains(@class,'learn-path-card__color')]";
	public String lessonsPlayIcon = "(//app-internal-course-chapters)[1]//i[contains(@class,'fa-play-circle')]";
	public String labNames = "//h6[contains(@class,'tertiary')]";
	public String typeOptions = "(//div[contains(@class, \"container-fluid\")] //div[@ngbdropdown])[3] //label";
	public String categoryOptions = "(//div[contains(@class, \"container-fluid\")] //div[@ngbdropdown])[2]//label";
	public String categoryLabels = "//div[contains(@class,'sub-category-position')]";
	public String quickFilterOptions = "(//div[contains(@class,'flex-wrap')])[1]//div";
	public String microDegreeNames = "//h5[contains(@class,'microdegree-card__title')]";
	public String certificatesName = "//h6/span";

}
