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
import java.awt.Robot;
import java.awt.event.KeyEvent;
//Call Login Page 
WebUI.callTestCase(findTestCase('THORtal Login/login'), [:], FailureHandling.STOP_ON_FAILURE)

//Get the current system date 
mydate = new Date()

formattedDate = mydate.format('dd/MM/yyy')

'Print message on console log'
KeywordLogger log = new KeywordLogger()

'Create New Deal'
WebUI.click(findTestObject('Configurations/Create New Deal'))

WebUI.delay(5)

'Select Thor Consultant'
WebUI.click(findTestObject('CreateNewDeal/Page_Thor/div_NS'))

WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Thor Consultant Search'), findTestData('Sales').getValue(2, 1))

WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Thor Consultant First'))

'Select Assisting Manager'
if (WebUI.verifyElementClickable(findTestObject('CreateNewDeal/Page_Thor/Assisting Manager'), FailureHandling.OPTIONAL)) {
    log.logInfo('--------- Assisting Manager element is not clickable  --------------')
} else {
    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Assisting Manager'))

    WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Assisting Manager Search'), 'AA')

    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/assisting Manager First'))
}

'Select Company'
String company = 'TC Inc'

WebUI.click(findTestObject('CreateNewDeal/Page_Thor/div_TC Inc'))

if (company.equals('TC Inc')) {
    log.logInfo('Already Selected')
} else if (company.equals('TC Ltd')) {
    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Page_Thor/li_TC Ltd'))
} else {
    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Page_Thor/li_TLS Ltd'))
}

'Select Deal Date'
WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/deal_date'), formattedDate)

'Select Brand'
WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Brand'))

WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Brand Search'), findTestData('Sales').getValue(6, 1))

WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Brand First'))

'Select Candidate Name'
WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Candidate Name'), findTestData('Sales').getValue(7, 1))

'Enter second grid details '

'Select Client'
WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Client'))

WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/client Search'), 'Aldesa')

WebUI.click(findTestObject('CreateNewDeal/Page_Thor/client First'))

'Select Contractor Type '
String a = findTestData('Sales').getValue(8, 1)

WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Contractor Type'))

if (a.equals('Contractor')) {
    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Contractor Type First'))

    'Invoice Rate'
    WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Invoice Rate'), findTestData('Sales').getValue(13, 1))

    'Candidate Rate'
    WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Candidate Rate'), findTestData('Sales').getValue(14, 1))

    'contract Days Worked '
    WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Contract Days Worked'), findTestData('Sales').getValue(16, 1))
} else if (a.equals('Permanent')) {
    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Contractor Type Second'))

    'Enter Billable Salary '
    WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Billable Salary'), findTestData('Sales').getValue(10, 1))

    'Thor Rate  '
    WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Thor Rate'), findTestData('Sales').getValue(12, 1))
} else {
    WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Contractor Type Third'))

    'Enter Billable Salary '
    WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Billable Salary'), findTestData('Sales').getValue(10, 1))

    'Thor Rate  '
    WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Thor Rate'), findTestData('Sales').getValue(12, 1))
}

'Select Sales Category'
WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Sales Category'))

WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Sales Category Search'), findTestData('Sales').getValue(9, 1))

WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Sales Category First'))

'Select Currency Type'
WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Currency'))

WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Currency Search'), findTestData('Sales').getValue(15, 1))

WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Currency First'))

'Expenses'
WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Expenses'), findTestData('Sales').getValue(17, 1))

'Expense Currency'
WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Expense Currency'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Expense Currency Search'), findTestData('Sales').getValue(18, 1))

WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Expense Currency First'))

'Scroll Down'
WebUI.scrollToElement(findTestObject('CreateNewDeal/Page_Thor/button_Save'), 3)

'Enter details to third Grid '

'Client Reference Number '
WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Client Reference Number'), findTestData('Sales').getValue(19, 1))

'Job Title'
WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Job Title'), findTestData('Sales').getValue(20, 1))

'Comments'
WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Comments'), findTestData('Sales').getValue(21, 1))

'Resgination Date'
WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/input_Resignation Date_resignation_date'), formattedDate)

'Start Date'
WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/input_Start Date_start_date'), formattedDate)

'Date Paperwork Signed'
WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Date Paperwork Signed'), formattedDate)

WebUI.sendKeys(findTestObject('CreateNewDeal/Page_Thor/Date Paperwork Signed'), Keys.chord(Keys.TAB))

'Invoice to be sent'
WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/input_Invoice to be sent_invoice_tobe_sent'), formattedDate)

WebUI.delay(5)


'Invoice Sent ?'
//use tab
WebUI.sendKeys(findTestObject('CreateNewDeal/Page_Thor/input_Invoice to be sent_invoice_tobe_sent'), Keys.chord(Keys.TAB))
Robot rb = new Robot()
rb.keyPress( KeyEvent.VK_SPACE );
rb.keyRelease(KeyEvent.VK_SPACE);
//WebUI.sendKeys(findTestObject('CreateNewDeal/Page_Thor/input_Invoice to be sent_invoice_tobe_sent'), Keys.chord(Keys.SPACE))

'Invoice Sent Date'
WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/input_Invoice Sent_invoice_sent_date'), formattedDate)

'Payment Terms'
WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/input_Payment Terms_form-control ng-pristine ng-valid ng-star-inserted ng-touched'), 
    findTestData('Sales').getValue(27, 1))


'Invoice Due Date'
WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/Invoice Due Date'), formattedDate)

'Invoice Paid?'
WebUI.sendKeys(findTestObject('CreateNewDeal/Page_Thor/Invoice Due Date'), Keys.chord(Keys.TAB))

rb.keyPress( KeyEvent.VK_SPACE );
rb.keyRelease(KeyEvent.VK_SPACE);
//WebUI.click(findTestObject('CreateNewDeal/Page_Thor/label_Invoice Paid_custom-control-label'))

'invoice Paid Date'
WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/input_Invoice Paid_invoice_paid_date'), formattedDate)

'Director Approval'
WebUI.sendKeys(findTestObject('CreateNewDeal/Page_Thor/input_Invoice Paid_invoice_paid_date'), Keys.chord(Keys.TAB))

rb.keyPress( KeyEvent.VK_SPACE );
rb.keyRelease(KeyEvent.VK_SPACE);
//WebUI.click(findTestObject('CreateNewDeal/Page_Thor/label_Director Approval'))

rb.mouseMove(1016 ,601); //move cursor over top URL ba

WebUI.delay(5)
/*
'Commission Paid'
//WebUI.click(findTestObject('CreateNewDeal/Page_Thor/Commission Paid'))

'VAT'
WebUI.click(findTestObject('CreateNewDeal/Page_Thor/label_VAT_custom-control-label'))

'VAT Amount'
WebUI.setText(findTestObject('CreateNewDeal/Page_Thor/input_VAT_form-control ng-untouched ng-pristine ng-star-inserted'), 
    formattedDate)
*/
'Generate InVoice'
WebUI.click(findTestObject('CreateNewDeal/Page_Thor/i_Invoice Number_dripicons-clockwise'))

WebUI.click(findTestObject('CreateNewDeal/Page_Thor/button_Save'))

WebUI.delay(5)

String sales = WebUI.getUrl()

if (sales.equals('http://192.168.0.28:4204/saleslog')) {
	
    log.logInfo('Deal Created Successfully')
} else {
WebUI.takeScreenshot()
}

