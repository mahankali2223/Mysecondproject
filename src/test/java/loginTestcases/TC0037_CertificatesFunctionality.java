package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CertificatePage;
import pageObjects.LMSPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0037_CertificatesFunctionality extends BaseClass {
	@Test(priority = 0)
	public void certificate() throws InterruptedException {
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
			lp.click(lp.learn);
			lm.click(lm.shortCourses);
			lm.spinnerloader();
			lm.click(lm.completed);
			lm.spinnerloader();
			lm.spinnerloader();
			String[] coursesName = lm.arrayGettext(lm.Coursesnames);
			lm.moveAndClick(lm.certificates);
			lm.spinnerloader();
			lm.spinnerloader();
			String[] certificationsName = lm.arrayGettext(certificate.certificateName);
			for (String courseName : coursesName) {
				int flag = 0;
				for (String certificationName : certificationsName) {
					System.out.println(courseName + " ----- " + certificationName + " -");
					if (certificationName.equals(courseName)) {
						flag = 1;
						break;
					}
				}
				Assert.assertEquals(flag, 1,
						"Certification not available in certification tab for " + courseName + " completed course");
			}
			certificate.logoutQA();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
