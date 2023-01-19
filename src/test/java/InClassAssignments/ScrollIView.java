package InClassAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollIView {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		Actions act = new Actions(driver);
		 WebElement textArea =  driver.findElement(By.xpath("//textarea"));
		act.scrollToElement(textArea).perform();
		textArea.clear();
		textArea.sendKeys("My Testing");
	}

}
