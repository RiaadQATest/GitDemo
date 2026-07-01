import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class endToEndTesting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\riaad\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//1.find count of links on page, link should use anchor "a" tagname.
		System.out.println (driver.findElements(By.tagName("a")).size());
		//2.limiting scope to get links count in footer section
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));
		System.out.println (footerdriver.findElements(By.tagName("a")).size());
		// 3 select links in first column 
		
		WebElement columndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println (columndriver.findElements(By.tagName("a")).size());
		
		//4. click on each link in column and check if the pages are opening
		 for (int i=1;i<columndriver.findElements(By.tagName("a")).size();i++ )  //i=1 because first link does not work 
	
		 {
			String clickOnLink= Keys.chord(Keys.CONTROL,Keys.ENTER);
			 
			 columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			 Thread.sleep(5000);
			 
		 }
			 Set <String> abc=driver.getWindowHandles();
			 Iterator<String> it=abc.iterator();
			 
			 while (it.hasNext())
			 {
				 
				 driver.switchTo().window(it.next());
				 System.out.println (driver.getTitle());
				 
			
			
			  }
	
	
	
		 
		 
	
	
	}

}
