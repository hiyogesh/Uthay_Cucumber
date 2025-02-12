package com.Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Driver.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartPage extends Driver{

	@Given("user should be login by {string} and {string}")
	public void userShouldBeLoginByAnd(String user, String pass) {
		
	    Actions act=new Actions(driver);
	    WebElement link=driver.findElement(By.xpath("//span[text()='Sign In'][@id='ctl00_LoginNameV1']"));
	    act.moveToElement(link).perform();
	    driver.findElement(By.linkText("Sign In")).click();
	    driver.findElement(By.xpath("//input[@id='LgnMobileOrEmail']")).sendKeys(user);
	    driver.findElement(By.xpath("//input[@id='logintextpswd']")).sendKeys(pass);
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnLogin")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_LoginNameV1")));
		String userName= driver.findElement(By.id("ctl00_LoginNameV1")).getText();
		System.out.println(userName);
	}
	@Given("user search a {string}")
	public void userSearchA(String book) {
	    driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys(book,Keys.ENTER);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+book+"']")));
	    driver.findElement(By.xpath("//a[text()='"+book+"']")).click();
	}
	@When("user add the book in cart")
	public void userAddTheBookInCart() {
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add to Cart']")));
	    driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
	    
	}
	@Then("cart count will updated")
	public void cartCountWillUpdated() {
		String count=driver.findElement(By.xpath("//span[@id='lnkcartdesk']")).getText();
	    System.out.println(count);
	    
	}
}
