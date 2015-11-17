package selenium;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.JavascriptExecutor;

//@Test(groups = { "funcTest" })
public class HowleyProfile {
	public WebDriver driver;
	Wait<WebDriver> wait;
	SoftAssert softAssert = new SoftAssert();
	final String usernameInput = "Megha";
	//final String titleInput1 = "page";
	final String titleInput1 = "page1";
	final String bodyInput1 = "body1 ";
	final String state = "Draft";
	final String titleInput2 = "vj";
	DateFormat dateFormat= new SimpleDateFormat("yyyy/MM/DD"); 
	Date date = new Date();
	
	
	@Test(groups = { "pageLoad" })
	public void loadPage()
	{
		//driver.get("http://howley.in/wp-admin/");
		driver.get("http://howley.in");
		driver.manage().window().maximize();
		
	}
	/*
	@Test(groups = { "funcTest" }, dependsOnMethods = { "loadPage" })
	public void login()
	{ 
			wait = new WebDriverWait(driver, 4000);
		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login"))).click();
		      //  driver.findElement(By.linkText("Login")).click();
		      driver.findElement(By.id("user_login")).sendKeys("mm");
		      driver.findElement(By.id("user_pass")).sendKeys("s1rp4syMPJM9");
		      driver.findElement(By.id("rememberme")).click();
		      //  driver.findElement(By.id("wp-submit")).click();
		      driver.findElement(By.name("user-submit")).click();
		      
		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SEO")));
		      //WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("title")));
		      String title = driver.getTitle();
		      System.out.println(title);
		      System.out.println("title: "+"SUBJ1");
		      softAssert.assertEquals(title, "SUBJ1", "Title incorrect");

		
	}
	/*
	@Test(groups = { "funcTest" }, dependsOnMethods = { "login" })
	public void displayAllPages()
	{
			 // driver.findElement(By.id("save-post")).click();
		     // System.out.println("clkd");
		     
		      Actions action = new Actions(driver);
		      WebElement menuPages = driver.findElement(By.id("menu-pages"));
		     // WebElement menuPages = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu-pages")));
		 	  action.moveToElement(menuPages);
		      action.perform();

		  
		  wait = new WebDriverWait(driver, 4000);
			  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All Pages"))).click();
	
	}
	*/
	/*
	@Test(groups = { "funcTest" }, dependsOnMethods = { "displayAllPages" })
	public void displayTableHeading()
	{
			  //WebElement pageTable = driver.findElement((By.cssSelector("table,[class='wp-list-table.widefat.fixed.pages']")));
			  WebElement pageTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table,[class='wp-list-table.widefat.fixed.pages']")));
			  
			  WebElement tableHead = pageTable.findElement(By.tagName("thead"));
			  List<WebElement> tableHeadings = tableHead.findElements(By.tagName("tr"));
			  System.out.println(tableHeadings.size());
  
			  for(WebElement tableHeading : tableHeadings)
			  {
				  List<WebElement> tableHeadingValue = tableHeading.findElements(By.tagName("th"));
			   	  System.out.println(tableHeadingValue.size());
			   	  
			   	  String tableHeading1 = tableHeadingValue.get(0).getText();
			   	  softAssert.assertEquals(tableHeading1, "Select All", "Select All incorrect");
			   	  String tableHeading2 = tableHeadingValue.get(1).getText(); 
			   	  softAssert.assertEquals(tableHeading2, "Title", "Title incorrect");
			   	  String tableHeading3 = tableHeadingValue.get(2).getText();
			   	  softAssert.assertEquals(tableHeading3, "Author", "Author incorrect");
			   	  String tableHeading4 = tableHeadingValue.get(3).getText();
			   	  softAssert.assertEquals(tableHeading4, "", "Comments incorrect");
			   	  String tableHeading5 = tableHeadingValue.get(4).getText();
			   	  softAssert.assertEquals(tableHeading5, "Date", "Date incorrect");
			   	  String tableHeading6 = tableHeadingValue.get(5).getText();
			   	  softAssert.assertEquals(tableHeading6, "Views", "Views incorrect");
			   	  softAssert.assertAll();

			  }

	}
	
	@Test(groups = { "funcTest" }, dependsOnMethods = { "displayTableHeading" })
	public void displayTableRowValues()
	{

			  WebElement pageTable = driver.findElement((By.cssSelector("table,[class='wp-list-table.widefat.fixed.pages']")));
			  WebElement tableRow = pageTable.findElement(By.tagName("tbody"));
			  List<WebElement> tableRows = tableRow.findElements(By.tagName("tr"));
			  System.out.println(tableRows.size());
			  
			  for(WebElement rowValue : tableRows)
			  {
				  List<WebElement> tableRowThValue = rowValue.findElements(By.tagName("th"));
				  List<WebElement> tableRowTdValue = rowValue.findElements(By.tagName("td"));
				  System.out.println(tableRowThValue.size());
				  System.out.println(tableRowTdValue.size());
				  
				  for(WebElement rowThVal : tableRowThValue)
				  {
					  String thValue = rowThVal.getText();
					  System.out.println(thValue);
				  }
				  
				  for(WebElement rowTdVal : tableRowTdValue)
				  {
					  String tdValue = rowTdVal.getText();
					  System.out.println(tdValue);
				  }
			  } 
	
	}
	

	@Test(groups = { "funcTest" }, dependsOnMethods = { "displayAllPages" /*"displayTableRowValues" })
	public void dispalySortedRows()
	{

			//System.out.println("n");
			//driver.findElement(By.linkText("spam queue"));
		     // driver.findElement(By.id("save-post")).click();
			//driver.findElement(By.linkText("BuddyPress Media Component")).click();
		      //driver.findElement(By.id("title")).sendKeys("abc");
			//driver.findElement(By.id("atd_onpublish")).click();
			//System.out.println("p clk");
			//driver.findElement(By.className("add-new-h2")).click();
			
			  Actions action = new Actions(driver);
			  WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
			  action.moveToElement(title);
			  action.perform();
	  
			  System.out.println("tile hovered");
	  
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sorting-indicator"))).click();
		      System.out.println("sort clicked");
	  
		      Actions action2 = new Actions(driver);
		      WebElement title2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
		      action2.moveToElement(title2);
		      action2.perform();
	  
		      System.out.println("tile hovered");
	  
		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sorting-indicator"))).click();
		      System.out.println("sort clicked");
	
	}
	
	
	@Test(groups = { "funcTest" }, dependsOnMethods = { "dispalySortedRows" })
	public void verifyInputPage()
	{
			  WebElement pageTable = driver.findElement(By.cssSelector("table,[class='wp-list-table.widefat.fixed.pages']"));
			  
		      
		      WebElement tableRow = pageTable.findElement(By.tagName("tbody"));
		      List<WebElement> tableRows = tableRow.findElements(By.tagName("tr"));
		      	      
		      for(WebElement rowValue: tableRows)
		      {
		    	  
		    	  List<WebElement> tableRowTdValue = rowValue.findElements(By.tagName("td"));
		    	  
		    	//  List<WebElement> titleValue =  tableRowTdValue.get(0);
		    	  
		    	  
		    	  
		    	  for(WebElement rowTdValue : tableRowTdValue)
		    	  { 
		    	  	// String value = tableRowTdValue.get(0).getText();
		    		 String value = rowTdValue.getText();
		    		 String titleValue = titleInput1+" - "+state;
		    		 if(value.matches(titleValue))
		    		 {
		    			 softAssert.assertEquals(titleValue, "page1 - Draft", "titleValue incorrect");
		    			 String rowValue2 = tableRowTdValue.get(1).getText();
		    			 softAssert.assertEquals(rowValue2, usernameInput , "usernameInput incorrect");
		    			 String rowValue3 = tableRowTdValue.get(2).getText();
		    			 System.out.println(rowValue3);
		    			 softAssert.assertEquals(rowValue3, "0", "Comments number incorrect");
		    			 String rowValue4 = tableRowTdValue.get(3).getText();
		    			 System.out.println(rowValue4);
		    			   DateFormat dateFormat= new SimpleDateFormat("yyyy/MM/DD"); 
		    			   Date date = new Date();
		    			   System.out.println(dateFormat.format(date));
		    			   String dateDisplay = dateFormat.format(date);
		
		    			 softAssert.assertEquals(rowValue4, "2015/05/29"+"\n"+"Last Modified", "date incorrect");
		    			 String rowValue5 = tableRowTdValue.get(4).getText();
		    			 softAssert.assertEquals(rowValue5, "", "Views value incorrect");
		    			 softAssert.assertAll();
		    		 }
		    	  }
		    	  
		       }


	}
	
	@Test(groups = { "funcTest" }, dependsOnMethods = { "dispalySortedRows" /*"verifyInputPage" })
	public void hoverTitle() //throws InterruptedException
	{

		WebElement pageTable = driver.findElement((By.cssSelector("table,[class='wp-list-table.widefat.fixed.pages']")));
		WebElement tableRowBody = pageTable.findElement(By.tagName("tbody"));
		
		List<WebElement> tableRow = tableRowBody.findElements(By.tagName("tr"));
		for(WebElement rowValue: tableRow)
		{
			List<WebElement> rowTdValue = rowValue.findElements(By.tagName("td"));
			String rowTdVal = rowTdValue.get(0).getText();
			if(rowTdVal.matches(titleInput2+" - "+state))
			{
				Actions action = new Actions(driver); 
				action.moveToElement(rowTdValue.get(0));
				action.perform();
				
				Actions action2 = new Actions(driver);
				WebElement titleName = driver.findElement(By.linkText(titleInput2));
			
				if(titleName.isDisplayed())
				{
					WebElement className = driver.findElement(By.cssSelector("td,[class='post-title.page-title.column-title']"));
					scrollTo(driver, className);
					//Thread.sleep(1000);
					//scrollTo(driver, titleName);
					/*
					//JavascriptExecutor jse = (JavascriptExecutor)driver;
					
					//jse.executeScript("arguments[0].scrollTop = arguments[1];", titleName, 1000);
										
					//Thread.sleep(1000);
					 //
					//String str = "Edit "+"\""+titleInput2+"\"";
					String str = "Edit "+"“"+titleInput2+"”";
					System.out.println(str);
					action2.moveToElement(titleName).perform();
					//action2.clickAndHold(titleName).perform();
					String hoverText = titleName.getAttribute("title");
					System.out.println(hoverText);
					softAssert.assertEquals(hoverText, str, "Tool tip incorrect");
					softAssert.assertAll();
									
				}
				else
				{
					System.out.println("Title "+titleInput2+" not found");
				}
				
			}
		}
	}
	
	
	@Test(groups = { "funcTest" }, dependsOnMethods = {/* "dispalySortedRows"   "hoverTitle" }, expectedExceptions = { StaleElementReferenceException.class })
	public void checkTitle()
	{	
			System.out.println("1");
			WebElement pageTable = driver.findElement((By.cssSelector("table,[class='wp-list-table.widefat.fixed.pages']")));
			WebElement tableRowBody = pageTable.findElement(By.tagName("tbody"));
			System.out.println("12");			
			List<WebElement> tableRow = tableRowBody.findElements(By.tagName("tr"));
			for(WebElement rowValue: tableRow)
			{  System.out.println("13");
				List<WebElement> rowTdValue = rowValue.findElements(By.tagName("td"));
				String rowTdVal = rowTdValue.get(0).getText();
				if(rowTdVal.matches(titleInput2+" - "+state))
				{  System.out.println("14"); 
					WebElement className = driver.findElement(By.cssSelector("td,[class='post-title.page-title.column-title']"));
					scrollTo(driver, className);
					System.out.println("d");
					Actions action = new Actions(driver); 
					action.moveToElement(rowTdValue.get(0)); 
					System.out.println("e");
					action.perform();
					System.out.println("f");
					driver.findElement(By.linkText(titleInput2)).click();
					System.out.println("g");
					
				}
				
				
			} 
			throw new StaleElementReferenceException("Stale ElementReference Exception ");

		
	} 
	
	/*
	@Test(groups = { "funcTest" }, dependsOnMethods = {/* "dispalySortedRows"   "hoverTitle" }, expectedExceptions = { StaleElementReferenceException.class })
public void checkTitle()
{	
		System.out.println("1");
		WebElement pageTable = driver.findElement((By.cssSelector("table,[class='wp-list-table.widefat.fixed.pages']")));
		WebElement tableRowBody = pageTable.findElement(By.tagName("tbody"));
		System.out.println("12");			
		List<WebElement> tableRow = tableRowBody.findElements(By.tagName("tr"));
		for(WebElement rowValue: tableRow)
		{  System.out.println("13");
			List<WebElement> rowTdValue = rowValue.findElements(By.tagName("td"));
			String rowTdVal = rowTdValue.get(0).getText();
			System.out.println(rowTdVal);
			System.out.println("Expected:"+titleInput2+" - "+state);
			if(rowTdVal.matches(titleInput2+" - "+state))
			{ 
				Actions action = new Actions(driver); 
				action.moveToElement(rowTdValue.get(0));
				action.perform();
				
				Actions action2 = new Actions(driver);
				WebElement titleName = driver.findElement(By.linkText(titleInput2));
			
				if(titleName.isDisplayed())
				{
					WebElement className = driver.findElement(By.cssSelector("td,[class='post-title.page-title.column-title']"));
					scrollTo(driver, className);
					//Thread.sleep(1000);
					action2.click();
				}

				/*
				System.out.println("14"); 
				WebElement className = driver.findElement(By.cssSelector("td,[class='post-title.page-title.column-title']"));
				scrollTo(driver, className);
				System.out.println("d");
				Actions action = new Actions(driver); 
				action.moveToElement(rowTdValue.get(0)); 
				System.out.println("e");
				action.perform();
				System.out.println("f");
				driver.findElement(By.linkText(titleInput2)).click();
				System.out.println("g");
				
			}
			
			
		} 
		throw new StaleElementReferenceException("Stale ElementReference Exception ");

	
}

	
	@Test(groups = { "funcTest" }, dependsOnMethods = { "checkTitle" })
	public void clickAuthorName()
	{

			WebElement pageTable = driver.findElement((By.cssSelector("table,[class='wp-list-table.widefat.fixed.pages']")));
			WebElement tableRowBody = pageTable.findElement(By.tagName("tbody"));
			
			List<WebElement> tableRow = tableRowBody.findElements(By.tagName("tr"));
			for(WebElement rowValue: tableRow)
			{
				List<WebElement> rowTdValue = rowValue.findElements(By.tagName("td"));
				String rowTdVal = rowTdValue.get(0).getText();
				if(rowTdVal.matches(titleInput2+" - "+state))
				{
					Actions action = new Actions(driver); 
					action.moveToElement(rowTdValue.get(0));
					action.perform();
					String authorName = rowTdValue.get(1).getText();
					if(authorName.matches(usernameInput))
					{
						driver.findElement(By.linkText(usernameInput)).click();
					}
				}
				
			}

		
	} 

	*/
	@BeforeClass(alwaysRun = true)
	public void beforeMethod()
	{
		driver = new FirefoxDriver();

	}
	
	@AfterClass(alwaysRun = true)
	public void afterMethod()
	{
		//driver.quit();
		
	}
	
	public void scrollTo(WebDriver driver, WebElement element)
	{
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[1];", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}


}
