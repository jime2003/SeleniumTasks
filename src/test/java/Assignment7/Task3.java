package Assignment7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
		/*
		 * Enter username as admin and password as mukesh and click on the login button 
		 * */
		
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("mukesh");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		/*
		 * Capture error message and verify message contains Invalid credentials
		 * */
		String invalidCredMessage = driver.findElement(By.xpath("//p[contains(@class,'oxd-alert-content-text')]")).getText();
		System.out.println(invalidCredMessage);
		if(invalidCredMessage.contains("Invalid credentials")) {
			System.out.println("Invalid Credential message is present");
		} else {
			System.out.println("Invalid Credential message is present");
			
		}
	}

}
