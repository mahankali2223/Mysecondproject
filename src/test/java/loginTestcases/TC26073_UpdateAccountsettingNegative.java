package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC26073_UpdateAccountsettingNegative extends BaseClass {
	@Test
	public void Test01submitBtnNegative() throws InterruptedException {

		try {
			LoginPage lp = new LoginPage(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginButton);
			lp.sendKeys(lp.email, rb.getString("emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("psswd"));
			lp.click(lp.loginsubmit);
			lp.spinnerloader();
			lp.spinnerloader();
			lp.spinnerloader();
			lp.updateAccount();
			lp.spinnerloader();
			lp.isDisable(lp.loginsubmit, "intial submit button is enable");

			// check for blank form
			lp.spinnerloader();
			lp.clear(lp.lastName);
			lp.sendKeys(lp.lastName, "kathi");
			lp.sendKeys(lp.mobileNum, lp.randomeNumber());
			lp.sendKeys(lp.updatePsswrd, rb.getString("psswd"));
			lp.isEnable(lp.loginsubmit, "After entering all data submit button is disable");

			// Checking Mandatory fields
			lp.clear(lp.email);
			lp.isDisable(lp.loginsubmit, "After clear email field submit button is enable");
			lp.sendKeys(lp.email, rb.getString("emailid"));
			lp.clear(lp.lastName);
			lp.click(lp.email);
			lp.isDisable(lp.loginsubmit, "After clear lastName field submit button is enable");
			lp.sendKeys(lp.lastName, "kathi");
			lp.clear(lp.firstName);
			lp.isDisable(lp.loginsubmit, "After clear first name field submit button is enable");
			lp.sendKeys(lp.firstName, "kathiii");
			lp.clear(lp.mobileNum);
			lp.isDisable(lp.loginsubmit, "After clear mobile number submit button is enable");
			lp.sendKeys(lp.mobileNum, lp.randomeNumber());
			lp.clear(lp.updatePsswrd);
			lp.isDisable(lp.loginsubmit, "After clear update password field submit button is enable");

//			// Checking invaildData
			lp.spinnerloader();
			lp.clear(lp.firstName);
//			lp.spinnerloader();
			lp.checkInvalidFirstNameMsg(lp.firstName, rb.getString("allcharas"));
			lp.clear(lp.lastName);
//			lp.spinnerloader();
			lp.checkInvalidLastNameMsg(lp.lastName, rb.getString("allcharas"));
//			lp.spinnerloader();
			lp.updateCheckInvalidEmailMsg(lp.email, rb.getString("specialcharamissing"));
			lp.updateCheckInvalidEmailMsg(lp.email, rb.getString("small"));
			lp.updateCheckInvalidEmailMsg(lp.email, rb.getString("singlechar"));
			lp.updateCheckInvalidEmailMsg(lp.email, rb.getString("numbers"));
			lp.updateCheckInvalidEmailMsg(lp.email, rb.getString("adg"));
			lp.updateCheckInvalidEmailMsg(lp.email, rb.getString("wer"));
			lp.moveAndClick(lp.lastName);

//			
//			// Checking UpdatePassword fields
			lp.spinnerloader();
			lp.moveAndClick(lp.update);
			lp.spinnerloader();
			lp.isDisable(lp.loginsubmit, "Intial update password submit button is enable");

//			// check for blank form
			lp.sendKeys(lp.oldPsswd, rb.getString("psswd"));
			lp.sendKeys(lp.newPsswd, rb.getString("newpasswd"));
			lp.sendKeys(lp.confirmPsswd, rb.getString("newpasswd"));
			lp.isEnable(lp.loginsubmit, "After filling all data update password sumbit button is disable");

//			// Checking Mandatory fields
			lp.clear(lp.oldPsswd);
			lp.isDisable(lp.loginsubmit, "After clearing old password field submit button is enable");
			lp.sendKeys(lp.oldPsswd, rb.getString("psswd"));
			lp.clear(lp.newPsswd);
			lp.isDisable(lp.loginsubmit, "After clearing new password field submit button is enable");
			lp.sendKeys(lp.newPsswd, rb.getString("newpasswd"));
			lp.clear(lp.confirmPsswd);
			lp.isDisable(lp.loginsubmit, "After clearing confirm password field submit button is enable");

			// Checking invaildData
			lp.updatePswdInvalidMesg(lp.newPsswd, rb.getString("numbers"));
			lp.updatePswdInvalidMesg(lp.newPsswd, rb.getString("singlechar"));
			lp.updatePswdInvalidMesg(lp.newPsswd, rb.getString("doublechar"));
			lp.updatePswdInvalidMesg(lp.newPsswd, rb.getString("threechar"));
			lp.updatePswdInvalidMesg(lp.newPsswd, rb.getString("fourchar"));
			lp.updatePswdInvalidMesg(lp.newPsswd, rb.getString("fivechar"));
			lp.updatePswdInvalidMesg(lp.newPsswd, rb.getString("sixchar"));
			lp.updatePswdInvalidMesg(lp.newPsswd, rb.getString("sevenchar"));
			lp.updatePasswordErrorMsg(lp.newPsswd, rb.getString("specialcharamissing"));
			lp.updatePwdConfirmInvalidMsg(lp.confirmPsswd, rb.getString("captial"));

			// Checking for Invalid old password
			lp.sendKeys(lp.oldPsswd, rb.getString("newpasswd"));
			lp.sendKeys(lp.newPsswd, rb.getString("newpasswd"));
			lp.sendKeys(lp.confirmPsswd, rb.getString("newpasswd"));
			lp.click(lp.loginsubmit);
			lp.spinnerloader();
			Assert.assertEquals(lp.isExisting(lp.updatedErrorMessage), true,
					"After giving invalid old password Error message not exist");
			Assert.assertEquals(lp.getText(lp.updatedErrorMeg), "The Entered Current Password Is Invalid",
					"After giving invalid old password Error message doesnot match");

			// Checking for Invalid new password
			lp.sendKeys(lp.oldPsswd, rb.getString("psswd"));
			lp.sendKeys(lp.newPsswd, rb.getString("psswd"));
			lp.sendKeys(lp.confirmPsswd, rb.getString("psswd"));
			lp.click(lp.loginsubmit);
			lp.spinnerloader();
			Assert.assertEquals(lp.isExisting(lp.updatedErrorMessage), true,
					"After giving new password as current password Error message not exist");
			Assert.assertEquals(lp.getText(lp.updatedErrorMeg).trim(),
					"The New Password Must Be Different Than Old One.",
					"After giving new password as current password Error message not match");

			lp.logout();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
