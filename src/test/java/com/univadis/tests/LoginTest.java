package com.univadis.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.univadis.pages.DashBoardPage;
import com.univadis.pages.HomePage;
import com.univadis.pages.LoginPage;

public class LoginTest {
	WebDriver driver; // null
	Properties prop; // null
	HomePage homePage; // null
	LoginPage loginPage; // null

	@BeforeMethod
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver//chromedriver80.exe");
		driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//config/config.properties");
		prop = new Properties(); // Important
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		homePage = new HomePage(driver);
		loginPage = homePage.goToLoginPage();
	}

	@Test(testName = "LoginTest", description = "Verify whether the user is able to login into the univadis.co.uk")
	public void verifyLoginTest() throws InterruptedException {

		DashBoardPage dashBoardPage = loginPage.doLogin(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		Assert.assertEquals(dashBoardPage.getUserName(), prop.getProperty("EXPECTED_USERNAME"));
	}

	
	@Test(testName = "Login Test Negative", description = "Verify whether the non registered user is not able to login into the univadis.co.uk")
	public void verifyLoginTestNegative() throws InterruptedException {

		DashBoardPage dashBoardPage = loginPage.doLogin(prop.getProperty("WRONG_USERNAME"), prop.getProperty("WRONG_PASSWORD"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
