package google.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import mercury.config.SetUp;
import mercury.utils.Framework;

public class HomePage extends SetUp {

	Framework framework = new Framework(driver);
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void pesquisarTexto(String texto) {
		framework.preencherCampo(By.id("lst-ib"), texto);	
		
		Actions action  = new Actions(driver);
		action.sendKeys(Keys.TAB).perform();			
		
		framework.clickButton(By.name("btnK"));
	}	

	
	public void pesquisarTextoSikuli(String texto) {
		Screen minhaTela = new Screen();
		Pattern pattern = new Pattern("src\\test\\resources\\dados\\campoPesquisar.PNG");
		try {
			minhaTela.paste(pattern, texto);
		} catch (FindFailed e) {
			Assert.assertTrue("Não encontrou o campo 'Pesquisar'.", false);
		}
								
		framework.clickButton(By.name("btnK"));
	}	
}
