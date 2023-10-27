package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC25693_Update_accountSetting extends BaseClass {

	@Test
	public void testAccountUpdate() throws InterruptedException {

		try {
			LoginPage lp = new LoginPage(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginButton);
			lp.sendKeys(lp.email, rb.getString("updateemail"));
			lp.sendKeys(lp.psswrd, rb.getString("updatepsswd"));
			lp.click(lp.loginsubmit);
			lp.spinnerloader();
			lp.spinnerloader();
			lp.updateAccount();
			lp.clear(lp.lastName);
			lp.sendKeys(lp.lastName, "mahankali");
			lp.sendKeys(lp.mobileNum, lp.randomeNumber());
			lp.sendKeys(lp.updatePsswrd, rb.getString("updatepsswd"));
			lp.spinnerloader();
			lp.click(lp.loginsubmit);
			lp.spinnerloader();
			lp.spinnerloader();
			lp.moveAndClick(lp.lastName);
			lp.spinnerloader();
			lp.moveAndClick(lp.update);
			lp.spinnerloader();
			Assert.assertEquals(lp.getText(lp.changePasswdheader).trim(), "Change Your Password".trim());
			lp.sendKeys(lp.oldPsswd, rb.getString("updatepsswd"));
			lp.sendKeys(lp.newPsswd, rb.getString("newpasswd"));
			lp.sendKeys(lp.confirmPsswd, rb.getString("newpasswd"));
			lp.click(lp.loginsubmit);
			lp.spinnerloader();
			lp.click(lp.gotoDashboard);
			lp.logout();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
