package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Newsroom {
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='wdpu-title']")
	public WebElement newWindowTitle;
	
	@FindBy(xpath = "//a[@class='wdpu-close']")
	public WebElement closeDialogBox;
	
	@FindBy(xpath = "//div[@class='w-dropdown-toggle filter-dropdown-2']")
	public WebElement categoryDropdrop;
	
	@FindBy(xpath = "//nav[@class='w-dropdown-list w--open']")
	public WebElement categoryList;
	
	public Newsroom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}