package com.univadis.tests;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OncologyHeadlineTest {

	
	@Test(testName="Verify Oncology Headlines",description="Verify whether Oncologh page has headlines or not")
	public void VerifyElement()
	{
		//
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver//chromedriver80.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.univadis.co.uk/news/all/oncology/");
//		List<String> headlines = new ArrayList<String>();
		int countHeadlines =0;
		List<WebElement> headlineTitle = driver.findElements(By.xpath("//ul[@id=\"filterableArticleList\"]/li/a"));
			
			for(WebElement w : headlineTitle) {
				System.out.println(w.getText() + " - " + w.getAttribute("href"));
				countHeadlines = countHeadlines +1;
			}
			
			Assert.assertEquals(countHeadlines, 3);
	}
	
	
}
