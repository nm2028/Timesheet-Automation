package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import baseClass.PageBaseClasses;

public class LoginPage extends PageBaseClasses {
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "user-name")
	public WebElement Name;

	@FindBy(className = "job-title")
	public WebElement job;

	@FindBy(linkText = "All Apps & Tools")
	public WebElement Tools;

	@FindBy(id = "i0116")
	public WebElement userId;

	@FindBy(id = "idSIButton9")
	public WebElement button1;

	@FindBy(id = "idBtn_Back")
	public WebElement button2;

//	user login
	public void userLogin(String userID) {
		userId.sendKeys(userID);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		button1.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		button2.click();
	}

//  print user name
	public void printUserProfile() throws Exception {
		try {

			System.out.println(Name.getText());
			System.out.println(job.getText());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			takeScreenshot("UserProfile");
			
		} catch (Exception e) {
			takeScreenshot("UserProfileFailed");
		}
	}

//	clicking Apps&Tools
	public NavigatePage navigatePage() {
		Tools.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, NavigatePage.class);
	}

}
