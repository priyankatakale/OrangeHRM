package test.org.oragnehrm;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.EmployeeListPage;
import pageObjects.LoginPage;
import pageObjects.NavigationMenuPage;
import resources.basehrm;

public class NavigationMenuTests extends basehrm {
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void verifynavigation() {
		LoginPage lp = new LoginPage(driver);
		NavigationMenuPage nav = new NavigationMenuPage(driver);
		lp.getusername();
		lp.getpassword();
		lp.getloginbtn();
		boolean b = nav.getNavigation().isDisplayed();
		Assert.assertEquals(true, b);

	}

	@AfterTest
	public void closebrowser() {
		driver.close();
	}
}