package test.org.oragnehrm;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.EmployeeListPage;
import pageObjects.LoginPage;
import pageObjects.NavigationMenuPage;
import resources.basehrm;

public class EmployeeListTests extends basehrm {
	public WebDriver driver;

	NavigationMenuPage navigation;
	LoginPage lp;
	EmployeeListPage el;

	@BeforeTest
	public void initialize() throws IOException, InterruptedException {
		// initialize driver
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		// create objects of POM
		lp = new LoginPage(driver);
		el = new EmployeeListPage(driver);
		navigation = new NavigationMenuPage(driver);

		// navigate to PIM menu
		lp.Login(UserName, PassWord);
		navigation.PIMclick();
	}

	@Test(enabled = false)
	public void verifyStatuscheckbox() throws IOException, InterruptedException {
		WebElement statusDropDown = el.getStatus();
		Select s = new Select(statusDropDown);
		s.selectByIndex(2);
		Thread.sleep(2000);
		String text = s.getFirstSelectedOption().getText();
		Assert.assertEquals(text, "Full-Time Contract");
		Thread.sleep(2000);
	}

	@Test(enabled = false)
	public void verifyIncludeField() throws InterruptedException {
		WebElement includeDropdown = el.getInclude();
		Select s = new Select(includeDropdown);
		s.selectByValue("1");
		String text = s.getFirstSelectedOption().getText();
		Assert.assertEquals(text, "Current Employees Only");
		Thread.sleep(2000);

	}

	@Test(enabled = false)
	public void verifyJobTitle() throws InterruptedException {
		WebElement jobtitleDropdown = el.getjobTitle();
		Select s = new Select(jobtitleDropdown);
		s.selectByVisibleText("CEO");
		String text = s.getFirstSelectedOption().getText();
		Assert.assertEquals(text, "CEO");

		Thread.sleep(2000);

	}

	@Test(enabled = false)
	public void verifySubUnit() throws InterruptedException {
		WebElement subunitDropdown = el.getsubUnit();
		Select s = new Select(subunitDropdown);
		s.selectByIndex(3);
		String text = s.getFirstSelectedOption().getText();
		Assert.assertEquals(text, "IT");
		Thread.sleep(4000);
	}

	@Test(enabled = false)
	public void verifySerachbtn() throws InterruptedException {
		String searchRec = el.searchEmployee("0004");
		Thread.sleep(6000);
		Assert.assertEquals("0004", searchRec);		
		el.getReset().click();
	}

	
	@Test(enabled = false)
	public void verifyAddbtn() throws InterruptedException {
		el.getEmployeename("Priyanka");
		el.getEmployeeid("05");
		el.getStatus();
		el.getInclude();
		el.getSupervisorname("Linda Anderson");
		el.getjobTitle();
		el.getsubUnit();
		el.getAdd().click();
		String actual = driver.getCurrentUrl();
		String expected = "https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee";
		Assert.assertEquals(expected, actual);
	}

	@Test(enabled = false)
	public void verifyDeletebtn() {
		el.getEmployeeid("0003");
		el.getCheckbox(3);
		el.getDelete().click();
		el.getConfirmationMsg();
		Assert.assertTrue(el.getConfirmationMsg());
		el.getalertOKbtn();

	}

	@Test (enabled = true)
	public void verifyDeleteFunctionality() {
		el.getEmployeeid("0002");
		el.getSearchbtn();
		el.getCheckbox(2);
		el.getDelete().click();
		el.getalertOKbtn();
		el.getEmployeeid("0002");
		el.getSearchbtn();
		Assert.assertEquals(el.getTableRecord(), "No Records Found");
	}

	@AfterTest
	public void closebrowser() {
		driver.close();
	}
}