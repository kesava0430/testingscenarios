package scenarios;
import java.util.List;
import org.openqa.selenium.*;
import org.testng.annotations.*;

public class scenario3 {
	WebDriver driver;
	scenarioutil scenarioutil = new scenarioutil();
    @BeforeTest
    public void triggerringbrowser() {   	
  	  driver = scenarioutil.gettriggeringbrowser();
  	  
    }
     
  @Test
  public void changingtosingopore() { 
	  driver.get(scenarioutil.baseUrl);
	  driver.findElement(By.cssSelector("#main-nav > ul > li.main-menu__item.is-hide-link > span")).click();
	  driver.findElement(By.cssSelector(".layout-container > div:nth-child(3) > section > div > div > div > div > div.modal__content__col.modal__content__col--one > div.modal__secondary-menu > ul > li:nth-child(11) > a")).click();
	  //driver.findElement(By.cssSelector("div.card-object.card-object--.top-stories-primary-section__item > div.card-object__content.card-object__content-- > div > div > h3 > a")).click();
  }
  @Test
  public void checkingweathervalues() {
	     List<WebElement> allcities = driver.findElements(By.cssSelector(".tabular-list__view--item > div > div:nth-child(1)"));
	    for ( WebElement we: allcities) {  
	    	System.out.println(we.getText());
	        if ( we.getText().contains("Singapore") ) {
	        	System.out.println("Weater for the City : "+we.getText());
	        	System.out.println("Condition for the City : "+driver.findElement(By.cssSelector(".tabular-list__view--item > div > div:nth-child(2)")).getText());
	        	System.out.println("MAX Temp for the City : "+driver.findElement(By.cssSelector(".tabular-list__view--item > div.tabular-list__view--temp > span:nth-child(1)")).getText());
	        	System.out.println("Min Temp for the City : "+driver.findElement(By.cssSelector(".tabular-list__view--item > div.tabular-list__view--temp > span:nth-child(2)")).getText());
	        	break;
	        }
	    }
  }
  @AfterTest
  public void closingbrowser() {
   driver.close(); 
  }
}