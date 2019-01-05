package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationMenuPage {
	WebDriver driver;
	By PIM = By.id("menu_pim_viewPimModule");
	By nav = By.cssSelector("div[class='menu']");
	By addEmployee = By.id("menu_pim_addEmployee");
	By recruitement_loc = By.id("menu_recruitment_viewRecruitmentModule");
	By candidates_loc = By.id("menu_recruitment_viewCandidates");
	By vaccancies_loc = By.id("menu_recruitment_viewJobVacancy");

	public NavigationMenuPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPIM() {
		return driver.findElement(PIM);
	}

	public void PIMclick() {
		getPIM().click();
	}

	public WebElement getNavigation() {
		return driver.findElement(nav);
	}

	public void getRecruitment() {
		driver.findElement(recruitement_loc).click();
	}

	public WebElement getAddemployee() {
		return driver.findElement(addEmployee);
	}

	public void getCandidates() {
		driver.findElement(candidates_loc).click();
	}

	public void getVaccancies() {
		driver.findElement(vaccancies_loc).click();
	}

	public void addEmployee() {
		driver.findElement(addEmployee).click();
	}
}