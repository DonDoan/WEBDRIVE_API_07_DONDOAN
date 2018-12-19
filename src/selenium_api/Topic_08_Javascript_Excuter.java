package selenium_api;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Javascript_Excuter {

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
	public void TC01_JavasriptExcuter() {
//		Test Script 01: Javascript Excecutor (JE)
//		Step 01 - Truy cập vào trang: http://live.guru99.com/
//		Step 02 - Sử dụng JE để get domain của page
//		Verify domain =  live.guru99.com
//		Step 03 - Sử dụng JE để get URL của page
//		Verify URL =  http://live.guru99.com/
//		Step 04 - Open MOBILE page (Sử dụng JE)
//		Step 05 - Add sản phẩm SAMSUNG GALAXY vào Cart (click vào ADD TO CART button bằng JE)
//		Hướng dẫn: sử dụng following-sibling
//		Step 06 - Verify message được hiển thị:  Samsung Galaxy was added to your shopping cart. (Sử dụng JE - Get innertext of the entire webpage )
//		Step 07 - Open PRIVACY POLICY page (Sử dụng JE)
//		Verify title của page = Privacy Policy (Sử dụng JE)
//		Step 08 - Srcoll xuống cuối page
//		Step 09 - Verify dữ liệu có hiển thị với chỉ 1 xpath: 
//		WISHLIST_CNT	The number of items in your Wishlist.
//		Hướng dẫn: sử dụng following-sibling
//		Step 10 - Navigate tới domain: http://demo.guru99.com/v4/  (Sử dụng JE)
//		Verify domain sau khi navigate = demo.guru99.com
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
	public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='6px groove red'", element);
    }

    public Object executeForBrowser(String javaSript) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript(javaSript);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public Object clickToElementByJS(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public Object sendkeyToElementByJS(WebElement element, String value) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public Object removeAttributeInDOM(WebElement element, String attribute) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public Object scrollToBottomPage() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public Object navigateToUrlByJS(String url) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("window.location = '" + url + "'");
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }	
	
}
