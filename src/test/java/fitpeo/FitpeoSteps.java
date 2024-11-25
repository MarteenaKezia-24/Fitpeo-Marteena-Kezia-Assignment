package fitpeo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import java.time.Duration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FitpeoSteps {
	 WebDriver driver;

	    // Constructor to initialize the WebDriver and load properties
	    public FitpeoSteps(BaseClass maindriver) throws Exception {
	        driver = maindriver.startBrowser();
	    }
	    
	@Given("I navigate to the FitPeo Homepage")
	public void i_navigate_to_the_fit_peo_homepage() throws Exception{
		
		driver.get("https://www.fitpeo.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@When("I navigate to the Revenue Calculator Page")
	public void i_navigate_to_the_revenue_calculator_page()  throws Exception{
		WebElement revenueCalculatorLink = driver.findElement(By.linkText("Revenue Calculator"));
        revenueCalculatorLink.click();
    	Thread.sleep(3000);
	}

	@When("I scroll down to the Slider section")
	public void i_scroll_down_to_the_slider_section()  throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(3000);
	}

	@When("I adjust the slider to set its value to {int}")
	public void i_adjust_the_slider_to_set_its_value_to(Integer int1)  throws Exception{
		 WebElement slider = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/span[1]/span[3]"));
		 WebElement thumb = slider.findElement(By.xpath(".//span[@class='slider-thumb-class']")); // Find the thumb element

		    int sliderWidth = slider.getSize().getWidth();
		    int thumbPosition = thumb.getLocation().getX();  // Current X position of the thumb

		    int targetValue = 820;

		    int offset = targetValue - thumbPosition;

		    Actions actions = new Actions(driver);
		    actions.dragAndDropBy(thumb, offset, 0).perform();

		 
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.attributeContains(thumb, "style", "left"));
		 Actions move = new Actions(driver);
		 move.dragAndDropBy(slider, 2000, 500).perform();
		 Thread.sleep(3500);
	}
	

	@When("I click on the text field and enter the value 560")
	public void i_click_on_the_text_field_and_enter_the_value_560()  throws Exception{
		WebElement textField = driver.findElement(By.xpath("//*[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']")); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(textField));
	    textField.click();
        textField.clear();
        textField.sendKeys("560");
	}

	@Then("the slider's position should be updated to reflect the value {string}")
	public void the_slider_s_position_should_be_updated_to_reflect_the_value(String string)  throws Exception{
	  
	}

	@Then("I scroll down further to select the CPT Codes")
	public void i_scroll_down_further_to_select_the_cpt_codes()  throws Exception{
	    
	}

	@Then("I select the checkboxes for {string}, {string}, {string}, and {string}")
	public void i_select_the_checkboxes_for_and(String string, String string2, String string3, String string4) {
	   
	}

	@Then("the header displaying {string} should show {string}")
	public void the_header_displaying_should_show(String string, String string2) {
	   
	}

}
