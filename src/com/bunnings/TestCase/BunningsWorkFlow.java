/**
 * 
 */
package com.bunnings.TestCase;


import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bunnings.Pages.*;
import com.bunnings.Utils.EnvironmentProperties;
/**
 * @author Kalyani_Valluri
 *
 */

public class BunningsWorkFlow {
	EnvironmentProperties envProp=new EnvironmentProperties();
	WebDriver driver;

	@BeforeTest
	public void beforeTest()
	{
		//Setting property of Gecko Driver
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//geckodriver.exe");
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		//Setting desired capabilities
		capabilities.setCapability("marionette", true);
		//Passing the desired capabilities to the driver
		driver=new FirefoxDriver(capabilities);
		//Maximizing the browser
		driver.manage().window().maximize();
	}
	@Test
	public void verifyBunningsWorkFlow() throws FileNotFoundException
	{

		//sending the url to open depending on the environment
		driver.get(envProp.getProperty("url"));
		SearchResultPage searchResult=new SearchResultPage(driver);
		//Selecting a product from search result page
		searchResult.selectProduct();
		ProductDetailPage productDetail=new ProductDetailPage(driver);
		//getting the text of the selected paint item
		String pageTitle=productDetail.getPageTitle();
		//Adding the product to wishlist
		productDetail.addToWishlist();
		WishListPage wishListPage=new WishListPage(driver);
		//Checking if the selected product is present in wishlist
		wishListPage.wishListLinkAndCheck(pageTitle);

	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}
}
