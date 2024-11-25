package fitpeo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;

public class BaseClass {
	private WebDriver driver;

    // Start the browser only if it is not already initialized.
    public WebDriver startBrowser() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marteena\\Drivers\\chromedriver-win64 131\\chromedriver-win64\\chromedriver.exe");

		if (driver == null) {
			driver = new ChromeDriver();
		}
		return driver;
    }

    // Step definition for closing the browser
    @And("User closes the browser")
    public void userCloseTheBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Reset the driver to avoid stale references.
        }
    }
}
