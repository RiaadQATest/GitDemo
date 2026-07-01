import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignmentTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\riaad\\OneDrive\\Documents\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.linkText("Click Here")).click();
	
		Set<String>windows=driver.getWindowHandles();
		
		Iterator <String>it=windows.iterator();
		
		String parentID=it.next();
		String childID=it.next();
		driver.switchTo().window(childID);
		System.out.println (driver.findElement(By.cssSelector("body div")).getText());

		driver.switchTo().window(parentID);
		
		System.out.println	(driver.findElement(By.cssSelector("div h3")).getText());


		
	}

}
