package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium_api.Common;

public class TestNG_01_Annotation {
	Common c1 = new Common();
	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

//	  @BeforeClass
//	  public void beforeClass() {
//		  System.out.println("beforeClass");	  
//	  }	 
	@Parameters("browser")
	@BeforeClass (groups = "payment_1")
	public void SetupBrowsers(String BrowserName) {
		System.out.println("BeforeClass, payment_1");
		System.out.println("SetupBrowsers..........");
		System.out.println("Browsers is :" + BrowserName);
		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (BrowserName.equals("chrome_headless")) {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			ChromeOptions chromOptions = new ChromeOptions();
			chromOptions.addArguments("--headless");
			driver = new ChromeDriver(chromOptions);
		} else if (BrowserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BrowserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", ".\\lib\\IEdriver.exe");
			driver = new InternetExplorerDriver();
		}
	}

//  @Test(dataProvider = "dp")
//  public void f(Integer n, String s) {
//  }
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}

	@Test(groups = "user")
	public void TC_01() {
		System.out.println("TC_01, group user");
	}

	@Test(groups = "product")
	public void TC_02() {
		System.out.println("TC_02, group product");
	}

	@Test(groups = "product")
	public void TC_03() {
		System.out.println("TC_03, group product");
	}

	@Test(groups = "payment", priority = 2, enabled = true)
	public void TC_04() {
		System.out.println("TC_04, group payment, priority = 2, enabled = true");
	}

	@Test(groups = "payment", priority = 1, enabled = true)
	public void TC_05() {
		System.out.println("TC_05, group payment, priority = 1, enabled = true");
	}

	@Test(groups = "payment", priority = 3, enabled = false)
	public void TC_07() {
		System.out.println("TC_07, group payment, priority = 3, enabled = false");
	}

	@Test(groups = "payment", priority = 4, enabled = true)
	public void TC_08() {
		System.out.println("TC_08, group payment, priority = 4, enabled = true");
	}

	@Test(groups = "payment", enabled = true)
	public void TC_09() {
		System.out.println("TC_09, group payment");
	}

	@Test(groups = "payment")
	public void TC_10() {
		System.out.println("TC_10, group payment");
	}

	@Test(groups = "payment", dataProvider = "EmailPw")
	public void TC_11_LoginToSystem(String email, String pw) {
		System.out.println("TC_11_LoginToSystem, group payment, dataProvider");
		c1.open_page(driver, "http://live.guru99.com/index.php");
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Email Address']")).sendKeys(email);
		driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Password']")).sendKeys(pw);
		driver.findElement(By.xpath("//div[@class='account-login']//button[@type='submit']")).click();
		driver.findElement(By.xpath("//h1[text()='My Dashboard']")).isDisplayed();
		driver.findElement(By.xpath("//p[contains(.,'"+ email + "')]")).isDisplayed();
		driver.findElement(By.xpath("//header//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		driver.findElement(By.xpath("//h2[contains(text(),'This is demo site for')]")).isDisplayed();
		
	}
	@Parameters ({"email", "password"})
	@Test(groups = "payment_1")
	public void TC_12_LoginToSystem(String email, String pw) {
		System.out.println("TC_12_LoginToSystem, group payment_1, Parameters ");
		c1.open_page(driver, "http://live.guru99.com/index.php");
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Email Address']")).sendKeys(email);
		driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Password']")).sendKeys(pw);
		driver.findElement(By.xpath("//div[@class='account-login']//button[@type='submit']")).click();
		driver.findElement(By.xpath("//h1[text()='My Dashboard']")).isDisplayed();
		driver.findElement(By.xpath("//p[contains(.,'"+ email + "')]")).isDisplayed();
		driver.findElement(By.xpath("//header//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		driver.findElement(By.xpath("//h2[contains(text(),'This is demo site for')]")).isDisplayed();
		
	}
	@Parameters ({"email", "password"})
	@Test(groups = "payment_1", invocationCount = 2)
	public void TC_13_LoginToSystemLoop(String email, String pw) {
		System.out.println("TC_13_LoginToSystemLoop, group payment_1, Parameters ");
	  c1.open_page(driver, "http://live.guru99.com/index.php");
	  driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	  driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Email Address']")).sendKeys(email);
	  driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Password']")).sendKeys(pw);
	  driver.findElement(By.xpath("//div[@class='account-login']//button[@type='submit']")).click();
	  driver.findElement(By.xpath("//h1[text()='My Dashboard']")).isDisplayed();
	  driver.findElement(By.xpath("//p[contains(.,'"+ email + "')]")).isDisplayed();
	  driver.findElement(By.xpath("//header//span[text()='Account']")).click();
	  driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	  driver.findElement(By.xpath("//h2[contains(text(),'This is demo site for')]")).isDisplayed();

	}

	@Test(groups = "user")
	public void TC_06() {
		System.out.println("TC_06, group user");
	}

	@DataProvider
	public Object[][] EmailPw() {
		return new Object[][] { { "automationfc001@gmail.com", "123123" }, { "automationfc001@gmail.com", "123123" },
//				{ "automationfc001@gmail.com", "123123" },
//      new Object[] { 1, "a" },
//      new Object[] { 2, "b" },
		};
	}

	@AfterClass (groups = "payment_1")
	public void afterClass() {
		System.out.println("afterClass, payment_1");
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}

}
