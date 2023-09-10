package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactDetailsPage {
	
	
	
	//URL
	private static final String CONTACT_DETAILS_URL = "https://thinking-tester-contact-list.herokuapp.com/contactDetails";
	
	//LOCATORS
	private static final By CONTACT_DETAILS_DELETE_BUTTON_XPATH = By.xpath("//button[contains(text(), 'Delete Contact')]");
	private static final By CONTACT_DETAILS_EDIT_BUTON_ID = By.id("edit-contact");
	
	private static final By EDIT_FIRST_NAME_ID 	= By.id("firstName");
	private static final By EDIT_LAST_NAME_ID = By.id("lastName");
	private static final By EDIT_BIRTHDATE_ID = By.id("birthdate");
	private static final By EDIT_EMAIL_ID = By.id("email");
	private static final By EDIT_PHONE_ID = By.id("phone");
	private static final By EDIT_ADDRESS1_ID = By.id("street1");
	private static final By EDIT_ADDRESS2_ID = By.id("street2");
	private static final By EDIT_CITY_ID = By.id("city");
	private static final By EDIT_STATE_ID = By.id("stateProvince");
	private static final By EDIT_POSTAL_CODE_ID = By.id("postalCode");
	private static final By EDIT_COUNTRY_ID = By.id("country");
	private static final By EDIT_SUBMIT_BUTTON = By.id("submit");
	
	//DRIVER
	private ChromeDriver driver;
	private WebDriverWait wait;

	
	//CONSTRUCTORS
	public ContactDetailsPage(ChromeDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	//IS DISPLAYED
	public boolean isDisplayed() {
		String url = getUrl();
		
		return url.equalsIgnoreCase(CONTACT_DETAILS_URL);
	}
			
	//GET URL()
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	
	//OTHER METHODS
	public void editCountry(String country) {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_COUNTRY_ID));
		WebElement editCountry = driver.findElement(EDIT_COUNTRY_ID);
		editCountry.sendKeys(country);
	}

	public void editPostalCode(String zip) {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_POSTAL_CODE_ID));
		WebElement editPostal = driver.findElement(EDIT_POSTAL_CODE_ID);
		editPostal.sendKeys(zip);
	}

	public void editState(String state) {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_STATE_ID));
		WebElement editState = driver.findElement(EDIT_STATE_ID);
		editState.sendKeys(state);
	}

	public void editCity(String city) {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_CITY_ID));
		WebElement editCity = driver.findElement(EDIT_CITY_ID);
		editCity.sendKeys(city);
	}

	public void editAddress2(String address2) {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_ADDRESS2_ID));
		WebElement editAddress2 = driver.findElement(EDIT_ADDRESS2_ID);
		editAddress2.sendKeys(address2);
	}

	public void editAddress1(String address1) {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_ADDRESS1_ID));
		WebElement editAddress1 = driver.findElement(EDIT_ADDRESS1_ID);
		editAddress1.sendKeys(address1);
	}

	public void editPhone(String phone) {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_PHONE_ID));
		WebElement editPhone = driver.findElement(EDIT_PHONE_ID);
		editPhone.sendKeys(phone);
	}

	public void editEmail(String email) {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_EMAIL_ID));
		WebElement editEmail = driver.findElement(EDIT_EMAIL_ID);
		editEmail.sendKeys(email);
	}

	public void editBirthDate(String birthdate) {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_BIRTHDATE_ID));
		WebElement editBirthDate = driver.findElement(EDIT_BIRTHDATE_ID);
		editBirthDate.sendKeys(birthdate);
	}

	public void editLastName(String lastname) {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_LAST_NAME_ID));
		WebElement editLastName = driver.findElement(EDIT_LAST_NAME_ID);
		editLastName.sendKeys(lastname);
	}

	public void clearCountry() {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_COUNTRY_ID));
		WebElement clearCountry = driver.findElement(EDIT_COUNTRY_ID);
		clearCountry.clear();
	}

	public void clearPostalCode() {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_POSTAL_CODE_ID));
		WebElement clearPostalCode = driver.findElement(EDIT_POSTAL_CODE_ID);
		clearPostalCode.clear();
	}

	public void clearState() {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_STATE_ID));
		WebElement clearState = driver.findElement(EDIT_STATE_ID);
		clearState.clear();
	}

	public void clearCity() {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_CITY_ID));
		WebElement clearCity = driver.findElement(EDIT_CITY_ID);
		clearCity.clear();
	}

	public void clearAddress2() {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_ADDRESS2_ID));
		WebElement clearAddress2 = driver.findElement(EDIT_ADDRESS2_ID);
		clearAddress2.clear();
	}

	public void clearAddress1() {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_ADDRESS1_ID));
		WebElement clearAddress1 = driver.findElement(EDIT_ADDRESS1_ID);
		clearAddress1.clear();
	}

	public void clearPhone() {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_PHONE_ID));
		WebElement clearPhone = driver.findElement(EDIT_PHONE_ID);
		clearPhone.clear();
	}

	public void clearEmail() {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_EMAIL_ID));
		WebElement clearEmail = driver.findElement(EDIT_EMAIL_ID);
		clearEmail.clear();
	}

	public void clearBirthdate() {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_BIRTHDATE_ID));
		WebElement clearBirthDate = driver.findElement(EDIT_BIRTHDATE_ID);
		clearBirthDate.clear();
	}

	public void clearLastName() {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_LAST_NAME_ID));
		WebElement clearLastName = driver.findElement(EDIT_LAST_NAME_ID);
		clearLastName.clear();
	}

	public void clearFirstName() {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_FIRST_NAME_ID));
		WebElement clearFirstName = driver.findElement(EDIT_FIRST_NAME_ID);
		clearFirstName.clear();
	}

	public void editButton() {
		wait.until(ExpectedConditions.elementToBeClickable(CONTACT_DETAILS_EDIT_BUTON_ID));
		WebElement editButton =  driver.findElement(CONTACT_DETAILS_EDIT_BUTON_ID);
		editButton.click();
	}

	public void editFirstName(String firstname) {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_FIRST_NAME_ID));
		WebElement editFirstName = driver.findElement(EDIT_FIRST_NAME_ID);
		editFirstName.sendKeys(firstname);
	}
	

	public void deleteButtonOnContactDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(CONTACT_DETAILS_DELETE_BUTTON_XPATH));
		WebElement deleteButton = driver.findElement(CONTACT_DETAILS_DELETE_BUTTON_XPATH);
		deleteButton.click();
	}
	
	public void editSubmitButton() {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_SUBMIT_BUTTON));
		WebElement editSubmit = driver.findElement(EDIT_SUBMIT_BUTTON);
		editSubmit.click();
	}
	
	

}
