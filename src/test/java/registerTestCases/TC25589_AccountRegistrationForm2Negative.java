package registerTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CodeRegister4;
import testBase.BaseClass;

public class TC25589_AccountRegistrationForm2Negative extends BaseClass {
	@Test(priority = 0)
	public void testEmailnegative() throws InterruptedException {
		try {
			CodeRegister4 regPage4 = new CodeRegister4(driver);
//			this.navigate();
			regPage4.navigate();
			regPage4.checkInvalidEmailMsg(rb.getString("captial"));
			regPage4.checkInvalidEmailMsg(rb.getString("small"));
			regPage4.checkInvalidEmailMsg(rb.getString("specialcharamissing"));
			regPage4.checkInvalidEmailMsg(rb.getString("specailcharas"));
			regPage4.checkInvalidEmailMsg(rb.getString("singlechar"));
			regPage4.checkInvalidEmailMsg(rb.getString("wer"));
			regPage4.checkInvalidEmailMsg(rb.getString("adg"));
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 1)
	public void testPasswordnegative() throws InterruptedException {
		try {
			CodeRegister4 regPage4 = new CodeRegister4(driver);
//			this.navigate();
			regPage4.navigate();
			regPage4.spinnerloader();
			regPage4.checkInvalidPasswordMsg(rb.getString("captial")); // only capital letter
			regPage4.checkInvalidPasswordMsg(rb.getString("small")); // only small letter
			regPage4.checkInvalidPasswordMsg(rb.getString("numbers")); // only number
			regPage4.checkInvalidPasswordMsg(rb.getString("capsmall")); // only capital and small letter
			regPage4.checkInvalidPasswordMsg(rb.getString("specialcharamissing")); // special character missing
			regPage4.checkInvalidPasswordMsg(rb.getString("smallmissing")); // small letters missing
			regPage4.checkInvalidPasswordMsg(rb.getString("length")); // length is not 8
			regPage4.checkInvalidPasswordMsg(rb.getString("specailcharas")); // special characters
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 2)
	public void testFirstnegative() throws InterruptedException {
		try {
			CodeRegister4 regPage4 = new CodeRegister4(driver);
//			this.navigate();
			regPage4.navigate();
			regPage4.checkInvalidFirstNameMsg(regPage4.firstName, rb.getString("allcharas")); // All characters
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 3)
	public void testSubmitbtnNegative() throws InterruptedException {
		try {
			CodeRegister4 regPage4 = new CodeRegister4(driver);
//			this.navigate();
			regPage4.navigate();
			regPage4.isDisable(regPage4.submit);

			// check for blank form
			regPage4.sendKeys(regPage4.firstName, regPage4.randomString());
			regPage4.sendKeys(regPage4.psswrd, regPage4.randomAlphaNumeric());
			regPage4.sendKeys(regPage4.email, regPage4.randomString() + "@gmail.com");
			regPage4.click(regPage4.chkbox);
			regPage4.isEnable(regPage4.submit);

			// Checking Mandatory fields
			regPage4.clear(regPage4.firstName); // checking first name
//			regPage4.click(regPage.firstNameLabel);
			regPage4.isDisable(regPage4.submit);
			regPage4.sendKeys(regPage4.firstName, regPage4.randomString());
//			regPage4.click(regPage4.firstNameLabel);
			regPage4.clear(regPage4.psswrd); // checking password
//			regPage4.click(regPage4.firstNameLabel);
			regPage4.isDisable(regPage4.submit);
			regPage4.sendKeys(regPage4.psswrd, regPage4.randomAlphaNumeric());
//			regPage4.click(regPage.firstNameLabel);
			regPage4.clear(regPage4.email); // checking email
//			regPage4.click(regPage4.firstNameLabel);
			regPage4.isDisable(regPage4.submit);
			regPage4.sendKeys(regPage4.email, regPage4.randomString() + "@gmail.com");
//			regPage4.click(regPage4.firstNameLabel);
			regPage4.click(regPage4.chkbox); // checking checkbox
//			regPage4.click(regPage4.firstNameLabel);
			regPage4.isDisable(regPage4.submit);
			regPage4.click(regPage4.chkbox);
//			regPage4.click(regPage4.firstNameLabel);

			// Checking for invalid input
			regPage4.sendKeys(regPage4.email, regPage4.randomString());
//			regPage.click(regPage.firstNameLabel);
			regPage4.isDisable(regPage4.submit);
			regPage4.sendKeys(regPage4.email, regPage4.randomString() + "@gmail.com");
//			regPage.click(regPage.firstNameLabel);
			regPage4.sendKeys(regPage4.psswrd, regPage4.randomString());
//			regPage4.click(regPage4.firstNameLabel);
			regPage4.isDisable(regPage4.submit);

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
