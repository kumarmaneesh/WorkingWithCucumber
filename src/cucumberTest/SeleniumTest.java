	
package cucumberTest;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
 
public class SeleniumTest {
		private static WebDriver driver = null;
		static String driverPath = "C:\\Users\\ttc.mk\\Desktop\\MK\\";
	public static void main(String[] args) {
		
		try{
			System.out.println("launching Chrome browser");
			
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			//driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://www.store.demoqa.com");

			//Below code is to bypass zscalar authentication
			//*****************************************************************************************************
			Thread.sleep(3000);
			driver.findElement(By.name("lognsfc")).sendKeys("surbhi.kukreja.ttc@sgx.com");
			driver.findElement(By.name("lsubmit")).click();

			driver.findElement(By.name("passsfc")).sendKeys("Password123");
			driver.findElement(By.name("bsubmit")).click();
			Thread.sleep(2000);
			}catch(Exception e){
				//This is to print the logs - Method Name & Error description/stack
				System.out.println("Not able to open Browser --- " + e.getMessage());
				//Set the value of result variable to false
				
				}
		
        //driver = new FirefoxDriver();
 
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        //Launch the Online Store Website
 
        driver.get("http://www.store.demoqa.com");
 
        // Find the element that's ID attribute is 'account'(My Account) 
 
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
 
        // Find the element that's ID attribute is 'log' (Username)
 
        // Enter Username on the element found by above desc.
 
        driver.findElement(By.id("log")).sendKeys("testmk"); 
 
        // Find the element that's ID attribute is 'pwd' (Password)
 
        // Enter Password on the element found by the above desc.
 
        driver.findElement(By.id("pwd")).sendKeys("2w3e4r5t^Y");
 
        // Now submit the form. WebDriver will find the form for us from the element 
 
        driver.findElement(By.id("login")).click();
 
        // Print a Log In message to the screen
 
        System.out.println("Login Successful");
 
        // Find the element that's ID attribute is 'account_logout' (Log Out)
 
        driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
 
        // Print a Log In message to the screen
 
        System.out.println("LogOut Successful");
 
        // Close the driver
 
        driver.quit();
 
	}
 
}