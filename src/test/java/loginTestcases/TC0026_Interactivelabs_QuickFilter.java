package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LMSPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0026_Interactivelabs_QuickFilter extends BaseClass {

	@Test
	public void interactiveLabQuickFilter() throws InterruptedException {
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
			lp.spinnerloader();
			lp.spinnerloader();
			lm.moveAndClick(lm.interactiveLabs);
			String[] quickFilter = lm.arrayGettext(lm.quickFilterOptions);
			for (int i = 0; i <= quickFilter.length-1; i++) {
				lm.moveAndClick(lm.getOption(lm.quickFilterOptions, i + 1));
				lm.spinnerloader();
				lm.moveAndClick(lm.getOption(lm.quickFilterOptions, i + 1));
				lm.spinnerloader();
			}
			lm.logoutQA();

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
