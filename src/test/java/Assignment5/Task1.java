package Assignment5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		boolean checkEndsWith = driver.getCurrentUrl().endsWith("login"); //capture the url and check endsWith login
		System.out.println("url ends with login: "+checkEndsWith);
		
		boolean checkContains = driver.getCurrentUrl().contains("demo"); //capture the url and check url contains demo
		System.out.println("url contains demo: "+checkContains);
		
		boolean title = driver.getTitle().contains("HRM"); //verify title contains HRM
		System.out.println("Title of the page contains HRM: " + title);
		driver.quit();
	}

}
