package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LMSPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0034_LMS_MicroDegreeFunctionality extends BaseClass {
	@Test
	public void learningPathCourses() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			LMSPage lm = new LMSPage(driver);
			lm.navigateQA();
			lp.moveAndClick(lp.loginBttn);
			logger.info("Clicked on loginbutton");
			lp.sendKeys(lp.email, rb.getString("EmailID"));
			lp.sendKeys(lp.psswrd, rb.getString("PSSwd"));
			logger.info("Providing customer data");
			lp.click(lp.loginsubmit);
			logger.info("Clicked on loginsumbit");
			lm.spinnerloader();
			lm.spinnerloader();
			lp.moveAndClick(lp.learn);
			lm.click(lm.microDegree);
			lm.spinnerloader();
			lm.click(lm.purchased);
			lm.spinnerloader();
			String degreeName = lm.getText(lm.getOption(lm.microDegreeNames, 1));
			lm.spinnerloader();
			lm.moveAndClick(lm.microGoToDashBoard);
			lm.spinnerloader();
			lm.moveAndClick(lm.startLearning);
			lm.spinnerloader();
			lm.spinnerloader();
//			String lessonName = lm.getText(lm.selectedLesson);
			lm.click(lm.markComplete);
			lm.spinnerloader();
			lm.spinnerloader();
			lm.spinnerloader();
			lm.click(lm.popupConfirm);
			lm.spinnerloader();
			lm.spinnerloader();
//			Assert.assertEquals((lm.getLessonIcon(lessonName).getAttribute("class")).contains("fa-check-circle"), true);
			lm.click(lm.eccouncilIcon);
			lm.spinnerloader();
			lm.spinnerloader();
			lm.spinnerloader();
			lm.click(lp.learn);
			lm.spinnerloader();
			lm.click(lm.microDegree);
			lm.spinnerloader();
			lm.click(lm.inProgress);
			lm.spinnerloader();
			lm.spinnerloader();
			String[] coursesName = lm.arrayGettext(lm.microDegreeNames);
			int flag = 0;
			for (String course : coursesName) {
				if (course.contains(degreeName)) {
					flag = 1;
					break;
				}
			}
			Assert.assertEquals(flag, 1, "Started course " + degreeName + " not present the progress");
			lm.logoutQA();

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}
}
