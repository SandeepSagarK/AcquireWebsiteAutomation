package genericActions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.PageFactory;

public class Alerts {
	WebDriver driver;
	
	public Alerts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void getTextAlert() {
		Alert alert = driver.switchTo().alert();
		alert.getText();
	}
	
	public void sendKeysAlert(String arg) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(arg);
	}
}