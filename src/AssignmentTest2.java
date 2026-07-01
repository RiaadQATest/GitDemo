import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AssignmentTest2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String password = "TestPass123";

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Yaadie");
		driver.findElement(By.name("email")).sendKeys("Yaadie@testmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select dropDown = new Select(staticDropdown);
		dropDown.selectByIndex(1);
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.name("bday")).sendKeys("1993/11/01");
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit'] ")).click();

		String alertText = driver.findElement(By.className("alert-success")).getText();
		// Can trim and use Assert.assertEqual
		Assert.assertTrue(alertText.contains("Success! The Form has been submitted successfully!."));
		// Assert.assertEquals((driver.findElement(By.className("alert-success")).getText()),
		// "Success! The Form has been submitted successfully!.");

	}

}
