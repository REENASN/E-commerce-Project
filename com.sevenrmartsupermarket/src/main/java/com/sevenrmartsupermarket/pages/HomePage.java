package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='user-panel mt-3 pb-3 mb-3 d-flex']//a")
	private WebElement profileName;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Admin Users']//following::a[1]")
	private WebElement adminUsers;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Category']//following::a[1]")
	private WebElement category;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Sub Category']//following::a[1]")
	private WebElement subCategory;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Manage Contact']//following::a[1]")
	private WebElement manageContact;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Manage Product']//following::a[1]")
	private WebElement manageProduct;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Manage News']//following::a[1]")
	private WebElement manageNews;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Manage Footer Text']//following::a[1]")
	private WebElement manageFooterText;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Manage Category']//following::a[1]")
	private WebElement manageCategory;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}
	
	public String getProfileName()
	{
		return profileName.getText();
	}
	
	public void clickOnAdminUsers()
	{
		adminUsers.click();
	}
	
	public void clickOnCategory()
	{
		category.click();
	}
	
	public void clickOnSubCategory()
	{
		subCategory.click();
	}
	public void clickOnManageContact()
	{
		manageContact.click();
	}
}
