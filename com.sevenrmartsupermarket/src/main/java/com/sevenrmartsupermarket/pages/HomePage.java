package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='user-panel mt-3 pb-3 mb-3 d-flex']//a")
	private WebElement profileName_Element;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Admin Users']//following::a[1]")
	private WebElement adminUsers_Element;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Category']//following::a[1]")
	private WebElement category_Element;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Sub Category']//following::a[1]")
	private WebElement subCategory_Element;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Manage Contact']//following::a[1]")
	private WebElement manageContact_Element;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Manage Product']//following::a[1]")
	private WebElement manageProduct_Element;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Manage News']//following::a[1]")
	private WebElement manageNews_Element;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Manage Footer Text']//following::a[1]")
	private WebElement manageFooterText_Element;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Manage Category']//following::a[1]")
	private WebElement manageCategory_Element;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}
	
	public String getProfileName()
	{
		return profileName_Element.getText();
	}
	
	public void clickOnAdminUsers()
	{
		adminUsers_Element.click();
	}
	
	public void clickOnCategory()
	{
		category_Element.click();
	}
	
	
}
