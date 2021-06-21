package wallet.web.common;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	public static ExtentTest extentTest;
	public static String baseDir, runEnvironment;
	public static String ScreenshotDirName;
	protected static WebDriver driver;
	public static ExtentReports report = null;
	public static ExcelUtils xlsUtil;
	public String workingDir = System.getProperty("user.dir");
	protected static ConfigFileReader r= new ConfigFileReader();
    

	@Parameters({"baseDirPath","screenshotDirName", "url"})
	@BeforeSuite
	public void setup(String baseDirPath, String screenshotDirName, String url)throws Exception 
	{
		runEnvironment = r.getEnvName();
		baseDir=baseDirPath;
		ScreenshotDirName=screenshotDirName ;
		report = Reports.getReports(baseDirPath);
		try {
			switch(runEnvironment){
			case "local":
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
			    LoggingPreferences loggingprefs = new LoggingPreferences();
	            loggingprefs.enable(LogType.PERFORMANCE, Level.ALL);
	            DesiredCapabilities cap = new DesiredCapabilities().chrome();
	            cap.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
	            cap.setCapability(ChromeOptions.CAPABILITY, options);
	            WebDriverManager.chromedriver().setup();
	            System.out.println(workingDir + "/drivers/chromedriver.exe");
		        driver = new ChromeDriver(cap);
		    	driver.manage().window().maximize();
		    	driver.get(url);
		        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		        break;
			 }
			default:
		        break;
			}
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}

	

	@AfterSuite
	public static void tearDown() {
		try {
			System.out.println("Stop driver");
			driver.quit();
		} catch (Exception ex) {
		}

	}

	@BeforeMethod
	public void nameBefore(Method method) {
		extentTest = report.startTest(method.getName()).assignCategory(
				method.getAnnotation(org.testng.annotations.Test.class)
				.groups()).assignAuthor("Amaan Memon");
		System.out.println("Executing : " + method.getName());
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		report.endTest(extentTest);
		report.flush();
	}

	@BeforeClass
	public void beforeclass() {

		String className = this.getClass().getSimpleName();
		String[] parts = className.split("T", 2);
		String string1 = parts[0];

		System.out.println("Test Class Name : " + string1);
		Class s;
		try {
			s = Class.forName("page.objects." + string1 + "Objects");
			Object t = s.newInstance();
			PageFactory.initElements(new AppiumFieldDecorator(driver), t);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
