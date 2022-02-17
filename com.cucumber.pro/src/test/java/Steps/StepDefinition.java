package Steps;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.salesforce.BasePage;
import com.base.test.BaseTest;
import com.salesForce.pages.loginpage.LoginPage;
import com.salesForce.utility.CommmonUtilities;
import com.salesForce.utility.GenerateReports;
import com.salesfForce.pages.Home.HomePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	WebDriver driver;
	LoginPage loginPage;
	BasePage basePage;
	HomePage homePage;
	//protected static GenerateReports report=GenerateReports.getInstance();
	
	
	
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		//report.startSingleTestReport(method.getName());
	}
	@Given("User is on the login Page")
	public void user_is_on_the_login_page() {
		
		driver.get(CommmonUtilities.getApplicationProperty("url"));
		
	   ////report.logTestInfo("sF page is loaded");
	}

	@When("user enters\"cc@techarch.com\" into username field")
	public void user_enters_cc_techarch_com_into_username_field() {
		String username=CommmonUtilities.getApplicationProperty("username");
		loginPage.enterIntoUsername(username);
		
		 //report.logTestInfo("userName key is sent");
	}

	@When("user enters\"selenium1\" into password field")
	public void user_enters_selenium1_into_password_field() {
		String password=CommmonUtilities.getApplicationProperty("password");
		loginPage.enterIntoPassword(password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() 
	{
		loginPage.clcikLoginButton();
	}

	@Then("verify page title {string}")
	public void verify_page_title(String string) {
		
		System.out.println("at home page");//
		boolean userandHomeVerigy=homePage.verifyTitleOfTheHomePageAndUserAccount(string);
		Assert.assertTrue(userandHomeVerigy);
	}
	
	

	@When("user enters {string} into password field")
	public void user_enters_into_password_field(String string) {
		//String password=CommmonUtilities.getApplicationProperty("password");
		loginPage.enterIntoPassword(string);
	}

	@Then("verify error message {string}")
	public void verify_error_message(String string) {
	    String errorMsg=loginPage.getErrorMessage();
	    if(errorMsg.equalsIgnoreCase(string))
	    	Assert.assertTrue(true);
	    else
	    	Assert.assertTrue(false);
	}

//	 Scenario: Login with  valid UserName and inValid Password
//	  
//	    Given User is on the login Page
//	    When user enters"cc@techarch.com" into username field
//	    When user enters"123" into password field
//	    When user click on login button
//	   
//	    Then error message should be displayed
//	
	@After
	public void tearDown() {
		driver.quit();
	}

}
