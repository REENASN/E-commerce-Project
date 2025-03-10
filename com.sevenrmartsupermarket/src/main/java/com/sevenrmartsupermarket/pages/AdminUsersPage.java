package com.sevenrmartsupermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUsersPage 
{
	WebDriver driver;
	PageUtility pageutility=new PageUtility(driver);
	GeneralUtility generaluser=new GeneralUtility();
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement btn_New;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement btn_Search;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement btn_Reset;
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement input_Username;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement input_password;
	
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement select_Usertype;
	
	@FindBy(xpath = "//div[@class='card-footer center']//button[@type='submit']")
	private WebElement btn_Save;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5[contains(text(),'Alert!')]")
	private WebElement btn_Save_Success_Message;
	
	@FindBy(xpath = "//table//tbody//tr//td[1]")
	private WebElement table_Firstrow_UserName;
	
	@FindBy(xpath = "//div[@class='col-sm-6 form-group']//input")
	private WebElement input_Search_Username;
	
	@FindBy(xpath = "//div[@class='col-sm-6 form-group']//select[@class='form-control']")
	private WebElement input_Search_Usertype;
	
	@FindBy(xpath = "//div[@class='card-body']//button[@name='Search']")
	private WebElement btn_Search_Search;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']//h5[text()=' Alert!']")
	private WebElement alert_UnSuccessful;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr")
	private List<WebElement> table_Data_Searched;
	
	@FindBy(xpath = "//span[@id='res']//center[contains(text(),'.........RESULT NOT FOUND.......')]")
	private WebElement not_Found_Search_Data;
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[5]//a[3]")
	private WebElement btn_DeleteForFirstRow;
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[3]")
	private WebElement btn_status_FirstRowUser;
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[5]//a[1]")
	private WebElement btn_Change_Status;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5[text()=' Alert!']")
	private WebElement alert_Change_Status;
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[4]")
	private WebElement btn_Password_showDetails;
	
	@FindBy(xpath = "//table//tbody//tr[2]//span")
	private WebElement display_Password_Details;
	
	@FindBy(xpath = "//table//tbody//tr//td[5]//a[2]")
	private WebElement btn_Edit;
	
	public AdminUsersPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getNewButtonStatus()
	{
		System.out.println("Button Name:::"+btn_New.getText());
		return btn_New.isDisplayed();
	}

	public boolean getSearchButtonStatus()
	{
		System.out.println("Button Name:::"+btn_Search.getText());
		return btn_Search.isDisplayed();
	}
	
	public boolean getResetButtonStatus()
	{
		System.out.println("Button Name:::"+btn_Reset.getText());
		return btn_Reset.isDisplayed();
	}
	
	public void clickOnNewButton()
	{
		btn_New.click();
	}
	
	public void enterUserName(String userName) {
		input_Username.sendKeys(userName);
	}

	public void enterPassword(String password) {
		input_password.sendKeys(password);
	}

	public void enterUserType(String userType) {
		select_Usertype.sendKeys(userType);
	}
	
	public void clickOnSaveButton() {
		btn_Save.click();
	}
	
	public String getSaveButtonText()
	{
		return btn_Save_Success_Message.getText();
	}
	
	public String getDuplicationMessage()
	{
		return alert_UnSuccessful.getText();
	}
	
	public void enterUserNameForSearchFunction(String userName) 
	{
		input_Search_Username.sendKeys(userName);
	}
	public void clickOnSearchButton()
	{
		btn_Search.click();
	}
	
	public void enterUserTypeForSearchFunction(String userType) {
		input_Search_Usertype.sendKeys(userType);
	}
	
	public List<WebElement> clickOnSearchButtonForSearchFunction()
	{
		btn_Search_Search.click();
		return table_Data_Searched;		
	}
	
	public String getFirstRowData()
	{
		return table_Firstrow_UserName.getText();
	}
	
	public String getStatusOfFirstRowUser()
	{
		return btn_status_FirstRowUser.getText();
	}
	
	public void clickOnDownwardArrow()
	{
		btn_Password_showDetails.click();
	}
	
	public void clickonEditButton()
	{
		btn_Edit.click();
	}
	public void addNewUser(String userName, String password,String userType)
	{
		enterUserName(userName);
		enterPassword(password);
		enterUserType(userType);
		clickOnSaveButton();
			
		//generaluser.getRandomName();
		//System.out.println(generaluser.getRandomName());
	}
	
	public void addNewDuplicateUser(String userName, String password,String userType)
	{
		enterUserName(userName);
		enterPassword(password);
		enterUserType(userType);
		clickOnSaveButton();
	}
	
	public List<WebElement> searchForValidUser(String userName,String userType)
	{
		enterUserNameForSearchFunction(userName);
		enterUserTypeForSearchFunction(userType);
		 List<WebElement> Tabledatas=clickOnSearchButtonForSearchFunction();	
		 return Tabledatas;
	}
	
	public String searchOption_InvalidData(String userName,String userType)
	{
		enterUserNameForSearchFunction(userName);
		enterUserTypeForSearchFunction(userType);
		clickOnSearchButtonForSearchFunction();
		return not_Found_Search_Data.getText();
	}
	
	public String deleteButton()
	{
		return pageutility.switchToAlertAndGetText(driver,btn_DeleteForFirstRow);
	}
	
	public String userStatusChange()
	{
		pageutility.doubleClick(driver,btn_Change_Status);
		return alert_Change_Status.getText();
	}
	
	public boolean getPassWordOfaUser()
	{
		clickOnDownwardArrow();
		return display_Password_Details.isDisplayed();
	}
	
	public void editAUserDetails()
	{
		clickonEditButton();
		enterUserName("HelenSimon");
	}
}
