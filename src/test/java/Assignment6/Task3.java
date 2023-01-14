package Assignment6;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		/*
		 * Login
		 * */
		driver.findElement(By.cssSelector("[name='username']")).sendKeys("admin");
		driver.findElement(By.cssSelector("[name='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		/*
		 * Go to Admin and Add User 
		 * */
		List<WebElement> sidePanel = driver.findElements(By.xpath("//input[@placeholder='Search']//following::ul[1]//span"));
		sidePanel.get(0).click();
		
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("A");
		
		/*
		 * Type A in employee name and write XPath which matches all element in suggestions
		 * */
		
		List<WebElement> employeeNames =  driver.findElements(By.xpath("//div[@role='listbox']//span"));
		employeeNames.get(0).click();
		
		/*
		 * Fill out the Form
		 * */
		
		driver.findElement(By.xpath("//label[text()='User Role']//following::div[contains(text(),'Select')][1]")).click();
		driver.findElement(By.xpath("//div[@role='option']/span[text()='Admin']")).click();
		
		driver.findElement(By.xpath("//label[text()='Status']//following::div[contains(text(),'Select')][1]")).click();
		driver.findElement(By.xpath("//div[@role='option']/span[text()='Enabled']")).click();
		driver.findElement(By.xpath("//label[text()='Username']//following::div/input[1]")).sendKeys("senegal1234");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		driver.findElement(By.xpath("//label[text()='Password']//following::div/input[1]")).sendKeys("@Test1234");
		driver.findElement(By.xpath("//label[text()='Confirm Password']//following::div/input[1]")).sendKeys("@Test1234");
		/*
		 * Click on Save button
		 * */		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	//	JavascriptExecutor js = (JavascriptExecutor)driver;
	//	js.executeScript("arguments[0].click()",saveButton);
		//driver.findElement(By.xpath("//div[@class='oxd-form-actions']")).click();
		
		
		
		/*
		 * Verify if user has been added successfully
		 * */
		Thread.sleep(4000);
		String successMessageAfterAddUser = driver.findElement(By.xpath("//p[text()='Successfully Saved']")).getText();
		if(successMessageAfterAddUser.contains("Saved")) {
			System.out.println("User Added Successfully");
		}
		else {
			System.out.println("Some issue happened during adding a user");
		}
		
		/*
		 * Delete the username
		 * */
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		driver.findElement(By.xpath("//div[@role='row']/div[@role='cell']/div[text()='senegal1234']//following::button[@type='button'][1]")).click();
		driver.findElement(By.xpath("//div[@class='orangehrm-text-center-align']//following::button[2]")).click();
		Thread.sleep(3000);
		String successMessageAfterDeleteUser = driver.findElement(By.xpath("//p[text()='Successfully Deleted']")).getText();
		if(successMessageAfterDeleteUser.contains("Deleted")) {
			System.out.println("User Deleted Successfully");
		}
		else {
			System.out.println("Some issue happened during deleting a user");
		}
		
		/*
		 * User Logout
		 * */
		
		driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
		driver.findElement(By.xpath("//ul[@role='menu']/li/a[text()='Logout']")).click();
		String loginPage =driver.findElement(By.xpath("//h5[text()='Login']")).getText();
		System.out.println("User is navigated to "+loginPage+" page");
	}

}
