package org.testng;

import org.cts.LibGlobal;
import org.pojo.LoginPojo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogInClass extends LibGlobal {
	@BeforeClass
	public static void startBrowser() {
		launchMaximiseBrowser();
		implicitWait(20);
		
	}
	@Parameters({"userName","passWord"})
	@Test(invocationCount=2)
	public void tc1(@Optional("python")String user,@Optional("python@123")String pass) {
		loadUrl("http://adactinhotelapp.com/");
		LoginPojo l=new LoginPojo();
		fill(l.getMail(), user);
		Assert.assertEquals(l.getMail().getAttribute("value"),"zxydummy321","Check the mail id" );
		fill(l.getPass(), pass);
		Assert.assertEquals(l.getPass().getAttribute("value"), "Dummy@123","Check the password" );
		btnClick(l.getButton());
	}


}
