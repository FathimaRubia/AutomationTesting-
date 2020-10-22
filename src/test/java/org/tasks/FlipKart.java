package org.tasks;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.cts.LibGlobal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipKart extends LibGlobal {
	public WebDriver d;
	public FlipKartLoginPage f;
	public ProductSelectionPage p;
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
	private void tc1(String user,String pass) {
		f=new FlipKartLoginPage();
		f.logIn(user, pass);
	}
	@Test(dataProvider="product",dataProviderClass=InputDatas.class)
	private void tc2(String productName) {
		fill(f.getSearch(),productName);
		f.getButton().submit();
	}
	
	@Test(dataProvider="dropDown",dataProviderClass=InputDatas.class)
	private void tc3(String start) throws InterruptedException {
		p=new ProductSelectionPage();
		dropDownValue(p.getMinDropDown(),start);
		Thread.sleep(5000);
		Set<WebElement> s=new LinkedHashSet<WebElement>();
		List<WebElement> phoneList = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		s.addAll(phoneList);

		System.out.println("No.of mobiles above 50000:"+phoneList.size());

		System.out.println("==============================================");

		for (WebElement x : phoneList) {
			System.out.println(x.getText());
		}
		if(s.size()==phoneList.size()){
			System.out.println("NO DUPLICATES");
		}
		
	}


}


