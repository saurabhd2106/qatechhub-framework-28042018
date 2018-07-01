package com.mercuryTravel;

import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.implementation.TakeScreenshot;
import commonLibs.utils.DateUtils;
import commonLibs.utils.ReadConfigFileUtils;

public class ReportScenario {

	public Properties configProperty;

	public ExtentHtmlReporter reportHtml;
	public ExtentTest logger;
	public ExtentReports report;

	public String currentProjectDirectory;

	private String configFileName;
	protected TakeScreenshot camera;

	public static String testExecutionStartTime;

	@BeforeSuite
	public void initialization() throws Exception {
		currentProjectDirectory = System.getProperty("user.dir");
		testExecutionStartTime = DateUtils.getDate();

		configFileName = currentProjectDirectory + "/config/config.properties";
		configProperty = ReadConfigFileUtils.readProperties(configFileName);

		String reportFileName = currentProjectDirectory + "/reports/" + configProperty.getProperty("reportFileName");

		reportHtml = new ExtentHtmlReporter(reportFileName + testExecutionStartTime + ".html");

		report = new ExtentReports();
		report.attachReporter(reportHtml);

		
	}
	
	@AfterSuite
	public void flushUp() throws Exception{
		report.flush();
	}

}
