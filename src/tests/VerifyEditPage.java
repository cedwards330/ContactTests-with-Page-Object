package tests;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyEditPage {
	
	//URL
	private static final String CONTACT_DETAILS_URL = "https://thinking-tester-contact-list.herokuapp.com/contactDetails";
	
	//LOCATORS
	private static final By VERIFY_FIRST_NAME_ID 	= By.id("firstName");
	private static final By VERIFY_LAST_NAME_ID = By.id("lastName");
	private static final By VERIFY_BIRTHDATE_ID = By.id("birthdate");
	private static final By VERIFY_EMAIL_ID = By.id("email");
	private static final By VERIFY_PHONE_ID = By.id("phone");
	private static final By VERIFY_ADDRESS1_ID = By.id("street1");
	private static final By VERIFY_ADDRESS2_ID = By.id("street2");
	private static final By VERIFY_CITY_ID = By.id("city");
	private static final By VERIFY_STATE_ID = By.id("stateProvince");
	private static final By VERIFY_POSTAL_CODE_ID = By.id("postalCode");
	private static final By VERIFY_COUNTRY_ID = By.id("country");
	
	//DRIVER
	private ChromeDriver driver;
	//private WebDriverWait wait;
	private static int TIMEOUT = 60;
	
	//CONSTRUCTORS
	public VerifyEditPage(ChromeDriver drv) {
		driver = drv;
		//wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public boolean isDisplayed() {
		String url = getUrl();
		
		return url.equalsIgnoreCase(CONTACT_DETAILS_URL);
	}
			
	//GET URL()
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	//OTHER METHODS
	public String getCountry() {
		getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_COUNTRY_ID));
		WebElement verifyEditCountry = driver.findElement(VERIFY_COUNTRY_ID);
		String verifyCountry = verifyEditCountry.getText();
		return verifyCountry;
	}

	public String getPostalCode() {
		getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_POSTAL_CODE_ID));
		WebElement verifyEditPostalCode = driver.findElement(VERIFY_POSTAL_CODE_ID);
		String verifyPostalCode = verifyEditPostalCode.getText();
		return verifyPostalCode;
	}

	public String getState() {
		getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_STATE_ID));
		WebElement verifyEditState = driver.findElement(VERIFY_STATE_ID);
		String verifyState = verifyEditState.getText();
		return verifyState;
	}

	public String getCity() {
		getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_CITY_ID));
		WebElement verifyEditCity = driver.findElement(VERIFY_CITY_ID);
		String verifyCity = verifyEditCity.getText();
		return verifyCity;
	}

	public String getAddress2() {
		getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_ADDRESS2_ID));
		WebElement verifyEditAddress2 = driver.findElement(VERIFY_ADDRESS2_ID);
		String verifyAddress2 = verifyEditAddress2.getText();
		return verifyAddress2;
	}

	public String getAddress1() {
		getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_ADDRESS1_ID));
		WebElement verifyEditAddress1 = driver.findElement(VERIFY_ADDRESS1_ID);
		String verifyAddress1 = verifyEditAddress1.getText();
		return verifyAddress1;
	}

	public String getPhone() {
		getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_PHONE_ID));
		WebElement verifyEditPhone = driver.findElement(VERIFY_PHONE_ID);
		String verifyPhone = verifyEditPhone.getText();
		return verifyPhone;
	}

	public String getEmail() {
		getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_EMAIL_ID));
		WebElement verifyEditEmail = driver.findElement(VERIFY_EMAIL_ID);
		String verifyEmail = verifyEditEmail.getText();
		return verifyEmail;
	}

	public String getBirthdate() {
		getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_BIRTHDATE_ID));
		WebElement verifyEditBirthdate = driver.findElement(VERIFY_BIRTHDATE_ID);
		String verifyBirthdate = verifyEditBirthdate.getText();
		return verifyBirthdate;
	}
	public String getLastName() {
		getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_LAST_NAME_ID));
		WebElement verifyEditLastName = driver.findElement(VERIFY_LAST_NAME_ID);
		String verifyLastName = verifyEditLastName.getText();
		return verifyLastName;
	}
	
	public String getFirstName() {
		getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(VERIFY_FIRST_NAME_ID));
		WebElement verifyEditFirstName = driver.findElement(VERIFY_FIRST_NAME_ID);
		String verifyFirstName = verifyEditFirstName.getText();
		return verifyFirstName;
	}

	public WebDriverWait getWait(Duration duration) {
		WebDriverWait wait = new WebDriverWait(driver, duration);
		return wait;
	}
	
	
	
	

}
