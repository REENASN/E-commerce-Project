package com.sevenrmartsupermarket.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.dataProviders.AdminUserDataProvider;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ScreenShotCapture;
import com.sevenrmartsupermarket.dataProviders.AdminUserDataProvider;

public class AdminUsersTest extends Base {
	HomePage homepage;
	LoginPage loginpage;
	AdminUsersPage adminuserpage;
	
	
	@Test(priority=-1)
	public void verify_Buttons_AdminUsersPage()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnAdminUsers();
	    
	    adminuserpage=new AdminUsersPage(driver);
	    
	    boolean newButtonStatus= adminuserpage.getNewButtonStatus();
	    Assert.assertTrue(newButtonStatus);
	    
	    boolean searchButtonStatus= adminuserpage.getSearchButtonStatus();
	    Assert.assertTrue(searchButtonStatus);
	    
	    boolean ResetButtonStatus= adminuserpage.getResetButtonStatus();
	    Assert.assertTrue(ResetButtonStatus);
	}
	
	/*@Test(priority=1)
	public void verify_AddNewUser()
	{
		loginpage=new LoginPage(driver);
	    homepage=new HomePage(driver);
	    adminuserpage=new AdminUsersPage(driver);
	    loginpage.logIn();
	    homepage.clickOnAdminUsers();
	    adminuserpage.clickOnNewButton();
	    adminuserpage.addNewUser("SAARA DAVIS","SA123","Admin");
	    String actual_SuccessText=adminuserpage.getSaveButtonText();
	    String expected_SuccessText="Alert!";
	    Assert.assertEquals(actual_SuccessText, expected_SuccessText);  
	    
	    adminuserpage.clickOnSearchButton();
	    List<WebElement> Tabledatas=adminuserpage.searchForValidUser("SAARA DAVIS","Admin");
		System.out.println("Table Datas::");
		for(WebElement x:Tabledatas)
		{
			System.out.println(x.getText());
		}
		System.out.println("New User Added Successfully");
	}*/
	
	@Test(dataProvider ="userdatas",dataProviderClass =AdminUserDataProvider.class)
	public void verify_AddNewUser(String userName,String password,String userType)
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnAdminUsers();
	    
	    adminuserpage=new AdminUsersPage(driver);
	    adminuserpage.clickOnNewButton();
	    adminuserpage.addNewUser(userName,password,userType);
	    
	    String actual_SuccessText=adminuserpage.getSaveButtonText();
	    String expected_SuccessText="Alert!";
	    Assert.assertEquals(actual_SuccessText, expected_SuccessText);  
	    
	    adminuserpage.clickOnSearchButton();
	    List<WebElement> Tabledatas=adminuserpage.searchForValidUser("SAARA DAVIS","Admin");
		System.out.println("Table Datas::");
		for(WebElement x:Tabledatas)
		{
			System.out.println(x.getText());
		}
		System.out.println("New User Added Successfully");
	}
	
	@Test(priority=2)
	public void verify_AddDuplicateUser()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnAdminUsers();
	    
	    adminuserpage=new AdminUsersPage(driver);
	    adminuserpage.clickOnNewButton();
	    adminuserpage.addNewDuplicateUser("SAARA DAVIS","P123","Admin"); 
	    
	    String actual_AlertMessage= adminuserpage.getDuplicationMessage();
	    String expected_AlertMessage="Alert!";
	    Assert.assertEquals(actual_AlertMessage, expected_AlertMessage);
	    System.out.println("***User already exist***");
	}
	
	@Test(priority=3)
	public void verify_SearchButtonFunctionalityForValidUser()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnAdminUsers();
	    
	    adminuserpage=new AdminUsersPage(driver);
	    adminuserpage.clickOnSearchButton();
	    
	    List<WebElement> Tabledatas=adminuserpage.searchForValidUser("SAARA DAVIS","Admin");
		System.out.println("Table Datas::");
		for(WebElement x:Tabledatas)
		{
			System.out.println(x.getText());
		}
	}
	
	@Test(priority=4)
	public void verify_verify_SearchButtonFunctionalityForInValidUser()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		 
	    homepage=new HomePage(driver);
	    homepage.clickOnAdminUsers();
	    
	    adminuserpage=new AdminUsersPage(driver);
	    adminuserpage.clickOnSearchButton();
	    
	    String actualData=adminuserpage.searchOption_InvalidData("asdfSSaira","admin");
	    String expectedData=".........RESULT NOT FOUND.......";
	    Assert.assertEquals(actualData, expectedData);
	    System.out.println("User not found");
	}
	
	@Test(priority=9)
	public void verify_DeleteButtonFunctionality()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		 
	    homepage=new HomePage(driver);
	    homepage.clickOnAdminUsers();
	    
	    adminuserpage=new AdminUsersPage(driver);
	    adminuserpage.clickOnSearchButton();
	    adminuserpage.searchForValidUser("SAARA DAVIS","Admin");
	    
	    String firstRowUserName=adminuserpage.getFirstRowData();
	    String actualData=adminuserpage.deleteButton(); 
	    String expectedData="Do you want to delete this User?";
	    Assert.assertEquals(actualData, expectedData);
	    
	    adminuserpage.clickOnSearchButton();
	    
	    String actualData1=adminuserpage.searchOption_InvalidData(firstRowUserName,"Admin");
	    String expectedData1=".........RESULT NOT FOUND.......";
	    Assert.assertEquals(actualData1, expectedData1);
	    System.out.println("Username not found,Delete function Successfull");
	}
	
	@Test(priority=5)
	public void verify_UserStatusChangeButtonFunctionality()
	{
		loginpage=new LoginPage(driver);
		 loginpage.logIn();
		 
	    homepage=new HomePage(driver);
	    homepage.clickOnAdminUsers();
	    
	    adminuserpage=new AdminUsersPage(driver);
	    adminuserpage.clickOnSearchButton();
	    adminuserpage.searchForValidUser("SAARA DAVIS","Admin");
	    
	    String status=adminuserpage.getStatusOfFirstRowUser();
	    System.out.println("Before making Changes, User Status::"+status);
	    
	    String actualData=adminuserpage.userStatusChange();
	    String expectedData="Alert!";
	    Assert.assertEquals(actualData, expectedData);
	    String newStatus=adminuserpage.getStatusOfFirstRowUser();
	    System.out.println("After making Changes, User Status::"+newStatus);
	    
	}
	
	@Test(priority=6)
	public void verify_PasswordButtonShowsDetails()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnAdminUsers();
	    
	    adminuserpage=new AdminUsersPage(driver);
	    adminuserpage.clickOnSearchButton();
	    adminuserpage.searchForValidUser("SAARA DAVIS","Admin");
	    
	    boolean passwordStatus=adminuserpage.getPassWordOfaUser();
	    Assert.assertTrue(passwordStatus);
	    System.out.println("Password is displayed");
	}
	
	@Test(priority=7)
	public void verify_EditButtonFunctinality()
	{
		loginpage=new LoginPage(driver);
		loginpage.logIn();
		
	    homepage=new HomePage(driver);
	    homepage.clickOnAdminUsers();
	    
	    adminuserpage=new AdminUsersPage(driver);
	    adminuserpage.clickOnSearchButton();
	    adminuserpage.searchForValidUser("gayu","admin");
	    adminuserpage.editAUserDetails();
	    
	   // Assert.assertTrue(true);
	    System.out.println("Data Edited successfully");
	}
	
}
