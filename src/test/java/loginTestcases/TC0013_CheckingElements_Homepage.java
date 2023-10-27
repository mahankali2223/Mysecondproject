
package loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0013_CheckingElements_Homepage extends BaseClass {

	@Test
	public void testAccountLogin() throws InterruptedException {

		try {
			LoginPage lp = new LoginPage(driver);
			lp.navigate();
			lp.moveAndClick(lp.loginButton);
			lp.sendKeys(lp.email, rb.getString("emailid"));
			lp.sendKeys(lp.psswrd, rb.getString("psswd"));
			lp.click(lp.loginsubmit);
			Thread.sleep(10000);
			String welmsg = lp.getText(lp.welComemsg);
			// Checking Message on screen
			String mesg = "Welcome, lavanya!";
			Assert.assertEquals(welmsg, mesg);
			Assert.assertEquals(driver.getTitle(), "Course | Dashboard | EC-Council Learning");
			Assert.assertEquals(lp.getText(lp.browser).trim(), "Browse".trim());
			System.out.println("broser");
			Assert.assertEquals(lp.getText(lp.enterprise).trim(), "Enterprise".trim());
			System.out.println("enterprise");
			Assert.assertEquals(lp.getText(lp.upGradePro).trim(), "Upgrade To Pro".trim());
			System.out.println("upGradePro");
			Assert.assertEquals(lp.getText(lp.gotoDashboard).trim(), "Go To ".trim());
			System.out.println("gotoDashboard");
			Assert.assertEquals(lp.getText(lp.courses).trim(), "Courses".trim());
			System.out.println("courses");
			Assert.assertEquals(lp.getText(lp.learningPath).trim(), "Learning Paths".trim());
			System.out.println("learningPath");
			Assert.assertEquals(lp.getText(lp.microDegrees).trim(), "Micro Degrees".trim());
			System.out.println("microDegrees");
			Assert.assertEquals(lp.getText(lp.Stats).trim(), "Stats".trim());
			System.out.println("Stats");
			Assert.assertEquals(lp.getText(lp.completedCourses).trim(), "Completed Courses".trim());
			System.out.println("completedCourses");
			Assert.assertEquals(lp.getText(lp.myNotes).trim(), "My Notes".trim());
			System.out.println("myNotes");
			Assert.assertEquals(lp.getText(lp.bundles).trim(), "Bundles".trim());
			System.out.println("bundles");
			Assert.assertEquals(lp.getText(lp.favoriteLessons).trim(), "Favorite Lessons".trim());
			System.out.println("favoriteLessons");
			lp.logout();
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
	}

}
