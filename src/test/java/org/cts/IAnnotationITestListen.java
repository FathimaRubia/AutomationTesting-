package org.cts;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class IAnnotationITestListen implements IAnnotationTransformer,ITestListener {
	public static TakesScreenshot tk;
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testCons, Method testmethod) {
		IRetryAnalyzer r = annotation.getRetryAnalyzer();
		if(r==null) {
			annotation.setRetryAnalyzer(IRetryTrigger.class);
		}
	}

	@Override
	public void onFinish(ITestContext arg0) {
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
			
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			LibGlobal.screenShot(result.getName());
		} catch (IOException e) {
			System.out.println("IOException handled");
			e.printStackTrace();
		}
		
	}

}
