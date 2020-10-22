package org.tasks;

import java.awt.AWTException;

import java.util.ArrayList;
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

public class CovidCases extends LibGlobal {
	public WebDriver d;
	Map<String,String> mp=new LinkedHashMap<String,String>();
	@BeforeClass
	public void browserLaunch() throws AWTException {
		d = launchMaximiseBrowser();
		objectCreation();
		implicitWait(30);
		loadUrl("https://covidindia.org/");
	}
	@AfterClass
	private void endBrowser() {
		closeBrowser();
	}
	@Test
	private void tableData()  {
		WebElement covidTable = d.findElement(By.xpath("//table[@id='tablepress-96']"));
		WebElement down = d.findElement(By.xpath("//span[text()='Vote or See Results']"));
		jsScrollDown(down);

		List<WebElement> states = covidTable.findElements(By.xpath("//td[@class='column-1']"));
		List<WebElement> cases = covidTable.findElements(By.xpath("//td[@class='column-2']"));
		
		for (int i = 0; i < states.size(); i++) {
			mp.put(states.get(i).getText(), cases.get(i).getText());
			
		}
		Set<Entry<String, String>> m = mp.entrySet();
		for (Entry<String, String> keyValue : m) {
			
			System.out.println(keyValue);
			
		}
		
		


	}


}



