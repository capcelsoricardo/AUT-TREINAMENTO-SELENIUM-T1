package google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import mercury.config.SetUp;
import mercury.utils.Framework;

public class MTP extends SetUp{

	Framework framework = new Framework(driver);
	
	public MTP(WebDriver driver) {
		super(driver);
	}
	
	public void clickMenu(String menuPrincipal, String subMenu) { 								
				
		Actions action = new Actions(driver); 
		action.moveToElement(driver.findElement(By.xpath("//*[@id='sp-menu']//following::a[contains(text(),'"+menuPrincipal+"')]"))).perform();				
		
		framework.waitElementVisible(By.xpath("//*[@id='sp-menu']//following::a[contains(text(),'" + subMenu + "')]"), 10);
		
		action.click(driver.findElement(By.xpath("//*[@id='sp-menu']//following::a[contains(text(),'"+ subMenu +"')]"))).perform();
		
	}

}
