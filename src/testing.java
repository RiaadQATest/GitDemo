import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class testing {

	public static void main(String[] args) throws InterruptedException {

		String username = "rahul";

		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\riaad\\OneDrive\\Documents\\chromedriver.exe");// optional because of
																									// selenium manager
																									// update in package
																									// ,
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		String password = getPassword(driver);

		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.id("inputUsername")).sendKeys("Ree");
		driver.findElement(By.name("inputPassword")).sendKeys("wrrdfgn");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.xpath("//p[@class='error']")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("John@Two.co.za");
		driver.findElement(By.xpath("(//input[@type='text']) [2]")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("John@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("0752368455");
		driver.findElement(By.cssSelector("button[class='reset-pwd-btn']")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(username);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Hello " + username + ",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		System.out.println(driver.getCurrentUrl());
		// driver.quit();

	}

	public static String getPassword(WebDriver driver) throws InterruptedException {

		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[class='reset-pwd-btn']")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		// Please use temporary password 'rahulshettyacademy' to Login.
		String[] passwordArray = passwordText.split("'");

		String[] passwordArray2 = passwordArray[1].split("'");
		String password = passwordArray2[0];
		return password;

		// String password =passwordArray[1].split("'")[0];

		// 0th index - Please use temporary password

		// 1st index - rahulshettyacademy' to Login.

		// 0th index - rahulshettyacademy

		// 1st index - to Login.
	}

	/*
	 * System.setProperty("webdriver.chrome.driver",
	 * "/Users/rahulshetty/Documents/chromedriver");
	 * 
	 * WebDriver driver = new ChromeDriver();
	 * 
	 * driver.manage().window().maximize();
	 * 
	 * driver.get("http://google.com");
	 * 
	 * driver.navigate().to("https://rahulshettyacademy.com");
	 * 
	 * driver.navigate().back();
	 * 
	 * driver.navigate().forward();
	 */

}// rahulshettyacademy
