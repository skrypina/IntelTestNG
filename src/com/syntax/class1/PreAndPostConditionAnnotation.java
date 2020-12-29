package com.syntax.class1;

import org.testng.annotations.*;

public class PreAndPostConditionAnnotation {

    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class annotation");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am after class method");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }

    @Test
    public void testMethod(){
        System.out.println("I am a test method");
    }

    @Test
    public void testMethod2(){
        System.out.println("I am a second test method");
    }

    @Test
    public void testMethod3(){
        System.out.println("I am a third test method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }

}