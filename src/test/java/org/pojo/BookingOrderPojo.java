package org.pojo;

import org.cts.LibGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingOrderPojo extends LibGlobal {
	public BookingOrderPojo() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='order_no']")
	private WebElement order;
	
	public WebElement getOrder() {
		return order;
	}
	
	

}
