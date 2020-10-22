package org.tasks;

import org.testng.annotations.DataProvider;

public class InputDatas {
	@DataProvider(name="loginDetails")
	public Object[][] datas(){
		return new Object[][] {
			
			{"9677888119","nirmaladev"}
			
		};
	}
	@DataProvider(name="dropDown")
	public Object[][] dropDowns(){
		return new Object[][] {
			{"50000"}
			
		};
	}
	@DataProvider(name="product")
	public Object[][] products(){
		return new Object[][] {
			{"iphone"},{"dell"},{"samsung"},{"videoconledtv"}
			
		};
	}

}
