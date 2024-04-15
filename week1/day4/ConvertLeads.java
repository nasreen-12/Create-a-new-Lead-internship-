package day4;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ConvertLeads {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		//login
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("nasreen2810@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("shahir0806");
		driver.findElement(By.id("Login")).click();
		//open sales
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		driver.findElement(By.xpath("(//div[@class='slds-app-launcher__tile-body slds-truncate'])[8]")).click();
		//open leads
		WebElement lead = driver.findElement(By.xpath("(//span[text()='Leads'])[1]"));
		driver.executeScript("arguments[0].click();", lead);
		//search lead
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Any Name");
		driver.findElement(By.xpath("(//a[@title='Any Name'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Details']")).click();
		//edit lead status
		WebElement drop = driver.findElement(By.xpath("//button[@title='Edit Lead Status']"));
		driver.executeScript("arguments[0].click();",drop);
		Actions toleadstatus=new Actions(driver);
		toleadstatus.scrollToElement(driver.findElement(By.xpath("//label[text()='No. of Employees']"))).perform();
		driver.findElement(By.xpath("//label[text()='Lead Status']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@title='Working - Contacted']/ancestor::lightning-base-combobox-item"));
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		//mark complete
		toleadstatus.scrollToElement(driver.findElement(By.xpath("//a[@title='Working - Contacted']"))).perform();
		WebElement complete = driver.findElement(By.xpath("//span[text()='Mark Status as Complete']/.."));
		driver.executeScript("arguments[0].click();", complete);
		//submit approval
		WebElement submitdropdown = driver.findElement(By.xpath("(//span[text()='Show more actions']/..)[2]"));
		driver.executeScript("arguments[0].click();", submitdropdown);
		//convert lead
		Thread.sleep(3000);
		WebElement convert = driver.findElement(By.xpath("//span[text()='Convert']/.."));
		driver.executeScript("arguments[0].click();", convert);
		Thread.sleep(3000);
		WebElement convertlead = driver.findElement(By.xpath("//button[text()='Convert']"));
		driver.executeScript("arguments[0].click();", convertlead);
		//snapshot
		Thread.sleep(3000);
		WebElement snaplead = driver.findElement(By.xpath("//div[contains(@class,'modal-body')]"));
		File src=snaplead.getScreenshotAs(OutputType.FILE);
		File des=new File("./snaps/convertlead.png");
		FileUtils.copyFile(src, des);
		Thread.sleep(3000);
		//close pop-up
		driver.findElement(By.xpath("//button[@title='Close this window']")).click();
		
	}

}
