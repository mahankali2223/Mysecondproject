package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EnterprisePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

@Test(groups = { "enterprise1" })
public class TC0029_EnterpriseTimeZone extends BaseClass {

	public void enterpriseTimeZoneSearch() throws InterruptedException {
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
//			enterprise.moveAndClick(enterprise.nextmonth);
			enterprise.spinnerloader();
			enterprise.moveAndClick(enterprise.selectedTimeZone);
			enterprise.sendKeys(enterprise.timeZoneSearch, "Asia");
			String[] searchResult = enterprise.arrayGettext(enterprise.timeZoneList);
			for (String result : searchResult) {
				if (!(result.contains("Asia"))) {
					Assert.assertEquals(true, false, "After Searchig for Asia got " + result + " in result");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			driver.switchTo().defaultContent();
			enterprise.moveAndClick(enterprise.outSidePopPup);
			enterprise.spinnerloader();
			enterprise.logout();
		}
	}

	@Test(groups = "enterprise")
	public void enterpriseTimezoneSearchNegative() throws InterruptedException {
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
//			enterprise.click(enterprise.nextmonth);
			enterprise.spinnerloader();
			enterprise.moveAndClick(enterprise.selectedTimeZone);
			enterprise.sendKeys(enterprise.timeZoneSearch, "@12345");
			Assert.assertEquals(enterprise.arrayGettext(enterprise.timeZoneList).length, 0,
					" Getting Result for invalid Search @12345 ");
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			driver.switchTo().defaultContent();
			enterprise.moveAndClick(enterprise.outSidePopPup);
			enterprise.spinnerloader();
			enterprise.logout();
		}
	}

	@Test
	public void enterpriseTimeZoneRadioBtnValidation() throws InterruptedException {
		EnterprisePage enterprise = new EnterprisePage(driver);
		try {

			LoginPage lp = new LoginPage(driver);
			enterprise.navigate();
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
			Thread.sleep(5000);
//			if (enterprise.cookiesCloseBtn.isDisplayed()) {
//				enterprise.moveAndClick(enterprise.cookiesCloseBtn);
//			}
//			enterprise.click(enterprise.nextmonth);
			enterprise.spinnerloader();
			enterprise.click(enterprise.getOption(enterprise.availableDates, 1));
			enterprise.moveAndClick(enterprise.selectedTimeZone);
			enterprise.moveAndClick(enterprise.hoursTypeRadioButton);
			System.out.println("click radio btn 1");
			Thread.sleep(5000);
			String[] availableTimes = enterprise.arrayGettext(enterprise.availableTimes);
			for (String result : availableTimes) {
				System.out.println(result);
				if (result.contains("am") || result.contains("pm")) {
					Assert.assertEquals(true, false, "After enabling 24 hours type getting result of 12hrs type ");
				}
			}

			enterprise.moveAndClick(enterprise.hoursTypeRadioBtn);
			System.out.println("click radio btn 2");
			Thread.sleep(5000);
			availableTimes = enterprise.arrayGettext(enterprise.availableTimes);
			for (String result : availableTimes) {
				System.out.println(result);
				System.out.println(result.contains("am"));
				System.out.println(result.contains("pm"));
				if (!(result.contains("am") || result.contains("pm"))) {
					Assert.assertEquals(true, false, "After enabling 12 hours type getting result of 24hrs type ");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		} finally {
			driver.switchTo().defaultContent();
			enterprise.moveAndClick(enterprise.outSidePopPup);
			enterprise.spinnerloader();
			enterprise.logout();
		}
	}
}
