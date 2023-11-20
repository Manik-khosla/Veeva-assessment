package com.veeva_automation_framework.testRunner;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.veeva_automation_framework.configurations.AppConfig;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = "json:target/jsonReports/CucumberTestReport.json"		
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	
	@BeforeSuite
	@Parameters({"filename"})
	public static void readAppConfiguration(String filename) {
		AppConfig.ReadAppConfig(filename);
	}
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
