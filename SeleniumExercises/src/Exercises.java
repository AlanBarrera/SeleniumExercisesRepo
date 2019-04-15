import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
	
	public static void ExercisesOneAndTwo()
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
		
		// Close the browser.
		driver.quit();
	}
}