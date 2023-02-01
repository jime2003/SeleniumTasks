package Assignment11;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Helpers.Utility;

public class Task1 {
    
    @Test
    public void explicitWait(){
        WebDriver driver = Utility.startBrowser("Chrome", "http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
        
    }
}
