package selenium_api;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Iframe_WindowPopup {
	
	WebDriver driver;
	Common c1 = new Common();
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
	public void TC01_IframePopup() {
//		Test Script 01:
//			Step 01 - Truy cập vào trang: http://www.hdfcbank.com/
		c1.open_page(driver, "http://www.hdfcbank.com/");
//			Step 02 - Close popup nếu có hiển thị (switch qua iframe nếu có)  - F5 (refresh page) nhiều lần thì sẽ xuất hiện popup
		By IframePopupCloseBy = By.xpath("//iframe[@id='vizury-notification-template']");
		List<WebElement> IframePopupClose = driver.findElements(IframePopupCloseBy);
//		WebElement IframePopupClose = driver.findElement(IframePopupCloseBy);
//			Xpath iframe: //iframe[@id='vizury-notification-template']
//			Xpath close popup: //div[@id='div-close']
		if (IframePopupClose.size() > 0) {
			driver.switchTo().frame(IframePopupClose.get(0));
			By PopupCloseBy = By.xpath("//div[@id='div-close']");
			WebElement PopupClose = driver.findElement(PopupCloseBy);
			PopupClose.click();
			driver.switchTo().defaultContent();
		}
//			Step 03 - Verify đoạn text được hiển thị:  What are you looking for? (switch qua iframe nếu có)
		By IframeWhatAreULooking4By = By.xpath("//div[@class='flipBannerWrap']//iframe");
		WebElement IframeWhatAreULooking4 = driver.findElement(IframeWhatAreULooking4By);
		driver.switchTo().frame(IframeWhatAreULooking4);
		By WhatAreULooking4TextBy = By.xpath("//span[@id='messageText']");
		WebElement WhatAreULooking4Text = driver.findElement(WhatAreULooking4TextBy);
		String txtexpected = "What are you looking for?";
		Assert.assertEquals(WhatAreULooking4Text.getText(), txtexpected);
//			Step 04:
		driver.switchTo().defaultContent();
//			Verify banner có đúng 6 images (switch qua iframe nếu có)
//
//			Step 05 - Verify flipper banner được hiển thị và có 8 items
		
	}
//
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
