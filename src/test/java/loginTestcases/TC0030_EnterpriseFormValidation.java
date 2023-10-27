package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.EnterprisePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0030_EnterpriseFormValidation extends BaseClass {
	@Test(groups = "enterprise")
	public void enterpriseFormValidations() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		EnterprisePage enterprise = new EnterprisePage(driver);
		try {

			LoginPage lp = new LoginPage(driver);
			lp.navigate();
			enterprise.moveAndClick(lp.loginBttn);
			logger.info("Clicked on loginbutton");
			enterprise.sendKeys(lp.email, rb.getString("emailid"));
			enterprise.sendKeys(lp.psswrd, rb.getString("psswd"));
			logger.info("Providing customer data");
			enterprise.click(lp.loginsubmit);
			logger.info("Clicked on loginsumbit");
			enterprise.spinnerloader();
			enterprise.spinnerloader();
			enterprise.click(enterprise.enterprise);
			enterprise.spinnerloader();
			enterprise.click(enterprise.bookFreeConsultationButton);
			enterprise.spinnerloader();

			driver.switchTo().frame(enterprise.popupModel);
			enterprise.spinnerloader();
			enterprise.moveAndClick(enterprise.nextmonth);
			enterprise.spinnerloader();
			enterprise.moveAndClick(enterprise.getOption(enterprise.availableDates, 1));
			enterprise.moveAndClick(enterprise.getOption(enterprise.availableTimes, 1));
			enterprise.moveAndClick(enterprise.nextBtn);
			enterprise.spinnerloader();

			// Blank form validation
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.getText(enterprise.fullNameErrorMsg).contains("Can't be blank."), true,
					"Full Name Error message didn't matched");
			softAssert.assertEquals(enterprise.getText(enterprise.emailErrorMsg).contains("Can't be blank."), true,
					"Email Error message didn't matched");
			softAssert.assertEquals(enterprise.getText(enterprise.phnNumErrorMsg).contains("Can't be blank."), true,
					"Phone number Error message didn't matched");
			softAssert.assertEquals(enterprise.getText(enterprise.companyNameErrorMsg).contains("Can't be blank."),
					true, "Company Name Error message didn't matched");
			softAssert.assertEquals(
					enterprise.getText(enterprise.companySizeErrorMsg).contains("One answer must be selected."), true,
					"Company Size Error message didn't matched");

			// verify form After filling the valid data
			enterprise.sendKeys(enterprise.fullNameInput, "Testing");
			softAssert.assertEquals(enterprise.isExisting(enterprise.fullNameErrorMesg), false,
					"Full Name Error message visible for valid input Testing");
			enterprise.clear(enterprise.fullNameInput);
			enterprise.sendKeys(enterprise.emailInput, "Abcd@yahh.com");
			softAssert.assertEquals(enterprise.isExisting(enterprise.emailErrorMesg), false,
					"Email Error message visible for valid input Abcd@yahh.com");
			enterprise.clear(enterprise.emailInput);
			enterprise.sendKeys(enterprise.phnNumInput, "9701667892");
			softAssert.assertEquals(enterprise.isExisting(enterprise.phnNumMesg), false,
					"Phone Number Error message visible for valid input 9701667892");
			enterprise.clear(enterprise.phnNumInput);
			enterprise.sendKeys(enterprise.companyNameInput, "Testing");
			softAssert.assertEquals(enterprise.isExisting(enterprise.companyErrorMesg), false,
					"Company Name Error message visible for valid input Testing");
			enterprise.clear(enterprise.companyNameInput);
			enterprise.click(enterprise.getOption(enterprise.companySizeOptions, 1));
			softAssert.assertEquals(enterprise.isExisting(enterprise.companysizeMesg), false,
					"Company size Error message visible for valid input");

			// verify FullName input field
			enterprise.sendKeys(enterprise.fullNameInput, "Testing");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.isExisting(enterprise.fullNameErrorMesg), false,
					"Full Name Error message visible for valid input Testing");
			enterprise.sendKeys(enterprise.fullNameInput, "123456899");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.isExisting(enterprise.fullNameErrorMesg), true,
					"Full Name Error message not visible for invalid input 123456899");
			enterprise.sendKeys(enterprise.fullNameInput, "@#$%&*");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.isExisting(enterprise.fullNameErrorMesg), true,
					"Full Name Error message not visible for invalid input @#$%&*");

			// verify Email input field
			enterprise.sendKeys(enterprise.emailInput, "Testing@Yahoo.com");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.isExisting(enterprise.emailErrorMesg), false,
					"Email Error message visible for valid input Testing@Yahoo.com");
			enterprise.sendKeys(enterprise.emailInput, "1345567");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.isExisting(enterprise.emailErrorMesg), true,
					"Email Error message not visible for invalid input 1345567");
			enterprise.sendKeys(enterprise.emailInput, "@#$%^&");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.isExisting(enterprise.emailErrorMesg), true,
					"Email Error message not visible for invalid input @#$%^&");
			enterprise.sendKeys(enterprise.emailInput, "abcderg@");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.isExisting(enterprise.emailErrorMesg), true,
					"Email Error message not visible for invalid input abcderg@");
			enterprise.sendKeys(enterprise.emailInput, "@yahh.com");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.isExisting(enterprise.emailErrorMesg), true,
					"Email Error message not visible for invalid input @yahh.com");

			// verify Phone number field
			enterprise.sendKeys(enterprise.phnNumInput, "8888888888");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.isExisting(enterprise.phnNumMesg), false,
					"Phone Number Error message visible for valid input 8888888888");
			enterprise.sendKeys(enterprise.phnNumInput, "8908765");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.phnNumErrorMsg.isDisplayed(), true,
					"Phone Number Error message not visible for invalid input 8908765");
			enterprise.sendKeys(enterprise.phnNumInput, "8900676545354352");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.phnNumErrorMsg.isDisplayed(), true,
					"Phone Number Error message not visible for invalid input 8900676545354352");
			enterprise.sendKeys(enterprise.phnNumInput, "abcderg");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.phnNumErrorMsg.isDisplayed(), true,
					"Phone Number Error message not visible for invalid input abcderg");
			enterprise.sendKeys(enterprise.phnNumInput, "@#$%&*");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.phnNumErrorMsg.isDisplayed(), true,
					"Phone Number Error message not visible for invalid input @#$%&*");
			softAssert.assertEquals(
					enterprise.getText(enterprise.phnNumErrorMsg).contains(
							"This phone number format is not recognized. Please check the country and number."),
					true, "Phone number Error message didn't matched");

			// verify company name field
			enterprise.sendKeys(enterprise.companyNameInput, "Testing");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.isExisting(enterprise.companyErrorMesg), false,
					"Company Name Error message visible for valid input Testing");
			enterprise.sendKeys(enterprise.companyNameInput, "Testing private limited");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.isExisting(enterprise.companyErrorMesg), false,
					"Company Name Error message visible for valid input Testing private limited");
			enterprise.sendKeys(enterprise.companyNameInput, "123456899");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.isExisting(enterprise.companyErrorMesg), true,
					"Company Name Error message not visible for invalid input 123456899");
			enterprise.sendKeys(enterprise.companyNameInput, "@#$%&*");
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			softAssert.assertEquals(enterprise.isExisting(enterprise.companyErrorMesg), true,
					"Company Name Error message not visible for invalid input @#$%&*");

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			driver.switchTo().defaultContent();
			enterprise.moveAndClick(enterprise.outSidePopPup);
			enterprise.spinnerloader();
			enterprise.logout();
			softAssert.assertAll();

		}
	}

}
