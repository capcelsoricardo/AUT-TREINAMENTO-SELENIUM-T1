package mercury.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mercury.config.SetUp;

public class Helper extends SetUp {

	public Helper(WebDriver driver) {
		super(driver);
	}
		
	public boolean checkElement(String xpath) {
		try {
			return driver.findElement(By.xpath(xpath)).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void waitElement(String xpath) {
		
		WebDriverWait aguardar = new WebDriverWait(driver, 10);
		aguardar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
						
	}
	
	public String conversorMes(String mes) {
		switch (mes) {
			case "January":
				return "1";
				
			case "February":
				return "2";
				
			case "March":
				return "3";
				
			case "April":
				return "4";
				
			case "May":
				return "5";
				
			case "June":
				return "6";
				
			case "July":
				return "7";
				
			case "August":
				return "8";
				
			case "September":
				return "9";
				
			case "October":
				return "1";
				
			case "November":
				return "11";
				
			case "December":
				return "12";
			
			default:
				return "00";					
		}
	}
}
