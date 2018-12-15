package test.org.oragnehrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LoginPage;
import resources.basehrm;

public class LoginPageTests extends basehrm {
	LoginPage l;

	@BeforeTest
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		l = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
	}

	@AfterTest
	public void closebrowser() {
		driver.close();
	}
	

	/*
	 * @Test(dataProvider = "getvalidtCredentials") public void basePage(String
	 * username, String password) {
	 * 
	 * l.getusername().sendKeys(username); l.getpassword().sendKeys(password);
	 * l.getlogin().click(); }
	 * 
	 * @DataProvider public Object[][] getvalidtCredentials() {
	 * 
	 * Object[][] a = new Object[1][2]; a[0][0] = "Admin"; a[0][1] = "admin123";
	 * return a; }
	 */

	/*
	 * @Test(dataProvider = "GetinvalidCredentials") public void invalidData(String
	 * username, String password) { driver.get(prop.getProperty("url"));
	 * l.getusername().sendKeys(username); l.getpassword().sendKeys(password);
	 * l.getloginbtn().click();
	 * 
	 * String actual =
	 * driver.findElement(By.cssSelector("span[id='spanMessage']")).getText();
	 * String expected = "Invalid credentials";
	 * 
	 * Assert.assertEquals(expected, actual);
	 * 
	 * }
	 * 
	 * @DataProvider public Object[][] GetinvalidCredentials() {
	 * 
	 * Object[][] b = new Object[1][2]; b[0][0] = "sddd"; b[0][1] = "kdjad"; return
	 * b;
	 * 
	 * }
	 */

	@Test
	public void verifylogin() {
		l.Login(UserName, PassWord);
	}
}