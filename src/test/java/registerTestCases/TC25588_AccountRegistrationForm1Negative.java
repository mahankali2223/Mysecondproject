package registerTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CoderedRegister2;
import testBase.BaseClass;

public class TC25588_AccountRegistrationForm1Negative extends BaseClass {

	@Test(priority = 0)
	public void testEmailnegative() throws InterruptedException {
		logger.info("***  TC25588_RegisterForm1Negative ***");

		try {
			CoderedRegister2 regPage = new CoderedRegister2(driver);
//			this.navigate();
			regPage.navigate();
			regPage.checkInvalidEmailMsg(rb.getString("captial"));
			regPage.checkInvalidEmailMsg(rb.getString("small"));
			regPage.checkInvalidEmailMsg(rb.getString("specialcharamissing"));
			regPage.checkInvalidEmailMsg(rb.getString("specailcharas"));
			regPage.checkInvalidEmailMsg(rb.getString("singlechar"));
			regPage.checkInvalidEmailMsg(rb.getString("wer"));
			regPage.checkInvalidEmailMsg(rb.getString("adg"));
			logger.info("***  msgdisplayed ***");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
		logger.info("***  TC25588_RegisterForm1Negative ***");
	}

	@Test(priority = 1)
	public void testPasswordnegative() throws InterruptedException {
		try {
			CoderedRegister2 regPage = new CoderedRegister2(driver);
			regPage.navigate();
//			this.navigate();
			regPage.spinnerloader();
			regPage.checkInvalidPasswordMsg(rb.getString("captial")); // only capital letter
			regPage.checkInvalidPasswordMsg(rb.getString("small")); // only small letter
			regPage.checkInvalidPasswordMsg(rb.getString("numbers")); // only number
			regPage.checkInvalidPasswordMsg(rb.getString("capsmall")); // only capital and small letter
			regPage.checkInvalidPasswordMsg(rb.getString("specialcharamissing")); // special character missing
			regPage.checkInvalidPasswordMsg(rb.getString("smallmissing")); // small letters missing
			regPage.checkInvalidPasswordMsg(rb.getString("length")); // length is not8
			regPage.checkInvalidPasswordMsg(rb.getString("specailcharas"));// All Special characters

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 2)
	public void testFirstname() throws InterruptedException {
		logger.info("***  TC25588_RegisterForm1Negative ***");

		try {
			CoderedRegister2 regPage = new CoderedRegister2(driver);
//			this.navigate();
			regPage.navigate();
			regPage.checkInvalidFirstNameMsg(regPage.firstName, rb.getString("allcharas"));// All characters mixed
			logger.info("***  msgdisplayed ***");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
		logger.info("***  TC25588_RegisterForm1Negative ***");
	}

	@Test(priority = 3)
	public void TestsubmitBtnnegative() throws InterruptedException {
		try {
			CoderedRegister2 regPage = new CoderedRegister2(driver);
//			this.navigate();
			regPage.navigate();
			regPage.isDisable(regPage.submit);

			// check for blank form
			regPage.sendKeys(regPage.firstName, regPage.randomString());
			regPage.sendKeys(regPage.psswrd, regPage.randomAlphaNumeric());
			regPage.sendKeys(regPage.email, regPage.randomString() + "@gmail.com");
			regPage.click(regPage.chkbox);
			regPage.isEnable(regPage.submit);

			// Checking Mandatory fields
			regPage.clear(regPage.firstName); // checking first name
//			regPage.click(regPage.firstNameLabel);
			regPage.isDisable(regPage.submit);
			regPage.sendKeys(regPage.firstName, regPage.randomString());
//			regPage.click(regPage.firstNameLabel);
			regPage.clear(regPage.psswrd); // checking password
//			regPage.click(regPage.firstNameLabel);
			regPage.isDisable(regPage.submit);
			regPage.sendKeys(regPage.psswrd, regPage.randomAlphaNumeric());
//			regPage.click(regPage.firstNameLabel);
			regPage.clear(regPage.email); // checking email
//			regPage.click(regPage.firstNameLabel);
			regPage.isDisable(regPage.submit);
			regPage.sendKeys(regPage.email, regPage.randomString() + "@gmail.com");
//			regPage.click(regPage.firstNameLabel);
			regPage.click(regPage.chkbox); // checking checkbox
//			regPage.click(regPage.firstNameLabel);
			regPage.isDisable(regPage.submit);
			regPage.click(regPage.chkbox);
//			regPage.click(regPage.firstNameLabel);

			// Checking for invalid input
			regPage.sendKeys(regPage.email, regPage.randomString());
//			regPage.click(regPage.firstNameLabel);
			regPage.isDisable(regPage.submit);
			regPage.sendKeys(regPage.email, regPage.randomString() + "@gmail.com");
//			regPage.click(regPage.firstNameLabel);
			regPage.sendKeys(regPage.psswrd, regPage.randomString());
//			regPage.click(regPage.firstNameLabel);
			regPage.isDisable(regPage.submit);

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
