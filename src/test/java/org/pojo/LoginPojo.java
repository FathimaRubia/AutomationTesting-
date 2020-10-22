package org.pojo;

import org.cts.LibGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends LibGlobal {
	public LoginPojo() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private WebElement mail;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(id="login")
	private WebElement button;

	public WebElement getMail() {
		return mail;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getButton() {
		return button;
	}
	

}
