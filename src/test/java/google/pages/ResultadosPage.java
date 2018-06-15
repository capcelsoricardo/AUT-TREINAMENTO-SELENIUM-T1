package google.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import mercury.config.SetUp;
import mercury.utils.Framework;

public class ResultadosPage extends SetUp {

	Framework framework = new Framework(driver);
	
	public ResultadosPage(WebDriver driver) {
		super(driver);
	}

	public void clickLinkMTP() {
		framework.clickLink("Serviços de Garantia da Qualidade - Fábrica de Testes | MTP");
	}
	
	public void clickLinkMTPSikuli() {
		Screen minhaTela = new Screen();
		Pattern imagemLinkMTP = new Pattern("src\\test\\resources\\dados\\linkMTP.PNG");
		
		try {
			minhaTela.click(imagemLinkMTP);
		} catch (FindFailed e) {
			Assert.assertTrue("Não encontrou a imagem do link da MTP", false);
		}
	}
}
