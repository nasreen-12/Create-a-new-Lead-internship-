package day5;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateOpportunity {

	public static void main(String[] args) throws InterruptedException, IOException {
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
			//open  and search opportunities tab
			Thread.sleep(5000);
			WebElement opportunity = driver.findElement(By.xpath("//a[@title='Opportunities']"));
			driver.executeScript("arguments[0].click();", opportunity);
			driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Any Company Name");
			driver.findElement(By.xpath("//a[@title='Any Company Name-']")).click();
			// assign new task
			Thread.sleep(5000);
			WebElement click = driver.findElement(By.xpath("//span[contains(text(),'New Task')]"));
			driver.executeScript("arguments[0].click();", click);
			driver.findElement(By.xpath("//input[@aria-haspopup='listbox']")).click();
			driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Call']")).click();
			driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']")).click();
			WebElement date = driver.findElement(By.xpath("//button[@name='today']"));
			driver.executeScript("arguments[0].click();",date);
			driver.findElement(By.xpath("//a[contains(text(),'Not Started')]")).click();
			Thread.sleep(5000);
			WebElement select = driver.findElement(By.xpath("//a[@title='In Progress']"));
			driver.executeScript("arguments[0].click();",select);
			driver.findElement(By.xpath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton uiButton']")).click();
			//send email
			driver.findElement(By.xpath("//button[@value='SendEmail']")).click();
			driver.findElement(By.xpath("(//input[@aria-describedby='recipientsInputLabel'])[1]")).sendKeys("nasreen2810@gmail.com");
			driver.findElement(By.xpath("//input[@placeholder='Enter Subject...']")).sendKeys("Updated opportunity");
			driver.findElement(By.xpath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton  send uiButton']")).click();
			//change status
			WebElement emailstatus = driver.findElement(By.xpath("(//span[text()='Show more actions'])[2]/.."));
			driver.executeScript("arguments[0].click();",emailstatus);
			//change status
	        WebElement change = driver.findElement(By.xpath("//div[@title='Change Status']"));
	        driver.executeScript("arguments[0].click();",change);
			driver.findElement(By.xpath("//a[text()='In Progress']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@title='Completed']")).click();
			driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand cuf-publisherShareButton undefined uiButton']")).click();
			//Edit Opportunity Stage
			Thread.sleep(3000);
			WebElement submitdropdown = driver.findElement(By.xpath("(//span[text()='Show more actions']/..)[1]"));
			driver.executeScript("arguments[0].click();", submitdropdown);
			WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']/.."));
			driver.executeScript("arguments[0].click()", edit);
			Thread.sleep(3000);
			WebElement change2 = driver.findElement(By.xpath("//button[@data-value='Prospecting']/.."));
			driver.executeScript("arguments[0].click();",change2);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[@title='Qualification']/..")).click();
			driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
			//Snapshot
			Thread.sleep(3000);
			File src=driver.getScreenshotAs(OutputType.FILE);
			File des=new File("./snaps/Webpage.png");
			FileUtils.copyFile(src, des);

	}
	
}


