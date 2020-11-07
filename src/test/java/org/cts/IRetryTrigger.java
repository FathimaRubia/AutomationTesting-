package org.cts;

import java.io.IOException;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryTrigger implements IRetryAnalyzer{
	int min=0,max=3;

	@Override
	public boolean retry(ITestResult result) {
		try {
			LibGlobal.screenShot(result.getName());
		} catch (IOException e) {
			System.out.println("IOException handled");
			e.printStackTrace();
		}
		if(min< max) {
			min++;
			return true;
		}
		
		return false;
	}

	
	

}
