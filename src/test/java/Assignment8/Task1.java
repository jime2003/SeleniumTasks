package Assignment8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static void main(String[] args) {
		/*
		 * Capture the below text and verify text contains the below text
		 * */
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String fbContent = driver.findElement(By.xpath("//h2")).getText();
		if(fbContent.contains("Connect with friends and the world around you on Facebook.")) {
			System.out.println("Test case passed");
		}else {
			System.out.println("Test case failed");
		}

	}

}
