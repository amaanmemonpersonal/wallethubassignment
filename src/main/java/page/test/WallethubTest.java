package page.test;

import page.actions.WallethubActions;
import wallet.web.common.BaseTest;

import org.testng.annotations.Test;

public class WallethubTest extends WallethubActions {
	Object[][] orderEntryTestCases;

	@Test(priority=0 , description="Login in to the Application")
	public static void login() throws Exception {
		String tc = "Login-001";
		enterusername("AU9628", tc);
		enterpassword("amaanbro@123", tc);
    	clicksignin(tc);
    	checkBetaTesterOption(tc);
		enterbirthyear(tc);
		Thread.sleep(5000);
		checkReferAndEarnPopUp(tc);
		checkSkip(tc);
		Thread.sleep(5000);
		
    }
}