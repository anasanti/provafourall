package provafourall;



import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Desafio1 {
	private WebDriver driver;
	
	private By categorieButton = By.id("open-categories-btn");
	private By candyCategorie = By.id("category-1");
	private By addBrigadeiro = By.id("add-product-4-btn");
	private By addAlfajor = By.id("add-product-5-btn");
	private By allCategorie = By.id("category-all");
	private By cartButton = By.id("cart-btn");
	private By applyBrigadeiro = By.id("add-product-4-qtd");
	private By checkOutButton = By.id("finish-checkout-button");
	private By checkMessage = By.xpath("//h2[contains(@class,'sc-dNLxif')]");
	private By closekMessage = By.xpath("//button[contains(@class,'sc-jqCOkK')]");
	
	/*@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://shopcart-challenge.4all.com/");
		driver.manage().window().maximize();
		
	}*/
	
	@Test
	public void desafio1() {
		System.setProperty("webdriver.chrome.driver", "C:\\Ferramentas\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.get("https://shopcart-challenge.4all.com/"); //Acessar o site
		
		
		wait.until(ExpectedConditions.elementToBeClickable(categorieButton));
		driver.findElement(categorieButton).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(candyCategorie));
		driver.findElement(candyCategorie).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(addBrigadeiro));
		driver.findElement(addBrigadeiro).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(addAlfajor));
		driver.findElement(addAlfajor).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(categorieButton));
		driver.findElement(categorieButton).click();
		
		driver.findElement(allCategorie).click();
		
		driver.findElement(cartButton).click();
		for(int i=0; i<4; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(applyBrigadeiro));
		driver.findElement(applyBrigadeiro).click();;
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
		driver.findElement(checkOutButton).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkMessage));
		String textActual=driver.findElement(checkMessage).getText();
		String textExpected="Pedido realizado com sucesso!";
		Assert.assertEquals(textActual, textExpected);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(closekMessage));
		driver.findElement(closekMessage).click();
		
	}
	
	private void waitFixed(long i) {
		try {
			Thread.sleep(i);
		}catch(InterruptedException ex) {
			throw new RuntimeException("Problema no processamento do thread sleep");
		}
		
	}

	
	@After
	public void closePage() {
		driver.quit();
	}
}
