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
import mercury.pages.BookAFlightPage;
import mercury.pages.FlightConfirmationPage;
import mercury.pages.FlightFinderPage;
import mercury.pages.InicialPage;
import mercury.pages.SelectFlightPage;
import mercury.utils.Helper;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "src\\test\\resources\\dados\\CT003MTItinerary.xls")
public class CT003MTItinerary {

	public WebDriver driver;

	@Before
	public void createBrowser() {
		driver = SetUp.setUp(driver, "CHROME", "http://newtours.demoaut.com/");
	}

	@Test	
	public void realizarRegristro(@Param(name="user") String user, @Param(name="password") String password, 
			@Param(name="type") String type, @Param(name="passengers") String passengers, @Param(name="departmentFrom") String departmentFrom, 
			@Param(name="onMonth") String onMonth, @Param(name="onDay") String onDay, @Param(name="arrivingIn") String arrivingIn, 
			@Param(name="returningMonth") String returningMonth, @Param(name="returningDay") String returningDay, 
			@Param(name="airline") String airline) {
		
		Helper helper = new Helper(driver);
		
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
		
		BookAFlightPage bookAFlightPage = new BookAFlightPage(driver);				
		
		assertTrue("Texto com infomações do 'Depart' não foi apresentado corretamente. Texto esperado: 'Pangea Airlines 362'. Texto apresentado: " + bookAFlightPage.getTextDepart(), bookAFlightPage.getTextDepart().contains("Pangea Airlines 362"));
		assertTrue("Texto com infomações de 'Origen' e 'Destino' não foi apresentado corretamente.", bookAFlightPage.getTextRetornoViagem().contains(arrivingIn + " to " + departmentFrom));			
		assertTrue("Texto com informações de 'Return' não foi apresentado corretamente. Texto esperado: 'Pangea Airlines 632'. Texto apresentado: " + bookAFlightPage.getTextReturn(), bookAFlightPage.getTextReturn().contains("Pangea Airlines 632"));
	
		bookAFlightPage.preencherPassengers();
		bookAFlightPage.preencherCreditCard();
		bookAFlightPage.preencherBillingAddress();
		bookAFlightPage.preencherDeliveryAddress();
		bookAFlightPage.clickButtonSecurePurchase();
		
		FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
		
		assertTrue("Mensagem 'Your itinerary has been booked!' não foi apresentada.",flightConfirmationPage.getTextMensagemItenerary().trim().contains("Your itinerary has been booked!".trim()));				
		
		assertTrue("Informações de 'Departing'  de 'Origem' e 'Destino' não foram apresentadas com sucesso.", flightConfirmationPage.getMensagemDeparting().contains(departmentFrom + " to " + arrivingIn));		
		String dataDeparting = onDay + "/" + helper.conversorMes(onMonth) + "/2018";				
		assertTrue("Informações de 'Departing'  de 'Data' não foram apresentadas com sucesso.", flightConfirmationPage.getMensagemDeparting().contains(dataDeparting));		
		
		String dataReturning = returningDay + "/" + helper.conversorMes(returningMonth) + "/2018";				
		assertTrue("Informações de 'Returning'  de 'Data' não foram apresentadas com sucesso.", flightConfirmationPage.getMensagemReturning().contains(dataReturning));														
		
		
	}

	@After
	public void tearDown() {
		driver.quit();
	}		
}
