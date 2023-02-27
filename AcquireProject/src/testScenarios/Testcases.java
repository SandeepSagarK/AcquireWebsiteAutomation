package testScenarios;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProviders.ConfigFileReader;
import genericActions.*;
import pages.AcquireHomePage;
import pages.Newsroom;

public class Testcases {
	WebDriver driver;
	AcquireHomePage objAcquireHomePage;
	Newsroom objNewsroom;
	ConfigFileReader configFileReader;
	Alerts objAlerts;
	ScreenShot objScreenShot; 
	static ExtentTest test;
	static ExtentReports report;

	@BeforeClass
	public static void startTest()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"TestReport.html");
		test = report.startTest("Acquire Website Automation Test Report");
	}
	
	@BeforeTest
	public void setup() {
		configFileReader= new ConfigFileReader();
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(configFileReader.getApplicationUrl());
		driver.manage().window().maximize();
		objAcquireHomePage = new AcquireHomePage(driver);
		objNewsroom = new Newsroom(driver);
	}
	
	@Test
	public void navigate_to_homepage_verify_on_acquire_hyperlink() {	
		try {
			String acquireHyperLink = objAcquireHomePage.AcquireIcon.getAttribute("href");
			System.out.println("HyperLink for the Acquire URL is " +acquireHyperLink);
			assertEquals(configFileReader.getApplicationUrl(), acquireHyperLink);
			test.log(LogStatus.PASS, "Verified Acqire Hyperlink");
		} catch(Exception e){
			test.log(LogStatus.FAIL, "Test Verification Acqire Hyperlink Failed");
		}
	}
	
	@Test
	public void verify_on_newsroom() {
		try {
			objAcquireHomePage.Newsroom.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String acquireNewsroomUrl = objAcquireHomePage.Newsroom.getAttribute("href");
			System.out.println("HyperLink for the Acquire Newsroom URL is " +acquireNewsroomUrl);
			assertEquals(configFileReader.getNewsRoomUrl(), acquireNewsroomUrl);
			driver.navigate().back();
			test.log(LogStatus.PASS, "Verified Newsroom Page");
		} catch(Exception e){
			test.log(LogStatus.FAIL, "Test Verification Newsroom Page Failed");
		}
	}
	
	@Test
	public void verify_on_eventsbookings() {
		try {
			objAcquireHomePage.EventsAndBookings.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String acquireEventsUrl = objAcquireHomePage.EventsAndBookings.getAttribute("href");
			System.out.println("HyperLink for the Acquire Events and Bookings URL is " +acquireEventsUrl);
			String acquireEventsBookingsBanner = objAcquireHomePage.EventsAndBookingsBanner.getText();
			System.out.println("EventsBookings Banner is " +acquireEventsBookingsBanner);
			assertEquals(configFileReader.getEventsBookings(), acquireEventsBookingsBanner);
			driver.navigate().back();
			test.log(LogStatus.PASS, "Verified Events And Bookings Page");
		} catch(Exception e){
			test.log(LogStatus.FAIL, "Test Verification Events And Bookings Page Failed");
		}
	}
	
	@Test
	public void verify_on_requestsupport() {
		try {
			objAcquireHomePage.RequestSupport.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String acquireRequestSupportUrl = objAcquireHomePage.RequestSupport.getAttribute("href");
			System.out.println("HyperLink for the Acquire Request Support URL is " +acquireRequestSupportUrl);
			String acquireRequestSupportBanner = objAcquireHomePage.RequestSupportBanner.getText();
			System.out.println("Request Support Banner is " +acquireRequestSupportBanner);
			assertEquals(configFileReader.getRequestSupport(), acquireRequestSupportBanner);
			driver.navigate().back();
			test.log(LogStatus.PASS, "Verified Request Support Page");
		} catch(Exception e){
			test.log(LogStatus.FAIL, "Test Verification RequestSupport Page Failed");
		}
	}
	
	@Test
	public void navigate_to_newsroom_dismiss_alert_and_collect_CategoryDropdown_options() throws InterruptedException {
		try {
			objAcquireHomePage.Newsroom.click();
			Thread.sleep(15000);
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			wait.until(ExpectedConditions.textToBePresentInElement(objNewsroom.newWindowTitle, "Keep in touch with industry trends"));
//			System.out.println("Heading of child window is " + objNewsroom.newWindowTitle.getText());        
//			String acquireNewsroomUrl = objAcquireHomePage.Newsroom.getAttribute("href");
//			System.out.println("HyperLink for the Acquire Newsroom URL is " +acquireNewsroomUrl);
//			assertEquals(configFileReader.getNewsRoomUrl(), acquireNewsroomUrl);
			objNewsroom.closeDialogBox.click();
			Thread.sleep(3000);
		
			//to perform Scroll on application using Selenium
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			
			objNewsroom.categoryDropdrop.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			String catList = objNewsroom.categoryList.getText();
			System.out.println("List: "+catList);
			driver.navigate().to(configFileReader.getApplicationUrl());
			test.log(LogStatus.PASS, "Verified navigate_to_newsroom_dismiss_alert_and_collect_CategoryDropdown_options Page");
		} catch(Exception e){
			test.log(LogStatus.FAIL, "Test navigate_to_newsroom_dismiss_alert_and_collect_CategoryDropdown_options Failed");
		}
		
	}
	
	@Test
	public void navigate_to_contactUs_check_Insuite_enroll_top() {
		try {
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			
			objAcquireHomePage.ContactUs.click();
			objAcquireHomePage.CookieAccept.click();
			
			ScreenShot.takeSnapShot(driver, System.getProperty("user.dir")+"ContactUs.png");
			
			//to perform Scroll on application
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,650)", "");
			
			
			objAcquireHomePage.BacktoTop.click();
			
			test.log(LogStatus.PASS, "Verified navigate_to_contactUs_check_Insuite_enroll_top");
		} catch(Exception e){
			test.log(LogStatus.FAIL, "Test navigate_to_contactUs_check_Insuite_enroll_top Failed");
		}
	}
			


	@AfterTest
	public void cleanup(){
		driver.close();
		driver.quit();
	}
	
	@AfterClass
	public static void endTest()
	{
		report.endTest(test);
		report.flush();
	}
	
}