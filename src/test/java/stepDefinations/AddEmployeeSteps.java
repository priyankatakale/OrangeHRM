package stepDefinations;

import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;
import pageObjects.AddEmployee;
import pageObjects.EmployeeListPage;
import pageObjects.LoginPage;
import pageObjects.NavigationMenuPage;
import resources.basehrm;

@RunWith(Cucumber.class)
public class AddEmployeeSteps extends basehrm {
	LoginPage l;
	NavigationMenuPage nav;
	AddEmployee emp;

	@When("^User enters following details$")
	public void user_enters_following_details_and_clicks_on_save_button(DataTable dt) throws Throwable {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		String firstName = list.get(1).get("FirstName");
		String middleName = list.get(1).get("MiddleName");
		String lastName = list.get(1).get("LastName");
		String empId = list.get(1).get("Id");

		emp = new AddEmployee(driver);
		emp.getFirstname(firstName);
		emp.getMiddlename(middleName);
		emp.getLastname(lastName);
		emp.getEpId(empId);
	}

	@And("^user clicks on save button$")
	public void user_clicks_on_save_button() throws Throwable {
		emp.getSavebtn();
	}

	@And("^Navigate to add employee page$")
	public void navigate_to_add_employee_page() throws Throwable {
		nav = new NavigationMenuPage(driver);
		nav.PIMclick();
		nav.addEmployee();
	}

	@Then("^Verify that employee with id \"([^\"]*)\" saved successfully$")
	public void verify_that_employee_with_id_something_saved_successfully(String empId) throws Throwable {
		nav.PIMclick();
		EmployeeListPage ep = new EmployeeListPage(driver);
		Assert.assertEquals(empId, ep.searchEmployee(empId));
	}

	@When("^User enters following details for creditlogin page$")
	public void user_enters_following_details(DataTable dt) throws Throwable {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		String userName = list.get(0).get("UserName");
		String password = list.get(0).get("Password");
		String confirmpassword = list.get(0).get("ConfirmPassword");
		emp = new AddEmployee(driver);
		emp.getUsername(userName);
		emp.getPassword(password);
		emp.getConfirmPassword(confirmpassword);
		emp.getStatus();
	}
}