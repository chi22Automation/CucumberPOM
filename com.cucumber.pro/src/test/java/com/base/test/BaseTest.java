package com.base.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.salesForce.pages.loginpage.LoginPage;
import com.salesForce.utility.CommmonUtilities;
import com.salesForce.utility.GenerateReports;

import com.salesForce.utility.Constants;

//import com.salesForce.pages.loginpages.LoginPage;
//import com.salesForce.pages.profiles.ProfilePage;
//import com.salesForce.utility.CommmonUtilities;
//import com.salesForce.utility.Constants;
//import com.salesForce.utility.GenerateReports;
//import com.salesfForce.pages.Accounts.AccountEdit;
//import com.salesfForce.pages.Accounts.AccountMerge;
//import com.salesfForce.pages.Accounts.AccountNew;
//import com.salesfForce.pages.Accounts.AccountNewView;
//import com.salesfForce.pages.Accounts.AccountReport;
//import com.salesfForce.pages.Accounts.Accounts;
//import com.salesfForce.pages.Contacts.ContactEdit;
//import com.salesfForce.pages.Contacts.ContactHome;
//import com.salesfForce.pages.Contacts.ContactNewView;
//import com.salesfForce.pages.Home.DeveloperConsole;
//import com.salesfForce.pages.Home.HomePage;
//import com.salesfForce.pages.Home.MySettingsPage;
//import com.salesfForce.pages.Leads.LeadsHome;
//import com.salesfForce.pages.Leads.LeadsView;
//import com.salesfForce.pages.Opportunity.NewOpportunity;
//import com.salesfForce.pages.Opportunity.Opportunity;
//import com.salesfForce.pages.Opportunity.OpportunityPipeline;
//import com.salesfForce.pages.Opportunity.QuterlyReport;
//import com.salesfForce.pages.Opportunity.StuckOpportunities;
//import com.salesfForce.pages.RandomScnerio.CalenderNewEvent;
//import com.salesfForce.pages.RandomScnerio.UserCalender;
//import com.salesfForce.pages.RandomScnerio.UserCustomisedPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected static WebDriver driver;
	
	protected static GenerateReports report=GenerateReports.getInstance();
protected static LoginPage loginPage;
//	protected static HomePage homePage;
//	protected static ProfilePage profilePage;
//	protected static MySettingsPage mySettingPage;
//	protected static DeveloperConsole developerConsole;
//	protected static AccountEdit accountEdit;//     
//	protected static AccountMerge accountMerge;
//	protected static AccountNew accountNew;
//	protected static AccountNewView accountNewView;
//	protected static AccountReport accountReport;
//	protected static Accounts accounts;
//	protected static Opportunity opportunty;
//	protected static OpportunityPipeline oportunityPipeline;
//	protected static QuterlyReport oportunityReport;
//	protected static StuckOpportunities stuckOportunities;
//	protected static NewOpportunity newOpportunity;
//	protected  static LeadsView leadsView;
//	protected  static LeadsHome leadsHome;
//	protected  static ContactNewView contactNewView;
//	protected  static ContactHome contactHome;
//	protected  static ContactEdit contactEdit;
//	protected  static UserCustomisedPage userCustomisedPage;
//	protected  static UserCalender userCalender;
//	protected  static CalenderNewEvent calenderNewEvent;
//	  
	  
	@BeforeTest
	public void setUp() {
		System.out.println("Before classs is executing");
		report.startExtentReport();
		System.out.println("extent report document is created");
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void initialSetUp(String browserName,Method method){
		report.startSingleTestReport(method.getName());
		System.out.println("Before method is executing");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(CommmonUtilities.getApplicationProperty("url"));
		report.logTestInfo("application url is"+CommmonUtilities.getApplicationProperty("url"));
		ConstructorsCall();
		
	}
	public void ConstructorsCall() {
	//loginPage=new LoginPage(driver);
//		homePage=new HomePage(driver);
//		profilePage=new ProfilePage(driver);
//		mySettingPage=new MySettingsPage(driver);
//		developerConsole=new DeveloperConsole(driver);
//		accountEdit=new AccountEdit(driver);
//		accountMerge=new AccountMerge(driver);
//		accountNew=new AccountNew(driver);
//		accountNewView=new AccountNewView(driver);
//		accountReport=new AccountReport(driver);
//		accounts=new Accounts(driver);
//		opportunty=new Opportunity(driver);
//		oportunityPipeline= new  OpportunityPipeline(driver);
//		oportunityReport= new QuterlyReport(driver);
//		stuckOportunities=	new StuckOpportunities(driver);
//		newOpportunity=new NewOpportunity(driver);
//		leadsView=new LeadsView(driver);
//		leadsHome=new LeadsHome(driver);
//		contactNewView= new ContactNewView(driver);		
//		contactHome =new ContactHome(driver);
//		contactEdit= new ContactEdit(driver);
//		userCustomisedPage= new UserCustomisedPage(driver);
//		userCalender= new UserCalender(driver);
//		calenderNewEvent= new CalenderNewEvent(driver);
//		
}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			report.logTestpassed();
		} else if(result.getStatus()==ITestResult.FAILURE) {
			report.logTestFailed();
			
			String path=takescreenshot();
			System.out.println(path);
			try {
				report.logger.addScreenCaptureFromPath(path);
				//report.logger.addScreenCaptureFromPath(path, path)
				report.logTestInfo("file path for screenshot is received"+path);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		//closeAllDriver();
		driver.quit();
	}
	
	@AfterTest
	public void endUp() {
		report.endTestReport();
	}
	
	public static String takescreenshot() {
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//D:\BatchProjectCodes\Dec21\SeleniumAutomation\screenshots\firebase.jpg
		String filePath=Constants.SCREENSHOT_PATH+"firebase.jpg";
		System.out.println(filePath);
		File DestFile=new File(filePath);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
		//return "C://Users//chitr//Downloads//SeleniumAutomationPOMFramework-20220206T050024Z-001//SeleniumAutomationPOMFramework//ScreenShots//firebase.jpg";
		//return "C:\\Users\\chitr\\Downloads\\SeleniumAutomationPOMFramework-20220206T050024Z-001\\SeleniumAutomationPOMFramework\\ScreenShots\\firebase.jpg";
	}
	
}
