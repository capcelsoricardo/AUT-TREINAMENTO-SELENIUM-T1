package mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import mercury.config.SetUp;
import mercury.utils.Helper;

public class RegisterPage extends SetUp {

	Helper helper = new Helper(driver);

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public boolean checkPageRegister() {
		return helper.checkElement("//input[@name='register']");
	}

	public void preencherContactInformation(String firstName, String lastName, String phone, String email) {

		driver.findElement(By.name("firstName")).sendKeys(firstName);
		driver.findElement(By.name("lastName")).sendKeys(lastName);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("userName")).sendKeys(email);
	}

	public void preencherMailingInformation(String address, String address2, String city, String stateProvince,
			String postalCode, String country) {

		driver.findElement(By.name("address1")).sendKeys(address);
		driver.findElement(By.name("address2")).sendKeys(address2);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(stateProvince);
		driver.findElement(By.name("postalCode")).sendKeys(postalCode);

		WebElement comboCountry = driver.findElement(By.name("country"));
		new Select(comboCountry).selectByVisibleText(country);
	}

	public void preencherUserInformation(String userName, String password, String confirmPassword) {
		driver.findElement(By.name("email")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(confirmPassword);
	}

	public void clickSubmit() {
		driver.findElement(By.name("register")).click();
	}

	public boolean checkMensagemSucesso (String firstName, String lastName, String userName) { 
		
		boolean mensagem, mensagem2, mensagem3;
		
		mensagem = helper.checkElement("//b[contains(text(),'Dear " + firstName + " " + lastName + ",')]");
		mensagem2 = helper.checkElement("//font[contains(text(), 'Thank you for registering.')]");
		mensagem3 = helper.checkElement("//font[contains(text(), 'Thank you for registering.')]//following::font//b[text()=' Note: Your user name is " + userName + ".']");
		
		if((mensagem == true) && (mensagem2 == true) && (mensagem3 == true))
			return true;
		else
			return false;				
	}
}
