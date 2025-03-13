package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base{
	
	HomePage homepage;
	LoginPage loginpage;
	
	@Test(description="Verify that admin is able to navigate to Admin Users page")
	public void adminUsers()
	{
		loginpage=new LoginPage(driver);
	    homepage=new HomePage(driver);
	    loginpage.logIn("admin","admin");
	    homepage.clickOnAdminUsers();
	}
}
