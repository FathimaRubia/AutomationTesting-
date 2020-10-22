package org.tasks;

import org.cts.LibGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKartLoginPage extends LibGlobal{
	public FlipKartLoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']")
	private WebElement userName;
	@FindBy(xpath="//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
	private WebElement passWord;
	@FindBy(xpath="(//span[text()='Login'])[2]")
	private WebElement logIn;
	@FindBy(name="q")
	private WebElement search;
	@FindBy(xpath="//button[@class='vh79eN']")
	private WebElement button;

	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassWord() {
		return passWord;
	}
	public WebElement getLogIn() {
		return logIn;
	}
	public WebElement getSearch() {
		return search;
	}
	public WebElement getButton() {
		return button;
	}
	public void logIn(String user,String pass) {
		fill(getUserName(), user);
		fill(getPassWord(),pass);
		btnClick(getLogIn());
	}
	

}
