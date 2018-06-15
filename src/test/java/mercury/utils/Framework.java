package mercury.utils;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mercury.config.SetUp;

public class Framework extends SetUp {

	public Framework(WebDriver driver) {
		super(driver);
	}
	
	public void preencherCampo(By by, String texto){
		try {
			driver.findElement(by).sendKeys(texto); 
		} catch (Exception e) {
			System.out.println("Não encontrou o elemento ' " +by.toString() + " '");
		}				
	}
	
	public void clickButton(By by) {
		try {
			driver.findElement(by).click(); 
		} catch (Exception e) {			
			assertTrue("Não encontrou o botão ' " +by.toString() + " '", false);			
		}			
	}
	
	public void clickLink(String textLink) {
		try {
			driver.findElement(By.linkText(textLink)).click(); 
		} catch (Exception e) {			
			assertTrue("Não encontrou o Link ' " +textLink + " '", false);			
		}
	}
	
	public void waitElementVisible(By by, int seconds) { 
		WebDriverWait aguardar = new WebDriverWait(driver, seconds);
		aguardar.until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}

}
