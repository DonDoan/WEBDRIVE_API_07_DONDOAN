package selenium_api;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
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
	Common common = new Common();

	@BeforeClass
	public void beforeClass() {

		// Chrome
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

//		Firefox
//		driver = new FirefoxDriver();
	}

//
//	@Test
	public void TC01_MouseHover() {
//		Test Script 01: Move mouse to element
//		Step 01 - Truy cập vào trang: http://www.myntra.com/
		common.open_page(driver, "http://www.myntra.com/");
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
//	@Test
	public void TC02_ClickAndHold() throws Exception {	
//		Test Script 02: Click and hold element - select multiple item
//		Step 01 - Truy cập vào trang: http://jqueryui.com/resources/demos/selectable/display-grid.html
		String jquery_url = "http://jqueryui.com/resources/demos/selectable/display-grid.html";
		common.open_page(driver, jquery_url);
//		Step 02 - Click and hold từ 1-> 4
		List<WebElement> ListItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		Actions moveItem = new Actions(driver);
		moveItem.clickAndHold(ListItems.get(0)).moveToElement(ListItems.get(3)).release().perform();
		Thread.sleep(5000);
//		Step 03 - Sau khi chọn kiểm tra rằng có đúng 4 phần tử đã được chọn thành công với xpath:
		List<WebElement> number_selected = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']"));
//		//li[@class='ui-state-default ui-selectee ui-selected']
		Assert.assertEquals(number_selected.size(), 4);
//		Click Randomly
		driver.navigate().refresh();
		List<WebElement> ListItems1 = driver.findElements(By.xpath("//ol[@id='selectable']/li"));		
		WebElement num1 = ListItems1.get(0);
		WebElement num3 = ListItems1.get(2);
		WebElement num5 = ListItems1.get(4);
		WebElement num7 = ListItems1.get(6);
		WebElement num9 = ListItems1.get(8);
		moveItem.keyDown(Keys.CONTROL).build().perform();
		num1.click();
		num3.click();
		num5.click();
		num7.click();
		num9.click();
		moveItem.keyUp(Keys.CONTROL).build().perform();
		List<WebElement> number5_selected = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']"));		
		Thread.sleep(5000);
		Assert.assertEquals(number5_selected.size(), 5);		
		
	}
//	@Test
	public void TC03_DoubleClick() throws Exception {	
//		Test Script 03: Double click
//		Step 01 - Truy cập vào trang: http://www.seleniumlearn.com/double-click
		common.open_page(driver, "http://www.seleniumlearn.com/double-click");
//		Step 02 - Double click vào element: Double-Click Me!
		WebElement DoubleClickMe = driver.findElement(By.xpath("//button[text()='Double-Click Me!']"));
		Actions action = new Actions(driver);
		action.doubleClick(DoubleClickMe).perform();
//		Step 03 - Verify text trong alert được hiển thị: 'The Button was double-clicked.'
		Alert Alert_Double_Click = driver.switchTo().alert();
//		Alert_Double_Click.getText().
		Assert.assertEquals(Alert_Double_Click.getText(), "The Button was double-clicked.");
//		Step 04 - Accept Javascript alert
		Alert_Double_Click.accept();
		Thread.sleep(5000);
	}
//	@Test
	public void TC04_RightClick() throws Exception {
//		Test Script 04: Right click to element
//		Step 01 - Truy cập vào trang: http://swisnl.github.io/jQuery-contextMenu/demo.html
		common.open_page(driver, "http://swisnl.github.io/jQuery-contextMenu/demo.html");
//		Step 02 - Right click vào element: right click me
		WebElement RightClickMe = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action = new Actions(driver);
		action.contextClick(RightClickMe).perform();
//		Step 03 - Hover chuột vào element: Quit
		WebElement Quit = driver.findElement(By.xpath("//span[text()='Quit']"));
		action.moveToElement(Quit).perform();
		Thread.sleep(3000);
//		Step 04 - Verify element Quit (visible + hover) với xpath:
//		//li[contains(@class,'context-menu-visible') and contains(@class,'context-menu-hover')]/span[text()='Quit']
		Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-visible') and contains(@class,'context-menu-hover')]/span[text()='Quit']")).isDisplayed());
//		Step 05 - Click chọn Quit
		Quit.click();
		Thread.sleep(2000);
//		Step 06 - Accept Javascript alert
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(2000);
		alert1.accept();
	}
	@Test
	public void TC05_DragAndDrop() {
//		Test Script 05: Drag and drop element
//		Step 01 - Truy cập vào trang: http://demos.telerik.com/kendo-ui/dragdrop/angular
		common.open_page(driver, "http://demos.telerik.com/kendo-ui/dragdrop/angular");
//		Step 02 - Kéo hình tròn nhỏ vào hình tròn lớn
		WebElement Source = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement Target = driver.findElement(By.xpath("//div[@id='droptarget']"));
		Actions DragDropAction = new Actions(driver);
		DragDropAction.dragAndDrop(Source, Target).build().perform();
//		Step 03 - Verify message đã thay đổi: You did great!
		Assert.assertEquals(Target.getText(), "You did great!");
	}
//	@Test
//	@Test
	public void TC_06_Drag_Drop_HTML5_Xpath() throws AWTException, Exception {
//		Test Script 06: Drag and drop HTML5
//		Step 01 - Truy cập vào trang: https://html5demos.com/drag/#
//		Step 02 - Sử dụng Javascript/ Jquery để kéo thả element: one/ two/ three/.. vào thùng rác
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

}
