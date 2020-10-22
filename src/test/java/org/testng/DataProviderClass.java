package org.testng;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name="loginDetails")
	public Object[][] data() {
		return new Object[][]{

			{"zxydummy321","Dummy@123"}
			
		};
	}
	@DataProvider(name="hotelDetails")
	public Object[][] details() {
		return new Object[][] {

			{"Melbourne","Hotel Sunshine","Double","1 - One","20/10/2020","21/10/2020","2 - Two","2 - Two"}

		};
	}
	@DataProvider(name="paymentDetails")
	public Object[][] payment(){
		return new Object[][] {
			
			{"FATHIMA","Rubia","18,BANGALORE","3245678234567320","VISA","January","2020","123"}
		
		};
	}


}
