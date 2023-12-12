package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void clickMenu() {
		driver.findElement(By.id("react-burger-menu-btn")).click();
	}
	public void clickLogout() {
		driver.findElement(By.id("logout_sidebar_link")).click();
	}
	

}
