

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class brokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\riaad\\OneDrive\\Documents\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
	
	List<WebElement> links=	driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
	SoftAssert a= new SoftAssert();
	
	for (WebElement link: links)
		{
			
		//	String url= driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
			String url=link.getAttribute("href");
			
			
			//HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
			HttpURLConnection conn=(HttpURLConnection)new URI(url).toURL().openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode= 	conn.getResponseCode();
		//System.out.println(respCode);
			a.assertTrue(respCode<400, "The link with Text"+ link.getText() + "is broken with code"+respCode);
	
			
			
			/*		if (respCode>400)
			
			{
				System.out.println ("The link with Text"+ link.getText() + "is broken with code"+respCode );
				Assert.assertTrue(false);
			
			}
			
			*/
		
		}
	
			a.assertAll();
	
	
	
	}

}
