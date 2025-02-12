package com.hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Driver.Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Driver{
	@Before
	public void setup() {
		driver=new ChromeDriver();
	    this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	    driver.manage().window().maximize();
	    driver.get("https://www.bookbazaar.com/");
	}
	@After
	public void closeTest(Scenario scen) {
		boolean res=scen.isFailed();
		System.out.println(res);
		if(res) {
			byte[] screenshot=driver.getScreenshotAs(OutputType.BYTES);
			scen.attach(screenshot, "image/png", "Failed Scenario");
		}
		driver.quit();
	}

}
