package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CertificatePage;
import pageObjects.LMSPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0040CertificationFilterFunctionality extends BaseClass {
	@Test(priority = 0)
	public void certificateFilter() throws InterruptedException {
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
			String[] allCertificationType = certificate.arrayGettext(certificate.certificateType);
			certificate.moveAndClick(certificate.certificateFilter);
			String[] certificationFilters = certificate.arrayGettext(certificate.certificationFilterLabels);
			certificate.moveAndClick(certificate.certificateFilter);
			for (int i = 0; i < certificationFilters.length; i++) {
				certificate.moveAndClick(certificate.certificateFilter);
				certificate.moveAndClick(certificate.getOption(certificate.certificationFilterLabels, i + 1));
				certificate.moveAndClick(certificate.certificateSearchBtn);
				certificate.spinnerloader();
				int j = 0;
				for (String allCertification : allCertificationType) {
					if (certificationFilters[i].contains(allCertification)) {
						j++;
					}
				}
				String[] certificationType = certificate.arrayGettext(certificate.certificateType);
				Assert.assertEquals(certificationType.length, j, "Result not filtered properly");
				for (String certificationTypes : certificationType) {
					System.out.println(certificationTypes + " ---- " + certificationFilters[i]);
					Assert.assertEquals(certificationFilters[i].contains(certificationTypes), true, certificationTypes
							+ " - Result not populated correctly for filter: " + certificationFilters[i]);

				}
				certificate.moveAndClick(certificate.certificateFilter);
				certificate.moveAndClick(certificate.getOption(certificate.certificationFilterLabels, i + 1));
				certificate.moveAndClick(certificate.certificateFilter);
			}
			certificate.logoutQA();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 1)
	public void certificateFilterMultipleOptions() throws InterruptedException {
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
			String[] allCertificationType = certificate.arrayGettext(certificate.certificateType);
			certificate.moveAndClick(certificate.certificateFilter);
			String[] certificationFilters = certificate.arrayGettext(certificate.certificationFilterLabels);
			certificate.moveAndClick(certificate.certificateFilter);
			// Two Options
			for (int i = 0; i < certificationFilters.length - 1; i++) {
				certificate.moveAndClick(certificate.certificateFilter);
				certificate.moveAndClick(certificate.getOption(certificate.certificationFilterLabels, i + 1));
				certificate.moveAndClick(certificate.getOption(certificate.certificationFilterLabels, i + 2));
				certificate.moveAndClick(certificate.certificateSearchBtn);
				certificate.spinnerloader();
				int j = 0;
				for (String allCertification : allCertificationType) {
					if (certificationFilters[i].contains(allCertification)
							|| certificationFilters[i + 1].contains(allCertification)) {
						j++;
					}
				}
				String[] certificationType = certificate.arrayGettext(certificate.certificateType);
				Assert.assertEquals(certificationType.length, j, "Result not filtered properly");
				for (String certificationTypes : certificationType) {
					Assert.assertEquals(
							(certificationFilters[i].contains(certificationTypes)
									|| certificationFilters[i + 1].contains(certificationTypes)),
							true, certificationTypes + " - Result not populated correctly for filter: "
									+ certificationFilters[i] + " and " + certificationFilters[i + 1]);

				}
				certificate.moveAndClick(certificate.certificateFilter);
				certificate.moveAndClick(certificate.getOption(certificate.certificationFilterLabels, i + 1));
				certificate.moveAndClick(certificate.getOption(certificate.certificationFilterLabels, i + 2));
				certificate.moveAndClick(certificate.certificateFilter);
			}
			// Three Options
			for (int i = 0; i < certificationFilters.length - 2; i++) {
				certificate.moveAndClick(certificate.certificateFilter);
				certificate.moveAndClick(certificate.getOption(certificate.certificationFilterLabels, i + 1));
				certificate.moveAndClick(certificate.getOption(certificate.certificationFilterLabels, i + 2));
				certificate.moveAndClick(certificate.getOption(certificate.certificationFilterLabels, i + 3));
				certificate.moveAndClick(certificate.certificateSearchBtn);
				certificate.spinnerloader();
				int j = 0;
				for (String allCertification : allCertificationType) {
					if (certificationFilters[i].contains(allCertification)
							|| certificationFilters[i + 1].contains(allCertification)
							|| certificationFilters[i + 2].contains(allCertification)) {
						j++;
					}
				}
				String[] certificationType = certificate.arrayGettext(certificate.certificateType);
				Assert.assertEquals(certificationType.length, j, "Result not filtered properly");
				for (String certificationTypes : certificationType) {
					Assert.assertEquals(
							(certificationFilters[i].contains(certificationTypes)
									|| certificationFilters[i + 1].contains(certificationTypes)
									|| certificationFilters[i + 2].contains(certificationTypes)),
							true,
							certificationTypes + " - Result not populated correctly for filter: "
									+ certificationFilters[i] + " and " + certificationFilters[i + 1] + " and "
									+ certificationFilters[i + 2]);

				}
				certificate.moveAndClick(certificate.certificateFilter);
				certificate.moveAndClick(certificate.getOption(certificate.certificationFilterLabels, i + 1));
				certificate.moveAndClick(certificate.getOption(certificate.certificationFilterLabels, i + 2));
				certificate.moveAndClick(certificate.getOption(certificate.certificationFilterLabels, i + 3));
				certificate.moveAndClick(certificate.certificateFilter);
			}
			certificate.logoutQA();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}
}
