package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FlashObjectWebDriver {
	WebDriver webDriver;
	String flashObjectId;
	
	FlashObjectWebDriver(WebDriver webDriver, String flashObjectId)
	{
		this.webDriver = webDriver;
		this.flashObjectId = flashObjectId;
	}
	
	String callFlashObject(String functionName, String ...args)
	{
		Object result = ((JavascriptExecutor) webDriver).executeScript(makeJsFunction(functionName, args), new Object[0]);
		if(result != null)
			return result.toString();
		else
			return null;
	}
	
	String makeJsFunction(String functionName, String... args)
	{
		StringBuffer functionArgs = new StringBuffer();
		if(args.length > 0)
		{
			for(int i = 0; i < args.length; i++)
			{
				if(i > 0)
				{
					functionArgs.append(",");
					
				}
				functionArgs.append(String.format("'%1$s'", args[i]));
			}
		}
		
		return String.format("return document.%1$s.%2$s(%3$s);", flashObjectId, functionName, functionArgs);
	}
}
