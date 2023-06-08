package stepDefinitions;

import baseClass.PageBaseClasses;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClasses.LoginPage;
import pageClasses.NavigatePage;
import pageClasses.TimeSheetPage;
import utilities.ReadConfig;

public class MainClass extends PageBaseClasses {
	ReadConfig readconfig;
	LoginPage loginPage;
	NavigatePage navigatePage;
	TimeSheetPage timeSheetPage;

	public MainClass() {
		this.readconfig = new ReadConfig();
	}

	PageBaseClasses pageBase = new PageBaseClasses();

	@Before
	public void start() {
		pageBase.invokeBrowsers(readconfig.getBrowser());
	}

	@After
	public void after() {
		timeSheetPage.closeBrowser();
	}

	@Given("^user is on login page$")
	public void user_is_on_login_page() {
		loginPage = pageBase.openApplication(readconfig.getApplicationURL());
	}

	@When("^user enters emailId and clicks on next button$")
	public void user_enters_email_id() {
		loginPage.userLogin(readconfig.getUserId());
	}

	@Then("^user is navigated to the home page and userName and job role is printed$")
	public void user_is_navigated_to_the_home_page() throws Exception {
		loginPage.printUserProfile();
	}

	@When("^user clicks on All Apps & tools then user is navigated to Apps and Tools Directory$")
	public void user_clicks_on_all_apps_tools() {
		navigatePage = loginPage.navigatePage();
	}

	@When("^user enters Timesheet and press enter and clicks ESA timesheet$")
	public void user_enters_timesheet_and_press_enter_and_clicks_esa_timesheet() throws Exception {
		navigatePage.navigate(readconfig.getSearch());

	}

	@Then("^window is switched$")
	public void window_is_switched() throws Exception {
		navigatePage.switchWindows();
	}

	@Then("^Timesheet is clicked$")
	public void timesheet_is_clicked() {
		timeSheetPage = navigatePage.clickTimeSheet();
	}

	@Given("^user is on Timesheet Page$")
	public void user_is_on_timesheet_page() throws Exception {
		timeSheetPage.timesheet();
	}

	@When("^The first three week dates are checked with the calculated expected dates$")
	public void the_first_three_week_dates_are_checked_with_the_calculated_expected_dates() throws Exception {
		timeSheetPage.checkDates();
	}

	@When("^Store the actual and expected dates in the excel file$")
	public void store_the_actual_and_expected_dates_in_the_excel_file() throws Exception {
		timeSheetPage.excelOutput();
	}

}
