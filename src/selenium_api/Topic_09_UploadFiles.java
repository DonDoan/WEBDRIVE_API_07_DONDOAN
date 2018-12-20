package selenium_api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_UploadFiles {

	WebDriver driver;
	Common c1 = new Common();
	String RootFolder = System.getProperty("user.dir");
	String FileName01 = "01.png";
	String FileName02 = "02.png";
	String FileName03 = "03.png";
	String FilePath01 = RootFolder + "\\Upload\\" + FileName01;
	String FilePath02 = RootFolder + "\\Upload\\" + FileName02;
	String FilePath03 = RootFolder + "\\Upload\\" + FileName03;
	
	
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
	public void TC01_SigleUploadBySendkey() throws Exception {
//		Test Script 01: Upload file by sendkeys (multiple upload)
//		Step 01 - Truy cập vào trang: 
//		http://blueimp.github.com/jQuery-File-Upload/
		c1.open_page(driver, "http://blueimp.github.com/jQuery-File-Upload/");
//		Step 02 - Sử dụng phương thức sendKeys để upload file nhiều file cùng lúc chạy cho 3 trình duyệt (IE/ Firefox/ Chrome)
//		Upload 3 file:
//		Image01.png
//		Image02.png
//		Image03.png
//		WebElement AddFilesButton = driver.findElement(By.xpath("//input[@type='file']/preceding-sibling::span[contains(text(),'Add files')]"));
		WebElement AddFilesInput = driver.findElement(By.xpath("//input[@type='file']"));
//		c1.clickToElementByJS(driver, AddFiles);
		AddFilesInput.sendKeys(FilePath01);
		Thread.sleep(4000);
//		AddFilesInput.sendKeys(FilePath01 + "\n" + FilePath02 + "\n" + FilePath03);
//		Step 03 - Kiểm tra file đã được chọn thành công
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='01.png']")).isDisplayed());
//		Step 04 - Click Start button để upload cho cả 3 file
		c1.clickToElementByJS(driver, driver.findElement(By.xpath("//span[text()='Start']")));
//		Step 05 - Sau khi upload thành công verify cả 3 file đã được upload	
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='01.png']")).isDisplayed());
	}
	@Test
	public void TC02_MultiUploadBySendkey() throws Exception {
//		Test Script 01: Upload file by sendkeys (multiple upload)
//		Step 01 - Truy cập vào trang: 
//		http://blueimp.github.com/jQuery-File-Upload/
		c1.open_page(driver, "http://blueimp.github.com/jQuery-File-Upload/");
//		Step 02 - Sử dụng phương thức sendKeys để upload file nhiều file cùng lúc chạy cho 3 trình duyệt (IE/ Firefox/ Chrome)
//		Upload 3 file:
//		Image01.png
//		Image02.png
//		Image03.png
//		WebElement AddFilesButton = driver.findElement(By.xpath("//input[@type='file']/preceding-sibling::span[contains(text(),'Add files')]"));
		WebElement AddFilesInput = driver.findElement(By.xpath("//input[@type='file']"));
//		c1.clickToElementByJS(driver, AddFiles);
//		AddFilesInput.sendKeys(FilePath01);
		AddFilesInput.sendKeys(FilePath01 + "\n" + FilePath02 + "\n" + FilePath03);
		Thread.sleep(4000);
//		Step 03 - Kiểm tra file đã được chọn thành công
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='01.png']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='02.png']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='03.png']")).isDisplayed());
////		Step 04 - Click Start button để upload cho cả 3 file
		List<WebElement> StartButtons = driver.findElements(By.xpath("//table//button[@class='btn btn-primary start']"));
//		System.out.println(StartButtons);
		for (WebElement StartBtn : StartButtons) {
			System.out.println(StartBtn);
			c1.clickToElementByJS(driver, StartBtn);
//			StartBtn.click();
			Thread.sleep(4000);
		}
////		Step 05 - Sau khi upload thành công verify cả 3 file đã được upload	
//		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='01.png']")).isDisplayed());
//		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='02.png']")).isDisplayed());
//		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='03.png']")).isDisplayed());
	}
//
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
