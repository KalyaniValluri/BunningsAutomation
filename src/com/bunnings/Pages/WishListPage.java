/**
 * 
 */
package com.bunnings.Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
/**
 * @author Kalyani_Valluri
 *
 */
public class WishListPage {

WebDriver driver;
//Xpath to click on WishList Link
By wishListLink=By.xpath("//a[contains(@title, 'Wish List')]");

//Xpath to get the text of the paint present in wishlist
By wishListCheck=By.xpath("//a[contains(@class,'GAEvent display-block')]/strong");

public WishListPage(WebDriver driver)
{
	this.driver=driver;
}

public void wishListLinkAndCheck(String productAddedExpected)
{
	//Clicking on wishList link
	driver.findElement(wishListLink).click();
	//getting the text of the paint present in wishlist
	String productAddedActual=driver.findElement(wishListCheck).getText();
	//printing the title of the paint present in wishlist
	System.out.println(productAddedActual);
	//Verifying if the paint item added to the wishlist is same as the paint item present in wishlist
	assertEquals(productAddedActual, productAddedExpected);
}	
}
