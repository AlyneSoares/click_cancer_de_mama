package click.cancerdemama;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickBanner {
	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/alyne/workspace/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://cancerdemama.com.br/");
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void clicarCampanha() {		
		assertEquals("Site: Câncer de Mama", driver.getTitle());
		String handleInicial = driver.getWindowHandle();
		WebElement botaoAjuda = driver.findElement(By.className("img-responsive"));
		assertEquals("Site: Câncer de Mama", driver.getTitle());
		botaoAjuda.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		assertEquals("Campanha da Mamografia Digital GRATUITA   ||||||   Instituto NEO MAMA   ||||||", driver.getTitle());
	}

}
