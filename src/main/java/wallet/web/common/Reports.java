package wallet.web.common;
import com.relevantcodes.extentreports.ExtentReports;


public class Reports {
	public static ExtentReports report = null;

	public static String report_name = VerificationData.reportName;
	

	public static ExtentReports getReports(String baseDirPath) {
		if (report == null) {
			
			report = new ExtentReports(baseDirPath
					+ report_name);
			report.addSystemInfo("Selenium Version",
					VerificationData.seleniumVersion);
		}
		return report;
	}
}
