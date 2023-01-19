package Assignment8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		/*
		 * Capture all link text available in the footer section and verify Create Page Link is present or not. If yes then click on it.
		 * */
		List<WebElement> footerLinks =  driver.findElements(By.xpath("//div[@role='contentinfo']//a"));
		for(WebElement el:footerLinks) {
			if(el.getText().contains("Create Page")) {
				el.click();
				break;
			}
		}
	}

}
