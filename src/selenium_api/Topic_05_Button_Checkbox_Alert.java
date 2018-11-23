package selenium_api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Button_Checkbox_Alert {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		
		
		//Chrome
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		Firefox
//		driver = new FirefoxDriver();
	}
//
	@Test
	public void f() {
//			Test Script 01:
//			Step 01 - Truy cập vào trang: http://live.guru99.com/
//			Step 02 - Click vào link My Account dưới footer (Sử dụng Javascript Executor code)
//			Step 03 - Kiểm tra url của page sau khi click là: http://live.guru99.com/index.php/customer/account/login/
//			Step 04 - Click vào button CREATE AN ACCOUNT (Sử dụng Javascript Executor code)
//			Step 06 - Kiểm tra url của page sau khi click là: http://live.guru99.com/index.php/customer/account/create/
//			Reference:
//			public void clickElementByJavascript(WebElement element) {
//			    JavascriptExecutor je = (JavascriptExecutor) driver;
//			    je.executeScript("arguments[0].click();", element);
//			}
//
//			Test Script 02:
//			Step 01 - Truy cập vào trang: http://demos.telerik.com/kendo-ui/styling/checkboxes
//			Step 02 - Click vào checkbox: Dual-zone air conditioning (Thẻ input ko được sử dụng thuộc tính id)
//			Step 03 - Kiểm tra checkbox đó đã chọn
//			Step 04 - Sau khi checkbox đã được chọn - deselect nó và kiểm tra nó chưa được chọn
//
//			Test Script 03:
//			Step 01 - Truy cập vào trang: http://demos.telerik.com/kendo-ui/styling/radios
//			Step 02 - Click vào radiobutton:  2.0 Petrol, 147kW (Thẻ input ko được sử dụng thuộc tính id)
//			Step 03 - Kiểm tra radio button đó đã chọn hay chưa/ nếu chưa chọn lại
//
//			Test Script 04:
//			Step 01 - Truy cập vào trang: https://daominhdam.github.io/basic-form/index.html
//			Step 02 - Click vào button: Click for JS Alert
//			Step 03 - Verify message hiển thị trong alert là: I am a JS Alert
//			Step 04 - Accept alert và verify message hiển thị tại Result là:  You clicked an alert successfully
//
//			Test Script 05:
//			Step 01 - Truy cập vào trang: https://daominhdam.github.io/basic-form/index.html
//			Step 02 - Click vào button: Click for JS Confirm
//			Step 03 - Verify message hiển thị trong alert là: I am a JS Confirm
//			Step 04 - Cancel alert và verify message hiển thị tại Result là:  You clicked: Cancel
//
//			Test Script 06:
//			Step 01 - Truy cập vào trang: https://daominhdam.github.io/basic-form/index.html
//			Step 02 - Click vào button: Click for JS Prompt
//			Step 03 - Verify message hiển thị trong alert là: I am a JS prompt
//			Step 04 - Nhập vào text bất kì (daominhdam) và verify message hiển thị tại Result là:  You entered: daominhdam
//
//			Test Script 07:
//			Step 01 - Truy cập vào trang: http://the-internet.herokuapp.com/basic_auth
//			Step 02 - Handle authentication alert vs user/pass: admin/ admin
//			Step 03 - Verify message hiển thị sau khi login thành công:
//			Congratulations! You must have the proper credentials.		
	}
//
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
