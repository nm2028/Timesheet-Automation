package baseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.PageFactory;

import pageClasses.LoginPage;
import utilities.DateUtils;

public class PageBaseClasses {

	public WebDriver driver;

	public void invokeBrowsers(String browserName) {

		try {
			if (browserName.equalsIgnoreCase("mozilla")) {
				System.setProperty("webdriver.gecko.driver", "D:\\eclipse\\FindingHospitals\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver",
						"D:\\eclipse\\StoreNameMandatoryCheck\\driver\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	public LoginPage openApplication(String url) {
		driver.get(url);
		return PageFactory.initElements(driver, LoginPage.class);
	}

	public void takeScreenshot(String name) throws IOException {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(
				System.getProperty("user.dir") + "/Screenshots/" + name + DateUtils.getTimeStamp() + ".png");
		FileUtils.copyFile(sourceFile, destFile);
	}

//	public void takeScreenshot(io.cucumber.java.Scenario sc) throws IOException {
//	    TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
//	    byte[] screenshot=takeScreenshot.getScreenshotAs(OutputType.BYTES);
//	    sc.attach(screenshot, "image/png","Timesheet");
//	}

	public void closeBrowser() {
		try {
			driver.quit();
		} catch (UnreachableBrowserException e) {
			System.out.println("Error communicating with the remote browser: " + e.getMessage());
		}
	}

}
