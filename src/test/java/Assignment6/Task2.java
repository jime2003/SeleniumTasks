package Assignment6;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		driver.findElement(By.cssSelector("[name='username']")).sendKeys("admin");
		driver.findElement(By.cssSelector("[name='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		/*
		 * Write dynamic xpath which should match all below elements
		 * */
		List<WebElement> sidePanel = driver.findElements(By.xpath("//input[@placeholder='Search']//following::ul[1]//span"));
		sidePanel.get(0).click();
		
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("A");
		
		/*
		 * Type A in employee name and write XPath which matches all element in suggestions
		 * */
		
		List<WebElement> employeeNames =  driver.findElements(By.xpath("//div[@role='listbox']//span"));
		for(WebElement e:employeeNames) {
			System.out.println(e.getText());
		}
		
		
		/*
		 *  Write xpath (min 3 and  max no limit) for all elements under Add User section 
		 * */
		
		driver.findElement(By.xpath("//label[text()='User Role']//following::div[contains(text(),'Select')][1]")).click();
		driver.findElement(By.xpath("//div[@role='option']/span[text()='Admin']")).click();
		
		driver.findElement(By.xpath("//label[text()='Status']//following::div[contains(text(),'Select')][1]")).click();
		driver.findElement(By.xpath("//div[@role='option']/span[text()='Enabled']")).click();
		
		driver.findElement(By.xpath("//label[text()='Password']//following::div/input[1]")).sendKeys("Test1234");
		driver.findElement(By.xpath("//label[text()='Confirm Password']//following::div/input[1]")).sendKeys("Test1234");
		driver.findElement(By.xpath("//label[text()='Username']//following::div/input[1]")).sendKeys("senegal123");
		
		


	}

}
