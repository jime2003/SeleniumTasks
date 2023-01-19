package Assignment7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		/*
		 * Enter username as admin and password as admin123 and click on the login button 
		 * */
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		/*
		 * Capture the url and verify url contains dashboard
		 * */
		String landingPageUrl = driver.getCurrentUrl();
		System.out.println(landingPageUrl);
		if(landingPageUrl.contains("dashboard")) {
			System.out.println("User is on landing page");
		} else {
			System.out.println("Something wrong happened");
		}
		
		/*
		 * Click on image > Click on Logout
		 * */
		driver.findElement(By.xpath("//img[@alt='profile picture'][1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		
		/*
		 * Verify after logout the user is able to navigate to the login page.
		 * */
		String loginLabel = driver.findElement(By.xpath("//h5")).getText();
		if(loginLabel.contains("Login")) {
			System.out.println("The user is on login page");
		} else {
			System.out.println("Something went wrong during logout");
		}
	}

}
