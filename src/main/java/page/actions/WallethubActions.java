package page.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.objects.WallethubObjects;
import wallet.web.common.BasePageActions;

public class WallethubActions extends BasePageActions {
	
	public static void enteremail(String email, String tc) {
		InputData(WallethubObjects.textfieldEmailAddress, email, "Input Email Address;",tc);
	}
	
	public static void enterpassword(String password, String tc) {
		InputData(WallethubObjects.textfieldPassword, password, "Input Password;",tc);
	}
	
	public static void enter_confirm_password(String password, String tc) {
		InputData(WallethubObjects.textfieldConfirmPassword, password, "Input Confirm Password;",tc);
	}
	
	public static void check_uncheck_creditscore(String tc) {
		hover_and_click(WallethubObjects.checkboxCreditScore, "check/uncheck free credit score", tc);
	}
	
	public static void clickjoin(String tc) {
		click(WallethubObjects.buttonJoin, "click join button", tc);
	}
	
	public static void clickratingstar(int star, String tc) {
		hover_and_click(WallethubObjects.buttonratingStar.get(3), "click star", tc);
	}
	
	public static void select_dropdown(String value, String tc) {
		click(WallethubObjects.dropdownList, "click drop down", tc);
		List<WebElement> listValues =WallethubObjects.dropdownListOpened.findElement(By.tagName("ul")).findElements(By.tagName("li"));
		for(int i=0;i<listValues.size();i++)
		{
			if(listValues.get(i).getText().equals(value))
			{
				click(listValues.get(i), "click " + value, tc);
			}
		}
	}
	
	public static void InputReview(String review, String tc) {
		InputData(WallethubObjects.textareaReview, review, "Input Review",tc);
	}
	
	public static void clicksubmit(String tc) {
		click(WallethubObjects.buttonSubmit, "click Submit button", tc);
	}
}