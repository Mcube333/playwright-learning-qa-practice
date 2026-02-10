package basic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowserTest {

			public static void main(String[] args) {
				
			Playwright playwright = Playwright.create(); 
			
			BrowserType browsertype = playwright.chromium();
			
			Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
			
			Page page = browser.newPage();
			
			page.navigate("https://www.google.com");
			
			System.out.println(page.title());
			
//			page.close();
//			
//			browser.close();
//			
//			playwright.close();
			
		}
	}
