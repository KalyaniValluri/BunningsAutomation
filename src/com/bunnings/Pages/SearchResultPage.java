/**
 * 
 */
package com.bunnings.Pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Kalyani_Valluri
 *
 */
public class SearchResultPage {
	WebDriver driver;
	//Xpath to get all the items related to paint in the search result
	By productSelected=By.xpath("//a[contains(@class,'product-list__link')]");
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void selectProduct()
	{
		//getting all the webelements related to paint in the search result
		List<WebElement> links = driver.findElements(productSelected);
		Random gen = new Random();
		WebElement link = links.get(gen.nextInt(links.size()));
		//Randomly selecting an item related to paint search result
		link.click();
	}
}
