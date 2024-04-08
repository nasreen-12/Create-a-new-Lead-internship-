package day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExistingLeads {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("nasreen2810-12xr@force.com");
		driver.findElement(By.id("password")).sendKeys("nasreen2810@");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		WebElement button = driver.findElement(By.xpath("(//a[@role='button'])[1]"));
		driver.executeScript("arguments[0].click();",button);
		Thread.sleep(3000);
		WebElement choose = driver.findElement(By.xpath("//span[text()='Any Name']"));
		driver.executeScript("arguments[0].click();",choose);
		driver.findElement(By.xpath("(//button[@title='More Actions'])[3]")).click();
		driver.findElement(By.xpath("(//div[@class='slds-dropdown__item'])[1]")).click();
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("call");
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']")).click();
		driver.findElement(By.xpath("(//td[@class='slds-is-today']/following-sibling::td)[1]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Save')])[4]")).click();
		driver.findElement(By.xpath("//button[@aria-label='Log a Call']")).click();
		driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys("Can we discuss working together?");
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton uiButton']")).click();
		WebElement emailstatus = driver.findElement(By.xpath("(//span[text()='Show more actions'])[3]/.."));
		driver.executeScript("arguments[0].click();",emailstatus);
        WebElement click = driver.findElement(By.xpath("//div[@title='Change Status']"));
        driver.executeScript("arguments[0].click();",click);
		driver.findElement(By.xpath("(//a[contains(text(),'Not Started')])[1]")).click();
		driver.findElement(By.xpath("//a[@title='Completed']")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Save')])[4]")).click();
	}

}
