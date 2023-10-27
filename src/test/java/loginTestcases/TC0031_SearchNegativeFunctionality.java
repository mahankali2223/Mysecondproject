package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Browse;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0031_SearchNegativeFunctionality extends BaseClass  {
	@Test(priority = 0)
	public void searchNegativeFunctionality() throws InterruptedException {
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
			lp.spinnerloader();
			lp.sendKeys(browse.search, "@#%ggdgff");
			browse.click(browse.searchButton);
			browse.spinnerloader();
			browse.spinnerloader();
			Assert.assertEquals(browse.isExisting(browse.coursesName), false,"Getting result for invalid search: @#%ggdgff");
			browse.logout();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}
	

}
