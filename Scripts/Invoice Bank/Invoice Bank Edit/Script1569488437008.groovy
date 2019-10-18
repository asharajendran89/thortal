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

//Call Login Page
WebUI.callTestCase(findTestCase('THORtal Login/login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(0)

WebUI.click(findTestObject('Configurations/Invoice Bank'))

'Print message on console log'
KeywordLogger log = new KeywordLogger()

' Verify Invoice Bank page or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4205/invoice') {
    System.out.println('Invoice Bank- page')

    //EDIT
    //To Locate Table
    WebDriver driver = DriverFactory.getWebDriver()

    WebUI.delay(5)

    'To find Size of Row'
    List rows = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-sales-log/div/form/div/app-data-table/div[1]/table/tbody/tr'))

    'To find Size of Column'
    List col = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-sales-log/div/form/div/app-data-table/div[1]/table/tbody/tr[1]/td'))

    'To Print Row Size'
    java.lang.System.out.println(rows.size())

    'To Print Column Size'
    java.lang.System.out.println(col.size())

    if (rows.size() >= 1) {
        System.out.println('Data Exists')

        'Generating Random Edit Within Row Size'
        Random rad = new Random()

        int rowscount = rad.nextInt(rows.size)

        WebUI.delay(5)

        'Click on Random Edit'
        driver.findElement(By.xpath(('html/body/app-root/app-layout/div/div/div/div/app-sales-log/div/form/div/app-data-table/div[1]/table/tbody/tr['+rowscount)+']/td[1]/div/div/span/i')).click()

        WebUI.delay(3)

        WebUI.click(findTestObject('Object Repository/Invoice Bank/Invoice Edit'))
		
		
		
		
		
		
		/*'Click on update button'
		WebUI.click(findTestObject('Clients/Page_Thor/Page_Thor/update button'))

		errormessage = WebUI.getText(findTestObject('Clients/Page_Thor/Page_Thor/error message'))

		log.logInfo(errormessage)

		if (errormessage.equalsIgnoreCase('Client details updated successfully')) {
			WebUI.delay(5)

			WebUI.delay(5)

			'Search Edited name'
			WebUI.setText(findTestObject('Clients/Page_Thor/Page_Thor/Search'), findTestData('Clients').getValue(6, 1))

			'Verify whether edited name is updated or not'
			WebUI.verifyTextPresent(findTestData('Clients').getValue(6, 1), false, FailureHandling.OPTIONAL)
		} else {
			System.out.println('Client doesnt updated  Message: ' + errormessage)
		}
		*/
		
		
    } else {
        System.out.println('No Data to Edit')
    }
} else {
    System.out.println('Incorrect page')
}

