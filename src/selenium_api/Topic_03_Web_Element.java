package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Web_Element {
//========== Local Variables for this class ===========
	// declare an variable for url to open
	String url = "https://daominhdam.github.io/basic-form/index.html";
	// Set environment, browser to run testcases
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// Chrome
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

		// Firefox #
//		driver = new FirefoxDriver();

	}

//========== Catche of elenments by Xpath/Locators ===========
	By EmailByTextbox = By.xpath("//input[@type='email']");
	By PasswordByTextbox = By.xpath("//input[@type='password']");
	By AgeUnderDisabledByRadioButton = By
			.xpath("//label[text()='Checkbox is disabled']/preceding-sibling::input[@id='check-disbaled']");
	By AgeUnder18ByRadioButton = By.xpath(
			"//input[@name='user_age']/following-sibling::label[@for='over_18']/preceding-sibling::input[@id='under_18']");
	By AgeOver18ByRadioButton = By.xpath(
			"//input[@name='user_age']/following-sibling::label[@for='over_18']/preceding-sibling::input[@id='over_18']");
	By EducationlByTextarea = By.xpath("//textarea[@name='user_edu']");
	By BiographyByTextarea = By.xpath("//textarea[@name='user_bio']");
	By JobRole1ByDropdown = By.xpath("//select[@name='user_job1']");
	By JobRole2ByDropdown = By.xpath("//select[@name='user_job2']");
	By Slide1ByScroll = By.xpath("//input[@name='slider-1']");
	By Slide2ByScroll = By.xpath("//input[@name='slider-2']");
	By InterestsDevByCheckbox = By.xpath("//label[@for='development']/preceding-sibling::input[@type='checkbox']");
	By InterestsDisableByCheckbox = By
			.xpath("//label[text()='Checkbox is disabled']/preceding-sibling::input[@id='check-disbaled']");
	By ButtonIsEnabled = By.xpath("//label[@for='development']/preceding-sibling::input[@type='checkbox']");
	By ButtonIsDisabled = By.xpath("//button[@id='button-disabled']");

//====================================================================================================
//	Test Script 01: Kiểm tra phần tử hiển thị trên trang
	@Test
	public void TC01_chk_Elements_Displayed() {
		System.out.println("Start TC01_chk_Elements_Displayed...... ");
//		Step 01 - Truy cập vào trang: https://daominhdam.github.io/basic-form/index.html
		open_page(url);
//		Step 02 - Kiểm tra các phần tử sau hiển thị trên trang: Email/ Age (Under 18)/ Education
		Assert.assertTrue(isControlDisplayed(EmailByTextbox));
		Assert.assertTrue(isControlDisplayed(AgeUnder18ByRadioButton));
		Assert.assertTrue(isControlDisplayed(EducationlByTextarea));
//		Step 03 - Nếu có nhập giá trị: Automation Testing vào 2 field Email/ Education và chọn Age = Under 18	
		if (isControlDisplayed(EmailByTextbox)) {
			driver.findElement(EmailByTextbox).sendKeys("Automation Testing");
		}
		if (isControlDisplayed(AgeUnder18ByRadioButton)) {
			driver.findElement(AgeUnder18ByRadioButton).click();
		}
		if (isControlDisplayed(EducationlByTextarea)) {
			driver.findElement(EducationlByTextarea).sendKeys("Automation Testing");
		}
		System.out.println("End TC01_chk_Elements_Displayed...... ");
	}

