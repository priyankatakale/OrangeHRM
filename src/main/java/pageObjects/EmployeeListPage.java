package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeListPage {
	public WebDriver driver;
	String checkboxid = "#ohrmList_chkSelectRecord_";
	By status = By.id("empsearch_employee_status");
	By includeField = By.id("empsearch_termination");
	By jobTitle = By.id("empsearch_job_title");
	By subunit = By.id("empsearch_sub_unit");
	By employeename = By.id("empsearch_employee_name_empName");
	By supervisorname = By.id("empsearch_supervisor_name");
	By employeeid = By.id("empsearch_id");
	By searchbtn = By.id("searchBtn");
	By reset = By.id("resetBtn");
	By add = By.id("btnAdd");
	By checkbox;
	By delete = By.id("btnDelete");
	By confirmation = By.cssSelector("#deleteConfModal p");
	By alertOK = By.id("dialogDeleteBtn");
	By tablerecord = By.cssSelector("#resultTable tr td");

	public EmployeeListPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getStatus() {
		return driver.findElement(status);
	}

	public WebElement getInclude() {
		return driver.findElement(includeField);
	}

	public WebElement getjobTitle() {
		return driver.findElement(jobTitle);
	}

	public WebElement getsubUnit() {
		return driver.findElement(subunit);
	}

	public WebElement getSupervisorname(String supName) {
		WebElement spname = driver.findElement(supervisorname);
		spname.sendKeys("supName");
		return spname;
	}

	public WebElement getEmployeename(String empName) {
		WebElement name = driver.findElement(employeename);
		name.sendKeys(empName);
		return name;

	}

	public WebElement getEmployeeid(String id) {

		WebElement empIdTextbox = driver.findElement(employeeid);
		empIdTextbox.sendKeys(id);
		return empIdTextbox;

	}

	public WebElement getSearchbtn() {
		WebElement search = driver.findElement(searchbtn);
		search.click();
		return search;
	}

	public WebElement getRecord() {
		return driver.findElements(tablerecord).get(1);
	}

	public WebElement getReset() {
		return driver.findElement(reset);

	}

	public WebElement getAdd() {
		return driver.findElement(add);

	}

	public void getCheckbox(int id) {
		String cssCheckboxSelector = checkboxid + id;
		checkbox = By.cssSelector(cssCheckboxSelector);
		driver.findElement(checkbox).click();
	}

	public WebElement getDelete() {
		return driver.findElement(delete);
	}

	public boolean getConfirmationMsg() {
		return driver.findElement(confirmation).isDisplayed();

	}

	public void getalertOKbtn() {
		driver.findElement(alertOK).click();
	}

	public String getTableRecord() {
		String actual = driver.findElement(tablerecord).getText();
		return actual;
	}

	public String searchEmployee(String empId) throws InterruptedException {
		// el.getEmployeename();
		getEmployeeid(empId);
		getSearchbtn();
		WebElement elememt = getRecord();
		String s = elememt.getText();
		Thread.sleep(2000);
		return s;
	}

}