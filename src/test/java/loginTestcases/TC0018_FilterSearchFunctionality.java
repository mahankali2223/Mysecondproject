package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Browse;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0018_FilterSearchFunctionality extends BaseClass {

	@Test(priority = 0)
	public void categoriesSearch() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			Browse browse = new Browse(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginButton);
			lp.sendKeys(lp.email, rb.getString("emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("psswd"));
			lp.click(lp.loginsubmit);
			browse.spinnerloader();
			browse.spinnerloader();
			browse.click(browse.searchButton);
			browse.spinnerloader();
			browse.spinnerloader();
			String[] categorySearch = browse.arrayGettext(browse.categoryFilters);
			for (int i = 0; i < categorySearch.length; i++) {
				browse.sendKeys(browse.categorySearch, categorySearch[i]);
				browse.spinnerloader();
				String[] searchResults = browse.arrayGettext(browse.categoryFilters);
				for (String result : searchResults) {
					if (!(result.contains(categorySearch[i]))) {
						Assert.assertEquals(true, false, "Result didnt filter according to selected Category");
					}
				}
			}
			browse.getOption(browse.categoryFilters, 1).click();
			browse.click(browse.applyFilter);
			browse.spinnerloader();
			browse.spinnerloader();
			String[] categoryUi = browse.arrayGettext(browse.coursesLabel);
			for (String category : categoryUi) {
				if (!(category.contains(categorySearch[categorySearch.length - 1]))) {
					Assert.assertEquals(true, false, "Result didnt filter according to selected Category");
				}
			}
			browse.getOption(browse.categoryFilters, 1).click();

			lp.logout();
			System.out.println("logout");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 1)
	public void skillSearch() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			Browse browse = new Browse(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginButton);
			lp.sendKeys(lp.email, rb.getString("emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("psswd"));
			lp.click(lp.loginsubmit);
			browse.spinnerloader();
			browse.spinnerloader();
			browse.click(browse.searchButton);
			browse.spinnerloader();
			browse.spinnerloader();
			String[] skillSearch = browse.arrayGettext(browse.skillsFilters);
			for (int i = 0; i < skillSearch.length; i++) {
				browse.sendKeys(browse.skillSearch, skillSearch[i]);
				browse.spinnerloader();
				String[] searchResults = browse.arrayGettext(browse.skillsFilters);
				for (String result : searchResults) {
					if (!(result.contains(skillSearch[i]))) {
						Assert.assertEquals(true, false, "Result didnt filter according to selected skill");
					}
				}
			}
			browse.getOption(browse.skillsFilters, 1).click();
			browse.click(browse.applyFilter);
			browse.spinnerloader();
			browse.spinnerloader();
			String[] categoryUi = browse.arrayGettext(browse.coursesLevel);
			for (String category : categoryUi) {
				if (!(category.contains(skillSearch[skillSearch.length - 1]))) {
					Assert.assertEquals(true, false, "Result didnt filter according to selected skill");
				}
			}
			browse.getOption(browse.skillsFilters, 1).click();

			lp.logout();
			System.out.println("logout");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 2)
	public void specailtyArea() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			Browse browse = new Browse(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginButton);
			lp.sendKeys(lp.email, rb.getString("emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("psswd"));
			lp.click(lp.loginsubmit);
			browse.spinnerloader();
			browse.spinnerloader();
			browse.click(browse.searchButton);
			browse.spinnerloader();
			browse.spinnerloader();
			String[] specailtyArea = browse.arrayGettext(browse.specialtyAreaFilters);
			for (int i = 0; i < specailtyArea.length; i++) {
				browse.sendKeys(browse.specialityAreaSearch, specailtyArea[i]);
				browse.spinnerloader();
				String[] searchResults = browse.arrayGettext(browse.specialtyAreaFilters);
				for (String result : searchResults) {
					if (!(result.contains(specailtyArea[i]))) {
						Assert.assertEquals(true, false, "Result didnt filter according to specialtyArea");
					}
				}
			}
			lp.logout();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 3)
	public void joleRoleSearch() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			Browse browse = new Browse(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginButton);
			lp.sendKeys(lp.email, rb.getString("emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("psswd"));
			lp.click(lp.loginsubmit);
			browse.spinnerloader();
			browse.spinnerloader();
			browse.click(browse.searchButton);
			browse.spinnerloader();
			browse.spinnerloader();
			String[] joleRoleSearch = browse.arrayGettext(browse.jobRoleFilters);
			for (int i = 0; i < joleRoleSearch.length; i++) {
				browse.sendKeys(browse.jobRoleSearch, joleRoleSearch[i]);
				browse.spinnerloader();
				String[] searchResults = browse.arrayGettext(browse.jobRoleFilters);
				for (String result : searchResults) {
					if (!(result.contains(joleRoleSearch[i]))) {
						Assert.assertEquals(true, false, "Result didnt filter according to Jole Role");
					}
				}
			}
			lp.logout();
			System.out.println("logout");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
