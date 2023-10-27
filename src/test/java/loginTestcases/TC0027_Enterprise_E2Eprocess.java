package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.EnterprisePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0027_Enterprise_E2Eprocess extends BaseClass {
	@Test(groups = { "enterprise2" })
	public void enterprise() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		try {

			LoginPage lp = new LoginPage(driver);
			EnterprisePage enterprise = new EnterprisePage(driver);
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
			softAssert.assertEquals(enterprise.getText(enterprise.enterpriseHeader), "EC-Council Enterprise",
					"Enterprise Title is not Matching");
			String infoMsg = "Close skill gaps in your IT teams with custom curriculum mapping, dedicated course development that targets your organization’s needs, and deep analytics that always put you in the driving seat of your team’s training."
					.trim();
			softAssert.assertEquals(enterprise.getText(enterprise.enterpriseHeaderInfo).trim(), infoMsg,
					"Enterprise Title info is not Matching");
			softAssert.assertEquals(enterprise.getText(enterprise.bookFreeConsultationButton).trim(),
					"Book a Free Consultation", "Book a Free Consultation button label is not Matching");
			enterprise.click(enterprise.bookFreeConsultationButton);
			enterprise.spinnerloader();

			driver.switchTo().frame(enterprise.popupModel);
			softAssert.assertEquals(enterprise.getText(enterprise.sidePanelName), "EC-Council",
					"Side Panel Name is not Matching");
			softAssert.assertEquals(enterprise.getText(enterprise.sidePanelHeader), "Discovery Call",
					"Side Panel Header is not Matching");
			softAssert.assertEquals(enterprise.getText(enterprise.sidePanelDuration), "30 min",
					"Side Panel Duration is not Matching");
			softAssert.assertEquals(enterprise.getText(enterprise.sidePanelEventType),
					"Web conferencing details provided upon confirmation.", "Side Panel Event is not Matching");
			String sidePanelInfo = "We want to learn more about you! This short call gives you time to let us know about your needs to see if our products and services are right for you."
					.trim();
			softAssert.assertEquals(enterprise.getText(enterprise.sidePanelInfo).trim(), sidePanelInfo,
					"Side Pane Info is not Matching");
			softAssert.assertEquals(enterprise.getText(enterprise.calendarHeader).trim(), "Select a Date & Time",
					"Calendar Header is not Matching");
			softAssert.assertEquals(enterprise.getText(enterprise.timeZoneHeader).trim(), "Time zone",
					"Time Zone Header is not Matching");
//			enterprise.moveAndClick(enterprise.nextmonth);
			enterprise.spinnerloader();
			String selectedDate = enterprise.getText(enterprise.getOption(enterprise.availableDates, 1));
			String selectedMonth = (enterprise.getText(enterprise.selectedMonth).split(" "))[0];
			String selectedYear = (enterprise.getText(enterprise.selectedMonth).split(" "))[1];
			System.out.println(selectedDate + " / " + selectedMonth + " / " + selectedYear);
			enterprise.moveAndClick(enterprise.getOption(enterprise.availableDates, 1));
			softAssert.assertEquals(
					enterprise.getText(enterprise.selectedDateDetails).trim()
							.contains((selectedMonth + " " + selectedDate).trim()),
					true, "Selected Date " + enterprise.getText(enterprise.selectedDateDetails)
							+ " is not Matching with " + selectedMonth + " " + selectedDate);
			String selectedTimeZone = enterprise.getText(enterprise.selectedTimeZone);
			String selectedTime = enterprise.getText(enterprise.getOption(enterprise.availableTimes, 1));
			enterprise.moveAndClick(enterprise.getOption(enterprise.availableTimes, 1));
			enterprise.moveAndClick(enterprise.nextBtn);
			enterprise.spinnerloader();
			softAssert.assertEquals(enterprise.getText(enterprise.sidePanelName), "EC-Council",
					"Side Panel Name is not Matching");
			softAssert.assertEquals(enterprise.getText(enterprise.sidePanelHeader), "Discovery Call",
					"Side Panel Header is not Matching");
			softAssert.assertEquals(enterprise.getText(enterprise.sidePanelDuration), "30 min",
					"Side Panel Duration is not Matching");
			softAssert.assertEquals(enterprise.getText(enterprise.sidePanelEventType),
					"Web conferencing details provided upon confirmation.", "Side Panel Event is not Matching");
			sidePanelInfo = "We want to learn more about you! This short call gives you time to let us know about your needs to see if our products and services are right for you."
					.trim();
			softAssert.assertEquals(enterprise.getText(enterprise.sidePanelInfo).trim(), sidePanelInfo,
					"Side Panel Info is not Matching");
			softAssert.assertEquals(selectedTimeZone.contains(enterprise.getText(enterprise.sidePanelTimeZone)), true,
					"Side Panel selected Timezone is not Matching");
			softAssert.assertEquals(enterprise.getText(enterprise.sidePanelTimeDetails).contains(selectedTime), true,
					"Selected Time not populated correctly in side panel");
			softAssert.assertEquals(
					enterprise.getText(enterprise.sidePanelTimeDetails)
							.contains(selectedMonth + " " + selectedDate + ", " + selectedYear),
					true, "Selected Date not populated correctly in side panel");
			enterprise.sendKeys(enterprise.fullNameInput, "Testing");
			enterprise.sendKeys(enterprise.emailInput, "Abcd@yahh.com");
			enterprise.sendKeys(enterprise.phnNumInput, "9701667892");
			enterprise.sendKeys(enterprise.companyNameInput, "Test");
			enterprise.click(enterprise.getOption(enterprise.companySizeOptions, 1));
			enterprise.sendKeys(enterprise.moreInfoInput, "Testing Purpose");
			enterprise.spinnerloader();
//			if (enterprise.isExisting(enterprise.cookiesCloseButton)) {
//				enterprise.click(enterprise.cookiesCloseBtn);
//			}
			enterprise.moveAndClick(enterprise.scheduleEventButton);
			enterprise.spinnerloader();
			enterprise.spinnerloader();
			softAssert.assertEquals(enterprise.getText(enterprise.successMsgHeader), "You are scheduled",
					"Success header is not Matching");
			softAssert.assertEquals(enterprise.getText(enterprise.successMsgInfo),
					"A calendar invitation has been sent to your email address.",
					"Success header info is not Matching");
			softAssert.assertEquals(enterprise.getText(enterprise.successDetailHeader), "Discovery Call",
					"Success detail header is not Matching");
			softAssert.assertEquals(enterprise.getText(enterprise.successDetailName), "EC-Council",
					"Sucess detail Name is not Matching");
			softAssert.assertEquals(enterprise.getText(enterprise.successDetailEventType),
					"Web conferencing details to follow.", "Sucess detail event type is not Matching");
			softAssert.assertEquals(selectedTimeZone.contains(enterprise.getText(enterprise.sidePanelTimeZone)), true,
					"Sucess detail Timezone is not Matching");
			softAssert.assertEquals(enterprise.getText(enterprise.sidePanelTimeDetails).contains(selectedTime), true,
					"Selected Time not populated correctly in success details");
			softAssert.assertEquals(
					enterprise.getText(enterprise.sidePanelTimeDetails)
							.contains(selectedMonth + " " + selectedDate + ", " + selectedYear),
					true, "Selected Date not populated correctly in success details");
			driver.switchTo().defaultContent();
			enterprise.moveAndClick(enterprise.outSidePopPup);
			enterprise.logout();

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			softAssert.assertAll();
		}
	}

}
