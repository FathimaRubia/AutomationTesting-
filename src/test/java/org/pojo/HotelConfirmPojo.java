package org.pojo;

import org.cts.LibGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelConfirmPojo extends LibGlobal{
	public HotelConfirmPojo() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='radiobutton_0']")
	private WebElement select;
	@FindBy(xpath="//input[@id='continue']")
	private WebElement contin;
	public WebElement getSelect() {
		return select;
	}
	public WebElement getContin() {
		return contin;
	}
	

}
