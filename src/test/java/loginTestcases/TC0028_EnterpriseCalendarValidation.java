package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.EnterprisePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0028_EnterpriseCalendarValidation extends BaseClass {

	@Test(groups = {"enterprise"})
	public void enterpriseCalendarValidation() throws InterruptedException {
		try {

			LoginPage lp = new LoginPage(driver);
			EnterprisePage enterprise = new EnterprisePage(driver);
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
			String selectedMonth = (enterprise.getText(enterprise.selectedMonth).split(" "))[0];
			int currentDate = Integer.parseInt(enterprise.getText(enterprise.currentDate));
			System.out.println(currentDate);
			for (int i = 1; i < currentDate; i++) {
				System.out.println(i);
				Assert.assertEquals(enterprise.getDate(i, selectedMonth).getAttribute("disabled"), "true",
						currentDate + " " + selectedMonth + " is not disable");
			}
			driver.switchTo().defaultContent();
			enterprise.moveAndClick(enterprise.outSidePopPup);
			enterprise.logout();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}
}
