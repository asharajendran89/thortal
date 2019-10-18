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

WebUI.comment('Edit Client Category')

'Calling Login Test case'
WebUI.callTestCase(findTestCase('THORtal Login/login'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Configuration Button'
WebUI.click(findTestObject('Configurations/Configuration'))

'Scroll upto Refernece Data'
WebUI.scrollToElement(findTestObject('Configurations/Reference Data'), 0)

'Click on Reference data button'
WebUI.click(findTestObject('Configurations/Reference Data'))

WebDriver driver = DriverFactory.getWebDriver()

'Generating Random Edit Within Row Size'
Random rad = new Random()

' Verify Reference Data or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4205/configuration/reference_data') {
	System.out.println('Congiguration/Reference Data - page')

	WebUI.delay(5)
	
	
		'Click on Client Category tab'
    WebUI.click(findTestObject('Object Repository/Reference Data/client category'))
	
		//EDIT
		//To Locate Table
		
		WebUI.delay(5)
	
		'To find Size of Row'
		List rows5 = driver.findElements(By.xpath('.//*[@id="clientCategory"]/div[2]/table/tbody/tr'))
	
		'To find Size of Column'
		List col5 = driver.findElements(By.xpath('.//*[@id="clientCategory"]/div[2]/table/tbody/tr[1]/td'))
	
		'To Print Row Size'
		java.lang.System.out.println(rows5.size())
	
		'To Print Column Size'
		java.lang.System.out.println(col5.size())
	
	   if(WebUI.verifyTextPresent('No data available in table', false, FailureHandling.OPTIONAL)){
			System.out.println('No data available in table')
			
		}
	   
	   else if(rows5.size() == 1) {
		   
		   System.out.println('Data Exists in table')
		   
		   WebUI.click( findTestObject('Object Repository/Reference Data/Client one data'))
		   
		   'Edit Category Name'
		   WebUI.setText(findTestObject('Reference Data/Category Name'), findTestData('Configuration/Reference Data').getValue(4, 1))
		   
		   WebUI.click(findTestObject('Object Repository/Reference Data/Update button Client'))
		   
		   'Print message on console log'
		   KeywordLogger log = new KeywordLogger()
	   
		   errormessage = WebUI.getText(findTestObject('Object Repository/Reference Data/Client Error Message'))
	   
		   log.logInfo(errormessage)
	   
		   if (errormessage.equalsIgnoreCase('Client category ranges updated successfully')) {
			   WebUI.delay(5)
		   } else {
			   System.out.println('Client doesnt added Message: ' + errormessage)
			   

		   }
		   
	   }
	   
	   else{
		   System.out.println('Data Exists in table')
		   
			int rowscount5 = rad.nextInt(rows5.size)
	
			WebUI.delay(5)
	
			'Click on Random Edit'
			driver.findElement(By.xpath(('.//*[@id="clientCategory"]/div[2]/table/tbody/tr['+rowscount5)+']/td[6]/a')).click()
			WebUI.delay(3)
			
			
			'Edit Category Name'
			WebUI.setText(findTestObject('Reference Data/Category Name'), findTestData('Configuration/Reference Data').getValue(4, 1))
			
			WebUI.click(findTestObject('Object Repository/Reference Data/Update button Client'))
			
			'Print message on console log'
			KeywordLogger log = new KeywordLogger()
		
			errormessage = WebUI.getText(findTestObject('Object Repository/Reference Data/Client Error Message'))
		
			log.logInfo(errormessage)
		
			if (errormessage.equalsIgnoreCase('Client category ranges updated successfully')) {
				WebUI.delay(5)
			} else {
				System.out.println('Client doesnt added Message: ' + errormessage)
				

			}
			
		}
} else {
System.out.println('Incorrect page')
}

