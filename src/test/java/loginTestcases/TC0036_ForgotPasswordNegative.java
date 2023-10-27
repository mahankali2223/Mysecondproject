package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0036_ForgotPasswordNegative extends BaseClass {

	@Test(priority = 0)
	public void Test01_EmailNegative() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginButton);
			lp.click(lp.resetButton);
			lp.sendKeys(lp.resetEmail, "Adbc@gmail.com");
			lp.spinnerloader();
			lp.click(lp.reset);
			lp.spinnerloader();
			lp.clear(lp.resetEmail);
			lp.checkInvalidResetEmailMsg(lp.resetEmail, rb.getString("captial"));
			lp.checkInvalidResetEmailMsg(lp.resetEmail, rb.getString("numbers"));
			lp.checkInvalidResetEmailMsg(lp.resetEmail, rb.getString("small"));
			lp.checkInvalidResetEmailMsg(lp.resetEmail, rb.getString("specialcharamissing"));
			lp.checkInvalidResetEmailMsg(lp.resetEmail, rb.getString("specailcharas"));
			lp.checkInvalidResetEmailMsg(lp.resetEmail, rb.getString("singlechar"));
			lp.checkInvalidResetEmailMsg(lp.resetEmail, rb.getString("special"));
			lp.checkInvalidResetEmailMsg(lp.resetEmail, rb.getString("adg"));
			lp.checkInvalidResetEmailMsg(lp.resetEmail, rb.getString("wer"));
			lp.sendKeys(lp.resetEmail, "1245xyr@gmail.com");
			lp.click(lp.reset);
			Assert.assertEquals(lp.isExisting(lp.userfoundErrorMessage), true,
					"The user not found message is not existing");
			Assert.assertEquals(lp.getText(lp.userNotFoundMessg).trim(), "User not found",
					"After giving invalid email id, Error message doesnot match");
			lp.moveAndClick(lp.eccouncilIcon);
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

//
	@Test(priority = 1)
	public void Test01_InvalidOTPAndDisableReset() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginButton);
			lp.spinnerloader();
			lp.click(lp.resetButton);
			lp.sendKeys(lp.resetEmail, "TestWE@gmail.com");
			lp.spinnerloader();
			lp.click(lp.reset);
			lp.spinnerloader();
			lp.spinnerloader();
			lp.isDisable(lp.resetPasswordButton, "The reset button is enable before entering any character");
			lp.sendKeys(lp.otp1, "1");
			lp.isDisable(lp.resetPasswordButton, "The reset button is enable after entering character in first field");
			lp.sendKeys(lp.otp2, "2");
			lp.isDisable(lp.resetPasswordButton, "The reset button is enable after entering character in second field");
			lp.sendKeys(lp.otp3, "3");
			lp.isDisable(lp.resetPasswordButton, "The reset button is enable after entering character in Third field");
			lp.sendKeys(lp.otp4, "4");
			lp.isDisable(lp.resetPasswordButton, "The reset button is enable after entering character in fourth field");
			lp.sendKeys(lp.otp5, "5");
			lp.isDisable(lp.resetPasswordButton, "The reset button is enable after entering character in fifth field");
			lp.sendKeys(lp.otp6, "6");
			lp.isEnable(lp.resetPasswordButton, "The reset button is disable after entering all character");
			lp.clear(lp.otp6);
			lp.isDisable(lp.resetPasswordButton, "The reset button is enable after removing one character");
			lp.sendKeys(lp.otp6, "8");
			lp.isEnable(lp.resetPasswordButton, "The reset button is disable after again entering all character");
			lp.click(lp.resetPasswordButton);
			Assert.assertEquals(lp.isExisting(lp.updatedErrorMessage), true,
					"After giving invalid OTP Error message not exist");
			Assert.assertEquals(lp.getText(lp.updatedErrorMeg), "Invalid entered otp code.",
					"After giving invalid OTP Error message doesnot match");
			lp.moveAndClick(lp.eccouncilIcon);
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

//	@Test(priority = 2)
//	public void Test02_InvalidOTP() throws InterruptedException {
//		try {
//			LoginPage lp = new LoginPage(driver);
//			lp.navigate();
//			lp.moveAndClick(lp.loginButton);
//			lp.spinnerloader();
//			lp.click(lp.resetButton);
//			lp.sendKeys(lp.resetEmail, "Test@yahoo.com");
//			lp.spinnerloader();
//			lp.click(lp.reset);
//			lp.spinnerloader();
//			lp.spinnerloader();
//			lp.sendKeys(lp.otp1, "A");
//			lp.sendKeys(lp.otp2, "B");
//			lp.sendKeys(lp.otp3, "C");
//			lp.sendKeys(lp.otp4, "D");
//			lp.sendKeys(lp.otp5, "E");
//			lp.sendKeys(lp.otp6, "F");
//			lp.click(lp.resetPasswordButton);
//			lp.spinnerloader();
//			Assert.assertEquals(lp.isExisting(lp.updatedErrorMessage), true,
//					"After giving invalid OTP Error message not exist");
//			Assert.assertEquals(lp.getText(lp.updatedErrorMeg), "Invalid entered otp code.",
//					"After giving invalid OTP Error message doesnot match");
//			lp.moveAndClick(lp.eccouncilIcon);
//		} catch (Exception e) {
//			System.out.println(e);
//			Assert.fail();
//		}
//	}

	@Test(priority = 3)
	public void Test03_InvalidOTP() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginButton);
			lp.spinnerloader();
			lp.click(lp.resetButton);
			lp.sendKeys(lp.resetEmail, "TestingAD@gmail.com");
			lp.spinnerloader();
			lp.click(lp.reset);
			lp.spinnerloader();
			lp.spinnerloader();
			lp.sendKeys(lp.otp1, "123");
			lp.sendKeys(lp.otp2, "456");
			lp.sendKeys(lp.otp3, "365");
			lp.sendKeys(lp.otp4, "768");
			lp.sendKeys(lp.otp5, "987");
			lp.sendKeys(lp.otp6, "546");
			lp.click(lp.resetPasswordButton);
			lp.spinnerloader();
			Assert.assertEquals(lp.otp1.getAttribute("value").trim(), "1",
					"Otp1 field is taking more than one character");
			Assert.assertEquals(lp.otp2.getAttribute("value").trim(), "4",
					"Otp2 field is taking more than one character");
			Assert.assertEquals(lp.otp3.getAttribute("value").trim(), "3",
					"Otp3 field is taking more than one character");
			Assert.assertEquals(lp.otp4.getAttribute("value").trim(), "7",
					"Otp4 field is taking more than one character");
			Assert.assertEquals(lp.otp5.getAttribute("value").trim(), "9",
					"Otp5 field is taking more than one character");
			Assert.assertEquals(lp.otp6.getAttribute("value").trim(), "5",
					"Otp6 field is taking more than one character");
			lp.moveAndClick(lp.eccouncilIcon);
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
