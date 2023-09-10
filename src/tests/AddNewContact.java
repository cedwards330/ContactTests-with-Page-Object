package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewContact {
	
	//URL
	private static final String ADD_USER_URL = "https://thinking-tester-contact-list.herokuapp.com/addContact";
	
	
	//LOCATORS
	//private static final By ADD_NEW_CONTACT_ID = By.id("add-contact");
	private static final By ADD_CONTACT_FIRSTNAME_ID = By.id("firstName");
	private static final By ADD_CONTACT_LASTNAME_ID = By.id("lastName");
	private static final By ADD_CONTACT_BIRTHDATE_ID = By.id("birthdate");
	private static final By ADD_CONTACT_EMAIL_ID = By.id("email");
	private static final By ADD_CONTACT_PHONE_ID = By.id("phone");
	private static final By ADD_CONTACT_ADDRESS1_ID = By.id("street1");
	private static final By ADD_CONTACT_ADDRESS2_ID = By.id("street2");
	private static final By ADD_CONTACT_CITY_ID = By.id("city");
	private static final By ADD_CONTACT_STATE_ID = By.id("stateProvince");
	private static final By ADD_CONTACT_POSTALCODE_ID = By.id("postalCode");
	private static final By ADD_CONTACT_COUNTRY_ID = By.id("country");
	private static final By ADD_NEW_CONTACT_ERROR_XAPTH = By.xpath("//span[contains(text(), 'Contact validation failed')]");
	
	private static final By ADD_CONTACT_SUBMIT_ID = By.id("submit");
	
	//DRIVER
	private ChromeDriver driver;
	private WebDriverWait wait;
	private static int TIMEOUT = 30;
	
	//CONSTRUCTORS
	public AddNewContact(ChromeDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	//IS DISPLAYED
		public boolean isDisplayed() {
			String url = getUrl();
			
			return url.equalsIgnoreCase(ADD_USER_URL);
		}
				
		//GET URL()
		public String getUrl() {
			return driver.getCurrentUrl();
		}
	
	//OTHER METHODS
		public void submitButton() {
			wait.until(ExpectedConditions.elementToBeClickable(ADD_CONTACT_SUBMIT_ID));
			WebElement addContactSubmitButton = driver.findElement(ADD_CONTACT_SUBMIT_ID);
			addContactSubmitButton.click();
		}

		public void typeCountry(String country) {
			wait.until(ExpectedConditions.elementToBeClickable(ADD_CONTACT_COUNTRY_ID));
			WebElement typeCountry = driver.findElement(ADD_CONTACT_COUNTRY_ID);
			 typeCountry.sendKeys(country);
		}

		public void typePostalCode(String zip) {
			wait.until(ExpectedConditions.elementToBeClickable(ADD_CONTACT_POSTALCODE_ID));
			WebElement typePostalCode = driver.findElement(ADD_CONTACT_POSTALCODE_ID);
			 typePostalCode.sendKeys(zip);
		}

		public void typeState(String state) {
			wait.until(ExpectedConditions.elementToBeClickable(ADD_CONTACT_STATE_ID));
			WebElement typeState = driver.findElement(ADD_CONTACT_STATE_ID);
			 typeState.sendKeys(state);
		}

		public void typeCity(String city) {
			wait.until(ExpectedConditions.elementToBeClickable(ADD_CONTACT_CITY_ID));
			WebElement typeCity = driver.findElement(ADD_CONTACT_CITY_ID);
			typeCity.sendKeys(city);
		}

		public void typeAddress2(String address2) {
			wait.until(ExpectedConditions.elementToBeClickable(ADD_CONTACT_ADDRESS2_ID));
			WebElement typeAddress2 = driver.findElement(ADD_CONTACT_ADDRESS2_ID);
			typeAddress2.sendKeys(address2);
		}

		public void typeAddress1(String address1) {
			wait.until(ExpectedConditions.elementToBeClickable(ADD_CONTACT_ADDRESS1_ID));
			WebElement typeAddress1 = driver.findElement(ADD_CONTACT_ADDRESS1_ID);
			typeAddress1.sendKeys(address1);
		}

		public void typePhone(String phone) {
			wait.until(ExpectedConditions.elementToBeClickable(ADD_CONTACT_PHONE_ID));
			WebElement typePhone = driver.findElement(ADD_CONTACT_PHONE_ID);
			typePhone.sendKeys(phone);
		}

		public void typeEmail(String email) {
			wait.until(ExpectedConditions.elementToBeClickable(ADD_CONTACT_EMAIL_ID));
			WebElement typeEmail = driver.findElement(ADD_CONTACT_EMAIL_ID);
			typeEmail.sendKeys(email);
		}

		public void typeBirthDate(String birthdate) {
			wait.until(ExpectedConditions.elementToBeClickable(ADD_CONTACT_BIRTHDATE_ID));
			WebElement typeBirthDate = driver.findElement(ADD_CONTACT_BIRTHDATE_ID);
			typeBirthDate.sendKeys(birthdate);
		}

		public void typeLastName(String lastname) {
			wait.until(ExpectedConditions.elementToBeClickable(ADD_CONTACT_LASTNAME_ID));
			WebElement typeLastName = driver.findElement(ADD_CONTACT_LASTNAME_ID);
			typeLastName.sendKeys(lastname);
		}

		public void typeFirstName(String firstname) {
			wait.until(ExpectedConditions.elementToBeClickable(ADD_CONTACT_FIRSTNAME_ID));
			WebElement typeFirstName = driver.findElement(ADD_CONTACT_FIRSTNAME_ID);
			typeFirstName.sendKeys(firstname);
		}
		
		
		
		public WebDriverWait getWait(Duration duration) {
			WebDriverWait wait = new WebDriverWait(driver, duration);
			return wait;
		}
		
		public String getAddNewContactError() {
			getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(ADD_NEW_CONTACT_ERROR_XAPTH));
			WebElement getAddNewContactError = driver.findElement(ADD_NEW_CONTACT_ERROR_XAPTH);
			String errorMessage = getAddNewContactError.getText();
			
			return errorMessage;
		}

		//TEST DATA

				private static final String ADD_CONTACT_FIRSTNAME = "Fred";
				private static final String ADD_CONTACT_LASTNAME = "Astaire";
				private static final String ADD_CONTACT_BIRTHDATE = "1920-04-04";
				private static final String ADD_CONTACT_EMAIL = "fred.astaire@gmail.com";
				private static final String ADD_CONTACT_PHONE = "8675309";
				private static final String ADD_CONTACT_ADDRESS1 = "1 Hollywood Blvd";
				private static final String ADD_CONTACT_ADDRESS2 = "2 Hollywood Blvd";
				private static final String ADD_CONTACT_CITY = "Los Angeles";
				private static final String ADD_CONTACT_STATE = "California";
				private static final String ADD_CONTACT_POSTALCODE = "T2K1B7";
				private static final String ADD_CONTACT_COUNTRY = "USA";

		
		

}
