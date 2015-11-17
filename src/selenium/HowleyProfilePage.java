package selenium;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.firefox.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

public class HowleyProfilePage{
WebDriver driver = new FirefoxDriver();
Wait<WebDriver> wait;
final String usernameInput = "Megha";
	
SoftAssert softAssert = new SoftAssert();

final String titleInput1 = "page1";
final String bodyInput1 = "body1 ";
final String state = "Draft";
DateFormat dateFormat= new SimpleDateFormat("yyyy/MM/DD"); 
Date date = new Date();


	 
void displayProfile(WebDriver driver)
{//wait = new WebDriverWait(driver, 3000);
	  
	  this.driver = driver;
	  
 try
 {
	  
	wait = new WebDriverWait(driver, 4000);  
	/*
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
	WebElement w = driver.findElement(By.linkText("Logout"));
	
	w.click(); */
	
	WebElement css = driver.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"));
	wait = new WebDriverWait(driver, 4000);
	if(css.isDisplayed())
	{
		
		if(css.getText().matches("Howdy, "+usernameInput))
	
		{
			
			css.click();
		}
		else
		{
			System.out.println("css element is incorrect or not displayed");
		}
				
	}
	 
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
 
}	

void addPage(WebDriver driver)
{
	  try
	  {
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu-pages"))).click();
		  
	   //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("wp-menu-image.dashicons-before.dashicons-admin-page"))).click();	  

	   //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='menu-pages']/a/div[2]"))).click();
		  
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All Pages"))).click();
	   
	   wait = new WebDriverWait(driver, 4000);
	 	   
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.add-new-h2"))).click();
	
	   

	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title"))).sendKeys(titleInput1);
	  // driver.findElement(By.id("title")).sendKeys(titleInput1);
	   wait = new WebDriverWait(driver, 3000);
	   driver.findElement(By.id("content-html")).click();
	  // driver.findElement(By.id("content")).sendKeys(bodyInput1);
	   WebElement contentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
	   contentElement.sendKeys(bodyInput1); 
	   
	   DateFormat dateFormat= new SimpleDateFormat("yyyy/MM/DD"); 
	   Date date = new Date();
	   System.out.println(dateFormat.format(date));
	    
	   //driver.findElement(By.id("save-post")).click();
	   
	   WebElement wordCount1 =  driver.findElement(By.id("wp-word-count"));
	   String wordCount = wordCount1.getText();
	   System.out.println(wordCount);
		   
	   String[] wordArray1 = bodyInput1.split("\\s+");
	   int actualWordCount1 = wordArray1.length;
	   System.out.println(actualWordCount1);
		   
	   boolean condition = ("Word count: "+actualWordCount1).equals(wordCount);
	   System.out.println(condition);
	 
	  
	   softAssert.assertEquals(wordCount, "Word count: "+actualWordCount1, " fail message");
	 
	   
	   driver.findElement(By.id("save-post")).click();
	   
	  
	   
	   /*   WebElement draftUpdated = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
	   String draftUpdatedMessage = draftUpdated.getText();
	   softAssert.assertEquals(draftUpdatedMessage, "Page draft updated.", "Draft message incorrect");
	   
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Preview page"))).click();
	   driver.findElement(By.linkText("Preview Page")).click();
	   */
	   
	   String mwh = driver.getWindowHandle();
	   
	   
	   WebElement viewPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("View Page")));
		  // WebElement viewPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("button button-small")));
		   String viewPageText = viewPage.getText();
		   softAssert.assertEquals(viewPageText, "View Page", "View Page display incorrect");
		   
		  
		   viewPage.click();
		   
	   
	   Set s = driver.getWindowHandles();
	   
	   Iterator ite = s.iterator();
	   
	   while(ite.hasNext())
	   {
		   String popupHandle = ite.next().toString();
		   if(!popupHandle.contains(mwh))
		   {
			   driver.switchTo().window(popupHandle);
			   
			   WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));
				  String pageTitleName = pageTitle.getText();
				  // Assert.assertTrue("Page title incorrect", pageTitleName.equals(titleInput1));
				  softAssert.assertEquals(pageTitleName, titleInput1, "Page title incorrect");
				  
				/* WebElement body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("page-content rich-content .p")));
				  				  
				  String bodyDescription = body.getText();
				  softAssert.assertEquals(bodyDescription, bodyInput1, "Body Description incorrect");
				  */
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Entertainment"))).click();
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recent-tab")));
				   
				  driver.switchTo().window(mwh);
			   
		   }
	   }
	  
		   
		   /*Set<String> handles = driver.getWindowHandles();
		   for(String handle : handles)
		   {
			   driver.switchTo().window(handle);
			   WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-title")));
				  String pageTitleName = pageTitle.getText();
				  // Assert.assertTrue("Page title incorrect", pageTitleName.equals(titleInput1));
				  softAssert.assertEquals(pageTitleName, titleInput1, "Page title incorrect");
				  
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Entertainment"))).click();
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recent-tab")));
				   
				driver.switchTo().window(mwh);
		   }
		   driver.switchTo().window(mwh);
	   */
		   
		   
	   driver.findElement(By.linkText("More")).click();
	   //softAssert.assertAll();
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
	
}


