package selenium;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Howley {
	
	public WebDriver driver;
	Wait<WebDriver> wait;
	SoftAssert softAssert = new SoftAssert();
	final String usernameInput = "Megha";
	final String titleInput1 = "page1";
	final String bodyInput1 = "body1 ";
	final String state = "Draft";
	DateFormat dateFormat= new SimpleDateFormat("yyyy/MM/DD"); 
	Date date = new Date();
	
	@Test
	public void login()
	{
		try
		{
	      driver.findElement(By.id("user_login")).sendKeys("mm");
	      driver.findElement(By.id("user_pass")).sendKeys("s1rp4syMPJM9");
	      driver.findElement(By.id("rememberme")).click();
	      driver.findElement(By.id("wp-submit")).click();
		}
	    
		catch(NoSuchElementException e)
		{
			System.out.println(e);
		}
		
		catch(TimeoutException e)
		{
			System.out.println(e);
		}
		catch(ElementNotVisibleException e)
		{
		   System.out.println(e);
		}
		catch(NullPointerException e)
		{
			System.out.println(e);
		}
		
	}
	
	
	@Test
	public void displayAllPages()
	{
		  wait = new WebDriverWait(driver, 4000);
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All Pages"))).click();
	
		
	} 

	
	
	
	
	@BeforeClass
	public void beforeMethod()
	{
		driver = new FirefoxDriver();
		driver.get("http://howley.in/wp-admin/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void afterMethod()
	{
		//driver.quit();
		
	}

}
