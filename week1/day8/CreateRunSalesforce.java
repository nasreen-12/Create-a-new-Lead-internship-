package day8;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateRunSalesforce {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		//login step
		driver.findElement(By.id("username")).sendKeys("nasreen2810@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("shahir0806");
		driver.findElement(By.id("Login")).click();
		//open sales
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		driver.findElement(By.xpath("(//div[@class='slds-app-launcher__tile-body slds-truncate'])[8]")).click();
		//Navigate to Report Tab
		WebElement report = driver.findElement(By.xpath("//a[@title='Reports']"));
		driver.executeScript("arguments[0].click();", report);
		//Create New Folder
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='New Folder']")).click();
		driver.findElement(By.xpath("(//input[@class='inputText input'])[1]")).sendKeys("Nasreen");
		driver.findElement(By.xpath("(//input[@class='inputText input'])[2]")).sendKeys("NasreenSharuk");
		WebElement click = driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton']"));
		driver.executeScript("arguments[0].click();", click);
		//Navigate to all folders
		Thread.sleep(3000);
		WebElement open = driver.findElement(By.xpath("//a[text()='All Folders']"));
		driver.executeScript("arguments[0].click();", open);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search all folders...']")).sendKeys("Nasreen");
		WebElement nasreen = driver.findElement(By.xpath("//a[@title='Nasreen']"));
		driver.executeScript("arguments[0].click();", nasreen);
		//Create New Report
		driver.findElement(By.xpath("(//a[@title='New Report'])[2]")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		WebElement open1 = driver.findElement(By.xpath("//a[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", open1);
		WebElement open2 = driver.findElement(By.xpath("//p[@data-tooltip='Opportunities with Products']"));
		driver.executeScript("arguments[0].click();", open2);
		driver.findElement(By.xpath("//button[text()='Start Report']")).click();
		driver.switchTo().defaultContent();
		//Save the Report
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		WebElement open3 = driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral action-bar-action-ReportSaveAction reportAction report-action-ReportSaveAction']"));
		driver.executeScript("arguments[0].click();", open3);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@value='New Opportunities with Products Report']")).sendKeys("Internship Report");
		WebElement save = driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand report-save']"));
		driver.executeScript("arguments[0].click();", save);
		driver.switchTo().defaultContent();
		//Run the Report
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='Run']")).click();
		driver.switchTo().defaultContent();
		//Verify Report Creation:
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		String reportcreat = driver.findElement(By.xpath("//div[@class='slds-page-header__name-title']")).getText();
		if (reportcreat.contains("Internship Report")) {
			System.out.println("The report is created successfully");
			
		} else {
			System.out.println("The report is not created successfully");

		}
	}
		
		
		
		

	}


