package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LMSPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0025_Interactivelabs_CombinedFilter extends BaseClass {

	@Test
	public void interactiveCombinedFilter() throws InterruptedException {
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
			lm.moveAndClick(lm.interactiveLabs);
			lm.spinnerloader();
			for (int i = 0; i < 3; i++) {
				lm.moveAndClick(lm.typeDrpDwn);
				lm.spinnerloader();
				lm.moveAndClick(lm.getOption(lm.typeOptions, i + 1));
				lm.spinnerloader();
				lm.moveAndClick(lm.catergoryDrpDwn);
				lm.spinnerloader();
				lm.moveAndClick(lm.getOption(lm.categoryOptions, i + 1));
				lm.moveAndClick(lm.catergoryDrpDwn);
				lm.spinnerloader();
				String selectedOption;
				if (i == 0) {
					selectedOption = "Certification Lab";
				} else {
					selectedOption = lm.getOption(lm.typeOptions, i + 1).getText();
				}
				String selectedOption1 = lm.getOption(lm.categoryOptions, i + 1).getText();
				String[] labsUi = lm.arrayGettext(lm.labNames);
				for (String labs : labsUi) {
					if (!(labs.contains(selectedOption))) {
						Assert.assertEquals(true, false, "For " + selectedOption + " type filter and " + selectedOption1
								+ " typeFilter results didn't matched, found " + labs + " labname in result");
					}
				}
				String[] labUi = lm.arrayGettext(lm.categoryLabels);
				for (String labs : labUi) {
					if (!(labs.contains(selectedOption1))) {
						Assert.assertEquals(true, false,
								"For " + selectedOption + " type filter and " + selectedOption1
										+ " category filter results didn't matched, found " + labs
										+ " category name in result");
					}
				}
				lm.moveAndClick(lm.typeDrpDwn);
				lm.spinnerloader();
				lm.moveAndClick(lm.getOption(lm.typeOptions, i + 1));
				lm.spinnerloader();
				lm.moveAndClick(lm.catergoryDrpDwn);
				lm.spinnerloader();
				lm.moveAndClick(lm.getOption(lm.categoryOptions, i + 1));
				lm.spinnerloader();
				lm.moveAndClick(lm.catergoryDrpDwn);
			}
			lm.logoutQA();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
