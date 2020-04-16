package com.meyoung.day01;

import org.junit.Rule;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo {

    @BeforeMethod
    public void beforeMethod(){
        System.out.print("beforeMethod run");
    }
    @BeforeTest
    public void testCaseBefore(){
        System.out.print("beforetest run");
    }
    @Test
    public void testCase01(){
        System.out.print("test01 run");
    }
    @Test
    public void testCase02(){
        System.out.print("test02 run");
    }

    @AfterTest
    public void afterTest(){
        System.out.print("aftertest run");
    }

}
