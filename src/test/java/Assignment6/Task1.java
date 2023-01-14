package Assignment6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		/*
		 * 3 xpath and CSS for username
		 */
		System.out.println(driver.findElement(By.cssSelector("[name='username']")).isDisplayed()); 
		System.out.println(driver.findElement(By.cssSelector("[placeholder='Username']")).isDisplayed());  
		System.out.println(driver.findElement(By.cssSelector("div div div [name='username']")).isDisplayed()); 
		
		System.out.println(driver.findElement(By.xpath("//label[contains(text(),'Username')]//following::div[1]/input")).isDisplayed()); 
		System.out.println(driver.findElement(By.xpath("//input[@placeholder='Username']")).isDisplayed());  
		System.out.println(driver.findElement(By.xpath("//input[@name='username']")).isDisplayed()); 
		
		
		/*
		 * 3 xpath and CSS for password
		 */
		System.out.println(driver.findElement(By.cssSelector("[name='password']")).isDisplayed()); 
		System.out.println(driver.findElement(By.cssSelector("[placeholder='Password']")).isDisplayed());  
		System.out.println(driver.findElement(By.cssSelector("div div div [name='password']")).isDisplayed()); 
		
		System.out.println(driver.findElement(By.xpath("//label[contains(text(),'Password')]//following::div[1]/input")).isDisplayed()); 
		System.out.println(driver.findElement(By.xpath("//input[@placeholder='Password']")).isDisplayed());  
		System.out.println(driver.findElement(By.xpath("//input[@name='password']")).isDisplayed()); 
		
		
		/*
		 * 3 xpath and CSS for Login button
		 */
		System.out.println(driver.findElement(By.cssSelector("button[type='submit']")).isDisplayed()); 
		System.out.println(driver.findElement(By.cssSelector("div button[type='submit']")).isDisplayed());  
		System.out.println(driver.findElement(By.cssSelector("div>button[type='submit']")).isDisplayed()); 
		
		System.out.println(driver.findElement(By.xpath("//button[text()=' Login ']")).isDisplayed()); 
		System.out.println(driver.findElement(By.xpath("//button[normalize-space()='Login']")).isDisplayed());  
		System.out.println(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed()); 
		
	}

}
