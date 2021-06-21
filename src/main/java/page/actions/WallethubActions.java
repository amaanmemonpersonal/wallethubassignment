package page.actions;

import page.objects.WallethubObjects;
import wallet.web.common.BasePageActions;

public class WallethubActions extends BasePageActions {
	
	public static void enterusername(String username, String tc) {
		InputData(WallethubObjects.tf_UserName, username, "Input username",tc);
	}
}