package selenium_api;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_UserInteraction {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		// Chrome
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

//		Firefox
//		driver = new FirefoxDriver();
	}

//
	@Test
	public void TC01_MouseHover() {
//		Test Script 01: Move mouse to element
//		Step 01 - Truy cập vào trang: http://www.myntra.com/
		open_page("http://www.myntra.com/");
//		Step 02 - Hover chuột vào Menu để login
		By IconMenuBy = By.xpath("//div[@class='desktop-userIconsContainer']");
		WebElement IconMenu = driver.findElement(IconMenuBy);
		Actions action = new Actions(driver);
		action.moveToElement(IconMenu).perform();
//		Step 03 - Chọn Login button
		By LoginBy = By.xpath("//a[text()='login']");
		WebElement Login = driver.findElement(LoginBy);
		Login.click();
//		Step 04 - Verify Login form được hiển thị
		By LoginTitleBy = By.xpath("//p[text()='Login to Myntra']");
		WebElement LoginTitle = driver.findElement(LoginTitleBy);
		Assert.assertTrue(LoginTitle.isDisplayed());
	}		
//		Test Script 02: Click and hold element - select multiple item
//		Step 01 - Truy cập vào trang: http://jqueryui.com/resources/demos/selectable/display-grid.html
//		Step 02 - Click and hold từ 1-> 4
//		Step 03 - Sau khi chọn kiểm tra rằng có đúng 4 phần tử đã được chọn thành công với xpath:
//		//li[@class='ui-state-default ui-selectee ui-selected']
//
//		Test Script 03: Double click
//		Step 01 - Truy cập vào trang: http://www.seleniumlearn.com/double-click
//		Step 02 - Double click vào element: Double-Click Me!
//		Step 03 - Verify text trong alert được hiển thị: 'The Button was double-clicked.'
//		Step 04 - Accept Javascript alert
//
//		Test Script 04: Right click to element
//		Step 01 - Truy cập vào trang: http://swisnl.github.io/jQuery-contextMenu/demo.html
//		Step 02 - Right click vào element: right click me
//		Step 03 - Hover chuột vào element: Quit
//		Step 04 - Verify element Quit (visible + hover) với xpath:
//		//li[contains(@class,'context-menu-visible') and contains(@class,'context-menu-hover')]/span[text()='Quit']
//
//		Step 05 - Click chọn Quit
//		Step 06 - Accept Javascript alert
//
//		Test Script 05: Drag and drop element
//		Step 01 - Truy cập vào trang: http://demos.telerik.com/kendo-ui/dragdrop/angular
//		Step 02 - Kéo hình tròn nhỏ vào hình tròn lớn
//		Step 03 - Verify message đã thay đổi: You did great!
//
//		Test Script 06: Drag and drop HTML5
//		Step 01 - Truy cập vào trang: https://html5demos.com/drag/#
//		Step 02 - Sử dụng Javascript/ Jquery để kéo thả element: one/ two/ three/.. vào thùng rác		


//	@Test
	public void TC_07_Drag_Drop_HTML5_Xpath() throws AWTException, Exception {
		driver.get("https://html5demos.com/drag/");

		String oneXpath = "//a[@id='one']";
		String targetXpath = "//div[@id='bin']";

		drag_the_and_drop_html5_by_xpath(oneXpath, targetXpath);

		Thread.sleep(2000);
	}

	public void drag_the_and_drop_html5_by_xpath(String sourceLocator, String targetLocator) throws AWTException {

		WebElement source = driver.findElement(By.xpath(sourceLocator));
		WebElement target = driver.findElement(By.xpath(targetLocator));

		// Setup robot
		Robot robot = new Robot();
		robot.setAutoDelay(500);

		// Get size of elements
		Dimension sourceSize = source.getSize();
		Dimension targetSize = target.getSize();

		// Get center distance
		int xCentreSource = sourceSize.width / 2;
		int yCentreSource = sourceSize.height / 2;
		int xCentreTarget = targetSize.width / 2;
		int yCentreTarget = targetSize.height / 2;

		Point sourceLocation = source.getLocation();
		Point targetLocation = target.getLocation();
		System.out.println(sourceLocation.toString());
		System.out.println(targetLocation.toString());

		// Make Mouse coordinate center of element
		sourceLocation.x += 0 + xCentreSource;
		sourceLocation.y += 70 + yCentreSource;
		targetLocation.x += 0 + xCentreTarget;
		targetLocation.y += 70 + yCentreTarget;

		System.out.println(sourceLocation.toString());
		System.out.println(targetLocation.toString());

		// Move mouse to drag from location
		robot.mouseMove(sourceLocation.x, sourceLocation.y);

		// Click and drag
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x,
				((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

		// Move to final position
		robot.mouseMove(targetLocation.x, targetLocation.y);

		// Drop
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

//
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	// Open URL
	public void open_page(String a) {
		driver.get(a);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
