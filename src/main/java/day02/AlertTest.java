package day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * js 弹框
 * Alert : alert-仅确定按钮
 *         confirm：有确定和取消
 *         prompt：有确定和取消，并且有输入框可输入值
 */
public class AlertTest {

    WebDriver driver;

    @BeforeMethod
    public void initChromeDriver(){
        System.setProperty("webdriver.chrome.driver","D:\\BaiduNetdiskDownload\\Selenium环境\\win64\\chromedriver_V80.0.3987.132_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

    }

    /**
     * alert() 方法用于显示带有一条指定消息和一个 确认 按钮的警告框。
     * @throws InterruptedException
     */
    @Test
    public void alertTest() throws InterruptedException {
        driver.get("https://www.runoob.com/try/try.php?filename=tryjs_alert");
        //如果有Iframe 先切换到Iframe去，在继续定位
        //将控制权交给Iframe/frame
        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
       // driver.switchTo().frame("");//要么是name 要么是 id
        driver.findElement(By.cssSelector("body > input[type=button]")).click();
        //上一步操作后，js弹窗弹出，弹出的弹窗无法用鼠标进行定位，这时候就可判断是Alert
        //driver将控制权转交给Alert弹框
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        //点击Alert中的 确定 按钮
        //获取弹框中的文字
        alert.getText();
        alert.accept();
        //driver 控制权转交给原来的界面
        driver.switchTo().defaultContent();
    }

    /**
     * Confirm : 有确定和取消 两个按钮
     * confirm()方法用于显示一个带有指定消息和确认及取消按钮的对话框。
     * 如果访问者点击"确定"，此方法返回true，否则返回false。
     */
    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("https://www.runoob.com/try/try.php?filename=tryjs_confirm");
        //将控制权转交给frame - WebDriver
        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
        driver.findElement(By.cssSelector("body > button")).click();
        Alert alert=   driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
        System.out.println("2323");
        driver.switchTo().defaultContent();
//        driver.findElement(By.cssSelector("body > div.container > div > div:nth-child(2) > div > div.panel-heading > form > button"));

    }

    /**
     * prompt()方法用于显示可提示用户进行输入的对话框。
     * 这个方法返回用户输入的字符串。
     */
    @Test
    public void promptTest() throws InterruptedException {
        driver.get("https://www.runoob.com/try/try.php?filename=tryjs_prompt");
        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
        driver.findElement(By.cssSelector("body > button")).click();
        Alert prompt = driver.switchTo().alert();
        Thread.sleep(2000);
        prompt.sendKeys("wangqian nihaoya");
        prompt.accept();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.id("demo")).getText(),"你好 wangqian nihaoya! 今天感觉如何?");
    }


    @AfterMethod
    public void quitChromeDriver(){
        driver.quit();
    }
}
