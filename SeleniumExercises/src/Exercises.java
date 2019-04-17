import java.util.List;
import java.util.Set;

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
			ExerciseNine();
			ExerciseTen();
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
		
		// Open https://www.seleniumeasy.com/test/table-sort-search-demo.html.
		String url = "https://www.seleniumeasy.com/test/table-sort-search-demo.html";
		driver.get(url);
	
		
		// Get the value of cell 'C. Hurst' and print it on the console.
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr/td[1]"));
		
		for(int row = 1; row <= rows.size(); row++)
		{
			WebElement name = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr["+row+"]/td[1]"));
			if(name.getText().equals("C. Hurst"))
			{
				System.out.println(name.getText() + " found in row number " + row);
				break;
			}
		}
	
		// Delay to see what is happening.
		Thread.sleep(3000);
		
		// Close the browser.
		driver.quit();
	}
	
	public static void ExerciseNine() throws InterruptedException
	{
		// Launch a new Firefox browser.
		driver = new FirefoxDriver();
		
		// Open https://www.seleniumeasy.com/test/table-sort-search-demo.html.
		String url = "https://www.seleniumeasy.com/test/table-sort-search-demo.html";
		driver.get(url);
	
		// Print all the column values of row 'C. Marshall'.
		int numberOfRows = driver.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr/td[1]")).size();
		List<WebElement> columnHeaders = driver.findElements(By.xpath("//*[@id=\"example\"]/thead/tr/th"));

		for(int row = 1; row <= numberOfRows; row++)
		{
			WebElement name = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr["+row+"]/td[1]"));
			
			if(name.getText().equals("C. Marshall"))
			{
				for(int column = 1; column <= columnHeaders.size(); column++)
				{
					WebElement cell = driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr["+row+"]/td["+column+"]"));
					System.out.println(columnHeaders.get(column - 1).getText() + ": " + cell.getText());
				}
				
				break;
			}
		}
	
		// Delay to see what is happening.
		Thread.sleep(3000);
		
		// Close the browser.
		driver.quit();
	}
	
	public static void ExerciseTen() throws InterruptedException
	{
		// Launch a new Firefox browser.
		driver = new FirefoxDriver();
		
		// Open http://toolsqa.com/automation-practice-switch-windows/.
		String url = "http://toolsqa.com/automation-practice-switch-windows/";
		driver.get(url);
		
		// Get Window name(with GetWindowHandle command).
		String mainWindow = driver.getWindowHandle();
		System.out.println("The current Window name is: " + mainWindow);
		
		// There is an issue with the '__cfRLUnblockHandlers' variable for the 'New Message Window' button.
		// so we have to give time for it to load, else onClikc JS function will do nothing.
		Thread.sleep(1000);
		
		// Click on Button "New Message Window".
		WebElement button = driver.findElement(By.xpath("//*[@id=\"content\"]/p[3]/button"));
		
		button.click();
		
		// Get all the Windows names (with GetWindowHandles command).
		System.out.print("\nAll Windows names: ");
		
		Set<String> windows = driver.getWindowHandles();
		
		for(String window : windows)
			System.out.print(window + " ");
		
		System.out.println();
		
		// Delay to see what is happening.
		Thread.sleep(3000);
		
		// Close the Pop Up Window (with Switch Command to shift window).
		for(String window : windows)
		{
			// Since we know there are only 2 windows, close the one that is not the main window.
			if(!window.equals(mainWindow))
			{
				driver.switchTo().window(window);
				driver.close();
			}
		}
		
		// Delay to see what is happening.
		Thread.sleep(3000);
		
		// Close the browser.
		driver.quit();
	}
}