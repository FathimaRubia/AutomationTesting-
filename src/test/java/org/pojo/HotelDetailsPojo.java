package org.pojo;

import org.cts.LibGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelDetailsPojo extends LibGlobal {
	public HotelDetailsPojo() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//select[@id='location']")
	private WebElement locDropDown;
	@FindBy(xpath="//select[@name='hotels']")
	private WebElement hotelDropDown;
	@FindBy(xpath="//select[@id='room_type']")
	private WebElement roomDropDown;
	@FindBy(xpath="//select[@name='room_nos']")
	private WebElement numberDropDown;
	@FindBy(xpath="//input[@id='datepick_in']")
	private WebElement checkInDate;
	@FindBy(xpath="//input[@id='datepick_out']")
	private WebElement checkOutDate;
	@FindBy(xpath="//select[@id='adult_room']")
	private WebElement adultDropDown;
	@FindBy(xpath="//select[@name='child_room']")
	private WebElement childDropDown;
	@FindBy(xpath="//input[@id='Submit']")
	private WebElement search;
	public WebElement getLocDropDown() {
		return locDropDown;
	}
	public WebElement getHotelDropDown() {
		return hotelDropDown;
	}
	public WebElement getRoomDropDown() {
		return roomDropDown;
	}
	public WebElement getNumberDropDown() {
		return numberDropDown;
	}
	public WebElement getCheckInDate() {
		return checkInDate;
	}
	public WebElement getCheckOutDate() {
		return checkOutDate;
	}
	public WebElement getAdultDropDown() {
		return adultDropDown;
	}
	public WebElement getChildDropDown() {
		return childDropDown;
	}
	public WebElement getSearch() {
		return search;
	}
}
