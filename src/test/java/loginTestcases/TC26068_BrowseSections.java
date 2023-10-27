package loginTestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Browse;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC26068_BrowseSections extends BaseClass {

	@Test
	public void testBrowseSection() throws InterruptedException {

		try {

			LoginPage lp = new LoginPage(driver);
			Browse browser = new Browse(driver);
			browser.navigate();
			lp.moveAndClick(lp.loginButton);
			lp.sendKeys(lp.email, rb.getString("emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("psswd"));
			lp.click(lp.loginsubmit);
			lp.spinnerloader();
			lp.spinnerloader();
			Assert.assertEquals(lp.getText(lp.browser).trim(), "Browse".trim());
			lp.click(lp.browser);
			Assert.assertEquals(browser.getText(browser.courseHeader).trim(), "Course Categories".trim());
			System.out.println("courseHeader");
			Assert.assertEquals(browser.getText(browser.popularCoursesHeader).trim(), "Popular Courses".trim());
			System.out.println("popularCoursesHeader");
			Assert.assertEquals(browser.getText(browser.learningPathHeader).trim(), "Trending Learning Paths".trim());
			System.out.println("learningPathHeader");
			Assert.assertEquals(browser.getText(browser.searchingHeader).trim(), "People Are Searching For".trim());
			System.out.println("searchingHeader");

			String[] courseOption = { "Software Development", "DevSecOps", "Security Architecture and Operations",
					"Governance, Risk, and Compliance", "Industrial Security Controls",
					"Vulnerability Assessment and Pentesting", "Cybersecurity", "Cloud Security", "Data Science" };
			String[] courseOptionUi = browser.arrayGettext(browser.course);
			Assert.assertEquals(courseOptionUi, courseOption);
			System.out.println("courseOption");

			String[] popularCourses = browser.arrayGettext(browser.popularCourses);
			String[] trendingCourses = browser.arrayGettext(browser.trendingCourses);
			List<WebElement> list = driver.findElements(By.xpath("//li[contains(@class,'d-flex justify-content')]"));
			for (int i = 0; i < list.size(); i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", list.get(i));
				Actions actions = new Actions(driver);
				actions.moveToElement(list.get(i)).perform();
				String[] popularCoursesUpdated = browser.arrayGettext(browser.popularCourses);
				String[] trendingCoursesUpdated = browser.arrayGettext(browser.trendingCourses);
				Assert.assertEquals(popularCoursesUpdated.equals(popularCourses), false, "Popular courses not updated");
				Assert.assertEquals(trendingCoursesUpdated.equals(trendingCourses), false,
						"Trending courses not updated");
			}

			lp.logout();
			System.out.println("logout");

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}

	}

}
