package day03;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JsTest {


    WebDriver driver;

    @BeforeMethod
    public void init(){
        System.setProperty("webdriver.chrome.driver","D:\\BaiduNetdiskDownload\\Selenium环境\\win64\\chromedriver_V80.0.3987.132_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

    }

    @Test
    public void exJS() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //document.getElementById("kw").setAttribute("","");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"123\");");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }


}
