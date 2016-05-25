package za.co.sms.web.app.gui.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import za.co.sms.web.app.selinium.SeleniumHandler;

public class Login {
	private SeleniumHandler seleniumHandler;
	public Login(SeleniumHandler seleniumHandler){
		this.seleniumHandler=seleniumHandler;
	}
	
	public void performLogin()throws Exception{
		enterCredentials();
		seleniumHandler.searchByIdAndClick("reset");
		enterCredentials();
		seleniumHandler.searchByIdAndClick("submit");
	}
	
	private void enterCredentials(){
		seleniumHandler.searchByIdEnterData("userName", "admin");
		seleniumHandler.searchByIdEnterData("password", "abcd12345");
	}
}
