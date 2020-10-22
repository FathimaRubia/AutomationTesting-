package org.tasks;

import java.awt.AWTException;

import org.cts.LibGlobal;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductsSearch extends LibGlobal {
	public WebDriver d;
	public FlipKartLoginPage f;
	@BeforeClass
	public void browserLaunch() {
		d = launchMaximiseBrowser();
		implicitWait(30);
		loadUrl("http://www.flipkart.com/");
	}
			@AfterClass
			private void endBrowser() {
				closeBrowser();
			}
	@Test(dataProvider="loginDetails",dataProviderClass=InputDatas.class)
	private void tc1(String user,String pass) throws AWTException {
		objectCreation();
		f=new FlipKartLoginPage();
		f.logIn(user, pass);
	}
	@Test(dataProvider="product",dataProviderClass=InputDatas.class)
	private void tc2(String productName) throws InterruptedException {
		fill(f.getSearch(),productName);
		f.getButton().submit();
		System.out.println(url());
		Assert.assertTrue(url().contains(productName), "Url is not correct");
		Thread.sleep(5000);
		btnClick(f.getSearch());
		select();
		cut();    

	}
}
