import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// System.setProperty("Webdriver.chrome.driver","C:\\Users\\riaad\\OneDrive\\Documents\\chromedriver.exe");//optional
		// because of selenium
		// manager update in package ,
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// dropdown with select tag
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByContainsVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		// drop downs that are not static and can be updated
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		// Select multiple times on a button
		/*
		 * int i=1; while (i<2) {
		 * 
		 * driver.findElement(By.id("hrefIncAdt")).click(); i++;
		 * 
		 * }
		 */
		// can also use for loop

		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		// System.out.println (driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		// Dynamic dropdowns withindexes
		// (//a[contains(@text,'Chennai')])[2]
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//a[contains(@text,'Chennai')])[2]")).click();
		// If the ask no indexes to find dynamic drop-downs
		driver.findElement(By
				.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[contains(@text,'Chennai')]"))
				.click();

		// Auto Suggested dropdown (NB*when options are not given, provide input on
		// dropdown,get generic locator which find all items and store it in list,
		// iterate or list and get text the compare with text you looking for, then
		// break. )
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
		}

		// select calender

		Thread.sleep(3000);
		// driver.findElement(By.cssSelector("a.ui-state-default.ui-state-active.ui-state-hover")).click();
		driver.findElement(By.id("ctl00_mainContent_view_date1")).sendKeys("05/05");

		// Checkboxs and getting there size,check if box is selected
		Assert.assertFalse(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());
		// System.out.println
		// (driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());
		driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).click();
		// System.out.println
		// (driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());
		Assert.assertTrue(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());

		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		// a.ui-state-default.ui-state-active.ui-state-hover

		// System.out.println
		// (driver.findElement(By.id("Div1")).getDomAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		// System.out.println
		// (driver.findElement(By.id("Div1")).getDomAttribute("style"));

		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {

			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

		driver.findElement(By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']")).click();

		Thread.sleep(5000);

	}

}
