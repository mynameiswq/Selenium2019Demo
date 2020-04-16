package day02;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test02 {

    WebDriver driver ;

    @BeforeMethod
    public void initChromeDriver(){
        System.setProperty("webdriver.chrome.driver","D:\\BaiduNetdiskDownload\\Selenium环境\\win64\\chromedriver_V80.0.3987.132_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

    }

    @Test
    public void getTagNameTest(){
        driver.get("http://www.baidu.com");
        String tagName = driver.findElement(By.id("kw")).getTagName();
        //不推荐通过java的equals方法去比较，因为哪怕不相等，整个代码跑完了，也是绿色的，不会报红
        Assert.assertEquals(tagName,"input");
    }

    /**
     * 获取某个tagname的其中的某一个属性值,BY.getAttribute()
     */
    @Test
    public void getAtrribute(){
        driver.get("http://www.baidu.com");
        String valueText = driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(valueText,"百度一下");
    }

    /**
     * driver.getTitle()
     * 获取当前界面页签名
     */
    @Test
    public void getTitle(){
        driver.get("http://www.baidu.com");
        String title = driver.getTitle();
        Assert.assertEquals(title,"百度一下，你就知道");
    }


    /**
     * 判断一个元素是否展示：isDisplayed() - boolean
     * 即一个元素是否在界面展示出来了
     */
    @Test
    public void isDisplayed(){
        driver.get("http://www.baidu.com");
        boolean b = driver.findElement(By.id("su")).isDisplayed();
//        Assert.assertEquals(b,true);
        Assert.assertTrue(b);
    }

    /**
     * isSelected  判断选择框是否被选中
     */
    @Test
    public void isSelected(){
        //radio
        //checkBox
        boolean b = driver.findElement(By.id("checkbox")).isSelected();
    }

    /**
     * 判断元素是否被激活   isEnabled()
     * 判断submit按钮 处于未激活状态
     */
    @Test
    public void isEnableTest(){
        //是否处于可点击状态
        boolean b = driver.findElement(By.id("submit")).isEnabled();
        Assert.assertFalse(b);
    }


    /**
     * 截图百度首页
     */
    @Test
    public void shotTest() {
        driver.get("http://www.baidu.com");
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\test1.jpg"));
            System.out.println("123");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void quitChromeDriver(){
        driver.quit();
    }





}
