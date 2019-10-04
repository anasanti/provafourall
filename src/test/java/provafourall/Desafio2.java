package provafourall;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Desafio2 {
	private WebDriver driver;
	private Logger log;
	
	private By categoryButton = By.id("open-categories-btn");
	private By drinkCategory = By.id("category-0");
	private By addCoca = By.id("add-product-0-btn");
	private By addFanta = By.id("add-product-1-btn");
	private By addWater = By.id("add-product-2-btn");
	private By addRisole = By.id("add-product-3-btn");
	private By cartButton = By.id("cart-btn");
	private By moreRisole = By.id("add-product-3-qtd");
	private By lessRisole = By.id("remove-product-3-qtd");
	private By validateAmount = By.id("price-total-checkout");
	private By checkOutButton = By.id("finish-checkout-button");
	private By checkMessage = By.xpath("//h2[contains(@class,'sc-dNLxif')]");
	private By closekMessage = By.xpath("//button[contains(@class,'sc-jqCOkK')]");
	
	@Test
	public void desafio2() {
		System.setProperty("webdriver.chrome.driver", "C:\\Ferramentas\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.get("https://shopcart-challenge.4all.com/"); //Acessar o site
		
		wait.until(ExpectedConditions.elementToBeClickable(categoryButton));
		driver.findElement(categoryButton).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(drinkCategory));
		driver.findElement(drinkCategory).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(addCoca));
		driver.findElement(addCoca).click();
		
		waitFixed(5000);
		wait.until(ExpectedConditions.elementToBeClickable(addFanta));
		driver.findElement(addFanta).click();
		
		waitFixed(5000);
		wait.until(ExpectedConditions.elementToBeClickable(addWater));
		driver.findElement(addWater).click();
		
		//waitFixed(5000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,Toastify__toast-body)]")));
//		driver.findElement(By.xpath("//div[contains(@class,Toastify__toast-bod)]"));
			
		waitFixed(5000);
		wait.until(ExpectedConditions.elementToBeClickable(categoryButton));
		driver.findElement(categoryButton).click();
		
		driver.findElement(By.id("category-all")).click();//Selecionar categoria todos
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@id,add-product-3-btn)]")));
//		driver.findElement(By.xpath("//button[contains(@id,add-product-3-btn)]")).click(); //adicionar risole 
		
		waitFixed(5000);
		wait.until(ExpectedConditions.elementToBeClickable(addRisole));
		driver.findElement(addRisole).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(cartButton));
		driver.findElement(cartButton).click();
		for(int i=0; i<9; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(moreRisole));
			driver.findElement(moreRisole).click();
		}
		
		
		for(int i=0; i<5; i++) {
	  		wait.until(ExpectedConditions.elementToBeClickable(lessRisole));
			driver.findElement(lessRisole).click();
		}
		
		/*waitFixed(5000);
		String textActual = "R$36,00";
		String textExpected = driver.findElement(By.xpath("//button[contains(@id,price-total-checkout")).getText();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("price-total-checkout")));
		//log.info("Mensagem informando o valor que está retornando"+driver.findElement(By.xpath("//button[contains(@id,price-total-checkout")).getText());
		Assert.assertEquals(textExpected, textActual); //validar valor total*/
		
		waitFixed(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(validateAmount));
//		if(driver == null) {
//			log.severe("Driver é nulo");
//		}
//		WebElement totalPrice = driver.findElement(By.id("price-total-checkout"));
//		if(totalPrice == null) {
//			log.severe("Preço total é nulo");
//		}
//		log.severe("Mensagem informando o valor que está retornando"+totalPrice.getText());
		Assert.assertEquals("R$ 36,00", driver.findElement(validateAmount).getText());
		
		
		wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
		driver.findElement(checkOutButton).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkMessage));
		Assert.assertEquals(driver.findElement(checkMessage).getText(), "Pedido realizado com sucesso!");
		
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
