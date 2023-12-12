package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver; 
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	// We could add other common methods here if required
}
