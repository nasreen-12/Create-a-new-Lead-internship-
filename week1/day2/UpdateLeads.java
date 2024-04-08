package week1.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class UpdateLeads {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("nasreen2810-12xr@force.com");
		driver.findElement(By.id("password")).sendKeys("nasreen2810@");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//one-app-nav-bar-item-root[@data-id='Lead']")).click();
		driver.findElement(By.partialLinkText("New")).click();
		driver.findElement(By.xpath("//button[@name='salutation']")).click();
		driver.findElement(By.xpath("//span[@title='Mr.']")).click();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Any Name");
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("Any Company Name");
		driver.findElement(By.xpath("//input[@name='Title']")).sendKeys("QA");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		WebElement drop = driver.findElement(By.xpath("(//span[contains(text(),'More Actions')])[1]"));
		driver.executeScript("arguments[0].click();",drop);
		driver.findElement(By.xpath("(//div[@class='slds-dropdown__item'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']")).click();
		driver.findElement(By.xpath("(//td[@class='slds-is-today']/following-sibling::td)[1]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Save')])[4]")).click();
		driver.findElement(By.xpath("//button[@value='SendEmail']")).click();
		driver.findElement(By.xpath("(//input[@aria-describedby='recipientsInputLabel'])[1]")).sendKeys("nasreen2810@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Subject...']")).sendKeys("UpdatedLeads");
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr']")).sendKeys("updated leads are available");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton  send uiButton']")).click();
		WebElement emailstatus = driver.findElement(By.xpath("(//span[text()='Show more actions'])[2]/.."));
		driver.executeScript("arguments[0].click();",emailstatus);
        WebElement click = driver.findElement(By.xpath("//div[@title='Change Status']"));
        driver.executeScript("arguments[0].click();",click);
		driver.findElement(By.xpath("(//a[contains(text(),'Not Started')])[1]")).click();
		driver.findElement(By.xpath("//a[@title='Completed']")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Save')])[4]")).click();
	}

}
