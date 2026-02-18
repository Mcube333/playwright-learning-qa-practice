package PlaywrightBasics;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginLogoutWithTestNG {

	@Test
	public void LoginLogoutTest() {

		Browser browser = null;
		Page newpage = null;
		try {
			browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

			// browser = Playwright.create().firefox().launch(new
			// BrowserType.LaunchOptions().setHeadless(false));

			// browser = Playwright.create().webkit().launch(new
			// BrowserType.LaunchOptions().setHeadless(false));

			newpage = browser.newPage();

			newpage.navigate("https://freelance-learn-automation.vercel.app/login");

			AssertJUnit.assertTrue(newpage.title().contains("Learn Automation Courses"));

			/*
			 * Below are the different ways to select the locator and perform the action on
			 * it. We can use any of the below method to select the locator and perform the
			 * action on it.
			 */

			// newpage.locator("#email1").fill("admin@email.com");

			// newpage.locator("xpath=//input[@name='email1']").fill("admin@email.com");

			// newpage.locator("css=input[name='email1']").fill("admin@email.com");

			newpage.getByPlaceholder("Enter Email").fill("admin@email.com");

			newpage.getByPlaceholder("Enter Password").fill("admin@123");

			/*
			 * this below line will click on the first "Sign in" button which is present on
			 * the page, but in our case there are two "Sign in" buttons present on the
			 * page, so it will click on the first one and it will not work, so we have to
			 * use nth() method to click on the second "Sign in" button.
			 */

			// newpage.getByText("Sign in").nth(1).click();

			newpage.getByText("Sign in").last().click();

			AssertJUnit.assertTrue(newpage.locator(".welcomeMessage").textContent().contains("Welcome"));

			newpage.getByAltText("menu").click();

			newpage.getByText("Sign out").click();

			AssertJUnit.assertTrue(newpage.url().contains("login"));

		} finally {

			newpage.close();

			browser.close();
		}

	}

}
