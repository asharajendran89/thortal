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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.Keys as Keys

WebUI.comment('Performance Targets')

'Calling Login Test case'
WebUI.callTestCase(findTestCase('THORtal Login/login'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on Configuration button'
WebUI.click(findTestObject('Configurations/Configuration'))

WebUI.delay(5)

'Scroll upto Performance target button'
WebUI.scrollToElement(findTestObject('PerformanceTargets/Page_Thor/performance targets button'), 0)

'Click on Performance target'
WebUI.click(findTestObject('PerformanceTargets/Page_Thor/performance targets button'))

WebDriver driver = DriverFactory.getWebDriver()

'Generating Random Edit Within Row Size'
Random rad = new Random()

'Perform keyboard actions'
Robot rb = new Robot()

'Print message on console log'
KeywordLogger log = new KeywordLogger()

' Verify Reference Data or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4205/configuration/performance_target') {
    System.out.println('Congiguration/Performance Targets - page')

    WebUI.delay(5)

    WebUI.comment('Individual')

    WebUI.setText(findTestObject('Object Repository/PerformanceTargets/Page_Thor/search-individual'), findTestData('Performance targets').getValue(
            5, 1))

    'To find Size of Row'
    List rows = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-performance-target/div/div[3]/div/div[1]/div/table/tbody/tr'))

    'To find Size of Column'
    List col = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-performance-target/div/div[3]/div/div[1]/div/table/tbody/tr[1]/td'))

    'To Print Row Size'
    java.lang.System.out.println(rows.size())

    'To Print Column Size'
    java.lang.System.out.println(col.size())

    
	if(WebUI.verifyTextPresent('No data available in table', false, FailureHandling.OPTIONAL)){
		System.out.println('No data available in table')
		
	}
	
	else if(rows.size() == 1) {
		
		System.out.println('Data Exists in table')
		
		WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Data one'))
		WebUI.delay(3)
		
		//WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/close individual'))
		'Select Target Metric'
		String Target = 'Deal Count'

		WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Traget Metric dropdown'))

		if (Target.equals('GP Written-Up')) {
			WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/First dd'))
		} else {
			WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Second dd'))
		}
		
		WebUI.setText(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Month'), findTestData('Performance targets').getValue(
				4, 1))

		WebUI.setText(findTestObject('PerformanceTargets/Page_Thor/Quater'), findTestData('Performance targets').getValue(
				2, 1))

		WebUI.setText(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Anual'), findTestData('Performance targets').getValue(
				3, 1))

		'Check  Status'
		WebUI.sendKeys(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Anual'), Keys.chord(Keys.TAB))

		rb.keyPress(KeyEvent.VK_SPACE)

		rb.keyRelease(KeyEvent.VK_SPACE)

		WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/update button- individual'))

		errormessage = WebUI.getText(findTestObject('Object Repository/PerformanceTargets/Page_Thor/error message'))

		log.logInfo(errormessage)

		if (errormessage.equalsIgnoreCase('Target configuration updated successfully')) {
			WebUI.delay(5)
		} else {
			System.out.println('Client doesnt added Message: ' + errormessage)
		}
		
		
	}
	else{
		
		System.out.println('Data exists in table')
		
        int rowscount = rad.nextInt(rows.size)

        WebUI.delay(5)
		

        'Click on Random Edit'
        driver.findElement(By.xpath(('html/body/app-root/app-layout/div/div/div/div/app-performance-target/div/div[3]/div/div[1]/div/table/tbody/tr[' + 
                rowscount) + ']/td[10]/a')).click()

        WebUI.delay(5)

        //WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/close individual'))
        'Select Target Metric'
        String Target = 'Deal Count'

        WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Traget Metric dropdown'))

        if (Target.equals('GP Written-Up')) {
            WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/First dd'))
        } else {
            WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Second dd'))
        }
        
        WebUI.setText(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Month'), findTestData('Performance targets').getValue(
                4, 1))

        WebUI.setText(findTestObject('PerformanceTargets/Page_Thor/Quater'), findTestData('Performance targets').getValue(
                2, 1))

        WebUI.setText(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Anual'), findTestData('Performance targets').getValue(
                3, 1))

        'Check  Status'
        WebUI.sendKeys(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Anual'), Keys.chord(Keys.TAB))

        rb.keyPress(KeyEvent.VK_SPACE)

        rb.keyRelease(KeyEvent.VK_SPACE)

        WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/update button- individual'))

        errormessage = WebUI.getText(findTestObject('Object Repository/PerformanceTargets/Page_Thor/error message'))

        log.logInfo(errormessage)

        if (errormessage.equalsIgnoreCase('Target configuration updated successfully')) {
            WebUI.delay(5)
        } else {
            System.out.println('Client doesnt added Message: ' + errormessage)
        }
    } 
    
    WebUI.delay(3)

    WebUI.comment('Team')

    WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Team button'))

    'To find Size of Row'
    List rows2 = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-performance-target/div/div[3]/div/div[2]/div/table/tbody/tr'))

    'To find Size of Column'
    List col2 = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-performance-target/div/div[3]/div/div[2]/div/table/tbody/tr[1]/td'))

    'To Print Row Size'
    java.lang.System.out.println(rows2.size())

    'To Print Column Size'
    java.lang.System.out.println(col2.size())

	if(WebUI.verifyTextPresent('No data available in table', false, FailureHandling.OPTIONAL)){
		System.out.println('No data available in table')
	}
	else if(rows2.size() == 1) {
		
		System.out.println('Data Exists in table')
		
		WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Data one -Team'))
		WebUI.delay(3)
		
		WebUI.setText(findTestObject('Object Repository/PerformanceTargets/Page_Thor/month-team'), findTestData('Performance targets').getValue(
				4, 1))

		WebUI.setText(findTestObject('PerformanceTargets/Page_Thor/Quater -team'), findTestData('Performance targets').getValue(
				2, 1))

		WebUI.setText(findTestObject('PerformanceTargets/Page_Thor/Anual-team'), findTestData('Performance targets').getValue(
				3, 1))

		'Check  Status'
		WebUI.sendKeys(findTestObject('PerformanceTargets/Page_Thor/Anual-team'), Keys.chord(Keys.TAB))

		rb.keyPress(KeyEvent.VK_SPACE)

		rb.keyRelease(KeyEvent.VK_SPACE)

		WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/update - team'))

		errormessage = WebUI.getText(findTestObject('Object Repository/PerformanceTargets/Page_Thor/error message- team'))

		log.logInfo(errormessage)

		if (errormessage.equalsIgnoreCase('Target configuration updated successfully')) {
			WebUI.delay(5) //WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/close button- Team'))
		} else {
			System.out.println('Client doesnt added Message: ' + errormessage)
		}
	}
	else{
		System.out.println('Data exists in table')
		
        int rowscount2 = rad.nextInt(rows2.size)

        WebUI.delay(5)

        'Click on Random Edit'
        driver.findElement(By.xpath(('html/body/app-root/app-layout/div/div/div/div/app-performance-target/div/div[3]/div/div[2]/div/table/tbody/tr[' + 
                rowscount2) + ']/td[8]/a')).click()

        WebUI.delay(5)

        WebUI.setText(findTestObject('Object Repository/PerformanceTargets/Page_Thor/month-team'), findTestData('Performance targets').getValue(
                4, 1))

        WebUI.setText(findTestObject('PerformanceTargets/Page_Thor/Quater -team'), findTestData('Performance targets').getValue(
                2, 1))

        WebUI.setText(findTestObject('PerformanceTargets/Page_Thor/Anual-team'), findTestData('Performance targets').getValue(
                3, 1))

        'Check  Status'
        WebUI.sendKeys(findTestObject('PerformanceTargets/Page_Thor/Anual-team'), Keys.chord(Keys.TAB))

        rb.keyPress(KeyEvent.VK_SPACE)

        rb.keyRelease(KeyEvent.VK_SPACE)

        WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/update - team'))

        errormessage = WebUI.getText(findTestObject('Object Repository/PerformanceTargets/Page_Thor/error message- team'))

        log.logInfo(errormessage)

        if (errormessage.equalsIgnoreCase('Target configuration updated successfully')) {
            WebUI.delay(5) //WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/close button- Team'))
        } else {
            System.out.println('Client doesnt added Message: ' + errormessage)
        }
    } 
    
    WebUI.delay(3)

    WebUI.comment('Brand')

    WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Brand button'))

    'To find Size of Row'
    List rows3 = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-performance-target/div/div[3]/div/div[3]/div/table/tbody/tr[1]/td'))

    'To find Size of Column'
    List col3 = driver.findElements(By.xpath('html/body/app-root/app-layout/div/div/div/div/app-performance-target/div/div[3]/div/div[3]/div/table/tbody/tr'))

    'To Print Row Size'
    java.lang.System.out.println(rows3.size())

    'To Print Column Size'
    java.lang.System.out.println(col3.size())
	
    if(WebUI.verifyTextPresent('No data available in table', false, FailureHandling.OPTIONAL)){
		System.out.println('No data available in table')
		
	}
	
	else if(rows3.size() == 1) {
		
		System.out.println('Data Exists in table')
		WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Data one- brand'))
		WebUI.delay(3)
		findTestObject('Object Repository/PerformanceTargets/Page_Thor/Annuak-Brand')
		
				WebUI.setText(findTestObject('PerformanceTargets/Page_Thor/Month-Brand'), findTestData('Performance targets').getValue(
						4, 1))
		
				WebUI.setText(findTestObject('PerformanceTargets/Page_Thor/Quarter-Brand'), findTestData('Performance targets').getValue(
						2, 1))
		
				WebUI.setText(findTestObject('PerformanceTargets/Page_Thor/Annuak-Brand'), findTestData('Performance targets').getValue(
						3, 1))
		
				'Check  Status'
				WebUI.sendKeys(findTestObject('PerformanceTargets/Page_Thor/Annuak-Brand'), Keys.chord(Keys.TAB))
		
				rb.keyPress(KeyEvent.VK_SPACE)
		
				rb.keyRelease(KeyEvent.VK_SPACE)
		
				WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Update Button- brans'))
		
				errormessage = WebUI.getText(findTestObject('Object Repository/PerformanceTargets/Page_Thor/error -brand'))
		
				log.logInfo(errormessage)
				if (errormessage.equalsIgnoreCase('Target configuration updated successfully')) {
					WebUI.delay(5) // WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/close button-Brand'))
				} else {
					System.out.println('Client doesnt added Message: ' + errormessage)
				}
	}
	else{

        int rowscount3 = rad.nextInt(rows3.size)

        WebUI.delay(5)

        'Click on Random Edit'
        driver.findElement(By.xpath(('html/body/app-root/app-layout/div/div/div/div/app-performance-target/div/div[3]/div/div[3]/div/table/tbody/tr[' + 
                rowscount3) + ']/td[7]/a')).click()

        WebUI.delay(3)

        findTestObject('Object Repository/PerformanceTargets/Page_Thor/Annuak-Brand')

        WebUI.setText(findTestObject('PerformanceTargets/Page_Thor/Month-Brand'), findTestData('Performance targets').getValue(
                4, 1))

        WebUI.setText(findTestObject('PerformanceTargets/Page_Thor/Quarter-Brand'), findTestData('Performance targets').getValue(
                2, 1))

        WebUI.setText(findTestObject('PerformanceTargets/Page_Thor/Annuak-Brand'), findTestData('Performance targets').getValue(
                3, 1))

        'Check  Status'
        WebUI.sendKeys(findTestObject('PerformanceTargets/Page_Thor/Annuak-Brand'), Keys.chord(Keys.TAB))

        rb.keyPress(KeyEvent.VK_SPACE)

        rb.keyRelease(KeyEvent.VK_SPACE)

        WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/Update Button- brans'))

        errormessage = WebUI.getText(findTestObject('Object Repository/PerformanceTargets/Page_Thor/error -brand'))

        log.logInfo(errormessage)
        if (errormessage.equalsIgnoreCase('Target configuration updated successfully')) {
            WebUI.delay(5) // WebUI.click(findTestObject('Object Repository/PerformanceTargets/Page_Thor/close button-Brand'))
        } else {
            System.out.println('Client doesnt added Message: ' + errormessage)
        }
    } 
    
    WebUI.delay(3)
} else {
    System.out.println('Incorrect page')
}

