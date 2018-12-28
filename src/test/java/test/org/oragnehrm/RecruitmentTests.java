package test.org.oragnehrm;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LoginPage;
import pageObjects.NavigationMenuPage;
import pageObjects.RecruitmentPage;
import resources.basehrm;

public class RecruitmentTests extends basehrm {
	public WebDriver driver;
	RecruitmentPage rp;

	@BeforeTest
	public void Initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.Login(UserName, PassWord);
		NavigationMenuPage np = new NavigationMenuPage(driver);
		np.getRecruitment();
		np.getCandidates();
		rp = new RecruitmentPage(driver);
	}

	@Test(enabled = false)
	public void verifyJobTitle() {

		Select s = new Select(rp.getjobTitle());
		s.selectByVisibleText("CEO");
		String actual = s.getFirstSelectedOption().getText();
		Assert.assertEquals("CEO", actual);
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false)
	public void verifyCandidatename() {
		rp.getCandidateName("123");
		Assert.assertTrue("verify candidate name failed.", rp.getInvalidtext().equalsIgnoreCase("Invalid"));

	}

	@Test
	public void verifyDate() throws InterruptedException {
		rp.setdynamicDate("2018", "Dec", 24);
		Thread.sleep(8000);

	}

}