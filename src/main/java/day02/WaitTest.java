package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

/**
 * 等待方式：三种
 * 全局/隐式等待
 * 显示等待
 * 线程等待
 */
public class WaitTest {

    WebDriver driver ;
    /**
     *线程等待
     * Thread.sleep(3000)
     */
    @BeforeTest
    public void init(){
        //全局/隐式等待:临时方案
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void test(){
        //显示等待：推荐
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.id("12")));

        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.id("")));
//        new WebDriverWait(driver,30).until(ExpectedConditions.);
    }


}
