package com.sevenrmartsupermarket.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.CategoryPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class CategoryTest extends Base{
	
	LoginPage loginpage;
	HomePage homepage;
	CategoryPage categorypage;
	SoftAssert softassert=new SoftAssert();
	
	@Test(priority=1,groups={"smoke","regression"})
	public void verify_New__Buttons_AddCategoryFunctionality()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnCategory();
	    
	    categorypage=new CategoryPage(driver);
	    categorypage.clickOnNewButton();
	    String category="BeautyProducts";
	    categorypage.addCategoryDetails(category);
	    
	    String actualAlert= categorypage.getSavebuttonAlertMessage();
	    String expectedAlert="Alert!";
	    softassert.assertEquals(actualAlert,expectedAlert);
	    
	    categorypage.clickOnHomePage_Navigation();
	    homepage.clickOnCategory();
	    categorypage.clickOnSearchButton();
	    categorypage.searchCategories(category);	
	}
	
	@Test(priority=2)
	public void verify_New_Buttons_Add_DuplicateCategory()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnCategory();
	    
	    categorypage=new CategoryPage(driver);
	    categorypage.clickOnNewButton();
	    categorypage.addDuplicateCategoryInformations("BeautyProducts");
	    
	   String actualAlert= categorypage.getDuplicationAlertMessage();
	   String expectedAlert="Alert!";
	   Assert.assertEquals(actualAlert,expectedAlert);
	}
	
	@Test(priority=3)
	public void verify_Search_ButtonsFunctionality()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnCategory();
	    
	    categorypage=new CategoryPage(driver);
	    categorypage.clickOnSearchButton(); 
	    categorypage.searchCategories("BeautyProducts");	
	    
	    boolean actual=categorypage.SearchedCategoryAvailability();	
	    Assert.assertTrue(actual);
	}
	
	@Test(priority=4)
	public void verify__Delete_ButtonsFunctionality()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnCategory();
	    
	    categorypage=new CategoryPage(driver);
	    categorypage.clickOnSearchButton();
	    String categoryToDelete="BeautyProducts";
	    categorypage.searchCategories(categoryToDelete);	
	   
	    String actualAlert=categorypage.deleteCategory();
	    String expectedAlert="Do you want to delete this Category?";
	    softassert.assertEquals(actualAlert, expectedAlert);
	    
	    categorypage.clickOnSearchButton();
	    categorypage.searchCategories(categoryToDelete);	
	    
	}
}
