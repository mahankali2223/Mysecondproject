package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LMSPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0024_Interactivelab_Categoryfilter extends BaseClass {

	@Test
	public void interactiveLabCategoryFilter() throws InterruptedException {
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
			lm.moveAndClick(lm.catergoryDrpDwn);
			lm.spinnerloader();
			String[] catergoryFilter = lm.arrayGettext(lm.categoryOptions);
			lm.moveAndClick(lm.catergoryDrpDwn);
			System.out.println(catergoryFilter.length);
			for (int i = 0; i < catergoryFilter.length; i++) {
				lm.moveAndClick(lm.catergoryDrpDwn);
				lm.moveAndClick(lm.getOption(lm.categoryOptions, i + 1));
				lm.spinnerloader();
				lm.moveAndClick(lm.catergoryDrpDwn);
				lm.spinnerloader();
				String selectedOption = lm.getOption(lm.categoryOptions, i + 1).getText();
				String[] categoryNamesUi = lm.arrayGettext(lm.categoryLabels);
				for (String labels : categoryNamesUi) {
					System.out.println("Option : " + selectedOption + "Name : " + labels);
					if (!(labels.contains(selectedOption))) {
						Assert.assertEquals(true, false, "For " + selectedOption
								+ " category filter results didn't matched, found " + labels + " in result");
					}
				}
				lm.moveAndClick(lm.catergoryDrpDwn);
				lm.spinnerloader();
				lm.moveAndClick(lm.getOption(lm.categoryOptions, i + 1));
				lm.spinnerloader();
				lm.moveAndClick(lm.catergoryDrpDwn);
				lm.spinnerloader();
			}
			lm.logoutQA();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test
	public void CategoryFilterMultipleOptions() throws InterruptedException {
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
			lm.moveAndClick(lm.catergoryDrpDwn);
			lm.spinnerloader();
//			// Two options
			for (int j = 0; j < 4; j++) {
				lm.moveAndClick(lm.getOption(lm.categoryOptions, j + 1));
				lm.spinnerloader();
				String selectedOption = lm.getOption(lm.categoryOptions, j + 1).getText();
				for (int i = j + 1; i < 5; i++) {
					lm.moveAndClick(lm.getOption(lm.categoryOptions, i + 1));
					lm.moveAndClick(lm.catergoryDrpDwn);
					lm.spinnerloader();
					String selectedOption1 = lm.getOption(lm.categoryOptions, i + 1).getText();
					String[] categoryUi = lm.arrayGettext(lm.categoryLabels);
					for (String category : categoryUi) {
						if (!(category.contains(selectedOption) || category.contains(selectedOption1))) {
							Assert.assertEquals(true, false, "For " + selectedOption + " , " + selectedOption1
									+ " type filter results didn't matched, found " + category + " in result");
						}
					}
					lm.moveAndClick(lm.catergoryDrpDwn);
					lm.spinnerloader();
					lm.moveAndClick(lm.getOption(lm.categoryOptions, i + 1));
					lm.spinnerloader();
				}
				lm.moveAndClick(lm.getOption(lm.categoryOptions, j + 1));
				lm.spinnerloader();
			}

			// Three options
			for (int j = 0; j < 3; j++) {
				lm.moveAndClick(lm.getOption(lm.categoryOptions, j + 1));
				lm.spinnerloader();
				lm.moveAndClick(lm.getOption(lm.categoryOptions, j + 2));
				lm.spinnerloader();
				String selectedOption = lm.getOption(lm.categoryOptions, j + 1).getText();
				String selectedOption1 = lm.getOption(lm.categoryOptions, j + 2).getText();
				for (int i = j + 2; i < 5; i++) {
					lm.moveAndClick(lm.getOption(lm.categoryOptions, i + 1));
					lm.spinnerloader();
					lm.moveAndClick(lm.catergoryDrpDwn);
					String selectedOption2 = lm.getOption(lm.categoryOptions, i + 1).getText();
					Thread.sleep(3000);
					String[] categoryUi = lm.arrayGettext(lm.categoryLabels);
					for (String category : categoryUi) {
						if (!(category.contains(selectedOption) || category.contains(selectedOption1)
								|| category.contains(selectedOption2))) {
							Assert.assertEquals(true, false,
									"For " + selectedOption + " , " + selectedOption1 + " , " + selectedOption2
											+ " type filter results didn't matched, found " + category + " in result");
						}
					}
					lm.moveAndClick(lm.catergoryDrpDwn);
					lm.moveAndClick(lm.getOption(lm.categoryOptions, i + 1));
					lm.spinnerloader();
				}
				lm.moveAndClick(lm.catergoryDrpDwn);
				lm.moveAndClick(lm.getOption(lm.categoryOptions, j + 1));
				lm.spinnerloader();
				lm.moveAndClick(lm.getOption(lm.categoryOptions, j + 2));
				lm.spinnerloader();
				lm.moveAndClick(lm.catergoryDrpDwn);
				lm.spinnerloader();
			}
			lm.logoutQA();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
