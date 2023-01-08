package Assignement9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task {

	public static void main(String[] args) throws InterruptedException {
		String email = "Jinal@test3.com";
		String password = "Test1234";
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.findElement(By.cssSelector("[class='subLink']")).click();
		Thread.sleep(9000);
		boolean statusBefore = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
		System.out.println("Status of SignUp before filling out form is: "+statusBefore);
		driver.findElement(By.id("name")).sendKeys("Jinal");
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);		
		driver.findElement(By.cssSelector("div[class='interests-div'] div:nth-child(3)")).click();
		driver.findElement(By.id("gender")).click();
		Select ddoption = new Select(driver.findElement(By.id("state")));
		ddoption.selectByValue("Gujarat");
		WebElement signUp = driver.findElement(By.xpath("//button[@type='submit']"));
		boolean statusAfter = signUp.isEnabled();
		System.out.println("Status of SignUp after filling out form is: "+statusAfter);
		signUp.click();
		Thread.sleep(6000);
		
		// login with same above credentials
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.id("password1")).sendKeys(password);
		driver.findElement(By.className("submit-btn")).click();
		Thread.sleep(5000);
		boolean signOutVisibility = driver.findElement(By.xpath("//button[contains(text(),'Sign out')]")).isDisplayed();
		if(signOutVisibility==true) {
			System.out.println("Login Successfully");	
		}
		else {
			System.out.println("Login Failed");
		}
		
		driver.findElement(By.xpath("//button[contains(text(),'Sign out')]")).click();
		
		
		
		
		driver.quit();
		

	}

}
