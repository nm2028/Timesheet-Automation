package pageClasses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import baseClass.PageBaseClasses;

public class NavigatePage extends PageBaseClasses {
	public NavigatePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "[id*='genericSearch']")
	public WebElement search;
	@FindBy(xpath = "/html/body/div/app-root/main/div/unily-spa/dynamic-content-viewer/section/upgrade-component-wrapper/div/div/div/div/div[2]/generic-search/div/generic-search-results/item-template[2]/div/div/a/span[2]")
	public WebElement esatimesheet;
	@FindBy(xpath = "//*[@id=\'win0groupletPTNUI_LAND_REC_GROUPLET$0\']")
	public WebElement Timesheet;

	public void navigate(String searchItem) {

//		Searching Timesheet
		search.sendKeys(searchItem);
		search.sendKeys(Keys.ENTER);

//		Clicked "ESA Timesheet"
		esatimesheet.click();
	}
	public void switchWindows() throws Exception {
		
//		Handling multiple Windows
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();

		String mainPageId = itr.next();
		String timeSheetPageId = itr.next();

// 		Switching to Timesheet Tab
		try {
			driver.switchTo().window(timeSheetPageId);
			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println(e);
			takeScreenshot("SwitchTabFailed");
		}
	}

	public TimeSheetPage clickTimeSheet() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Timesheet.click();
		return PageFactory.initElements(driver, TimeSheetPage.class);
	}
}
