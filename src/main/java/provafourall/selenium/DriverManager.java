package provafourall.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	private WebDriver driver;
	
	
	public DriverManager(String browserName) {
		
		chooseBrowser(browserName);
		driver.manage().window().maximize();
		driver.get("https://shopcart-challenge.4all.com/");
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void chooseBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Ferramentas\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.driver","C:\\Ferramentas\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();			
		}
		else{
			System.setProperty("webdriver.Edge.driver","C:\\Ferramentas\\driver\\IEDriverServer.exe");
			driver = new EdgeDriver();			
		}
		
	}
	
	public void endSession() {
		driver.quit();
	}
}
