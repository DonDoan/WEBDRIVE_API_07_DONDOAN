package selenium_api;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
//import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Button_Checkbox_Alert {
	WebDriver driver;
	JavascriptExecutor javaExecutor;
	WebDriverWait waitExplicit;
	String url3 = "https://daominhdam.github.io/basic-form/index.html";
	By message1 = By.xpath("//p[@id='result']");

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
	public void TC01() throws Exception {
//		Common Common1 = new Common();
//			Test Script 01:
//			Step 01 - Truy cập vào trang: http://live.guru99.com/
		String url1 = "http://live.guru99.com/";
//		Common1.open_page(url1);
		open_page(url1);
		Thread.sleep(1000);
		By FooterMyaccount = By.xpath("//div[@class='footer']//a[text()='My Account']");
		WebElement Myaccount_element = driver.findElement(FooterMyaccount);
//			Step 02 - Click vào link My Account dưới footer (Sử dụng Javascript Executor code)
//		Common1.clickElementByJavascript(Myaccount_element);
		clickElementByJavascript(Myaccount_element);
//			Step 03 - Kiểm tra url của page sau khi click là: http://live.guru99.com/index.php/customer/account/login/
		Assert.assertTrue(driver.getCurrentUrl().equals("http://live.guru99.com/index.php/customer/account/login/"));
//			Step 04 - Click vào button CREATE AN ACCOUNT (Sử dụng Javascript Executor code)
		By CreateAnAcc = By.xpath("//span[text()='Create an Account']");
		WebElement CreateAnAccElement = driver.findElement(CreateAnAcc);
		clickElementByJavascript(CreateAnAccElement);
//			Step 06 - Kiểm tra url của page sau khi click là: http://live.guru99.com/index.php/customer/account/create/
		Assert.assertTrue(driver.getCurrentUrl().equals("http://live.guru99.com/index.php/customer/account/create/"));
	}

//	@Test
	public void TC02() throws Exception {
//			Test Script 02:
		String Kendo_url = "http://demos.telerik.com/kendo-ui/styling/checkboxes";
		Thread.sleep(1000);
//			Step 01 - Truy cập vào trang: http://demos.telerik.com/kendo-ui/styling/checkboxes
		open_page(Kendo_url);
//			Step 02 - Click vào checkbox: Dual-zone air conditioning (Thẻ input ko được sử dụng thuộc tính id)
		By DualzoneByButton = By.xpath("//label[contains(text(),'Dual')]/preceding-sibling::input");
		WebElement DualzoneByButtonElement = driver.findElement(DualzoneByButton);
		clickElementByJavascript(DualzoneByButtonElement);
//			Step 03 - Kiểm tra checkbox đó đã chọn
		Assert.assertTrue(DualzoneByButtonElement.isSelected());
//			Step 04 - Sau khi checkbox đã được chọn - deselect nó và kiểm tra nó chưa được chọn
		if (DualzoneByButtonElement.isSelected()) {
			clickElementByJavascript(DualzoneByButtonElement);
		}
		Assert.assertFalse(DualzoneByButtonElement.isSelected());
	}

//	@Test
	public void TC03() throws Exception {
//		Common Common1 = new Common();
//			Test Script 03:
//			Step 01 - Truy cập vào trang: http://demos.telerik.com/kendo-ui/styling/radios
		String Url2 = "http://demos.telerik.com/kendo-ui/styling/radios";
		open_page(Url2);
//		Common1.open_page(Url2);
//			Step 02 - Click vào radiobutton:  2.0 Petrol, 147kW (Thẻ input ko được sử dụng thuộc tính id)
		By Petrol2p0ByRadio = By.xpath("//label[contains(text(),'2.0 Petrol')]/preceding-sibling::input");
		By Petrol1p8ByRadio = By.xpath("//label[contains(text(),'1.8 Petrol')]/preceding-sibling::input");
		WebElement Petrol2p0ByRadioElement = driver.findElement(Petrol2p0ByRadio);
		WebElement Petrol1p8ByRadioElement = driver.findElement(Petrol1p8ByRadio);
		clickElementByJavascript(Petrol2p0ByRadioElement);
		Thread.sleep(1000);
//			Step 03 - Kiểm tra radio button đó đã chọn hay chưa/ nếu chưa chọn lại
		if (Petrol2p0ByRadioElement.isSelected()) {
			System.out.println("This element " + Petrol2p0ByRadioElement + " was selected.");
		} else {
			System.out.println("This element " + Petrol2p0ByRadioElement + " was not selected. Please re-select it...");
		}
		System.out.println("De-selecting it");
		clickElementByJavascript(Petrol1p8ByRadioElement);
		Assert.assertFalse(Petrol2p0ByRadioElement.isSelected());
	}

//	@Test
	public void TC04() throws Exception {
//			Test Script 04:
//			Step 01 - Truy cập vào trang: https://daominhdam.github.io/basic-form/index.html
		open_page(url3);
		By AlertByButton = By.xpath("//button[contains(text(),'Alert')]");
//			Step 02 - Click vào button: Click for JS Alert
		clickXpathByJavascript(AlertByButton);
//			Step 03 - Verify message hiển thị trong alert là: I am a JS Alert
		Alert alert1 = driver.switchTo().alert();
		String TextonAlert = alert1.getText();
		Assert.assertEquals(TextonAlert, "I am a JS Alert");
//			Step 04 - Accept alert và verify message hiển thị tại Result là:  You clicked an alert successfully
		alert1.accept();
		Assert.assertEquals(driver.findElement(message1).getText(), "You clicked an alert successfully");
	}

