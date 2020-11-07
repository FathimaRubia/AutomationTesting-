package org.cts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleExecutionClass extends LibGlobal {
	public WebDriver d;
	@BeforeMethod
	public void browser() {
		d = launchMaximiseBrowser();
		implicitWait(30);
	}
	@AfterMethod
	public void close() {
		d.quit();
	}
	
	@Parameters("input")
	@Test
	public void googleSuccess(String input) {
		loadUrl("http://www.google.com/");
		WebElement search = d.findElement(By.name("q"));
		fill(search,input);
		System.out.println("GOOGLE TESTCASE 1 : "+Thread.currentThread().getId());

	}
	@Parameters("input")
	@Test
	public void googleFailure(String input) {
		loadUrl("http://www.google.com/");
		WebElement search = d.findElement(By.name("q"));
		fill(search,input);
		System.out.println("GOOGLE TESTCASE 2: "+Thread.currentThread().getId());
		Assert.assertTrue(false);
		

	}


}
