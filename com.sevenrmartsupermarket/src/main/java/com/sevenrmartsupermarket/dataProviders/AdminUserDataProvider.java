package com.sevenrmartsupermarket.dataProviders;

import org.testng.annotations.DataProvider;

public class AdminUserDataProvider {
	
	@DataProvider(name="userdatas")
	public Object[][] newuser()
	{
		return new Object [][] {{"SAARA DAVIS","SA123","Admin"}
								
								};
								
	}
	}
