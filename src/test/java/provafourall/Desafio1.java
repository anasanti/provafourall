package provafourall;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import provafourall.pages.PageHome;
import provafourall.pages.ShopCar;
import provafourall.selenium.DriverManager;




public class Desafio1 {

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
	public void desafio1() {
		
		home.clickCategorySelect();
		
		home.clickCategoryCandy();
		
		home.clickProductBrigadeiro();
		
		home.clickProductAlfajor();
		
		home.clickCategorySelect();
		
		home.clickCategoriesAll();
		
		home.clickButtonCart();
		
		shopCar.increaseAmountBrigadeiros(4);

		shopCar.clickButtonCheckOut();
		
		shopCar.validadeMessageConfimation();
		
		shopCar.clickCloseMessage();
		
	}
	
	@After
	public void closePage() {
		driver.endSession();
	}
}
