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

WebUI.click(findTestObject('Configurations/Configuration'))

WebUI.scrollToElement(findTestObject('Configurations/Reference Data'), 0)

WebUI.click(findTestObject('Configurations/Reference Data'))

WebDriver driver = DriverFactory.getWebDriver()

'Generating Random Edit Within Row Size'
Random rad = new Random()

' Verify Reference Data or not'
if (WebUI.getUrl() == 'http://192.168.0.28:4205/configuration/reference_data') {
    System.out.println('Congiguration/Reference Data - page')

    WebUI.delay(5)

    WebUI.comment('Contract Type')

    'To find Size of Row'
    List rows = driver.findElements(By.xpath('.//*[@id="contractType"]/div/table/tbody/tr[1]/td'))

    'To find Size of Column'
    List col = driver.findElements(By.xpath('.//*[@id="contractType"]/div/table/tbody/tr'))

    'To Print Row Size'
    java.lang.System.out.println(rows.size())

    'To Print Column Size'
    java.lang.System.out.println(col.size())

   if(WebUI.verifyTextPresent('No data available in table', false, FailureHandling.OPTIONAL)){
		System.out.println('No data available in table')
		
	}
   else{
	   
	   System.out.println('Data Exists in table')
	   
        int rowscount = rad.nextInt(rows.size)

        WebUI.delay(5)

        'Click on Random Edit'
        driver.findElement(By.xpath(('.//*[@id="contractType"]/div/table/tbody/tr[' + rowscount) + ']/td[3]/a')).click()

        WebUI.delay(5)

        WebUI.click(findTestObject('Reference Data/Close button'))
    } 
   
    WebUI.delay(3)

    WebUI.comment('Billing Calculation')

    WebUI.click(findTestObject('Object Repository/Reference Data/Billing Calculations'))

    //EDIT
    //To Locate Table
	
	WebUI.comment('Table-Shared deals')
    WebUI.delay(5)

    'To find Size of Row'
    List rows2 = driver.findElements(By.xpath('.//*[@id="billingCalc"]/div/div[1]/div/table/tbody/tr'))

    'To find Size of Column'
    List col2 = driver.findElements(By.xpath('.//*[@id="billingCalc"]/div/div[1]/div/table/tbody/tr[1]/td'))

    'To Print Row Size'
    java.lang.System.out.println(rows2.size())

    'To Print Column Size'
    java.lang.System.out.println(col2.size())

   if(WebUI.verifyTextPresent('No data available in table', false, FailureHandling.OPTIONAL)){
		System.out.println('No data available in table')
		
	}
   else{
	   System.out.println('Data Exists in table')
	   
        int rowscount2 = rad.nextInt(rows2.size)

        WebUI.delay(5)

        'Click on Random Edit'
        driver.findElement(By.xpath(('html/body/app-root/app-layout/div/div/div/div/app-reference-conf/div/div[2]/div/div/div/div/div[2]/div/div[1]/div/table/tbody/tr['+rowscount2)+']/td[5]/a')).click()
		
		WebUI.delay(3)
		
		WebUI.click(findTestObject('Object Repository/Reference Data/Close buttton -shared deals'))
		
    } 
	
	
	
	//EDIT
	//To Locate Table
	
	WebUI.comment('Table-Solo Deals')
	WebUI.delay(5)

	'To find Size of Row'
	List rows3 = driver.findElements(By.xpath('.//*[@id="billingCalc"]/div/div[2]/div/table/tbody/tr'))

	'To find Size of Column'
	List col3= driver.findElements(By.xpath('.//*[@id="billingCalc"]/div/div[2]/div/table/tbody/tr[1]/td'))

	'To Print Row Size'
	java.lang.System.out.println(rows3.size())

	'To Print Column Size'
	java.lang.System.out.println(col3.size())

	 if(WebUI.verifyTextPresent('No data available in table', false, FailureHandling.OPTIONAL)){
		System.out.println('No data available in table')
		
	}
	 else{
		 
		 System.out.println('Data Exists in table')
		 
		int rowscount3 = rad.nextInt(rows3.size)

		WebUI.delay(5)

		'Click on Random Edit'
		driver.findElement(By.xpath(('.//*[@id="billingCalc"]/div/div[2]/div/table/tbody/tr['+rowscount3)+']/td[4]/a')).click()
		
		WebUI.delay(3)
		
		WebUI.click(findTestObject('Object Repository/Reference Data/Close button- solo deals'))
		
	} 
	 
	 
	 WebUI.comment('Sales Category')
	 
		 WebUI.click( findTestObject('Object Repository/Reference Data/sales Caetgory'))
	 
		 //EDIT
		 //To Locate Table
		 
		 WebUI.delay(5)
	 
		 'To find Size of Row'
		 List rows4 = driver.findElements(By.xpath('.//*[@id="salesCategory"]/div/table/tbody/tr'))
	 
		 'To find Size of Column'
		 List col4 = driver.findElements(By.xpath('.//*[@id="salesCategory"]/div/table/tbody/tr[1]/td'))
	 
		 'To Print Row Size'
		 java.lang.System.out.println(rows4.size())
	 
		 'To Print Column Size'
		 java.lang.System.out.println(col4.size())
	 
		if(WebUI.verifyTextPresent('No data available in table', false, FailureHandling.OPTIONAL)){
			 System.out.println('No data available in table')
			 
		 }
		else{
			System.out.println('Data Exists in table')
			
			 int rowscount4 = rad.nextInt(rows4.size)
	 
			 WebUI.delay(5)
	 
			 'Click on Random Edit'
			 driver.findElement(By.xpath(('.//*[@id="salesCategory"]/div/table/tbody/tr['+rowscount4)+']/td[3]/a')).click()
			 WebUI.delay(3)
			 
			 WebUI.click(	findTestObject('Object Repository/Reference Data/close sales'))
			 
		 }
		 
		 
		WebUI.comment('Client Category')
		
			WebUI.click( findTestObject('Object Repository/Reference Data/sales Caetgory'))
		
			//EDIT
			//To Locate Table
			
			WebUI.delay(5)
		
			'To find Size of Row'
			List rows5 = driver.findElements(By.xpath('.//*[@id="clientCategory"]/div[2]/table/tbody/tr'))
		
			'To find Size of Column'
			List col5 = driver.findElements(By.xpath('.//*[@id="clientCategory"]/div[2]/table/tbody/tr[1]/td'))
		
			'To Print Row Size'
			java.lang.System.out.println(rows5.size())
		
			'To Print Column Size'
			java.lang.System.out.println(col5.size())
		
		   if(WebUI.verifyTextPresent('No data available in table', false, FailureHandling.OPTIONAL)){
				System.out.println('No data available in table')
				
			}
		   else{
			   System.out.println('Data Exists in table')
			   
				int rowscount5 = rad.nextInt(rows5.size)
		
				WebUI.delay(5)
		
				'Click on Random Edit'
				driver.findElement(By.xpath(('.//*[@id="clientCategory"]/div[2]/table/tbody/tr['+rowscount5)+']/td[6]/a')).click()
				WebUI.delay(3)
				
				WebUI.click(	findTestObject('Object Repository/Reference Data/close sales'))
				
			}
			
		
		
	 
	
} else {
    System.out.println('Incorrect page')
}

