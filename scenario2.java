package scenarios;
import org.openqa.selenium.*;
import org.testng.annotations.*;

public class scenario2 {
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
	  driver.findElement(By.cssSelector(".layout-container > div:nth-child(3) > section > div > div > div > div > div.modal__content__col.modal__content__col--one > div.modal__secondary-menu > ul > li:nth-child(1) > ul > li:nth-child(1) > a")).click();
	  driver.findElement(By.cssSelector("div.card-object.card-object--.top-stories-primary-section__item > div.card-object__content.card-object__content-- > div > div > h3 > a")).click();
  }
  @Test
  public void scrollingfornewtaskstoopen() {
	  scenarioutil.scrollingandverifying(driver);  
  }
  @AfterTest
  public void closingbrowser() {
   driver.close(); 
  }
}