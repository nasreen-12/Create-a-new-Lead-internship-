package day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageTasks {

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
		//open  and search opportunities tab
		Thread.sleep(5000);
		WebElement opportunity = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunity);
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Any Company Name");
		driver.findElement(By.xpath("//a[@title='Any Company Name-']")).click();
        //create new task
		Thread.sleep(5000);
		WebElement click = driver.findElement(By.xpath("//span[contains(text(),'New Task')]"));
		driver.executeScript("arguments[0].click();", click);
		driver.findElement(By.xpath("//input[@aria-haspopup='listbox']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Other']")).click();
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']")).click();
		WebElement date = driver.findElement(By.xpath("//button[@name='today']"));
		driver.executeScript("arguments[0].click();",date);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton uiButton']")).click();
		//Upload Sample File
		Thread.sleep(3000);
		WebElement upload_file = driver.findElement(By.xpath("//input[@type='file']"));
		Thread.sleep(3000);
		upload_file.sendKeys("C:\\Users\\NASREEN\\Desktop\\nasreen CV.pdf");
		System.out.println("File is Uploaded Successfully");
		Thread.sleep(3000);
		WebElement done = driver.findElement(By.xpath("//span[text()='Done']"));
		driver.executeScript("arguments[0].click();", done);
		//Verify Details
		String file = driver.findElement(By.xpath("//span[@title='nasreen CV']")).getText();
		if(file.contains("nasreen CV")) {
			System.out.println("The file is uploaded :"+file);
		}else {
			System.out.println("The file is not uploaded");
		}
		//Update Details
		WebElement details = driver.findElement(By.xpath("//a[text()='Details']"));
		driver.executeScript("arguments[0].click();", details);
		Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@title='Edit Description']")).sendKeys("Attachments uploaded successfully");
        WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
        driver.executeScript("arguments[0].click();", save);
        //Check Qualification Stage
         WebElement click1 = driver.findElement(By.xpath("//span[text()='Mark Stage as Complete']"));
      	 driver.executeScript("arguments[0].click();", click1);
      	WebElement click2 =  driver.findElement(By.xpath("//button[@name='SaveEdit']"));
      	driver.executeScript("arguments[0].click();", click2);
	}

}
