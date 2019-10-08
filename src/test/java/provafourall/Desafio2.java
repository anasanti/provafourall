package provafourall;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import provafourall.pages.PageHome;
import provafourall.pages.ShopCar;
import provafourall.selenium.DriverManager;

public class Desafio2 {
	private DriverManager driver;
	private PageHome home;
	private ShopCar shopCar;

	@Before
	public void setUp() {
		driver = new DriverManager(System.getProperty("browserName"));
		home = new PageHome(driver.getDriver());
		shopCar = new ShopCar(driver.getDriver());
	}
	
	@Test
	public void desafio2() {
		home.clickCategorySelect();
		
		home.clickCategoryDrink();
		
		home.clickProductCoca();
		home.messageAlertBox();
		home.messageCloseAlert();
		
		home.clickProductFanta();
		home.messageAlertBox();
		home.messageCloseAlert();
		
		home.clickProductWater();
		home.messageAlertBox();
		home.messageCloseAlert();
			
		home.clickCategorySelect();
		
		home.clickCategoriesAll();
		
		home.clickProductRisole();
		
		home.clickButtonCart();
		
		shopCar.increaseAmountRisoles(9);
		
		shopCar.decreaseAmountRisoles(5);

		shopCar.validateTotalAmount();
				
		shopCar.clickButtonCheckOut();
		
		shopCar.validadeMessageConfimation();
		
		shopCar.clickCloseMessage();
		
	}
	
	@After
	public void closePage() {
		driver.endSession();
	}
}
