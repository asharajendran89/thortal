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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver

'Call Login Testcase'
WebUI.callTestCase(findTestCase('THORtal Login/login'), [:], FailureHandling.STOP_ON_FAILURE)

'Print message on console log'
KeywordLogger log = new KeywordLogger()

'Click Configuration'
WebUI.click(findTestObject('Configurations/Configuration'))

WebUI.delay(5)

WebUI.scrollToElement(findTestObject('Configurations/Employees'), 0)

WebUI.delay(5)

'Click Employees on Configuration'
WebUI.click(findTestObject('Configurations/Employees'))

' Verify Employee page or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4205/configuration/employees') {
    System.out.println('Congiguration/Employee - page')

    WebUI.delay(5)

    //EDIT
    //To Locate Table
    WebDriver driver = DriverFactory.getWebDriver()

    WebUI.delay(5)

    'To find Size of Row'
    List rows = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-employee-conf/div/div[3]/div/div/table/tbody/tr'))

    'To find Size of Column'
    List col = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-employee-conf/div/div[3]/div/div/table/tbody/tr[1]/td'))

    'To Print Row Size'
    java.lang.System.out.println(rows.size())

    'To Print Column Size'
    java.lang.System.out.println(col.size())

    if (WebUI.verifyTextPresent('No data available in table', false, FailureHandling.OPTIONAL)) {
        System.out.println('No data available in table')
    } else if (rows.size() == 1) {
        System.out.println('Data Exists in table')

        WebUI.click(findTestObject('Object Repository/Employees/password data one'))

        WebUI.delay(3)
		
		'Enter New Password'
		WebUI.setText(findTestObject('Employees/Confirm password'), 'thor@123')
		
		'Enter Confirm Password'
		WebUI.setText(findTestObject('Employees/Chnage password'), 'thor@123')
		
		'Click on save button'
		WebUI.click(findTestObject('Employees/Save password'))
		

        errormessage = WebUI.getText(findTestObject('Object Repository/Employees/Error password message'))

        log.logInfo(errormessage)

        if (errormessage.equalsIgnoreCase('Password updated successfully')) {
            WebUI.delay(5)

        } else {
            System.out.println('Employee doesnt added Message: ' + errormessage)
        }
    } else {
        'Generating Random Edit Within Row Size'
        Random rad = new Random()

        int rowscount = rad.nextInt(rows.size)

        WebUI.delay(5)

        'Click on Random Edit'
        driver.findElement(By.xpath(('html/body/app-root/app-layout/div/div/div/div/app-employee-conf/div/div[3]/div/div/table/tbody/tr[' + 
                rowscount) + ']/td[10]/a')).click()

        WebUI.delay(3)

        'Enter New Password'
		WebUI.setText(findTestObject('Employees/Confirm password'), 'thor@123')
		
		'Enter Confirm Password'
		WebUI.setText(findTestObject('Employees/Chnage password'), 'thor@123')
		
		'Click on save button'
		WebUI.click(findTestObject('Employees/Save password'))
		

        errormessage = WebUI.getText(findTestObject('Object Repository/Employees/Error password message'))

        log.logInfo(errormessage)

        if (errormessage.equalsIgnoreCase('Password updated successfully')) {
            WebUI.delay(5)

        } else {
            System.out.println('Employee doesnt added Message: ' + errormessage)
        }
    }
} else {
    System.out.println('Incorrect page')
}


