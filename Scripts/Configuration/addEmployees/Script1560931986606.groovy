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
import org.openqa.selenium.Keys as Keys
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

'Call Login Testcase'
WebUI.callTestCase(findTestCase('THORtal Login/login'), [:], FailureHandling.STOP_ON_FAILURE)

'Click Configuration'
WebUI.click(findTestObject('Configurations/Configuration'))

WebUI.delay(5)

WebUI.scrollToElement(findTestObject('Configurations/Employees'), 0)

WebUI.delay(5)

'Click Employees on Configuration'
WebUI.click(findTestObject('Configurations/Employees'))

WebUI.delay(3)

'Click New Employee'
WebUI.click(findTestObject('Employees/New Employee'))

'Enter the required details to create new employee'
WebUI.delay(3)

'First name'
WebUI.setText(findTestObject('Employees/First Name'), findTestData('Employee data/Employee Internal data').getValue(1, 1))

'Last name'
WebUI.setText(findTestObject('Employees/Last Name'), findTestData('Employee data/Employee Internal data').getValue(2, 1))

//WebUI.setText(findTestObject('Employees/Emp Code'), findTestData('Employees').getValue(8, 1))
'Emp Code'
WebUI.setText(findTestObject('Employees/Emp Code'), findTestData('Employee data/Employee Internal data').getValue(3, 1))

'User name'
WebUI.setText(findTestObject('Employees/User Name'), findTestData('Employee data/Employee Internal data').getValue(4, 1))

'Password'
WebUI.setText(findTestObject('Employees/Password'), findTestData('Employee data/Employee Internal data').getValue(5, 1))

'Select role'
WebUI.click(findTestObject('Employees/Role'))

WebUI.setText(findTestObject('Employees/Role Search'), findTestData('Employee data/Employee Internal data').getValue(6, 
        1))

WebUI.click(findTestObject('Employees/Role First'))

'Enable/Disable Business Developer based on Y or N in excel'
business = findTestData('Employee data/Employee Internal data').getValue(11, 1)

'Perform keyboard actions'
Robot rb = new Robot()

if (business.equalsIgnoreCase('Y')) {
    WebUI.sendKeys(findTestObject('Employees/Role'), Keys.chord(Keys.TAB))

    rb.keyPress(KeyEvent.VK_SPACE)

    rb.keyRelease(KeyEvent.VK_SPACE)
}

'Select Company'
String company = 'TC Ltd'

WebUI.click(findTestObject('Employees/Company'))

if (company.equalsIgnoreCase('TC Inc')) {
    WebUI.click(findTestObject('Employees/Company First'))
} else if (company.equalsIgnoreCase('TC Ltd')) {
    WebUI.click(findTestObject('Employees/Company Second'))
} else {
    WebUI.click(findTestObject('Employees/Company Third'))
}

'Select Brand'
WebUI.click(findTestObject('Employees/Brand'))

//WebUI.setText(findTestObject('Employees/Brand Search'), findTestData('Employees').getValue(3, 1))
WebUI.setText(findTestObject('Employees/Brand Search'), findTestData('Employee data/Employee Internal data').getValue(8, 
        1))

WebUI.click(findTestObject('Employees/Brand First'))

WebUI.delay(5)

//WebUI.click(findTestObject('Employees/Teams Label'))

/*WebUI.click(findTestObject('Employees/Teams'))

WebUI.setText(findTestObject('Employees/Teams Search'), 'Team Other')

WebUI.click(findTestObject('Employees/Teams First'))
*/
'Select Start Date and Leave Date'
today = new Date()

todayDate = today.format('dd/MM/yyy')

'Start date'
WebUI.setText(findTestObject('Employees/Start Date'), todayDate)

yesterday = (today + 1)

reportDate = yesterday.format('dd/MM/yyy')

'Leave Date'
WebUI.setText(findTestObject('Employees/Leave Date'), reportDate)

'Enable/Disable Business Developer based on Y or N in excel'
billable= findTestData('Employee data/Employee Internal data').getValue(12, 1)


if (billable.equalsIgnoreCase('Y')) {
	WebUI.sendKeys(findTestObject('Employees/Leave Date'), Keys.chord(Keys.TAB))

	rb.keyPress(KeyEvent.VK_SPACE)

	rb.keyRelease(KeyEvent.VK_SPACE)
}


WebUI.setText(findTestObject('Employees/Email'), findTestData('Employee data/Employee Internal data').getValue(10, 1))



'Enable/Disable Business Developer based on Y or N in excel'
EnableCTE= findTestData('Employee data/Employee Internal data').getValue(13, 1)


if (EnableCTE.equalsIgnoreCase('Y')) {
	WebUI.sendKeys(findTestObject('Employees/Email'), Keys.chord(Keys.TAB))

	rb.keyPress(KeyEvent.VK_SPACE)

	rb.keyRelease(KeyEvent.VK_SPACE)
	WebUI.setText(findTestObject('Employees/CTE Role'), findTestData('Employee data/Employee Internal data').getValue(14, 1))
	
}

'Enable/Disable Business Developer based on Y or N in excel'
showcontact= findTestData('Employee data/Employee Internal data').getValue(15, 1)


if (showcontact.equalsIgnoreCase('Y')) {
	WebUI.sendKeys(findTestObject('Employees/CTE Role'), Keys.chord(Keys.TAB))
	
	
	rb.keyPress(KeyEvent.VK_SPACE)

	rb.keyRelease(KeyEvent.VK_SPACE)
	
}
'click save button'
WebUI.click(findTestObject('Employees/Save'))

WebUI.delay(5)

WebUI.setText(findTestObject('Employees/Search'), findTestData('Employee data/Employee Internal data').getValue(3, 1))

WebUI.verifyTextPresent(findTestData('Employee data/Employee Internal data').getValue(3, 1), false)

