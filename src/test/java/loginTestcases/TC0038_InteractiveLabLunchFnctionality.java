package loginTestcases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LMSPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0038_InteractiveLabLunchFnctionality extends BaseClass {
	@Test(priority = 0)
	public void interactiveLabSearch() throws InterruptedException {
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
			lp.spinnerloader();
			lp.spinnerloader();
			lm.moveAndClick(lm.interactiveLabs);
			lp.spinnerloader();
			lm.click(lm.labSearch);
			lp.spinnerloader();
			lm.sendKeys(lm.labSearch, "Data");
			lm.spinnerloader();
			lm.spinnerloader();
			lm.getOption(lm.labNames, 1);
			lm.spinnerloader();
			lm.moveAndClick(lm.learnMore);
			lm.spinnerloader();
			lm.spinnerloader();
			lm.moveAndClick(lm.lunchLab);
			lm.spinnerloader();
			lm.spinnerloader();
			lm.spinnerloader();
			String parentWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			// Converting HashSet to Array
			String[] windowHandles = allWindowHandles.toArray(new String[allWindowHandles.size()]);
			driver.switchTo().window(windowHandles[1]);
			// Iterate over all handles and switch to child window
//			for (String handle : allWindowHandles) {
//				if (!handle.equals(parentWindowHandle)) {
//					driver.switchTo().window(handle);
//					break;
//				}
//			}
			Assert.assertEquals(lm.getText(lm.playHeader).trim(), "Play Experience", "Play header not matching in tab");
			lm.moveAndClick(lm.playButton);
			lm.spinnerloader();
			lm.spinnerloader();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
//			Assert.assertEquals(lm.getText(lm.labQueue).contains(" Lab Queue Position: "),
//					"LabQueue header not matching in tab");
//			Assert.assertEquals(lm.getText(lm.labCpyState).contains(" Lab Copy State: "), true,
//					" LabCoptyState header not matching in tab");
//			Assert.assertEquals(lm.getText(lm.labCreationProgress).contains(" Lab Creation Progress: "), true,
//					" LabCreation header not matching in tab");
//			Assert.assertEquals(lm.getText(lm.labRedirection).contains(" Lab Redirection State: "), true,
//					" LabRedirection header not matching in tab");
//			Assert.assertEquals(lm.getText(lm.labLaunchState).contains(" Lab Launch State: "), true,
//					" LabLaunch header not matching in tab");
//			Assert.assertEquals(lm.getText(lm.moduleName).trim(),
//					"CHFI V10 Module 04 Data Acquisition and Duplication CyberQ Labs",
//					"Module Name header not matching in tab");
			wait.until(ExpectedConditions.elementToBeClickable(lm.LaunchButton)).click();
			lm.spinnerloader();
			lm.spinnerloader();
			lm.spinnerloader();
			lm.moveAndClick(lm.terminateButton);
			lm.spinnerloader();
			Assert.assertEquals(lm.getText(lm.finishLabHeader).trim(), "Finish Lab",
					"FinishLab header not matching in tab");
			Assert.assertEquals(lm.getText(lm.finishLabQuestion).trim(), "Do you want to Finish the Lab ?",
					"FinishLabquestion header not matching in tab");
			lm.moveAndClick(lm.finishButton);
			lm.spinnerloader();
			lm.spinnerloader();
//			Assert.assertEquals(lm.getText(lm.closedWindowSuccessMeg).trim(),
//					" Great Job! You have completed this Lab. [Close Window] ",
//					"SuccessWindow header not matching in tab");
//			Assert.assertEquals(lm.getText(lm.terminatedSuccessMeg).trim(), " Lab Terminated Successfully  ",
//					"Terminated Success Msg not matching in tab");
			driver.close();
			driver.switchTo().window(parentWindowHandle);
			lm.logoutQA();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}
}
