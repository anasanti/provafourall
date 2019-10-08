package provafourall.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	private WebDriver driver;
	
	
	public DriverManager() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Ferramentas\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://shopcart-challenge.4all.com/");
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void endSession() {
		driver.quit();
	}
}
