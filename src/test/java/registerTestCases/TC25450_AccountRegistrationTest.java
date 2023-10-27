package registerTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import testBase.BaseClass;

public class TC25450_AccountRegistrationTest extends BaseClass {

	@Test
	public void testAccountRegistration() throws InterruptedException {
		logger.info("***  Starting TC25450_AccountRegistrationTest ***");
		try {

			AccountRegisterationPage codered = new AccountRegisterationPage(driver);
			codered.navigate();
			codered.click(codered.getFree);
			logger.info("Clicked on getfree access");
			logger.info("Providing customer data");
			codered.sendKeys(codered.firstName, codered.name);
			codered.sendKeys(codered.email, codered.name + "@gmail.com");
			codered.sendKeys(codered.psswrd, codered.randomAlphaNumeric());
			codered.spinnerloader();
			codered.click(codered.countryId);
			codered.spinnerloader();
			System.out.println("click countrydropdown");
			codered.clickOption("India");
			codered.click(codered.chkbox);
			codered.click(codered.submit);
			codered.spinnerloader();
			logger.info("Clicked on continue");
			codered.spinnerloader();
			codered.proceedToNextStep();
			codered.logout();
			logger.info("Clicked on logout");

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
		logger.info("***  Finished TC25450_AccountRegistrationTest ***");
	}
}
