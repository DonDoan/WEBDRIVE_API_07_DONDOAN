package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_UploadFiles {

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
	public void TC01_UploadBySendkey() {
//		Test Script 01: Upload file by sendkeys (multiple upload)
//		Step 01 - Truy cập vào trang: 
//		http://blueimp.github.com/jQuery-File-Upload/
		c1.open_page(driver, "http://blueimp.github.com/jQuery-File-Upload/");
//		Step 02 - Sử dụng phương thức sendKeys để upload file nhiều file cùng lúc chạy cho 3 trình duyệt (IE/ Firefox/ Chrome)
//		Upload 3 file:
//		Image01.png
//		Image02.png
//		Image03.png
//		Step 03 - Kiểm tra file đã được chọn thành công
//		Step 04 - Click Start button để upload cho cả 3 file
//		Step 05 - Sau khi upload thành công verify cả 3 file đã được upload		
	}
//
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
