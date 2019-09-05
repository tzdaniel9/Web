package com.web;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Web {

	static WebDriver driver;

	@BeforeMethod
	public void Setup() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void TestCaseWeb() throws InterruptedException {
		driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
		
		SoftAssert s_assert = new SoftAssert();
		String relativeXpath = "//table[contains(@class,'smart-table table table-striped')]";
		s_assert.assertTrue(driver.findElement(By.xpath(relativeXpath)).isDisplayed());
		s_assert.assertAll();
		
		driver.findElement(By.xpath("//button[@class='btn btn-link pull-right']")).click();

		driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("FName1");

		driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("LName1");

		driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("User1");

		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("Pass1");

		driver.findElement(By.xpath("//label[text()='Company AAA']")).click();

		WebElement Role = driver.findElement(By.name("RoleId"));
		Select select = new Select(Role);
		select.selectByVisibleText("Admin");

		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("admin@mail.com");

		driver.findElement(By.xpath("//input[@name='Mobilephone']")).sendKeys("082555");
		
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Close'])[1]/following::button[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='First Name'])[1]/preceding::button[1]")).click();
		
	    driver.findElement(By.xpath("//input[@name='FirstName']")).click();
	    driver.findElement(By.xpath("//input[@name='FirstName']")).clear();
		driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("FName2");

		driver.findElement(By.xpath("//input[@name='LastName']")).click();
		driver.findElement(By.xpath("//input[@name='LastName']")).clear();
		driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("LName2");

		driver.findElement(By.xpath("//input[@name='UserName']")).click();
		driver.findElement(By.xpath("//input[@name='UserName']")).clear();
		driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("User2");

		driver.findElement(By.xpath("//input[@name='Password']")).click();
		driver.findElement(By.xpath("//input[@name='Password']")).clear();
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("Pass2");

		driver.findElement(By.xpath("//label[text()='Company BBB']")).click();

		driver.findElement(By.name("RoleId")).click();
	    new Select(driver.findElement(By.name("RoleId"))).selectByVisibleText("Customer");
	    driver.findElement(By.name("RoleId")).click();

		driver.findElement(By.xpath("//input[@name='Email']")).click();
		driver.findElement(By.xpath("//input[@name='Email']")).clear();
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("customer@mail.com");

		driver.findElement(By.xpath("//input[@name='Mobilephone']")).click();
		driver.findElement(By.xpath("//input[@name='Mobilephone']")).clear();
		driver.findElement(By.xpath("//input[@name='Mobilephone']")).sendKeys("083444");

		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

	}

	@AfterMethod
    public void tearDown() throws InterruptedException, IOException{
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\mecer\\eclipse-workspace\\ee\\QA-Assessment\\src\\main\\resources\\screenShots\\screenshot.png"));
			
        driver.quit();
        }
}
