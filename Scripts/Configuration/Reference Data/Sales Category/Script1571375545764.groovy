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

WebUI.comment('Sales Category')

'calling login Test case'
WebUI.callTestCase(findTestCase('THORtal Login/login'), [:], FailureHandling.STOP_ON_FAILURE)

'click on Configuration Button'
WebUI.click(findTestObject('Configurations/Configuration'))

'Scroll upto Reference Data button'
WebUI.scrollToElement(findTestObject('Configurations/Reference Data'), 0)

'click Reference Data button'
WebUI.click(findTestObject('Configurations/Reference Data'))

WebDriver driver = DriverFactory.getWebDriver()

'Generating Random Edit Within Row Size'
Random rad = new Random()

' Verify Reference Data or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4205/configuration/reference_data') {
    System.out.println('Congiguration/Reference Data - page')

    WebUI.delay(5)
	
		WebUI.click( findTestObject('Object Repository/Reference Data/sales Caetgory'))
	
		//EDIT
		//To Locate Table
		
		WebUI.delay(5)
	
		'To find Size of Row'
		List rows4 = driver.findElements(By.xpath('.//*[@id="salesCategory"]/div/table/tbody/tr'))
	
		'To find Size of Column'
		List col4 = driver.findElements(By.xpath('.//*[@id="salesCategory"]/div/table/tbody/tr[1]/td'))
	
		'To Print Row Size'
		java.lang.System.out.println(rows4.size())
	
		'To Print Column Size'
		java.lang.System.out.println(col4.size())
	
	   if(WebUI.verifyTextPresent('No data available in table', false, FailureHandling.OPTIONAL)){
			System.out.println('No data available in table')
			
		}
	   else{
		   System.out.println('Data Exists in table')
		   
			int rowscount4 = rad.nextInt(rows4.size)
	
			WebUI.delay(5)
	
			'Click on Random Edit'
			driver.findElement(By.xpath(('.//*[@id="salesCategory"]/div/table/tbody/tr['+rowscount4)+']/td[3]/a')).click()
			WebUI.delay(3)
			
			'Enter Category Value'
			WebUI.setText(findTestObject('Object Repository/Reference Data/Category Value'), '')

			'Click on save button'
			 WebUI.click(findTestObject('Object Repository/Reference Data/Save button sales'))
			
			  'Print message on console log'
			 KeywordLogger log = new KeywordLogger()
		 
			 errormessage = WebUI.getText(findTestObject('Object Repository/Reference Data/error message sales'))
		 
			 log.logInfo(errormessage)
		 
			 if (errormessage.equalsIgnoreCase('Sales Category updated successfully')) {
				 WebUI.delay(5)
			 } else {
				 System.out.println('Contract Type didnt updated Message: ' + errormessage)
				 
				 'Click on close button'
			WebUI.click(findTestObject('Object Repository/Reference Data/close sales'))
				 
	
			 }
			
			
		}
		
} else {
System.out.println('Incorrect page')
}
