package stepDefinition;
 
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 
public class TestSteps {
	public static WebDriver driver;
	static String driverPath = "C:\\Users\\ttc.mk\\Desktop\\MK\\";
	@Test
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
        //driver = new FirefoxDriver();
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.store.demoqa.com");
		}
 
	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		}
 
	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
		driver.findElement(By.id("log")).sendKeys("testmk"); 	 
	    driver.findElement(By.id("pwd")).sendKeys("2w3e4r5t^Y");
	    driver.findElement(By.id("login")).click();
		}
 
	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Login Successfully");
	}
	
	@Given("^User is logged in$")
	public void user_is_logged_in() throws Throwable {
	   System.out.println("User is already logged in.. Proceed to logout");
	}
 
	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
	}
 
	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
		System.out.println("Logout Successfully");
	    //throw new PendingException();
	}
	
	@Then("^User closes the browser$")
	public void user_closes_the_browser() throws Throwable {
	   System.out.println("User closed the browser successfully");
	   driver.quit();
	}
 
}
