import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentTest7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	System.setProperty("Webdriver.chrome.driver", "C:\\Users\\riaad\\OneDrive\\Documents\\chromedriver.exe");
	
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
	List<WebElement> columnsCount= driver.findElements(By.cssSelector(".table-display tbody th"));

	System.out.println("Number of columns: "+ columnsCount.size());
	
	List<WebElement> rowsCount= driver.findElements(By.cssSelector(".table-display tbody tr"));

	System.out.println("Number of rows: "+ rowsCount.size());
	
	System.out.println ("Second Row Text: "+driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText());
	
	
	
	}

}
