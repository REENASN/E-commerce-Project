package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class SubCategoryPage
{
	WebDriver driver;
	PageUtility pageutility=new PageUtility(driver);
	GeneralUtility generaluser=new GeneralUtility();
	WaitUtility waitutility=new WaitUtility(driver);
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")
 	private WebElement newbutton;
	@FindBy(xpath = "//select[@id='cat_id']")
 	private WebElement categoryDropDown;
 	@FindBy(xpath = "//input[@id='subcategory']")
 	private WebElement sub_Category;
 	@FindBy(xpath = "//input[@id='main_img']")
 	private WebElement image_Upload;
 	@FindBy(xpath = "//button[@name='create']")
 	private WebElement saveButton;
 	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
 	private WebElement green_Alertbox;
 	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
 	private WebElement searchButton;
 	@FindBy(xpath = "//select[@class='form-control selectpicker']")
 	private WebElement searchCategoryDropdown;
 	@FindBy(xpath = "//input[@placeholder='Sub Category']")
 	private WebElement searchSubCategory;
 	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
 	private WebElement searchButtonRed;
 	@FindBy(xpath = "//table//tbody//tr[1]//td[1]")
 	private WebElement SearchedData;
 	@FindBy(xpath = "//table//tbody//tr//td[5]//a[2]")
 	private WebElement deteteButton;
 	
 
	public SubCategoryPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickTheNew_Button()
	{
		newbutton.click();
	}
	
	public void selectCategory_Dropdown(WebElement dropdown ,String category)
	{
		pageutility.selectByVisibleText(dropdown, category);
	}
	
	public void enterSubCategory(WebElement subcategoryElement,String subcategory)
	{
		subcategoryElement.sendKeys(subcategory);
	}
	
	public void uploadTheImage()
	{
		pageutility.uploadImage(image_Upload,"softToys");
	}
	
	public void clickTheSaveButton()
	{
		saveButton.click();
	}
	
	public boolean isGreenAlertboxDispalyed()
	{
		return green_Alertbox.isDisplayed();
	}
	
	public void clickSearchButton(WebElement searchButtonElement)
	{
		pageutility.mouseClick(driver, searchButtonElement);
	}
	
	public boolean SearchedSubCategoryAvailability()
	{
		return SearchedData.isDisplayed();
	}
	public void addSubCategoryDetails(String category,String subcategory)
	{
		 clickTheNew_Button();
		 selectCategory_Dropdown(categoryDropDown,category);
		 enterSubCategory(sub_Category,subcategory);
		 uploadTheImage();
		 clickTheSaveButton();
	}
	
	public void searchSubCategory(String category,String subcategory)
	{
		clickSearchButton(searchButton);
		selectCategory_Dropdown(searchCategoryDropdown,category);
		enterSubCategory(searchSubCategory,subcategory);
		clickSearchButton(searchButtonRed);
	}
	
	public void deleteSubCategory()
	{
		pageutility.switchToAlert(driver,deteteButton);
	}
	
}
