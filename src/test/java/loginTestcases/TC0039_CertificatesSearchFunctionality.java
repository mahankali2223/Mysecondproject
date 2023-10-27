package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CertificatePage;
import pageObjects.LMSPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0039_CertificatesSearchFunctionality extends BaseClass {
	@Test(priority = 0)
	public void certificateSearch() throws InterruptedException {
		try {
			CertificatePage certificate = new CertificatePage(driver);
			LoginPage lp = new LoginPage(driver);
			LMSPage lm = new LMSPage(driver);
			lp.navigateQA();
			lp.moveAndClick(lp.loginBttn);
			logger.info("Clicked on loginbutton");
			lp.sendKeys(lm.email, rb.getString("Emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("Psswd"));
			logger.info("Providing customer data");
			lp.click(lp.loginsubmit);
			logger.info("Clicked on loginsumbit");
			lm.spinnerloader();
			lm.spinnerloader();
			lm.moveAndClick(lm.certificates);
			lm.spinnerloader();
			lm.spinnerloader();
			String certificationName = certificate.getText(certificate.getOption(certificate.certificateName, 1));
			certificate.sendKeys(certificate.certificateSearchInput, certificationName);
			certificate.moveAndClick(certificate.certificateSearchBtn);
			certificate.spinnerloader();
			String[] certificationsName = lm.arrayGettext(certificate.certificateName);
			for (String certification : certificationsName) {
				Assert.assertEquals(certificationName.contains(certification), true,
						"Certification Search Result didn't match");
			}
			certificate.logoutQA();

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 1)
	public void certificateSearchNegative() throws InterruptedException {
		try {
			CertificatePage certificate = new CertificatePage(driver);
			LoginPage lp = new LoginPage(driver);
			LMSPage lm = new LMSPage(driver);
			lp.navigateQA();
			lp.moveAndClick(lp.loginBttn);
			logger.info("Clicked on loginbutton");
			lp.sendKeys(lm.email, rb.getString("Emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("Psswd"));
			logger.info("Providing customer data");
			lp.click(lp.loginsubmit);
			logger.info("Clicked on loginsumbit");
			lm.spinnerloader();
			lm.spinnerloader();
			lm.moveAndClick(lm.certificates);
			lm.spinnerloader();
			lm.spinnerloader();
			certificate.sendKeys(certificate.certificateSearchInput, "aawrrt@$");
			certificate.click(certificate.certificateSearchBtn);
			certificate.spinnerloader();
			Assert.assertEquals(certificate.isExisting(certificate.certificateName), false,
					" Certification Seach result populated after searching invalid input: aawrrt@$");
			certificate.logoutQA();

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
