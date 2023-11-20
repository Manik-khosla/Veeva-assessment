package com.veeva_automation_framework.ProductURL;

public enum ProductURLMap {
	
	CoreProduct("https://www.nba.com/warriors"),
	DerivedProduct1("https://www.nba.com/sixers/"),
    DerivedProduct2("https://www.nba.com/bulls/");

	private String url;
	
	ProductURLMap(String url) {
		this.url = url;
	}
	
	
	public String geturl() {
		return url;
	}

}
