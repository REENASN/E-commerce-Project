package com.sevenrmartsupermarket.tests;

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
	@Test(groups="regression")
	public void verifyLogin()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.logIn("REENASN","REENASN123");
		String expectedProfileName="REENASN";
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
		System.out.println(userName+passWord);
		loginpage=new LoginPage(driver);
		loginpage.logIn(userName,passWord);
		//loginpage.logIn("REENA","REENASN12");
		String expectedAlertMessage="Alert!";
		String actualAlertMessage=loginpage.alertMessageForInvalidCredentials();
		System.out.println("ActualAlertMessage"+actualAlertMessage);
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
		
	}
}
