package testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseClass.PageBaseClasses;
import pageClasses.NavigatePage;
import pageClasses.TimeSheetPage;
import pageClasses.LoginPage;
import utilities.ReadConfig;

public class TestClass extends PageBaseClasses {

	ReadConfig readconfig;
	LoginPage loginPage;
	NavigatePage navigatePage;
	TimeSheetPage timeSheetPage;

	public TestClass() {
		this.readconfig = new ReadConfig();
	}

	PageBaseClasses pageBase = new PageBaseClasses();

	@BeforeTest
	public void test() {
		pageBase.invokeBrowsers(readconfig.getBrowser());
		loginPage = pageBase.openApplication(readconfig.getApplicationURL());
	}

	@Test(priority = 1)
	public void UserLognTest() throws Exception {
		loginPage.userLogin(readconfig.getUserId());
		loginPage.printUserProfile();
		navigatePage = loginPage.navigatePage();
	}

	@Test(priority = 2)
	public void NavigateTest() throws Exception {
		navigatePage.navigate(readconfig.getSearch());
		navigatePage.switchWindows();
		timeSheetPage=navigatePage.clickTimeSheet();
	}

	@Test(priority=3)
	public void TimeSheetTest() throws Exception {
		timeSheetPage.timesheet();
		timeSheetPage.checkDates();
		timeSheetPage.excelOutput();
	}

	@AfterTest
	public void closeBrowser() {
		timeSheetPage.closeBrowser();

	}
}
