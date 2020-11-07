package org.cts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class AmazonExecutionClass extends LibGlobal {
	public WebDriver d;
	@BeforeMethod
	public void browser() {
		d = launchMaximiseBrowser();
		implicitWait(30);
	}
	@AfterClass
	public void close() {
		d.quit();
	}

	@Parameters({"amazUser","amazPass"})
	@Test
	public void logIn(String amazUser,String amazPass) {
		loadUrl("http://www.amazon.in/");
		Actions a=new Actions(driver);
		WebElement SignMouse = d.findElement(By.xpath("//span[text()='Hello, Sign in']"));
		a.moveToElement(SignMouse).perform();
		WebElement signIn = d.findElement(By.xpath("(//span[text()='Sign in'])[1]"));
		signIn.click();
		WebElement mail = d.findElement(By.xpath("//input[@id='ap_email']"));
		mail.sendKeys(amazUser );	
		WebElement cont= d.findElement(By.xpath("//input[@id='continue']"));
		cont.click();
		WebElement pass = d.findElement(By.xpath("//input[@id='ap_password']"));
		pass.sendKeys(amazPass);
		WebElement logIn = d.findElement(By.xpath("//input[@id='signInSubmit']"));
		logIn.click();
		System.out.println("AMAZON TESTCASE 1 : "+Thread.currentThread().getId());
	}
	@Parameters({"product"})
	@Test
	public void searchProduct(String product) throws InterruptedException {
		WebElement search = d.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		Thread.sleep(5000);
		search.sendKeys(product);
		WebElement go = d.findElement(By.xpath("//input[@value='Go']"));
		go.click();
		System.out.println("AMAZON TESTCASE 2 : "+Thread.currentThread().getId());

	}
	@Parameters({"product"})
	@Test
	public void searchProductFailure(String product) {
		WebElement search = d.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys(product);
		WebElement go = d.findElement(By.xpath("//input[@value='Go']"));
		go.click();
		System.out.println("AMAZON TESTCASE 3 : "+Thread.currentThread().getId());
		Assert.assertTrue(false);
	}
}
