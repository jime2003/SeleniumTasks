package Helpers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

        public static WebElement elementHighlighter(WebDriver driver, WebElement element){
            
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid red;')", element);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {  
                e.printStackTrace();
            }
            js.executeScript("arguments[0].setAttribute('style','background:#FFFFFF;border-top-color: ;border-right-color: ;border-bottom-color: ;border-left-color: ;')", element);
            return element;
        }

        public static WebElement elementHighlighter(WebDriver driver,By locator){
            WebElement element = driver.findElement(locator);
            
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid red;')", element);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {  
                e.printStackTrace();
            }
            js.executeScript("arguments[0].setAttribute('style','background:#FFFFFF;border-top-color: ;border-right-color: ;border-bottom-color: ;border-left-color: ;')", element);
            return element;
        }

        public static void waitForSeconds(int seconds){
            try {
                Thread.sleep(seconds);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
}    
    

