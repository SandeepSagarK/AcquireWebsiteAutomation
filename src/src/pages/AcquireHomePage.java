package pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcquireHomePage {
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='nav-div']/div/a")
	public WebElement AcquireIcon;
	
	@FindBy(xpath = "//div[@class='top-bar-div-block']/a[contains(text(),'Newsroom')]")
	public WebElement Newsroom;
	
	@FindBy(xpath = "//h2[contains(text(),'CEO 2022 recap and what’s ahead for 2023')]")
	public WebElement NewsroomBanner;
	
	@FindBy(xpath = "//div[@class='top-bar-div-block']/a[contains(text(),'Events  & Bookings')]")
	public WebElement EventsAndBookings;
	
	@FindBy(xpath = "//h1[contains(text(),'Events & Bookings')]")
	public WebElement EventsAndBookingsBanner;
	
	@FindBy(xpath = "//div[@class='top-bar-div-block']/a[contains(text(),'Request Support')]")
	public WebElement RequestSupport;
	
	@FindBy(xpath = "//h2[contains(text(),'acQuire Technical Support')]")
	public WebElement RequestSupportBanner;
	
	@FindBy(xpath = "//div[@class='top-bar-div-block']/a/span[@class='top-nav-icon']/i")
	public WebElement Search;
	
	@FindBy(xpath = "//div[@class='nav-right']/a[@class='button w-button']")
	public WebElement ContactUs;
	
	@FindBy(id = "//a[@id='back-to-top']")
	public WebElement BacktoTop;
	
	@FindBy(xpath = "//div[@class='cli-bar-btn_container']/a[contains(text(),'Accept')]")
	public WebElement CookieAccept;
	
	
	public AcquireHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}