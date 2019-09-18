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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

WebUI.callTestCase(findTestCase('THORtal Login/login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

'Click on Configuration'
WebUI.click(findTestObject('Configurations/Configuration'))

WebUI.delay(5)

'Scroll upto clients button'
WebUI.scrollToElement(findTestObject('Clients/Page_Thor/Page_Thor/Client button'), 0)

WebUI.delay(5)

'Click on client button'
WebUI.click(findTestObject('Clients/Page_Thor/Page_Thor/Client button'))

' Verify Clients page or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4204/configuration/clients') {
    System.out.println('Congiguration/Clients - page')

    WebUI.delay(5)

    'Click on New clientbutton'
    WebUI.click(findTestObject('Object Repository/Clients/Page_Thor/Page_Thor/button_New Client'))

    'Enter Client Name'
    WebUI.setText(findTestObject('Clients/Page_Thor/Page_Thor/ClientName'), findTestData('Clients').getValue(1, 1))

    'Enter VAT Number'
    WebUI.setText(findTestObject('Clients/Page_Thor/Page_Thor/Client_vat_number'), findTestData('Clients').getValue(2, 1))

    'Select VAT Status'
    String company = '20%'

    WebUI.click(findTestObject('Clients/Page_Thor/Page_Thor/VAT Status dropdown'))

    if (company.equalsIgnoreCase('Zero Rated')) {
        WebUI.click(findTestObject('Clients/Page_Thor/VAT Status Zero Rated'))
    } else if (company.equalsIgnoreCase('Reverse Charge Applies')) {
        WebUI.click(findTestObject('Clients/Page_Thor/VAT Status Reverse Charge Applies'))
    } else {
        WebUI.click(findTestObject('Clients/Page_Thor/VAT Status 20'))
    }
    
    'Enter Contact Name'
    WebUI.setText(findTestObject('Clients/Page_Thor/Page_Thor/Page_Thor/Contact Name'), findTestData('Clients').getValue(
            3, 1))

    'Enter Contact Email ID'
    WebUI.setText(findTestObject('Clients/Page_Thor/Page_Thor/Page_Thor/Contact Email'), findTestData('Clients').getValue(
            4, 1))

    'Enter Postal Address'
    WebUI.setText(findTestObject('Clients/Page_Thor/Page_Thor/Page_Thor/Contact postal address'), findTestData('Clients').getValue(
            5, 1))

    'Perform keyboard actions'
    Robot rb = new Robot()

    'Check  Status'
    WebUI.sendKeys(findTestObject('Clients/Page_Thor/Page_Thor/Page_Thor/Contact postal address'), Keys.chord(Keys.TAB))

    rb.keyPress(KeyEvent.VK_SPACE)

    rb.keyRelease(KeyEvent.VK_SPACE)

    /*rb.keyPress(KeyEvent.VK_TAB);
rb.keyRelease(KeyEvent.VK_TAB);

rb.keyPress(KeyEvent.VK_ENTER);
rb.keyRelease(KeyEvent.VK_ENTER);*/
    WebUI.delay(5)

    'Click on ' + ' icon'

    WebUI.click(findTestObject('Clients/Page_Thor/Page_Thor/plus icon'))

    'Click on ' - ' Icon'

    WebUI.click(findTestObject('Clients/Page_Thor/Page_Thor/minus button'))

    'Click on save button'
    WebUI.click(findTestObject('Clients/Page_Thor/Page_Thor/button_Save'))

    'Print message on console log'
    KeywordLogger log = new KeywordLogger()

    errormessage = WebUI.getText(findTestObject('Clients/Page_Thor/Page_Thor/error message'))

    log.logInfo(errormessage)

    if (errormessage.equalsIgnoreCase('Client added successfully')) {
        WebUI.delay(5)

        'Search Created client'
        WebUI.setText(findTestObject('Clients/Page_Thor/Page_Thor/Search'), findTestData('Clients').getValue(1, 1))

        WebUI.delay(3)

        'Checking whether client is created or not'
        WebUI.verifyTextPresent(findTestData('Clients').getValue(1, 1), false, FailureHandling.OPTIONAL)
    } else {
        System.out.println('Client doesnt added Message: ' + errormessage)
    }
} else {
    System.out.println('Incorrect page')
}

