package wallet.web.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.TimeZone;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;

public class BasePageActions extends BaseTest {
	public static String pass;
	public static String report_date;
	public static String report_date1;
	public static Properties prop = new Properties();
	
	public static String currentTime() {
		DateFormat dateFormat = new SimpleDateFormat("E-yyyy-MM-dd-'at'-hh-mma");
		Date date = new Date();

		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		report_date1 = dateFormat.format(date);
		report_date = report_date1.toLowerCase();
		System.out.println("current time is" + report_date);
		return report_date;
	}
	
	public static void click(WebElement locator, String description, String tc) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(locator));
			locator.click();
			extentTest.log(LogStatus.PASS, description, tc);
		} catch (NoSuchElementException e) {
			extentTest.log(LogStatus.FAIL, description, tc);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(locator + e.getMessage());
			extentTest.log(LogStatus.FAIL, description, tc);
		}
	}
	
	public static void hover_and_click(WebElement locator, String description, String tc) {
		try {
			Actions actions = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(locator));
			actions.moveToElement(locator);
			actions.click().build().perform();
			extentTest.log(LogStatus.PASS, description, tc);
		} catch (NoSuchElementException e) {
			extentTest.log(LogStatus.FAIL, description, tc);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(locator + e.getMessage());
			extentTest.log(LogStatus.FAIL, description, tc);
		}
	}
	
	public static void InputData(WebElement locator, String data, String description, String tc) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(locator));
			locator.clear();
			locator.sendKeys(data);
			extentTest.log(LogStatus.PASS, description + " Data: " + data, tc);
		} catch (NoSuchElementException e) {
			extentTest.log(LogStatus.FAIL, description, tc);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(locator + e.getMessage());
			extentTest.log(LogStatus.FAIL, description, tc);
		}
	}
	
	public static void InputDataJs(WebElement locator, String data, String description, String tc) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(locator));
			locator.clear();
			for (int i = 0; i < data.length(); i++) {
				locator.sendKeys(String.valueOf(data.charAt(i)));
			}
			extentTest.log(LogStatus.PASS, description + " Data: " + data, tc);
		} catch (NoSuchElementException e) {
			extentTest.log(LogStatus.FAIL, description, tc);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(locator + e.getMessage());
			extentTest.log(LogStatus.FAIL, description, tc);
		}
	}
}
