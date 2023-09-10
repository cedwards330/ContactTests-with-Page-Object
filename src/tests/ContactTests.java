package tests;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




	public class ContactTests {
	
		private static final String FIRSTNAME = "Jane";
		private static final String LASTNAME = "Doe";
		private static final String EMAIL = "JaneDoe105@gmail.com";
		private static final String PASSWORD = "123456789";

		private static final String USER_VALIDATION_FAILED = "User validation failed: firstName: Path `firstName` is required., lastName: Path `lastName` is required., email: Email is invalid, password: Path `password` is required.";
		private static final String ADD_CONTACT_ERROR = "Contact validation failed: firstName: Path `firstName` is required., lastName: Path `lastName` is required.";

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


		//CONTACT DETAIL TEST DATA
		private static final String EDIT_FIRST_NAME = "Charlie";
		private static final String EDIT_LAST_NAME = "Sheen";
		private static final String EDIT_BIRTHDATE = "1967-07-08";
		private static final String EDIT_EMAIL = "charliesheen@gmail.com";
		private static final String EDIT_PHONE = "5445454";
		private static final String EDIT_ADDRESS1 = "21 compton blvd";
		private static final String EDIT_ADDRESS2 = "22 compton blvd";
		private static final String EDIT_CITY = "Crenshaw";
		private static final String EDIT_STATE = "California";
		private static final String EDIT_POSTAL_CODE = "T2b1Z7";
		private static final String EDIT_COUNTRY = "denmark";

		private ChromeDriver driver;

		@BeforeClass
		public void setUp() {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
/*
		@AfterClass
		public void tearDown() {
			driver.quit();
		}
*/
		@Test
		public void createAccount() throws InterruptedException {
			
			HomePage homepage = new HomePage(driver);
			
			homepage.open();
			Assert.assertTrue(homepage.isDisplayed());

			homepage.goToSignUpPage();

			SignUpPage signUpPage = new SignUpPage(driver);
			
			Assert.assertTrue(signUpPage.isDisplayed());

			signUpPage.typeFirstName(FIRSTNAME);
			signUpPage.typeLastName(LASTNAME);
			signUpPage.typeEmail(EMAIL);
			signUpPage.typePassword(PASSWORD);
			signUpPage.submit();
			
			ContactList contactList = new ContactList(driver);
			Thread.sleep(3000);
			Assert.assertTrue(contactList.isDisplayed());
			
			contactList.logout();

		}

		@Test
		public void cannot_Sign_Up_Without_Mandatory_Fields() throws InterruptedException {
			HomePage homepage = new HomePage(driver);
			homepage.open();
			Assert.assertTrue(homepage.isDisplayed());

			homepage.goToSignUpPage();

			SignUpPage signUpPage = new SignUpPage(driver);
			Assert.assertTrue(signUpPage.isDisplayed());

			signUpPage.submit();

			Assert.assertEquals(signUpPage.getErrorMessage(), USER_VALIDATION_FAILED);
		}

		@Test
		public void create_Contact() throws InterruptedException {
			
			HomePage homepage = new HomePage(driver);
			homepage.open();
			Assert.assertTrue(homepage.isDisplayed());

			homepage.typeUserEmail();
			homepage.typeUserPassword();
			homepage.login();

			ContactList contactList = new ContactList(driver);
			
			Thread.sleep(3000);
			contactList.goToAddNewContactPage();

			AddNewContact addContact = new AddNewContact(driver);
			addContact.typeFirstName(ADD_CONTACT_FIRSTNAME);
			addContact.typeLastName(ADD_CONTACT_LASTNAME);
			addContact.typeBirthDate(ADD_CONTACT_BIRTHDATE);
			addContact.typeEmail(ADD_CONTACT_EMAIL);
			addContact.typePhone(ADD_CONTACT_PHONE);
			addContact.typeAddress1(ADD_CONTACT_ADDRESS1);
			addContact.typeAddress2(ADD_CONTACT_ADDRESS2);
			addContact.typeCity(ADD_CONTACT_CITY);
			addContact.typeState(ADD_CONTACT_STATE);
			addContact.typePostalCode(ADD_CONTACT_POSTALCODE);
			addContact.typeCountry(ADD_CONTACT_COUNTRY);			
			addContact.submitButton();

			Thread.sleep(3000);
			VerifyAddContactPage verifyContact = new VerifyAddContactPage(driver);
			Assert.assertTrue(verifyContact.isDisplayed());
			
			String name = verifyContact.getName();
			Assert.assertTrue(name.contains(ADD_CONTACT_FIRSTNAME));

			String birthdate = verifyContact.getBirthdate();
			Assert.assertTrue(birthdate.contains(ADD_CONTACT_BIRTHDATE));

			String email = verifyContact.getEmail();
			Assert.assertTrue(email.contains(ADD_CONTACT_EMAIL));

			String phone = verifyContact.getPhone();
			Assert.assertTrue(phone.contains(ADD_CONTACT_PHONE));

			String address = verifyContact.getAddress();
			Assert.assertTrue(address.contains(ADD_CONTACT_ADDRESS1));

			String cityStateZip = verifyContact.getcityStateZip();
			Assert.assertTrue(cityStateZip.contains(ADD_CONTACT_STATE));
			
			String country = verifyContact.getCountry();
			Assert.assertTrue(country.contains(ADD_CONTACT_COUNTRY));

			verifyContact.logout();
			
			Thread.sleep(3000);
			Assert.assertTrue(homepage.isDisplayed());
		}
		
		@Test
		public void cannotCreateContactWithoutMandatoryFields() throws InterruptedException {
			HomePage homepage = new HomePage(driver);
			homepage.open();
			Assert.assertTrue(homepage.isDisplayed());

			homepage.typeUserEmail();
			homepage.typeUserPassword();
			homepage.login();

			ContactList contactList = new ContactList(driver);
			
			Thread.sleep(3000);
			Assert.assertTrue(contactList.isDisplayed());
			
			contactList.goToAddNewContactPage();

			AddNewContact addContact = new AddNewContact(driver);
			
			Assert.assertTrue(addContact.isDisplayed());

			addContact.submitButton();
			addContact.getAddNewContactError();
			Assert.assertEquals(addContact.getAddNewContactError()  , ADD_CONTACT_ERROR);

		}

		@Test
		public void deleteContact() throws InterruptedException {
			HomePage homepage = new HomePage(driver);
			homepage.open();
			Assert.assertTrue(homepage.isDisplayed());

			homepage.typeUserEmail();
			homepage.typeUserPassword();
			homepage.login();

			ContactList contactList = new ContactList(driver);
			
			Thread.sleep(3000);
			Assert.assertTrue(contactList.isDisplayed());

			contactList.goToContactDetailsPage();
			
			ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
			Assert.assertTrue(contactDetailsPage.isDisplayed());

			contactDetailsPage.deleteButtonOnContactDetails();
			
			Thread.sleep(5000);
			String alertMessage = driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			//WebElement button = driver.findElement(By.xpath("//button[text() = 'Are you sure you want to delete this contact?']"));
			//button.click();
			
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept();
			
			Thread.sleep(3000);
			
			Thread.sleep(3000);
			Assert.assertTrue(contactList.isDisplayed());	

		}

		@Test
		public void editContact() throws InterruptedException {
			HomePage homepage = new HomePage(driver);
			homepage.open();
			Assert.assertTrue(homepage.isDisplayed());

			homepage.typeUserEmail();
			homepage.typeUserPassword();
			homepage.login();

			ContactList contactList = new ContactList(driver);
			
			Thread.sleep(3000);
			Assert.assertTrue(contactList.isDisplayed());
			
			contactList.selectExistingContact();

			ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
			
			Thread.sleep(3000);
			Assert.assertTrue(contactDetailsPage.isDisplayed());
			
			Thread.sleep(3000);
			contactDetailsPage.editButton();
			contactDetailsPage.clearFirstName();
			contactDetailsPage.clearFirstName();
			contactDetailsPage.clearLastName();
			contactDetailsPage.clearBirthdate();
			contactDetailsPage.clearEmail();
			contactDetailsPage.clearPhone();
			contactDetailsPage.clearAddress1();					
			contactDetailsPage.clearAddress2();					
			contactDetailsPage.clearCity();					
			contactDetailsPage.clearState();					
			contactDetailsPage.clearPostalCode();					
			contactDetailsPage.clearCountry();					

			contactDetailsPage.editFirstName(EDIT_FIRST_NAME);	
			contactDetailsPage.editLastName(EDIT_LAST_NAME);					
			contactDetailsPage.editBirthDate(EDIT_BIRTHDATE);					
			contactDetailsPage.editEmail(EDIT_EMAIL);					
			contactDetailsPage.editPhone(EDIT_PHONE);				
			contactDetailsPage.editAddress1(EDIT_ADDRESS1);					
			contactDetailsPage.editAddress2(EDIT_ADDRESS2);
			contactDetailsPage.editCity(EDIT_CITY);					
			contactDetailsPage.editState(EDIT_STATE);					
			contactDetailsPage.editPostalCode(EDIT_POSTAL_CODE);					
			contactDetailsPage.editCountry(EDIT_COUNTRY);

			contactDetailsPage.editSubmitButton();
			
			VerifyEditPage verifyEdit = new VerifyEditPage(driver);
			
			Thread.sleep(5000);
			Assert.assertTrue(verifyEdit.isDisplayed());

			Thread.sleep(3000);
			String firstname = verifyEdit.getFirstName();
			Assert.assertEquals(firstname, EDIT_FIRST_NAME);

			String lastname = verifyEdit.getLastName();
			Assert.assertEquals (lastname, EDIT_LAST_NAME);

			String birthdate = verifyEdit.getBirthdate();
			Assert.assertEquals(birthdate, EDIT_BIRTHDATE);

			String email = verifyEdit.getEmail();
			Assert.assertEquals(email, EDIT_EMAIL);

			String phone = verifyEdit.getPhone();
			Assert.assertEquals(phone, EDIT_PHONE);

			String address1 = verifyEdit.getAddress1();
			Assert.assertEquals(address1, EDIT_ADDRESS1);

			String address2 = verifyEdit.getAddress2();
			Assert.assertEquals(address2, EDIT_ADDRESS2);

			String city = verifyEdit.getCity();
			Assert.assertEquals(city, EDIT_CITY);

			String state = verifyEdit.getState();
			Assert.assertEquals(state, EDIT_STATE);

			String postalCode = verifyEdit.getPostalCode();
			Assert.assertEquals(postalCode, EDIT_POSTAL_CODE);

			String country = verifyEdit.getCountry();
			Assert.assertEquals(country, EDIT_COUNTRY);
			
			contactList.logout();
			
			Thread.sleep(3000);
			Assert.assertTrue(homepage.isDisplayed());
		}


	}