package com.univadis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	/*
	 * In Java class variables SHOULD BE PRIVATE and should accessed by methods
	 * ONLY!! Locators will be my variables Business Functionalities: Methods
	 */
	private final By LOGIN_LINK = By.linkText("Login");
	private final By SIGN_UP_LINK = By.linkText("Sign up free");
	private final By ONCOLOGY_LINK = By.linkText("Oncology");
	private WebDriver driver;
	private WebDriverWait wait;

	public HomePage(WebDriver wd) {
		driver = wd;
		wait = new WebDriverWait(driver, 30);
		// TODO Auto-generated constructor stub
	}

	public LoginPage goToLoginPage() { // Page Class MEthods should return Page Objects ONLY
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(LOGIN_LINK))).click();
		LoginPage loginPage = new LoginPage(driver);// Class Loaded into the memory, Class variables intialization,
		return loginPage; // Constructor is called
	}

	public void goToSignUpPage() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(SIGN_UP_LINK))).click();
	}
	
	public LoginPage goToOncology() { // Page Class MEthods should return Page Objects ONLY
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(ONCOLOGY_LINK))).click();
		
		
		LoginPage loginPage = new LoginPage(driver);// Class Loaded into the memory, Class variables intialization,
		return loginPage; // Constructor is called
	}

}
