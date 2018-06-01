package mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import mercury.config.SetUp;

public class FlightFinderPage extends SetUp {

	public FlightFinderPage(WebDriver driver) {
		super(driver);
	}

	public boolean existSignOff() {
		try {
			return driver.findElement(By.xpath("//a[text()='SIGN-OFF']")).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void preencherFlightDetails(String type, String passengers, String departmentFrom, String onMonth,
			String onDay, String arrivingIn, String returningMonth, String returningDay) {
		driver.findElement(By.xpath("//input[@value='" + type + "']")).click();

		WebElement comboPassengers = driver.findElement(By.name("passCount"));
		new Select(comboPassengers).selectByVisibleText(passengers);

		WebElement comboDepartmentFrom = driver.findElement(By.name("fromPort"));
		new Select(comboDepartmentFrom).selectByVisibleText(departmentFrom);

		WebElement comboOnMonth = driver.findElement(By.name("fromMonth"));
		new Select(comboOnMonth).selectByVisibleText(onMonth);

		WebElement comboOnDay = driver.findElement(By.name("fromDay"));
		new Select(comboOnDay).selectByVisibleText(onDay);

		WebElement comboArrivingIn = driver.findElement(By.name("toPort"));
		new Select(comboArrivingIn).selectByVisibleText(arrivingIn);

		WebElement comboReturningMonth = driver.findElement(By.name("toMonth"));
		new Select(comboReturningMonth).selectByVisibleText(returningMonth);

		WebElement comboReturningDay = driver.findElement(By.name("toDay"));
		new Select(comboReturningDay).selectByVisibleText(returningDay);
	}

	public void preencherPreferences(String airline) {
		driver.findElement(By.xpath("//input[@value='Business']")).click();
		WebElement comboAirline = driver.findElement(By.name("airline"));
		new Select(comboAirline).selectByVisibleText(airline);
	}

	public void clickButtonContinue() {
		driver.findElement(By.name("findFlights")).click();
	}
}