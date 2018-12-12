package selenium_api;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_WindowPopup {

	WebDriver driver;
	Common c1 = new Common();

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
	public void TC01_Window() {
//			Step 01 - Truy cập vào trang: https://daominhdam.github.io/basic-form/index.html
		c1.open_page(driver, "https://daominhdam.github.io/basic-form/index.html");
//			Step 02 - Click "Opening a new window: Click Here" link -> Switch qua tab mới
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		String parent_wd = driver.getWindowHandle();
		switchToChildWindowByID(parent_wd);
		System.out.println(parent_wd);
//			Step 03 - Kiểm tra title của window mới = Google
		String title_ChildWindow = driver.getTitle();
		System.out.println(title_ChildWindow);
//		Assert.assertEquals(title_ChildWindow, "Google");
//			Step 04 - Close window mới
		closeAllExceptForParentWindows(parent_wd);
//			Step 05 - Switch về parent window
		System.out.println(parent_wd);
		driver.switchTo().window(parent_wd);
//			Step 06 - Kiểm tra đã quay về parent window thành công (title/ url)	
		Assert.assertEquals(driver.getCurrentUrl(), "https://daominhdam.github.io/basic-form/index.html");
//
	}

//
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

//	Switch to child Windows (only 2 windows)
	public void switchToChildWindowByID(String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

//    Switch to child Windows (greater than 2 windows and title of the pages are unique)
	public void switchToWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

//    Close all windows except for parent window
	public boolean closeAllExceptForParentWindows(String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}
}
