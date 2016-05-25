package za.co.sms.web.app.selinium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumHandler {
	private WebDriver webDriver;
	private int threadSleep;
	private int pageRenderWait;
	
	public SeleniumHandler(WebDriver webDriver,String siteURL,int threadSleep,int pageRenderWait){
		this.webDriver=webDriver;
		this.threadSleep=threadSleep;
		this.pageRenderWait=pageRenderWait;
		webDriver.get(siteURL);
	}
	
	private void waitForPageToLoad(){
		try{
		Thread.sleep(threadSleep);
		}catch(Exception exception){
			exception.printStackTrace();
		}
		webDriver.manage().timeouts().implicitlyWait(pageRenderWait,TimeUnit.SECONDS);
	}
	
	public WebElement searchByID(String elementId){		
		WebElement webElement = webDriver.findElement(By.id(elementId));
		return webElement;
	}
	
	public WebElement searchByName(String elementName){
		WebElement webElement = webDriver.findElement(By.name(elementName));
		return webElement;
	}

	public void enterData(WebElement webElement,String userInput){
		webElement.sendKeys(userInput);
	}

	public void click(WebElement webElement){
		webElement.click();
		waitForPageToLoad();
	}

	public void searchByIdAndClick(String element){
		WebElement webElement=searchByID(element);
		click(webElement);		
	}

	public void searchByNameAndClick(String element){
		WebElement webElement=searchByName(element);
		click(webElement);		
	}

	public void searchByNameEnterData(String element,String userInput){
		WebElement webElement=searchByName(element);
		enterData(webElement,userInput);		
	}
	
	public void searchByIdEnterData(String element,String userInput){
		WebElement webElement=searchByID(element);
		enterData(webElement,userInput);		
	}
	
	public void searchByIdEnterDataAndClick(String element,String userInput){
		WebElement webElement=searchByID(element);
		enterData(webElement,userInput);
		click(webElement);		
	}

	public void searchByNameEnterDataAndClick(String element,String userInput){
		WebElement webElement=searchByName(element);
		enterData(webElement,userInput);
		click(webElement);
	}
}
