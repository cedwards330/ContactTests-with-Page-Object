package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactList {
	
	//URL
	private static final String CONTACTLISTURL = "https://thinking-tester-contact-list.herokuapp.com/contactList";
	private static final long TIMEOUT = 0;	
	
	//LOCATORS
	private static final By ADD_NEW_CONTACT_ID = By.id("add-contact");
	private static final By VERIFY_NAME_FIELD= By.xpath("//tr[@class = 'contactTableBodyRow']/td[2]");
	
	
	private static final By LOGOUT_ID = By.id("logout");
	
		
	//DRIVER
	private ChromeDriver driver;
	private WebDriverWait wait;
	
		
	//CONSTRUCTORS
	public ContactList(ChromeDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	//IS DISPLAYED
	public boolean isDisplayed() {
		String url = getUrl();
		
		return url.equalsIgnoreCase(CONTACTLISTURL);
	}
	
	//GET URL()
	public String getUrl() {
		return driver.getCurrentUrl();
	}
		
	//OTHER METHODS
	public void goToAddNewContactPage() {
		getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.elementToBeClickable(ADD_NEW_CONTACT_ID));
		WebElement addNewContactButton = driver.findElement(ADD_NEW_CONTACT_ID);
		addNewContactButton.click();
	}
	public WebDriverWait getWait(Duration duration) {
		WebDriverWait wait = new WebDriverWait(driver, duration);
		return wait;
	}
	
	public void logout() {
		wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_ID));
		WebElement logoutButton = driver.findElement(LOGOUT_ID);
		logoutButton.click();
	}
	public void goToContactDetailsPage() {
		wait.until(ExpectedConditions.elementToBeClickable(VERIFY_NAME_FIELD));
		WebElement editNameField = driver.findElement(VERIFY_NAME_FIELD);
		editNameField.click();
	}
	
	public void selectExistingContact() {
		wait.until(ExpectedConditions.elementToBeClickable(VERIFY_NAME_FIELD));
		WebElement editNameField = driver.findElement(VERIFY_NAME_FIELD);
		editNameField.click();
	}
	


}
