package Assignment5;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		List<WebElement> smIcon = driver.findElements(By.xpath("//div[@class='orangehrm-login-footer-sm']/a"));
		for(WebElement ele:smIcon){
			if(ele.getAttribute("href").contains("linkedin")){
				HashMap<String,String> smIconMap = new HashMap<String,String>();
				smIconMap.put("Linkedin", ele.getAttribute("href"));
				System.out.println(smIconMap);
				

			}else if (ele.getAttribute("href").contains("facebook")){
				HashMap<String,String> smIconMap = new HashMap<String,String>();
				smIconMap.put("FaceBook", ele.getAttribute("href"));
				System.out.println(smIconMap);
			
			} else if(ele.getAttribute("href").contains("twitter")){
				HashMap<String,String> smIconMap = new HashMap<String,String>();
				smIconMap.put("Twitter", ele.getAttribute("href"));
				System.out.println(smIconMap);
			} else if(ele.getAttribute("href").contains("youtube")){
				HashMap<String,String> smIconMap = new HashMap<String,String>();
				smIconMap.put("YouTube", ele.getAttribute("href"));
				System.out.println(smIconMap);

			}
		
		
		}
		

	}

}
