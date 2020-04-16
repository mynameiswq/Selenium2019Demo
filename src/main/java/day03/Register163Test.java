package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Register163Test {

    WebDriver driver ;
    @BeforeMethod
    public void init(){
        System.setProperty("webdriver.chrome.driver","D:\\BaiduNetdiskDownload\\Selenium环境\\win64\\chromedriver_V80.0.3987.132_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    }

    @Test
    public void regist(){
        driver.get("https://mail.163.com/");
        driver.findElement(By.linkText("注册新帐号")).click();
        //获取当前界面的handler
        String currentHanlder = driver.getWindowHandle();
        //获取所有的handler，进行driver的控制权转交
        for(String handler:driver.getWindowHandles()){
            if(currentHanlder.equals(handler)){
                continue;
            }
            driver.switchTo().window(handler);
        };
        driver.findElement(By.id("username")).sendKeys("wq123test");
        driver.findElement(By.id("password")).sendKeys("testpw");
        System.currentTimeMillis();
        driver.findElement(By.id("phone")).sendKeys("15072814358");
        driver.findElement(By.id("service")).click();
        driver.findElement(By.linkText("立即注册")).click();
        //验证码
        //1、找开发要万能验证码
        //2、把验证码功能干掉

    }

    @Test
    public  void testcase01(){
        //时间戳：1970年零点到现在为止的秒数
        //1585920047044:13位，这样可以利用时间戳当做参数传给 邮箱名，保证不重复邮箱名。
        //同样手机号码也可这样，手机号是11位，可以截取,最好是 通过  “/”除号，time/100 -》取整数部分，保留了前 11位
        long time = System.currentTimeMillis();
        System.out.println(time);
        String num = String.valueOf(time);
    }



    @AfterMethod
    public void quit(){
    ////*[@id="_mail_component_15_15"]
    }

}
