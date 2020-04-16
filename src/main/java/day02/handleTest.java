package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class handleTest {

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
     * 通过handle方式，将driver控制权移交到浏览器的另外一个界面，只适用于当前就两个 界面
     * 多个界面，
     * 总结：仅 window  alert  iframe  会需要控制权转交，driver.switchto().xxx
     * @throws InterruptedException
     */
    @Test
    public void handleTest() throws InterruptedException {
        driver.get("");
        driver.findElement(By.linkText("aaa")).click();
        Thread.sleep(3000);
        //获取当前界面的handle
        String currentHandle = driver.getWindowHandle();
        //获取所有界面的handles
        Set<String> handleList = driver.getWindowHandles();

        //遍历handles，拿到不是当前界面的handle,通过driver.switchto().windle(handle)方法，切换到新打开的浏览器界面
        for(String handle : handleList){
            if(currentHandle.equals(handle))
                continue;
            driver.switchTo().window(handle);
        }


    }

}
