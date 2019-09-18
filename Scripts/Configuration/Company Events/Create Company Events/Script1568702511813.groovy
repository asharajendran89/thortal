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

WebUI.callTestCase(findTestCase('THORtal Login/login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

'click on Configuration'
WebUI.click(findTestObject('Configurations/Configuration'))

WebUI.delay(5)

'Scroll upto Company Events'
WebUI.scrollToElement(findTestObject('Company Events/Page_Thor/Company event button'), 0)

WebUI.delay(5)

'Click on comapany events button'
WebUI.click(findTestObject('Company Events/Page_Thor/Company event button'))

' Verify CompanyEvents page or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4204/configuration/company_events') {
    System.out.println('Congiguration/Company Events - page')

    WebUI.delay(5)
'Click on New Event'
    WebUI.click(findTestObject('Company Events/Page_Thor/New Event'))
'Enter Title'
    WebUI.setText(findTestObject('Company Events/Page_Thor/Event Title'), findTestData('Configuration/Comapny Events').getValue(
            1, 1))

    //Get the current system date
    mydate = new Date()

    formattedDate = mydate.format('dd/MM/yyy')
'Enter Date'
    WebUI.setText(findTestObject('Company Events/Page_Thor/Event Date'), formattedDate)
'Enter Start Hour'
    WebUI.setText(findTestObject('Company Events/Page_Thor/Start time HH'), findTestData('Configuration/Comapny Events').getValue(
            2, 1))
'ENter Start Minutes'
    WebUI.setText(findTestObject('Company Events/Page_Thor/Start Time MM'), findTestData('Configuration/Comapny Events').getValue(
            3, 1))
'Enter End Hour'
    WebUI.setText(findTestObject('Company Events/Page_Thor/End Time HH'), findTestData('Configuration/Comapny Events').getValue(
            4, 1))
'ENter End Minutes'
    WebUI.setText(findTestObject('Company Events/Page_Thor/End Time MM'), findTestData('Configuration/Comapny Events').getValue(
            5, 1))
'Enter Description'
    WebUI.setText(findTestObject('Company Events/Page_Thor/Description'), findTestData('Configuration/Comapny Events').getValue(
            6, 1))
'Click on save Button'
    WebUI.click(findTestObject('Company Events/Page_Thor/button_Save'))

    'Print message on console log'
    KeywordLogger log = new KeywordLogger()

    errormessage = WebUI.getText(findTestObject('Company Events/Page_Thor/Error message'))

    log.logInfo(errormessage)

    if (errormessage.equalsIgnoreCase('Event created successfully')) {
        WebUI.delay(5)

        'Search Created Event'
        WebUI.setText(findTestObject('Company Events/Page_Thor/Search'), findTestData('Configuration/Comapny Events').getValue(
                1, 1))

        WebUI.delay(3)

        'Checking whether Event is created or not'
        WebUI.verifyTextPresent(findTestData('Configuration/Comapny Events').getValue(1, 1), false, FailureHandling.OPTIONAL)
    } else {
        System.out.println('Event doesnt added Message: ' + errormessage)
    }
} else {
    System.out.println('Incorrect page')
}

WebUI.delay(3)
'Click on Dashboard button'
WebUI.click(findTestObject('Configurations/Dashboard'))

if (WebUI.getUrl() == 'http://192.168.0.28:4204/dashboard') {
	System.out.println('Dashboard- page')

	WebUI.delay(5)
	'Verifying whether it is dispalying in dashboard page or not'
	WebUI.verifyTextPresent(findTestData('Configuration/Comapny Events').getValue(1, 1), false, FailureHandling.OPTIONAL)
	
	
}
else {
	System.out.println('Incorrect page')
}