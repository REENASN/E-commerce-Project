package com.sevenrmartsupermarket.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.CategoryPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class CategoryTest extends Base{
	
	LoginPage loginpage;
	HomePage homepage;
	CategoryPage categorypage;
	
	@Test(priority=1,groups={"smoke","regression"})
	public void verify_Buttons_New_AddCategoryFunctionality()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnCategory();
	    
	    categorypage=new CategoryPage(driver);
	    categorypage.clickOnNewButton();
	    categorypage.addCategoryInformations("Choclates");
	    
	    String actualAlert= categorypage.getSavebuttonAlertMessage();
	    String expectedAlert="Alert!";
	    Assert.assertEquals(actualAlert,expectedAlert);
	   
	    categorypage.clickOnHomeNavigation();
	    homepage.clickOnCategory();
	    categorypage.clickOnSearchButton();
	    List<WebElement> Tabledatas=categorypage.searchForCategories("Choclates");
		System.out.println("Table Datas::");
		for(WebElement x:Tabledatas)
		{
			System.out.println(x.getText());
		}
		System.out.println("***category added Successfully***");
	}
	
	@Test(priority=2)
	public void verify_Buttons_New_Add_DuplicateCategory()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnCategory();
	    
	    categorypage=new CategoryPage(driver);
	    categorypage.clickOnNewButton();
	    categorypage.addDuplicateCategoryInformations("Choclates");
	    
	   String actualAlert= categorypage.getDuplicationAlertMessage();
	   String expectedAlert="Alert!";
	   Assert.assertEquals(actualAlert,expectedAlert);
	   
	   System.out.println("***This category already Exist***");
	}
	
	@Test(priority=3)
	public void verify_Buttons_SearchFunctionality()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnCategory();
	    
	    categorypage=new CategoryPage(driver);
	    categorypage.clickOnSearchButton();
	    
	    List<WebElement> Tabledatas=categorypage.searchForCategories("Choclates");
		System.out.println("Table Datas::");
		for(WebElement x:Tabledatas)
		{
			System.out.println(x.getText());
		}
	    
	}
	
	@Test(priority=4)
	public void verify__DeleteButtonsFunctionality()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnCategory();
	    
	    categorypage=new CategoryPage(driver);
	    categorypage.clickOnSearchButton();
	    
	    List<WebElement> Tabledatas=categorypage.searchForCategories("Choclates");
		System.out.println("Table Datas::");
		for(WebElement x:Tabledatas)
		{
			System.out.println(x.getText());
		}
		
	    String actualAlert=categorypage.deleteCategory();
	    String expectedAlert="Do you want to delete this Category?";
	    Assert.assertEquals(actualAlert, actualAlert);
	    System.out.println("***Category deleted successfully***");
	    
	}
}
