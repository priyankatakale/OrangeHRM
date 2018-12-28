package test.org.oragnehrm;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import entities.EmployeeDetails;
import junit.framework.Assert;
import pageObjects.AddEmployee;
import pageObjects.EmployeeListPage;
import pageObjects.LoginPage;
import pageObjects.NavigationMenuPage;
import resources.basehrm;

public class AddEmployeeTests extends basehrm {
	public WebDriver driver;
	NavigationMenuPage nav;
	AddEmployee addemp;

	@BeforeTest

	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.Login(UserName, PassWord);
		nav = new NavigationMenuPage(driver);
		nav.PIMclick();
		nav.getAddemployee().click();

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false)
	public void verifyAddEmployee() throws InterruptedException {
		addemp = new AddEmployee(driver);
		addemp.getFirstname("ishani");
		addemp.getMiddlename("pritam");
		addemp.getLastname("Takale");
		addemp.getEpId("07");
		addemp.getSavebtn();
		nav.PIMclick();
		EmployeeListPage ep = new EmployeeListPage(driver);
		Assert.assertEquals("07", ep.searchEmployee("07"));
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false)
	public void verifyCreditLoginpage() throws InterruptedException {
		addemp = new AddEmployee(driver);
		addemp.getFirstname("ishani");
		addemp.getLastname("takale");
		addemp.getEpId("07");
		addemp.getcheckLogin();
		addemp.getUsername("ishani.takale");
		addemp.getPassword("ishani07");
		addemp.getConfirmPassword("ishani07");
		addemp.getStatus();
		addemp.getSavebtn();
		Thread.sleep(3000);
		nav.PIMclick();

		EmployeeListPage ep = new EmployeeListPage(driver);
		Assert.assertEquals("07", ep.searchEmployee("07"));

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false)
	public void verifySearchByEmpId() throws IOException, InterruptedException {
		nav.PIMclick();
		/*
		 * readWriteExcel r = new readWriteExcel(); ArrayList<EmployeeDetails> emplist =
		 * r.getexcelData(); EmployeeListPage el = new EmployeeListPage(driver); for
		 * (EmployeeDetails employeeDetails : emplist) { if(!
		 * employeeDetails.employeeId.equals(el.searchEmployee(employeeDetails.
		 * employeeId))) {
		 * 
		 * } }
		 */
		EmployeeListPage el = new EmployeeListPage(driver);

		String empId = readWriteExcel.getcellData(1, 1);
		Assert.assertEquals(empId, el.searchEmployee(empId));
	}

	@Test
	public void verifySetData() throws IOException, InterruptedException {
		nav.PIMclick();
		readWriteExcel.setcellData("30", 4, 1);
		EmployeeListPage el = new EmployeeListPage(driver);
		Assert.assertEquals("30", el.searchEmployee("30"));
	}

}