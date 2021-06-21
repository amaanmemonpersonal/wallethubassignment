package page.test;

import page.actions.FacebookActions;
import org.testng.annotations.Test;

public class FacebookTest extends FacebookActions {

	@Test(priority=0 , description="Login in to the Application")
	public static void login() throws Exception {
		String tc = "Facebook-001";
		enterusername("your username", tc);
		enterpassword("your password", tc);
    	clicksignin(tc);
    	clickview(tc);
    	poststatus("Hello World", tc);
    	clickpost(tc);
		Thread.sleep(5000);	
    }
}