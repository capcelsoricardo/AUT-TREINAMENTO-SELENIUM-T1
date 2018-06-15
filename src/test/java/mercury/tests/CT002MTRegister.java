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
import mercury.pages.InicialPage;
import mercury.pages.RegisterPage;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "src\\test\\resources\\dados\\CT002MTRegister.xls")
public class CT002MTRegister {

	public WebDriver driver;

	@Before
	public void createBrowser() {
		driver = SetUp.setUp(driver, "CHROME", "http://newtours.demoaut.com/");
	}

	@Test	
	public void realizarRegristro(@Param(name="firstName") String firstName, @Param(name="lastName") String lastName, 
			@Param(name="phone") String phone, @Param(name="email") String email, @Param(name="address") String address,
			@Param(name="address2") String address2, @Param(name="city") String city, @Param(name="stateProvince") String stateProvince,
			@Param(name="postalCode") String postalCode, @Param(name="country") String country, @Param(name="userName") String userName, 
			@Param(name= "password") String password, @Param(name="confirmPassword") String confirmPassword) {		
		
		InicialPage inicialPage = new InicialPage(driver);		
		inicialPage.clickRegister();
		
		RegisterPage registerPage = new RegisterPage(driver);
		assertTrue("Página Register não foi apresentada com sucesso.", registerPage.checkPageRegister());
							
		registerPage.preencherContactInformation(firstName, lastName, phone, email);
		registerPage.preencherMailingInformation(address, address2, city, stateProvince, postalCode, country);
		registerPage.preencherUserInformation(userName, password, confirmPassword);
		registerPage.clickSubmit();
		
		assertTrue("Mensagem de registro não foi apresentada com sucesso.", registerPage.checkMensagemSucesso(firstName, lastName, userName));
	}

	@After
	public void tearDown() {
		driver.quit();
	}		
}