//	@Test
	public void TC05() throws Exception {
//			Test Script 05:
//			Step 01 - Truy cập vào trang: https://daominhdam.github.io/basic-form/index.html
		open_page(url3);
		By ConfirmByButton = By.xpath("//button[contains(text(),'Confirm')]");
//			Step 02 - Click vào button: Click for JS Confirm
		clickXpathByJavascript(ConfirmByButton);
//			Step 03 - Verify message hiển thị trong alert là: I am a JS Confirm
		Alert alert1 = driver.switchTo().alert();
		String TextonAlert = alert1.getText();
		Assert.assertEquals(TextonAlert, "I am a JS Confirm");
//			Step 04 - Cancel alert và verify message hiển thị tại Result là:  You clicked: Cancel
		alert1.dismiss();
		Assert.assertEquals(driver.findElement(message1).getText(), "You clicked: Cancel");
	}

	@Test
	public void TC06() throws Exception {
//			Test Script 06:
//			Step 01 - Truy cập vào trang: https://daominhdam.github.io/basic-form/index.html
//		Common Common1 = new Common();
//		Common1.open_page(url3);
//		Common1.A1();
//		open_page(url3);
//		By PromptByButton = By.xpath("//button[contains(text(),'Prompt')]");
////			Step 02 - Click vào button: Click for JS Prompt
//		clickXpathByJavascript(PromptByButton);
////			Step 03 - Verify message hiển thị trong alert là: I am a JS prompt
//		Alert alert2 = driver.switchTo().alert();
//		String TextonAlert2 = alert2.getText();
//		System.out.println(TextonAlert2);
//		Assert.assertEquals(TextonAlert2, "I am a JS prompt");
////			Step 04 - Nhập vào text bất kì (daominhdam) và verify message hiển thị tại Result là:  You entered: daominhdam
//		Thread.sleep(3000);
//		alert2.sendKeys("Don");
//		Thread.sleep(3000);
//		alert2.accept();
//		System.out.println(driver.findElement(message1).getText());
//		Assert.assertEquals(driver.findElement(message1).getText(), "You entered: Don");
	}

//	@Test
	public void TC07() throws Exception {
//			Test Script 07:
//		String url4 = "http://the-internet.herokuapp.com/basic_auth";
		String url4 = "http://admin:admin@the-internet.herokuapp.com/basic_auth/";
//			Step 01 - Truy cập vào trang: http://the-internet.herokuapp.com/basic_auth
		open_page(url4);
//		By Basic_Auth = By.xpath("//a[text()='Basic Auth']");
//		Thread.sleep(1000);
//		clickXpathByJavascript(Basic_Auth);
//			Step 02 - Handle authentication alert vs user/pass: admin/ admin
//		wait(driver, 5).until(EC.alert_is_present());
//		Alert alert_authen = driver.switchTo().alert();
//		System.out.println(alert_authen.getText());
//		alert_authen.sendKeys("admin" + Keys.TAB + "admin");
//		alert_authen.send_keys("admin" + Keys.TAB.toString() + "admin");
//		alert_authen.accept();
//		alert_authen.dismiss();
//			Step 03 - Verify message hiển thị sau khi login thành công:
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='example']/p")).getText(), "Congratulations! You must have the proper credentials.");
//					
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	// Sub Functions
	// Click By Xpath by javaScript
	public void clickXpathByJavascript(By a) {
		WebElement element = driver.findElement(a);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
	}

	// Click Element by javaScript
	public void clickElementByJavascript(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
	}

	// Open URL
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
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		System.out.println(generatedString);
	}

	public void selectItemInCustomDropDown(String ScrollToXpath, String parentXpath, String childXpath,
			String expectedItem) throws Exception {
		// Scroll to view element dropdown
		javaExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(ScrollToXpath)));
		// Click vào dropdown
		WebElement element = driver.findElement(By.xpath(parentXpath));
		element.click();
		Thread.sleep(1000);
		// Get tất cả item trong dropdown vào 1 list element (List <WebElement>)
		List<WebElement> childList = driver.findElements(By.xpath(childXpath));
		// Print out
		System.out.println(childList);
		// Wait để tất cả phần tử trong dropdown được hiển thị
		waitExplicit.until(ExpectedConditions.visibilityOfAllElements(childList));
		// Dùng vòng lặp for duyệt qua từng phần tử sau đó getText
		for (WebElement child : childList) {
			String textItem = child.getText().trim();
			System.out.println("Text in drop dow =" + textItem);
			// Nếu actual text = expected text thì click vào phần tử đó và break khỏi vòng
			// lặp
			if (textItem.equals(expectedItem)) {
				javaExecutor.executeScript("arguments[0].scrollIntoView(true);", child);
				child.click();
				break;
			}
		}
	}

	public void selectItemInCustomDropDown1(String parenXpath, String childXpath, String expectedItem) {
		// click vào dropdown
		WebElement element = driver.findElement(By.xpath(parenXpath));
		element.click();

		// Danh sách phần tử
		List<WebElement> childList = driver.findElements(By.xpath(childXpath));

		// Đợi hiển thị tất cả các phần tử
		waitExplicit.until(ExpectedConditions.visibilityOfAllElements(childList));

		for (WebElement child : childList) {

			String textItem = child.getText();
			System.out.println("Text in Dropdown = " + textItem);

			if (textItem.equals(expectedItem)) {
				child.click();
				break;
			}
		}
	}
	// End Sub Functions
}
