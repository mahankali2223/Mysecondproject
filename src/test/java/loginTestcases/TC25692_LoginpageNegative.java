package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC25692_LoginpageNegative extends BaseClass {

	@Test(priority = 0)
	public void Test01_EmailNegative() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginButton);
			lp.checkInvalidEmailMsg(lp.email, rb.getString("captial"));
			lp.checkInvalidEmailMsg(lp.email, rb.getString("numbers"));
			lp.checkInvalidEmailMsg(lp.email, rb.getString("small"));
			lp.checkInvalidEmailMsg(lp.email, rb.getString("specialcharamissing"));
			lp.checkInvalidEmailMsg(lp.email, rb.getString("specailcharas"));
			lp.checkInvalidEmailMsg(lp.email, rb.getString("singlechar"));
			lp.checkInvalidEmailMsg(lp.email, rb.getString("special"));
			lp.checkInvalidEmailMsg(lp.email, rb.getString("adg"));
//			lp.checkInvalidEmailMsg(lp.email,rb.getString("qwr"));
//			lp.checkInvalidEmailMsg(lp.email,rb.getString("tyu"));
			lp.checkInvalidEmailMsg(lp.email, rb.getString("wer"));

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 1)
	public void Test02_Invalidusername() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
//			this.navigate();
			lp.sendKeys(lp.email, rb.getString("invaildemail"));
			lp.sendKeys(lp.psswrd, rb.getString("invaildpsswd"));
			lp.click(lp.loginsubmit);
			lp.checkInvalidUsernamemsg();

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 2)
	public void Test03_SubmitBtnNegative() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
//			this.navigate();
			lp.isDisable(lp.loginsubmit);

			// check for blank form
			lp.sendKeys(lp.email, rb.getString("emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("psswd"));
			lp.isEnable(lp.loginsubmit);

			// Checking Mandatory fields
			lp.clear(lp.email);
			lp.isDisable(lp.loginsubmit);
			lp.sendKeys(lp.email, rb.getString("emailid"));
			lp.clear(lp.psswrd);
			lp.isDisable(lp.loginsubmit);
			lp.clear(lp.email);
			lp.sendKeys(lp.psswrd, rb.getString("psswd"));
			lp.isDisable(lp.loginsubmit);

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
