package loginTestcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Browse;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0017SearchFilterFunctionality extends BaseClass {

	@Test(priority = 0)
	public void testFilters() throws InterruptedException {
		try {
//
			LoginPage lp = new LoginPage(driver);
			Browse browse = new Browse(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginButton);
			lp.sendKeys(lp.email, rb.getString("emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("psswd"));
			lp.click(lp.loginsubmit);
			lp.spinnerloader();
			lp.spinnerloader();
			browse.click(browse.searchButton);
			lp.spinnerloader();
//			String[] typesText = { "Learning Paths".trim(), "Courses".trim() };
//			String[] typesText1 = { "Courses".trim() };
//			String[] typesText2 = { "Learning Paths".trim() };
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3")));
//			String[] types = browse.arrayGettext("//h3");
//			Assert.assertEquals(types.equals(typesText), true, "Types didnt match");

			browse.getOption(browse.typeFilters, 1).click();
			browse.click(browse.applyFilter);
			browse.spinnerloader();
//			types = browse.arrayGettext("//h3");
//			Assert.assertEquals(types.equals(typesText1), true, "Only courses section is not visible");

			browse.getOption(browse.typeFilters, 2).click();
			browse.click(browse.applyFilter);
			browse.spinnerloader();
			browse.spinnerloader();
//			types = browse.arrayGettext("//h3");
//			Assert.assertEquals(types.equals(typesText), true, "All section is not visible");

			browse.getOption(browse.typeFilters, 1).click();
			browse.click(browse.applyFilter);
			browse.spinnerloader();
			browse.spinnerloader();
//			types = browse.arrayGettext("//h3");
//			Assert.assertEquals(types.equals(typesText2), true, "Only learning section is not visible");

			browse.getOption(browse.typeFilters, 2).click();
			browse.click(browse.applyFilter);
			browse.spinnerloader();
			browse.spinnerloader();
//			types = browse.arrayGettext("//h3");
//			Assert.assertEquals(types.equals(typesText), true, "All section is not visible");

			lp.logout();
			System.out.println("logout");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 1)
	public void categoriesFilters() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			Browse browse = new Browse(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginButton);
			lp.sendKeys(lp.email, rb.getString("emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("psswd"));
			lp.click(lp.loginsubmit);
			lp.spinnerloader();
			lp.spinnerloader();
			browse.click(browse.searchButton);
			lp.spinnerloader();
			browse.spinnerloader();
			String[] categoryFilters = browse.arrayGettext(browse.categoryFilters);

			// Individual option
			for (int i = 0; i < 2; i++) {
				browse.getOption(browse.categoryFilters, i + 1).click();
				String selectedOption = browse.getOption(browse.categoryFilters, i + 1).getText();
				browse.click(browse.applyFilter);
				browse.spinnerloader();
				browse.spinnerloader();
				String[] categoryUi = browse.arrayGettext(browse.coursesLabel);
				for (String category : categoryUi) {
					if (!(category.contains(selectedOption))) {
						Assert.assertEquals(true, false, "Result didnt filter according to selected Category");
					}
				}
				browse.getOption(browse.categoryFilters, i + 1).click();
			}

			// Two options
			for (int j = 0; j < 2; j++) {
				browse.getOption(browse.categoryFilters, j + 1).click();
				String selectedOption = browse.getOption(browse.categoryFilters, j + 1).getText();
				for (int i = j + 1; i < 3; i++) {
					browse.getOption(browse.categoryFilters, i + 1).click();
					String selectedOption1 = browse.getOption(browse.categoryFilters, i + 1).getText();
					browse.click(browse.applyFilter);
					browse.spinnerloader();
					browse.spinnerloader();
					String[] categoryUi = browse.arrayGettext(browse.coursesLabel);
					for (String category : categoryUi) {
						System.out.println("[ " + selectedOption + " , " + selectedOption1 + " ] contains " + category);
						if (!(category.contains(selectedOption) || category.contains(selectedOption1))) {
							Assert.assertEquals(true, false, "Result didnt filter according to selected Category");
						}
					}
					browse.getOption(browse.categoryFilters, i + 1).click();
				}
				browse.getOption(browse.categoryFilters, j + 1).click();
			}

			// Three options
			for (int j = 0; j < 2; j++) {
				browse.getOption(browse.categoryFilters, j + 1).click();
				browse.getOption(browse.categoryFilters, j + 2).click();
				String selectedOption = browse.getOption(browse.categoryFilters, j + 1).getText();
				String selectedOption1 = browse.getOption(browse.categoryFilters, j + 2).getText();
				for (int i = j + 2; i < 4; i++) {
					browse.getOption(browse.categoryFilters, i + 1).click();
					String selectedOption2 = browse.getOption(browse.categoryFilters, i + 1).getText();
					browse.click(browse.applyFilter);
					browse.spinnerloader();
					browse.spinnerloader();
					String[] categoryUi = browse.arrayGettext(browse.coursesLabel);
					for (String category : categoryUi) {
						if (!(category.contains(selectedOption) || category.contains(selectedOption1)
								|| category.contains(selectedOption2))) {
							Assert.assertEquals(true, false, "Result didnt filter according to selected category");
						}
					}
					browse.getOption(browse.categoryFilters, i + 1).click();
				}
				browse.getOption(browse.categoryFilters, j + 1).click();
				browse.getOption(browse.categoryFilters, j + 2).click();
			}
			// Four options
			for (int j = 0; j < 2; j++) {
				browse.getOption(browse.categoryFilters, j + 1).click();
				browse.getOption(browse.categoryFilters, j + 2).click();
				browse.getOption(browse.categoryFilters, j + 3).click();
				String selectedOption = browse.getOption(browse.categoryFilters, j + 1).getText();
				String selectedOption1 = browse.getOption(browse.categoryFilters, j + 2).getText();
				String selectedOption2 = browse.getOption(browse.categoryFilters, j + 3).getText();
				for (int i = j + 3; i < 5; i++) {
					browse.getOption(browse.categoryFilters, i + 1).click();
					String selectedOption3 = browse.getOption(browse.categoryFilters, i + 1).getText();
					browse.click(browse.applyFilter);
					lp.spinnerloader();
					browse.spinnerloader();
					String[] categoryUi = browse.arrayGettext(browse.coursesLabel);
					for (String category : categoryUi) {
						if (!(category.contains(selectedOption) || category.contains(selectedOption1)
								|| category.contains(selectedOption2) || category.contains(selectedOption3))) {
							Assert.assertEquals(true, false, "Result didnt filter according to selected category");
						}
					}
					browse.getOption(browse.categoryFilters, i + 1).click();
				}
				browse.getOption(browse.categoryFilters, j + 1).click();
				browse.getOption(browse.categoryFilters, j + 2).click();
				browse.getOption(browse.categoryFilters, j + 3).click();
			}

			// Five options
			for (int j = 0; j < 2; j++) {
				browse.getOption(browse.categoryFilters, j + 1).click();
				browse.getOption(browse.categoryFilters, j + 2).click();
				browse.getOption(browse.categoryFilters, j + 3).click();
				browse.getOption(browse.categoryFilters, j + 4).click();
				String selectedOption = browse.getOption(browse.categoryFilters, j + 1).getText();
				String selectedOption1 = browse.getOption(browse.categoryFilters, j + 2).getText();
				String selectedOption2 = browse.getOption(browse.categoryFilters, j + 3).getText();
				String selectedOption3 = browse.getOption(browse.categoryFilters, j + 4).getText();
				for (int i = j + 4; i < 7; i++) {
					browse.getOption(browse.categoryFilters, i + 1).click();
					String selectedOption4 = browse.getOption(browse.categoryFilters, i + 1).getText();
					browse.click(browse.applyFilter);
					browse.spinnerloader();
					browse.spinnerloader();
					String[] categoryUi = browse.arrayGettext(browse.coursesLabel);
					for (String category : categoryUi) {
						if (!(category.contains(selectedOption) || category.contains(selectedOption1)
								|| category.contains(selectedOption2) || category.contains(selectedOption3)
								|| category.contains(selectedOption4))) {
							Assert.assertEquals(true, false, "Result didnt filter according to selected category");
						}
					}
					browse.getOption(browse.categoryFilters, i + 1).click();
				}
				browse.getOption(browse.categoryFilters, j + 1).click();
				browse.getOption(browse.categoryFilters, j + 2).click();
				browse.getOption(browse.categoryFilters, j + 3).click();
				browse.getOption(browse.categoryFilters, j + 4).click();
			}

			// Six options
			for (int j = 0; j < 2; j++) {
				browse.getOption(browse.categoryFilters, j + 1).click();
				browse.getOption(browse.categoryFilters, j + 2).click();
				browse.getOption(browse.categoryFilters, j + 3).click();
				browse.getOption(browse.categoryFilters, j + 4).click();
				browse.getOption(browse.categoryFilters, j + 5).click();
				String selectedOption = browse.getOption(browse.categoryFilters, j + 1).getText();
				String selectedOption1 = browse.getOption(browse.categoryFilters, j + 2).getText();
				String selectedOption2 = browse.getOption(browse.categoryFilters, j + 3).getText();
				String selectedOption3 = browse.getOption(browse.categoryFilters, j + 4).getText();
				String selectedOption4 = browse.getOption(browse.categoryFilters, j + 5).getText();
				for (int i = j + 5; i < 8; i++) {
					browse.getOption(browse.categoryFilters, i + 1).click();
					String selectedOption5 = browse.getOption(browse.categoryFilters, i + 1).getText();
					browse.click(browse.applyFilter);
					browse.spinnerloader();
					browse.spinnerloader();
					String[] categoryUi = browse.arrayGettext(browse.coursesLabel);
					for (String category : categoryUi) {
						if (!(category.contains(selectedOption) || category.contains(selectedOption1)
								|| category.contains(selectedOption2) || category.contains(selectedOption3)
								|| category.contains(selectedOption4) || category.contains(selectedOption5))) {
							Assert.assertEquals(true, false, "Result didnt filter according to selected category");
						}
					}
					browse.getOption(browse.categoryFilters, i + 1).click();
				}
				browse.getOption(browse.categoryFilters, j + 1).click();
				browse.getOption(browse.categoryFilters, j + 2).click();
				browse.getOption(browse.categoryFilters, j + 3).click();
				browse.getOption(browse.categoryFilters, j + 4).click();
				browse.getOption(browse.categoryFilters, j + 5).click();
			}

			// Seven options
			for (int j = 0; j < 2; j++) {
				browse.getOption(browse.categoryFilters, j + 1).click();
				browse.getOption(browse.categoryFilters, j + 2).click();
				browse.getOption(browse.categoryFilters, j + 3).click();
				browse.getOption(browse.categoryFilters, j + 4).click();
				browse.getOption(browse.categoryFilters, j + 5).click();
				browse.getOption(browse.categoryFilters, j + 6).click();
				String selectedOption = browse.getOption(browse.categoryFilters, j + 1).getText();
				String selectedOption1 = browse.getOption(browse.categoryFilters, j + 2).getText();
				String selectedOption2 = browse.getOption(browse.categoryFilters, j + 3).getText();
				String selectedOption3 = browse.getOption(browse.categoryFilters, j + 4).getText();
				String selectedOption4 = browse.getOption(browse.categoryFilters, j + 5).getText();
				String selectedOption5 = browse.getOption(browse.categoryFilters, j + 6).getText();
				for (int i = j + 6; i < 9; i++) {
					browse.getOption(browse.categoryFilters, i + 1).click();
					String selectedOption6 = browse.getOption(browse.categoryFilters, i + 1).getText();
					browse.click(browse.applyFilter);
					browse.spinnerloader();
					browse.spinnerloader();
					String[] categoryUi = browse.arrayGettext(browse.coursesLabel);
					for (String category : categoryUi) {
						if (!(category.contains(selectedOption) || category.contains(selectedOption1)
								|| category.contains(selectedOption2) || category.contains(selectedOption3)
								|| category.contains(selectedOption4) || category.contains(selectedOption5)
								|| category.contains(selectedOption6))) {
							Assert.assertEquals(true, false, "Result didnt filter according to selected category");
						}
					}
					browse.getOption(browse.categoryFilters, i + 1).click();
				}
				browse.getOption(browse.categoryFilters, j + 1).click();
				browse.getOption(browse.categoryFilters, j + 2).click();
				browse.getOption(browse.categoryFilters, j + 3).click();
				browse.getOption(browse.categoryFilters, j + 4).click();
				browse.getOption(browse.categoryFilters, j + 5).click();
				browse.getOption(browse.categoryFilters, j + 6).click();
			}

			// Eight options
			for (int j = 0; j < 1; j++) {
				browse.getOption(browse.categoryFilters, j + 1).click();
				browse.getOption(browse.categoryFilters, j + 2).click();
				browse.getOption(browse.categoryFilters, j + 3).click();
				browse.getOption(browse.categoryFilters, j + 4).click();
				browse.getOption(browse.categoryFilters, j + 5).click();
				browse.getOption(browse.categoryFilters, j + 6).click();
				browse.getOption(browse.categoryFilters, j + 7).click();
				String selectedOption = browse.getOption(browse.categoryFilters, j + 1).getText();
				String selectedOption1 = browse.getOption(browse.categoryFilters, j + 2).getText();
				String selectedOption2 = browse.getOption(browse.categoryFilters, j + 3).getText();
				String selectedOption3 = browse.getOption(browse.categoryFilters, j + 4).getText();
				String selectedOption4 = browse.getOption(browse.categoryFilters, j + 5).getText();
				String selectedOption5 = browse.getOption(browse.categoryFilters, j + 6).getText();
				String selectedOption6 = browse.getOption(browse.categoryFilters, j + 7).getText();
				for (int i = j + 7; i < 9; i++) {
					browse.getOption(browse.categoryFilters, i + 1).click();
					String selectedOption7 = browse.getOption(browse.categoryFilters, i + 1).getText();
					browse.click(browse.applyFilter);
					browse.spinnerloader();
					browse.spinnerloader();
					String[] categoryUi = browse.arrayGettext(browse.coursesLabel);
					for (String category : categoryUi) {
						if (!(category.contains(selectedOption) || category.contains(selectedOption1)
								|| category.contains(selectedOption2) || category.contains(selectedOption3)
								|| category.contains(selectedOption4) || category.contains(selectedOption5)
								|| category.contains(selectedOption6) || category.contains(selectedOption7))) {
							Assert.assertEquals(true, false, "Result didnt filter according to selected category");
						}
					}
					browse.getOption(browse.categoryFilters, i + 1).click();
				}
				browse.getOption(browse.categoryFilters, j + 1).click();
				browse.getOption(browse.categoryFilters, j + 2).click();
				browse.getOption(browse.categoryFilters, j + 3).click();
				browse.getOption(browse.categoryFilters, j + 4).click();
				browse.getOption(browse.categoryFilters, j + 5).click();
				browse.getOption(browse.categoryFilters, j + 6).click();
				browse.getOption(browse.categoryFilters, j + 7).click();
			}

			// Nine options
			for (int j = 0; j < categoryFilters.length - 8; j++) {
				browse.getOption(browse.categoryFilters, j + 1).click();
				browse.getOption(browse.categoryFilters, j + 2).click();
				browse.getOption(browse.categoryFilters, j + 3).click();
				browse.getOption(browse.categoryFilters, j + 4).click();
				browse.getOption(browse.categoryFilters, j + 5).click();
				browse.getOption(browse.categoryFilters, j + 6).click();
				browse.getOption(browse.categoryFilters, j + 7).click();
				browse.getOption(browse.categoryFilters, j + 8).click();
				String selectedOption = browse.getOption(browse.categoryFilters, j + 1).getText();
				String selectedOption1 = browse.getOption(browse.categoryFilters, j + 2).getText();
				String selectedOption2 = browse.getOption(browse.categoryFilters, j + 3).getText();
				String selectedOption3 = browse.getOption(browse.categoryFilters, j + 4).getText();
				String selectedOption4 = browse.getOption(browse.categoryFilters, j + 5).getText();
				String selectedOption5 = browse.getOption(browse.categoryFilters, j + 6).getText();
				String selectedOption6 = browse.getOption(browse.categoryFilters, j + 7).getText();
				String selectedOption7 = browse.getOption(browse.categoryFilters, j + 8).getText();
				for (int i = j + 8; i < categoryFilters.length; i++) {
					browse.getOption(browse.categoryFilters, i + 1).click();
					String selectedOption8 = browse.getOption(browse.categoryFilters, i + 1).getText();
					browse.click(browse.applyFilter);
					browse.spinnerloader();
					browse.spinnerloader();
					String[] categoryUi = browse.arrayGettext(browse.coursesLabel);
					for (String category : categoryUi) {
						if (!(category.contains(selectedOption) || category.contains(selectedOption1)
								|| category.contains(selectedOption2) || category.contains(selectedOption3)
								|| category.contains(selectedOption4) || category.contains(selectedOption5)
								|| category.contains(selectedOption6) || category.contains(selectedOption7)
								|| category.contains(selectedOption8))) {
							Assert.assertEquals(true, false, "Result didnt filter according to selected category");
						}
					}
					browse.getOption(browse.categoryFilters, i + 1).click();
				}
				browse.getOption(browse.categoryFilters, j + 1).click();
				browse.getOption(browse.categoryFilters, j + 2).click();
				browse.getOption(browse.categoryFilters, j + 3).click();
				browse.getOption(browse.categoryFilters, j + 4).click();
				browse.getOption(browse.categoryFilters, j + 5).click();
				browse.getOption(browse.categoryFilters, j + 6).click();
				browse.getOption(browse.categoryFilters, j + 7).click();
				browse.getOption(browse.categoryFilters, j + 8).click();
			}

			lp.logout();
			System.out.println("logout");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 2)
	public void skillsFilters() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			Browse browse = new Browse(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginButton);
			lp.sendKeys(lp.email, rb.getString("emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("psswd"));
			lp.click(lp.loginsubmit);
			lp.spinnerloader();
			lp.spinnerloader();
			browse.click(browse.searchButton);
			lp.spinnerloader();
			browse.spinnerloader();
			// Individual option
			String[] skillFilters = browse.arrayGettext(browse.skillsFilters);
			for (int i = 0; i < skillFilters.length; i++) {
				browse.getOption(browse.skillsFilters, i + 1).click();
				String selectedOption = browse.getOption(browse.skillsFilters, i + 1).getText();
				browse.click(browse.applyFilter);
				browse.spinnerloader();
				browse.spinnerloader();
				String[] skillUi = browse.arrayGettext(browse.coursesLevel);
				for (String skill : skillUi) {
					if (!(skill.contains(selectedOption))) {
						Assert.assertEquals(true, false, "Result didnt filter according to selected level");
					}
				}
				browse.getOption(browse.skillsFilters, i + 1).click();
			}
			// Two options
			for (int j = 0; j < skillFilters.length - 1; j++) {
				browse.getOption(browse.skillsFilters, j + 1).click();
				String selectedOption = browse.getOption(browse.skillsFilters, j + 1).getText();
				for (int i = j + 1; i < skillFilters.length; i++) {
					browse.getOption(browse.skillsFilters, i + 1).click();
					String selectedOption1 = browse.getOption(browse.skillsFilters, i + 1).getText();
					browse.click(browse.applyFilter);
					browse.spinnerloader();
					browse.spinnerloader();
					String[] skillUi = browse.arrayGettext(browse.coursesLevel);
					for (String skill : skillUi) {
						if (!(skill.contains(selectedOption) || skill.contains(selectedOption1))) {
							Assert.assertEquals(true, false, "Result didnt filter according to selected level");
						}
					}
					browse.getOption(browse.skillsFilters, i + 1).click();
				}
				browse.getOption(browse.skillsFilters, j + 1).click();
			}

			// Three options
			for (int j = 0; j < skillFilters.length - 2; j++) {
				browse.getOption(browse.skillsFilters, j + 1).click();
				browse.getOption(browse.skillsFilters, j + 2).click();
				String selectedOption = browse.getOption(browse.skillsFilters, j + 1).getText();
				String selectedOption1 = browse.getOption(browse.skillsFilters, j + 2).getText();
				for (int i = j + 2; i < skillFilters.length; i++) {
					browse.getOption(browse.skillsFilters, i + 1).click();
					String selectedOption2 = browse.getOption(browse.skillsFilters, i + 1).getText();
					browse.click(browse.applyFilter);
					browse.spinnerloader();
					browse.spinnerloader();
					String[] skillUi = browse.arrayGettext(browse.coursesLevel);
					for (String skill : skillUi) {
						if (!(skill.contains(selectedOption) || skill.contains(selectedOption1)
								|| skill.contains(selectedOption2))) {
							Assert.assertEquals(true, false, "Result didnt filter according to selected level");
						}
					}
					browse.getOption(browse.skillsFilters, i + 1).click();
				}
				browse.getOption(browse.skillsFilters, j + 1).click();
				browse.getOption(browse.skillsFilters, j + 2).click();
			}
			lp.logout();
			System.out.println("logout");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}
}
