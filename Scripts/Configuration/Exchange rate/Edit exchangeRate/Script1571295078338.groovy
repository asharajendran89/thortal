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
import org.openqa.selenium.By as By
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.comment('Edit Exchange Rate')

'Login Test case'
WebUI.callTestCase(findTestCase('THORtal Login/login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

'Click on Configuration'
WebUI.click(findTestObject('Configurations/Configuration'))

WebUI.delay(5)

'Scroll upto Exchnage rate button'
WebUI.scrollToElement(findTestObject('Configurations/Exchange rate'), 0)

WebUI.delay(3)

'Click on Exchnage rate Button'
WebUI.click(findTestObject('Configurations/Exchange rate'))

WebUI.delay(2)

' Verify Exchange Rate page or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4205/configuration/exchange') {
    System.out.println('Congiguration/Exchnage Rate - page')

    WebUI.delay(3)
	
	
	//EDIT
	//To Locate Table
	WebDriver driver = DriverFactory.getWebDriver()

	WebUI.delay(5)

	'To find Size of Row'
	List rows = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-exchange-conf/div/div[2]/div/div/table/tbody/tr'))

	'To find Size of Column'
	List col = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-exchange-conf/div/div[2]/div/div/table/tbody/tr[1]/td'))

	'To Print Row Size'
	java.lang.System.out.println(rows.size())

	'To Print Column Size'
	java.lang.System.out.println(col.size())

if(WebUI.verifyTextPresent('No data available in table', false, FailureHandling.OPTIONAL)){
		System.out.println('No data available in table')
		
	}
	
	else{
		System.out.println('Data available in table')
		
	
	'Click on edit Exchnage rate Button'
    WebUI.click(findTestObject('Exchange Rate/Edit Exchange rate button'))

    WebUI.delay(3)
	
	'Enter DKK Value'
    WebUI.setText(findTestObject('Exchange Rate/DKK'), '9')

	'Enter EUR Value'
    WebUI.setText(findTestObject('Exchange Rate/EUR'), '1.15')

	'Enter GBP Value'
    WebUI.setText(findTestObject('Exchange Rate/GBP'), '1')

	'Enter NOK Value'
    WebUI.setText(findTestObject('Exchange Rate/NOK'), '10.5')

	'Enter SEK Value'
    WebUI.setText(findTestObject('Exchange Rate/SEK'), '10')

	'Enter SGD Value'
    WebUI.setText(findTestObject('Exchange Rate/SGD'), '1.7')

	'Enter USD Value'
    WebUI.setText(findTestObject('Exchange Rate/USD'), '1.35')
	
	'Click on Save Button'
   WebUI.click(findTestObject('Exchange Rate/Save Button'))
	
	'Print message on console log'
	KeywordLogger log = new KeywordLogger()

	errormessage = WebUI.getText(findTestObject('Object Repository/Exchange Rate/Error Message'))

	log.logInfo(errormessage)

	if (errormessage.equalsIgnoreCase('Exchange rate updated successfully')) {
		WebUI.delay(5)
	} else {
		System.out.println('Exchange rate Doesnt updated Message: ' + errormessage)
	}
	//'Click on Close button'
   // WebUI.click(findTestObject('Exchange Rate/Close Button'))
	}
} else {
    System.out.println('Incorrect page')
}

