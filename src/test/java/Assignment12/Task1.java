package Assignment12;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Helpers.Utility;

public class Task1 {
	WebDriver driver;
	@BeforeMethod
	@Parameters({"browserName"})	
	public void setUp(String browserName){
		 driver =Utility.startBrowser(browserName, "https://ineuron-courses.vercel.app/login");
		
		
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();

	}

    @Test 	
    public void useTestNG(){
		driver.findElement(By.id("email1")).sendKeys("ineuron@ineuron.ai");
		driver.findElement(By.id("password1")).sendKeys("ineuron");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		/*
		 * Mouse Hover on manage
		 * */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Manage']")));
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
		 chooseFile.sendKeys("C:/Users/sv70/Documents/GitHub/SeleniumTasks/src/test/resources/UploadImage/thumbnail.png");
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
		WebDriverWait wait0 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait0.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Cypress-JavaScript']")));
		WebElement courseName =  driver.findElement(By.xpath("//td[text()='Cypress-JavaScript']"));
		Point getCourseLoc = courseName.getLocation();
		int xcordCourse = getCourseLoc.getX();
		int ycordCourse = getCourseLoc.getY();
		Actions act0 = new Actions(driver);
		act0.moveByOffset(xcordCourse, ycordCourse);
        Assert.assertTrue(courseName.isDisplayed());

		 /*
		  * Delete created course 

		  */
		

		  WebElement ele = driver.findElement(By.xpath("//td[text()='Cypress-JavaScript']//following::button[text()='Delete']"));
		  try {
			ele.click();
		  } catch (Exception e) {
			Rectangle rect = ele.getRect();
			int deltaY = rect.y + rect.height;
			new Actions(driver).scrollByAmount(0, deltaY).perform();
			ele.click();
			
		  }

		  try {
			Thread.sleep(4000, 0);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		  /*
		   * Verify course has been deleted
		   */
		  List<WebElement> courseColumns =  driver.findElements(By.xpath("//td[2]"));
          for(WebElement element:courseColumns){
            Assert.assertFalse(element.getText().contains("Cypress"));
          }
          

	
		  /*
		   * Logout from application
		   */
		  driver.findElement(By.xpath("//button[contains(text(),'Sign out')]")).click();
    }
}
