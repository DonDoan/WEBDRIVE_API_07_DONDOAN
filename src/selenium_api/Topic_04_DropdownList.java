package selenium_api;

import java.util.List;
//import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_DropdownList {

//	String HomePageUrl = "http://demo.guru99.com/v4";
//========== Catche of elenments by Xpath/Locators ===========

//=============================================================

//===================================
	WebDriver driver;
	String CustomerID;
	WebDriverWait waitExplicit;
	JavascriptExecutor javaExecutor;

// BEFORE TEST - SET ENVIRONMENT=============================================================
	@BeforeClass
	public void beforeClass() {
		// Chrome
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		waitExplicit = new WebDriverWait(driver, 30);
		javaExecutor = (JavascriptExecutor) driver;
	}

	// Firefox
//		driver = new FirefoxDriver();

// TESTCASES=============================================================
	public void TC_01_HTMLDropDownList() throws Exception {
//			Step 01 - Truy cập vào trang: https://daominhdam.github.io/basic-form/index.html
		String url1 = "https://daominhdam.github.io/basic-form/index.html";
		open_page(url1);
//			Step 02 - Kiểm tra dropdown Job Role 01 không hỗ trợ thuộc tính multi-select
		By Jobrole1ByDropdown = By.xpath("//select[@name='user_job1']");
		Select select1 = new Select(driver.findElement(Jobrole1ByDropdown));
		Assert.assertFalse(select1.isMultiple());
//			Step 03 - Chọn giá trị Automation Tester trong dropdown bằng phương thức selectVisible
		select1.selectByVisibleText("Automation Tester");
//			Step 04 - Kiểm tra giá trị đã được chọn thành công
		String chosen_value1 = select1.getFirstSelectedOption().getText();
		Assert.assertEquals(chosen_value1, "Automation Tester");
		Thread.sleep(1000);
//			Step 05 - Chọn giá trị Manual Tester trong dropdown bằng phương thức selectValue
		select1.selectByValue("manual");
//			Step 06 - Kiểm tra giá trị đã được chọn thành công
		String chosen_value2 = select1.getFirstSelectedOption().getText();
		Assert.assertEquals(chosen_value2, "Manual Tester");	
		Thread.sleep(1000);
//			Step 07 - Chọn giá trị Mobile Tester trong dropdown bằng phương thức selectIndex
		select1.selectByIndex(3);
//			Step 08 - Kiểm tra giá trị đã được chọn thành công
		String chosen_value3 = select1.getFirstSelectedOption().getText();
		Assert.assertEquals(chosen_value3, "Mobile Tester");	
		Thread.sleep(1000);			
//			Step 09 - Kiểm tra dropdown có đủ 5 giá trị		
		Assert.assertEquals(select1.getOptions().size(), 5);
	}

//	@Test
	public void TC_02_HandleCustomDropDownList() throws Exception {
		// Jquery
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");

		selectItemInCustomDropDown("//span[@id='number-button']",
				"//ul[@id = 'number-menu']/li[@class='ui-menu-item']/div", "19");
		Assert.assertTrue(driver
				.findElement(
						By.xpath("//span[@id ='number-button']/span[@class= 'ui-selectmenu-text' and text() ='19'] "))
				.isDisplayed());
		Thread.sleep(2000);

		selectItemInCustomDropDown("//span[@id='number-button']",
				"//ul[@id = 'number-menu']/li[@class='ui-menu-item']/div", "15");
		Assert.assertTrue(driver
				.findElement(
						By.xpath("//span[@id ='number-button']/span[@class= 'ui-selectmenu-text' and text() ='15'] "))
				.isDisplayed());
		Thread.sleep(2000);

		selectItemInCustomDropDown("//span[@id='number-button']",
				"//ul[@id = 'number-menu']/li[@class='ui-menu-item']/div", "4");
		Assert.assertTrue(driver
				.findElement(
						By.xpath("//span[@id ='number-button']/span[@class= 'ui-selectmenu-text' and text() ='4'] "))
				.isDisplayed());
		Thread.sleep(2000);

		// Kendo-ui
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/index");

		selectItemInCustomDropDown("//span[@aria-owns= 'color_listbox']", "//ul[@id ='color_listbox']/li", "Orange");
		Assert.assertTrue(driver
				.findElement(
						By.xpath("//span[@aria-owns= 'color_listbox']//span[@class = 'k-input' and text() = 'Orange']"))
				.isDisplayed());
		Thread.sleep(2000);

		selectItemInCustomDropDown("//span[@aria-owns= 'color_listbox']", "//ul[@id ='color_listbox']/li", "Grey");
		Assert.assertTrue(driver
				.findElement(
						By.xpath("//span[@aria-owns= 'color_listbox']//span[@class = 'k-input' and text() = 'Grey']"))
				.isDisplayed());
		Thread.sleep(2000);

		selectItemInCustomDropDown("//span[@aria-owns= 'color_listbox']", "//ul[@id ='color_listbox']/li", "Black");
		Assert.assertTrue(driver
				.findElement(
						By.xpath("//span[@aria-owns= 'color_listbox']//span[@class = 'k-input' and text() = 'Black']"))
				.isDisplayed());
		Thread.sleep(2000);

	}

	public void selectItemInCustomDropDown(String parentXpath, String childXpath, String expectedItem) {
		// Click vào dropdown
		WebElement element = driver.findElement(By.xpath(parentXpath));
		javaExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		// Get tất cả item trong dropdown vào 1 list element (List <WebElement>)
		List<WebElement> childList = driver.findElements(By.xpath(childXpath));
		// Wait để tất cả phần tử trong dropdown được hiển thị
		waitExplicit.until(ExpectedConditions.visibilityOfAllElements(childList));
		// Dùng vòng lặp for duyệt qua từng phần tử sau đó getText
		for (WebElement child : childList) {
			String textItem = child.getText();
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
// End Sub Functions
}
