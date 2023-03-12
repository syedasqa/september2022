package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.LoginPage;
import page.TestBase;

public class LoginPageTest extends TestBase{	
	LoginPage loginPageObj;	
	
	@BeforeMethod
	public void setUp() {
		initDriver();
		loginPageObj= PageFactory.initElements(driver, LoginPage.class);
	}
	
	@Test
	public void loginTest() throws Throwable {
		loginPageObj.enterUserName("demo@techfios.com");
		loginPageObj.enterPassword("abc123");
		loginPageObj.clickSignInButton();
		takeScreenshot(driver);		
	}
	
	@Test
	public void pageTitleTest() throws Throwable {
		loginPageObj.enterUserName("demo@techfios.com");
		loginPageObj.enterPassword("abc123");
		loginPageObj.clickSignInButton();
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginPageObj.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		takeScreenshot(driver);		
	}	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}	

}
