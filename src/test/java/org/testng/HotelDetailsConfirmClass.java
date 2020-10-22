package org.testng;

import org.cts.LibGlobal;
import org.pojo.HotelConfirmPojo;
import org.pojo.HotelDetailsPojo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotelDetailsConfirmClass extends LibGlobal {
	@BeforeMethod
	public void waitLoc() {
		implicitWait(20);
	}
	@Test(dataProvider="hotelDetails",dataProviderClass=DataProviderClass.class)
	public void tc2(String location,String hotel,String room,String roomNo,String checkIn,String checkOut,String adult,String child){
		HotelDetailsPojo d=new HotelDetailsPojo();
		dropDownVisible(d.getLocDropDown(), location);
		Assert.assertTrue(d.getLocDropDown().getAttribute("value").equals("Melbourne"),"Locationdropdown is not selected");
		dropDownVisible(d.getHotelDropDown(), hotel);
		Assert.assertTrue(d.getHotelDropDown().getAttribute("value").equals("Hotel Sunshine"), "HotelDropdown is not selected");
		dropDownVisible(d.getRoomDropDown(), room);
		Assert.assertTrue(d.getRoomDropDown().getAttribute("value").equals("Double"), "RoomDropdown is not selected");
		dropDownVisible(d.getNumberDropDown(), roomNo);
		Assert.assertTrue(d.getNumberDropDown().getAttribute("value").contains("1"), "NumberDropdown is not selected");
		fill(d.getCheckInDate(), checkIn);
		Assert.assertEquals(d.getCheckInDate().getAttribute("value"), "20/10/2020","Check the check-in date" );
		fill(d.getCheckOutDate(),checkOut);
		Assert.assertEquals(d.getCheckOutDate().getAttribute("value"), "21/10/2020","Check the check-out date" );
		dropDownVisible(d.getAdultDropDown(), adult);
		Assert.assertTrue(d.getAdultDropDown().getAttribute("value").contains("2"), "AdultDropdown is not selected");
		dropDownVisible(d.getChildDropDown(), child);
		Assert.assertTrue(d.getChildDropDown().getAttribute("value").contains("2"), "ChildDropdown is not selected");
		btnClick(d.getSearch());
	}

	@Test
	public void tc3() {
		HotelConfirmPojo c=new HotelConfirmPojo();
		btnClick(c.getSelect());
		Assert.assertTrue(c.getSelect().isSelected(), "Confirm checkbox is not selected");
		btnClick(c.getContin());
	}


}
