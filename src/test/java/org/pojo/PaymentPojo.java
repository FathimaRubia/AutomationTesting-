package org.pojo;

import org.cts.LibGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPojo extends LibGlobal{
	public PaymentPojo() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='first_name']")
	private WebElement firstName;
	@FindBy(xpath="//input[@name='last_name']")
	private WebElement lastName;
	@FindBy(xpath="//textarea[@name='address']")
	private WebElement address;
	@FindBy(xpath="//input[@name='cc_num']")
	private WebElement creditNo;
	@FindBy(xpath="//select[@id='cc_type']")
	private WebElement creditType;
	@FindBy(xpath="//select[@id='cc_exp_month']")
	private WebElement month;
	@FindBy(xpath="//select[@id='cc_exp_year']")
	private WebElement year;
	@FindBy(xpath="//input[@name='cc_cvv']")
	private WebElement ccvNo;
	@FindBy(xpath="//input[@id='book_now']")
	private WebElement book;
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getCreditNo() {
		return creditNo;
	}
	public WebElement getCreditType() {
		return creditType;
	}
	public WebElement getMonth() {
		return month;
	}
	public WebElement getYear() {
		return year;
	}
	public WebElement getCcvNo() {
		return ccvNo;
	}
	public WebElement getBook() {
		return book;
	}

}
