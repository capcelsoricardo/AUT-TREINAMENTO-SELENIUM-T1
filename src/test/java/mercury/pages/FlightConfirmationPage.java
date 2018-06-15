package mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import mercury.config.SetUp;

public class FlightConfirmationPage extends SetUp {

	public FlightConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	public String getTextMensagemItenerary() {
		return driver.findElement(By.xpath("//font[contains(text(), 'itinerary has been')]")).getText();		
	}
	
	public String getMensagemDeparting() {
		return driver.findElement(By.xpath("//font[contains(text(), 'Departing')]//following::td/font")).getText();
	}
	
	public String getMensagemReturning() {
		return driver.findElement(By.xpath("//font[contains(text(), 'Returning')]//following::td/font")).getText();
	}

}
