package page.objects;

import org.openqa.selenium.support.FindBy;
import java.util.List;
import org.openqa.selenium.WebElement;

public class WallethubObjects {
	
	@FindBy(name="em")
	public static WebElement textfieldEmailAddress;
	
	@FindBy(name="pw1")
	public static WebElement textfieldPassword;
	
	@FindBy(name="pw2")
	public static WebElement textfieldConfirmPassword;
	
	@FindBy(xpath="//i[@class='track bf-icon-ok']")
	public static WebElement checkboxCreditScore;
	
	@FindBy(xpath="//span[contains(text(), 'Join')]")
	public static WebElement buttonJoin;
	
	@FindBy(xpath="//a[@href='https://wallethub.com/profile/test-insurance-company-13732055i#reviews']")
	public static WebElement buttonReview;
	
	@FindBy(xpath="//*[@class='rvs-svg']/div/*[name()='svg']")
	public static List<WebElement>  buttonratingStar;
	
	@FindBy(xpath="//div[@class='dropdown second']")
	public static WebElement dropdownList;
	
	@FindBy(xpath="//div[@class='dropdown second opened']")
	public static WebElement dropdownListOpened;
	
	@FindBy(xpath="//textarea[@placeholder='Write your review...']")
	public static WebElement textareaReview;
	
	@FindBy(xpath = "//div[starts-with(@class,'sbn-action')]")
	public static WebElement buttonSubmit;
}