@Test
void verifyPageCreated(WebDriver driver)
{
	  try
	  {
		  
		  wait = new WebDriverWait(driver, 4000);
		
		  /*
    driver.get("http://howley.in/wp-login.php");
    driver.manage().window().maximize();
    driver.findElement(By.id("user_login")).sendKeys("mm");
    driver.findElement(By.id("user_pass")).sendKeys("s1rp4syMPJM9");
    driver.findElement(By.id("wp-submit")).click();
    */
		  
		  driver.get("http://howley.in/wp-admin/");
		  driver.manage().window().maximize();
	      
	      driver.findElement(By.id("user_login")).sendKeys("mm");
	      driver.findElement(By.id("user_pass")).sendKeys("s1rp4syMPJM9");
	      driver.findElement(By.id("rememberme")).click();
	      driver.findElement(By.id("wp-submit")).click();
	      
	      
	      
	      Actions action = new Actions(driver);
	      WebElement menuPages = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wp-menu-name")));
	      //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div, [class='wp-menu-image.dashicons-before.dashicons-admin-page']"))).click();
	      action.moveToElement(menuPages);
	      action.perform();
	      
    
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='menu-pages']/a/div[2]"))).click();

	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div, [class='wp-menu-image.dashicons-before.dashicons-admin-page']"))).click();
	      
	  
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu-pages"))).click();
	  
	  //driver.findElement(By.id("id")).
	  
	  wait = new WebDriverWait(driver, 4000);
		  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All Pages"))).click();
	  /*
	  String mwh = driver.getWindowHandle();
	  
	  wait = new WebDriverWait(driver, 4000);
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  
	  driver.switchTo().window(mwh);
	  */
	  int index = 0;
	  WebElement pageTable = driver.findElement((By.cssSelector("table,[class='wp-list-table.widefat.fixed.pages']")));
	  
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
	  
	  catch(NoAlertPresentException e)
	  {
		  System.out.println(e);
	  }
	  
	  
	  
	 
}

@Test
void displaySortedRows(WebDriver driver)
{
	  wait = new WebDriverWait(driver, 4000);
	  
	  try
	  {
		  
	  
		  // WebElement pageTable = driver.findElement((By.cssSelector("table,[class='wp-list-table.widefat.fixed.pages']")));
	  
		  //  WebElement tableHead = pageTable.findElement(By.tagName("thead"));
    
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
    
	      Actions action3 = new Actions(driver);
	      WebElement title3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
	      action3.moveToElement(title3);
	      action3.perform();
    
    
	     // wait.until(ExpectedConditions.visibilityOfElementLocated(By))
	      WebElement pageTable = driver.findElement(By.cssSelector("table,[class='wp-list-table.widefat.fixed.pages']"));
	      
	      WebElement tableRow = pageTable.findElement(By.tagName("tbody"));
	      List<WebElement> tableRows = tableRow.findElements(By.tagName("tr"));
	      	      
	      for(WebElement rowValue: tableRows)
	      {
	    	  List<WebElement> tableRowThValue = rowValue.findElements(By.tagName("th"));
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
	  catch(NoSuchElementException e)
	  {
		  System.out.println(e);
	  }
    
    
    
}


}
