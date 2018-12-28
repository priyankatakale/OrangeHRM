package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RecruitmentPage {
	public WebDriver driver;

	By jobtitle_loc = By.id("candidateSearch_jobTitle");
	By vacancy_loc = By.id("candidateSearch_jobVacancy");
	By hiringMngr_loc = By.id("candidateSearch_hiringManager");
	By status_loc = By.id("candidateSearch_status");
	By candidatename_loc = By.id("candidateSearch_candidateName");
	By keywords_loc = By.id("candidateSearch_keywords");
	By fromdate_loc = By.id("candidateSearch_fromDate");
	By todate_loc = By.id("candidateSearch_toDate");
	By method_loc = By.id("candidateSearch_modeOfApplication");
	By searchbtn_loc = By.id("btnSrch");
	By resetbtn_loc = By.id("btnRst");
	By addbtn_loc = By.id("btnAdd");
	By deletebtn_loc = By.id("btnDelete");
	By invalidtex_loc = By.cssSelector("span[for='candidateSearch_candidateName']");
	By dynamicdate_loc = By.cssSelector("a[class='ui-state-default']");
	By dynamicmonth_loc = By.cssSelector("select[class='ui-datepicker-month");
	By dynamicyear_loc = By.cssSelector("select[class='ui-datepicker-year']");

	public RecruitmentPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getjobTitle() {
		return driver.findElement(jobtitle_loc);
	}

	public WebElement getVacancy() {
		return driver.findElement(vacancy_loc);
	}

	public WebElement getHiringMngr() {
		return driver.findElement(hiringMngr_loc);
	}

	public WebElement getStatus(String name) {
		return driver.findElement(status_loc);
	}

	public WebElement getCandidateName(String name) {
		WebElement canditae_name = driver.findElement(candidatename_loc);
		canditae_name.sendKeys(name);
		return canditae_name;

	}

	public WebElement getKeywords() {
		return driver.findElement(keywords_loc);
	}

	public WebElement getFromdate() {
		return driver.findElement(fromdate_loc);
	}

	public WebElement getTodate() {
		return driver.findElement(todate_loc);
	}

	public WebElement getMethodofapp() {
		return driver.findElement(method_loc);
	}

	public WebElement getSerachbtn() {
		return driver.findElement(searchbtn_loc);
	}

	public WebElement getResetbtn() {
		return driver.findElement(resetbtn_loc);
	}

	public WebElement getAddbtn() {
		return driver.findElement(addbtn_loc);
	}

	public WebElement getDeletebtn() {
		return driver.findElement(deletebtn_loc);
	}

	public String getInvalidtext() {
		return driver.findElement(invalidtex_loc).getText();
	}

	public WebElement getDate() {
		WebElement fromdate = driver.findElement(fromdate_loc);
		fromdate.click();
		return fromdate;
	}

	public void setdynamicDate(String year, String month, int date) {
		getDate();
		Select s1 = new Select(driver.findElement(dynamicyear_loc));
		s1.selectByVisibleText(year);
		Select s = new Select(driver.findElement(dynamicmonth_loc));
		s.selectByVisibleText(month);
		driver.findElements(dynamicdate_loc).get(date-1).click();		
	}
}