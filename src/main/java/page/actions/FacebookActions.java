package page.actions;


import page.objects.FacebookObjects;
import wallet.web.common.BasePageActions;

public class FacebookActions extends BasePageActions {
	
	public static void enterusername(String username, String tc) {
		InputData(FacebookObjects.textfieldUserName, username, "Input username",tc);
	}
	
	public static void enterpassword(String password, String tc) {
		InputData(FacebookObjects.textfieldPassword, password, "Input password",tc);
	}
	
	public static void clicksignin(String tc) {
		click(FacebookObjects.buttonLogin, "click signin button", tc);
	}
	
	public static void clickview(String tc) {
		click(FacebookObjects.viewPostStatus, "click view post status", tc);
	}
	
	public static void poststatus(String status, String tc) {
		InputData(FacebookObjects.textfieldStatus, status, "Input status",tc);
	}
	
	public static void clickpost(String tc) {
		click(FacebookObjects.buttonPost.get(2), "click post button", tc);
	}
}