# BunningsAutomation

The solution comprises of 3 packages.

1)com.bunnings.Pages

This package deals with all the page methods for all the 3 pages in the solution. Below are the page funtions for the 3 pages present in this package.

ProductDetailPage: To get the product details of the selected random product
SearchResultPage: To select a random product from the search results page
WishListPage: To check the details of the selected product in wishlist page

2)com.bunnings.TestCase

This package has the test case automated using TestNg. test case is written to call the respective pages and perform function using selenium webdriver.
We need to run as a TestNg test.

3)com.bunnings.Utils

This package has the environment variables for Test,Staging and Production environment. There is also a env.properties file to give the value of test environment to be used.
There is a Class file to pick the right environment url depending on the value in env.properties file.

Apart from these, there is a geckodriver executable to facilitate the execution of test in firefox browser.


