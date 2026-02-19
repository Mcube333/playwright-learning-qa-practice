package PlaywrightBasics;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class RegisterNewUserWithPlaywright {
	
	/* * This class is used to register a new user on the website. We are using the Faker library to generate random data for the user.
	 *  We are also using the PlaywrightAssertions class to verify the assertions.*/

	public static void main(String[] args) {
		
		Browser browser = Playwright.create().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page newpage = browser.newPage();
		
		newpage.navigate("https://freelance-learn-automation.vercel.app/login");
		
		newpage.getByText("New user? Signup").click();
		
		PlaywrightAssertions.assertThat(newpage.locator(".submit-btn")).isDisabled();
		
		newpage.locator("#name").fill(new Faker().name().fullName());
		
		newpage.getByPlaceholder("Email").fill(new Faker().name().firstName() + "@gmail.com");
		
		newpage.getByPlaceholder("Password").fill("Admin@123");
		
		//newpage.locator("xpath=//label[text()='Selenium']//preceding::input[1]").click();
		
		newpage.getByText("java").click();
		
		PlaywrightAssertions.assertThat(newpage.locator("xpath=//label[text()='Java']//preceding::input[1]")).isChecked();
		
		newpage.locator("xpath=//input[@value='Female']").click();
		
		PlaywrightAssertions.assertThat(newpage.locator("xpath=//input[@value='Female']")).isChecked();
		
		newpage.locator("#state").selectOption("Bihar");
		
		String hobbies[] = {"Reading", "Swimming"};
		
		newpage.locator("#hobbies").selectOption(hobbies);
		
		PlaywrightAssertions.assertThat(newpage.locator(".submit-btn")).isEnabled();
		
		newpage.locator(".submit-btn").click();
		
		PlaywrightAssertions.assertThat(newpage.locator(".Toastify")).containsText("Signup successfully, Please login!");
		
		newpage.close();
		
		browser.close();
		
	}

}
