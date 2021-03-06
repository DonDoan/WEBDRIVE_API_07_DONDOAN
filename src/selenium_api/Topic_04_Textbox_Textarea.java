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
	By EditCustomerID = By.xpath("//input[@name='cusid']");

	By CustomerNameByTextbox = By.xpath("//input[@name='name']");
	By DobByTd = By.xpath("//input[@name='dob']");
	By AddressByTextarea = By.xpath("//textarea[@name='addr']");
	By CityByTextbox = By.xpath("//input[@name='city']");
	By StateByTextbox = By.xpath("//input[@name='state']");
	By PinByTextbox = By.xpath("//input[@name='pinno']");
	By MobileNumberByTextbox = By.xpath("//input[@name='telephoneno']");
	By EmailByTextbox = By.xpath("//input[@name='emailid']");
	By SubmitButton = By.xpath("//input[@type='submit']");
	
	By RegisterdCustomerIDByTd = By.xpath("//td[text()='Customer ID']/following-sibling::td[1]");
	By RegisterdCustomerNameByTd = By.xpath("//td[text()='Customer Name']/following-sibling::td[1]");
	By RegisterdBodByTd = By.xpath("//td[text()='Birthdate']/following-sibling::td[1]");
	By RegisterdAddressByTd = By.xpath("//td[text()='Address']/following-sibling::td[1]");
	By RegisterdCityByTd = By.xpath("//td[text()='City']/following-sibling::td[1]");
	By RegisterdStateByTd = By.xpath("//td[text()='State']/following-sibling::td[1]");
	By RegisterdPinByTd = By.xpath("//td[text()='Pin']/following-sibling::td[1]");
	By RegisterdMobiNoByTd = By.xpath("//td[text()='Mobile No.']/following-sibling::td[1]");
	By RegisterdEmailByTd = By.xpath("//td[text()='Email']/following-sibling::td[1]");
	
//=============================================================
//========= Manage Input Data======== 
	private String NewCustomerName, NewDob, NewAdress, NewCity, NewState, NewPin, NewMobiNumber, NewEmail, NewPassword; 
	private String EditAdress, EditCity, EditState, EditPin, EditMobiNumber, EditEmail;

	
//===================================
	WebDriver driver;
	String CustomerID;

