package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class ManageContactPage {
	
	WebDriver driver;
	PageUtility pageutility=new PageUtility(driver);
	GeneralUtility generaluser=new GeneralUtility();
	WaitUtility waitutility=new WaitUtility(driver);
	
	@FindBy(xpath = "//table//tbody//td[6]//a")
	private WebElement editButton;
	
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phonenumber;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Delivery Time']")
	private WebElement deliveryTime;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement updateButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement greenAlertBox;
	
	public ManageContactPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickTheEditButton()
	{
		 editButton.click();
	}
	
	public void enterThePhoneNumber(String phone)
	{
		phonenumber.clear();
 		phonenumber.sendKeys(phone);
	}
	
	public void enterTheDeliveryTime(String del_Time)
	{
		deliveryTime.clear();
		deliveryTime.sendKeys(del_Time);
	}
	
	public void clickUpdateButton()
	{
		pageutility.mouseClick(driver, updateButton);	
	}
	
	public boolean isSuccessAlertDisplayed()
 	{
 		return greenAlertBox.isDisplayed();
 	}
	
	public void editContactUsInformation(String phone,String delivery_Time)
	{
		clickTheEditButton();
		enterThePhoneNumber(phone);
		enterTheDeliveryTime(delivery_Time);
		clickUpdateButton();
	}
}
