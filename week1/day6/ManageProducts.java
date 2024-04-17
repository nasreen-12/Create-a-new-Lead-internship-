package day6;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ManageProducts {

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
		//Check Qualification Stage
		WebElement click = driver.findElement(By.xpath("//span[text()='Mark Stage as Complete']"));
		driver.executeScript("arguments[0].click();", click);
		//Select Price Book
		Thread.sleep(3000);
		WebElement select = driver.findElement(By.xpath("//span[text()='Show actions for Products']"));
		driver.executeScript("arguments[0].click();", select);
		Thread.sleep(3000);
		WebElement select1 = driver.findElement(By.xpath("//a[@title='Choose Price Book']"));
		driver.executeScript("arguments[0].click();", select1);
		WebElement select6 = driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton']"));
		driver.executeScript("arguments[0].click();", select6);
		//Add Products
		Thread.sleep(3000);
		WebElement select4 = driver.findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[1]"));
		driver.executeScript("arguments[0].click();", select4);
		WebElement select5 = driver.findElement(By.xpath("//a[@title='Add Products']"));
		driver.executeScript("arguments[0].click();", select5);
		//Search and Display Products
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Search Products']")).sendKeys("SLA"+Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@data-aura-class='forceSearchInputLookupDesktopActionItem'])[1]")).click();
		Thread.sleep(3000);
		List<WebElement> colvalue = driver.findElements(By.xpath("//div[@class='undefined hideRowNumberColumn hideRLAColumn forceListViewManagerGrid']//div/table/tbody/tr/td[2]/following-sibling::th"));
		 int productsize = colvalue.size();
		   System.out.println("col size is :"+productsize);
		for (int i = 0; i < colvalue.size(); i++) {
		Thread.sleep(3000);
		   String proname = colvalue.get(i).getText();
		    System.out.println("the product names for the search results SLA"+proname);
		}
		
		//Select Products:
		driver.findElement(By.xpath("//span[text()='Select 4 items']/../..")).click();
		driver.findElement(By.xpath("//button[@title='Next']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='SLA: Gold']/ancestor::th/following-sibling::td")).click();
		driver.findElement(By.xpath("//a[text()='SLA: Gold']/ancestor::th/following-sibling::td//input")).sendKeys("2"+Keys.ENTER);
		// driver.findElement(By.xpath("//a[text()='SLA: Gold']/ancestor::th/following-sibling::td//input")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[text()='SLA: Bronze']/ancestor::th/following-sibling::td")).click();
		driver.findElement(By.xpath("//a[text()='SLA: Bronze']/ancestor::th/following-sibling::td//input")).sendKeys("10"+Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='SLA: Platinum']/ancestor::th/following-sibling::td")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='SLA: Platinum']/ancestor::th/following-sibling::td//input")).sendKeys("1"+Keys.ENTER);
        driver.findElement(By.xpath("//a[text()='SLA: Silver']/ancestor::th/following-sibling::td")).click();
		driver.findElement(By.xpath("//a[text()='SLA: Silver']/ancestor::th/following-sibling::td//input")).sendKeys("5"+Keys.ENTER);
        driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
		//View All Products:
		Actions viewall=new Actions(driver);
		viewall.moveToElement(driver.findElement(By.xpath("(//span[text()='View All']/parent::div)[1]"))).perform();
		Thread.sleep(3000);
		WebElement view = driver.findElement(By.xpath("(//span[text()='View All']/parent::div)[1]"));
		driver.executeScript("arguments[0].click();", view);
		//Retrieve Product Details:
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@title='SLA: Gold']/ancestor::th/following-sibling::td)[5]")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
	   Thread.sleep(3000);
		String code = driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.OpportunityLineItem.ProductCode']")).getText();
		String proname = driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.OpportunityLineItem.Product2Id']")).getText();
		System.out.println("The product code is :/n "+code+"/n productname is /n :"+proname);
		driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
		}
		
		
		}
	


