import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class calenderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String year="2027";
String monthNumber = "6";
String date="13";
String[] expectedDateList= {monthNumber,date,year};


		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\riaad\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//explicit wait
		WebDriverWait w = new WebDriverWait (driver,Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
	
	//	System.out.println (driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText());
	List <WebElement> actualDateList= driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
	 for (int i=0;i<actualDateList.size();i++)
		 
	 {
		 
		System.out.println ( actualDateList.get(i).getAttribute("value"));
		Assert.assertEquals(actualDateList.get(i).getAttribute("value"), expectedDateList[i]);
	
	 }
	driver.close();
	
	
	}


}
