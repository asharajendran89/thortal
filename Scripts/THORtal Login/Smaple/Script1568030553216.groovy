import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

'Browse to THORtal application'
WebUI.openBrowser('http://192.168.0.28:4205/login')

'Initiate the driverfactory to access the webdriver'
WebDriver driver = DriverFactory.getWebDriver()

'Maximize the browser window'
WebUI.maximizeWindow()

'Created a object for log'
KeywordLogger log = new KeywordLogger()

'Wait for 3 sec'
WebUI.delay(5)

'Condition to check THORtal logo is present in the login page or not'

	
	WebUI.delay(5)
	
    'Iterate the data file to perform valid and invalid credentials'
    for (int i = 1; i <= findTestData('Login').getRowNumbers(); i++) {
        'Enter email id'
        WebUI.setText(findTestObject('Login/User Name'), findTestData('Login').getValue(1, i))

        'Enter password'
        WebUI.setText(findTestObject('Login/Password'), findTestData('Login').getValue(2, i))

        'Click on Submit button'
        WebUI.click(findTestObject('Login/signin'))

        'Condition to check a error message and the text Lead is present or not'
        currentpageurl = WebUI.getUrl()

        if (currentpageurl.equals('http://192.168.0.28:4205/dashboard')) {
            log.logInfo('--------- Sucessfull Log In --------------')

            'click on logout button'
            WebUI.click(findTestObject('Object Repository/Login/Logout'))

            'Condition failed verify the error message'
        } else {
            errormessage = WebUI.getText(findTestObject('Object Repository/Login/Error'))

            log.logInfo(errormessage)
        }
    }
 

