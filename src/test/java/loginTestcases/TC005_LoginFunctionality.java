package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC005_LoginFunctionality extends BaseClass {
	@Test
	public void testAccountLogin() throws InterruptedException {
		logger.debug("application logs......");
		logger.info("***  TC25620_LoginFunctionality ***");
		try {
			LoginPage lp = new LoginPage(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginButton);
			logger.info("clicked loginbtn");
			lp.sendKeys(lp.email, rb.getString("emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("psswd"));
			logger.info("providing customer data");
			lp.click(lp.loginsubmit);
			logger.info("clicked submitbtn");
			lp.spinnerloader();
			lp.spinnerloader();
			String welmsg = lp.getText(lp.welComemsg);
			// Checking Message on screen
			String mesg = "Welcome, Lavanya!";
			Assert.assertEquals(welmsg, mesg);
			lp.logout();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
		
		logger.info("***TC005_LoginFunctionality ***");
	}

}
