package dsalgo.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import dsalgo.testbase.BaseClass;
import dsalgo.utilities.ConfigReader;
import dsalgo.pageobjects.DataStructure_POM;
import dsalgo.pageobjects.Graph_POM;
import dsalgo.pageobjects.HomePage;
import dsalgo.pageobjects.Login_POM;
import dsalgo.pageobjects.Stack_POM;

import dsalgo.utilities.Loggerload;

public class StackTest extends BaseClass {

	ConfigReader reader = new ConfigReader();
	HomePage homepage = new HomePage();
	Login_POM sign = new Login_POM();

	@BeforeMethod
	public void OpenApp() {

		driver.get(ConfigReader.getProperty("appURL"));
		Login_POM sign = new Login_POM();
		HomePage homepage = new HomePage();
		DataStructure_POM dspom = new DataStructure_POM();
		Graph_POM graph = new Graph_POM();
		homepage.clickOnGetStartedButton();
		sign.signInclick();
		dspom.Login("Rockstars_Numpy", "Numpy@Rock123");
		homepage.clickOnLoginBtn();
		String Title = graph.getStackPageTitle();
		Loggerload.info("Title of the Page : \" " + Title + "\" ");
		assertEquals(Title, "NumpyNinja", "Title do not match");

	}

	@Test(priority = 1, dataProvider = "DataTryEditorValidCode", dataProviderClass = DataProviderClass.class)
	public void OperationinStackValidcode(String code, String output) throws InterruptedException {

		Stack_POM stack = new Stack_POM();
		stack.getstarted_stack();
		stack.Operation_stack();
		stack.Tryeditor_Stack();
		stack.answer_stack();
		stack.setvalidcode(code);
		stack.Run_stack();
		Assert.assertEquals(stack.getActualResult(), output);
		Loggerload.info("You are viewing the Assessment Title in the Try Editor Page" + driver.getTitle() + " page.");
	}

	@Test(priority = 2, dataProvider = "DataTryEditorInvalidCode", dataProviderClass = DataProviderClass.class)
	public void OperationinStackInValidcode(String code, String output) throws InterruptedException {

		Stack_POM stack = new Stack_POM();
		stack.getstarted_stack();
		stack.Operation_stack();
		stack.Tryeditor_Stack();
		stack.answer_stack();
		stack.setinvalidcode(code);
		stack.Run_stack();
		String actualError = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(actualError, output);
		Loggerload.info("You are viewing the " + driver.getTitle() + " page.");
	}

	@Test(priority = 3, dataProvider = "DataTryEditorValidCode", dataProviderClass = DataProviderClass.class)
	public void ImplementationstackValidcode(String code, String output) throws InterruptedException {
		Stack_POM stack = new Stack_POM();
		stack.getstarted_stack();
		stack.Implementation_Stack();
		stack.Tryeditor_Stack();
		stack.answer_stack();
		stack.setvalidcode(code);
		stack.Run_stack();
		Assert.assertEquals(stack.getActualResult(), output);
		Loggerload.info("You are viewing the Assessment Title in the Try Editor Page" + driver.getTitle() + " page.");
	}

	@Test(priority = 4, dataProvider = "DataTryEditorInvalidCode", dataProviderClass = DataProviderClass.class)
	public void ImplementationstackInValidcode(String code, String output) throws InterruptedException {

		Stack_POM stack = new Stack_POM();
		stack.getstarted_stack();
		stack.Implementation_Stack();
		stack.Tryeditor_Stack();
		stack.answer_stack();
		stack.setinvalidcode(code);
		stack.Run_stack();
		String actualError = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(actualError, output);
		Loggerload.info("You are viewing the " + driver.getTitle() + " page.");
	}

	@Test(priority = 5, dataProvider = "DataTryEditorValidCode", dataProviderClass = DataProviderClass.class)
	public void ApplicationstackValidcode(String code, String output) throws InterruptedException {
		Stack_POM stack = new Stack_POM();
		stack.getstarted_stack();
		stack.Applications_Stack();
		stack.Tryeditor_Stack();
		stack.answer_stack();
		stack.setvalidcode(code);
		stack.Run_stack();
		Assert.assertEquals(stack.getActualResult(), output);
		Loggerload.info("You are viewing the Assessment Title in the Try Editor Page" + driver.getTitle() + " page.");
	}

	@Test(priority = 6, dataProvider = "DataTryEditorInvalidCode", dataProviderClass = DataProviderClass.class)
	public void ApplicationstackInValidcode(String code, String output) throws InterruptedException {

		Stack_POM stack = new Stack_POM();
		stack.getstarted_stack();
		stack.Applications_Stack();
		stack.Tryeditor_Stack();
		stack.answer_stack();
		stack.setinvalidcode(code);
		stack.Run_stack();
		String actualError = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(actualError, output);
		Loggerload.info("You are viewing the " + driver.getTitle() + " page.");
	}

	@Test(priority = 6, description = "DS Practicequestion")
	public void VerifyStackPracticeQuestio() throws InterruptedException {

		Stack_POM stack = new Stack_POM();
		stack.getstarted_stack();
		stack.Operation_stack();
		stack.practicequestion_Stack();
		String Title = stack.getStackPageTitle();
		Loggerload.info("Title of the Page : \" " + Title + "\" ");
		assertEquals(Title, "Practice Questions", "Title do not match");
	}

}
