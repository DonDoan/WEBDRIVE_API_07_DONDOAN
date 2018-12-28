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
	WebDriverWait w ;
	@BeforeClass
	public void beforeClass() {

		// Chrome
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

//		Firefox
//		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		w = new WebDriverWait(driver, 2);		
	}

//
//	@Test
	public void TC01() throws Exception {
//		Test Script 01: Implicit Wait
//		Step 01 - Truy cập vào trang: 
//		http://the-internet.herokuapp.com/dynamic_loading/2
		c1.open_page(driver, "http://the-internet.herokuapp.com/dynamic_loading/2");
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
//		Step 02 - Define an implicit wait (If you set 2 seconds, test will fail)
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); // fail, timeout with 2s cannot findElement
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		Step 03 - Click the Start button
		c1.clickToElementByJS(driver, driver.findElement(By.xpath("//button[text()='Start']")));
//		Step 04 - Wait result text will appear
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
//		c1.open_page(driver, "http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
//		Step 02 - Click the Start button
		c1.clickToElementByJS(driver, driver.findElement(By.xpath("//button[text()='Start']")));
//		Step 03 - Wait Loading invisible
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //fail case
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='loading']")).isDisplayed());
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mail")));

//		WebDriverWait w1 = new WebDriverWait(driver, 4); //if set 4s, this timeout is not enough for find element of the w1 wait.
		WebDriverWait w1 = new WebDriverWait(driver, 5);
		System.out.println("--------Start time -----");
		System.out.println(date = new Date());
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading")));
		w1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
		System.out.println("--------End time -----");
		System.out.println(date = new Date());
//		Step 04 - Check result text is "Hello World!"
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
	}

//	@Test
	public void TC03() {
//		Test Script 03: Sử dụng Explicit wait
//		Check cho Hello world text visible -> sau đó check Helloworld text được hiển thị
//		Implicit wait chỉ set 2s
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		Step 01 - Truy cập vào trang: 
//		http://the-internet.herokuapp.com/dynamic_loading/2
//		c1.open_page(driver, "http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
//		Step 02 - Click the Start button
		c1.clickToElementByJS(driver, driver.findElement(By.xpath("//button[text()='Start']")));
//		Step 03 - Wait Hello World visible
		System.out.println("--------Start time -----");
		System.out.println(date = new Date());
		WebDriverWait w1 = new WebDriverWait(driver, 5); // 5s is a optima number
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		System.out.println("--------End time -----");
		System.out.println(date = new Date());
//		Step 04 - Check result text is "Hello World!"
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
	}

//	@Test
	public void TC_04_InvisibleInDomAndNot() throws Exception {
//		Check cho Helloworld invisible + có trong DOM -> hết bao nhiêu s?
//				Check cho Helloworld invisible + ko có trong DOM -> hết bao nhiêu s?
//				Check cho Loading invisible + có trong DOM -> hết bao nhiêu s?
//				Check cho Loading invisible + ko có trong DOM -> hết bao nhiêu s?
//		Truy cập vào trang: 
//		http://the-internet.herokuapp.com/dynamic_loading/2
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
		WebDriverWait w2 = new WebDriverWait(driver, 1);
		WebDriverWait w1 = new WebDriverWait(driver, 5); // 5s is a optima number
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
//		Check Hello World text invisible -> not in DOM,  PASS (Wait for implicitly wait)
		System.out.println("--------Start time - Check Hello World text invisible -> not in DOM -----");
		System.out.println(date = new Date());		
		w1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));	
		System.out.println("--------End time -----");
		System.out.println(date = new Date());	
//		Check Loading invisible -> not in DOM, PASS (Wait for implicitly wait)
		System.out.println("--------Start time  - Check Loading invisible -> not in DOM, -----");
		System.out.println(date = new Date());		
		w1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));	
		System.out.println("--------End time -----");
		System.out.println(date = new Date());	
//		Click the Start button
		System.out.println("--------Click the Start button -----");
//		c1.clickToElementByJS(driver, driver.findElement(By.xpath("//button[text()='Start']")));
		driver.findElement(By.xpath("//button[text()='Start']")).click();
//		Check Loading visible -> in DOM, PASS 	
		System.out.println("--------Start time  - Check Loading visible -> in DOM, -----");
		System.out.println(date = new Date());		
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='loading']")));	
		System.out.println("--------End time -----");
		System.out.println(date = new Date());		
//		Check Hello World text visible -> in DOM,  PASS (Wait for implicitly wait)
		System.out.println("--------Start time - Check Hello World text visible -> in DOM -----");
		System.out.println(date = new Date());		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebDriverWait w3 = new WebDriverWait(driver, 7); //5s is a optima number, loading icon visible in 5s
		w3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']//h4[text()='Hello World!']")));	
		System.out.println("--------End time -----");
		System.out.println(date = new Date());		
//		Check Loading precense -> in DOM, 		
		System.out.println("--------Start time  - Check Loading precense -> in DOM, PASS -----");
		System.out.println(date = new Date());	
		w2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='loading']")));	
		System.out.println("--------End time -----");
		System.out.println(date = new Date());					
//		Check Loading invisible -> in DOM, PASS		
		System.out.println("--------Start time  - Check Loading invisible -> in DOM, -----");
		System.out.println(date = new Date());		
		w1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));	
		System.out.println("--------End time -----");
		System.out.println(date = new Date());		
//		Check Loading visible -> in DOM, FAIL		
//		System.out.println("--------Start time  - Check Loading visible -> in DOM, -----");
//		System.out.println(date = new Date());		
//		w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='loading']")));	
//		System.out.println("--------End time -----");
//		System.out.println(date = new Date());			
			
	}
	
	@Test
	public void TC05() {
//		Test Script 05: Explicit Wait
//		Step 01 - Truy cập vào trang:
//		http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx
		driver.get("http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		driver.manage().window().maximize();
//		Step 02 - Wait cho "Date Time Picker" được hiển thị (sử dụng: presence or visibility)
		WebDriverWait w1 = new WebDriverWait(driver, 4);
		w1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("")));
//		Step 03 - In ra ngày đã chọn (Before AJAX call) -> hiện tại chưa chọn nên in ra = "No Selected Dates to display."
		System.out.println("");
//		Step 04 - Chọn ngày hiện tại (VD: 23/09/2017) (hoặc 1 ngày bất kì tương ứng trong tháng/ năm hiện tại)
		
//		Step 05 - Wait cho đến khi "loader ajax" không còn visible (sử dụng: invisibility)
//		Xpath: //div[@class='raDiv']
//		Step 06 - Wait cho selected date = 23 được visible ((sử dụng: visibility)
//		Xpath: //*[contains(@class,'rcSelected')]//a[text()='23']
//		Step 07 - Verify ngày đã chọn bằng = Saturday, September 23, 2017		
	}	
	
	
//	@Test
	public void TC06() {
//		Test Script 06: Fluent Wait
//		Step 01 - Truy cập vào trang: 
//		https://daominhdam.github.io/fluent-wait/
//		Step 02 - Wait cho đến khi countdown time được visible (visibility)
//		Step 03 - Sử dụng Fluent wait để:
//		Mỗi 1s kiểm tra countdount= 00 được xuất hiện trên page hay chưa (giây đếm ngược về 00)
//		Tức là trong vòng 15s (tổng thời gian), cứ mỗi 1 giây verify xem nó đã đếm ngược về giây 00 hay chưa			
	}	

	

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
