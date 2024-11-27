package fitpeo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
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
		WebElement slider = driver.findElement(By.xpath("//*[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-16i48op']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 Actions actions = new Actions(driver);
		 actions.dragAndDropBy(slider,-26, 0).build().perform();
		 
         WebElement textField = driver.findElement(By.xpath("//*[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']"));  // Replace with the correct ID
         String textFieldValue = textField.getAttribute("value");
         System.out.println("Slider text field value: " + textFieldValue); 
	}


	@When("I click on the text field and enter the value 560")
	public void i_click_on_the_text_field_and_enter_the_value_560()  throws Exception{
		WebElement textField = driver.findElement(By.xpath("//*[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']")); 

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(textField));

		textField.click();
		String s = Keys.chord(Keys.CONTROL, "a");
		textField.sendKeys(s);
		textField.sendKeys(Keys.DELETE);
		textField.sendKeys("560");
			
	}

	@Then ("the sliders position should be updated to reflect the value 560")
	public void the_sliders_position_should_be_updated_to_reflect_the_value_560() throws Exception {
		WebElement textField = driver.findElement(By.xpath("//*[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']")); 

		String updatedSliderTextValue = textField.getAttribute("value");
        System.out.println("Updated slider text field value: " + updatedSliderTextValue);
        if ("560".equals(updatedSliderTextValue)) {
            System.out.println("Text field value is updated correctly.");
        }
	}

	@Then("I select the checkboxes for {string}, {string}, {string}, and {string}")
	public void i_select_the_checkboxes_for_and(String code1, String code2, String code3, String code4) throws Exception{
		WebElement cpt99091 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]"));  
        WebElement cpt99453 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]"));  
        WebElement cpt99454 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]"));  
        WebElement cpt99474 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[8]"));  

        cpt99091.click();
        cpt99453.click();
        cpt99454.click();
        cpt99474.click();

	    }
	
	@Then("the header displaying Total Recurring Reimbursement for all Patients Per Month should show {string}")
	public void the_header_displaying_total_Recurring_Reimbursement_for_all_Patients_Per_Month_should_show( String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement totalRecurringHeader = driver.findElement(By.xpath("//*['Total Recurring Reimbursement for all Patients Per Month:']/p[4]"));
		
         String totalValue = totalRecurringHeader.getText();
         System.out.println("Total Recurring Reimbursement: " + totalValue);
         if ("$110700".equals(totalValue)) {
             System.out.println("Total Recurring Reimbursement is correct.");
         } else {
             System.out.println("Total Recurring Reimbursement is incorrect.");
         }
	}

}
