package selenium_api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Iframe_WindowPopup {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		
		
		//Chrome
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		Firefox
//		driver = new FirefoxDriver();
	}
//
	@Test
	public void f() {
		
		String homePageTitle = driver.getTitle();
		AssertJUnit.assertEquals(homePageTitle, "Google");
	}
//
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
