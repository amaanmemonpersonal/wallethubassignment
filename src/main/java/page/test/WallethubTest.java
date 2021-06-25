package page.test;

import page.actions.WallethubActions;
import wallet.web.common.Utils;

import org.testng.annotations.Test;

public class WallethubTest extends WallethubActions {

	@Test(priority=0 , description="Sign up with light user")
	public static void Signup() throws Exception {
		String tc = "WalletHub-001";
		String email = "amaan.memon" + Utils.generateRandomString(2) + "@gmail.com";
		String password = "@Amaan123";
		enteremail(email, tc);
		enterpassword(password, tc);
		enter_confirm_password(password, tc);
		check_uncheck_creditscore(tc);
		clickjoin(tc);
		Thread.sleep(5000);
    }
	
	@Test(priority=1 , description="Navigate to Test Insurance Company and write review and verify")
	public static void InsuranceCompanyPage() throws Exception {
		String review_data = "WalletHub is the first-ever website to offer free credit scores and full credit reports that are updated on a daily basis. But we consider that just an appetizer, as we’ve built the brain of an artificially intelligent financial advisor that will truly leave your wallet full. WalletHub’s brain performs three primary functions, providing: 1) Customized credit-improvement advice; 2) Personalized savings alerts; and 3) 24/7 wallet surveillance. Such features are supplemented by more reviews of financial products, professionals and companies than any other website offers and a diverse community of subject matter experts. WalletHub is owned by Evolution Finance, Inc. and is based in Washington, DC.";
		String tc = "WalletHub-002";
		driver.get("http://wallethub.com/profile/test_insurance_company/");
		clickratingstar(3, tc);
		select_dropdown("Health Insurance", tc);
		InputReview(review_data,tc);
		clicksubmit(tc);
		Thread.sleep(10000);
    }
}