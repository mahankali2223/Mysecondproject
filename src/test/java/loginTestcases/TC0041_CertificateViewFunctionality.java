package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CertificatePage;
import pageObjects.LMSPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0041_CertificateViewFunctionality extends BaseClass{
	@Test()
	public void viewCertificate() throws InterruptedException {
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
			String certificateName = certificate.getText(certificate.getOption(certificate.certificateName, 1));
			certificate.click(certificate.getOption(certificate.certificationViewBtn, 1));
			certificate.spinnerloader();
			Assert.assertEquals(certificate.getText(certificate.certificateHeader), "Certificate of Achievement",
					" Certification header not matching in view tab");
			Assert.assertEquals(certificateName, certificate.getText(certificate.certificationCourse),
					" Certification course name not match in view tab ");
			certificate.logoutQA();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}


}
