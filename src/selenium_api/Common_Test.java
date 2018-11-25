package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Common_Test {
	// ====================================================================================================
//	WebDriver driver;
//	JavascriptExecutor javaExecutor;
	// Sub Functions
	public void A1() {
		System.out.print("DON");
	}
	//Open URL
	public void open_page(WebDriver driver, String a) {
		driver.get(a);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}