//--------------------------------------------------------------
//	Test Script 02: Kiểm tra phần tử enable/ disable trên trang
	@Test
	public void TC02_chk_Elements_Enabled() {
		System.out.println("Start TC02_chk_Elements_Enabled...... ");
//		Step 01 - Truy cập vào trang: https://daominhdam.github.io/basic-form/index.html
		open_page(url);
//		Step 02 - Kiểm tra các phần tử sau enable trên trang: Email/ Age (Under 18)/ Education/ Job Role 01/ Interests (Development)/ Slider 01/ Button is enabled
		Assert.assertTrue(isControlEnabled(EmailByTextbox));
		Assert.assertTrue(isControlEnabled(AgeUnder18ByRadioButton));
		Assert.assertTrue(isControlEnabled(EducationlByTextarea));
		Assert.assertTrue(isControlEnabled(JobRole1ByDropdown));
		Assert.assertTrue(isControlEnabled(InterestsDevByCheckbox));
		Assert.assertTrue(isControlEnabled(Slide1ByScroll));
		Assert.assertTrue(isControlEnabled(ButtonIsEnabled));
//		Step 03 - Kiểm tra các phần tử sau disable trên trang: 
//		Password / Age (Radiobutton is disabled)/ Biography/ Job Role 02/ Interests (Checkbox is disabled)/ Slider 02/ Button is disabled
		Assert.assertFalse(isControlEnabled(PasswordByTextbox));
		Assert.assertFalse(isControlEnabled(AgeUnderDisabledByRadioButton));
		Assert.assertFalse(isControlEnabled(BiographyByTextarea));
		Assert.assertFalse(isControlEnabled(JobRole2ByDropdown));
		Assert.assertFalse(isControlEnabled(InterestsDisableByCheckbox));
		Assert.assertFalse(isControlEnabled(Slide2ByScroll));
		Assert.assertFalse(isControlEnabled(ButtonIsDisabled));
//		Step 04 - Nếu có in ra Element is enabled/ ngược lại Element is disabled		
		System.out.println("End TC02_chk_Elements_Enabled...... ");
	}

//	Test Script 03: Kiểm tra phần tử được chọn trên trang
	@Test
	public void TC03_chk_Elements_Selected() {
		System.out.println("Start TC03_chk_Elements_Selected...... ");
//		Step 01 - Truy cập vào trang: https://daominhdam.github.io/basic-form/index.html
		open_page(url);
//		Step 02 - Click chọn Age (Under 18)/ Interests (Development)
		if (isControlEnabled(AgeUnder18ByRadioButton)) {
			driver.findElement(AgeUnder18ByRadioButton).click();
		}
		if (isControlEnabled(InterestsDevByCheckbox)) {
			driver.findElement(InterestsDevByCheckbox).click();
		}
//		Step 03 - Kiểm tra các phần tử tại Step 02 đã được chọn
		System.out.println("Check elements are selected...... ");
		Assert.assertTrue(isControlSelected(AgeUnder18ByRadioButton));
		Assert.assertTrue(isControlSelected(InterestsDevByCheckbox));
//		Step 04 - Nếu chưa được chọn thì cho phép chọn lại 1 lần nữa	
		System.out.println("Check elements can be re-selected or not...... ");
		System.out.println("deselecting " + AgeUnder18ByRadioButton + "...... ");
		driver.findElement(AgeOver18ByRadioButton).click(); // click to select the other option
		Assert.assertFalse(isControlSelected(AgeUnder18ByRadioButton));
		System.out.println("re-selecting " + AgeUnder18ByRadioButton + "...... ");
		driver.findElement(AgeUnder18ByRadioButton).click(); // re-select
		Assert.assertTrue(isControlSelected(AgeUnder18ByRadioButton));

		System.out.println("deselecting " + InterestsDevByCheckbox + "...... ");
		driver.findElement(InterestsDevByCheckbox).click(); // click to deselect
		Assert.assertFalse(isControlSelected(InterestsDevByCheckbox));
		System.out.println("re-selecting " + InterestsDevByCheckbox + "...... ");
		driver.findElement(InterestsDevByCheckbox).click(); // re-select
		Assert.assertTrue(isControlSelected(InterestsDevByCheckbox));

		System.out.println("End TC03_chk_Elements_Selected...... ");
	}

//====================================================================================================
// quit testing
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

//====================================================================================================	
// Sub Functions	
	public void open_page(String a) {
		driver.get("https://daominhdam.github.io/basic-form/index.html");
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
//End Sub Functions		
}