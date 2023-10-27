package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.UpgradeProPage;
import testBase.BaseClass;

public class TC0042_UpGradeProFunctionality extends BaseClass {
	@Test(priority = 0)
	public void upGradePro() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			UpgradeProPage Pro =new UpgradeProPage(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginBttn);
			logger.info("Clicked on loginbutton");
			lp.sendKeys(lp.email, rb.getString("Emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("Psswd"));
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
			Pro.sendKeys(Pro.firstName, "Lavanya");
			Pro.sendKeys(Pro.lastName, "mahankali");
			Pro.sendKeys(Pro.email, "mhankaliLavanya44@gmail.com");
			Pro.sendKeys(Pro.address, "H.no 1-24 Hyderabad");
			lp.spinnerloader();
			Pro.sendKeys(Pro.cityName, "Hyderabad");
			Pro.click(Pro.CountryDropDown);
			lp.spinnerloader();
			Pro.sendKeys(Pro.region, "Telangana");
			Pro.sendKeys(Pro.postalCode, "500016");
			Pro.click(Pro.creditCard);
			Pro.sendKeys(Pro.cardNumber, "1234567989009987");
			Pro.sendKeys(Pro.expiryDate,"09/24");
			Pro.sendKeys(Pro.cvcInput, "456");
			Pro.click(Pro.countryInput);
			
			lp.logout();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
