package Assignment8;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task4 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		/*
		 * Click on Create new account
		 * */
		driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		/*
		 * Fill in all details and click on the Signup button using CSS selectors
		 * */
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Hello");
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("World");
		driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("HelloWorld@abc.com");
		driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']")).sendKeys("HelloWorld@abc.com");
		driver.findElement(By.cssSelector("input[name='reg_passwd__']")).sendKeys("@Test1234");
		Select month = new Select(driver.findElement(By.cssSelector("select[name='birthday_month']")));
		month.selectByValue("7");
		Select day = new Select(driver.findElement(By.cssSelector("select[name='birthday_day']")));
		day.selectByValue("26");
		Select year = new Select(driver.findElement(By.cssSelector("select[name='birthday_year']")));
		year.selectByValue("1987");
		List<WebElement> gender = driver.findElements(By.cssSelector("span[data-name='gender_wrapper'] span label"));
		for(WebElement el:gender) {
			if (el.getText().contains("Male")) {
				el.click();
				break;
			}
		}
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
	}	

}
