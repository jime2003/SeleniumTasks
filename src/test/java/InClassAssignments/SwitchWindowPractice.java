package InClassAssignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindowPractice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		List<WebElement> footerLinks =  driver.findElements(By.cssSelector("div[class='orangehrm-login-footer-sm'] a"));
		for(WebElement e:footerLinks) {
			e.click();
		}
		String parent = driver.getWindowHandle();
		Set<String> childTabs = driver.getWindowHandles();
		List<String> allWindowHandle = new ArrayList<String>(childTabs);
		for(String t:allWindowHandle) {
			driver.switchTo().window(t);
			if(!parent.equals(t) && driver.switchTo().window(t).getTitle().contains("Twitter")) {
				System.out.println(driver.findElement(By.xpath("//span[text()='OrangeHRM'][1]")).getText()); 
				driver.switchTo().window(parent);
				break;
			}
			else if(!parent.equals(t)) {
				driver.close();
			}
		}
		

	}

}
