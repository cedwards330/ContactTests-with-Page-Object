package tests;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyAddContactPage {
	
	//URL
	private static final String CONTACT_LIST_URL = "https://thinking-tester-contact-list.herokuapp.com/contactList";
	
	//LOCATORS
	private static final By VERIFY_NAME_FIELD= By.xpath("//tr[@class = 'contactTableBodyRow']/td[2]");
	private static final By VERIFY_BIRTH_FIELD = By.xpath("//tr[@class = 'contactTableBodyRow']/td[3]");
	private static final By VERIFY_EMAIL_FIELD = By.xpath("//tr[@class = 'contactTableBodyRow']/td[4]");
	private static final By VERIFY_PHONE_FIELD = By.xpath("//tr[@class = 'contactTableBodyRow']/td[5]");
	private static final By VERIFY_ADDRESS_FIELD = By.xpath("//tr[@class = 'contactTableBodyRow']/td[6]");
	private static final By VERIFY_CITY_STATE_ZIP_FIELD = By.xpath("//tr[@class = 'contactTableBodyRow']/td[7]");
	private static final By VERIFY_COUNTRY_FIELD = By.xpath("//tr[@class = 'contactTableBodyRow']/td[8]");
	
	private static final By LOGOUT_ID = By.id("logout");
	
	//DRIVER
	private ChromeDriver driver;
	private WebDriverWait wait;
	private static int TIMEOUT = 30;
	
	//CONSTRUCTORS
	public VerifyAddContactPage(ChromeDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}
	
	//IS DISPLAYED
			public boolean isDisplayed() {
				String url = getUrl();
				
				return url.equalsIgnoreCase(CONTACT_LIST_URL);
			}
					
			//GET URL()
			public String getUrl() {
				return driver.getCurrentUrl();
			}
	
	//OTHER METHODS
			public String getCountry() {
				getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_COUNTRY_FIELD));
				WebElement countryField = driver.findElement(VERIFY_COUNTRY_FIELD);
				String country = countryField.getText();
				return country;
			}
			
			public String getcityStateZip() {
				getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_CITY_STATE_ZIP_FIELD));
				WebElement cityStaeZipField = driver.findElement(VERIFY_CITY_STATE_ZIP_FIELD);
				String cityStateZip = cityStaeZipField.getText();
				return cityStateZip;
			}

			public String getAddress() {
				getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_ADDRESS_FIELD));
				WebElement addressField = driver.findElement(VERIFY_ADDRESS_FIELD);
				String address = addressField.getText();
				return address;
			}

			public String getPhone() {
				getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_PHONE_FIELD));
				WebElement phoneField = driver.findElement(VERIFY_PHONE_FIELD);
				String phone = phoneField.getText();
				return phone;
			}

			public String getEmail() {
				getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_EMAIL_FIELD));
				WebElement getEmail = driver.findElement(VERIFY_EMAIL_FIELD);
				String email = getEmail.getText();
				return email;
			}

			public String getBirthdate() {
				getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_BIRTH_FIELD));
				WebElement birthdateField = driver.findElement(VERIFY_BIRTH_FIELD);
				String birthdate = birthdateField.getText();
				return birthdate;
			}

			public String getName() {
				getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_NAME_FIELD));
				WebElement nameField = driver.findElement(VERIFY_NAME_FIELD);
				String name = nameField.getText();
				return name;
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

}
