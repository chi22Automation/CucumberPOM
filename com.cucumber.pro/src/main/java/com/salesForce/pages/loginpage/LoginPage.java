package com.salesForce.pages.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.salesforce.BasePage;
import com.salesForce.utility.CommmonUtilities;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver){
		super(driver);

    }
	
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id ="Login") WebElement btnLogin;
	@FindBy(id ="error") WebElement errorText;
	@FindBy(id ="rememberUn") WebElement rememberMeCheckBox;
	@FindBy(id ="forgot_password_link") WebElement forgotPwdLink;
	@FindBy(xpath ="//span[@id='idcard-identity']") WebElement userTxtBoxAfterRemCheckOut;
	@FindBy(xpath ="//a[@title='Logout']") WebElement logOut;
	
	@FindBy(xpath ="//input[@id='un']") WebElement userName;
	@FindBy(xpath ="//input[@id='continue']") WebElement continueBtn;
	@FindBy(xpath ="//p[contains(text(),'We’ve sent you an email with a link to finish rese')]") WebElement messagetopasswordchange;
	//p[contains(text(),'We’ve sent you an email with a link to finish rese')]
	public void clcikForgotPwd() 
	{
		clickElement(forgotPwdLink);
	}
		
		public void sendTextEmail()
		{ 
			userName.sendKeys(CommmonUtilities.getApplicationProperty("email"));
			clearElement(continueBtn); 
	    }
		public boolean messageforForgotPwd() 
		{
			if(messagetopasswordchange.getText().contains("sent"))
				return true;
			else 
				return false;
			
			
		}
	

	public void verifyCredentilas()
	{
		String username=CommmonUtilities.getApplicationProperty("username");
	     enterIntoUsername(username);
		String password=CommmonUtilities.getApplicationProperty("password");
		 enterIntoPassword(password);
		 clcikLoginButton();
		 
		 
	}
	
	public void enterIntoUsername(String usrName) {
		enterText(username, usrName);
		
	}
	public void enterIntoPassword(String passwrd) {
		enterText(password, passwrd);
	}
	public void clcikLoginButton() {
		clickElement(btnLogin);
	}
	public void handleAlert() {
		AcceptAlert();
	}
	public void clcikCheckBox() {
		clickElement(rememberMeCheckBox);
	}
	
	public String getErrorMessage() 
	{
		String recvErrorTxt=getErrorText(errorText);
		return recvErrorTxt;
	}
	public String gettextBoxDateAfterLogOut()
	{
		//report.logTestInfo("inside method gettextBoxDateAfterLogOut");
		//report.logTestInfo(userTxtBoxAfterRemCheckOut.getText());
	String txtData=	getTextBoxData(userTxtBoxAfterRemCheckOut);
	//report.logTestInfo("inside method gettextBoxDateAfterLogOutafterGetting textbox data"+txtData);
	
	return txtData;
	}
	}

