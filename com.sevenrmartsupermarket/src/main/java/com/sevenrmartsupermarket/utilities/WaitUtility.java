package com.sevenrmartsupermarket.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriver driver;
	WebDriverWait wait;
	
	public WaitUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForClickable(WebElement element,long time) 
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForVisibility(WebElement element,long time)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("element")));
	}
	
	public void waitForElementLocated(WebElement element,long time)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("element")));
	}
	
}
