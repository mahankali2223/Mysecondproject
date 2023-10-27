package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Browse;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0033_FilterSearchNegativeFunctionality extends BaseClass {
	@Test
	public void catergoryFilterSearchNegativeFunctionality() throws InterruptedException {

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
			browse.sendKeys(browse.categorySearch, "QE$h");
			Assert.assertEquals(browse.isExisting(browse.categoryFilters), false,
					"Catergory result is visible after searching for invalid catergory: QE$h");
			lp.logout();
			System.out.println("logout");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test
	public void skillFilterSearchNegativeFunctionality() throws InterruptedException {

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
			browse.sendKeys(browse.skillSearch, "QE$h");
			Assert.assertEquals(browse.isExisting(browse.skillsFilters), false,
					"Skill result is visible after searching for invalid skill: QE$h");
			lp.logout();
			System.out.println("logout");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test
	public void specialityAreaFilterSearchNegativeFunctionality() throws InterruptedException {

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
			browse.sendKeys(browse.specialityAreaSearch, "QE$h");
			Assert.assertEquals(browse.isExisting(browse.specialtyAreaFilters), false,
					"Speciality Area result is visible after searching for invalid Area: QE$h");
			lp.logout();
			System.out.println("logout");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test
	public void JobFilterSearchNegativeFunctionality() throws InterruptedException {

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
			browse.sendKeys(browse.jobRoleSearch, "QE$h");
			Assert.assertEquals(browse.isExisting(browse.jobRoleFilters), false,
					"Job result is visible after searching for invalid Role: QE$h");
			lp.logout();
			System.out.println("logout");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}
}
