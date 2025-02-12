package com.Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Driver.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage extends Driver{
	
	@Given("user click on the login link")
	public void userClickOnTheLoginLink() {
	    
	    Actions act=new Actions(driver);
	    WebElement link=driver.findElement(By.xpath("//span[text()='Sign In'][@id='ctl00_LoginNameV1']"));
	    act.moveToElement(link).perform();
	    driver.findElement(By.linkText("Sign In")).click();
	}
//	@Given("user enter the userName as 8667864738")
//	public void userEnterTheUserNameAs8667864738() {
//	    driver.findElement(By.xpath("//input[@id='LgnMobileOrEmail']")).sendKeys("8667864738");
//	}
//	@Given("user enter the Password as Yogesh123")
//	public void userEnterThePasswordAsYogesh123() {
//	    
//	    driver.findElement(By.xpath("//input[@id='logintextpswd']")).sendKeys("Yogesh123");
//	}
	@When("user click on the login btn")
	public void userClickOnTheLoginBtn() {
	    
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnLogin")).click();
	}
	@Then("user name will be updated")
	public void userNameWillBeUpdated() {
		
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_LoginNameV1")));
	   String user= driver.findElement(By.id("ctl00_LoginNameV1")).getText();
	   System.out.println(user);
	}
//	@Given("user enter the userName as 1236985471")
//	public void userEnterTheUserNameAs1236985471() {
//		driver.findElement(By.xpath("//input[@id='LgnMobileOrEmail']")).sendKeys("1236985471");
//		
//	}
//	@Given("user enter the Password as Yogesh")
//	public void userEnterThePasswordAsYogesh() {
//		driver.findElement(By.xpath("//input[@id='logintextpswd']")).sendKeys("Yogesh");
//	}
	@Then("login should be fail")
	public void loginShouldBeFail() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Please enter your registered mobile number.']")));
	   String  res=driver.findElement(By.xpath("//div[text()='Please enter your registered mobile number.']")).getText();
	System.out.println(res);
	}
	@Given("user enter the userName as {string}")
	public void userEnterTheUserNameAs(String User) {
		driver.findElement(By.xpath("//input[@id='LgnMobileOrEmail']")).sendKeys(User);
	}
	@Given("user enter the Password as {string}")
	public void userEnterThePasswordAs(String password) {
		driver.findElement(By.xpath("//input[@id='logintextpswd']")).sendKeys(password);
	}

}
