package com.meyoung.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowersTest {

    @BeforeTest
    public void init(){





    }


    @Test
    public void initChromeDriver(){
        //谷歌driver
        System.setProperty("WebDriver.chrome.driver","");
        WebDriver chromeDriver = new ChromeDriver();
    }

    @Test
    public void initFirFoxDriver(){
        //火狐浏览器的安装路径
        System.setProperty("WebDriver.firefox.bin","火狐的安装路径（若是Version48以下的）");
        //火狐driver的路径
        System.setProperty("WebDriver.firefox.bin","火狐driver的路径（若是火狐版本是等于或者在Version48以上的）");
        WebDriver firFoxDriver = new FirefoxDriver();
    }

    @Test
    public void initIEDriver(){
        //IE浏览器：webdriver 3.0 不支持 IE6 ，IE8
        System.setProperty("webdriver.ie.driver","IE driver路径");
        WebDriver ieDriver = new InternetExplorerDriver();
        //备注：启动IE浏览器可能会报错，selenium.remote.sessionNotFoundException:.....
        //解决方式：打开IE设置-IE选项-》安全Sheet-》四个：Internet、本地Internet、受信任站点、受限制站点下的启动保护模式保持都勾选或者都不勾选状态。

    }

    @Test
    public void initEdgeDriver(){
        //Edge浏览器仅 win10 有
        System.setProperty("webdriver.edge.driver","edge driver路径");
        WebDriver adgeDriver = new EdgeDriver();
    }


}
