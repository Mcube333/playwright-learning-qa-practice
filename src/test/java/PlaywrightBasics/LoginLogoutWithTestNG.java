package PlaywrightBasics;

import org.testng.annotations.Test;

import org.testng.Assert;
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

			newpage = browser.newPage();

			newpage.navigate("https://freelance-learn-automation.vercel.app/login");

			Assert.assertTrue(newpage.title().contains("Learn Automation Courses"));

			newpage.getByPlaceholder("Enter Email").fill("admin@email.com");

			newpage.getByPlaceholder("Enter Password").fill("admin@123");

			newpage.getByText("Sign in").last().click();

			Assert.assertTrue(newpage.locator(".welcomeMessage").textContent().contains("Welcome"));

			newpage.getByAltText("menu").click();

			newpage.getByText("Sign out").click();

			// PlaywrightAssertions.assertThat(newpage).hasURL(Pattern.compile("login"));
			newpage.waitForURL("**/login");

			String currentUrl = newpage.url();

			Assert.assertTrue(currentUrl.contains("login"),
					"Expected URL to contain 'login', but found: " + currentUrl);

		} finally {

			newpage.close();

			browser.close();

		}

	}

	@Test
	public void LoginWithInvalidCredentials() {

		Browser browser = null;
		Page newpage = null;
		try {
			browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

			newpage = browser.newPage();

			newpage.navigate("https://freelance-learn-automation.vercel.app/login");

			Assert.assertTrue(newpage.title().contains("Learn Automation Courses"));

			newpage.getByPlaceholder("Enter Email").fill("wrongemail@email.com");

			newpage.getByPlaceholder("Enter Password").fill("wrongpassword");

			newpage.getByText("Sign in").last().click();

			Assert.assertTrue(newpage.locator(".errorMessage").textContent().contains("USER Email Doesn't Exist"));

		} finally {

			newpage.close();

			browser.close();
		}
	}

	@Test
	public void LoginWithEmptyCredentials() {

		Browser browser = null;
		Page newpage = null;
		try {
			browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

			newpage = browser.newPage();

			newpage.navigate("https://freelance-learn-automation.vercel.app/login");

			Assert.assertTrue(newpage.title().contains("Learn Automation Courses"));

			newpage.getByText("Sign in").last().click();

			Assert.assertTrue(
					newpage.locator(".errorMessage").textContent().contains("Email and Password is required"));

		} finally {

			newpage.close();

			browser.close();

		}

	}

	@Test
	public void LoginWithInvalidEmailFormat() {

		Browser browser = null;
		Page newpage = null;
		try {
			browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

			newpage = browser.newPage();

			newpage.navigate("https://freelance-learn-automation.vercel.app/login");

			Assert.assertTrue(newpage.title().contains("Learn Automation Courses"));

			newpage.getByPlaceholder("Enter Email").fill("invalid@email.com");

			newpage.getByPlaceholder("Enter Password").fill("admin@123");

			newpage.getByText("Sign in").last().click();

			Assert.assertTrue(newpage.locator(".errorMessage").textContent().contains("USER Email Doesn't Exist"));

		} finally {

			newpage.close();

			browser.close();
		}
	}

	@Test
	public void LoginWithIncorrectPassword() {

		Browser browser = null;
		Page newpage = null;
		try {
			browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

			newpage = browser.newPage();

			newpage.navigate("https://freelance-learn-automation.vercel.app/login");

			Assert.assertTrue(newpage.title().contains("Learn Automation Courses"));

			newpage.getByPlaceholder("Enter Email").fill("admin@email.com");

			newpage.getByPlaceholder("Enter Password").fill("wrongpassword");

			newpage.getByText("Sign in").last().click();

			Assert.assertTrue(
					newpage.locator(".errorMessage").textContent().contains("Email and Password Doesn't match"));

		} finally {

			newpage.close();

			browser.close();

		}
	}

}
