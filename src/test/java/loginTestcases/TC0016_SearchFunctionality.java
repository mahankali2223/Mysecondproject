package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Browse;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0016_SearchFunctionality extends BaseClass {
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
			Assert.assertEquals(browse.getText(browse.searchHeader), "Search Results For \"\"",
					"Search Result header is not matching");
			String[] coursesName = browse.arrayGettext(browse.coursesName);
			Assert.assertEquals((coursesName.length) > 0, true, "After clicking on search no courses visible");
			browse.sendKeys(browse.search, "Python");
			browse.click(browse.searchButton);
			browse.spinnerloader();
			browse.spinnerloader();
			Assert.assertEquals(browse.getText(browse.searchHeader), "Search Results For \"Python\"",
					"Search Result header is not matching after searching");
			String[] courseNames = browse.arrayGettext(browse.coursesName);
			Assert.assertEquals((courseNames.length) > 0, true);
			lp.logout();
			System.out.println("logout");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
