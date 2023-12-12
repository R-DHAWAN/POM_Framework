package testScenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;

public class TestLogin {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homepage;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		homepage = new HomePage(driver);
	}

	@Test(priority=1)
	public void testSuccessfulLogin() throws InterruptedException {

		driver.get("https://www.saucedemo.com");
		Thread.sleep(2000); // Using Thread.sleep() to visualize the process being implemented
		loginPage.enterUsername("standard_user");
		Thread.sleep(2000);
		loginPage.enterPassword("secret_sauce");
		Thread.sleep(2000);
		loginPage.clickLoginButton();
		Thread.sleep(2000);

		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Swag Labs";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}

	@Test(priority=2)
	public void testSuccessfulLogout() throws InterruptedException {
		homepage.clickMenu();
		Thread.sleep(1000);
		homepage.clickLogout();
		Thread.sleep(1000);
		
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Swag Labs";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
