package Assignment7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static void main(String[] args) throws InterruptedException {
		String borderStyle = "1px";
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		/*
		 * Click on login button (No need to enter login details)
		 * */
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		/*
		 * Verify that username and password have border of 1px.
		 *	Note- use getCssProperty to fetch css details

		 * */
		
		String cssPropertyUsername = driver.findElement(By.name("username")).getCssValue("border");
		String cssPropertyPassword = driver.findElement(By.name("password")).getCssValue("border");
		if(cssPropertyUsername.contains(borderStyle)) {
			System.out.println("username test case passed");
		}else {
			System.out.println("username test case failed");
		}
		if(cssPropertyPassword.contains(borderStyle)) {
			System.out.println("password test case passed");
		}else {
			System.out.println("password test case failed");
		}
		
		
	}

}
