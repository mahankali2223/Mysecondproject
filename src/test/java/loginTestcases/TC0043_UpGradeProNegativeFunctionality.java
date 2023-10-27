package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPage;
import pageObjects.UpgradeProPage;
import testBase.BaseClass;

public class TC0043_UpGradeProNegativeFunctionality extends BaseClass {
	@Test(priority = 0)
	public void upGradeProNegative() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		try {
			LoginPage lp = new LoginPage(driver);
			UpgradeProPage Pro = new UpgradeProPage(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginBttn);
			logger.info("Clicked on loginbutton");
			lp.sendKeys(lp.email, rb.getString("emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("psswd"));
			logger.info("Providing customer data");
			lp.click(lp.loginsubmit);
			logger.info("Clicked on loginsumbit");
			lp.spinnerloader();
			lp.spinnerloader();
			Pro.moveAndClick(Pro.upGradePro);
			lp.spinnerloader();
			Pro.moveAndClick(Pro.getStartNow);
			lp.spinnerloader();
			Pro.moveAndClick(Pro.freeTrial);
			
			// Blank form validation
			Pro.moveAndClick(Pro.placeOrderBtn);
			softAssert.assertEquals(Pro.getText(Pro.firstNameError).contains("Please enter your first name"), true,
					"Fist Name Error message didn't matched");
			softAssert.assertEquals(Pro.getText(Pro.lastNameError).contains("Please enter your last name"), true,
					"last Name Error message didn't matched");
			softAssert.assertEquals(Pro.getText(Pro.emailError).contains("Please enter your email address"), true,
					"Email Error message didn't matched");
			softAssert.assertEquals(Pro.getText(Pro.addressError).contains("Please enter address"), true,
					"Address Error message didn't matched");
			softAssert.assertEquals(Pro.getText(Pro.cityError).contains("Please enter your city"), true,
					"city Error message didn't matched");
			softAssert.assertEquals(Pro.getText(Pro.countryError).contains("Please select a country"), true,
					"country Error message didn't matched");
			softAssert.assertEquals(Pro.getText(Pro.regionError).contains("Please enter region"), true,
					"Region Error message didn't matched");
			softAssert.assertEquals(Pro.getText(Pro.postalCodeError).contains("Please enter postal code"), true,
					"Postal Code Error message didn't matched");
			
			// Email validation
			
//			Pro.checkInvalidEmailMsg(rb.getString("captial"));
//			Pro.checkInvalidEmailMsg(rb.getString("small"));
//			Pro.checkInvalidEmailMsg(rb.getString("specialcharamissing"));
//			Pro.checkInvalidEmailMsg(rb.getString("specailcharas"));
//			Pro.checkInvalidEmailMsg(rb.getString("singlechar"));
//			Pro.checkInvalidEmailMsg(rb.getString("wer"));
//			Pro.checkInvalidEmailMsg(rb.getString("adg"));
			
			
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
