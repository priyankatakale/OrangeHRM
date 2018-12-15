package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	By usernameLocator = By.id("txtUsername");
	By passwordLocator = By.id("txtPassword");
	By loginbtnLocator = By.cssSelector("input[type='submit']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getusername() {
		return driver.findElement(usernameLocator);
	}

	public WebElement getpassword() {
		return driver.findElement(passwordLocator);
	}

	public WebElement getloginbtn() {
		return driver.findElement(loginbtnLocator);
	}

	public void Login(String username, String password) {
		driver.findElement(usernameLocator).sendKeys(username);
		driver.findElement(passwordLocator).sendKeys(password);
		driver.findElement(loginbtnLocator).click();
	}
}