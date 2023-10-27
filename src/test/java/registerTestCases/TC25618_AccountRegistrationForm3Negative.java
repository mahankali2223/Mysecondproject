package registerTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import testBase.BaseClass;

public class TC25618_AccountRegistrationForm3Negative extends BaseClass {

	@Test(priority = 0)
	public void testEmailnegative() throws InterruptedException {
		try {
			AccountRegisterationPage codered = new AccountRegisterationPage(driver);
//			this.navigate();
			codered.navigate();
			codered.click(codered.getFree);
			codered.checkInvalidEmailMsg(rb.getString("captial"));
			codered.checkInvalidEmailMsg(rb.getString("small"));
			codered.checkInvalidEmailMsg(rb.getString("specialcharamissing"));
			codered.checkInvalidEmailMsg(rb.getString("specailcharas"));
			codered.checkInvalidEmailMsg(rb.getString("singlechar"));
			codered.checkInvalidEmailMsg(rb.getString("wer"));
			codered.checkInvalidEmailMsg(rb.getString("adg"));
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 1)
	public void testPasswordnegative() throws InterruptedException {
		try {
			AccountRegisterationPage codered = new AccountRegisterationPage(driver);
//			this.navigate();
			codered.checkInvalidPasswordMsg(rb.getString("captial")); // only capital letter
			codered.checkInvalidPasswordMsg(rb.getString("small")); // only small letter
			codered.checkInvalidPasswordMsg(rb.getString("numbers")); // only number
			codered.checkInvalidPasswordMsg(rb.getString("capsmall")); // only capital and small letter
			codered.checkInvalidPasswordMsg(rb.getString("specialcharamissing")); // special character missing
			codered.checkInvalidPasswordMsg(rb.getString("smallmissing")); // small letters missing
			codered.checkInvalidPasswordMsg(rb.getString("length")); // length is not 8
			codered.checkInvalidPasswordMsg(rb.getString("specailcharas")); // special characters
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 2)
	public void testFirstnameNegative() throws InterruptedException {
		try {
			AccountRegisterationPage codered = new AccountRegisterationPage(driver);
//			this.navigate();
			codered.checkInvalidFirstNameMsg(codered.firstName, rb.getString("allcharas")); // All characters
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 3)
	public void testSubmitbtnNegative() throws InterruptedException {
		try {
			AccountRegisterationPage codered = new AccountRegisterationPage(driver);
//			this.navigate();
			codered.isDisable(codered.submit);

			// check for blank form
			codered.sendKeys(codered.firstName, codered.randomString());
			codered.sendKeys(codered.psswrd, codered.randomAlphaNumeric());
			codered.sendKeys(codered.email, codered.randomString() + "@gmail.com");
			codered.click(codered.countryId);
			codered.clickOption("India");
			codered.click(codered.chkbox);
			codered.isEnable(codered.submit);

			// Checking Mandatory fields
			codered.clear(codered.firstName); // checking first name
//			regPage.click(regPage.firstNameLabel);
			codered.isDisable(codered.submit);
			codered.sendKeys(codered.firstName, codered.randomString());
//			regPage.click(regPage.firstNameLabel);
			codered.clear(codered.psswrd); // checking password
//			regPage.click(regPage.firstNameLabel);
			codered.isDisable(codered.submit);
			codered.sendKeys(codered.psswrd, codered.randomAlphaNumeric());
//			regPage.click(regPage.firstNameLabel);
			codered.clear(codered.email); // checking email
//			regPage.click(regPage.firstNameLabel);
			codered.isDisable(codered.submit);
			codered.sendKeys(codered.email, codered.randomString() + "@gmail.com");
//			regPage.click(regPage.firstNameLabel);
			codered.click(codered.chkbox); // checking checkbox
//			regPage.click(regPage.firstNameLabel);
			codered.isDisable(codered.submit);
			codered.click(codered.chkbox);
//			regPage.click(regPage.firstNameLabel);

			// Checking for invalid input
			codered.sendKeys(codered.email, codered.randomString());
//			regPage.click(regPage.firstNameLabel);
			codered.isDisable(codered.submit);
			codered.sendKeys(codered.email, codered.randomString() + "@gmail.com");
//			regPage.click(regPage.firstNameLabel);
			codered.sendKeys(codered.psswrd, codered.randomString());
//			regPage.click(regPage.firstNameLabel);
			codered.isDisable(codered.submit);

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
