package org.testng;

import org.cts.LibGlobal;
import org.pojo.BookingOrderPojo;
import org.pojo.PaymentPojo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PaymentBookingClass extends LibGlobal{
	@BeforeMethod
	public void waitLocat() {
		implicitWait(20);
	}
	@AfterClass
	public static void endBrowser() {
		closeBrowser();
	}
	
	@Test(dataProvider="paymentDetails",dataProviderClass=DataProviderClass.class)
	public void tc4(String first,String last,String address,String creditNo,String creditType,String month,String year,String ccvNo){
		PaymentPojo p=new PaymentPojo();
		fill(p.getFirstName(), first);
	    Assert.assertEquals(p.getFirstName().getAttribute("value"), "FATHIMA","Check the first name");
		fill(p.getLastName(), last);
		Assert.assertEquals( p.getLastName().getAttribute("value"), "Rubia","Check the last name");
		fill(p.getAddress(), address);
		Assert.assertEquals( p.getAddress().getAttribute("value"), "18,BANGALORE","Check the address");
		fill(p.getCreditNo(), creditNo);
		Assert.assertEquals(p.getCreditNo().getAttribute("value"), "3245678234567320", "Check the credit card number");
		dropDownVisible(p.getCreditType(), creditType);
		Assert.assertTrue(p.getCreditType().getAttribute("value").contains("VISA"), "Credit typeDropdown is not selected");
		dropDownVisible(p.getMonth(), month);
		Assert.assertTrue(p.getMonth().getText().contains("Jan"), "MonthDropdown is not selected");
		dropDownVisible(p.getYear(), year);
		Assert.assertTrue(p.getYear().getAttribute("value").equals("2020"),"YearDropdown is not selected");
		fill(p.getCcvNo(), ccvNo);
		Assert.assertEquals( p.getCcvNo().getAttribute("value"), "123","Check the CCV number");
		btnClick(p.getBook());
	}

	@Test
	public void tc5() {
		BookingOrderPojo b=new BookingOrderPojo();
		String orderNo = b.getOrder().getAttribute("value");
		System.out.println("HOTEL BOOKING ORDER NUMBER : "+ orderNo);
	}

}





