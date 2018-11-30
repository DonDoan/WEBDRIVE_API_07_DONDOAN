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
//		Test Script 01:
//			Step 01 - Truy cập vào trang: http://www.hdfcbank.com/
//			Step 02 - Close popup nếu có hiển thị (switch qua iframe nếu có)  - F5 (refresh page) nhiều lần thì sẽ xuất hiện popup
//			Xpath iframe: //iframe[@id='vizury-notification-template']
//
//			Xpath close popup: //div[@id='div-close']
//
//			Step 03 - Verify đoạn text được hiển thị:  What are you looking for? (switch qua iframe nếu có)
//
//			Step 04:
//			Verify banner có đúng 6 images (switch qua iframe nếu có)
//
//			Step 05 - Verify flipper banner được hiển thị và có 8 items
		
		String homePageTitle = driver.getTitle();
		AssertJUnit.assertEquals(homePageTitle, "Google");
	}
//
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
