package com.univadis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {
	private final By USERNAME = By.xpath("//span[@data-initials=\"AH\"]");
	private WebDriver driver;
	private WebDriverWait wait;

	public DashBoardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);

	}

	public String getUserName() {
		String userName = wait.until(ExpectedConditions.elementToBeClickable(USERNAME)).getAttribute("data-fullname");
		return userName;
	}

}
