package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationMenuPage {
	WebDriver driver;
	By PIM = By.id("menu_pim_viewPimModule");
	By nav = By.cssSelector("div[class='menu']");
	By addEmployee = By.id("menu_pim_addEmployee");

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

	public WebElement getAddemployee() {
		return driver.findElement(addEmployee);
	}
}