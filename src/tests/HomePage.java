package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	//test data
	private static final String EMAIL = "JohnDoe5@hotmail.com";
	private static final String PASSWORD = "123456789";
	
	//URL
	private static final String LOGIN_PAGE_URL = "https://thinking-tester-contact-list.herokuapp.com/";
	
	//LOCATORS
	private static final By SIGN_UP_ID = By.id("signup");
	private static final By LOGIN_EMAIL_iD = By.id("email");
	private static final By LOGIN_PASSWORD_ID = By.id("password");
	private static final By LOGIN_SUBMIT_ID = By.id("submit");
	
	//DRIVER
	private ChromeDriver driver;
	private WebDriverWait wait;
	//private static int TIMEOUT = 30;
	
	//CONSTRUCTORS
	public HomePage(ChromeDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	//IS DISPLAYED
	public boolean isDisplayed() {
		String url = getUrl();
		
		return url.equalsIgnoreCase(LOGIN_PAGE_URL);
	}
	
	//GET URL()
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	//OTHER METHODS
	public void open() {
		driver.get(LOGIN_PAGE_URL);
	}
	
	public void goToSignUpPage() {
		WebElement signupButton = driver.findElement(SIGN_UP_ID);
		signupButton.click();
	}

	public void typeUserPassword() {
		wait.until(ExpectedConditions.elementToBeClickable(LOGIN_PASSWORD_ID));
		WebElement typeLoginPassword = driver.findElement(LOGIN_PASSWORD_ID);
		typeLoginPassword.sendKeys(PASSWORD);
	}

	public void typeUserEmail() {
		wait.until(ExpectedConditions.elementToBeClickable(LOGIN_EMAIL_iD));
		WebElement typeLoginEmail = driver.findElement(LOGIN_EMAIL_iD);
		typeLoginEmail.sendKeys(EMAIL);
	}
	
	public void login() {
		wait.until(ExpectedConditions.elementToBeClickable(LOGIN_SUBMIT_ID));
		WebElement loginSubmit = driver.findElement(LOGIN_SUBMIT_ID);
		loginSubmit.click();
	}
	
	
}
