package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 {

	WebDriver driver;
	Common c1 = new Common();
	@BeforeClass
	public void beforeClass() {
		
		
		//Chrome
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		Firefox
//		driver = new FirefoxDriver();
//		driver.get("https://www.youtube.com/watch?v=jf-q_dG8WzI");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
//
	@Test
	public void TC01 () throws Exception {
		c1.open_page(driver, "https://www.youtube.com/watch?v=jf-q_dG8WzI");
		WebElement Login = driver.findElement(By.xpath("//yt-formatted-string[text()='Đăng nhập']"));
		c1.clickToElementByJS(driver, Login);
		Thread.sleep(1000);
		WebElement EmailPhone = driver.findElement(By.xpath("//input[@aria-label='Email hoặc điện thoại']"));
		EmailPhone.sendKeys("nonghaisanfresh@gmail.com");
		Thread.sleep(1000);
		String Password = "n0n9haisanfr3sh";
		WebElement Pw = driver.findElement(By.xpath("//input[@aria-label='Nhập mật khẩu của bạn']"));
		Pw.sendKeys(Password);
		Thread.sleep(1000);
		WebElement Continue = driver.findElement(By.xpath("//span[text()='Tiếp theo']"));
		c1.clickToElementByJS(driver, Continue);
		Thread.sleep(2000);
		String homePageTitle = driver.getTitle();
		System.out.println("HOME PAGE TITLE IS " + homePageTitle);
		Thread.sleep(2000);
//		WebElement LikedButton = driver.findElement(By.xpath("//div[@id='menu']//button[contains(@aria-label,'khác thích video này')]/yt-icon[@class='style-scope ytd-toggle-button-renderer']"));
//		c1.clickToElementByJS(driver, LikedButton);
//		LikedButton.click();
//		Thread.sleep(2000);
		
	}
//	@Test
	public void TC02 () throws Exception {
		c1.open_page(driver, "https://www.youtube.com/watch?v=jf-q_dG8WzI");
		WebElement Login = driver.findElement(By.xpath("//yt-formatted-string[text()='Đăng nhập']"));
		c1.clickToElementByJS(driver, Login);
		Thread.sleep(1000);
		WebElement EmailPhone = driver.findElement(By.xpath("//input[@aria-label='Email hoặc điện thoại']"));
		EmailPhone.sendKeys("nonghaisanfresh@gmail.com");
		Thread.sleep(1000);
		String Password = "n0n9haisanfr3sh";
		WebElement Pw = driver.findElement(By.xpath("//input[@aria-label='Nhập mật khẩu của bạn']"));
		Pw.sendKeys(Password);
		Thread.sleep(1000);
		WebElement Continue = driver.findElement(By.xpath("//span[text()='Tiếp theo']"));
		c1.clickToElementByJS(driver, Continue);
		Thread.sleep(2000);
		String homePageTitle = driver.getTitle();
		System.out.println("HOME PAGE TITLE IS " + homePageTitle);
		Thread.sleep(2000);
//		WebElement LikedButton = driver.findElement(By.xpath("//div[@id='menu']//button[contains(@aria-label,'khác thích video này')]/yt-icon[@class='style-scope ytd-toggle-button-renderer']"));
//		c1.clickToElementByJS(driver, LikedButton);
//		LikedButton.click();
//		Thread.sleep(2000);
		
	}
//
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
