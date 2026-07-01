import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\riaad\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// Scrolling window

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);

		// Scrolling table

		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		// count a column in a table, css=.tableFixHead
		// td:nth-child(4),xpath=//div[@class='tableFixHead']//td[4]
		int sum = 0;
		List<WebElement> tableValues = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		for (int i = 0; i < tableValues.size(); i++)

		{

			sum = sum + Integer.parseInt(tableValues.get(i).getText());
		}

		System.out.println(sum);

		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, total);

	}

}
