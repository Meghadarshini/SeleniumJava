package selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HowleyElementAction extends HowleyProfile
{
	/*
	@Test(groups = { "elementAction" })
	public void editTitle() 
	{
		//driver.findElement(By.linkText("WordPress 4.2.4")).click();

		WebElement pageTable = driver.findElement(By.cssSelector("table,[class='wp-list-table.widefat.fixed.pages']"));
		scrollTo(driver, pageTable);
		WebElement tableRowBody = pageTable.findElement(By.tagName("tbody"));
		List<WebElement> tableRow = tableRowBody.findElements(By.tagName("tr"));
		for(WebElement rowValue : tableRow)
		{
			List<WebElement> rowTdValue = rowValue.findElements(By.tagName("td"));
			String rowTdVal = rowTdValue.get(0).getText();
			System.out.println("rowTdVal:"+rowTdVal);
			System.out.println(titleInput1);
			String value = titleInput1+" - "+state;	
			//String value = titleInput1;			
			System.out.println("The val is"+value);
			if(rowTdVal.matches(titleInput1+" - "+state))
			{
				scrollTo(driver, rowTdValue.get(0));
				//WebElement className = driver.findElement(By.cssSelector("td,[class='post-title.page-title.column-title']"));
				//scrollTo(driver, className);
				Actions action = new Actions(driver);
				WebElement editLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));
				action.moveToElement(editLink);
				action.perform();
				editLink.click();
				WebElement titleName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("post_title")));
				Actions action2 = new Actions(driver);
				action2.moveToElement(titleName);
				action2.perform();
				
				//scrollTo(driver, titleName);
				titleName.clear();
				titleName.sendKeys("Page1 Edited");
				driver.findElement(By.id("content-html")).click();
				WebElement content = driver.findElement(By.name("content"));
				content.clear();
				content.sendKeys("body1 edited");
				driver.findElement(By.id("save-post")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("save-post")));
				
			}
		}
		
	}
	*/
	
	@Test( groups = { "deleteElementAction" })
	void deletePage()
	{
		wait = new WebDriverWait(driver, 4000);
		WebElement pageTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table,[class='wp-list-table.widefat.fixed.pages']"))); 
		//displayAllPages();
		//WebElement pageTable = driver.findElement(By.cssSelector("table,[class='wp-list-table.widefat.fixed.pages']"));
		scrollTo(driver, pageTable);
		WebElement tableRowBody = pageTable.findElement(By.tagName("tbody"));
		List<WebElement> tableRow = tableRowBody.findElements(By.tagName("tr"));
		for(WebElement rowValue : tableRow)
		{
			List<WebElement> rowTdValue = rowValue.findElements(By.tagName("td"));
			String rowTdVal = rowTdValue.get(0).getText();
			System.out.println(titleInput1);
			if(rowTdVal.matches(titleInput1+" - "+state))
			{
				scrollTo(driver, rowTdValue.get(0));
				WebElement className = driver.findElement(By.cssSelector("td,[class='post-title.page-title.column-title']"));
				scrollTo(driver, className);
				Actions action = new Actions(driver);
				WebElement trashLink = driver.findElement(By.linkText("Trash"));
				action.moveToElement(trashLink);
				action.perform();
				action.click();
			}
		}
							
	}
	
	@Test( groups = { "deleteElementAction" }, dependsOnMethods = { "deletePage" })
	void deletePagePermanently()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Trash "))).click();
		WebElement pageTable = driver.findElement(By.cssSelector("table,[class='wp-list-table.widefat.fixed.pages']"));
		WebElement tableRowBody = pageTable.findElement(By.tagName("tbody"));
		List<WebElement> tableRow = tableRowBody.findElements(By.tagName("tr"));
		for(WebElement rowValue : tableRow)
		{
			List<WebElement> rowTdValue = rowValue.findElements(By.tagName("td"));
			String rowTdVal = rowTdValue.get(0).getText();
			System.out.println(titleInput1);
			if(rowTdVal.matches(titleInput1+" - "+state))
			{
				scrollTo(driver, rowTdValue.get(0));
				WebElement className = driver.findElement(By.cssSelector("td,[class='post-title.page-title.column-title']"));
				scrollTo(driver, className);
				WebElement deletePermanentlyLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Restore")));
				//Delete Permanently
				deletePermanentlyLink.click();
				
			}
		}
				
	}
	
	
	@Test( groups = { "seo" } )
	void seoBook()
	{

		wait = new WebDriverWait(driver, 4000);
		/*
		String mainWindow = driver.getWindowHandle();		
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		driver.switchTo().window(mainWindow);
		*/
		WebElement seo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SEO")));
		//WebElement seo = driver.findElement(By.linkText("SEO"));
		Actions action = new Actions(driver);
		action.moveToElement(seo);
		action.perform();
		//scrollTo(driver, seo);
		WebElement keywordResearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wp-admin-bar-wpseo-kwresearch")));
		//scrollTo(driver, keywordResearch);
		Actions action1 = new Actions(driver);
		action1.moveToElement(keywordResearch);
		action1.perform();
		
		String mainWindow = driver.getWindowHandle();
		WebElement seoBook = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SEO Book")));
		//WebElement seoBook = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wp-admin-bar-wpseo-wordtracker")));
		//scrollTo(driver, seoBook);
		Actions action2 = new Actions(driver);
		action2.moveToElement(seoBook).click();
		action2.perform();	
		//action2.click();
		//action2.click();
		//seoBook.click();
		
		Set windowHandles = driver.getWindowHandles();
		Iterator iter = windowHandles.iterator();
		while(iter.hasNext())
		{
			String popupHandle = iter.next().toString();
			if(!popupHandle.contains(mainWindow))
			{
				driver.switchTo().window(popupHandle);
				String title = driver.getTitle();
				System.out.println(title);
				softAssert.assertEquals(title, "SEO Book Keyword Suggestion Tool", "Title incorrect");	
				//driver.switchTo().window(popupHandle).close();
				driver.close();
			}
		}	
		
		driver.switchTo().window(mainWindow);		
	}
	
	@Test( groups = { "seo" }, dependsOnMethods = { "seoBook" })
	void adWordsExternal()
	{
		wait = new WebDriverWait(driver, 4000);
		WebElement seo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SEO")));
		Actions action1 = new Actions(driver);
		action1.moveToElement(seo);
		action1.perform();
		WebElement keywordResearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wp-admin-bar-wpseo-kwresearch")));
		Actions action2 = new Actions(driver);
		action2.moveToElement(keywordResearch);
		action2.perform();
		WebElement adwordsExternal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("AdWords External")));
		
		String mainWindow = driver.getWindowHandle();
		Actions action3 = new Actions(driver);
		action3.moveToElement(adwordsExternal).click();
		action3.perform();
		Set windowHandles = driver.getWindowHandles();
		Iterator iter = windowHandles.iterator();
		while(iter.hasNext())
		{
			String popupHandle = iter.next().toString();
			if(!popupHandle.contains(mainWindow))
			{
				driver.switchTo().window(popupHandle);
				String title = driver.getTitle();
				System.out.println(title);
				softAssert.assertEquals(title, "Google AdWords: Keyword Planner", "Google AdWords title incorrect");
				//driver.switchTo().window(popupHandle).close();
				driver.close();
				
			}
		}
		
		driver.switchTo().window(mainWindow);
	}
	
	@Test( groups = {"seo"}, dependsOnMethods = { "adWordsExternal" } )
	void checkGoogleCache()
	{
		wait = new WebDriverWait(driver, 4000);
		WebElement seo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SEO")));
		Actions action1 = new Actions(driver);
		action1.moveToElement(seo);
		action1.perform();
		WebElement analyzeThisPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wp-admin-bar-wpseo-analysis")));
		Actions action2 = new Actions(driver);
		action2.moveToElement(analyzeThisPage);
		action2.perform();
		WebElement checkGoogleCache = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Check Google Cache")));
		String mainWindow = driver.getWindowHandle();
		Actions action3 = new Actions(driver);
		action3.moveToElement(checkGoogleCache).click();
		action3.perform();
		Set windowHandles = driver.getWindowHandles();
		Iterator iter = windowHandles.iterator();
		while(iter.hasNext())
		{
			String popupHandle = iter.next().toString();
			if(!popupHandle.contains(mainWindow))
			{
				driver.switchTo().window(popupHandle);
				String title = driver.getTitle();
				System.out.println(title);
				softAssert.assertEquals(title, "SUBJ1", "Check Google Cache title incorrect");
				//driver.switchTo().window(popupHandle).close();
				driver.close();
				
			}
		}
		driver.switchTo().window(mainWindow);
		
	}
	
	@Test( groups = {"seo"}, dependsOnMethods = { "checkGoogleCache" }  )
	void mobileFriendlyTest()
	{
		wait = new WebDriverWait(driver, 4000);
		WebElement seo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SEO")));
		Actions action1 = new Actions(driver);
		action1.moveToElement(seo);
		action1.perform();
		WebElement analyzeThisPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wp-admin-bar-wpseo-analysis")));
		Actions action2 = new Actions(driver);
		action2.moveToElement(analyzeThisPage);
		action2.perform();
		WebElement mobileFriendlyTest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mobile-Friendly Test")));
		String mainWindow = driver.getWindowHandle();
		Actions action3 = new Actions(driver);
		action3.moveToElement(mobileFriendlyTest).click();
		action3.perform();
		Set windowHandles = driver.getWindowHandles();
		Iterator iter = windowHandles.iterator();
		while(iter.hasNext())
		{
			String popupHandle = iter.next().toString();
			if(!popupHandle.contains(mainWindow))
			{
				driver.switchTo().window(popupHandle);
				String title = driver.getTitle();
				System.out.println(title);
				softAssert.assertEquals(title, "Mobile-Friendly Test", "Mobile-Friendly Test title incorrect");
				//driver.switchTo().window(popupHandle).close();
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);		
	}
	
	
	
	
	
	
	
	
	
	

}
