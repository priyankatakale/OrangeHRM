package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basehrm {
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	public String UserName, PassWord;

	public WebDriver initializeDriver() throws IOException, InterruptedException {
		prop = new Properties();
		System.out.println(System.getProperty("user.dir"));
		FileInputStream fis = new FileInputStream("./src/main/java/resources/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		UserName = prop.getProperty("username");
		PassWord = prop.getProperty("password");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Selenium\\webdriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {

		} else if (browserName.equals("IE")) {

		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

}