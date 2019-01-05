package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddEmployee {
	WebDriver driver;
	By firstnameLocator = By.id("firstName");
	By middlenameLocator = By.id("middleName");
	By lastnameLocator = By.id("lastName");
	By empid_loc = By.id("employeeId");
	By photograph_loc = By.id("photofile");
	By savebtn_loc = By.id("btnSave");
	By checklogin_loc = By.id("chkLogin");
	By username_loc = By.id("user_name");
	By password_loc = By.id("user_password");
	By confirmpassword_loc = By.id("re_password");
	By status_loc = By.id("status");

	public AddEmployee(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstname(String firstname) {
		WebElement FirstName = driver.findElement(firstnameLocator);
		FirstName.sendKeys(firstname);
		return FirstName;
	}

	public WebElement getMiddlename(String middlename) {
		WebElement MiddleName = driver.findElement(middlenameLocator);
		MiddleName.sendKeys(middlename);
		return MiddleName;
	}

	public WebElement getLastname(String lastname) {
		WebElement LastName = driver.findElement(lastnameLocator);
		LastName.sendKeys(lastname);
		return LastName;
	}

	public WebElement getEpId(String id) {
		driver.findElement(empid_loc).clear();
		WebElement employeeId = driver.findElement(empid_loc);
		employeeId.sendKeys(id);
		return employeeId;

	}

	public void getPhotograph() {
		driver.findElement(photograph_loc).click();

	}

	public void getSavebtn() {
		driver.findElement(savebtn_loc).click();
	}

	public WebElement getUsername(String Username) {
		WebElement UserName = driver.findElement(username_loc);
		UserName.sendKeys(Username);
		return UserName;
	}

	public WebElement getPassword(String Password) {
		WebElement PassWord = driver.findElement(password_loc);
		PassWord.sendKeys(Password);
		return PassWord;
	}

	public WebElement getConfirmPassword(String Confirmpassword) {
		WebElement ConfirmPassWord = driver.findElement(confirmpassword_loc);
		ConfirmPassWord.sendKeys(Confirmpassword);
		return ConfirmPassWord;
	}

	public void getStatus() {
		Select s = new Select(driver.findElement(status_loc));
		s.selectByValue("Enabled");

	}

	public void getcheckLogin() {
		driver.findElement(checklogin_loc).click();

	}

}