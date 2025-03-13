package com.sevenrmartsupermarket.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class LoginTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	ExcelReader excelreader=new ExcelReader();
	
	@Test(groups="regression",description="Verify the profile name")
	public void verifyLogin()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.logIn("admin","admin");
		String expectedProfileName="Admin";
		String actualProfileName=homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);
		
		//homepage.adminUsersTile();
	}
	@Test(groups={"smoke","regression"})
	public void verifyInvalidLogin()
	{
		excelreader.setExcelFile("LoginData","InvalidCredentials");
		String userName=excelreader.getCellData(2, 0);
		String passWord=excelreader.getCellData(2, 1);
	
		loginpage=new LoginPage(driver);
		loginpage.logIn(userName,passWord);
		
		boolean isRedAlertMessageDisplayed=loginpage.alertMessageForInvalidCredentials();
		Assert.assertTrue(isRedAlertMessageDisplayed);
		
	}
}
