package registerTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import testBase.BaseClass;

public class TC25587_AccountRegistration4Test extends BaseClass {

	@Test
	public void testAccountRegistration3() throws InterruptedException {

		try {

			AccountRegisterationPage codered = new AccountRegisterationPage(driver);
			codered.navigate();
			codered.click(codered.createAccount);
			codered.spinnerloader();
			codered.sendKeys(codered.firstName, codered.name);
			codered.sendKeys(codered.email, codered.name + "@gmail.com");
			codered.sendKeys(codered.psswrd, codered.randomAlphaNumeric());
			codered.spinnerloader();
			codered.click(codered.countryId);
			codered.spinnerloader();
			codered.clickOption("India");
			codered.click(codered.chkbox);
			codered.click(codered.submit);
			codered.spinnerloader();
			codered.proceedToNextStep();
			codered.logout();

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
