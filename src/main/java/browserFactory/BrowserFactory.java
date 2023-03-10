package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class BrowserFactory {
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
    
}
