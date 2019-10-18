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

'Scroll upto Commission button'
WebUI.scrollToElement(findTestObject('commission/Page_Thor/Commission'), 0)

WebUI.delay(3)

'Click on Commission Button'
WebUI.click(findTestObject('commission/Page_Thor/Commission'))

WebUI.delay(2)

' Verify Commission page or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4205/configuration/commission') {
    System.out.println('Congiguration/Commission- page')

    WebUI.delay(3)
	
	'Total options in dropdown count'
	YearTotalOption = WebUI.getNumberOfTotalOption(	findTestObject('Object Repository/commission/Page_Thor/Year dropdown'))
	
	'Printing Total dropdown options count'
	java.lang.System.out.println('No of  options : ' + YearTotalOption)
	
/*	'Checking Data exists in Dropdown or not'
	if (YearTotalOption >= 1) {
		WebUI.delay(5)
	
		'Clicking all the options '
		for (int YR = 0; YR <= (YearTotalOption-1); YR++) {
			WebUI.selectOptionByIndex(findTestObject('Object Repository/commission/Page_Thor/Year dropdown'), YR)*/
		
   //EDIT
    //To Locate Table
    WebDriver driver = DriverFactory.getWebDriver()

    WebUI.delay(5)

    'To find Size of Row'
    List rows = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-commission-conf/div/div[2]/div/div/table/tbody/tr'))

    'To find Size of Column'
    List col = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-commission-conf/div/div[2]/div/div/table/tbody/tr[1]/td'))

    'To Print Row Size'
    java.lang.System.out.println(rows.size())

    'To Print Column Size'
    java.lang.System.out.println(col.size())

    if(WebUI.verifyTextPresent('No data available in table', false, FailureHandling.OPTIONAL)){
		System.out.println('No data available in table')
		
	}
else{
	System.out.println('Data exists in table')
	
        'Generating Random Edit Within Row Size'
        Random rad = new Random()

        int rowscount = rad.nextInt(rows.size)

        WebUI.delay(5)

        'Click on Random Edit'
        driver.findElement(By.xpath(('html/body/app-root/app-layout/div/div/div/div/app-commission-conf/div/div[2]/div/div/table/tbody/tr[' + 
                rowscount) + ']/td[14]/a')).click()

        WebUI.delay(3)

        'Enter June Value'
        WebUI.setText(findTestObject('Object Repository/commission/Page_Thor/June'),'' )

        'Enter July Value'
        WebUI.setText(findTestObject('Object Repository/commission/Page_Thor/July'), '')

        'Enter August Value'
        WebUI.setText(findTestObject('Object Repository/commission/Page_Thor/August'),'' )

        'Enter September Value'
        WebUI.setText(findTestObject('Object Repository/commission/Page_Thor/September'),'')

        'Enter October Value'
        WebUI.setText(findTestObject('Object Repository/commission/Page_Thor/October'),'' )

        'Enter November Value'
        WebUI.setText(findTestObject('Object Repository/commission/Page_Thor/November'), '')

        'Enter December Value'
        WebUI.setText(findTestObject('Object Repository/commission/Page_Thor/December'),'' )

        'Enter January  Value'
        WebUI.setText(findTestObject('Object Repository/commission/Page_Thor/January'),'' )

        'Enter February  Value'
        WebUI.setText(findTestObject('Object Repository/commission/Page_Thor/Feburary'),'' )

        'Enter March Value'
        WebUI.setText(findTestObject('Object Repository/commission/Page_Thor/March'),'' )

        'Enter April Value'
        WebUI.setText(findTestObject('Object Repository/commission/Page_Thor/April'), '')

        'Enter May Value'
        WebUI.setText(findTestObject('Object Repository/commission/Page_Thor/May'), '')

        'Click on Update Button'

         WebUI.click(	findTestObject('Object Repository/commission/Page_Thor/button_Update'))
        'Click on Close Button'
       // WebUI.click(findTestObject('Object Repository/commission/Page_Thor/close button'))

        'Print message on console log'
        KeywordLogger log = new KeywordLogger()

        errormessage = WebUI.getText(findTestObject('Object Repository/commission/Page_Thor/Errror Message'))

        log.logInfo(errormessage)

        if (errormessage.equalsIgnoreCase('Exchange rate updated successfully')) {
            WebUI.delay(5)
        } //'Click on Close button'
        // WebUI.click(findTestObject('Exchange Rate/Close Button'))
        else {
            System.out.println('Exchange rate Doesnt updated Message: ' + errormessage)
        }
} }/*}
	else{
		
		java.lang.System.out.println('No options in Dropdown')
	}
} */
 else {
    System.out.println('Incorrect page')
}

