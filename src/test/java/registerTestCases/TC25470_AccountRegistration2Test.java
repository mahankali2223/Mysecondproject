package registerTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.CoderedRegister2;
import testBase.BaseClass;

public class TC25470_AccountRegistration2Test extends BaseClass {

	@Test
	public void testAccountRegister() throws InterruptedException {

		try {
			CoderedRegister2 regPage = new CoderedRegister2(driver);
			AccountRegisterationPage codered = new AccountRegisterationPage(driver);
			regPage.navigate();
			regPage.sendKeys(regPage.firstName, codered.name);
			regPage.sendKeys(regPage.email, codered.name + "@gmail.com");
			regPage.sendKeys(regPage.psswrd, regPage.randomAlphaNumeric());
			regPage.click(regPage.chkbox);
			regPage.click(regPage.submit);
			regPage.spinnerloader();
			codered.proceedToNextStep();
			codered.logout();

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}
}
