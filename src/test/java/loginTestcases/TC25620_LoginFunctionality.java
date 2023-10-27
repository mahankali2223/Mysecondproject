package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC25620_LoginFunctionality extends BaseClass {
	@Test
	public void testAccountLogin() throws InterruptedException {
		logger.debug("application logs......");
		logger.info("***  TC25620_LoginFunctionality ***");
		try {
			LoginPage lp = new LoginPage(driver);
			lp.navigateQA();
			lp.moveAndClick(lp.loginBttn);
			logger.info("Clicked on loginbutton");
			lp.sendKeys(lp.email, rb.getString("Emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("Psswd"));
			logger.info("Providing customer data");
			lp.click(lp.loginsubmit);
			logger.info("Clicked on loginsumbit");
			lp.spinnerloader();
			lp.spinnerloader();
//		    String welmsg = lp.getText(lp.welComemessg);
////		    // Checking Message on screen
//		    String mesg = "Welcome, mahankali!";
//		    Assert.assertEquals(welmsg, mesg);
			Assert.assertEquals(lp.getText(lp.browser).trim(), "Browse".trim());
			Assert.assertEquals(lp.getText(lp.enterprise).trim(), "Enterprise".trim());
			Assert.assertEquals(lp.getText(lp.home).trim(), "Home".trim());
			Assert.assertEquals(lp.getText(lp.weeklyGoals).trim(), "Weekly Goal Tracker".trim());
			Assert.assertEquals(lp.getText(lp.learn).trim(), "Learn".trim());
			Assert.assertEquals(lp.getText(lp.interactiveLabs).trim(), "Interactive Labs".trim());
			Assert.assertEquals(lp.getText(lp.officialEcourse).trim(), "Official eCourseware".trim());
			Assert.assertEquals(lp.getText(lp.examVouchers).trim(), "Exam Vouchers".trim());
			Assert.assertEquals(lp.getText(lp.certificates).trim(), "Certificates".trim());
			lp.click(lp.learn);
			lp.arrayGettext(lp.learnModules);
			Thread.sleep(3000);
			lp.logoutQA();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}

		logger.info("***  TC25620_LoginFunctionality ***");
	}

}
