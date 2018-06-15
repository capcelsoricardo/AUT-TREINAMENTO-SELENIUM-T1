package mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import mercury.config.SetUp;
import mercury.utils.Helper;

public class BookAFlightPage extends SetUp {
	
	Helper helper = new Helper(driver);

	public BookAFlightPage(WebDriver driver) {
		super(driver);
	}
	
	public String getTextDepart() { 
				
		helper.waitElement("//font[contains(text(), 'FLIGHT')]//following::tr[1]/td/font");
		
		return driver.findElement(By.xpath("//font[contains(text(), 'FLIGHT')]//following::tr[1]/td/font")).getText();
	}
	
	public String getTextRetornoViagem() { 
		
		return driver.findElement(By.xpath("//font[contains(text(), 'FLIGHT')]//following::tr[2]/td/b/font")).getText();
	}	

	
	public String getTextReturn() {
		return driver.findElement(By.xpath("//font[contains(text(), 'FLIGHT')]//following::tr[4]/td/font/font/font/b")).getText();
	}
	
	public void preencherPassengers() {
		
	}
	
	public void preencherCreditCard() {
		
	}
	
	public void preencherBillingAddress() {
		
	}
	
	public void preencherDeliveryAddress() {
		
	}
	
	public void clickButtonSecurePurchase() {
		driver.findElement(By.name("buyFlights")).click();
	}
	
}
