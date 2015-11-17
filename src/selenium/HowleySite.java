package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Document;

public class HowleySite extends HowleyProfile{
	
	@Test(groups = { "advertisement" } )
	void icecreamVideo() throws InterruptedException
	{
		wait = new WebDriverWait(driver, 4000);
		/*
		System.out.println("b");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Advertisement"))).click();
		System.out.println("s");
		//WebElement ic = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("post-1290")));
		//ic.click();
		//ic.click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("I Scream for Ice – Cream"))).click();
		
		WebElement ic = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("I Scream for Ice – Cream")));
		
		//WebElement ic = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("post-1290")));
		
		WebElement a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div,[class='post-1290.post.type-post.status-publish.format-video.has-post-thumbnail.hentry.category-advertisement.category-cute.category-funny.category-kids.item.clearfix.cf.item-video']")));
		
		Actions action = new Actions(driver);
		action.moveToElement(ic);
		//action.click(ic);
		action.perform();
		
		driver.get("http://howley.in/kids/i-scream-for-ice-cream/");
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].play();", ic);
		
		//FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "post-1290");
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "content");
		
		flashApp.callFlashObject("Play");
		
		Thread.sleep(4000L);
		
		flashApp.callFlashObject("Pause");
		*/
		
		/*
		driver.get("http://www.permadi.com/tutorial/flashjscommand/");
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "myFlashMovie");
		
		
		flashApp.callFlashObject("Play");
		
		
		
		Thread.sleep(4000);
		
	//	flashApp.callFlashObject("Pause");
		
		//Thread.sleep(30000);
		
		flashApp.callFlashObject("StopPlay");
		
	
	
		
		
		
		//Thread.sleep(arg0)
	
		
	//	js.executeScript("document", arg1)
		/*
		WebElement ic = driver.findElement(By.id("post-1290"));
		Actions action = new Actions(driver);
		action.moveToElement(ic);
		action.click(ic);
		action.perform();
		System.out.println("g");
		ic.click();
		//ic.click();
		System.out.println("c");
		*/

		
		//WebElement a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("post-1290.post.type-post.status-publish.format-video.has-post-thumbnail.hentry.category-advertisement.category-cute.category-funny.category-kids.item.clearfix.cf.item-video")));
		//a.click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Become a fan on Facebook"))).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cute"))).click();
		
	}

}
