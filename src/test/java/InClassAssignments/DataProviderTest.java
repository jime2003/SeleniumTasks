package InClassAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Helpers.Utility;

public class DataProviderTest {
    @Test(dataProvider = "randomData")   
    public void test1(String uname, String password){
       WebDriver driver = Utility.startBrowser("Chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uname); 
       driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
       driver.findElement(By.xpath("//button[@type='submit']")).click(); 
        Reporter.log(uname,true);
        Reporter.log(password,true);
    }

    @DataProvider (name="randomData")
    public Object[][] sampleData(){
        Object[][] sample = new Object[2][2];
        sample[0][0] = "Admin";
        sample[0][1] = "Admin123";
        sample[1][0] = "Jinal";
        sample[1][1] = "Patel";
        return sample;
        
    }
    
}
