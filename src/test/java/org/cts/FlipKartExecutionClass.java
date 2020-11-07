package org.cts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlipKartExecutionClass extends LibGlobal{
	public WebDriver d1;
	@BeforeMethod
	public void browser() {
		d1 = launchMaximiseBrowser();
		implicitWait(30);
	}
	@Parameters({"flipUser","flipPass"})
	@Test
	public void tc3(String flipUser,String flipPass) {
		loadUrl("http://www.flipkart.com");
		WebElement mobile=d1.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']"));
		fill(mobile,flipUser);
		WebElement passWord=d1.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']"));
		fill(passWord,flipPass );
		WebElement button=d1.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']"));
		btnClick(button);
		System.out.println("FLIPKART TESTCASE : "+Thread.currentThread().getId());


	}


}
