package mercury.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
