package org.cts;

import java.io.IOException;
import java.util.Date;

import org.pojo.BookingOrderPojo;
import org.pojo.HotelConfirmPojo;
import org.pojo.HotelDetailsPojo;
import org.pojo.LoginPojo;
import org.pojo.PaymentPojo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgSimpleProgram extends LibGlobal {
	@BeforeClass
	private void startBrowser() {
		launchMaximiseBrowser();
		implicitWait(20);
		loadUrl("http://adactinhotelapp.com/");
	}
	@AfterClass
	private void endBrowser() {
		closeBrowser();
	}
	@BeforeMethod
	private void startTime() {
		Date d=new Date();
		System.out.println("Test starting time:"+d);
	}
	@AfterMethod
	private void endTime() {
		Date d=new Date();
		System.out.println("Test Ending time:"+d);
	}
	@Test
	private void tc1() throws IOException {
		LoginPojo l=new LoginPojo();
		fill(l.getMail(), excelRead(1, 0));
		fill(l.getPass(), excelRead(1, 1));
		btnClick(l.getButton());
		
	}
	@Test
	private void tc2() throws IOException {
		HotelDetailsPojo d=new HotelDetailsPojo();
		dropDownIndex(d.getLocDropDown(), 2);
		dropDownIndex(d.getHotelDropDown(), 2);
		dropDownIndex(d.getRoomDropDown(), 2);
		dropDownIndex(d.getNumberDropDown(), 2);
		fill(d.getCheckInDate(), excelRead(1, 7));
		fill(d.getCheckOutDate(), excelRead(1, 8));
		dropDownIndex(d.getAdultDropDown(), 2);
		dropDownIndex(d.getChildDropDown(), 2);
		btnClick(d.getSearch());
	}
	@Test
	private void tc3() {
		HotelConfirmPojo c=new HotelConfirmPojo();
		btnClick(c.getSelect());
		btnClick(c.getContin());
	}
	@Test
	private void tc4() throws IOException {
		PaymentPojo p=new PaymentPojo();
		fill(p.getFirstName(), excelRead(1, 2));
		fill(p.getLastName(), excelRead(1, 3));
		fill(p.getAddress(), excelRead(1, 4));
		fill(p.getCreditNo(), excelRead(1, 5));
		dropDownIndex(p.getCreditType(), 1);
		dropDownIndex(p.getMonth(), 10);
		dropDownIndex(p.getYear(), 10);
		fill(p.getCcvNo(), excelRead(1, 6));
		btnClick(p.getBook());
	}
	@Test
	private void tc5() {
		BookingOrderPojo b=new BookingOrderPojo();
		String orderNo = b.getOrder().getAttribute("value");
		System.out.println("HOTEL BOOKING ORDER NUMBER : "+ orderNo);
	}

}
