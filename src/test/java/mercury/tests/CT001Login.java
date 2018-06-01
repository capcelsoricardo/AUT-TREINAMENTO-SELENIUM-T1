package mercury.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import mercury.config.SetUp;
import mercury.pages.FlightFinderPage;
import mercury.pages.InicialPage;

public class CT001Login {

	public WebDriver driver;

	@Before
	public void createBrowser() {
		driver = SetUp.setUp(driver, "CHROME");
	}

	@Test
	public void login() {
		InicialPage inicialPage = new InicialPage(driver);
		
		inicialPage.login("mercury", "mercury");		
		FlightFinderPage flightFinderPage = new FlightFinderPage(driver);
		
		assertTrue("Não encontrou o elemento SIGN-OFF.",flightFinderPage.existSignOff());
	}

	@After
	public void tearDown() {
		driver.quit();
	}		
}
