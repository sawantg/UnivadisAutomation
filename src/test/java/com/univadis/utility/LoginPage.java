package com.univadis.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private final By USERNAMETEXTBOX = By.id("_username");
	private final By PASSWORDTEXTBOX = By.id("_password");
	private final By LOGINBUTTON = By.xpath("//input[@value=\"Login\"]");
	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; // this keyword is used to differentiate between class variable and method
								// variable when both class variable and method variable have same name!!
		wait = new WebDriverWait(driver, 20);

	}

	public DashBoardPage doLogin(String userName, String password) throws InterruptedException {
		WebElement userNameTextBox = driver.findElement(USERNAMETEXTBOX);
		userNameTextBox.sendKeys(userName);
		WebElement passwordTextBox = driver.findElement(PASSWORDTEXTBOX);
		passwordTextBox.sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(LOGINBUTTON)).click();

		DashBoardPage dashBpardPage = new DashBoardPage(driver);
		return dashBpardPage;
	}

}
