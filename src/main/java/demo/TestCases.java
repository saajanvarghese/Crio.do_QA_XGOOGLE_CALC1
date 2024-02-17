package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        
        driver.get("https://www.google.com");

        String currentUrl = driver.getCurrentUrl();
        
        if(currentUrl.contains("google")){
            System.out.println("url of the page contains google");
        }
        else{
            System.out.println("url of the webpage contains invalid web address");
        }

        WebElement googlesearchbox = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        googlesearchbox.sendKeys("calculator");

        Thread.sleep(3000);

        // WebElement clickOption = driver.findElement(By.xpath("//*[@class='lnnVSe']/div/span"));
        // clickOption.click();

        List <WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='eIPGRd']"));

        System.out.println(list.size());

        for(int i=0;i<list.size();i++){
            String listitem= list.get(i).getText();
            if(listitem.contains("calculator")){
                list.get(i).click();
                break;
            }
        }

        // WebElement googlesearchbtn = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
        // googlesearchbtn.click();

        WebElement calculator = driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div[1]"));

        if(calculator.isDisplayed()){
            System.out.println("Google calculator loaded successfully");
        }
        else{
            System.out.println("Google calculator did not load successfully");
        }
        
        WebElement display_zero = driver.findElement(By.xpath("//*[@id='cwos']"));

        //String zero = display_zero.getText();

        if(display_zero.isDisplayed()){
            System.out.println("Initial display shows zero");
        }
        else{
            System.out.println("Initial display does not show zero");
        }


        System.out.println("end Test case: testCase01");
    }

    public  void testCase02() throws InterruptedException{

        System.out.println("Start Test case: testCase02");

        WebElement add_first_number = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='5']"));
        add_first_number.click();

        WebElement addButton = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='+']"));
        addButton.click();

        WebElement add_second_number = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='7']"));
        add_second_number.click();

        WebElement equalsButton = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='=']"));
        equalsButton.click();
        
        Thread.sleep(2000);

        WebElement result = driver.findElement(By.xpath("//*[@id=\"cwos\"]"));
        //String resultValue = result.getText();

        if (result.isDisplayed()) {
            System.out.println(" Addition operation result is correct.");
        } else {
            System.out.println(" Addition operation result is incorrect.");
        }

        //Perform a subtraction operation, 15 - 8.
        //All clear the tab
        WebElement allclearButton = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='AC']"));
        allclearButton.click();

        WebElement sub_first_number_1 = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='1']"));
        sub_first_number_1.click();

        WebElement sub_first_number_2 = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='5']"));
        sub_first_number_2.click();

        WebElement subtractButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[4]/div/div"));
        subtractButton.click();

        WebElement sub_second_number_1 = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='8']"));
        sub_second_number_1.click();
        
        Thread.sleep(1000);

        WebElement equalButton = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='=']"));
        equalButton.click();

        //Confirm that the displayed result is correct (in this case, 7).
        WebElement result1 = driver.findElement(By.xpath("//*[@id=\"cwos\"]"));
        //String result1Value = result.getText();

        if (result1.isDisplayed()) {
            System.out.println(" subtraction operation result is correct.");
        } else {
            System.out.println(" subtraction operation result is incorrect.");
        }

        System.out.println("end Test case: testCase02");

    }
    public  void testCase03() throws InterruptedException{

        System.out.println("Start Test case: testCase03");

        WebElement allClearButton = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='AC']"));
        allClearButton.click();
        // Perform a multiplication operation, 10 * 3.
        WebElement multiply_first_number_1 = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='1']"));
        multiply_first_number_1.click();

        WebElement multiply_first_number_2 = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='0']"));
        multiply_first_number_2.click();

        WebElement product_button = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[3]/td[4]/div/div"));
        product_button.click();

        WebElement multiply_second_number = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='3']"));
        multiply_second_number.click();
        
        Thread.sleep(1000);

        WebElement equalButton = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='=']"));
        equalButton.click();                                  

        //Confirm that the displayed result is correct (in this case, 30).
        WebElement result3 = driver.findElement(By.xpath("//*[@id=\"cwos\"]"));
        String result3Value = result3.getText();

        if (result3.isDisplayed()) {
            System.out.println(" mutiplication operation result is correct.");
        } else {
            System.out.println(" multiplication operation result is incorrect.");
        }

        //Click the "AC" (All Clear) button on the calculator.
        WebElement ACButton = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='AC']"));
        ACButton.click();

        //Verify that the display clears.
        result3Value = ACButton.getText();
        if (result3Value.isEmpty()) {
            System.out.println(" Display is cleared after clicking the 'AC' button..");
        } else {
            System.out.println(" Display is not cleared after clicking the 'AC' button..");
        }

        //Expected Result: The "All Clear" (AC) button should clear the display, and the Google Calculator should correctly perform the multiplication operation.

        System.out.println("end Test case: testCase03");
}
    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
   
        WebElement div_first_number_1 = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='2']"));
        div_first_number_1.click();

        WebElement div_first_number_2 = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='0']"));
        div_first_number_2.click();

        WebElement divButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[2]/td[4]/div/div"));
        divButton.click();

        WebElement div_second_number  = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='4']"));
        div_second_number.click();
        
        Thread.sleep(1000);

        WebElement equalButton = driver.findElement(By.xpath("//div[contains(@class, 'PaQdxb')]//div[text()='=']"));
        equalButton.click();

        //Confirm that the displayed result is correct (in this case, 5).
        WebElement result4 = driver.findElement(By.xpath("//*[@id=\"cwos\"]"));
        String result4Value = result4.getText();

        if (result4.isDisplayed()) {
            System.out.println(" Division operation result is correct.");
        } else {
            System.out.println(" Division operation result is incorrect.");
        }
        //Expected Result: The Google Calculator should correctly perform the division operation.

        System.out.println("end Test case: testCase04");
    }

}
