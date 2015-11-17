package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HowleySettings extends HowleyProfile{
	/*
	@Test( groups = { "settings" } )
	void clickSettings()
	{
		wait = new WebDriverWait(driver, 4000);		
		WebElement settings = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu-settings")));
		Actions action = new Actions(driver);
		action.moveToElement(settings);
		action.perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sharing"))).click();	
		
		String mainWindow = driver.getWindowHandle();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Link account with WordPress.com"))).click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Need an account?"))).click();

		Set windowHandles2 = driver.getWindowHandles(); 
		Iterator ite = windowHandles2.iterator();
		while(ite.hasNext())
		{
			String popHandle = ite.next().toString();
			if(!popHandle.contains(mainWindow))// && !popHandle.contains(popupHandle))
			{
				driver.switchTo().window(popHandle);
				
				WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass1")));
				password.sendKeys("Megha*472");
				driver.findElement(By.name("Submit")).click();
				
			}
		}
		
		driver.switchTo().window(mainWindow);
		
		
	}
	
		/*

		*/
	
	

}
