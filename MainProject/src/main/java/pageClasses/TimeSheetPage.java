package pageClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import baseClass.PageBaseClasses;

public class TimeSheetPage extends PageBaseClasses {
	public TimeSheetPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//a[@class=\"ps-link\"]")
	public List<WebElement> TimeSheetDates;

	List<String> datesList = new ArrayList<String>();
	List<String> TimeSheetList = new ArrayList<String>();

	public void timesheet() throws Exception {
//		checking Timesheet title
		try {
			String title = driver.getTitle();
			Assert.assertEquals(title, "Timesheet Landing Component");
			takeScreenshot("TimeSheetSummaryPage");
		} catch (Exception e) {
			System.out.println(e);
			takeScreenshot("TimeSheetSummaryPageFailed");
		}
	}

	public void checkDates() throws Exception {
		try {
			LocalDate date = LocalDate.now();
//			first week Saturday
			while (date.getDayOfWeek() != DayOfWeek.SATURDAY) {
				date = date.minusDays(1);
			}
//			first week Friday
			LocalDate date2 = date.plusDays(6);

//			Formatting the date
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			String fri = date.format(dateTimeFormatter).toUpperCase();
			String sat = date2.format(dateTimeFormatter).toUpperCase();

			String first_week = fri + " " + "To" + " " + sat;
//			adding first week dates to the list
			datesList.add(first_week);

//			adding 2nd and 3rd week dates to the list
			for (int i = 0; i < 8;) {
				LocalDate fri1 = date.minusDays(i + 7);
				String f = fri1.format(dateTimeFormatter).toUpperCase();
				LocalDate sat2 = date2.minusDays(i + 7);
				String s = sat2.format(dateTimeFormatter).toUpperCase();
				String week = f + " " + "To" + " " + s;
				datesList.add(week);
				i = i + 7;
			}

//			Checking the dates of the Timesheet with expected dates 
			for (WebElement TSD : TimeSheetDates) {
				for (int i = 0; i < 3; i++) {
					if (TSD.getText().equalsIgnoreCase(datesList.get(i))) {
						TimeSheetList.add(TSD.getText());
						break;
					}
				}
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println(e);
			takeScreenshot("getDatesFailed");
		}
	}

//	Printing values in excel file
	public void excelOutput() throws Exception {
		File src = new File(System.getProperty("user.dir") + "\\OutputData\\output.xlsx");
		FileInputStream fin = new FileInputStream(src); // responsible for loading data byte by byte
		XSSFWorkbook book = new XSSFWorkbook(fin); // loads the entire workbook
		XSSFSheet sheet = book.getSheetAt(0); // loads specific sheet in the workbook

		// below values are expected values
		sheet.createRow(1).createCell(0).setCellValue(datesList.get(0));
		sheet.createRow(2).createCell(0).setCellValue(datesList.get(1));
		sheet.createRow(3).createCell(0).setCellValue(datesList.get(2));

		// below values are actual values
		sheet.createRow(6).createCell(0).setCellValue(TimeSheetList.get(0));
		sheet.createRow(7).createCell(0).setCellValue(TimeSheetList.get(1));
		sheet.createRow(8).createCell(0).setCellValue(TimeSheetList.get(2));

		FileOutputStream fout = new FileOutputStream(src);
		book.write(fout);
		fout.close();
	}
}
