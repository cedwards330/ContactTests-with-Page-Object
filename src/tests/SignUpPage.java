package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
	
	//URL
	private static final String ADD_USER_URL = "https://thinking-tester-contact-list.herokuapp.com/addUser";
	
	//LOCATORS
	private static final By FIRSTNAME_ID = By.id("firstName");
	private static final By LASTNAME_ID = By.id("lastName");
	private static final By EMAIL_ID = By.id("email");
	private static final By PASSWORD_ID = By.id("password");
	private static final By SUBMIT_ID = By.id("submit");
	private static final By ERROR_XPATH = By.xpath("//span[contains(text(), 'User validation failed:')]");
	

	
	private static final By LOGOUT_ID = By.id("logout");

	
	//DRIVER
	private ChromeDriver driver;
	private WebDriverWait wait;
	private static int TIMEOUT = 30;
	
	//CONSTRUCTORS
	public SignUpPage(ChromeDriver drv) {
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
	/*
	public String getErrorMessage1() {
		getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(ERROR_XPATH));
		
		WebElement errorMessagePopup = driver.findElement(ERROR_XPATH);
		String errorMessage = errorMessagePopup.getText();
		
		return errorMessage;
	}
	*/
	public WebDriverWait getWait(Duration duration) {
		WebDriverWait wait = new WebDriverWait(driver, duration);
		return wait;
	}
	
	public void submit() {
		wait.until(ExpectedConditions.elementToBeClickable(SUBMIT_ID));
		WebElement submitButton = driver.findElement(SUBMIT_ID);
		submitButton.click();
	}

	public void typePassword(String password) {
		wait.until(ExpectedConditions.elementToBeClickable(PASSWORD_ID));
		WebElement typePassword = driver.findElement(PASSWORD_ID);
		typePassword.sendKeys(password);
	}

	public void typeEmail(String email) {
		wait.until(ExpectedConditions.elementToBeClickable(EMAIL_ID));
		WebElement typeEmail = driver.findElement(EMAIL_ID);
		typeEmail.sendKeys(email);
	}

	public void typeLastName(String lastname) {
		wait.until(ExpectedConditions.elementToBeClickable(LASTNAME_ID));
		WebElement typeLastName = driver.findElement(LASTNAME_ID);
		typeLastName.sendKeys(lastname);
	}

	public void typeFirstName(String firstname) {
		wait.until(ExpectedConditions.elementToBeClickable(FIRSTNAME_ID));
		WebElement typeFirstName = driver.findElement(FIRSTNAME_ID);
		typeFirstName.sendKeys(firstname);
	}
	public String getErrorMessage() {
		getWait(Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(ERROR_XPATH));
		
		WebElement errorMessageDisplayed = driver.findElement(ERROR_XPATH);
		String errorMessage = errorMessageDisplayed.getText();
		
		return errorMessage;
	}
	
	public void logout() {
		wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_ID));
		WebElement logoutButton = driver.findElement(LOGOUT_ID);
		logoutButton.click();
	}
	


	


}
