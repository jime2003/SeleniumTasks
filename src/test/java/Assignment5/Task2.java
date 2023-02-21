package Assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		boolean logoPresence = driver.findElement(By.xpath("//img[contains(@src,'/web/images/ohrm_branding.png')]")).isDisplayed();
		
		if(logoPresence){
			System.out.println("Logo is present");
			
		} else{
			System.out.println("Logo is not present");
		}

	}

}
