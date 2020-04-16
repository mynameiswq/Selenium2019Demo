package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectTest {

    WebDriver driver ;

    @BeforeMethod
    public void initChromeDriver(){
        System.setProperty("webdriver.chrome.driver","D:\\BaiduNetdiskDownload\\Selenium环境\\win64\\chromedriver_V80.0.3987.132_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void quitChromeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    /**
     * 三种处理方式：
     * selectByIndex()
     * selectByValue()
     * selectByName()
     */
    @Test
    public void selectTest(){
        driver.get("");
        WebElement ele = driver.findElement(By.id(""));
        //实例化select对象
        Select select = new Select(ele);
        //通过 索引选择下拉框
        select.selectByIndex(2);
        //通过 属性Value值来选择下拉框
        select.selectByValue("");
        //文本值来选择下拉框（注意有的文本中有末尾或开头或中间的空格）
        select.selectByVisibleText("");

    }


}
