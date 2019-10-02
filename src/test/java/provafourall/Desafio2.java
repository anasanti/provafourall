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
	
	@Test
	public void desafio2() {
		System.setProperty("webdriver.chrome.driver", "C:\\Ferramentas\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.get("https://shopcart-challenge.4all.com/"); //Acessar o site
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("open-categories-btn")));
		driver.findElement(By.id("open-categories-btn")).click(); //Selecionar a categoria
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("category-0")));
		driver.findElement(By.id("category-0")).click(); //selecionar a categoria bebida
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-product-0-btn")));
		driver.findElement(By.id("add-product-0-btn")).click(); //adicionar coca
		
		waitFixed(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-product-1-btn")));
		driver.findElement(By.id("add-product-1-btn")).click(); //adicionar fanta
		
		waitFixed(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-product-2-btn")));
		driver.findElement(By.id("add-product-2-btn")).click(); //adicionar agua
		
		//waitFixed(5000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,Toastify__toast-body)]")));
//		driver.findElement(By.xpath("//div[contains(@class,Toastify__toast-bod)]"));
			
		waitFixed(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("open-categories-btn")));
		driver.findElement(By.id("open-categories-btn")).click(); //Selecionar a categoria
		
		driver.findElement(By.id("category-all")).click();//Selecionar categoria todos
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@id,add-product-3-btn)]")));
//		driver.findElement(By.xpath("//button[contains(@id,add-product-3-btn)]")).click(); //adicionar risole 
		
		waitFixed(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-product-3-btn")));
		driver.findElement(By.id("add-product-3-btn")).click(); //adicionar risole
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cart-btn")));
		driver.findElement(By.id("cart-btn")).click(); //Acessar o carrinho
		for(int i=0; i<9; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id("add-product-3-qtd")));
			driver.findElement(By.id("add-product-3-qtd")).click();
		} //adicionar mais 9 produtos
		
		
		for(int i=0; i<5; i++) {
	  		wait.until(ExpectedConditions.elementToBeClickable(By.id("remove-product-3-qtd")));
			driver.findElement(By.id("remove-product-3-qtd")).click();
		} //remover 5 produtos
		
		/*waitFixed(5000);
		String textActual = "R$36,00";
		String textExpected = driver.findElement(By.xpath("//button[contains(@id,price-total-checkout")).getText();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("price-total-checkout")));
		//log.info("Mensagem informando o valor que está retornando"+driver.findElement(By.xpath("//button[contains(@id,price-total-checkout")).getText());
		Assert.assertEquals(textExpected, textActual); //validar valor total*/
		
		waitFixed(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("price-total-checkout")));
//		if(driver == null) {
//			log.severe("Driver é nulo");
//		}
//		WebElement totalPrice = driver.findElement(By.id("price-total-checkout"));
//		if(totalPrice == null) {
//			log.severe("Preço total é nulo");
//		}
//		log.severe("Mensagem informando o valor que está retornando"+totalPrice.getText());
		Assert.assertEquals("R$ 36,00", driver.findElement(By.id("price-total-checkout")).getText()); //validar valor total
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("finish-checkout-button")));
		driver.findElement(By.id("finish-checkout-button")).click(); //finalizar compra
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'sc-dNLxif')]")));
		Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(@class,'sc-dNLxif')]")).getText(), "Pedido realizado com sucesso!"); //validar mensagem
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'sc-jqCOkK')]")));
		driver.findElement(By.xpath("//button[contains(@class,'sc-jqCOkK')]")).click(); //fechar a menssagem
		
		
		
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
