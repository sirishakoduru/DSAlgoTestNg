package dsalgo.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dsalgo.pageobjects.HomePage;
import dsalgo.pageobjects.QueuePage;
import dsalgo.pageobjects.RegisterPage;
import dsalgo.testbase.BaseClass;
import dsalgo.utilities.ConfigReader;
import dsalgo.utilities.ExcelReader;

public class QueueTest extends BaseClass {
	HomePage homepage;
	RegisterPage register;
	QueuePage queuepage;

	@BeforeMethod
	public void setup() {

		driver.get(ConfigReader.getProperty("appHomeURL"));
		homepage = new HomePage();
		register = new RegisterPage();
		queuepage = new QueuePage();

		homepage.click_signin();
		homepage.enterUsername(ConfigReader.getProperty("username"));
		homepage.enterLoginPwd(ConfigReader.getProperty("password"));
		homepage.clickOnLoginBtn();

		assertEquals(register.getPageTitle(), "NumpyNinja", "Title mis match");
	}

	public void validCodeTryEditor(String code[]) {

		String pythonCode = code[0];
		String output = code[1];
		queuepage.navigateToTryEditor();
		queuepage.enterCodeInTryEditor(pythonCode);
		queuepage.clickOnRunButton();

		String actualMsg = queuepage.getActualResult();
		assertEquals(actualMsg, output, "Result mis matched");
	}

	public void inValidCodeTryEditor(String code) {
		
		queuepage.navigateToTryEditor();
		queuepage.enterCodeInTryEditor(code);
		queuepage.clickOnRunButton();
		queuepage.alerHandling();
	}


	// Queue Page
	@Test(priority = 1)
	public void navigateToQueuePage() {

		queuepage.navigateToHomePage();
		queuepage.dropdown_queue();
		String title = queuepage.getQueuePageTitle();
		assertEquals("Queue", title, "Title mis match");
	}

	// Implementation of Queue in Python
	@Test(priority = 2)
	public void navToImplQueueInPython() {
		queuepage.navigateToQueuePage();
		queuepage.clickOnImpQueuePythonLink();
		String title = queuepage.getQueuePageTitle();
		assertEquals(title, "Implementation of Queue in Python", "Title mis match");
	}

	@Test(priority = 3)
	public void tryEditorFromImplQueueInPython() {
		queuepage.navigateToQueuePage();
		queuepage.clickOnImpQueuePythonLink();
		queuepage.clickOnTryHereButton();
		assertTrue(queuepage.runBtnIsDisplayed());

	}

	@Test(priority = 4, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validCodeForImplQueueInPython(String code[]) {

		validCodeTryEditor(code);

	}


	@Test(priority = 5, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidCodeForImplQueueInPython(String code) {

		inValidCodeTryEditor(code);

	}


	// Implementation using collections.deque
	@Test(priority = 6)
	public void navToImplUsingCollectionsDequePage() {
		queuepage.navigateBackToQueuePage();
		queuepage.clickOnImpUsingCollectionDequeLink();
		String title = queuepage.getQueuePageTitle();
		assertEquals(title, "Implementation using collections.deque", "Title mis match");
	}

	@Test(priority = 7)
	public void tryEditorFromImplUsingCollectionsDequePage() {

		queuepage.navigateToImpUsingCollecDequeLink();
		queuepage.clickOnTryHereButton();
		assertTrue(queuepage.runBtnIsDisplayed());

	}

	@Test(priority = 8, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validCodeForImplUsingCollectionsDequePage(String code[]) {
		validCodeTryEditor(code);

	}

	@Test(priority = 9, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidCodeForImplUsingCollectionsDequePage(String code) {

		inValidCodeTryEditor(code);
	}

	// Implementation using Array
	@Test(priority = 10)
	public void navToImplUsingArrayPage() {

		queuepage.navigateToQueuePage();
		queuepage.clickOnImpUsingArray();
		String title = queuepage.getQueuePageTitle();
		assertEquals(title, "Implementation using array", "Title mis match");

	}

	@Test(priority = 11)
	public void tryEditorFromImplUsingArrayPage() {

		queuepage.navigateToImpUsingArrayLink();
		queuepage.clickOnTryHereButton();
		assertTrue(queuepage.runBtnIsDisplayed());

	}

	@Test(priority = 12, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validCodeForImplUsingArrayPage(String code[]) {

		validCodeTryEditor(code);

	}

	@Test(priority = 13, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidCodeForImplUsingArrayPage(String code) {

		inValidCodeTryEditor(code);

	}

	// Queue Operations
	@Test(priority = 14)
	public void navToQueueOperationPage() {

		queuepage.navigateToQueuePage();
		queuepage.clickOnQueueOperationsLink();
		String title = queuepage.getQueuePageTitle();
		assertEquals(title, "Queue Operations", "Title mis match");

	}

	@Test(priority = 15)
	public void tryEditorFromQueueOperationPage() {
		queuepage.navigateToQueueOperationsLink();
		queuepage.clickOnTryHereButton();
		assertTrue(queuepage.runBtnIsDisplayed());

	}

	@Test(priority = 16, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validCodeForQueueOperationPage(String code[]) {
		validCodeTryEditor(code);

	}

	@Test(priority = 17, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidCodeForQueueOperationPage(String code) {

		inValidCodeTryEditor(code);

	}

	// Practice Questions
	@Test(priority = 18)
	public void clickOnPracticeQLink() {

		queuepage.navigateToQueueOperationsLink();
		queuepage.clickOnPracticeQuestionLink();
		String title = queuepage.getQueuePageTitle();
		assertEquals(title, "Practice Questions", "Title mis match");

	}

}