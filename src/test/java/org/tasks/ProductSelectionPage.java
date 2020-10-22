package org.tasks;

import org.cts.LibGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class ProductSelectionPage extends LibGlobal {
	public ProductSelectionPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//select[@class='fPjUPw'])[1]")
	private WebElement minDropDown;
	@FindBy(xpath="(//select[@class='fPjUPw'])[2]")
	private WebElement maxDropDown;
	public WebElement getMinDropDown() {
		return minDropDown;
	}
	public WebElement getMaxDropDown() {
		return maxDropDown;
	}
	
}
