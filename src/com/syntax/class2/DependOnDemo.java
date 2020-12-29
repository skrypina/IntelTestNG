package com.syntax.class2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependOnDemo {
    @Test(groups = "smoke")
    public void login() {
        System.out.println("I am login in");
        Assert.assertFalse(false);
    }

    @Test(dependsOnMethods = "login", groups = "smoke")//if login fails, this Test method will get ignored
    public void addEmployee() {
        System.out.println("I am adding employee");
    }

//    @Test()
//    public void test3() {
//        System.out.println("I am test 3");
//    }
}