package selenium_api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Common_called {
	Common_Test common1 = new Common_Test();
	WebDriver driver;
	// ====================================================================================================
	@BeforeClass
	public void beforeClass() {

		// Chrome
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void A2() {

		common1.A1();
		String url = "https://google.com/";
		common1.open_page(driver,url);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}	
}