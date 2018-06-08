/**
 * 
 */
package com.bunnings.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Kalyani_Valluri
 *
 */
public class ProductDetailPage {

	WebDriver driver;
	//Xpath to get the Text of the selected paint item
	By productTitle=By.xpath("//div[contains(@class,'page-title')]/h1");
	//Xpath to click on add to wishList button
	By wishListButton=By.xpath("//div/button[@class='btn-add-wishlist inactive']");
	public ProductDetailPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public String getPageTitle()
	{
		//getting the text of the selected paint item
		String title=driver.findElement(productTitle).getText();
		//printing the text of the selected paint item
		System.out.println(title);
		return title;
	}
	public void addToWishlist()
	{
		//clicking on add to wishList button
		driver.findElement(wishListButton).click();
	}
	
}
