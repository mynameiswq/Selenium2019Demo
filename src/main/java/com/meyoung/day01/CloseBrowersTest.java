package com.meyoung.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CloseBrowersTest {

    /**
     * 仅执行一次。
     * @throws InterruptedException
     */
    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver","D:\\BaiduNetdiskDownload\\Selenium环境\\win64\\chromedriver_V80.0.3987.132_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void initChromeDriver() throws InterruptedException {
        //谷歌driver
        System.setProperty("webdriver.chrome.driver","D:\\BaiduNetdiskDownload\\Selenium环境\\win64\\chromedriver_V80.0.3987.132_win32\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();

        //实例化Dimesion 设置浏览器窗口大小
//        Dimension dimesion = new Dimension(500,500);
//        chromeDriver.manage().window().setSize(dimesion);

        chromeDriver.get("http://www.baidu.com");
        //设置浏览器最大化
        chromeDriver.manage().window().maximize();
        //同get方法
//        chromeDriver.navigate().to("http://www.baidu.com");
        Thread.sleep(3000);
        //后退
        chromeDriver.navigate().back();
        Thread.sleep(3000);
        //前进
        chromeDriver.navigate().forward();
        //刷新当前界面b
        chromeDriver.navigate().refresh();
        //关闭当前页面
        chromeDriver.close();
        //关闭driver
        chromeDriver.quit();


        Assert.assertEquals(chromeDriver.getCurrentUrl(),"");
    }



}
