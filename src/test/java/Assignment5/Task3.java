package Assignment5;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		List<WebElement> smIcon = driver.findElements(By.xpath("//div[@class='orangehrm-login-footer-sm']//a"));	
		int icons = smIcon.size();
		System.out.println("Social Icons number in the footer is: "+icons);
		for (WebElement webElement : smIcon) {
			System.out.println(webElement.getText());
		}
		driver.quit();
		

	}

}
