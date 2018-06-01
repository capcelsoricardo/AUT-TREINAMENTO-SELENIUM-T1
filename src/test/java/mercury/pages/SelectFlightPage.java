package mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import mercury.config.SetUp;
import mercury.utils.Helper;

public class SelectFlightPage extends SetUp {

	public SelectFlightPage(WebDriver driver) {
		super(driver);
	}
	
	Helper helper = new Helper(driver);
	
	public boolean checkSelectFlightPage(){
		return helper.checkElement("//font[contains(text(), 'Select your departure')]");
	}
	
	public void selectDepart() {
		driver.findElement(By.xpath("//input[@name='outFlight']//following::input[2]")).click();
	}
	
	public void selectReturn() {
		driver.findElement(By.xpath("//input[@name='inFlight']//following::input[2]")).click();
	}
	
	public void clickButtonContinue() {
		driver.findElement(By.name("reserveFlights")).click();
	}
}
