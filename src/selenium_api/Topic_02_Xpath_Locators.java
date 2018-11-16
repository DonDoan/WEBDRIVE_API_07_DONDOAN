package selenium_api;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
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

	}

//====================================================================================================
	// Begin TC01
	// Test Script 01: Verify URL and title
	@Test
	public void TC01_Verify_URL_title() {
//				Step 01 - Truy cập vào trang: http://live.guru99.com
		driver.get("http://live.guru99.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Step 02 - Kiểm tra title của page là: "Home page"
		String Homepage_title = driver.getTitle();
		Assert.assertEquals(Homepage_title, "Home page");
		// Step 03 - Click vào link "My Account" để tới trang đăng nhập
		// We can use the below xpath command lines
//			//div[@class='footer-container']//a[@title='My Account']  -> fast
//			//div[@class='footer-container']//a[text()='My Account'] -> fast
//			//div[@class='footer-container']//a[contains(text(),'Acc')]
//			//div[@class='footer-container']//a[starts-with(text(),'My ')]
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		// Step 04 - Click CREATE AN ACCOUNT button để tới trang đăng kí tài khoản
//			//span[contains(text(),'Create an Account')]
//			//a[@class='button']//span[contains(text(),'Create')]	
//			//span[text()='Create an Account'] -> fast
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
//			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		// Step 05 - Back lại trang đăng nhập
		driver.navigate().back();
//				Step 06 - Kiểm tra url của page đăng nhập là: http://live.guru99.com/index.php/customer/account/login/
		String login_url = driver.getCurrentUrl();
		Assert.assertEquals(login_url, "http://live.guru99.com/index.php/customer/account/login/");
//				Step 07 - Forward tới trang tạo tài khoản
		driver.navigate().forward();
//				Step 08 - Kiểm tra url của page tạo tài khoản là: http://live.guru99.com/index.php/customer/account/create/	
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.guru99.com/index.php/customer/account/create/");
	}

	// End TC01
// ===================================================================================================	
//====================================================================================================
	// Begin TC02
	// Test Script 02: Login empty
	@Test
	public void TC02_Login_empty() {
//		Step 01 - Truy cập vào trang: http://live.guru99.com/
		driver.get("http://live.guru99.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		Step 02 - Click vào link "My Account" để tới trang đăng nhập
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
//		Step 03 - Để trống Username/ Password -> do nothing ???
//		Step 04 - Click Login button
		// button[@type='submit' and @title='Login']
		driver.findElement(By.xpath("//button[@type='submit' and  @title='Login']")).click();
//		Step 05 - Verify error message xuất hiện tại 2 field:  This is a required field.		
		Assert.assertTrue(
				driver.findElement(By.xpath("//input[@type='email']/following-sibling::div[1]")).isDisplayed());
		Assert.assertTrue(
				driver.findElement(By.xpath("//input[@type='password']/following-sibling::div[1]")).isDisplayed());
	}

	// End TC02
// ===================================================================================================	
	// Begin TC03
//	Test Script 03: Login with Email invalid
	@Test
	public void TC03_Login_w_invalidEmail() {
//		Step 01 - Truy cập vào trang: http://live.guru99.com/
		driver.get("http://live.guru99.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		Step 02 - Click vào link "My Account" để tới trang đăng nhập
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
//		Step 03 - Nhập email invalid: 123434234@12312.123123
		String invalid_email = "123434234@12312.123123";
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(invalid_email);
//		Step 04 - Click Login button
		driver.findElement(By.xpath("//button[@title='Login']")).click();
//		Step 05 - Verify error message xuất hiện:  Please enter a valid email address. For example johndoe@domain.com.	
		Assert.assertTrue(driver.findElement(By.xpath(
				"//input[@type='email']/following-sibling::div[text()='Please enter a valid email address. For example johndoe@domain.com.']"))
				.isDisplayed());
		// input[@type='email']/following-sibling::div[1]
	}

	// End TC03
// ===================================================================================================	
	// Begin TC04
//	Test Script 04: Login with Password < 6 character
	@Test
	public void TC04_Login_invalidPassword() {
//	Step 01 - Truy cập vào trang: http://live.guru99.com/
		driver.get("http://live.guru99.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	Step 02 - Click vào link "My Account" để tới trang đăng nhập
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
//	Step 03 - Nhập email correct and password incorrect: automation@gmail.com/ 123
		String valid_email = "automation@gmail.com", invalid_password = "123";
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(valid_email);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(invalid_password);
//	Step 04 - Click Login button
		driver.findElement(By.xpath("//button[@title='Login']")).click();
//	Step 05 - Verify error message xuất hiện: Please enter 6 or more characters without leading or trailing spaces.
		Assert.assertTrue(driver.findElement(By.xpath(
				"//input[@id='pass']/following-sibling::div[text()='Please enter 6 or more characters without leading or trailing spaces.']"))
				.isDisplayed());
	}

	// End TC04
// ===================================================================================================	
	// Begin TC05
//	Test Script 05: Login with Password incorrect
	@Test
	public void TC05_Login_incorrectPassword() {
//		Step 01 - Truy cập vào trang: http://live.guru99.com/
		driver.get("http://live.guru99.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		Step 02 - Click vào link "My Account" để tới trang đăng nhập
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
//		Step 03 - Nhập email correct and password incorrect: automation@gmail.com/ 123123123
		String valid_email = "automation@gmail.com", incorrect_password = "123123123";
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(valid_email);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(incorrect_password);
//		Step 04 - Click Login button
		driver.findElement(By.xpath("//button[@title='Login']")).click();
//		Step 05 - Verify error message xuất hiện: Invalid login or password.
		// span[contains(text(),'Invalid')]/ancestor::div[@class='account-login'] -->
		// for ancestor : output hereunder is div class = account-login, span is current
		// node.
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).isDisplayed());
	}

	// End TC05
// ===================================================================================================	
	// Begin TC06
//	Test Script 06: Create an account
	@Test
	public void TC06_CreateAcc() {
//	Step 01 - Truy cập vào trang: http://live.guru99.com/
		driver.get("http://live.guru99.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	Step 02 - Click vào link "My Account" để tới trang đăng nhập
		driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
//	Step 03 - Click CREATE AN ACCOUNT button để tới trang đăng kí tài khoản
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
//	Step 04 - Nhập thông tin hợp lệ vào tất cả các field: First Name/ Last Name/ Email Address/ Password/ Confirm Password
		String fist_name = "Don", last_name = "Doan", ran_email = "dondoan" + random_num_4email() + "@gmail.com", password = "123456";
		System.out.println(ran_email); // print randome email created
//	(Lưu ý: Tạo random cho dữ liệu tại field Email Address)
		driver.findElement(By.id("firstname")).sendKeys(fist_name);
		driver.findElement(By.id("lastname")).sendKeys(last_name);
		driver.findElement(By.name("email")).sendKeys(ran_email);
		driver.findElement(By.className("validate-password")).sendKeys(password);
		driver.findElement(By.className("validate-cpassword")).sendKeys(password);
//	Step 05 - Click REGISTER button
		driver.findElement(By.xpath("//span[text()='Register']")).click();
//	Step 06 - Verify message xuất hiện khi đăng kí thành công: Thank you for registering with Main Website Store.
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).isDisplayed());
//	Step 07 - Logout khỏi hệ thống
		driver.findElement(By.xpath("//span[@class='label' and text()='Account']")).click();
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();
//	Step 08 - Kiểm tra hệ thống navigate về Home page sau khi logout thành công	
//		Why can't we check with Homepage title???
//		String Homepage_title = driver.getTitle();
//		Assert.assertEquals(Homepage_title, "Home page");
		Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'This is demo site for')]")).isDisplayed());
	}
	// End TC06
// ===================================================================================================	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public int random_num_4email() {
		Random random = new Random();
		int random_num = random.nextInt(30)+1;
		System.out.println("Random number is " + random_num);
		return random_num;
	}
}