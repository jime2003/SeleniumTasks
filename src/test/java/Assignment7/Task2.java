package Assignment7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
		/*
		 * Enter username as admin and click on the login button 
		 * */
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		/*
		 * Verify password field is showing the required message.
		 * */
		String hardEdit = driver.findElement(By.xpath("//input[@name='password']//following::span")).getText();
		System.out.println(hardEdit);
		if(hardEdit.contains("Required")) {
			System.out.println("Required message for blank password field is present");
		} else {
			System.out.println("Required message for blank password field is missing");
		}
	}

}
