package Assignment5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tast5 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Open the below application and verify the capture all href values from social media icons. 
		 * Run a loop and verify if any url contains youtube. 
		 * If youtube found then break the loop.
		 * */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		List<WebElement> smIcon = driver.findElements(By.xpath("//div[@class='orangehrm-login-footer-sm']//a"));
		for(WebElement ele:smIcon) {
			String hrefText = ele.getText();
			System.out.println(hrefText);
		}
		for(WebElement ele:smIcon) {
			if(ele.getText().contains("youtube")) {
				System.out.println("Found href with text youtube!");
				break;
			}
			else {
				System.out.println(ele.getText());
			}
		}
		

	}

}
