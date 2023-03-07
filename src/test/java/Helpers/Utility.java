package Helpers;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {   
        public static void clearWebField(WebElement element){
            while(!element.getAttribute("value").equals("")){
                element.sendKeys(Keys.BACK_SPACE);
            }
        }
  
    
        public static WebDriver startBrowser(String browserName, String appUrl){
            WebDriver driver =null;
            if (browserName.contains("Chrome") || browserName.contains("Google Chrome")) {
                driver = new ChromeDriver();
                
            }
            else if(browserName.contains("Edge") || browserName.contains("Microsoft Edge")){
                driver = new EdgeDriver();
            }
            else if(browserName.contains("FireFox") || browserName.contains("Mozilla Firefox")){
                driver = new FirefoxDriver();

            }
            else{
                Reporter.log(browserName + "not supported");
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
            driver.get(appUrl);

            return driver;
        }
        
        public static void waitForSeconds(int seconds) {
        	try {
				Thread.sleep(seconds*1000);
			} catch (InterruptedException e) {
				
			}
        }
        
        public static WebElement waitForElement(WebElement element,int seconds) throws InterruptedException {
        	int intMillis = 1000;
        	boolean flag = false;
        	long end = System.currentTimeMillis() + (seconds * intMillis);
        	while(System.currentTimeMillis()<end) {
        		try {
        			element.isEnabled();
        			flag=true;
        			break;
        			
					
				} catch (Exception e) {
					 System.out.println("Still waiting for the element");
					
				}
        			waitForSeconds(1);
        	}
        	return element;
        }
        
        public static String getCurrentTime() {
        	String date = new SimpleDateFormat("HH:mm:ss_dd_MM_yyyy").format(new Date());
        	return date;
     
        }
        
        public static void captureScreenshotOfPage(WebElement element, WebDriver driver) {
        	try {
				FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("./screenshots/screenshot"+getCurrentTime()+".png"));
			} catch (IOException e) {
				System.out.println("Something wen wrong"+e.getMessage());
		
			}
        }
        
        public static void captureScreenshotOfWebElement(WebElement element, WebDriver driver) {
        	try {
      
				FileHandler.copy(element.getScreenshotAs(OutputType.FILE), new File("./elementScreenshots/element"+getCurrentTime()+".png"));
			} catch (IOException e) {
				System.out.println("Something wen wrong"+e.getMessage());
		
			}
        }
        
        
        
     
}    
    

