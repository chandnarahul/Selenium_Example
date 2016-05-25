package za.co.sms.web.app.gui;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor; 

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Alert;

import za.co.sms.web.app.gui.inbox.InboxOperations;
import za.co.sms.web.app.gui.login.Login;
import za.co.sms.web.app.selinium.SeleniumHandler;

public class GuiTester {
	final String SITE_URL = "http://localhost:8080/websmsserviceapp-0.1/";
	final int MAX_WAIT_TIME_SEC = 2;
	final int THREAD_SLEEP=500;
	private WebDriver webDriver;

	public GuiTester(WebDriver webDriver){
		this.webDriver=webDriver;
	}

	public static void main(String[] args)
	{
		File pathToBinary = new File("c:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		GuiTester guiHtmlUnitTester=new GuiTester(new FirefoxDriver(ffBinary,firefoxProfile));
		guiHtmlUnitTester.executeTests();
		GuiTester guiIETester=new GuiTester(new InternetExplorerDriver());
		guiIETester.executeTests();
		GuiTester guiChromeTester=new GuiTester(new ChromeDriver());
		guiChromeTester.executeTests();
	}

	public void executeTests(){
		try
		{
			SeleniumHandler seleniumHandler=new SeleniumHandler(webDriver, SITE_URL, THREAD_SLEEP,MAX_WAIT_TIME_SEC);
			Login login=new Login(seleniumHandler);
			login.performLogin();
			InboxOperations inboxOperations=new InboxOperations(seleniumHandler);
			inboxOperations.performOperations();

		}catch(Exception e){
			e.printStackTrace();
		}
		webDriver.close();
		webDriver.quit();
	}
}
