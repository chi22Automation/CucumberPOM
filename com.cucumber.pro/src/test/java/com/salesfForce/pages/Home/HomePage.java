package com.salesfForce.pages.Home;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.base.salesforce.BasePage;



public class HomePage extends  BasePage	
{
public HomePage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="home_Tab") WebElement hometab;
	@FindBy(id="userNavLabel") WebElement login;
	@FindBy(linkText="Logout") WebElement logout;	
	
	@FindBys(@FindBy(xpath="//div[@id='userNav-menuItems']//a")) List<WebElement> AllData;
	@FindBy(xpath ="//div[@id='userNavButton']") WebElement userloginLink;
	@FindBy(xpath ="//a[@title='My Profile']") WebElement myProfile;
	@FindBy(xpath ="//a[@title='My Settings']")  WebElement  userMenumySettinge;
	@FindBy(xpath ="//div[@id='tabContainer']//nav//ul//li[1]//a[1]")  WebElement  homeLinkBtn;
	@FindBy(xpath ="//h1[@class='currentStatusUserName']//a")  WebElement  firstAndLastName;
	@FindBy(xpath ="//div[@title='User menu for c Chh']//span[@class='menuButtonLabel']")  WebElement  userProfile;
	
	@FindBy(xpath ="//ul[@id='tabBar']")  List<WebElement> tabitems1 ;
	@FindBy(xpath ="//select[@id='duel_select_1']") WebElement selectTab;
	
	@FindBy(xpath ="//tbody/tr[1]/td[1]/select[1]") WebElement availableTabs;
	@FindBy(xpath ="//input[@title='Save']") WebElement saveBtn;
	@FindBy(xpath ="//ul[@id='tabBar']")  List<WebElement> tabitems2;
	@FindBy(xpath ="//img[@title='Remove']")  WebElement removeBtn;
	//img[@title='Remove']
	 String previousSessionTab="";
	public boolean selectFromCustomizedTabAndRemove()
	{
		waitUntilVisible(selectTab);
		//if(dropdown.getSize()>0) { to be implemented
		Select selQReport2=new Select(selectTab);
		selQReport2.selectByIndex(2);
		WebElement selWeb= selQReport2.getFirstSelectedOption();
		System.out.println("selected item is"+selWeb.getText());
		String text=selWeb.getText();
		System.out.println("items move form select to available list");
		waitUntilVisible(removeBtn);
		clickElement(removeBtn);
		waitUntilVisible(availableTabs);
		Select selQReport3=new Select(availableTabs);
		List	<WebElement> listavailable= selQReport3.getOptions();
		for(WebElement we:listavailable)
		{ if(we.getText().equalsIgnoreCase(text))
		{ previousSessionTab=we.getText();
			//report.logTestInfo("items Moved from selected tab");
		}
		break;

		}
		waitUntilVisible(saveBtn);
		clickElement(saveBtn);
		
		
		
		if (tabitems1.equals(tabitems2) == true) {
			System.out.println(" Array List are equal");
			return true;
		}
		else
		{
			System.out.println(" Array List are  not equal");
			return false;
		}

	}
	
	 public boolean logOutNLoginFromCustom()
	 { boolean istabequalAsPrevious=false;
		 waitUntilVisible(logout);
			clickElement(logout);
		   waitUntilVisible(login);
			clickElement(login);
			for(WebElement we:tabitems2)
			{if(we.getText().equalsIgnoreCase(previousSessionTab))
				istabequalAsPrevious= false;
			else istabequalAsPrevious= true;
			}
			return istabequalAsPrevious;
	 }
			
	
		 
	
	
	
	public boolean firstNlastPageHomePage() 
	{
		waitUntilVisible(homeLinkBtn);
	    clickElement(homeLinkBtn);
	    waitUntilVisible(firstAndLastName);
		String fAndLName= firstAndLastName.getText();
		String[]fSplitLName=  fAndLName.split("");
		//if((fSplitLName[0].equalsIgnoreCase("c")) &&(fSplitLName[1].equalsIgnoreCase("Chh")))
		String FAndLNamePage=driver.getTitle();
		waitUntilVisible(userProfile);
		clickElement(userProfile);
		waitUntilVisible(myProfile);
		clickElement(myProfile);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		String myprofileTitle=driver.getTitle();
		//report.logTestInfo(myprofileTitle);
		if(FAndLNamePage.equalsIgnoreCase(myprofileTitle))
		return true;
		else
			return false;
	}
	
	
	public boolean verifyTitleOfTheHomePageAndUserAccount() {
		boolean result=false;
		String title=getTitleOfThePage(hometab);
		System.out.println("title of the page"+title);
		String userverify=login.getText();
		System.out.println(userverify);
		if((title.equalsIgnoreCase("Home Page ~ Salesforce - Developer Edition")) && (userverify.equalsIgnoreCase("c Chh")))

		{
			System.out.println("title is"+title);
			result=true;
		}
		else
		{
			System.out.println("title is in false cond"+title);
			result= false;
		}
		return result;

		
	}
	public boolean verifyTitleOfTheHomePageAndUserAccount(String stringHomeTitle) {
		boolean result=false;
		String title=getTitleOfThePage(hometab);
		System.out.println("title of the page"+title);
		String userverify=login.getText();
		System.out.println(userverify);
		if((title.equalsIgnoreCase(stringHomeTitle)) && (userverify.equalsIgnoreCase("c Chh")))

		{
			System.out.println("title is"+title);
			result=true;
		}
		else
		{
			System.out.println("title is in false cond"+title);
			result= false;
		}
		return result;

		
	}
	public void clcikloginlink() {
		clickElement(login);
	}
	public void clcikLogoutlink() 
	{
		clickElement(logout);
	}
	public void clickprofileLink() {
		clickElement(myProfile);
		
		//report.logTestInfo("After mYprofileCLicked");
		waitUntilVisible(login);
		//report.logTestInfo("After waiting");
		
	}
	public void clcikLogouttitle() 
	{
		clickElement(logout);
	}
	public void clickpmysettingLink() {
		clcikloginlink();
		waitUntilVisible(userMenumySettinge);
		clickElement(userMenumySettinge);		
//		report.logTestInfo("After mYsettingCLicked");
//		report.logTestInfo("After waiting");
		
	}
	public void mouseOverelement()
	{
		//mouseOver(userloginLink);
		//report.logTestInfo("afterMouseoverLogin now we will click oginLink");
		clickElement(userloginLink);
		//report.logTestInfo("afterMouseoverLogin Linkedis click");
	}
	
	public  boolean clickuserMenuData()
	{  //report.logTestInfo("clicking all login data");
		boolean usermenuverify=getuserMenuData(AllData);
		//report.logTestInfo("afterverifying all list items in login Link");
		return usermenuverify;
	}
	public  boolean getuserMenuData(List<WebElement> items)
	{
		String[] exp = {"My profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};
		// List<WebElement> items= driver.findElements(By.xpath("//div[@id='userNav-menuItems']//a"));
		 //System.out.println("no of items are"+items.size()); 
		  boolean match = false;
		 for(WebElement we:items)  
		 { 	System.out.println(we.getText());	
		  for (int i=0; i<exp.length; i++){
		      if (we.getAttribute("text").equalsIgnoreCase(exp[i])){
		        match = true;
		      }
		    }
		 }
		 return match;
	}
	 
	}
	

