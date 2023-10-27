package registerTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.CodeRegister4;
import testBase.BaseClass;

public class TC25546_AccountRegistration3Test extends BaseClass {
	@Test
	public void testAccountRegistration4() throws InterruptedException {

		try {

			CodeRegister4 regPage4 = new CodeRegister4(driver);
			AccountRegisterationPage codered = new AccountRegisterationPage(driver);
			regPage4.navigate();
			regPage4.sendKeys(regPage4.firstName, codered.name);
			regPage4.sendKeys(regPage4.email, codered.name + "@gmail.com");
			regPage4.sendKeys(regPage4.psswrd, regPage4.randomAlphaNumeric());
			regPage4.click(regPage4.chkbox);
			regPage4.click(regPage4.submit);
			regPage4.spinnerloader();
			codered.proceedToNextStep();
			regPage4.logout();

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
