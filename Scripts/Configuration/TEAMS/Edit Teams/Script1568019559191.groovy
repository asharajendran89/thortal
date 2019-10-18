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
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

WebUI.comment('Edit TEAMS')

WebUI.callTestCase(findTestCase('THORtal Login/login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

'Click Configuration button'
WebUI.click(findTestObject('Teams/Page_Thor/span_Configuration'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

'Scroll upto TEAMS button'
WebUI.scrollToElement(findTestObject('Teams/Page_Thor/Teams button'), 0)

WebUI.delay(5)

'Click on TEAMS button'
WebUI.click(findTestObject('Teams/Page_Thor/Teams button'))

'Print message on console log'
KeywordLogger log = new KeywordLogger()

' Verify Clients page or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4205/configuration/teams') {
    System.out.println('Congiguration/Teams - page')

    WebUI.delay(3)

    //EDIT
    //To Locate Table
    WebDriver driver = DriverFactory.getWebDriver()

    WebUI.delay(5)

    'To find Size of Row'
    List rows = driver.findElements(By.xpath('.//*[@id="DataTables_Table_0"]/tbody/tr'))

    'To find Size of Column'
    List col = driver.findElements(By.xpath('.//*[@id="DataTables_Table_0"]/thead/tr/th'))

    'To Print Row Size'
    java.lang.System.out.println(rows.size())

    'To Print Column Size'
    java.lang.System.out.println(col.size())

    if (WebUI.verifyTextPresent('No data available in table', false, FailureHandling.OPTIONAL)) {
        System.out.println('No data available in table')
    } else if (rows.size() == 1) {
        System.out.println('Data Exists in table')

        WebUI.click(findTestObject('Object Repository/Teams/Page_Thor/Team data one'))

        WebUI.delay(3)

        'Edit Team Name '
        WebUI.setText(findTestObject('Teams/Page_Thor/Tname'), findTestData('Configuration/Teams Data').getValue(4, 1))

        'Click on Update button'
        WebUI.click(findTestObject('Teams/Page_Thor/Update button'))

        errormessage = WebUI.getText(findTestObject('Teams/Page_Thor/Error message'))

        log.logInfo(errormessage)

        if (errormessage.equalsIgnoreCase('Team updated successfully')) {
            WebUI.delay(5)

            'Search Edited name'
            WebUI.setText(findTestObject('Teams/Page_Thor/Team search'), findTestData('Configuration/Teams Data').getValue(
                    4, 1))

            'Verify whether edited name is updated or not'
            WebUI.verifyTextPresent(findTestData('Configuration/Teams Data').getValue(4, 1), false, FailureHandling.OPTIONAL)
        } else {
            System.out.println('Team doesnt updated  Message: ' + errormessage)
        }
    } else {
        System.out.println('Data Exists in table')

        'Generating Random Edit Within Row Size'
        Random rad = new Random()

        int rowscount = rad.nextInt(rows.size)

        WebUI.delay(5)

        'Click on Random Edit'
        driver.findElement(By.xpath(('.//*[@id="DataTables_Table_0"]/tbody/tr[' + rowscount) + ']/td[5]/a')).click()

        WebUI.delay(3)

        'Edit Team Name '
        WebUI.setText(findTestObject('Teams/Page_Thor/Tname'), findTestData('Configuration/Teams Data').getValue(4, 1))

        'Click on Update button'
        WebUI.click(findTestObject('Teams/Page_Thor/Update button'))

        errormessage = WebUI.getText(findTestObject('Teams/Page_Thor/Error message'))

        log.logInfo(errormessage)

        if (errormessage.equalsIgnoreCase('Team updated successfully')) {
            WebUI.delay(5)

            WebUI.delay(5)

            'Search Edited name'
            WebUI.setText(findTestObject('Teams/Page_Thor/Team search'), findTestData('Configuration/Teams Data').getValue(
                    4, 1))

            'Verify whether edited name is updated or not'
            WebUI.verifyTextPresent(findTestData('Configuration/Teams Data').getValue(4, 1), false, FailureHandling.OPTIONAL)
        } else {
            System.out.println('Team doesnt updated  Message: ' + errormessage)
        }
    }
} else {
    System.out.println('Incorrect page')
}