// BEFORE TEST - SET ENVIRONMENT=============================================================
	@BeforeClass
	public void beforeClass() {
		// Chrome
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
//========= Manage Input Data======== 		
		NewCustomerName = "Selenium DonDoan"; 
		NewDob =  "09252013";
//		NewDob =  "2010-01-02";
		NewAdress = "36 AnTrung 14"; 
		NewCity = "Da Nang"; 
		NewState = "Son Tra"; 
		NewPin = "123456"; 
		NewMobiNumber = "0123456789"; 
		NewEmail = "dondoan" + Random_Number() + "@gmail.com";
		NewPassword = "012345"; 
		
		EditAdress = "37 AnTrung 14"; 
		EditCity = "Tam Ky"; 
		EditState = "Nui Thanh"; 
		EditPin = "234567"; 
		EditMobiNumber = "0123456788"; 
		EditEmail = "dondoan" + Random_Number() + "@gmail.com";
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
		driver.findElement(CustomerNameByTextbox).sendKeys(NewCustomerName);
		driver.findElement(DobByTd).sendKeys(NewDob);
		driver.findElement(AddressByTextarea).sendKeys(NewAdress);
		driver.findElement(CityByTextbox).sendKeys(NewCity);
		driver.findElement(StateByTextbox).sendKeys(NewState);
		driver.findElement(PinByTextbox).sendKeys(NewPin);
		driver.findElement(MobileNumberByTextbox).sendKeys(NewMobiNumber);
		driver.findElement(EmailByTextbox).sendKeys(NewEmail);
		driver.findElement(PasswordByTextbox).sendKeys(NewPassword);
		driver.findElement(SubmitButton).click();
		//			Step 05 - Sau khi hệ thống tạo mới Customer thành công > Get ra thông tin của Customer ID
//			Sử dụng xpath với following-sibling::td
		CustomerID = driver.findElement(RegisterdCustomerIDByTd).getText();
		System.out.println("Customer ID have just created is " + CustomerID);
//			Step 06 - Verify tất cả thông tin được tạo mới thành công
		Assert.assertEquals(driver.findElement(RegisterdCustomerNameByTd).getText(), NewCustomerName);
		System.out.println("Date of birth was inputed as expected : " + NewDob);
		System.out.println("Date of birth was inputed actually : " + driver.findElement(RegisterdBodByTd).getText());
//		Assert.assertEquals(driver.findElement(RegisterdBodByTd).getText(), NewDob);
		Assert.assertEquals(driver.findElement(RegisterdAddressByTd).getText(), NewAdress);
		Assert.assertEquals(driver.findElement(RegisterdCityByTd).getText(), NewCity);
		Assert.assertEquals(driver.findElement(RegisterdStateByTd).getText(), NewState);
		Assert.assertEquals(driver.findElement(RegisterdPinByTd).getText(), NewPin);
		Assert.assertEquals(driver.findElement(RegisterdMobiNoByTd).getText(), NewMobiNumber);
		Assert.assertEquals(driver.findElement(RegisterdEmailByTd).getText(), NewEmail);
	}

	@Test
	public void TC02_EditCustomer() {

//			Step 07 - Chọn menu Edit Customer > Nhập Customer ID > Submit
		driver.findElement(MenuEditCustomer).click();		
		driver.findElement(EditCustomerID).sendKeys(CustomerID);
		driver.findElement(SubmitButton).click();
//			Step 08 - Tại màn hình Edit Customer:
//			Verify giá trị tại 2 field: Customer Name và Address đúng với dữ liệu khi tạo mới New Customer tại Step 04
//		System.out.println("NewCustomerName is " + driver.findElement(CustomerNameByTextbox).getAttribute("value"));
//		System.out.println("NewCustomerName is " + NewCustomerName);
		Assert.assertEquals(driver.findElement(CustomerNameByTextbox).getAttribute("value"), NewCustomerName);
		Assert.assertEquals(driver.findElement(RegisterdAddressByTd).getText(), NewAdress);
//			Step 09 - Nhập giá trị mới tại tất cả các field (ngoại trừ những field bị disable) > Submit
		driver.findElement(AddressByTextarea).clear();
		driver.findElement(CityByTextbox).clear();
		driver.findElement(StateByTextbox).clear();
		driver.findElement(PinByTextbox).clear();
		driver.findElement(MobileNumberByTextbox).clear();
		driver.findElement(EmailByTextbox).clear();
		
		driver.findElement(AddressByTextarea).sendKeys(EditAdress);
		driver.findElement(CityByTextbox).sendKeys(EditCity);
		driver.findElement(StateByTextbox).sendKeys(EditState);
		driver.findElement(PinByTextbox).sendKeys(EditPin);
		driver.findElement(MobileNumberByTextbox).sendKeys(EditMobiNumber);
		driver.findElement(EmailByTextbox).sendKeys(EditEmail);
		driver.findElement(SubmitButton).click();		
//			Step 10 - Verify giá trị tất cả các field đúng với dữ liệu sau khi đã Edit thành công	
		Assert.assertEquals(driver.findElement(RegisterdCustomerNameByTd).getText(), NewCustomerName);
		System.out.println("Date of birth was inputed as expected : " + NewDob);
		System.out.println("Date of birth was inputed actually : " + driver.findElement(RegisterdBodByTd).getText());		
//		Assert.assertEquals(driver.findElement(RegisterdBodByTd).getText(), NewDob);
		Assert.assertEquals(driver.findElement(RegisterdAddressByTd).getText(), EditAdress);
		Assert.assertEquals(driver.findElement(RegisterdCityByTd).getText(), EditCity);
		Assert.assertEquals(driver.findElement(RegisterdStateByTd).getText(), EditState);
		Assert.assertEquals(driver.findElement(RegisterdPinByTd).getText(), EditPin);
		Assert.assertEquals(driver.findElement(RegisterdMobiNoByTd).getText(), EditMobiNumber);
		Assert.assertEquals(driver.findElement(RegisterdEmailByTd).getText(), EditEmail);		
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
//	public void Random_String() {
//		  
//	    int leftLimit = 97; // letter 'a'
//	    int rightLimit = 122; // letter 'z'
//	    int targetStringLength = 10;
//	    Random random = new Random();
//	    StringBuilder buffer = new StringBuilder(targetStringLength);
//	    for (int i = 0; i < targetStringLength; i++) {
//	        int randomLimitedInt = leftLimit + (int) 
//	          (random.nextFloat() * (rightLimit - leftLimit + 1));
//	        buffer.append((char) randomLimitedInt);
//	    }
//	    String generatedString = buffer.toString();
//	 
//	    System.out.println(generatedString);
//	}	
// End Sub Functions
}
