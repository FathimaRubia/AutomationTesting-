package org.tasks;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.cts.LibGlobal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HighCostIPhones  extends LibGlobal {
	public WebDriver d;
	public FlipKartLoginPage f;
	Map<String,Integer> mp=new LinkedHashMap<String,Integer>();
	
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
	@Test
	private void tc2() {
		fill(f.getSearch(),"iphone");
		f.getButton().submit();
	}
	@Test
	private void tc3() {
		List<WebElement> names = d.findElements(By.xpath("//div[@class='_3wU53n']"));
		List<WebElement> prizes = d.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
		for (int i = 0; i < names.size(); i++) {
			String cost = prizes.get(i).getText();
			String cost1 = cost.replaceAll("₹","");
			String cost2 = cost1.replaceAll(",","");
			int prize = Integer.parseInt(cost2);
			mp.put(names.get(i).getText(), prize);	
		}
	}
	@Test
	private void tc4() {
		Set<Entry<String, Integer>> m = mp.entrySet();
		for (Entry<String, Integer> x : m) {
			if(x.getValue()>50000) {
				System.out.println(x.getKey()+":"+x.getValue());
			}
	}
		
	}

}
