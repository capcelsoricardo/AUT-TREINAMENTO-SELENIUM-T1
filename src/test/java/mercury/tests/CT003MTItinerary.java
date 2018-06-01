package mercury.tests;

import static org.junit.Assert.assertTrue;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import mercury.config.SetUp;
import mercury.pages.FlightFinderPage;
import mercury.pages.InicialPage;
import mercury.pages.SelectFlightPage;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "src\\test\\resources\\dados\\CT003MTItinerary.xls")
public class CT003MTItinerary {

	public WebDriver driver;

	@Before
	public void createBrowser() {
		driver = SetUp.setUp(driver, "CHROME");
	}

	@Test	
	public void realizarRegristro(@Param(name="user") String user, @Param(name="password") String password, 
			@Param(name="type") String type, @Param(name="passengers") String passengers, @Param(name="departmentFrom") String departmentFrom, 
			@Param(name="onMonth") String onMonth, @Param(name="onDay") String onDay, @Param(name="arrivingIn") String arrivingIn, 
			@Param(name="returningMonth") String returningMonth, @Param(name="returningDay") String returningDay, 
			@Param(name="airline") String airline) {
		
		InicialPage inicialPage = new InicialPage(driver);
		inicialPage.login(user, password);
		
		FlightFinderPage flightFinderPage = new FlightFinderPage(driver);			
		assertTrue("Página 'Flight Finder' não foi apresentada com sucesso.",flightFinderPage.existSignOff());
		
		flightFinderPage.preencherFlightDetails(type, passengers, departmentFrom, onMonth, onDay, arrivingIn, returningMonth, returningDay);
		
		flightFinderPage.preencherPreferences(airline);		
		flightFinderPage.clickButtonContinue();
		
		SelectFlightPage selectFlight = new SelectFlightPage(driver);
		assertTrue("Página 'Select Flight' não foi apresentada com sucesso.", selectFlight.checkSelectFlightPage());
		
		selectFlight.selectDepart();
		selectFlight.selectReturn();
		selectFlight.clickButtonContinue();											
	}

	@After
	public void tearDown() {
		driver.quit();
	}		
}
