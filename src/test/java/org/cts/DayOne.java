package org.cts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DayOne {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AA\\eclipse-workspace\\ProjectFramework\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http://adactinhotelapp.com/");
		WebElement mail=driver.findElement(By.id("username"));
		mail.sendKeys("zxydummy321");
		WebElement pass=driver.findElement(By.id("password"));
		pass.sendKeys("Dummy@123");
		WebElement button=driver.findElement(By.id("login"));
		button.click();

		WebElement locDropDown= driver.findElement(By.xpath("//select[@id='location']"));
		Select s1=new Select(locDropDown);
		s1.selectByIndex(2);
		WebElement hotelDropDown= driver.findElement(By.xpath("//select[@name='hotels']"));
		Select s2=new Select(hotelDropDown);
		s2.selectByIndex(2);
		WebElement roomDropDown= driver.findElement(By.xpath("//select[@id='room_type']"));
		Select s3=new Select(roomDropDown);
		s3.selectByIndex(2);
		WebElement numberDropDown= driver.findElement(By.xpath("//select[@name='room_nos']"));
		Select s4=new Select(numberDropDown);
		s4.selectByIndex(2);
		WebElement checkInDate=driver.findElement(By.xpath("//input[@id='datepick_in']"));
		checkInDate.sendKeys("11/10/2020");
		WebElement checkOutDate=driver.findElement(By.xpath("//input[@id='datepick_out']"));
		checkOutDate.sendKeys("12/10/2020");
		WebElement adultDropDown= driver.findElement(By.xpath("//select[@id='adult_room']"));
		Select s5=new Select(adultDropDown);
		s5.selectByIndex(2);
		WebElement childDropDown= driver.findElement(By.xpath("//select[@name='child_room']"));
		Select s6=new Select(childDropDown);
		s6.selectByIndex(2);
		WebElement search= driver.findElement(By.xpath("//input[@id='Submit']"));
		search.click();
		WebElement select= driver.findElement(By.xpath("//input[@name='radiobutton_0']"));
		select.click();
		WebElement contin= driver.findElement(By.xpath("//input[@id='continue']"));
		contin.click();
		WebElement firstName= driver.findElement(By.xpath("//input[@name='first_name']"));
		firstName.sendKeys("FATHIMA");
		WebElement lastName= driver.findElement(By.xpath("//input[@name='last_name']"));
		lastName.sendKeys("RUBIA");
		WebElement address= driver.findElement(By.xpath("//textarea[@name='address']"));
		address.sendKeys("18,WEST STREET,BANGALORE");
		WebElement creditNo= driver.findElement(By.xpath("//input[@name='cc_num']"));
		creditNo.sendKeys("3245678234567321");
		WebElement creditType= driver.findElement(By.xpath("//select[@id='cc_type']"));
		Select s7=new Select(creditType);
		s7.selectByIndex(1);
		WebElement month= driver.findElement(By.xpath("//select[@id='cc_exp_month']"));
		Select s8=new Select(month);
		s8.selectByIndex(10);
		WebElement year= driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
		Select s9=new Select(year);
		s9.selectByIndex(10);
		WebElement ccvNo= driver.findElement(By.xpath("//input[@name='cc_cvv']"));
		ccvNo.sendKeys("123");
		WebElement book= driver.findElement(By.xpath("//input[@id='book_now']"));
		book.click();
		WebElement order= driver.findElement(By.xpath("//input[@name='order_no']"));
		String orderNo = order.getAttribute("value");
		System.out.println("HOTEL BOOKING ORDER NUMBER : "+ orderNo);
		




	}
}
