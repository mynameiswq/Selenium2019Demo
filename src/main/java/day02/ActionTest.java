package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionTest {

    WebDriver driver ;

    @BeforeMethod
    public void initChromeDriver(){
        System.setProperty("webdriver.chrome.driver","D:\\BaiduNetdiskDownload\\Selenium环境\\win64\\chromedriver_V80.0.3987.132_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

    }
    /**
     * 点击百度的新闻按钮
     */
    @Test
    public void clickNews(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("u1"));
        List<WebElement> aEles = driver.findElements(By.cssSelector("#u1>a"));
        for(WebElement element : aEles){
            System.out.println(element.getText());
        }


//        driver.findElement(By.name("tj_trnews")).click();
//        System.out.println(driver.getCurrentUrl());
//        Assert.assertEquals(driver.getCurrentUrl(),"http://news.baidu.com/");
//        if(driver.getCurrentUrl().equals("http://news.baidu.com/")){
//            System.out.println("新闻转换成功");
//        };

//        if(isExit(By.cssSelector("img[alt=\"百度新闻\"]"))){
//            System.out.println("跳转成功");
//        };

//        driver.findElement(By.cssSelector("img[alt=\"百度新闻\"]"));
//        driver.getPageSource().contains("img[alt=\"百度新闻\"]");

    }


    public  boolean isExit(By by){
        if(driver.findElement(by).isEnabled()){
            return true;
        }
        return false;
    }

    @AfterMethod
    public void quitChromeDriver(){
        driver.quit();
    }
}
