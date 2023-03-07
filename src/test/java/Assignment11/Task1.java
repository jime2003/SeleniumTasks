package Assignment11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Helpers.Utility;

public class Task1 {
    
    @Test
    public void explicitWaitWithCondition1(){
        WebDriver driver = Utility.startBrowser("Chrome", "http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
        driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
        WebElement ele = driver.findElement(By.xpath("//p[@id='demo']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBe(By.xpath("//p[@id='demo']"), "WebDriver"));
    
    }
    
    @Test
    public void explicitWaitWithCondition2(){
        WebDriver driver = Utility.startBrowser("Chrome", "http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
        driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
        WebElement ele = driver.findElement(By.xpath("//p[@id='demo']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElement(ele, "WebDriver"));
    
    }
}
