package page.objects;

import org.openqa.selenium.support.FindBy;
import java.util.List;
import org.openqa.selenium.WebElement;

public class FacebookObjects {
	
	@FindBy(id="email")
	public static WebElement textfieldUserName;
	
	@FindBy(id="pass")
	public static WebElement textfieldPassword;
	
	@FindBy(name="login")
	public static WebElement buttonLogin;
	
	@FindBy(xpath="//span[contains(text(), 'on your mind')]")
	public static WebElement viewPostStatus;
	
	@FindBy(xpath="//div[starts-with(@aria-describedby, 'placeholder')]")
	public static WebElement textfieldStatus;
	
	@FindBy(xpath="//span[contains(text(), 'Post')]")
	public static List<WebElement> buttonPost;
	
}