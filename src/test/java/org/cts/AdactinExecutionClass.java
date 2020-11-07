package org.cts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdactinExecutionClass extends LibGlobal {
	public WebDriver d1;
	@BeforeMethod
	public void browser() {
		d1 = launchMaximiseBrowser();
		implicitWait(30);
	}
	
	@Parameters({"adacUser","adacPass"})
	@Test
	public void tc2(String adacUser,String adacPass) {
		loadUrl("http://adactinhotelapp.com/");
		WebElement mail=d1.findElement(By.id("username"));
		fill(mail,adacUser);
		WebElement passWord=d1.findElement(By.id("password"));
		fill(passWord,adacPass );
		WebElement button=d1.findElement(By.id("login"));
		btnClick(button);
		System.out.println("ADACTIN TESTCASE : "+Thread.currentThread().getId());
	}
	
}
