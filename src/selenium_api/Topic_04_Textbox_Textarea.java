package selenium_api;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Textbox_Textarea {
	String HomePageUrl = "http://demo.guru99.com/v4";
	String User = "mngr161493";
	String Pass = "harErAh";
//========== Catche of elenments by Xpath/Locators ===========
	By UserIDByTextbox = By.xpath("//input[@name='uid']");	
	By PasswordByTextbox = By.xpath("//input[@name='password']");
	By LoginButton = By.xpath("//input[@name='btnLogin']");
	By WelcomeLine = By.xpath("//marquee[contains(text(),'Welcome')]");
	By MenuNewCustomer = By.xpath("//a[text()='New Customer']");
	By MenuEditCustomer = By.xpath("//a[text()='Edit Customer']");

//=============================================================
//========= Manage Input Data======== 

//===================================
	WebDriver driver;

// BEFORE TEST - SET ENVIRONMENT=============================================================
	@BeforeClass
	public void beforeClass() {
		// Chrome
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	// Firefox
//		driver = new FirefoxDriver();
	
// TESTCASES=============================================================
	@Test
	public void TC01_NewCustomer() {
//			Step 01 - Access vào trang: http://demo.guru99.com/v4
		open_page(HomePageUrl);
//			Step 02 - Đăng nhập với thông tin: User = mngr161493 | Pass = harErAh
		driver.findElement(UserIDByTextbox).sendKeys(User);
		driver.findElement(PasswordByTextbox).sendKeys(Pass);
		driver.findElement(LoginButton).click();
//			Verify HomePage được hiển thị thành công
		Assert.assertTrue(isControlDisplayed(WelcomeLine));	
//			Note: Manual test để lấy thông tin User/Pass nếu hết hạn - User chỉ tồn tại trong 20 ngày - http://demo.guru99.com/
//			Step 03 - Chọn menu New Customer
		driver.findElement(MenuNewCustomer).click();
//			Step 04 - Nhập toàn bộ dữ liệu đúng > Click Submit
		
//			Step 05 - Sau khi hệ thống tạo mới Customer thành công > Get ra thông tin của Customer ID
//			Sử dụng xpath với following-sibling::td
//			Step 06 - Verify tất cả thông tin được tạo mới thành công

	}

	@Test
	public void TC02_EditCustomer() {

//			Step 07 - Chọn menu Edit Customer > Nhập Customer ID > Submit
//			Step 08 - Tại màn hình Edit Customer:
//			Verify giá trị tại 2 field: Customer Name và Address đúng với dữ liệu khi tạo mới New Customer tại Step 04
//			Step 09 - Nhập giá trị mới tại tất cả các field (ngoại trừ những field bị disable) > Submit
//			Step 10 - Verify giá trị tất cả các field đúng với dữ liệu sau khi đã Edit thành công		
	}

//
// ====================================================================================================
// QUIT TESTING  =================================================================
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

// ====================================================================================================
// Sub Functions
	public void open_page(String a) {
		driver.get(a);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
// Control Displayed for elements
	public boolean isControlDisplayed(By by) {
		WebElement elements = driver.findElement(by);
		if (elements.isDisplayed()) {
			System.out.println("element " + by + " is displayed");
			return true;
		} else {
			System.out.println("element " + by + " is not displayed");
			return false;
		}
	}

// Control Enabled for elements
	public boolean isControlEnabled(By by) {
		WebElement elements = driver.findElement(by);
		if (elements.isEnabled()) {
			System.out.println("element " + by + " is enabled");
			return true;
		} else {
			System.out.println("element " + by + " is disabled");
			return false;
		}
	}

// Control Selected for elements
	public boolean isControlSelected(By by) {
		WebElement elements = driver.findElement(by);
		if (elements.isSelected()) {
			System.out.println("element " + by + " is selected");
			return true;
		} else {
			System.out.println("element " + by + " is not selected");
			return false;
		}
	}
// Random	
	public int Random_Number() {
		Random random = new Random();
		int random_num = random.nextInt(999);
		System.out.println("Random number is " + random_num);
		return random_num;
	}	
	public void Random_String() {
		  
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    System.out.println(generatedString);
	}	
// End Sub Functions
}
