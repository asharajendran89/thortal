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

WebUI.callTestCase(findTestCase('login'), [:], FailureHandling.STOP_ON_FAILURE)

'Click Configuration'
WebUI.click(findTestObject('Configurations/Configuration'))

'Click Employee'
WebUI.click(findTestObject('Configurations/Employees'))

WebUI.delay(3)

'Click New Employee'
WebUI.click(findTestObject('Employees/New Employee'))

'First Name'
WebUI.setText(findTestObject('Employees/First Name'), findTestData('Employees').getValue(6, 1))

'Last name'
WebUI.setText(findTestObject('Employees/Last Name'), findTestData('Employees').getValue(7, 1))

'Emp Code'
WebUI.setText(findTestObject('Employees/Emp Code'), 'Team')
//WebUI.setText(findTestObject('Employees/Emp Code'), findTestData('Employees').getValue(8, 1))

'Username'
WebUI.setText(findTestObject('Employees/User Name'), findTestData('Employees').getValue(9, 1))

WebUI.setEncryptedText(findTestObject('Employees/Password'), 'AdUMoLaE2tWuHJEBZev0OA==')

'Password'

//WebUI.setEncryptedText(findTestObject('Employees/Password'), findTestData('Employees').getValue(10, 1))
'select role'
WebUI.click(findTestObject('Employees/Role'))

//WebUI.setText(findTestObject('Employees/Role Search'), findTestData('Employees').getValue(2, 1))

WebUI.setText(findTestObject('Employees/Role Search'), 'Resourcer')

WebUI.click(findTestObject('Employees/Role First'))

'Print message on console log'
KeywordLogger log = new KeywordLogger()

'Select Company'
String company = 'TC Ltd'

WebUI.click(findTestObject('Employees/Company'))

if (company.equals('TC Inc')) {
    WebUI.click(findTestObject('Employees/Company First'))
} else if (company.equals('TC Ltd')) {
    WebUI.click(findTestObject('Employees/Company Second'))
} else {
    WebUI.click(findTestObject('Employees/Company Third'))
}

'Select Brand'
WebUI.click(findTestObject('Employees/Brand'))

WebUI.setText(findTestObject('Employees/Brand Search'), findTestData('Employees').getValue(3, 1))

WebUI.click(findTestObject('Employees/Brand First'))

'select teams'
WebUI.click(findTestObject('Employees/Teams'))

WebUI.setText(findTestObject('Employees/Teams Search'), 'Team Other')

WebUI.click(findTestObject('Employees/Teams First'))

today = new Date()

todayDate = today.format('dd/MM/yyy')

yesterday = (today + 1)

reportDate = yesterday.format('dd/MM/yyy')

'Start date'
WebUI.setText(findTestObject('Employees/Start Date'), todayDate)

//date.getDate()
'Leave Date'
WebUI.setText(findTestObject('Employees/Leave Date'), reportDate)

'click save button'
WebUI.click(findTestObject('Employees/Save'))

//WebUI.delay(5)

//assert WebUI.getText(findTestObject('Employees/Employee Validation')) == 'Employees are created successfully '



