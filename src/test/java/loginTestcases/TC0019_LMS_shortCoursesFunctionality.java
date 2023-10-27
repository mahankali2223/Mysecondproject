package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LMSPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0019_LMS_shortCoursesFunctionality extends BaseClass {
	@Test(priority = 0)
	public void shortFreeCourses() throws InterruptedException {
		try {
			LoginPage lp = new LoginPage(driver);
			LMSPage lm = new LMSPage(driver);
			lm.navigateQA();
			lp.moveAndClick(lp.loginBttn);
			logger.info("Clicked on loginbutton");
			lp.sendKeys(lp.email, rb.getString("Emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("Psswd"));
			logger.info("Providing customer data");
			lp.click(lp.loginsubmit);
			logger.info("Clicked on loginsumbit");
			lm.spinnerloader();
			lm.spinnerloader();
			lp.click(lp.learn);
			lm.spinnerloader();
			lp.arrayGettext(lp.learnModules);
			lm.click(lm.shortCourses);
			lm.spinnerloader();
			lm.spinnerloader();
			lm.click(lm.freeCourses);
			lm.spinnerloader();
			lm.spinnerloader();
			String courseName = lm.getText(lm.getOption(lm.Coursesnames, 1));
			lm.getOption(lm.Coursesnames, 1);
			lm.spinnerloader();
			lm.spinnerloader();
			lm.moveAndClick(lm.startcourses);
			lm.spinnerloader();
			lm.spinnerloader();
			lm.spinnerloader();
			lm.moveAndClick(lm.resumeCourse);
			lm.spinnerloader();
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
			lm.spinnerloader();
			lm.click(lp.learn);
			lm.spinnerloader();
			lm.click(lm.shortCourses);
			lm.spinnerloader();
			lm.spinnerloader();
			lm.click(lm.inProgress);
			lm.spinnerloader();
			lm.spinnerloader();
			String[] coursesName = lm.arrayGettext(lm.Coursesnames);
			int flag = 0;
			for (String course : coursesName) {
				if (course.contains(courseName)) {
					flag = 1;
					break;
				}
			}
			Assert.assertEquals(flag, 1, "Started course " + courseName + " not present the progress");
			lm.logoutQA();

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 1)
	public void shortCoursesInprogressFunctionality() throws InterruptedException {
		try {
//
			LoginPage lp = new LoginPage(driver);
			LMSPage lm = new LMSPage(driver);
			lm.navigateQA();
			lp.moveAndClick(lp.loginBttn);
			logger.info("Clicked on loginbutton");
			lp.sendKeys(lp.email, rb.getString("Emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("Psswd"));
			logger.info("Providing customer data");
			lp.click(lp.loginsubmit);
			logger.info("Clicked on loginsumbit");
			lm.spinnerloader();
			lm.spinnerloader();
			lm.spinnerloader();
			lp.click(lp.learn);
			lm.click(lm.shortCourses);
			// For Non Pro user
			lm.spinnerloader();
			lm.spinnerloader();
			lm.click(lm.inProgress);
			lm.spinnerloader();
			String courseName = lm.getText(lm.getOption(lm.Coursesnames, 1));
			lm.spinnerloader();
			lm.spinnerloader();
			lm.moveAndClick(lm.startcourses);
			lm.spinnerloader();
			lm.spinnerloader();
			lm.spinnerloader();
			lm.moveAndClick(lm.resumeCourse);
			lm.spinnerloader();
			lm.spinnerloader();
			lm.spinnerloader();
			System.out.println("Lenth of chapter " + lm.chapterslist.size());
			for (int i = 0; i < lm.chapterslist.size(); i++) {
				if ((lm.chapterIconlist.get(i).getAttribute("class")).contains("fa-chevron-down")) {
					System.out.println("chapterNumber " + i);
					lm.click(lm.chapterslist.get(i));
				}
			}
			lm.spinnerloader();
			lm.spinnerloader();
			lm.moveAndClick(lm.lessonPlayIcon);
			lm.spinnerloader();

			while (lm.markComplete.isDisplayed()) {
//				String lessonName = lm.getText(lm.selectedLesson);
				lm.click(lm.markComplete);
				System.out.println("completed");
				lm.spinnerloader();
				lm.spinnerloader();
				lm.spinnerloader();
				lm.spinnerloader();

				if (!(lm.popupConfirm.isDisplayed())) {
					break;
				}
				lm.click(lm.popupConfirm);
				System.out.println("confirm");
				lm.spinnerloader();
				lm.spinnerloader();
				lm.spinnerloader();
//				Assert.assertEquals((lm.getLessonIcon(lessonName).getAttribute("class")).contains("fa-check-circle"),
//						true);
			}
			lm.click(lm.eccouncilIcon);
			lm.spinnerloader();
			lm.spinnerloader();
			lm.spinnerloader();
			lm.click(lp.learn);
			lm.spinnerloader();
			lm.click(lm.shortCourses);
			lm.spinnerloader();
			lm.spinnerloader();
			lm.click(lm.completed);
			lm.spinnerloader();
			lm.spinnerloader();
			String[] coursesName = lm.arrayGettext(lm.Coursesnames);
			int flag = 0;
			for (String course : coursesName) {
				if (course.contains(courseName)) {
					flag = 1;
					break;
				}
			}
			Assert.assertEquals(flag, 1, "Completed course " + courseName + " not present in complete section");
			lm.logoutQA();

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}
}
