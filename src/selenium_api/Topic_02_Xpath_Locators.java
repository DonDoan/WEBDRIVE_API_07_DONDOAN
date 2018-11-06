package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.reporters.jq.NavigatorPanel;

public class Topic_02_Xpath_Locators {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// Chrome
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

		// Firefox #
//		driver = new FirefoxDriver();

		// Truy cập vào trang http://live.guru99.com
//		driver.get("http://live.guru99.com");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//==================================================================================================
// Begin TC01
//Test Script 01: Verify URL and title
	@Test
	public void TC01_Verify_URL_title() {
//			Step 01 - Truy cập vào trang: http://live.guru99.com
		driver.get("http://live.guru99.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//			Step 02 - Kiểm tra title của page là: "Home page"
		String Homepage_title = driver.getTitle();
		Assert.assertEquals(Homepage_title, "Home page");

//			Step 03 - Click vào link "My Account" để tới trang đăng nhập
// We can use the below xpath command lines
//		//div[@class='footer-container']//a[@title='My Account']  -> fast
//		//div[@class='footer-container']//a[text()='My Account'] -> fast
//		//div[@class='footer-container']//a[contains(text(),'Acc')]
//		//div[@class='footer-container']//a[starts-with(text(),'My ')]

		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

//			Step 04 - Click CREATE AN ACCOUNT button để tới trang đăng kí tài khoản
//		//span[contains(text(),'Create an Account')]
//		//a[@class='button']//span[contains(text(),'Create')]	
//		//span[text()='Create an Account'] -> fast
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

//			Step 05 - Back lại trang đăng nhập
		driver.navigate().back();
		
//			Step 06 - Kiểm tra url của page đăng nhập là: http://live.guru99.com/index.php/customer/account/login/
		String login_url= driver.getCurrentUrl();
		Assert.assertEquals(login_url, "http://live.guru99.com/index.php/customer/account/login/");
		
//			Step 07 - Forward tới trang tạo tài khoản
		driver.navigate().forward();
		
//			Step 08 - Kiểm tra url của page tạo tài khoản là: http://live.guru99.com/index.php/customer/account/create/	
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.guru99.com/index.php/customer/account/create/");
	}
// End TC01
// ===================================================================================================	
	
//	@Test
//	public void TC_01_CheckTitle() {
//		String homePageTitle = driver.getTitle();
//		Assert.assertEquals(homePageTitle, "Google");
//	}	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}