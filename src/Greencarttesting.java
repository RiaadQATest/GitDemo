
import java.sql.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Greencarttesting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\riaad\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//explicit wait
		WebDriverWait w = new WebDriverWait (driver,Duration.ofSeconds(5));
		
		String[] cartItems = { "Beetroot", "Cauliflower", "Musk Melon" }; // Add items you'd like in a cart using array
		int s = 0;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		addCartItems(driver, cartItems);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
	//explicit wait
		//WebDriverWait w = new WebDriverWait (driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		
		System.out.println (driver.findElement(By.cssSelector(".promoInfo")).getText());
	
	
	
	}
	
	
	
	
	
	public static void addCartItems(WebDriver driver,String[] cartItems)
	{
		int s = 0;
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < products.size(); i++)
		{
			List cartItemsList = Arrays.asList(cartItems);

			String[] name = products.get(i).getText().split("-");// add the split(by -) and make string an Array by
																	// storing the value in index 0 and 1
			String actualname = name[0].trim(); // make new value a String, call index O ass that were the value we
												// looking for is stored, trim blank spaces.
			// convert Array to arraylist

			// check if name is present in Arraylist or not
			// format it to get actual item name by trimming
			// if (name.contains("Beetroot"))
			if (cartItemsList.contains(actualname)) // use new formatted name
			{

				s++;
			//	driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(); //issue using text, it is inconsistent locator
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// break; (dont need break when using arraylist.contains put if condition )

				if (s == cartItems.length)

				{
					break;
				}

			}
		}
	}
	
}
