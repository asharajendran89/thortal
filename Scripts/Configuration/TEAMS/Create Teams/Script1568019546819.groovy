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

WebUI.comment('Create Teams')

WebUI.callTestCase(findTestCase('THORtal Login/login'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Configuration button'
WebUI.click(findTestObject('Teams/Page_Thor/span_Configuration'))

WebUI.delay(5)

'Scroll upto Teams button'
WebUI.scrollToElement(findTestObject('Teams/Page_Thor/Teams button'), 0)

WebUI.delay(3)

'Click on Teams button'
WebUI.click(findTestObject('Teams/Page_Thor/Teams button'))

WebUI.delay(3)

'Print message on console log'
KeywordLogger log = new KeywordLogger()

' Verify Clients page or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4205/configuration/teams') {
    System.out.println('Congiguration/Teams - page')

    'Click on New Teams Button'
    WebUI.click(findTestObject('Teams/Page_Thor/button_New Team'))

    WebUI.delay(3)

    'Enter Teams Name'
    WebUI.setText(findTestObject('Object Repository/Teams/Page_Thor/Tname'), findTestData('Configuration/Teams Data').getValue(
            1, 1))

    WebUI.delay(3)

    'Click on Brand dropdown'
    WebUI.click(findTestObject('Teams/Page_Thor/div_Brand'))

    WebUI.delay(0)

    'Search dropdown value'
    WebUI.setText(findTestObject('Teams/Page_Thor/Brand Search'), findTestData('Configuration/Teams Data').getValue(2, 1))

    WebUI.delay(0)

    'Select drodown value through search'
    WebUI.click(findTestObject('Teams/Page_Thor/Brand first'))

    'Click on save button'
    WebUI.click(findTestObject('Teams/Page_Thor/button_Save'))

    errormessage = WebUI.getText(findTestObject('Teams/Page_Thor/Error message'))

    log.logInfo(errormessage)

    if (errormessage.equalsIgnoreCase('Team created successfully')) {
        WebUI.delay(5)

        'Search Team Name'
        WebUI.setText(findTestObject('Teams/Page_Thor/Team search'), findTestData('Configuration/Teams Data').getValue(1, 
                1))

        'Check Whether the Team is created or not'
        WebUI.verifyTextPresent(findTestData('Configuration/Teams Data').getValue(1, 1), false, FailureHandling.OPTIONAL)
    } else {
        System.out.println('Team doesnt added Message: ' + errormessage)
    }
} else {
    System.out.println('Incorrect page')
}

