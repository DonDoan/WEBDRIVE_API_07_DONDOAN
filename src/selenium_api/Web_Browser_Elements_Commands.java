package selenium_api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Web_Browser_Elements_Commands {
    WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// Khởi tạo browser:
		driver = new FirefoxDriver();
		
		// Set property trỏ đến file chromedriver
		// Dấu . = G:\PROJECT TRAINING ONLINE\Online_Class_07\WebDriverAPI - Bitbucket (root folder)
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_WebBrowser() {
		/*------- WEB BROWSER --------*/
		// Đóng tab mà nó đang active
		driver.close();

		// Đóng browser
		driver.quit(); /**/

		// Open Url
		driver.get("Url"); /**/

		// Get ra Url của page hiện tại
		String loginPageUrl = driver.getCurrentUrl(); /**/

		// Get ra source code của page hiện tại
		String homePageSource = driver.getPageSource();
		// Dùng kiểm tra 1 cách tương đối - perfomance chạy nhanh
		Assert.assertTrue(homePageSource.contains("SELENIUM WEBDRIVER FORM DEMO"));

		// Get ra title của page hiện tại
		String homePageTitle = driver.getTitle(); /**/
		Assert.assertEquals(homePageTitle, "SELENIUM WEBDRIVER FORM DEMO");

		/* Windows popup */
		// Get ra windows id của page hiện tại (GUID - Uniqe)
		String homePageID = driver.getWindowHandle(); /**/
		// b952bfd0-bf1a-4fc8-89f9-3065d146e225
		// Get ra tất cả windows id của tất cả các tab
		driver.getWindowHandles();

		/* WebdriverWait */
		// Wait cho element (findelement/ findelements)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); /**/

		// Wait cho page được load thành công
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Set timeout cho script
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

		// F11 - GUI
		driver.manage().window().fullscreen();

		// Phóng to browser ra hết cỡ
		driver.manage().window().maximize(); /**/

		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.manage().window().setPosition(new Point(300, 300));

		Dimension initial_size = driver.manage().window().getSize();
		int height = initial_size.getHeight();
		int width = initial_size.getWidth();

		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

		// Tracking history (back/ forward)
		driver.navigate().to("Url");

		// Alert/ iframe/ windows
		driver.switchTo().alert(); /**/

		driver.switchTo().frame(""); /**/
		driver.switchTo().defaultContent();

		driver.switchTo().window("GUID"); /**/

	}

	@Test
	public void TC_02_WebElement() {
		/*------- WEB ELEMENT --------*/
		// Cách 1: Action trực tiếp lên step (click/ sendkey/ getText/..)
		driver.findElement(By.id("email")).sendKeys("");

		// Cách 2: Dùng lại element này
		WebElement emailTextbox = driver.findElement(By.id("email"));
		emailTextbox.clear(); /**/
		emailTextbox.sendKeys(""); /**/
		emailTextbox.click(); /**/

		// Xóa data trước khi sendkey (textbox/ textarea/ dropdown)
		emailTextbox.clear();
		emailTextbox.sendKeys("Automation Testing");

		// Nếu ko tìm thấy element nào hết: throw exception và đánh fail testcase
		emailTextbox.findElement(By.xpath("//input[@id='password']"));

		List<WebElement> homePageLink = driver.findElements(By.xpath("//a"));
		// Thao tác vs element của List
		homePageLink.get(0).click(); /**/
		homePageLink.get(1).getText(); /**/

		int homePageNumber = homePageLink.size(); /**/

		// Nếu ko tìm thấy element nào hết: return list rỗng và chạy step tiếp theo chứ
		// ko đánh fail testcase

		/*
		 * <input id="email"
		 * class="input-text required-entry validate-email validation-failed"
		 * type="email" title="Email Address" value="" name="login[username]"
		 * spellcheck="false" autocorrect="off" autocapitalize="off"/>
		 */

		// Giá trị mình cần đang nằm trong 1 attribute của thẻ
		WebElement emailTxt = driver.findElement(By.xpath("//*[@name='name']"));
		String emailNameValue = emailTxt.getAttribute("value"); /**/
		// Automation Test

		// <td>Customer Name</td> -> nằm bên ngoài thẻ
		emailTxt.getText(); /**/

		// GUI
		String emailBackground = emailTxt.getCssValue("background-color");
		// #f89b51
		String emailFontSize = emailTxt.getCssValue("font-size");
		// 27px

		emailTxt.getLocation();
		emailTxt.getSize();

		String emailTagname = emailTxt.getTagName();
		// input

		// Dynamic locator
		// Element đầu tiên sẽ get ra phần tử cho element sau sử dụng

		// Kiểm tra 1 element có hiển thị ở trên page hay ko
		Assert.assertTrue(emailTxt.isDisplayed()); /**/

		// Kiểm tra 1 element có bị disabled ở trên page hay ko
		Assert.assertTrue(emailTxt.isEnabled()); /**/
		
		Assert.assertFalse(emailTxt.isEnabled()); /**/

		// Kiểm tra 1 element có được chọn thành công ở trên page hay ko (radio button/ checkbox - chỉ work vs thẻ input)
		Assert.assertTrue(emailTxt.isSelected()); /**/
		
		// Button/ checkbox/ radio/ link
		emailTxt.click();
		
		// Form search/ login/ register (ENTER)
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("111");
		driver.findElement(By.xpath("//input[@id='pass']")).submit();
		emailTxt.submit();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}