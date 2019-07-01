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

'Open browser'
WebUI.openBrowser('http://192.168.0.28:4204/login')

'Maximize the opened browser'
WebUI.maximizeWindow()

'Print message on console log'
KeywordLogger log = new KeywordLogger()

'Check whether User Name field exists or not'
try {
    log.logInfo('---------User Name exists --------------')

    WebUI.setText(findTestObject('Login/User Name'), 'nick')
}
catch (Throwable e) {
    log.logInfo('User Name not found: ' + e.getMessage())
} 

'Check whether Password field exists or not'
try {
    log.logInfo('---------password exists --------------')

    WebUI.setEncryptedText(findTestObject('Login/Password'), 'AdUMoLaE2tWuHJEBZev0OA==')
}
catch (Throwable e) {
    log.logInfo('Password not found: ' + e.getMessage())
} 

'Check whether Log In button exists or not'
try {
    log.logInfo('---------Log In  exists --------------')

    WebUI.click(findTestObject('Login/Log In'))
}
catch (Throwable e) {
    log.logInfo('Log In not found: ' + e.getMessage())

  } 

WebUI.delay(5)

'Check if login was proper or not'
currentpageurl = WebUI.getUrl()

if (!(currentpageurl.equals('http://192.168.0.28:4204/dashboard'))) {
    errormessage = WebUI.getText(findTestObject('Login/errormessage'))
	log.logInfo(errormessage)
} else {
    log.logInfo('--------- Sucessfull Log In --------------')
}

