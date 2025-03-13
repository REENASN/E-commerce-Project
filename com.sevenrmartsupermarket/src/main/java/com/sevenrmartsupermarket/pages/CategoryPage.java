package com.sevenrmartsupermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class CategoryPage {
	
	WebDriver driver;
	PageUtility pageutility=new PageUtility(driver);
	GeneralUtility generaluser=new GeneralUtility();
	WaitUtility waitutility=new WaitUtility(driver);
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement btn_New;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement btn_Search;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
	private WebElement btn_Reset;
	@FindBy(xpath="//input[@id='category']")
	private WebElement input_Category;
	@FindBy(xpath="//input[@id='main_img']")
	private WebElement choose_ImageFile;
	
	@FindBy(xpath="//input[@name='top_menu'][@value='yes']")
	private WebElement radiobutton_TopMenu_Yes;
	
	@FindBy(xpath="//input[@name='top_menu'][@value='no']")
	private WebElement radiobutton_TopMenu_No;
	
	@FindBy(xpath="//input[@name='show_home'][@value='yes']")
	private WebElement radiobutton_LeftMenu_Yes;
	
	@FindBy(xpath="//input[@name='show_home'][@value='no']")
	private WebElement radiobutton_LeftMenu_No;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement button_Save;
	
	@FindBy(xpath="//li[@id='134-selectable']//span")
	private WebElement selectGroup_Discount;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//h5[text()=' Alert!']")
	private WebElement text_SaveAlert;
	
	@FindBy(xpath="//input[@class='form-control'][@placeholder='Category']")
	private WebElement input_Search_Category;

	@FindBy(xpath="//div[@class='card-body']//button[@type='submit']")
	private WebElement button_Search_Submit;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr")
	private List<WebElement> table_Data_Searched;
	
	@FindBy(xpath="//table//tbody//tr//td[1]")
	private WebElement searchedData;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']//h5")
	private WebElement alert_AlreadyExist;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/home'][text()='Home']")
	private WebElement navigate_back_Home;
	
	@FindBy(xpath="//table//tbody//tr[1]//td[4]//a[2]")
	private WebElement button_Delete;
	
	@FindBy(xpath="//table//tbody//tr[1]")
	private WebElement data_First_Row;
	
	
	
	public CategoryPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnNewButton()
	{
		btn_New.click();
	}
	
	public void enterCategoryName(String category)
	{
		input_Category.sendKeys(category);
	}
	
	public void selectGroups()
	{
		pageutility.doubleClick(driver, selectGroup_Discount);
	}
	public void chooseImageFile()
	{
		pageutility=new PageUtility(driver);
		pageutility.uploadImage(choose_ImageFile, "BeautyProducts");	
	}
	
	public void select_RadioButton_ShowOnTopMenu()
	{
		pageutility.mouseClick(driver,radiobutton_TopMenu_No);
	}
	
	public void select_RadioButton_ShowOnLeftMenu()
	{
		pageutility.mouseClick(driver,radiobutton_LeftMenu_No);
	}
	
	public void clickOnSaveButton()
	{
		waitutility=new WaitUtility(driver);
		waitutility.waitForClickable(button_Save,30);
		pageutility.mouseClick(driver,button_Save);
	}
	
	public String getSavebuttonAlertMessage()
	{
		return text_SaveAlert.getText();
	}
	
	public String getDuplicationAlertMessage()
	{
		System.out.println("***This category already Exist***");
		return alert_AlreadyExist.getText();
	}
	public void clickOnSearchButton()
	{
		waitutility=new WaitUtility(driver);
		waitutility.waitForClickable(btn_Search,30);
		btn_Search.click();
	}
	
	public void enterSearchCategory(String categoryname)
	{
		input_Search_Category.sendKeys(categoryname);
	}
	
	public void clickOnSubmitSearchButton()
	{
		pageutility.mouseClick(driver, button_Search_Submit);
	}
	
	public boolean SearchedCategoryAvailability()
	{
		return searchedData.isDisplayed(); 
	}
	
	public void clickOnHomePage_Navigation()
	{
		navigate_back_Home.click();
	}
	
	public void addCategoryDetails(String category)
	{
		enterCategoryName(category);
		selectGroups();
		chooseImageFile();
		select_RadioButton_ShowOnTopMenu();
		select_RadioButton_ShowOnLeftMenu();
		clickOnSaveButton();	
	}
	public void addDuplicateCategoryInformations(String category)
	{
		enterCategoryName(category);
		selectGroups();
		chooseImageFile();
		select_RadioButton_ShowOnTopMenu();
		select_RadioButton_ShowOnLeftMenu();
		clickOnSaveButton();
	}
	
	public void searchCategories(String category)
	{
		enterSearchCategory(category);
	    clickOnSubmitSearchButton();
	}
	
	public String deleteCategory()
	{
		return pageutility.switchToAlertAndGetText(driver, button_Delete);
	}
}
