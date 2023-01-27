package Assignment10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task1 {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.findElement(By.id("email1")).sendKeys("ineuron@ineuron.ai");
		driver.findElement(By.id("password1")).sendKeys("ineuron");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
		/*
		 * Mouse Hover on manage
		 * */
		WebElement manageLink = driver.findElement(By.xpath("//span[text()='Manage']"));
		Actions act = new Actions(driver);
		act.moveToElement(manageLink).perform();
		
		/*
		 * Click on Manage courses
		 * */
		driver.findElement(By.xpath("//span[text()='Manage Courses']")).click();
		
		/*
		 * Click on add new course
		 * */
		WebElement addCourse = driver.findElement(By.cssSelector("div.header-div div.manage-btns > button:nth-child(3)"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", addCourse);
		
		/*
		 * Fill all details
		 * */
		 WebElement chooseFile = driver.findElement(By.id("thumbnail"));
		 chooseFile.sendKeys("C:/Users/sv70/Desktop/thumbnail.png");
		 driver.findElement(By.xpath("//h3[text()='Course Name']//following::input[@id='name']")).sendKeys("Cypress-JavaScript");
		 driver.findElement(By.xpath("//h3[text()='Description']//following::textarea[@id='description']")).sendKeys("Learn Cypress-JavaScript");
		 driver.findElement(By.xpath("//h3[text()='Instructor']//following::input[@id='instructorNameId']")).sendKeys("JinalP");
		 WebElement elePrice =   driver.findElement(By.xpath("//h3[text()='Price']//following::input[@value='0']"));
		 elePrice.sendKeys(Keys.BACK_SPACE);	 
		elePrice.sendKeys("10000");
		 driver.findElement(By.xpath("//h3[text()='Starts From']//following::input[@name='startDate']")).click();
		 List<WebElement> allDays = driver.findElements(By.xpath("//div[@role='option']"));
		 for(WebElement e: allDays){
			if(e.getAttribute("aria-selected").equalsIgnoreCase("true")){
				e.click();
				break;
			}
		 }	 
		 driver.findElement(By.xpath("//h3[text()='Ends On']//following::input[@name='endDate']")).click();
		 List<WebElement> allDays1 = driver.findElements(By.xpath("//div[@role='option']"));
		 for(WebElement e: allDays1){
			if(e.getAttribute("aria-selected").equalsIgnoreCase("true")){
				e.click();
				break;
			}
		 }
	
		 driver.findElement(By.xpath("//h3[text()='Category']//following::div[text()='Select Category']")).click();
		 driver.findElement(By.xpath("//div[@class='menu-items']/button[text()='Testing']")).click();
		 driver.findElement(By.xpath("//button[text()='Save']")).click();

		 /*
		 *	Verify course has been added
		 *  */
		String courseName =  driver.findElement(By.xpath("//td[text()='Cypress-JavaScript']")).getText();
		System.out.println(courseName);

		 /*
		  * Delete created course 

		  */
		  driver.findElement(By.xpath("//td[text()='Cypress-JavaScript']//following::button[text()='Delete']")).click();
		  try {
			Thread.sleep(2000, 0);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		  /*
		   * Verify course has been deleted
		   */
		  List<WebElement> courseColumns =  driver.findElements(By.xpath("//td[2]"));
		  for(WebElement ele: courseColumns){
			if (ele.getText().contains("Cypress")) {
				System.out.println("Course not deleted");
				
			} else{
				System.out.println("Course got deleted");
			}
			
		  }
		  /*
		   * Logout from application
		   */
		  driver.findElement(By.xpath("//button[contains(text(),'Sign out')]")).click();
		  

	}
}


