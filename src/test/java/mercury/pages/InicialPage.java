package mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import mercury.config.SetUp;

public class InicialPage extends SetUp {

	public InicialPage(WebDriver driver) {
		super(driver); 
	}

	public void login(String user, String password) {
		driver.findElement(By.name("userName")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();		
	}		
	
	public void clickRegister() {
		driver.findElement(By.linkText("REGISTER")).click();
	}
}
