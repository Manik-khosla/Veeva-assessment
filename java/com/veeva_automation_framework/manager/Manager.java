package com.veeva_automation_framework.manager;

public class Manager {

	private  DriverManager dm;

	private  PageObjectManager pm;

	public  DriverManager getDriverManager(String browserName, int timeout) {

		if(this.dm == null) {
		dm = new DriverManager(browserName,timeout);
			return dm;
		}else {
			return dm;
		}
	}

	public  PageObjectManager getPageObjectManager() {

		if(pm == null) {
			pm = new PageObjectManager(dm.getDriver());
			return pm;
		}else {
			return pm;
		}
	}
	
	public void clear() {
		dm = null;
		pm = null;
	}

}
