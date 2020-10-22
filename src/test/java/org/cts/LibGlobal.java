package org.cts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class LibGlobal {
	public static WebDriver driver=null;
	public static Actions a;
	public static Robot r;
	public static JavascriptExecutor js;
	public static TakesScreenshot tk;
	public static File f;

	public static WebDriver launchMaximiseBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AA\\eclipse-workspace\\ProjectFramework\\Drivers\\chromedriver 86 version.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	public static void implicitWait(int tim) {
		driver.manage().timeouts().implicitlyWait(tim, TimeUnit.SECONDS);
	}
	public static void fluentWaitAlert(int tim,int poll) { 
		FluentWait<WebDriver> f=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(tim))
				.pollingEvery(Duration.ofSeconds(poll)).ignoring(Throwable.class);
		f.until(ExpectedConditions.alertIsPresent());
	}
	public static void objectCreation() throws AWTException {
		a=new Actions(driver);
		r=new Robot();
		js=(JavascriptExecutor)driver;
		tk=(TakesScreenshot)driver;
	}
	public static void loadUrl(String url) {
		driver.get(url);
	}
	public static void fill(WebElement element,String input) {
		element.sendKeys(input);
	}
	public static void btnClick(WebElement element){
		element.click();
	}
	public static void visibilityCheck(WebElement element){
		boolean display = element.isDisplayed();
		System.out.println("DISPLAYED : "+display);
		boolean enable = element.isEnabled();
		System.out.println("ENABLED : "+enable);
		boolean select = element.isSelected();
		System.out.println("SELECTED : "+select );
	}
	public static String title() {
		String head = driver.getTitle();
		return head;
	}
	public static String url() {
		String urlLoad = driver.getCurrentUrl();
		return urlLoad;
	}
	public static void closeBrowser() {
		driver.quit();
	}
	public static String text(WebElement element) {
		String text = element.getText();
		return text;
	}
	public static String attribute(WebElement element,String attrName) {
		String attrValue = element.getAttribute(attrName);
		System.out.println("ATTRIBUTE VALUE OF "+attrName+": "+attrValue);
		return attrValue;
	}
	public String attributeValue(WebElement element) {
		String userInput = element.getAttribute("value");
		System.out.println("USER ENTERED INPUT : "+userInput);
		return userInput;
		
	}
	public static String Css(WebElement element,String propertyName) {
		String propertyValue = element.getCssValue(propertyName);
		System.out.println("CSS PROPERTY VALUE OF "+propertyName +": "+propertyValue);
		return propertyValue;
	}
	public static void mouseHover(WebElement element) {
		a.moveToElement(element).perform();
	}
	public static void actionsFill(WebElement target,String input) {
		a.sendKeys(target, input).perform();
	}
	public static void dragDrop(WebElement from,WebElement to) {
		a.dragAndDrop(from,to).perform();
	}
	public static void rightClick(WebElement element) {
		a.contextClick(element).perform();
	}
	public static void dbleClik(WebElement element) {
		a.doubleClick(element).perform();
	}
	public static void select() {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
	}
	public static void copy(){
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}
	public static void cut() {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
	}
	public static void tab() {
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	public static void delete() {
		r.keyPress(KeyEvent.VK_DELETE);
		r.keyRelease(KeyEvent.VK_DELETE);
	}
	
	public static void enter() {
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void paste() {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	public static void down(int n) {
		for (int i = 1; i <=n; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);	
		}
	}
	public static List<WebElement> elementsTagname(String tagName) {
		List<WebElement> elements = driver.findElements(By.tagName(tagName));
		System.out.println("LIST OF WEBELEMENTS");
		System.out.println("===================");
		for (WebElement element : elements) {
			text(element);
		}
		return elements;
	}
	public static void screenShot(String name) throws IOException {
		File src = tk.getScreenshotAs(OutputType.FILE);
		f=new File("C:\\Users\\AA\\eclipse-workspace\\ProjectFramework\\ScreenShot\\"+name+".png");
		FileUtils.copyFile(src, f);
	}
	public static void jsFill(WebElement element,String input) {
		js.executeScript("arguments[0].setAttribute('value','"+input+"')", element);
	}
	public static String jsGet(WebElement element) {
		Object obj = js.executeScript("return arguments[0].getAttribute('value')", element);
		String text=(String)obj;
		System.out.println("USER INPUT: " + text);
		return text;
	}
	public static void jsClick(WebElement element) {
		js.executeScript("arguments[0].click()", element);
	}
	public static void jsScrollUp(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public static void jsScrollDown(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	public static void jsHighLighting(WebElement element) {
		js.executeScript("arguments[0].setAttribute('style','background:yellow')", element);
	}
	public static void alertAccept(){
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	public static void alertDismiss() {
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}
	public static void alertFill(String input) {
		Alert alt=driver.switchTo().alert();
		alt.sendKeys(input);
	}
	public static void alertText() {
		Alert alt=driver.switchTo().alert();
		String text = alt.getText();
		System.out.println("ALERT TEXT : "+text);
	}
	public static void frameSwitch(WebElement fr) {
		driver.switchTo().frame(fr);
	}
	public static void frameSwitch(String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	public static void frameSwitch(int index) {
		driver.switchTo().frame(index);
	}
	public static void frameParent() {
		driver.switchTo().parentFrame();
	}
	public static int framesCount() {
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int count = frames.size();
		return count;
	}
	public static int tablesCount() {
		List<WebElement> tables = driver.findElements(By.tagName("table"));
		int count = tables.size();
		return count;
	}
	public static void defaultSwitch() {
		driver.switchTo().defaultContent();
	}
	public static void windowSwitch() {
		String parentId = driver.getWindowHandle();
		Set<String> allWindowsId = driver.getWindowHandles();
		for (String windowId : allWindowsId) {
			if(!(parentId.equals(windowId))) {
				driver.switchTo().window(windowId);
			}	
		}
	}
	public static int dropDownCount() {
		List<WebElement> dropDowns = driver.findElements(By.tagName("select"));
		int count = dropDowns.size();
		return count;
	}
	public static void dropDownIndex(WebElement drop,int a) {
		Select s=new Select(drop);
		s.selectByIndex(a);
	}
	public static void dropDownValue(WebElement drop,String val) {
		Select s=new Select(drop);
		s.selectByValue(val);
	}
	public static void dropDownVisible(WebElement drop,String vis) {
		Select s=new Select(drop);
		s.selectByVisibleText(vis);
	}
	public static void dropDownOptions(WebElement drop) {
		Select s=new Select(drop);
		List<WebElement> optionNames = s.getOptions();
		System.out.println("DROPDOWN OPTIONS");
		System.out.println("================");
		for (WebElement option : optionNames) {
			text(option);	
		}
	}
	public static void dropDownSelectOptions(WebElement drop) {
		Select s=new Select(drop);
		List<WebElement> selectNames = s.getAllSelectedOptions();
		System.out.println("SELECTED OPTIONS");
		System.out.println("================");
		for (WebElement selected : selectNames) {
			text(selected);	
		}
	}
	public static void dropDownFirstSelect(WebElement drop) {
		Select s=new Select(drop);
		WebElement first = s.getFirstSelectedOption();
		text(first);
	}
	public static void dropDownDeSelect(WebElement drop) {
		Select s=new Select(drop);
		s.deselectAll();
	}
	public static void deSelectIndex(WebElement drop,int a) {
		Select s=new Select(drop);
		s.deselectByIndex(a);
	}
	public static void deSelectValue(WebElement drop,String val) {
		Select s=new Select(drop);
		s.deselectByValue(val);
	}
	public static void deSelectVisible(WebElement drop,String vis) {
		Select s=new Select(drop);
		s.deselectByVisibleText(vis);
	}
	public static void multipleDropDown(WebElement drop) {
		Select s=new Select(drop);
		boolean multiple = s.isMultiple();
		System.out.println("MULTI-SELECT DROPDOWN : "+multiple);
	}
	public static void navigateUrl(String url) {
		driver.navigate().to(url);
	}
	public static void navigateBack() {
		driver.navigate().back();
	}
	public static void navigateForward() {
		driver.navigate().forward();
	}
	public static void navigateRefresh() {
		driver.navigate().refresh();
	}
	
public static String excelRead(int i,int j) throws IOException {
	
	File file=new File("C:\\Users\\AA\\eclipse-workspace\\ProjectFramework\\TestDataExcel\\Datas.xlsx");
	FileInputStream finStream=new FileInputStream(file);
    Workbook w=new XSSFWorkbook(finStream);
	Sheet s = w.getSheet("adactin");
	Row r = s.getRow(i);
	Cell c = r.getCell(j);
    CellType cellType = c.getCellType();
    String value="";
    int code = cellType.getCode();
    
	if (code==1) {
		value = c.getStringCellValue();
	
	} else if(DateUtil.isCellDateFormatted(c)) {
		Date d = c.getDateCellValue();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
		value = sim.format(d);

	}
	else {
		double dbl = c.getNumericCellValue();
		long l=(long)dbl;
		value = String.valueOf(l);
	}
	return value;
}
public static void excelNewWrite(int i,int j,String name) throws IOException {
	File f=new File("C:\\Users\\AA\\eclipse-workspace\\ProjectFramework\\TestDataExcel\\Datas.xlsx");
	Workbook w=new XSSFWorkbook();
	Sheet s = w.createSheet("data");
	Row r = s.createRow(i);
	Cell c = r.createCell(j);
	c.setCellValue(name);
	FileOutputStream fout=new FileOutputStream(f); 
	w.write(fout);
	System.out.println("New Excel Created Successfully");
}
public static void excelWrite(int rowNo,int cellNo,String name) throws IOException {
	File file=new File("C:\\Users\\AA\\eclipse-workspace\\ProjectFramework\\TestDataExcel\\Datas.xlsx");
	FileInputStream finStream=new FileInputStream(file);
	Workbook w=new XSSFWorkbook(finStream);
	Sheet s = w.getSheet("adactin");
	Row r = s.getRow(rowNo);
	Cell c = r.createCell(cellNo);
	c.setCellValue(name);
	FileOutputStream fout=new FileOutputStream(file);
	w.write(fout);
	System.out.println("Excel Write Done Successfully");
}
public static void excelUpdate(int rowNo,int cellNo,String existed,String newContent) throws IOException {
	File file=new File("C:\\Users\\AA\\eclipse-workspace\\ProjectFramework\\TestDataExcel\\Datas.xlsx");
	FileInputStream finStream=new FileInputStream(file);
	Workbook w=new XSSFWorkbook(finStream);
	Sheet s = w.getSheet("adactin");
	Row r = s.getRow(rowNo);
	Cell c = r.getCell(cellNo);
	String value = c.getStringCellValue();
	if(value.contains(existed)) {
		c.setCellValue(newContent);
	}
	
	FileOutputStream fout=new FileOutputStream(file);
	w.write(fout);
	System.out.println("Excel Update Done Successfully");

}



}







