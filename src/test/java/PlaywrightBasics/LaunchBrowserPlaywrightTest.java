package PlaywrightBasics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowserPlaywrightTest {

public static void main(String[] args) {
	
	/* This is the first test case which is used to launch the browser and navigate to the URL and get the title of the page 
	 * and print it in the console and then close the browser. */

  	Playwright playwright = Playwright.create();
  	
  	BrowserType browsertype = playwright.chromium();
  	
  	//BrowserType browsertype = playwright.firefox();
  	
  	//BrowserType browsertype = playwright.webkit();
  	
  	Browser browserlaunch = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false)); 
  	
  	/*This Below line is used to launch the browser in non headless mode and also specify the channel as chrome, 
  	so that it will launch the latest version of chrome browser which is installed in our system.*/
  	
  //Browser browserlaunch = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
  	
  	Page page = browserlaunch.newPage();
	  
	page.navigate("https://playwright.dev/java/docs/intro#first-script");
	
	String title = page.title();
	
	System.out.println("Title is : " + title);
	
	page.close();
	
	browserlaunch.close();
	
	playwright.close();
  }
}
