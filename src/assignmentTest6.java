import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class assignmentTest6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\riaad\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement selectedcheckBox= driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input"));
		selectedcheckBox.click();
		selectedcheckBox.getText();
		
		String selectedcheckBoxText =driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText().trim();
		
		WebElement optionDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(optionDropdown);
		dropdown.selectByVisibleText(selectedcheckBoxText);
		
		driver.findElement(By.id("name")).sendKeys(selectedcheckBoxText);
		driver.findElement(By.id("alertbtn")).click();
		String alertText=driver.switchTo().alert().getText();
		
		if (alertText.contains(selectedcheckBoxText))
			
		{
			System.out.println("Test successfull");
		}
		else
		{

			System.out.println("failed");
			
		}
		
		
		
		
	
	
	}

}
