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
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("open-categories-btn")));
		driver.findElement(By.id("open-categories-btn")).click(); //Selecionar a categoria
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("category-1")));
		//waitFixed(4000);
		driver.findElement(By.id("category-1")).click();//Selecionar categoria doces
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-product-4-btn")));
		driver.findElement(By.id("add-product-4-btn")).click(); //Adicionar o Brigadeiro no carrinho
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-product-5-btn")));
		driver.findElement(By.id("add-product-5-btn")).click(); //Adicionar o Alfajor no carrinho
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("open-categories-btn")));
		driver.findElement(By.id("open-categories-btn")).click(); //Selecionar a categoria
		
		driver.findElement(By.id("category-all")).click();//Selecionar categoria todos
		
		driver.findElement(By.id("cart-btn")).click(); //Acessar o carrinho
		for(int i=0; i<4; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id("add-product-4-qtd")));
		driver.findElement(By.id("add-product-4-qtd")).click();;
		}//Aumentar a quantidade de Brigadeiro para 4
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("finish-checkout-button")));
		driver.findElement(By.id("finish-checkout-button")).click();//finalizar a compra
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'sc-dNLxif')]")));
		String textActual=driver.findElement(By.xpath("//h2[contains(@class,'sc-dNLxif')]")).getText();
		String textExpected="Pedido realizado com sucesso!";
		Assert.assertEquals(textActual, textExpected);//Validar menssagem
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'sc-jqCOkK')]")));
		driver.findElement(By.xpath("//button[contains(@class,'sc-jqCOkK')]")).click();//fechar a menssagem
		
		driver.quit();//fechar internet	
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
