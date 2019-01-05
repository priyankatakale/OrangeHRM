package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjects.LoginPage;
import resources.basehrm;

import java.io.IOException;

import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class LoginPageSteps extends basehrm {

	LoginPage l;

	public LoginPageSteps() throws IOException, InterruptedException {
		if (driver == null) {
			driver = initializeDriver();
		}
	}

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		l = new LoginPage(driver);
	}

	@Given("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(prop.getProperty(strArg1));
	}

	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
		String expected = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertEquals(expected, driver.getCurrentUrl());
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and clicks on login button$")
	public void user_enters_username_and_password_and_clicks_on_login_button(String userName, String password)
			throws Throwable {
		String uName = prop.getProperty(userName);
		String pWord = prop.getProperty(password);
		l = new LoginPage(driver);
		l.Login(uName, pWord);
	}

}