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

WebUI.comment('Contract Type')

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


    'To find Size of Row'
    List rows = driver.findElements(By.xpath('.//*[@id="contractType"]/div/table/tbody/tr[1]/td'))

    'To find Size of Column'
    List col = driver.findElements(By.xpath('.//*[@id="contractType"]/div/table/tbody/tr'))

    'To Print Row Size'
    java.lang.System.out.println(rows.size())

    'To Print Column Size'
    java.lang.System.out.println(col.size())

    if (WebUI.verifyTextPresent('No data available in table', false, FailureHandling.OPTIONAL)) {
        System.out.println('No data available in table')
    } else {
        System.out.println('Data Exists in table')

        int rowscount = rad.nextInt(rows.size)

        WebUI.delay(5)

        'Click on Random Edit'
        driver.findElement(By.xpath(('.//*[@id="contractType"]/div/table/tbody/tr[' + rowscount) + ']/td[3]/a')).click()

        WebUI.delay(5)

		'Enter Contractor Name'
		WebUI.setText(findTestObject('Reference Data/Contract Name'), '')
		
		'Click on save button'
		 WebUI.click(findTestObject('Object Repository/Reference Data/Save Button Contract type'))
		
		 'Print message on console log'
		 KeywordLogger log = new KeywordLogger()
	 
		 errormessage = WebUI.getText(findTestObject('Object Repository/Reference Data/Error message contract type'))
	 
		 log.logInfo(errormessage)
	 
		 if (errormessage.equalsIgnoreCase('Contract Type updated successfully')) {
			 WebUI.delay(5)
		 } else {
			 System.out.println('Contract Type didnt updated Message: ' + errormessage)
			 
			 'Click on close button'
			 WebUI.click(findTestObject('Reference Data/Close button'))
			 

		 }
		 
    }
} else {
    System.out.println('Incorrect page')
}


