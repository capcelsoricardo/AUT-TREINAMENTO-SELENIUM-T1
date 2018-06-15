package mercury.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import google.pages.HomePage;
import google.pages.MTP;
import google.pages.ResultadosPage;
import mercury.config.SetUp;

public class CT001GMTPConsultarSite {

	public WebDriver driver;

	@Before
	public void createBrowser() {
		driver = SetUp.setUp(driver, "CHROME", "http://google.com.br");
	}

	@Test	
	public void consultarSite() {
		HomePage homePage = new HomePage(driver);
		//homePage.pesquisarTexto("\"Fábrica de Teste MTP\"");
		homePage.pesquisarTexto("Fábrica de ");
		
		ResultadosPage resultadosPage = new ResultadosPage(driver);
		resultadosPage.clickLinkMTPSikuli();
		
		MTP mtp = new MTP(driver);
		mtp.clickMenu("Setores", "Indústria e Varejo");
	}

	@After
	public void tearDown() {
		//driver.quit();
	}		
}
