package com.veeva_automation_framework.manager;

public class Manager {

	private  DriverManager dm;


	public  DriverManager getDriverManager(String browserName, int timeout) {

		if(this.dm == null) {
		dm = new DriverManager(browserName,timeout);
			return dm;
		}else {
			return dm;
		}
	}
	
	public void clear() {
		dm = null;
	}

}
