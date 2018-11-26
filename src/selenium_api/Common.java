package selenium_api;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
	// ====================================================================================================
	WebDriver driver;
	JavascriptExecutor javaExecutor;
	WebDriverWait waitExplicit;
	// Sub Functions
	//Click Element by javaScript
	public void clickElementByJavascript(JavascriptExecutor javaExecutor, WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
	}
	//Click Element by javaScript
	public void A1() {
		System.out.print("DON");
	}
	//Open URL
	public void open_page(WebDriver driver, String a) {
		driver.get(a);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// Control Displayed for elements
	public boolean isControlDisplayed(WebDriver driver, By by) {
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
	public boolean isControlEnabled(WebDriver driver, By by) {
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
	public boolean isControlSelected(WebDriver driver, By by) {
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
//		public void Random_String() {
//			  
//		    int leftLimit = 97; // letter 'a'
//		    int rightLimit = 122; // letter 'z'
//		    int targetStringLength = 10;
//		    Random random = new Random();
//		    StringBuilder buffer = new StringBuilder(targetStringLength);
//		    for (int i = 0; i < targetStringLength; i++) {
//		        int randomLimitedInt = leftLimit + (int) 
//		          (random.nextFloat() * (rightLimit - leftLimit + 1));
//		        buffer.append((char) randomLimitedInt);
//		    }
//		    String generatedString = buffer.toString();
//		 
//		    System.out.println(generatedString);
//		}	
	public void selectItemInCustomDropDown(JavascriptExecutor javaExecutor, WebDriverWait waitExplicit, WebDriver driver, String ScrollToXpath, String parentXpath, String childXpath, String expectedItem) throws Exception {
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
	
	 public void selectItemInCustomDropDown1(WebDriverWait waitExplicit, WebDriver driver, String parenXpath, String childXpath, String expectedItem) {
		  // click vào dropdown
		  WebElement element = driver.findElement(By.xpath(parenXpath));
		  element.click();
		  
		  //Danh sách phần tử
		  List <WebElement> childList = driver.findElements(By.xpath(childXpath));
		  
		  //Đợi hiển thị tất cả các phần tử
		  waitExplicit.until(ExpectedConditions.visibilityOfAllElements(childList));
		  
		  for(WebElement child: childList) {
			  
			  String textItem = child.getText();
			  System.out.println("Text in Dropdown = " +textItem);
			  
			  if(textItem.equals(expectedItem)) {
				  child.click();
				  break;
			  }
		  }	
	 }	
	// End Sub Functions
}