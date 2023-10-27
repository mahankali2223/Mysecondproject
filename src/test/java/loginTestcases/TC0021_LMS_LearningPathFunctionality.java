package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LMSPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0021_LMS_LearningPathFunctionality extends BaseClass {

	@Test
	public void learningPathCourses() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			LMSPage lm = new LMSPage(driver);
			lm.navigateQA();
			lp.moveAndClick(lp.loginBttn);
			logger.info("Clicked on loginbutton");
			lp.sendKeys(lp.email, rb.getString("LEmailID"));
			lp.sendKeys(lp.psswrd, rb.getString("LPwsd"));
			logger.info("Providing customer data");
			lp.click(lp.loginsubmit);
			logger.info("Clicked on loginsumbit");
			lm.spinnerloader();
			lm.spinnerloader();
			lp.moveAndClick(lp.learn);
			lm.click(lm.learningPath);
			lm.spinnerloader();
			lm.click(lm.purchased);
			lm.spinnerloader();
			String bundleName = lm.getText(lm.getOption(lm.bundleNames, 1));
			lm.spinnerloader();
			lm.moveAndClick(lm.GoToDashBoard);
			lm.spinnerloader();
			lm.moveAndClick(lm.CourseListButton.get(0));
			lm.spinnerloader();
			lm.spinnerloader();
			System.out.println("Lenth of chapter " + lm.chapterslist.size());
			for (int i = 0; i < lm.chapterslist.size(); i++) {
				if ((lm.chapterIconlist.get(i).getAttribute("class")).contains("fa-chevron-down")) {
					lm.moveAndClick(lm.chapterslist.get(i));
				}
			}
			lm.spinnerloader();
			lm.spinnerloader();
			lm.moveAndClick(lm.lessonPlayIcon);
			lm.spinnerloader();

			while (lm.markComplete.isDisplayed()) {
//				String lessonName = lm.getText(lm.selectedLesson);
				lm.click(lm.markComplete);
				lm.spinnerloader();
				lm.spinnerloader();
				lm.spinnerloader();
				lm.click(lm.popupConfirm);
				System.out.println("confirm");
				lm.spinnerloader();
				lm.spinnerloader();
				lm.spinnerloader();
//				Assert.assertEquals((lm.getLessonIcon(lessonName).getAttribute("class")).contains("fa-check-circle"),
//						true);
			}

			lm.moveAndClick(lm.eccouncilIcon);
			lm.spinnerloader();
			lm.spinnerloader();
			lm.spinnerloader();
			lm.click(lp.learn);
			lm.spinnerloader();
			lm.click(lm.learningPath);
			lm.spinnerloader();
			lm.click(lm.inProgress);
			lm.spinnerloader();
			lm.spinnerloader();
			String[] bundlesName = lm.arrayGettext(lm.bundleNames);
			int flag = 0;
			for (String bundle : bundlesName) {
				if (bundle.contains(bundleName)) {
					flag = 1;
					break;
				}
			}
			Assert.assertEquals(flag, 1, "Started Bundle " + bundleName + " not present in Progress section");
			lm.logoutQA();

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

//	@Test
//	public void learningpathInprogressFunctionality() throws InterruptedException {
//		try {
//
//			LoginPage lp = new LoginPage(driver);
//			LMSPage lm = new LMSPage(driver);
//	        lm.navigateQA();
//			lp.moveAndClick(lp.loginBttn);
//			logger.info("Clicked on loginbutton");
//			lp.sendKeys(lp.email, rb.getString("Emailid"));
//			lp.sendKeys(lp.psswrd, rb.getString("Psswd"));
//			logger.info("Providing customer data");
//			lp.click(lp.loginsubmit);
//			logger.info("Clicked on loginsumbit");
//			lm.spinnerloader();
//			lm.spinnerloader();
//			lp.click(lp.learn);
//			lm.click(lm.learningPath);
//			lm.spinnerloader();
//			lm.click(lm.inProgress);
//			lm.spinnerloader();
//			String bundleName = lm.getText(lm.getOption(lm.bundleNames, 1));
//			lm.spinnerloader();
//			lm.spinnerloader();
//			lm.moveAndClick(lm.GoToDashBoard);
//			lm.spinnerloader();
//			for (int j = 0; j < lm.CourseList.size(); j++) {
//				lm.moveAndClick(lm.CourseListButton.get(j));
//				lm.spinnerloader();
//				lm.spinnerloader();
//				System.out.println("Lenth of chapter " + lm.chapterslist.size());
//				for (int i = 0; i < lm.chapterslist.size(); i++) {
//					if ((lm.chapterIconlist.get(i).getAttribute("class")).contains("fa-chevron-down")) {
//						lm.click(lm.chapterslist.get(i));
//					}
//				}
//				lm.spinnerloader();
//				lm.spinnerloader();
//				lm.moveAndClick(lm.lessonPlayIcon);
//				lm.spinnerloader();
//				while (lm.markComplete.isDisplayed()) {
////				String lessonName = lm.getText(lm.selectedLesson);
//					lm.click(lm.markComplete);
//					lm.spinnerloader();
//					lm.spinnerloader();
//					lm.spinnerloader();
//					lm.click(lm.popupConfirm);
//					System.out.println("confirm");
//					lm.spinnerloader();
//					lm.spinnerloader();
//					lm.spinnerloader();
//					if (lm.quizQuestionLabel.isDisplayed()) {
//						int numOfQuestion = Integer.parseInt((lm.getText(lm.quizQuestionLabel).split("of "))[1]);
//						Thread.sleep(numOfQuestion * 2000);
//
//					}
////				Assert.assertEquals((lm.getLessonIcon(lessonName).getAttribute("class")).contains("fa-check-circle"),
////						true);
//				}
////
//				lm.click(lm.eccouncilIcon);
//				lm.spinnerloader();
//				lm.spinnerloader();
//				Thread.sleep(10000);
//				lm.click(lp.learn);
//				Thread.sleep(2000);
//				lm.click(lm.learningPath);
//				Thread.sleep(5000);
//				lm.click(lm.inProgress);
//				lm.spinnerloader();
//				Thread.sleep(2000);
//				lm.click(lm.GoToDashBoard);
//			}
//
//			lm.click(lm.eccouncilIcon);
//			lm.spinnerloader();
//			lm.spinnerloader();
//			Thread.sleep(10000);
//			lm.click(lp.learn);
//			Thread.sleep(2000);
//			lm.click(lm.learningPath);
//			Thread.sleep(5000);
//			lm.click(lm.completed);
//			lm.spinnerloader();
//			Thread.sleep(2000);
//			String[] bundlesName = lm.arrayGettext(lm.bundleNames);
//			int flag = 0;
//			for (String bundle : bundlesName) {
//				if (bundle.contains(bundleName)) {
//					flag = 1;
//					break;
//				}
//			}
//			Assert.assertEquals(flag, 1, "Completed " + bundleName + " not present completed section");
//			lm.logoutQA();
//
//		} catch (Exception e) {
//			System.out.println(e);
//			Assert.fail();
//		}
//	}
}
