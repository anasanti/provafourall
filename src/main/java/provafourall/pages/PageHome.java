package provafourall.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageHome {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By categorieButton = By.id("open-categories-btn");
	private By candyCategory = By.id("category-1");
	private By addBrigadeiro = By.id("add-product-4-btn");
	private By addAlfajor = By.id("add-product-5-btn");
	private By allCategorie = By.id("category-all");
	private By drinkCategory = By.id("category-0");
	private By addCoca = By.id("add-product-0-btn");
	private By addFanta = By.id("add-product-1-btn");
	private By addWater = By.id("add-product-2-btn");
	private By addRisole = By.id("add-product-3-btn");
	private By closeButton = By.xpath("//button[contains(@class,'Toastify__close-button Toastify__close-button--succes')]");
	private By alertClose = By.xpath("//div[contains(@class,'Toastify__toast-body')]");
	private By cartButton = By.id("cart-btn");
	

	
	public PageHome(WebDriver drive) {
		this.driver = drive;
		wait = new WebDriverWait(driver, 50);
	}
	
	public void clickCategorySelect() {
		wait.until(ExpectedConditions.elementToBeClickable(categorieButton));
		driver.findElement(categorieButton).click();
	}
	
	public void clickCategoriesAll() {
		wait.until(ExpectedConditions.elementToBeClickable(allCategorie));
		driver.findElement(allCategorie).click();
	}
	
	public void clickCategoryDrink() {
		wait.until(ExpectedConditions.elementToBeClickable(drinkCategory));
		driver.findElement(drinkCategory).click();
	}
	
	public void clickCategoryCandy() {
		wait.until(ExpectedConditions.elementToBeClickable(candyCategory));
		driver.findElement(candyCategory).click();
	}
	
	public void clickProductCoca() {
		wait.until(ExpectedConditions.elementToBeClickable(addCoca));
		driver.findElement(addCoca).click();
	}
	
	public void clickProductFanta( ) {
		wait.until(ExpectedConditions.elementToBeClickable(addFanta));
		driver.findElement(addFanta).click();
	}
	
	public void clickProductWater() {
		wait.until(ExpectedConditions.elementToBeClickable(addWater));
		driver.findElement(addWater).click();
	}
	
	public void clickProductRisole() {
		wait.until(ExpectedConditions.elementToBeClickable(addRisole));
		driver.findElement(addRisole).click();
	}
	
	public void clickProductBrigadeiro() {
		wait.until(ExpectedConditions.elementToBeClickable(addBrigadeiro));
		driver.findElement(addBrigadeiro).click();
	}
	
	public void clickProductAlfajor() {
		wait.until(ExpectedConditions.elementToBeClickable(addAlfajor));
		driver.findElement(addAlfajor).click();
	}

	public void messageAlertBox() {
		wait.until(ExpectedConditions.elementToBeClickable(alertClose));
		driver.findElement(alertClose).click();
	}
	
	public void messageCloseAlert() {
		wait.until(ExpectedConditions.elementToBeClickable(closeButton));
		driver.findElement(closeButton);
	}
	
	public void clickButtonCart() {
		wait.until(ExpectedConditions.elementToBeClickable(cartButton));
		driver.findElement(cartButton).click();
	}
}
