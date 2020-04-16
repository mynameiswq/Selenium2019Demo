package day04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * TestNG数据驱动 通过注解：dataprovider
 */
public class DataProviderTest{

    public static String a;
    public static int b;


    @DataProvider(name = "loginUser")
    public Object[][] data1(){
        int c;
        a = "1";
        //有几组数据。引用该数据源的方法就运行几次
        return new Object[][]{
                {"user1","pwd1"},
                {"user2","pwd2"}
        };
    }

    @DataProvider(name = "drivers")
    public Object[][] driver(){
        //读取excel  csv db xml文件
        return new Object[][]{
                {"chrome","http://192.168.1.105:4445"},
                {"firefox",""},
                {"ie",""}
        };

    }

    @Test(dataProvider = "loginUser")
    public void loginTest(String userName,String pwd){
        System.out.println("user:" + userName);
        System.out.println("pwd：" + pwd);

    }

    @Test(dataProvider = "drivers")
    public void driverTest(){

    }


}

