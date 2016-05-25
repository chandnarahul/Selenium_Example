package za.co.sms.web.app.gui.inbox;

import za.co.sms.web.app.selinium.SeleniumHandler;

public class InboxOperations {
	private SeleniumHandler seleniumHandler;
	public InboxOperations(SeleniumHandler seleniumHandler){
		this.seleniumHandler=seleniumHandler;
	}
	
	public void performOperations(){
		seleniumHandler.searchByNameAndClick("campaigns");
		seleniumHandler.searchByNameAndClick("contactUs");
		seleniumHandler.searchByNameAndClick("home");
		seleniumHandler.searchByNameAndClick("userInbox");
	}
}
