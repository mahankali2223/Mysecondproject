package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LMSPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0020_LMS_SearchFunctionality extends BaseClass {
	@Test
	public void shortCoursesSearch() throws InterruptedException {
		try {

			LoginPage lp = new LoginPage(driver);
			LMSPage lm = new LMSPage(driver);
			lm.navigateQA();
			lp.moveAndClick(lp.loginBttn);
			logger.info("Clicked on loginbutton");
			lp.sendKeys(lp.email, rb.getString("Emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("Psswd"));
			logger.info("Providing customer data");
			lp.click(lp.loginsubmit);
			logger.info("Clicked on loginsumbit");
			lm.spinnerloader();
			lm.spinnerloader();
			lp.click(lp.learn);
			lp.arrayGettext(lp.learnModules);
			lm.click(lm.shortCourses);
			lm.spinnerloader();
			lm.click(lm.freeCourses);
			lm.spinnerloader();
			lm.click(lm.search);
			lm.spinnerloader();
			lm.sendKeys(lm.search, "python");
			String[] courseName = lm.arrayGettext(lm.Coursesnames);
			Assert.assertEquals((courseName.length) > 0, true);
			lm.spinnerloader();
			lp.logoutQA();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test
	public void shortCoursesSearchNegative() throws InterruptedException {
		try {

			LoginPage lp = new LoginPage(driver);
			LMSPage lm = new LMSPage(driver);
			lm.navigateQA();
			lp.moveAndClick(lp.loginBttn);
			logger.info("Clicked on loginbutton");
			lp.sendKeys(lp.email, rb.getString("Emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("Psswd"));
			logger.info("Providing customer data");
			lp.click(lp.loginsubmit);
			logger.info("Clicked on loginsumbit");
			lm.spinnerloader();
			lm.spinnerloader();
			lm.spinnerloader();
			lp.click(lp.learn);
			lp.arrayGettext(lp.learnModules);
			lm.click(lm.shortCourses);
			lm.spinnerloader();
			lm.click(lm.purchased);
			lm.spinnerloader();
			lm.click(lm.search);
			lm.spinnerloader();
			lm.sendKeys(lm.search, "@1234");
			Assert.assertEquals(lm.getText(lm.searchResult),
					"You don't have any purchased courses yet or no purchased courses met these criteria.".trim());
			lp.logoutQA();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
