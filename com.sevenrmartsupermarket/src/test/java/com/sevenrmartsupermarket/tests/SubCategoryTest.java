package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.SubCategoryPage;

public class SubCategoryTest  extends Base{
	
	LoginPage loginpage;
	HomePage homepage;
	SubCategoryPage subcategorypage;
	
	@Test
	public void verify_UserAbleToAddNewSubCategory()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnSubCategory();
	    
	    subcategorypage=new SubCategoryPage(driver);
	    subcategorypage.addSubCategoryDetails("Toys","Soft Toys");
	    
	    boolean greenAlertBoxDisplaystatus=subcategorypage.isGreenAlertboxDispalyed();
	     Assert.assertTrue(greenAlertBoxDisplaystatus);
	}
	
	@Test(priority=1)
	public void verify_userAbleToSearchSubcategory()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
	
		homepage=new HomePage(driver);
    	homepage.clickOnSubCategory();
    
    	subcategorypage=new SubCategoryPage(driver);
    	subcategorypage.searchSubCategory("Toys","Soft Toys");
    	
    	boolean actual=subcategorypage.SearchedSubCategoryAvailability();	
	    Assert.assertTrue(actual);	
	}
	
	@Test(priority=2)
	public void verifyUserAbleToDeleteASubCategory()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
	
		homepage=new HomePage(driver);
    	homepage.clickOnSubCategory();
    
    	subcategorypage=new SubCategoryPage(driver);
    	subcategorypage.searchSubCategory("Toys","Soft Toys");
    	subcategorypage.deleteSubCategory();
	}
}
