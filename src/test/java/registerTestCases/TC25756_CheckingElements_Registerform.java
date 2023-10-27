package registerTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.CoderedRegister2;
import testBase.BaseClass;

public class TC25756_CheckingElements_Registerform extends BaseClass {

	@Test
	public void testAccountCheckingElements() throws InterruptedException {
		try {
			CoderedRegister2 regPage = new CoderedRegister2(driver);
			AccountRegisterationPage codered = new AccountRegisterationPage(driver);
			regPage.navigate();
			String firstlabel = regPage.getText(regPage.firstNameLabel);
			String firstName = "First Name *";
			Assert.assertEquals(firstlabel, firstName);
			String emaillabel = regPage.getText(regPage.emailLabel);
			String emailLabel = "Email *";
			Assert.assertEquals(emaillabel, emailLabel);
			String password = regPage.getText(regPage.password);
			String psswrdlabel = "Password *";
			Assert.assertEquals(password, psswrdlabel);
			regPage.sendKeys(regPage.firstName, codered.name);
			regPage.sendKeys(regPage.email, codered.name + "@gmail.com");
			regPage.sendKeys(regPage.psswrd, regPage.randomAlphaNumeric());
			regPage.click(regPage.chkbox);
			regPage.click(regPage.submit);
			regPage.spinnerloader();
			codered.assertionHeaders();
			codered.logout();

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}

	}

}
