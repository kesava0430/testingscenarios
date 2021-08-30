package scenarios;
import java.util.List;
import org.openqa.selenium.*;

public class scenarioutil {
    public static final String baseUrl = "https://www.channelnewsasia.com/news/international";
    public static final String driverPath = "/Users/kesava-2647/Desktop/seleniumjars/chromedriver"; 
    
    public static void scrollingandverifying(WebDriver driver) {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
   	  for(int i=0 ;i<=3;i++) {
   		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
   	  try {
   	  Thread.sleep(5000);
   	  }
   	  catch(InterruptedException ie){
   	  }
   	  }
   	  List<WebElement> listofstories = driver.findElements(By.linkText("Expand to read the full story"));
   	  System.out.println(listofstories);
   	  js.executeScript("arguments[0].scrollIntoView(true);",listofstories.get(1));
   	  js.executeScript("arguments[0].click();",listofstories.get(1));
   	  if(listofstories.get(1).isDisplayed()) {
   		  System.out.println("Expected story has not opened");
   	  }else {
   		  System.out.println("Expected story has been opened");
   	  }	  
    }
    
     
}