import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercises 
{
	public static WebDriver driver;
	
	public static void main(String[] args)
	{
		// Set the Gecko Driver.
		System.setProperty("webdriver.gecko.driver", "/Users/alanbarrera/git/SeleniumExercisesRepo/SeleniumExercises/geckodriver");
		
		try
		{
			// Run the exercises.
			ExercisesOneAndTwo();
			ExerciseThree();
			ExerciseFour();
			ExerciseFive();
			ExerciseSix();
			ExerciseSeven();
			ExerciseEight();
		}
		catch(Exception ex)
		{
			// Print in the console any error.
			System.out.println("An error has ocurred: " + ex);
		}
		finally
		{
			// Make sure to quit the driver.
			driver.quit();
		}
	}
	
	public static void ExercisesOneAndTwo() throws InterruptedException
	{
		// Launch a new Firefox browser.
		driver = new FirefoxDriver();
		
		// Open Store.DemoQA.com.
		String url = "http://store.demoqa.com/";
		driver.get(url);
		
		// Get Page Title and Title length
		String pageTitle = driver.getTitle();
		int titleLength = pageTitle.length();
		
		// Print Page Title and Title length on the Eclipse Console.
		System.out.println("Page Title: " + pageTitle);
		System.out.println("Title length: " + titleLength);
		
		// Get Page URL and verify if it is correct.
		String pageUrl = driver.getCurrentUrl();
		System.out.println("Is the page correct? -> " + pageUrl.equals(url));
		
		// Get Page Source and Page Source length.
		String pageSource = driver.getPageSource();
		int sourceLength = pageSource.length();
		
		// Print Page Length on Eclipse Console.
		System.out.println("Page Source Length: " + sourceLength);
		
		// Delay to see what is happening.
		Thread.sleep(3000);
		
		// Close the browser.
		driver.quit();
	}
	
	public static void ExerciseThree() throws InterruptedException
	{
		// Launch a new Firefox browser.
		driver = new FirefoxDriver();
		
		// Open http://toolsqa.com/automation-practice-form/.
		String url = "http://toolsqa.com/automation-practice-form/";
		driver.get(url);
		
		// Type Name & Last Name (with Name locator).
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		
		firstName.sendKeys("Alan");
		lastName.sendKeys("Barrera");
		
		// Delay to see what is happening.
		Thread.sleep(3000);
		
		// Click on Submit button (with ID locator).
		WebElement submitButton = driver.findElement(By.id("submit"));
		submitButton.submit();
		
		// Delay to see what is happening.
		Thread.sleep(3000);
		
		// Close the browser.
		driver.quit();
	}
	
	public static void ExerciseFour() throws InterruptedException
	{
		// Launch a new Firefox browser.
		driver = new FirefoxDriver();
		
		// Open http://toolsqa.com/automation-practice-form/.
		String url = "http://toolsqa.com/automation-practice-form/";
		driver.get(url);
		
		// Delay to see what is happening.
		Thread.sleep(3000);
				
		// Click on the Link "Partial Link Test" (with 'partialLinkTest' locator, by "Partial" word).
		WebElement partialLink = driver.findElement(By.partialLinkText("Partial"));
		partialLink.click();
		
		// Identify Submit button with 'tagName', convert it to String and print it on the console.
		WebElement submitButton = driver.findElement(By.tagName("button"));
		System.out.println("Submit button string: " + submitButton.toString());
		
		// Delay to see what is happening.
		Thread.sleep(3000);
		
		// Click on the Link "Link Test" (Use 'linkTest' locator).
		WebElement link = driver.findElement(By.linkText("Link Test"));
		link.click();
		
		// Delay to see what is happening.
		Thread.sleep(3000);
		
		// Close the browser.
		driver.quit();
	}
	
	public static void ExerciseFive() throws InterruptedException
	{
		// Launch a new Firefox browser.
		driver = new FirefoxDriver();
		
		// Open http://toolsqa.com/automation-practice-form/.
		String url = "http://toolsqa.com/automation-practice-form/";
		driver.get(url);
		
		// Delay to see what is happening.
		Thread.sleep(3000);
		
		// Select the deselected Radio button (female) for category Sex (with IsSelected method).
		List<WebElement> sexRadioButtons = driver.findElements(By.name("sex"));
		
		
		if(sexRadioButtons.get(0).isSelected())
			sexRadioButtons.get(1).click();
		else
			sexRadioButtons.get(0).click();
		
		// Select the Third radio button for category 'Years of Exp'
		// (with Id attribute for Radio button selection).
		WebElement expRadioButton = driver.findElement(By.id("exp-2"));
		expRadioButton.click();
		
		// Check the Check Box 'Automation Tester' for category 'Profession'
		// (with Value attribute for Radio button selection).
		List<WebElement> professionCheckBoxes = driver.findElements(By.name("profession"));
		
		for(WebElement professionCheckBox : professionCheckBoxes)
		{
			if(professionCheckBox.getAttribute("value").equalsIgnoreCase("Automation Tester"))
			{
				professionCheckBox.click();
				break;
			}
		}
		
		// Check the Check Box 'Selenium IDE' for category 'Automation Tool'
		// (with cssSelector).
		WebElement seleniumIDECheckBox = driver.findElement(By.cssSelector("input[value='Selenium IDE']"));
		seleniumIDECheckBox.click();
		
		// Delay to see what is happening.
		Thread.sleep(5000);
		
		// Close the browser.
		driver.quit();
	}
	
	public static void ExerciseSix() throws InterruptedException
	{
		// Launch a new Firefox browser.
		driver = new FirefoxDriver();
		
		// Open http://toolsqa.com/automation-practice-form/.
		String url = "http://toolsqa.com/automation-practice-form/";
		driver.get(url);
		
		// Select 'Continents' Drop down (with Id for element identifying)
		Select continentsDropdown = new Select(driver.findElement(By.id("continents")));
		
		// Select option 'Europe' (with selectByIndex).
		continentsDropdown.selectByIndex(1);
		
		// Delay to see what is happening.
		Thread.sleep(1500);
		
		// Select option 'Africa' (with selectByVisibleText).
		continentsDropdown.selectByVisibleText("Africa");
		
		// Print all the options for the selected drop down and select one option of your choice.
		List<WebElement> continentsOptions = continentsDropdown.getOptions();
		
		for(WebElement continentsOption : continentsOptions)
			System.out.println(continentsOption.getText());
		
		// Delay to see what is happening.
		Thread.sleep(1500);
		
		continentsDropdown.selectByVisibleText("Antartica");
		
		// Delay to see what is happening.
		Thread.sleep(3000);
		
		// Close the browser.
		driver.quit();
	}
	
	public static void ExerciseSeven() throws InterruptedException
	{
		// Launch a new Firefox browser.
		driver = new FirefoxDriver();
		
		// Open http://toolsqa.com/automation-practice-form/.
		String url = "http://toolsqa.com/automation-practice-form/";
		driver.get(url);
		
		// Select 'Selenium Commands' Multiple selection box
		// (with Name locator for element identifying).
		Select seleniumCommands = new Select(driver.findElement(By.name("selenium_commands")));
		
		// Select option 'Browser Commands' and then deselect it
		// (with selectByIndex and deselectByIndex).
		seleniumCommands.selectByIndex(0);
		
		// Delay to see what is happening.
		Thread.sleep(1000);
		
		seleniumCommands.deselectByIndex(0);
		
		// Delay to see what is happening.
		Thread.sleep(1000);
		
		// Select option 'Navigation Commands' and then deselect it
		// (with selectByVisibleText and deselectByVisibleText).
		seleniumCommands.selectByVisibleText("Navigation Commands");
		
		// Delay to see what is happening.
		Thread.sleep(1000);
		
		seleniumCommands.deselectByVisibleText("Navigation Commands");
		
		// Print and select all the options for the selected Multiple selection list.
		List<WebElement> seleniumCommandsOptions = seleniumCommands.getOptions();
		
		int numberOfOptions = seleniumCommandsOptions.size();
		
		for(int i = 0; i < numberOfOptions; i++)
		{
			System.out.println(seleniumCommandsOptions.get(i).getText());
			seleniumCommands.selectByIndex(i);
		}
				
		// Deselect all options.
		for(int i = 0; i < numberOfOptions; i++)
			seleniumCommands.deselectByIndex(i);
		
		// Delay to see what is happening.
		Thread.sleep(3000);
		
		// Close the browser.
		driver.quit();
	}
	
	public static void ExerciseEight() throws InterruptedException
	{
		// Launch a new Firefox browser.
		driver = new FirefoxDriver();
		
		// Open http://demo.guru99.com/test/web-table-element.php.
		String url = "http://demo.guru99.com/test/web-table-element.php";
		driver.get(url);
		
		// Get the value of cell 'NCC' and print it on the console.
		WebElement companyCell = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[11]/td[1]/a"));
		
		// Click on the link of that cell.
		companyCell.click();
		
		// Delay to see what is happening.
		Thread.sleep(3000);
		
		// Close the browser.
		driver.quit();
	}
}