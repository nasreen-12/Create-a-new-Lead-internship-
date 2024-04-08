package week1.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class EditLead {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("nasreen2810-12xr@force.com");
		driver.findElement(By.id("password")).sendKeys("nasreen2810@");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//one-app-nav-bar-item-root[@data-id='Lead']")).click();
		driver.findElement(By.xpath("(//a[@role='button'])[21]")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Ganesh");
		WebElement scroll = driver.findElement(By.xpath("//button[@aria-label='Lead Status - Current Selection: New']"));
		driver.executeScript("arguments[0].click();",scroll);
		driver.findElement(By.xpath("//span[@title='Contacted']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	}

}