package scenarios;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class scenario1 {
	WebDriver driver;
    @BeforeTest
    public void triggerringbrowser() {
    	System.out.println("launching chrome browser"); 
        System.setProperty("webdriver.chrome.driver", scenarioutil.driverPath);
    	 driver = new ChromeDriver();
    }
     
  @Test
  public void newsitemheadlineTitle() {  
      driver.get(scenarioutil.baseUrl);
      driver.findElement(By.className("feature-card__heading-link--")).isDisplayed();
      driver.findElement(By.className("feature-card__heading-link--")).click();
  }
  @Test
  public void verifynewstitle() {
	  String expectedHeading = "Travellers entering Malaysia via Johor must submit COVID-19 home quarantine application a week before arrival";
	  String heading = driver.findElement(By.className("h1--page-title")).getText();
	  expectedHeading = expectedHeading.replaceAll("[\\n\\t ]", "");
	  heading = heading.replaceAll("[\\n\\t ]", "");
	  if (expectedHeading.contentEquals(heading)){
          System.out.println("Expected News Item Opened");
      } else {
          System.out.println("Expected News Item not Opened");
      }
	  
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