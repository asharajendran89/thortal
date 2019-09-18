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

    //EDIT
    //To Locate Table
    WebDriver driver = DriverFactory.getWebDriver()

    'To find Size of Row'
    List rows = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-company-events/div/div[2]/div/div/table/tbody/tr'))

    'To find Size of Column'
    List col = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-company-events/div/div[2]/div/div/table/tbody/tr[1]/td'))

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

        TitleText = WebUI.getText(findTestObject('Object Repository/Company Events/Page_Thor/tiltile field'))

        System.out.println(TitleText)

        'Click on Random Edit'
        driver.findElement(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-company-events/div/div[2]/div/div/table/tbody/tr[1]/td[6]/a[2]')).click()

        //WebUI.getText(findTestObject('Object Repository/Company Events/Page_Thor/Event Title'))
        // TitleTextview = driver.findElement(By.xpath('html/body/modal-container/div/div/form/div[2]/form-input[2]/div/input')).getAttribute('Value');
        'Verify whether edited name is updated or not'
        WebUI.verifyElementText(findTestObject('Company Events/Page_Thor/View title'), 'Automation Edited')

        //System.out.println(TitleTextview)
        /*if (TitleText == a) {
            System.out.println('Data Macthed')
        } else {
            System.out.println('Data Not Macthed')
        }*/
        WebUI.delay(3)

        WebUI.click(findTestObject('Company Events/Page_Thor/Close button'))
    } else {
        System.out.println('No Data to Edit')
    }
} else {
    System.out.println('Incorrect page')
}

