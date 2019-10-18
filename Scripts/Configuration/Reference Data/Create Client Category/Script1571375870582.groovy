import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

WebUI.comment('Create New Category')

'Calling Login Test case'
WebUI.callTestCase(findTestCase('THORtal Login/login'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Configuration Button'
WebUI.click(findTestObject('Configurations/Configuration'))

'Scroll upto Refernece Data'
WebUI.scrollToElement(findTestObject('Configurations/Reference Data'), 0)

'Click on Reference data button'
WebUI.click(findTestObject('Configurations/Reference Data'))

WebDriver driver = DriverFactory.getWebDriver()

' Verify Reference Data or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4205/configuration/reference_data') {
    System.out.println('Congiguration/Reference Data - page')

    WebUI.delay(5)

	'Click on Client Category tab'
    WebUI.click(findTestObject('Object Repository/Reference Data/client category'))

    WebUI.delay(3)
	
	'Click on New Category'
    WebUI.click(findTestObject('Object Repository/Reference Data/New category Button'))
	
	'Enter Category Name'
    WebUI.setText(findTestObject('Reference Data/Category Name'), findTestData('Configuration/Reference Data').getValue(
            1, 1))
	
	'Enter Lower bound'
    WebUI.setText(findTestObject('Reference Data/Lower Bound'), findTestData('Configuration/Reference Data').getValue(2, 
            1))

	'Enter Upper Bound'
    WebUI.setText(findTestObject('Reference Data/Upper bound'), findTestData('Configuration/Reference Data').getValue(3, 
            1))

	'Click on Save button'
    WebUI.click(findTestObject('Object Repository/Reference Data/Save Button client'))

    'Print message on console log'
    KeywordLogger log = new KeywordLogger()

    errormessage = WebUI.getText(findTestObject('Object Repository/Reference Data/Client Error Message'))

    log.logInfo(errormessage)

    if (errormessage.equalsIgnoreCase('Client category ranges created successfully')) {
        WebUI.delay(5)
    } else {
        System.out.println('Client doesnt added Message: ' + errormessage)
		
		'click on Close Button'
        WebUI.click(findTestObject('Object Repository/Reference Data/Close button client'))
    }
} else {
    System.out.println('Incorrect page')
}

