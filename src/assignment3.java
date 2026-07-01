import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
// get Password and user name from Screen, make it variables that you pass
//select User and consultant 
//Select all items in cart, it should be dynamic so that if more items are can be add when avaible 
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\riaad\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String[] wantedItems = { "Blackberry", "Samsung Note 8", "Nokia Edge", "iphone X" };
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("Learning@830$3mK2");
		driver.findElement(By.cssSelector("input[value='user']")).click();
		// Thread.sleep(3000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement staticDropDown = driver.findElement(By.cssSelector("select.form-control"));
		Select dropdown = new Select(staticDropDown);
		dropdown.selectByIndex(2);
		// dropdown.selectByVisibleText("Consultant");
		// dropdown.selectByValue("consult");
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.id("signInBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.card-title")));

		List<WebElement> items = driver.findElements(By.cssSelector("h4.card-title"));
		for (int i = 0; i < items.size(); i++) {
			List cartItems = Arrays.asList(wantedItems);
			String name = items.get(i).getText();
			if (cartItems.contains(name)) {

				driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();

			}

		}

		
		driver.findElement(By.className("btn-primary")).click();
		
		
	}

}
