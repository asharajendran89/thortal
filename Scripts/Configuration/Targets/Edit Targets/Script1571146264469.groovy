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

'Print message on console log'
KeywordLogger log = new KeywordLogger()

' Verify Targets page or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4205/configuration/targets') {
    System.out.println('Congiguration/Targets - page')

    WebUI.delay(3)

    //EDIT
    //To Locate Table
    WebDriver driver = DriverFactory.getWebDriver()

    WebUI.delay(5)

    'To find Size of Row'
    List rows = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-target-conf/div/div[3]/div/div/table/tbody/tr'))

    'To find Size of Column'
    List col = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-target-conf/div/div[3]/div/div/table/tbody/tr[1]/td'))

    'To Print Row Size'
    java.lang.System.out.println(rows.size())

    'To Print Column Size'
    java.lang.System.out.println(col.size())

    if (rows.size() >= 1) {
        System.out.println('Data Exists')

        'Generating Random Edit Within Row Size'
        Random rad = new Random()

        int rowscount = rad.nextInt(rows.size)

        WebUI.delay(5)

        'Click on Random Edit'
        driver.findElement(By.xpath(('html/body/app-root/app-layout/div/div/div/div/app-target-conf/div/div[3]/div/div/table/tbody/tr[' + rowscount) + ']/td[6]/a')).click()

        WebUI.delay(3)

        'Enter Target Name'
        WebUI.setText(findTestObject('Targets/Targets Name'), findTestData('Configuration/Targets').getValue(7, 1))

        'Click on update button'
        WebUI.click(findTestObject('Object Repository/Targets/update button'))

        errormessage = WebUI.getText(findTestObject('Object Repository/Targets/update button'))

        log.logInfo(errormessage)

        if (errormessage.equalsIgnoreCase('Target configuration updated successfully')) {
            WebUI.delay(5)
            'Search Edited name'
            WebUI.setText(findTestObject('Object Repository/Targets/search'), findTestData('Configuration/Targets').getValue(
                    7, 1))

            'Verify whether edited name is updated or not'
            WebUI.verifyTextPresent(findTestData('Configuration/Targets').getValue(7, 1), false, FailureHandling.OPTIONAL)
        } else {
            System.out.println('Target doesnt updated  Message: ' + errormessage)
        }
    } else {
        System.out.println('No Data to Edit')
    }
} else {
    System.out.println('Incorrect page')
}
