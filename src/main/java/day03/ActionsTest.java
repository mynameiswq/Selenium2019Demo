package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsTest {

    WebDriver driver;

    @BeforeMethod
    public void init(){
        System.setProperty("webdriver.chrome.driver","D:\\BaiduNetdiskDownload\\Selenium环境\\win64\\chromedriver_V80.0.3987.132_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

    }

    /**
     * 打开百度页面,在百度一下按钮上单击右击
     */
    @Test
    public void rightClikTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        //contextClick() 右键,但注意一定要perform(),不然不执行点击操作
        //若contextClick()不传参，则谷歌浏览器，直接在浏览器界面左上角单击右键，传参则在传入的webElement处右键点击
        actions.contextClick(buttonBaidu).perform();
        Thread.sleep(3000);


        //双击百度一下按钮: doubleClick(WebElement)
        //不传参则在鼠标当前位置进行双击
        actions.doubleClick(buttonBaidu).perform();
        Thread.sleep(3000);

        //移动鼠标到 某个元素上
        actions.moveToElement(driver.findElement(By.name("tj_trnews"))).perform();
        Thread.sleep(5000);

        //拖拽
        WebElement begin = driver.findElement(By.id("12"));
        WebElement end = driver.findElement(By.id("34"));


        actions.dragAndDrop(begin,end).perform();
        //将元素，拖动到哪个点上去（坐标x,y）
        actions.dragAndDropBy(begin,500,500).perform();

        //
        actions.clickAndHold(begin).moveToElement(end).release(begin);

    }


    /**
     * 注：selenim的Action类只能单独对元素进行操作，拖拽多选，
     * 但无法进行“ctrl+s”之类的操作，因为这是需要同时按中的，
     * 这时候就需要Java的Robot类
     */
    @Test
    public void moreSelect(){
        Select select = (Select) driver.findElement(By.id("selectId"));
        List<WebElement> options = select.getOptions();
        Actions actions = new Actions(driver);
        //第一个到第三个，如果要只选第1个和第3个，则换成：Keys.CONTROL,具体其他按键，可看Keys类【枚举类】
        actions.keyDown(Keys.SHIFT).click(options.get(0)).click(options.get(3)).keyUp(Keys.SHIFT).perform();
//        actions.contextClick()
    }

    /**
     * java 的RoBot类
     */
    @Test
    public void savaHtml() throws AWTException {
        Robot robot = new Robot();
        //ctrl + s :快捷键保存
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        //回车，相当于点击确定保存按钮
        robot.keyPress(KeyEvent.VK_ENTER);

        int keys = (int) new Character('A');
        //按A键
        robot.keyPress(keys);

    }

    /**
     * sendKeys() 上传操作
     */
    @Test
    public void uploadTest(){
        driver.get("");
        //上传组件是Input，所以可以sendKeys()方式直接设置值
        driver.findElement(By.id("上传组件ID")).sendKeys("要上传的文件路径");
        //确定上传还需自己写
    }


    @AfterMethod
    public void after(){
        driver.quit();
    }

}
