import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import org.openqa.selenium.Keys as Keys
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
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

//Call Login Page
WebUI.comment('Creating deal with "Director Approval" which effects in "Invoice Bank "')

WebUI.callTestCase(findTestCase('THORtal Login/login'), [:], FailureHandling.STOP_ON_FAILURE)

//Get the current system date
'Current date'
today = new Date()

todayDate = today.format('dd/MM/yyy')

'Getting past date'
pastdate = (today - 5)

pastdate2 = pastdate.format('dd/MM/yyy')

'Getting future date'
futuredate = (today + 5)

futuredate2 = futuredate.format('dd/MM/yyy')

'For keyboard actions'
Robot rb = new Robot()

'Print message on console log'
KeywordLogger log = new KeywordLogger()

'Create New Deal'
WebUI.click(findTestObject('Configurations/Create New Deal'))

' Verify Create Deals page or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4205/saleslogs/new/parent') {
    System.out.println('Create New Deal - page')

    WebUI.delay(5)

    'Select Thor Consultant'
    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/div_NS'))

    WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Thor Consultant Search'), findTestData('Create New Deal').getValue(1, 1))

    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Thor Consultant First'))

    'Select Company'
    String company = 'TC Ltd'

    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Company'))

    if (company.equals('TC Inc')) {
        log.logInfo('Already Selected')
    } else if (company.equals('TC Ltd')) {
        WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Page_Thor/li_TC Ltd'))
    } else {
        WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Page_Thor/li_TLS Ltd'))
    }
    
    WebUI.delay(3)

    'Select Brand'
    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/brand main'))

    WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Brand search'), findTestData('Create New Deal').getValue(2, 1))

    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Brand first'))

    WebUI.delay(3)

    /*'Select Assisting Manager'
if (WebUI.verifyElementClickable(findTestObject('Object Repository/CreateNewDeal/Page_Thor/Main/Assisting manager'), FailureHandling.OPTIONAL)) {
	System.out.println('--------- Assisting Manager element is not clickable  --------------')
} else {
	WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Assisting manager'))

	WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Assisting Manager Search'), 'SU')

	WebUI.click(findTestObject('CreateNewDeal/Page_Thor/assisting Manager First'))
}*/
    'Select Deal Date'
    WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/deal_date'), todayDate)

    'Enter second grid details '

    'Select Candidate Name'
    WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Candidate Name'), findTestData('Create New Deal').getValue(3, 1))

    WebUI.delay(3)

    'Select Client'
    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Client'))

    WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/client Search'), 'dfff')

    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/client First'))

    'Select Currency Type'
    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Currency'))

    WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Currency search'), findTestData('Create New Deal').getValue(13, 1))

    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Currency first'))

    WebUI.delay(3)

    'Select Contractor Type '
    String a = findTestData('Create New Deal').getValue(4, 1)

    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Contract Type'))

    'Contractor'
    if (a.equals('Contractor')) {
        WebUI.delay(3)

        WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Contractor first'))

        WebUI.delay(3)

        'Select Sales Category'
        WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Page_Thor/div_Sales Category'))

        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/sales category search'), findTestData('Create New Deal').getValue(
                8, 1))

        WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Sales first'))

        'Enable days/Hours'
        WebUI.sendKeys(findTestObject('CreateNewDeal/Page_Thor/Main/Page_Thor/div_Sales Category'), Keys.chord(Keys.TAB))

        rb.keyPress(KeyEvent.VK_SPACE)

        rb.keyRelease(KeyEvent.VK_SPACE)

        'Invoice Rate'
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Invoice rate'), findTestData('Create New Deal').getValue(5, 1))

        'Candidate Rate'
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Candidate rate'), findTestData('Create New Deal').getValue(6, 
                1))

        'contract Days Worked '
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Contract days worked'), findTestData('Create New Deal').getValue(
                7, 1))

        'Enable CTE'
        WebUI.sendKeys(findTestObject('CreateNewDeal/Page_Thor/Main/Contract days worked'), Keys.chord(Keys.TAB))

        rb.keyPress(KeyEvent.VK_SPACE)

        rb.keyRelease(KeyEvent.VK_SPACE)

        'Random Email Generation'
        Random rad = new Random()

        int Email = rad.nextInt(2000)

        'Enter Candidate Email'
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Candidate Email'), ('Automationtest' + Email) + '@gmail.com')

        'Expenses'
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Expenses'), findTestData('Create New Deal').getValue(14, 1))

        'Expense Currency'
        WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Expence currency'), FailureHandling.STOP_ON_FAILURE)

        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Expence search'), findTestData('Create New Deal').getValue(13, 
                1))

        WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/expense first'))

        'Enter details to third Grid '

        'Start Date'
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Start Dtae'), pastdate2)

        'End Date'
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/End date'), futuredate2)

        'Invoice to be sent Date'
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Invoice to be sent'), todayDate) //Permenant
        //Retainer
    } else if (a.equals('Permanent')) {
        WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Contract type-2'))

        'Select Sales Category'
        WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Page_Thor/div_Sales Category'))

        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/sales category search'), findTestData('Create New Deal').getValue(
                9, 1))

        WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Sales first'))

        'Enter Billable Salary '
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Billable salaary'), findTestData('Create New Deal').getValue(11, 
                1))

        'Thor Rate  '
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Thor Rate'), findTestData('Create New Deal').getValue(12, 1))

        'Enter details to third Grid '

        'Start Date'
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Start Dtae'), pastdate2)

        'Invoice to be sent Date'
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Invoice to be sent'), todayDate)
    } else {
        WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Contract type -3'))

        'Select Sales Category'
        WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Page_Thor/div_Sales Category'))

        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/sales category search'), findTestData('Create New Deal').getValue(
                10, 1))

        WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Sales first'))

        'Enter Billable Salary '
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Billable salaary'), findTestData('Create New Deal').getValue(11, 
                1))

        'Thor Rate  '
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Thor Rate'), findTestData('Create New Deal').getValue(12, 1))

        'Enter details to third Grid '

        'Start Date'
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Start Dtae'), pastdate2)

        'Invoice to be sent Date'
        WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Invoice to be sent'), todayDate)
    }
    
    'Invoice to be sent'
    WebUI.sendKeys(findTestObject('CreateNewDeal/Page_Thor/Main/Invoice to be sent'), Keys.chord(Keys.TAB))

    rb.keyPress(KeyEvent.VK_SPACE)

    rb.keyRelease(KeyEvent.VK_SPACE)

    'Invoice Number'
    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Invoice Number'))

    'Director Approval'
    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Client reference number'))

    WebUI.sendKeys(findTestObject('CreateNewDeal/Page_Thor/Main/Client reference number'), Keys.chord(Keys.TAB))

    rb.keyPress(KeyEvent.VK_SPACE)

    rb.keyRelease(KeyEvent.VK_SPACE)

    'Click on Save button'
    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Main/Save'))

    errormessage = WebUI.getText(findTestObject('Object Repository/CreateNewDeal/Page_Thor/Main/error messgae'))

    log.logInfo(errormessage)

    if (errormessage.equalsIgnoreCase('Deal created successfully')) {
        WebUI.delay(5)

        ' Verify Sales log page or not'
        if (WebUI.getUrl() == 'http://192.168.0.28:4205/saleslog') {
            System.out.println('Sales log - page')

            'Search Created Deal'
            WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Main/Search'), findTestData('Create New Deal').getValue(3, 1))

            WebUI.delay(3)

            'Checking whether Deal is created or not'
            WebUI.verifyTextPresent(findTestData('Create New Deal').getValue(3, 1), false, FailureHandling.OPTIONAL)

            WebUI.delay(3)

            'Click on Invoice bank'
            WebUI.click(findTestObject('Configurations/Invoice Bank'))

            ' Verify Invoice bank page or not'
            if (WebUI.getUrl() == 'http://192.168.0.28:4205/invoice') {
                System.out.println('Invoice Bank - page')

                'Search Director approval Deal'
                WebUI.setText(findTestObject('Object Repository/CreateNewDeal/Page_Thor/Invoice search'), findTestData('Create New Deal').getValue(
                        3, 1))

                WebUI.delay(3)

                'Checking whether Director approval  Deal exists or not'
                WebUI.verifyTextPresent(findTestData('Create New Deal').getValue(3, 1), false, FailureHandling.OPTIONAL)
            } else {
                System.out.println('Incorrect page')
            }
        } else {
            System.out.println('Incorrect page')
        }
    } else {
        System.out.println('Deal doesnt Created Message: ' + errormessage)
    }
} else {
    System.out.println('Incorrect page')
}

