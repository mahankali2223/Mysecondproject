package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Browse;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0032_SearchAllFilterFunctionality extends BaseClass {
	@Test
	public void testSearchFunctionality() throws InterruptedException {

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
			browse.moveAndClick(browse.searchButton);
			browse.spinnerloader();
			browse.spinnerloader();
			browse.click(browse.getOption(browse.categoryFilters, 1));
			String selectedOption = browse.getText(browse.getOption(browse.categoryFilters, 1));
			browse.click(browse.getOption(browse.skillsFilters, 1));
			String selectedOption1 = browse.getText(browse.getOption(browse.skillsFilters, 1));
			browse.moveAndClick(browse.applyFilter);
			browse.spinnerloader();
			browse.spinnerloader();
			String[] categoryUi = browse.arrayGettext(browse.coursesLabel);
			String[] skillUi = browse.arrayGettext(browse.coursesLevel);
			for (String category : categoryUi) {
				if (!(category.contains(selectedOption))) {
					Assert.assertEquals(true, false, "Result didnt filter according to selected Category "
							+ selectedOption);
				}
			}
			for (String skill : skillUi) {
				if (!(skill.contains(selectedOption1))) {
					Assert.assertEquals(true, false, "Result didnt filter according to selected Filter " + selectedOption1);
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
