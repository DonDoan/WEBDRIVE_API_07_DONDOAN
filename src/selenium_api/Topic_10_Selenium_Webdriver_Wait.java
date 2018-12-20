package selenium_api;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Selenium_Webdriver_Wait {

	WebDriver driver;
	Common c1 = new Common();
	Date date;
	@BeforeClass
	public void beforeClass() {
		
		
		//Chrome
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		Firefox
//		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
//
//	@Test
	public void TC01() throws Exception {
//		Test Script 01: Implicit Wait
//		Step 01 - Truy cập vào trang: 
//		http://the-internet.herokuapp.com/dynamic_loading/2
		c1.open_page(driver, "http://the-internet.herokuapp.com/dynamic_loading/2");
//		Step 02 - Define an implicit wait (If you set 2 seconds, test will fail)
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); // fail, timeout with 2s cannot findElement
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		Step 03 - Click the Start button
		c1.clickToElementByJS(driver, driver.findElement(By.xpath("//button[text()='Start']")));
//		Step 04 - Wait result text will appea
		Thread.sleep(2000);
//		Step 05 - Check result text is "Hello World!"
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
	}
//	@Test
	public void TC02() {
//		Test Script 02: Sử dụng Explicit wait
//		Check cho loading icon invisible trước khi Helloworld text được hiển thị
//		Implicit wait chỉ set 2s
//		Step 01 - Truy cập vào trang: 
//		http://the-internet.herokuapp.com/dynamic_loading/2
		c1.open_page(driver, "http://the-internet.herokuapp.com/dynamic_loading/2");
//		Step 02 - Click the Start button
		c1.clickToElementByJS(driver, driver.findElement(By.xpath("//button[text()='Start']")));
//		Step 03 - Wait Loading invisible
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //fail case
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='loading']")).isDisplayed());
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mail")));
		
		WebDriverWait w = new WebDriverWait(driver, 1);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading")));
//		Step 04 - Check result text is "Hello World!"
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
	}
	@Test
	public void TC03() {
//		Test Script 03: Sử dụng Explicit wait
//		Check cho Hello world text visible -> sau đó check Helloworld text được hiển thị
//		Implicit wait chỉ set 2s
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		Step 01 - Truy cập vào trang: 
//		http://the-internet.herokuapp.com/dynamic_loading/2
		c1.open_page(driver, "http://the-internet.herokuapp.com/dynamic_loading/2");
//		Step 02 - Click the Start button
		c1.clickToElementByJS(driver, driver.findElement(By.xpath("//button[text()='Start']")));
		
//		Step 03 - Wait Hello World visible
		System.out.println("--------Start time -----");
		System.out.println(date = new Date());
		WebDriverWait w = new WebDriverWait(driver, 2);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		System.out.println("--------End time -----");
		System.out.println(date = new Date());
//		Step 04 - Check result text is "Hello World!"
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());		
	}
//
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
