import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SteamsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\riaad\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Click on column
		driver.findElement(By.cssSelector("th:first-of-type")).click();
		// capture all webelements into list

		List<WebElement> elementsList = driver.findElements(By.cssSelector("tbody td:first-of-type"));
		// capture text of all webelemnts into new (original) list
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		// sort on the original list of step 3->sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		// compare original list with sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		List<String> price;
		// scan the name column with getText ->Rice->print the price of the Rice
		do {
			List<WebElement> rows = driver.findElements(By.cssSelector("tbody td:first-of-type"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));
			if (price.size() < 1) {

				driver.findElement(By.cssSelector("[aria-label='Next']")).click();

			}
		} while (price.size() < 1);

		
		
		
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub

		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

		return priceValue;
	}

}
