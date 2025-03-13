package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageContactPage;

public class ManageContactTest  extends Base 
{
	LoginPage loginpage;
	HomePage homepage;
	ManageContactPage managecontactpage;
	
	@Test
	public void verifyThatUserAbleToChangePhonenumberAndDeliveryTime()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnManageContact();
	    
	    managecontactpage=new ManageContactPage(driver);
	    managecontactpage.editContactUsInformation("+91-8745854578","40");
	    
	    boolean greenAlertDisplayedStatus=managecontactpage.isSuccessAlertDisplayed();
	    Assert.assertTrue(greenAlertDisplayedStatus);   
	}
}
