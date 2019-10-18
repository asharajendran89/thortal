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

'Login Test case'
WebUI.callTestCase(findTestCase('THORtal Login/login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

'Click Configuration'
WebUI.click(findTestObject('Configurations/Configuration'))

WebUI.delay(3)

'scroll upto Targets button'
WebUI.scrollToElement(findTestObject('Configurations/Targets button'), 0)

WebUI.delay(3)

'Click on Targets button'
WebUI.click(findTestObject('Configurations/Targets button'))

WebUI.delay(3)

//Get the current system date
'Getting current date'
today = new Date()

todayDate = today.format('dd/MM/yyy')

'Getting Past date'
pdate = (today - 10)

pdate2 = pdate.format('dd/MM/yyy')

'Getting Future date'
futuredate = (today + 10)

futuredate2 = futuredate.format('dd/MM/yyy')

'Print message on console log'
KeywordLogger log = new KeywordLogger()

' Verify Targets page or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4205/configuration/targets') {
    System.out.println('Congiguration/Targets - page')

    WebUI.delay(3)

    'click on New targets button'
    WebUI.click(findTestObject('Targets/New Targets buttton'))

    WebUI.delay(3)

    'Enter Target Name'
    WebUI.setText(findTestObject('Targets/Targets Name'), findTestData('Configuration/Targets').getValue(7, 1))

    'Select Brand'
    WebUI.click(findTestObject('Targets/Allocated Brands'))

    'Search brand'
    WebUI.setText(findTestObject('Targets/Allocated Brands Search'), findTestData('Configuration/Targets').getValue(2, 1))

    'click on seacrhed brand'
    WebUI.click(findTestObject('Targets/Allocated Brands First'))

    WebUI.click(findTestObject('Targets/Allocated Brands'))

    'Enter Start date'
    WebUI.setText(findTestObject('Targets/Start Date'), pdate2)

    'Enter End Date'
    WebUI.setText(findTestObject('Targets/Page_Thor/end_date'), futuredate2)

    'Enter Total Target Amount'
    WebUI.setText(findTestObject('Targets/Total Target Amount'), findTestData('Configuration/Targets').getValue(3, 1))

    'Select Status'
    String Status = findTestData('Configuration/Targets').getValue(4, 1)

    WebUI.click(findTestObject('Targets/Status'))

    if (Status.equals('Active')) {
        WebUI.click(findTestObject('Object Repository/Targets/Status Active'))
    } else if (Status.equals('Inactive')) {
        WebUI.click(findTestObject('Object Repository/Targets/Status Inactive'))
    } else {
        WebUI.click(findTestObject('Object Repository/Targets/Status Future'))
    }
    
    'Select DealValue'
    String DealValue = findTestData('Configuration/Targets').getValue(5, 1)

    WebUI.click(findTestObject('Targets/Deal Value'))

    if (DealValue.equals('GP Written-Up')) {
        WebUI.click(findTestObject('Targets/Deal Value GP Written Up'))
    } else {
        WebUI.click(findTestObject('Targets/Deal Value GP Invoiced'))
    }
	//WebUI.uploadFile(findTestObject('Targets/Browser'), 'C:\\Users\\sambhavi\\Desktop\\Smiley-Thumbnail.png')
	
    'For keyboard actions'
    Robot rb = new Robot()

    WebUI.sendKeys(findTestObject('Object Repository/Targets/Deal Value'), Keys.chord(Keys.TAB))

    rb.keyRelease(KeyEvent.VK_DELETE)

    'Random generation of Levels'
    Random rad = new Random()

    int levels = rad.nextInt(5)

    System.out.println('Random Number : ' + levels)

    //int levels =5
    if (levels == 0) {
        y = (0 + 1)

        WebUI.setText(findTestObject('Object Repository/Targets/No of levels'), '' + y)

        WebUI.setText(findTestObject('Object Repository/Targets/Level1'), '5000')
    } else {
        WebUI.setText(findTestObject('Object Repository/Targets/No of levels'), '' + levels)

        if (levels == 1) {
            WebUI.setText(findTestObject('Object Repository/Targets/Level1'), '5000')
        } else if (levels == 2) {
            WebUI.setText(findTestObject('Object Repository/Targets/Level1'), '2000')

            WebUI.setText(findTestObject('Object Repository/Targets/Level2'), '3000')
        } else if (levels == 3) {
            WebUI.setText(findTestObject('Object Repository/Targets/Level1'), '1000')

            WebUI.setText(findTestObject('Object Repository/Targets/Level2'), '2000')

            WebUI.setText(findTestObject('Object Repository/Targets/level3'), '3000')
        } else if (levels == 4) {
            WebUI.setText(findTestObject('Object Repository/Targets/Level1'), '500')

            WebUI.setText(findTestObject('Object Repository/Targets/Level2'), '1000')

            WebUI.setText(findTestObject('Object Repository/Targets/level3'), '1500')

            WebUI.setText(findTestObject('Object Repository/Targets/level4'), '2000')
        } else {
            WebUI.setText(findTestObject('Object Repository/Targets/Level1'), '100')

            WebUI.setText(findTestObject('Object Repository/Targets/Level2'), '500')

            WebUI.setText(findTestObject('Object Repository/Targets/level3'), '1000')

            WebUI.setText(findTestObject('Object Repository/Targets/level4'), '1500')

            WebUI.setText(findTestObject('Object Repository/Targets/level5'), '1900')
        }
    }
    
    //EDIT
    //To Locate Table
    WebDriver driver = DriverFactory.getWebDriver()

    WebUI.delay(5)

    'To find Size of Row'
    List rows = driver.findElements(By.xpath('html/body/modal-container/div/div/form/div[2]/table/tbody/tr'))

    WebUI.delay(5)

    'To find Size of Column'
    List col = driver.findElements(By.xpath('html/body/modal-container/div/div/form/div[2]/table/tbody/tr[1]/td'))

    'To Print Row Size'
    java.lang.System.out.println(rows.size())

    'To Print Column Size'
    java.lang.System.out.println(col.size())

    if (rows.size() >= 1) {
        System.out.println('Data Exists')

        int rowscount = rad.nextInt(rows.size)

        'Enter Target Amount'
        WebUI.setText(findTestObject('Object Repository/Targets/amount'), '500', FailureHandling.OPTIONAL)
    } else {
        System.out.println('No Data to Enter')
    }
    
    'Click on Save Button'
    WebUI.click(findTestObject('Object Repository/Targets/Save'))

    //WebUI.click(findTestObject('Object Repository/Targets/Close')
    errormessage = WebUI.getText(findTestObject('Object Repository/Targets/error message'))

    log.logInfo(errormessage)

    if (errormessage.equalsIgnoreCase('Target successfully configured')) {
        WebUI.delay(5)

        'Search Created Target name'
        WebUI.setText(findTestObject('Object Repository/Targets/search'), findTestData('Configuration/Targets').getValue(
                1, 1))

        'Verify whether  target name is Created or not'
        WebUI.verifyTextPresent(findTestData('Configuration/Targets').getValue(1, 1), false, FailureHandling.OPTIONAL)
    } else {
        System.out.println('Target doesnt updated  Message: ' + errormessage)
    }
} else {
    System.out.println('Incorrect page')
}


