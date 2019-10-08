package provafourall.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopCar {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By applyBrigadeiro = By.id("add-product-4-qtd");
	private By checkOutButton = By.id("finish-checkout-button");
	private By checkMessage = By.xpath("//h2[contains(@class,'sc-dNLxif')]");
	private By closekMessage = By.xpath("//button[contains(@class,'sc-jqCOkK')]");
	private By moreRisole = By.id("add-product-3-qtd");
	private By lessRisole = By.id("remove-product-3-qtd");
	private By validateAmount = By.id("price-total-checkout");
	
	public ShopCar(WebDriver drive) {
		this.driver = drive;
		wait = new WebDriverWait(driver, 50);
	}
	
	public void increaseAmountBrigadeiro() {
		wait.until(ExpectedConditions.elementToBeClickable(applyBrigadeiro));
		driver.findElement(applyBrigadeiro).click();
	}
		
	public void increaseAmountBrigadeiros(int increaseAmountBrigadeiro) {
		for(int i=0; i<increaseAmountBrigadeiro; i++) {
			increaseAmountBrigadeiro();
		}
	}
	
	public void increaseAmountRisole() {
		wait.until(ExpectedConditions.elementToBeClickable(moreRisole));
		driver.findElement(moreRisole).click();
	}
	
	public void increaseAmountRisoles(int increaseAmountRisole) {
		for(int i=0; i<increaseAmountRisole; i++) {
			increaseAmountRisole();
		}
	}
	
	public void decreaseAmountRisole() {
		wait.until(ExpectedConditions.elementToBeClickable(lessRisole));
		driver.findElement(lessRisole).click();
	}
	
	public void decreaseAmountRisoles(int decreaseAmountRisole) {
		for(int i=0; i<decreaseAmountRisole; i++) {
			decreaseAmountRisole();
		}
	}
	
	public void validateTotalAmount() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(validateAmount));
		Assert.assertEquals("R$ 36,00", driver.findElement(validateAmount).getText());
	}
	
	public void clickButtonCheckOut() {
		wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
		driver.findElement(checkOutButton).click();
	}

	public void validadeMessageConfimation() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkMessage));
		Assert.assertEquals(driver.findElement(checkMessage).getText(), "Pedido realizado com sucesso!");
	}
	
	public void clickCloseMessage() {
		wait.until(ExpectedConditions.elementToBeClickable(closekMessage));
		driver.findElement(closekMessage).click();
	}
	
}
