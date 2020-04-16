package com.meyoung.day01;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.remote.strprotocol.IMessage;

public class TestNGDemo02 {

    /**
     * Assert一旦失败，那么他存在的那个单个的case就不执行了，但是其他的case依旧继续执行，相当于 continue
     */

    @Test
   public void assertEqualsTest(){
        //校验 a == 6
        String a ="as";
        String b = "assdf";
//        if(a == b){
//            System.out.println("true");
//        }else{
//            System.out.println("false");
//        }
//        Assert.assertEquals(a,b);
        Assert.assertEquals("false",a,b);
    }

   @Test
    public void assertNotEquals(){
        int a = 1;
        int b = 2;
//        Assert.assertNotEquals(a,b);
        //message只有在验证相反的结果下才会 打印
        Assert.assertNotEquals(a,b,"其实相等");
    }


   @Test
   public void assertNull(){
        String a = null;
        Assert.assertNull(a,"不为空");
        System.out.println("1");
   }

    @Test
    public void assertNotNull(){
        String a = null;
        Assert.assertNotNull(a,"为空");
        System.out.println("2");

    }

    @Test
    public void assertFalse(){
        boolean b = true;
        Assert.assertFalse(b,"不是false");
//        Assert.assertf
        System.out.println("3");

    }


}
