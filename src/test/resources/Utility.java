import org.openqa.selenium.WebElement;

public class Utility {   
        public void clearWebField(WebElement element){
            while(!element.getAttribute("value").equals("")){
                element.sendKeys(Keys.BACK_SPACE);
            }
        }
  
    }
    

