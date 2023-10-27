package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LMSPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0023_Interactivelab_TypeFilter extends BaseClass {
	@Test(priority = 0)
	public void interactiveLabSearch() throws InterruptedException {
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
			lp.spinnerloader();
			lm.click(lm.labSearch);
			lp.spinnerloader();
			lm.sendKeys(lm.labSearch, "Practice");
			lm.spinnerloader();
			String[] labNames = lm.arrayGettext(lm.labNames);
			Assert.assertEquals((labNames.length) > 0, true);
			lm.logoutQA();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 1)
	public void interactiveLabSearchNegative() throws InterruptedException {
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
			lp.spinnerloader();
//			String header = lm.getText(lm.interActiveLabHeader);
//			String labHeader = "Interactive Labs";
//			Assert.assertEquals(header.trim(), labHeader.trim());
			lm.click(lm.labSearch);
			lp.spinnerloader();
			lm.sendKeys(lm.labSearch, "!@#Sgjie");
			lm.spinnerloader();
			Assert.assertEquals(lm.getText(lm.searchResult),
					"Looks like you haven’t Started any Interactive Labs yet!".trim());
			lm.logoutQA();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 2)
	public void interactiveLabTypeFilter() throws InterruptedException {
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
			lp.spinnerloader();
			lm.click(lm.typeDrpDwn);
			lp.spinnerloader();
			String[] typeFilter = lm.arrayGettext(lm.typeOptions);
			System.out.println(typeFilter.length);
			for (int i = 0; i < typeFilter.length; i++) {
				lm.moveAndClick(lm.getOption(lm.typeOptions, i + 1));
				lm.spinnerloader();
				String selectedOption;
				if (i == 0) {
					selectedOption = "Certification Lab";
				} else {
					selectedOption = lm.getOption(lm.typeOptions, i + 1).getText();
				}
				String[] labsUi = lm.arrayGettext(lm.labNames);
				for (String labs : labsUi) {
					System.out.println("Option : " + selectedOption + "Name : " + labs);
					if (!(labs.contains(selectedOption))) {
						Assert.assertEquals(true, false, "For " + selectedOption
								+ " type filter results didn't matched, found " + labs + " in result");
					}
				}
				lm.moveAndClick(lm.getOption(lm.typeOptions, i + 1));
				lm.spinnerloader();
			}
			lm.logoutQA();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 3)
	public void typeFilterMultipleOptions() throws InterruptedException {
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
			lm.spinnerloader();
			lm.moveAndClick(lm.interactiveLabs);
			lm.spinnerloader();
			lm.moveAndClick(lm.typeDrpDwn);
			lm.spinnerloader();
			// Two options
			String[] typeFilter = lm.arrayGettext(lm.typeOptions);
			for (int j = 0; j < typeFilter.length - 1; j++) {
				lm.moveAndClick(lm.getOption(lm.typeOptions, j + 1));
				lm.spinnerloader();
				String selectedOption;
				if (j == 0) {
					selectedOption = "Certification Lab";
				} else {
					selectedOption = lm.getOption(lm.typeOptions, j + 1).getText();
				}
				for (int i = j + 1; i < typeFilter.length; i++) {
					lm.moveAndClick(lm.getOption(lm.typeOptions, i + 1));
					lm.spinnerloader();
					String selectedOption1 = lm.getOption(lm.typeOptions, i + 1).getText();
					String[] labNamesUi = lm.arrayGettext(lm.labNames);
					for (String labName : labNamesUi) {
						if (!(labName.contains(selectedOption) || labName.contains(selectedOption1))) {
							Assert.assertEquals(true, false, "For " + selectedOption + " , " + selectedOption1
									+ " type filter results didn't matched, found " + labName + " in result");
						}
					}
					lm.moveAndClick(lm.getOption(lm.typeOptions, i + 1));
					lm.spinnerloader();
				}
				lm.moveAndClick(lm.getOption(lm.typeOptions, j + 1));
				lm.spinnerloader();
			}

//			// Three options
			for (int j = 0; j < typeFilter.length - 2; j++) {
				lm.moveAndClick(lm.getOption(lm.typeOptions, j + 1));
				lm.spinnerloader();
				lm.moveAndClick(lm.getOption(lm.typeOptions, j + 2));
				lm.spinnerloader();
				lm.spinnerloader();
				String selectedOption;
				if (j == 0) {
					selectedOption = "Certification Lab";
				} else {
					selectedOption = lm.getOption(lm.typeOptions, j + 1).getText();
				}
				String selectedOption1 = lm.getOption(lm.typeOptions, j + 2).getText();
				for (int i = j + 2; i < typeFilter.length; i++) {
					lm.moveAndClick(lm.getOption(lm.typeOptions, i + 1));
					lm.spinnerloader();
					String selectedOption2 = lm.getOption(lm.typeOptions, i + 1).getText();
					Thread.sleep(3000);
					String[] labNamesUi = lm.arrayGettext(lm.labNames);
					for (String labName : labNamesUi) {
						if (!(labName.contains(selectedOption) || labName.contains(selectedOption1)
								|| labName.contains(selectedOption2))) {
							Assert.assertEquals(true, false,
									"For " + selectedOption + " , " + selectedOption1 + " , " + selectedOption2
											+ " type filter results didn't matched, found " + labName + " in result");
						}
					}
					lm.moveAndClick(lm.getOption(lm.typeOptions, i + 1));
					lm.spinnerloader();
				}
				lm.moveAndClick(lm.getOption(lm.typeOptions, j + 1));
				lm.spinnerloader();
				lm.moveAndClick(lm.getOption(lm.typeOptions, j + 2));
				lm.spinnerloader();
			}
			lm.logoutQA();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
